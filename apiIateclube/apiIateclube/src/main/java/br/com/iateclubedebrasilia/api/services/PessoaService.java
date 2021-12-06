package br.com.iateclubedebrasilia.api.services;

import br.com.iateclubedebrasilia.api.converter.DozerConverter;
import br.com.iateclubedebrasilia.api.domain.*;
import br.com.iateclubedebrasilia.api.dto.*;
import br.com.iateclubedebrasilia.api.repositories.PessoaRepository;
import br.com.iateclubedebrasilia.api.services.exceptions.ValidationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    private PessoaFisicaService pessoaFisicaService;

    private PessoaJuridicaService pessoaJuridicaService;

    private ContatoPessoaService contatoPessoaService;

    private EnderecoPessoaService enderecoPessoaService;

    public PessoaService(PessoaRepository pessoaRepository,
                         PessoaFisicaService pessoaFisicaService,
                         PessoaJuridicaService pessoaJuridicaService,
                         ContatoPessoaService contatoPessoaService,
                         EnderecoPessoaService enderecoPessoaService) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaFisicaService = pessoaFisicaService;
        this.pessoaJuridicaService = pessoaJuridicaService;
        this.contatoPessoaService = contatoPessoaService;
        this.enderecoPessoaService = enderecoPessoaService;
    }

    public Pessoa salvar(PessoaDTO pessoaDTO) {
        var entity = DozerConverter.parseObject(pessoaDTO, Pessoa.class);

        Pessoa pessoa = pessoaRepository.findById(UserService.authenticated().getId()).orElse(null);

        if (pessoa == null) {
            entity.setIden(UserService.authenticated().getId());
        }

        /*if (entity.getPesIden() != null) {
            Pessoa pessoa = pessoaRepository.findById(entity.getPesIden()).get();
            if (pessoa.getContatosPessoa().size() > 0) {
            *//*for (ContatoPessoa cont : pessoa.getContatosPessoa()) {
                pessoa.getContatosPessoa().remove(cont);
            }*//*
                pessoa.getContatosPessoa().clear();
                pessoaRepository.save(pessoa);
            }
        }*/

        entity.setUsuario(UserService.authenticated().getId());

        if (pessoaDTO.getPessoaFisica() != null) {
            var pfi = DozerConverter.parseObject(pessoaDTO.getPessoaFisica(), PessoaFisica.class);
            if (pfi.getCpf() == "") {
                pfi.setCpf("03887200187");
            }
            pfi.setPessoa(entity);
            pfi.setStatus(true);
            pfi.setDtaHora(LocalDateTime.now());
            pfi.setUsuario(entity.getUsuario());

            pfi.setIden(entity.getIden());

            entity.setPessoasFisicas(Arrays.asList(pfi));
        }
        if (pessoaDTO.getPessoaJuridica() != null) {
            var pju = DozerConverter.parseObject(pessoaDTO.getPessoaJuridica(), PessoaJuridica.class);
            pju.setPessoa(entity);
            pju.setStatus(true);
            pju.setIndFornecedor(false);
            pju.setDtaHora(LocalDateTime.now());
            pju.setUsuario(entity.getUsuario());

            entity.setPessoasJuridicas(Arrays.asList(pju));
        }

        if (pessoaDTO.getContatosPessoa() != null) {
            List<ContatoPessoa> listaContatos = new ArrayList<>();

            entity.getContatosPessoa().clear();

            pessoaDTO.getContatosPessoa().stream().forEach(x -> {
                ContatoPessoa contato = ContatoPessoa.builder()
                        .pessoa(entity)
                        .principal(x.getPrincipal() ? x.getPrincipal() : false)
                        .tipo(x.getTipo())
                        .contato(x.getContato())
                        .observacao(x.getObservacao())
                        .dtaIni(LocalDate.now())
                        .status(true)
                        .dtaHora(LocalDateTime.now())
                        .usuario(entity.getUsuario())
                        .build();
                listaContatos.add(contato);
            });
            //entity.setContatosPessoa(listaContatos);
            entity.getContatosPessoa().addAll(listaContatos);
        }

        if (pessoaDTO.getEnderecoPessoa() != null) {
            var end = DozerConverter.parseObject(pessoaDTO.getEnderecoPessoa(), EnderecoPessoa.class);
            end.setPessoa(entity);
            end.setDtaHora(LocalDateTime.now());
            end.setUsuario(entity.getUsuario());
            end.setStatus(true);

            entity.setEnderecosPessoa(Arrays.asList(end));
        }


        entity.setDtaHora(LocalDateTime.now());
        entity.setStatus(true);


        Pessoa pessoaSalva = null;
        try {
            pessoaSalva = pessoaRepository.save(entity);
        } catch (ConstraintViolationException e) {
            if (e.getMessage().contains("CPF")) {
                throw new ValidationException("Erro ao salvar sócio, CPF inválido!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pessoaSalva;


    }

    public PessoaDTO buscarPorId(Integer id) {

        Pessoa pessoa = Optional
                .ofNullable(id)
                .map(idConsultado -> pessoaRepository.findById(id).orElse(null))
                .orElseThrow(() -> new ValidationException("Usuário sem cadastro!"));


        PessoaFisica pessoaFisica = pessoaFisicaService.procurarPorPessoa(pessoa);
        PessoaJuridica pessoaJuridica = pessoaJuridicaService.procurarPorPessoa(pessoa);
        List<ContatoPessoa> contatosPessoas = contatoPessoaService.procurarPorPessoa(pessoa);
        EnderecoPessoa enderecoPessoa = enderecoPessoaService.procurarPorPessoa(pessoa);

        List<ContatoPessoaDTO> contatos = new ArrayList<>();
        if (contatosPessoas.size() != 0) {
            for (ContatoPessoa cont : contatosPessoas) {
                ContatoPessoaDTO contatoPessoaDTO = DozerConverter.parseObject(cont, ContatoPessoaDTO.class);
                contatos.add(contatoPessoaDTO);
            }

        }


        return PessoaDTO.builder()
                .nomeSoc(pessoa.getNomeSoc())
                .nomeReg(pessoa.getNomeReg())
                .iden(pessoa.getIden())
                .pessoaFisica(pessoaFisica != null ? DozerConverter
                        .parseObject(pessoaFisica, PessoaFisicaDTO.class) : null)
                .pessoaJuridica(pessoaJuridica != null ? DozerConverter
                        .parseObject(pessoaJuridica, PessoaJuridicaDTO.class) : null)
                .contatosPessoa(contatosPessoas.size() != 0 ? contatos : null)
                .enderecoPessoa(enderecoPessoa != null ? DozerConverter
                        .parseObject(enderecoPessoa, EnderecoPessoaDTO.class) : null)
                .build();
    }

    public List<Pessoa> listar() {
        return null;
    }

    public Pessoa salvar(Pessoa entity) {
        return null;
    }

    public Pessoa procurarPorIden(Integer id) {
        return null;
    }

    public void remover(Pessoa entity) {

    }

    public void removerPorIden(Integer id) {

    }
}

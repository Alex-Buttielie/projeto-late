package br.com.iateclubedebrasilia.api.services;

import br.com.iateclubedebrasilia.api.domain.Pessoa;
import br.com.iateclubedebrasilia.api.domain.PessoaJuridica;
import br.com.iateclubedebrasilia.api.repositories.PessoaJuridicaRepository;
import br.com.iateclubedebrasilia.api.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaJuridicaService {

    private PessoaJuridicaRepository pessoaJuridicaRepository;

    public PessoaJuridicaService(PessoaJuridicaRepository pessoaJuridicaRepository) {
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
    }


    public List<PessoaJuridica> listar() {
        return pessoaJuridicaRepository.findAll();
    }


    public PessoaJuridica salvar(PessoaJuridica entity) {
        return pessoaJuridicaRepository.save(entity);
    }


    public PessoaJuridica procurarPorIden(Integer id) {
        Optional<PessoaJuridica> pessoaJuridica = pessoaJuridicaRepository.findById(id);
        return pessoaJuridica.orElseThrow(() -> new ObjectNotFoundException("Pessoa Jurídica não encontrada!"));
    }

    public void remover(PessoaJuridica entity) {
        pessoaJuridicaRepository.delete(entity);
    }

    public void removerPorIden(Integer id) {
        pessoaJuridicaRepository.deleteById(id);
    }


    public PessoaJuridica procurarPorPessoa(Pessoa pessoa) {
        return pessoaJuridicaRepository.findByPessoa(pessoa);
    }
}

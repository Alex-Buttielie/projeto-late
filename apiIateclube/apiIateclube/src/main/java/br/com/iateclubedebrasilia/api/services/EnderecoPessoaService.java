package br.com.iateclubedebrasilia.api.services;

import br.com.iateclubedebrasilia.api.domain.EnderecoPessoa;
import br.com.iateclubedebrasilia.api.domain.Pessoa;
import br.com.iateclubedebrasilia.api.repositories.EnderecoPessoaRepository;
import br.com.iateclubedebrasilia.api.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoPessoaService {

    private EnderecoPessoaRepository enderecoPessoaRepository;

    public EnderecoPessoaService(EnderecoPessoaRepository enderecoPessoaRepository) {
        this.enderecoPessoaRepository = enderecoPessoaRepository;
    }

    public List<EnderecoPessoa> listar() {
        return enderecoPessoaRepository.findAll();
    }

    public EnderecoPessoa salvar(EnderecoPessoa entity) {
        return enderecoPessoaRepository.save(entity);
    }

    public EnderecoPessoa procurarPorIden(Integer id) {
        Optional<EnderecoPessoa> enderecoPessoa = enderecoPessoaRepository.findById(id);
        return enderecoPessoa.orElseThrow(() -> new ObjectNotFoundException("Endereço não encontrado!"));
    }

    public void remover(EnderecoPessoa entity) {
        enderecoPessoaRepository.delete(entity);
    }

    public void removerPorIden(Integer id) {
        enderecoPessoaRepository.deleteById(id);
    }

    public EnderecoPessoa procurarPorPessoa(Pessoa pessoa) {
        return enderecoPessoaRepository.findByPessoa(pessoa);
    }
}

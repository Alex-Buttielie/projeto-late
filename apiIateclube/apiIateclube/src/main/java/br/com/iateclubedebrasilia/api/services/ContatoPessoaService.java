package br.com.iateclubedebrasilia.api.services;

import br.com.iateclubedebrasilia.api.domain.ContatoPessoa;
import br.com.iateclubedebrasilia.api.domain.Pessoa;
import br.com.iateclubedebrasilia.api.repositories.ContatoPessoaRepository;
import br.com.iateclubedebrasilia.api.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContatoPessoaService {

    private ContatoPessoaRepository contatoPessoaRepository;

    public ContatoPessoaService(ContatoPessoaRepository contatoPessoaRepository) {
        this.contatoPessoaRepository = contatoPessoaRepository;
    }

    public List<ContatoPessoa> listar() {
        return contatoPessoaRepository.findAll();
    }

    public ContatoPessoa salvar(ContatoPessoa entity) {
        return contatoPessoaRepository.save(entity);
    }

    public ContatoPessoa procurarPorIden(Integer id) {
        Optional<ContatoPessoa> contatoPessoa = contatoPessoaRepository.findById(id);
        return contatoPessoa.orElseThrow(() -> new ObjectNotFoundException("Contato não encontrado!"));
    }

    public void remover(ContatoPessoa entity) {
        contatoPessoaRepository.delete(entity);
    }

    public void removerPorIden(Integer id) {
        contatoPessoaRepository.deleteById(id);
    }

    public List<ContatoPessoa> procurarPorPessoa(Pessoa pessoa) {
        return contatoPessoaRepository.findByPessoa(pessoa).stream().collect(Collectors.toList());
    }
}

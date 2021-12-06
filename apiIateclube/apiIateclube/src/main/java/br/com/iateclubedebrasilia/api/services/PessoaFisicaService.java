package br.com.iateclubedebrasilia.api.services;

import br.com.iateclubedebrasilia.api.domain.Pessoa;
import br.com.iateclubedebrasilia.api.domain.PessoaFisica;
import br.com.iateclubedebrasilia.api.repositories.PessoaFisicaRepository;
import br.com.iateclubedebrasilia.api.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaFisicaService {

    private PessoaFisicaRepository pessoaFisicaRepository;

    public PessoaFisicaService(PessoaFisicaRepository pessoaFisicaRepository) {
        this.pessoaFisicaRepository = pessoaFisicaRepository;
    }

    public List<PessoaFisica> listar() {
        return pessoaFisicaRepository.findAll();
    }

    public PessoaFisica salvar(PessoaFisica entity) {
        return pessoaFisicaRepository.save(entity);
    }

    public PessoaFisica procurarPorIden(Integer id) {
        Optional<PessoaFisica> pessoaFisica = pessoaFisicaRepository.findById(id);
        return pessoaFisica.orElseThrow(() -> new ObjectNotFoundException("Pessoa Física não encontrado"));
    }

    public void remover(PessoaFisica entity) {
        pessoaFisicaRepository.delete(entity);
    }

    public void removerPorIden(Integer id) {
        pessoaFisicaRepository.deleteById(id);
    }

    public PessoaFisica procurarPorPessoa(Pessoa pessoa) {
        return pessoaFisicaRepository.findByPessoa(pessoa);
    }
}

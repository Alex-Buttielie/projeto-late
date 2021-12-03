package br.com.iateclubedebrasilia.api.repositories;

import br.com.iateclubedebrasilia.api.domain.ContatoPessoa;
import br.com.iateclubedebrasilia.api.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ContatoPessoaRepository extends JpaRepository<ContatoPessoa, Integer> {

    Collection<ContatoPessoa> findByPessoa(Pessoa pessoa);
}

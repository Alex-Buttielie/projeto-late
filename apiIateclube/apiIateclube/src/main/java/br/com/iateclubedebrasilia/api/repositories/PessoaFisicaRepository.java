package br.com.iateclubedebrasilia.api.repositories;


import br.com.iateclubedebrasilia.api.domain.Pessoa;
import br.com.iateclubedebrasilia.api.domain.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Integer> {

    PessoaFisica findByPessoa(Pessoa pessoa);
}

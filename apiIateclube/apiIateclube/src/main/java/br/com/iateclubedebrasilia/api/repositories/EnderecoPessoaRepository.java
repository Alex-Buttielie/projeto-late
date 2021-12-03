package br.com.iateclubedebrasilia.api.repositories;


import br.com.iateclubedebrasilia.api.domain.EnderecoPessoa;
import br.com.iateclubedebrasilia.api.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoPessoaRepository extends JpaRepository<EnderecoPessoa, Integer> {

    EnderecoPessoa findByPessoa(Pessoa pessoa);
}

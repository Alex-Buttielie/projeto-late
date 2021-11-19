package br.com.iateclubedebrasilia.api.repositories;

import br.com.iateclubedebrasilia.api.domain.Dependencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DependenciaRepository extends JpaRepository<Dependencia, Integer> {

    List<Dependencia> findAllByIcTipoDependenciaOrderBySeqDependencia(String tipoDepencia);
}

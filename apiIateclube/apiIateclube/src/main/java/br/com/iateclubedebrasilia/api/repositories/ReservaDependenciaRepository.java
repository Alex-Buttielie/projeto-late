package br.com.iateclubedebrasilia.api.repositories;

import br.com.iateclubedebrasilia.api.domain.Dependencia;
import br.com.iateclubedebrasilia.api.domain.ReservaDependencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservaDependenciaRepository extends JpaRepository<ReservaDependencia, Integer> {

    @Override
    @Transactional(readOnly = true)
    List<ReservaDependencia> findAll();

    ReservaDependencia findByDependenciaAndDtaHoraInicio(Dependencia dependencia, LocalDateTime dataLocacao);
}

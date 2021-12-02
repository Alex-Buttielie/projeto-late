package br.com.iateclubedebrasilia.api.repositories;

import br.com.iateclubedebrasilia.api.domain.Dependencia;
import br.com.iateclubedebrasilia.api.dto.DependenciaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DependenciaRepository extends JpaRepository<Dependencia, Integer> {

    List<Dependencia> findAllByStatusOrderByIden(String tipoDepencia);
    //Dependencia findBySeqDependencia (Integer seqSequencia);%?1

    @Query(value = "select dep.DEP_IDEN," +
            "       dep.DEP_ABREVIACAO," +
            "       dep.DEP_DESCRICAO," +
            "       CASE" +
            "           WHEN rd.RDEP_DTA_HORA_INICIO >= ?1 and rd.RDEP_DTA_HORA_FIM <=  ?2 " +
            "               THEN 'OCUPADO'" +
            "               ELSE 'DISPONÍVEL'" +
            "           END DISPONIBILIDADE" +
            " from DEPENDENCIAS dep" +
            "         left join RESERVAS_DEPENDENCIAS rd" +
            "                   on dep.DEP_IDEN = rd.RDEP_DEP_IDEN" +
            " where dep.DEP_STATUS = 'S'", nativeQuery = true)
    List<DependenciaDTO> findChurrasqueiras(@Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);
}

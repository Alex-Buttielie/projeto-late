package br.com.iateclubedebrasilia.api.repositories.impl;

import br.com.iateclubedebrasilia.api.dto.DependenciaDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DependenciasRepositoryImpl implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public List<DependenciaDTO> listarDependencias(String tipo, LocalDate dataHoraInicio) {

        String sql = "select dep.DEP_IDEN, " +
                "                   dep.DEP_ABREVIACAO, " +
                "                   dep.DEP_DESCRICAO, " +
                "                   CASE " +
                "                       WHEN rd.RDEP_DTA_HORA_INICIO >= '" + dataHoraInicio.toString() + " 09:00:00.000' " +
                " and rd.RDEP_DTA_HORA_FIM <=  '" + dataHoraInicio.toString() + " 18:00:00.000'  " +
                "                           THEN 'OCUPADO' " +
                "                           ELSE 'DISPONÍVEL' " +
                "                       END 'DIURNO"+ dataHoraInicio.toString() + "', " +
                "                   CASE " +
                "                       WHEN rd.RDEP_DTA_HORA_INICIO >= '" + dataHoraInicio.toString() + " 18:00:00.000' " +
                " and rd.RDEP_DTA_HORA_FIM <=  '" + dataHoraInicio.toString() + " 22:00:00.000'  " +
                "                           THEN 'OCUPADO' " +
                "                           ELSE 'DISPONÍVEL' " +
                "                       END 'NOTURNO"+ dataHoraInicio.toString() + "'" +
                "             from DEPENDENCIAS dep " +
                "                     left join RESERVAS_DEPENDENCIAS rd " +
                "                               on dep.DEP_IDEN = rd.RDEP_DEP_IDEN " +
                "             where dep.DEP_STATUS = 'S'" +
                "               and dep.DEP_TIPO_DEPENDENCIA = '" + tipo + "'";


        Query query = entityManager.createNativeQuery(sql);

        List<Object> listObjects = query.getResultList();

        List<DependenciaDTO> listaDependencias = new ArrayList<>();

        for (Object item : listObjects) {
            Object[] itens = (Object[]) item;
            DependenciaDTO dependenciaDTO = DependenciaDTO
                    .builder()
                    .iden(new Integer(itens[0].toString()))
                    .abreviacao(itens[1].toString())
                    .descricao(itens[2].toString())
                    .diurno(itens[3].toString())
                    .noturno(itens[4].toString())
                    .build();

            listaDependencias.add(dependenciaDTO);
        }

        return listaDependencias;
    }
}

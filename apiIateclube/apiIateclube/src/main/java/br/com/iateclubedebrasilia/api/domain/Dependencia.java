package br.com.iateclubedebrasilia.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "DEPENDENCIAS", schema = "dbo")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dependencia {

    @Id
    @Column(name = "DEP_IDEN", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer iden;

    @Column(name = "DEP_DESCRICAO", length = 300)
    private String descricao;

    @Column(name = "DEP_ABREVIACAO", length = 300)
    private String abreviacao;

    @Column(name = "DEP_TIPO_DEPENDENCIA", length = 300)
    private String tipoDependencia;

    @Column(name = "DEP_STATUS", length = 1)
    private String status;

    @JsonIgnore
    @Column(name = "DEP_DTA_HORA")
    private LocalDateTime dtaHora;

    @ManyToOne
    @JoinColumn(name = "DEP_USU_IDEN", referencedColumnName = "USU_IDEN")
    private Usuario usuario;

}

package br.com.iateclubedebrasilia.api.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "RESERVAS_DEPENDENCIAS", schema = "dbo")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDependencia {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "RDEP_IDEN")
    private Integer iden;

    @JsonFormat
    @ManyToOne
    @JoinColumn(name = "RDEP_USU_SOLICITANTE", referencedColumnName = "USU_IDEN")
    private Usuario usuario;

    @JsonFormat
    @ManyToOne
    @JoinColumn(name = "RDEP_DEP_IDEN", referencedColumnName = "DEP_IDEN")
    private Dependencia dependencia;

    @JsonIgnore
    @Column(name = "RDEP_DTA_HORA_INICIO")
    private LocalDateTime dtaHoraInicio;

    @JsonIgnore
    @Column(name = "RDEP_DTA_HORA_FIM")
    private LocalDateTime dtaHoraFim;

    @JsonIgnore
    @Column(name = "RDEP_DTA_HORA")
    private LocalDateTime dtaHora;


}

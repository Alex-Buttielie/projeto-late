package br.com.iateclubedebrasilia.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TB_Dependencia")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dependencia {

    @Id
    @Column(name = "SEQ_DEPENDENCIA", nullable = false)
    private Integer seqDependencia;

    @Column(name = "DESCR_DEPENDENCIA", nullable = false, length = 25)
    private String descrDependencia;

    @Column(name = "MSG_LINHA_OLD")
    private String msgLinhaOld;

    @Lob
    @Column(name = "MSG_LINHA")
    private String msgLinha;

    @Column(name = "DE_ABREVIACAO", length = 10)
    private String deAbreviacao;

    @Column(name = "IC_TIPO_DEPENDENCIA", length = 1)
    private String icTipoDependencia;

    @Column(name = "IC_ATIVO", length = 1)
    private String icAtivo;


    @Column(name = "PERIODO", length = 1)
    private String perido;

    @Column(name = "MES")
    private String mes;

    @Column(name = "DIA")
    private Integer dia;

}

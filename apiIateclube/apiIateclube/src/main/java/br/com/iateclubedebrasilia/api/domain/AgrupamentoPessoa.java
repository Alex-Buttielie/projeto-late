package br.com.iateclubedebrasilia.api.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "agrupamentos_pessoas")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgrupamentoPessoa {

    @Id
    @Column(name = "agp_iden")
    private Integer iden;

    @ManyToOne
    @JoinColumn(name = "agp_pes_iden_origem", referencedColumnName = "pes_iden", nullable = false)
    private Pessoa pessoaOrigem;

    @ManyToOne
    @JoinColumn(name = "agp_pes_iden_agrp", referencedColumnName = "pes_iden", nullable = false)
    private Pessoa pessoaAgrp;

    @ManyToOne
    @JoinColumn(name = "agp_tagp_iden", referencedColumnName = "tagp_iden", nullable = false)
    private TipoAgrupamento tipoAgrupamento;

    @Basic
    @Column(name = "agp_dta_hora")
    private LocalDateTime dtaHora;

    @Basic
    @Column(name = "agp_usu_iden", nullable = false)
    private Integer usuario;
}

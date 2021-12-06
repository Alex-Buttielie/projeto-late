package br.com.iateclubedebrasilia.api.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;


@Entity
@Table(name = "PESSOAS")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    @Id
    @Column(name = "pes_iden")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iden;

    @Basic
    @Column(name = "pes_nome_reg")
    private String nomeReg;

    @Basic
    @Column(name = "pes_nome_soc")
    private String nomeSoc;

    @OneToMany(mappedBy = "pessoaOrigem", cascade = CascadeType.ALL)
    private Collection<AgrupamentoPessoa> agrupamentosPessoasOrigem;

    @OneToMany(mappedBy = "pessoaAgrp", cascade = CascadeType.ALL)
    private Collection<AgrupamentoPessoa> agrupamentosPessoas;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<ContatoPessoa> contatosPessoa;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private Collection<EnderecoPessoa> enderecosPessoa;

    @OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<PessoaFisica> pessoasFisicas;

    @OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<PessoaJuridica> pessoasJuridicas;

    @Basic
    @Column(name = "pes_status")
    private Boolean status;

    @Basic
    @Column(name = "pes_dta_hora")
    private LocalDateTime dtaHora;

    @Basic
    @Column(name = "pes_usu_iden", nullable = false)
    private Integer usuario;
}

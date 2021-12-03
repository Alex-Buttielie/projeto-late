package br.com.iateclubedebrasilia.api.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "contatos_pessoas")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContatoPessoa {

    @Id
    @Column(name = "cop_iden")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iden;

    @Basic
    @Column(name = "cop_tipo")
    private String tipo;

    @Basic
    @Column(name = "cop_principal")
    private Boolean principal;

    @Basic
    @Column(name = "cop_contato")
    private String contato;

    @Basic
    @Column(name = "cop_observacao")
    private String observacao;

    @Basic
    @Column(name = "cop_dta_ini")
    private LocalDate dtaIni;

    @Basic
    @Column(name = "cop_dta_fim")
    private Date dtaFim;

    @Basic
    @Column(name = "cop_status")
    private Boolean status;

    @Basic
    @Column(name = "cop_dta_hora")
    private LocalDateTime dtaHora;

    @ManyToOne
    @JoinColumn(name = "cop_pes_iden", referencedColumnName = "pes_iden", nullable = false)
    private Pessoa pessoa;

    @Basic
    @Column(name = "cop_usu_iden", nullable = false)
    private Integer usuario;

}

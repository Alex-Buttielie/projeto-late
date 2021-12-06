package br.com.iateclubedebrasilia.api.domain;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "pessoas_fisicas")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaFisica {

    @Id
    @Column(name = "pfi_iden")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iden;

    @Basic
    @Column(name = "pfi_sexo")
    private Character sexo;

    @Basic
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "pfi_dta_nascimento")
    private LocalDate dtaNascimento;

    @Basic
    @Column(name = "pfi_naturalidade")
    private String naturalidade;

    @Basic
    @Column(name = "pfi_nacionalidade")
    private String nacionalidade;

    @Basic
    @Column(name = "pfi_est_civil")
    private String estCivil;

    @CPF
    @Basic
    @Column(name = "pfi_cpf")
    private String cpf;

    @Basic
    @Column(name = "pfi_rg")
    private String rg;

    @Basic
    @Column(name = "pfi_rg_org_emissor")
    private String rgOrgEmissor;

    @Basic
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "pfi_dta_emissao")
    private LocalDate dtaEmissao;

    @Basic
    @Column(name = "pfi_nome_mae")
    private String nomeMae;

    @Basic
    @Column(name = "pfi_nome_pai")
    private String nomePai;

    @ManyToOne
    @JoinColumn(name = "pfi_pes_iden", referencedColumnName = "pes_iden")
    private Pessoa pessoa;

    @Basic
    @Column(name = "pfi_status")
    private Boolean status;

    @Basic
    @Column(name = "pfi_dta_hora")
    private LocalDateTime dtaHora;

    @Basic
    @Column(name = "pfi_usu_iden", nullable = false)
    private Integer usuario;

}

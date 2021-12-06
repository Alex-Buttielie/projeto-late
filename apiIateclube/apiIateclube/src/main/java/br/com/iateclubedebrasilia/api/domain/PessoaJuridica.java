package br.com.iateclubedebrasilia.api.domain;

import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "pessoas_juridicas")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaJuridica {

    @Id
    @Column(name = "pju_iden")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iden;

    @CNPJ
    @Basic
    @Column(name = "pju_cnpj")
    private String cnpj;

    @Basic
    @Column(name = "pju_ins_muni")
    private String insMuni;

    @Basic
    @Column(name = "pju_ins_est")
    private String insEst;

    @Basic
    @Column(name = "pju_ind_fornecedor")
    private Boolean indFornecedor;

    @ManyToOne
    @JoinColumn(name = "pju_pes_iden", referencedColumnName = "pes_iden", nullable = false)
    private Pessoa pessoa;

    @Basic
    @Column(name = "pju_status")
    private Boolean status;

    @Basic
    @Column(name = "pju_dta_hora")
    private LocalDateTime dtaHora;

    @Basic
    @Column(name = "pju_usu_iden", nullable = false)
    private Integer usuario;

}

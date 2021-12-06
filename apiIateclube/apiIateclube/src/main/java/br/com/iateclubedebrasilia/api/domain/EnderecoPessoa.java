package br.com.iateclubedebrasilia.api.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "enderecos_pessoas")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoPessoa {

    @Id
    @Column(name = "end_iden")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iden;

    @Basic
    @Column(name = "end_tipo")
    private String tipo;

    @Basic
    @Column(name = "end_logradouro")
    private String logradouro;

    @Basic
    @Column(name = "end_numero")
    private String numero;

    @Basic
    @Column(name = "end_complemento")
    private String complemento;

    @Basic
    @Column(name = "end_bairro")
    private String bairro;

    @Basic
    @Column(name = "end_cep")
    private String cep;

    @Basic
    @Column(name = "end_cidade")
    private String cidade;

    @Basic
    @Column(name = "end_estado")
    private String estado;

    @Basic
    @Column(name = "end_uf")
    private String uf;

    @Basic
    @Column(name = "end_status")
    private Boolean status;

    @Basic
    @Column(name = "end_dta_hora")
    private LocalDateTime dtaHora;

    @ManyToOne
    @JoinColumn(name = "end_pes_iden", referencedColumnName = "pes_iden", nullable = false)
    private Pessoa pessoa;

    @Basic
    @Column(name = "end_usu_iden", nullable = false)
    private Integer usuario;

}

package br.com.iateclubedebrasilia.api.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;


@Entity
@Table(name = "tipo_agrupamento")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoAgrupamento {

    @Id
    @Column(name = "tagp_iden")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iden;

    @Basic
    @Column(name = "tagp_nome")
    private String nome;

    @Basic
    @Column(name = "tagp_status")
    private Boolean status;

    @OneToMany(mappedBy = "tipoAgrupamento")
    private Collection<AgrupamentoPessoa> agrupamentoPessoa;

    @Basic
    @Column(name = "tagp_dta_hora")
    private LocalDateTime dtaHora;

    @Basic
    @Column(name = "tagp_usu_iden", nullable = false)
    private Integer usuario;

}

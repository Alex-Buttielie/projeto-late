package br.com.iateclubedebrasilia.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "permissoes")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permissao {


    @Id
    @Column(name = "per_iden")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer perIden;

    @Basic
    @Column(name = "per_descricao")
    private String perDescricao;

    @Basic
    @Column(name = "per_nome")
    private String perNome;

    @Basic
    @Column(name = "per_dta_hora")
    @CreationTimestamp
    private LocalDateTime perDtaHora;

    @ManyToMany(mappedBy = "permissoesGrupo")
    private Collection<Grupo> gruposPermissao;

    @ManyToMany
    @JoinTable(name = "menu_permissoes",
            joinColumns = @JoinColumn(name = "mpe_per_iden"),
            inverseJoinColumns = @JoinColumn(name = "mpe_men_iden"))
    private Collection<Menu> menus;

    @Basic
    @Column(name = "per_usu_iden", nullable = false)
    private Integer usuario;
}

package br.com.iateclubedebrasilia.api.entitys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;


@Entity
@Table(name = "menus")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {


    @Id
    @Column(name = "men_iden")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menIden;

    @Basic
    @Column(name = "men_descricao")
    private String menDescricao;

    @Basic
    @Column(name = "men_icone")
    private String menIcone;

    @Basic
    @Column(name = "men_ordem_menu")
    private Integer menOrdemMenu;

    @Basic
    @Column(name = "men_url")
    private String menUrl;

    @Basic
    @Column(name = "men_nivel")
    private Integer menNivel;

    @Basic
    @Column(name = "men_dta_hora")
    @CreationTimestamp
    private LocalDateTime menDtaHora;

    @ManyToMany(mappedBy = "menus")
    private Collection<Permissao> menuPermissoes;

    @ManyToOne
    @JoinColumn(name = "men_men_iden", referencedColumnName = "men_iden")
    private Menu menu;

    @OneToMany(mappedBy = "menu")
    private Collection<Menu> menus;

    @Basic
    @Column(name = "men_usu_iden", nullable = false)
    private Integer usuario;
}

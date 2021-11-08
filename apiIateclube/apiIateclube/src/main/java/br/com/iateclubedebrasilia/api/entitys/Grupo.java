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
@Table(name = "GRUPOS")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grupo {

    @Id
    @Column(name = "grp_iden")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer grpIden;

    @Column(name = "grp_nome")
    private String grpNome;

    @Column(name = "grp_descricao")
    private String grpDescricao;

    @ManyToMany(mappedBy = "gruposUsuario")
    private Collection<Usuario> usuarios;

    @ManyToMany
    @JoinTable(name = "grupos_permissoes",
            joinColumns = @JoinColumn(name = "gpe_grp_iden"),
            inverseJoinColumns = @JoinColumn(name = "gpe_per_iden"))
    private Collection<Permissao> permissoesGrupo;

    @Column(name = "grp_dta_hora")
    @CreationTimestamp
    private LocalDateTime grpDtaHora;

    @Column(name = "grp_usu_iden", nullable = false)
    private Integer usuario;

}

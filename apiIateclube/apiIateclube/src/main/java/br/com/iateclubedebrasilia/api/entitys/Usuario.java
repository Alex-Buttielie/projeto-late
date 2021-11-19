package br.com.iateclubedebrasilia.api.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "USUARIOS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(scope = Usuario.class,
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "usuIden")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_iden")
    private Integer usuIden;

    @Column(name = "usu_login", unique = true)
    private String usuLogin;

    @Column(name = "usu_email")
    private String usuEmail;

    @Column(name = "usu_nome")
    private String usuNome;

    @JsonIgnore
    @Column(name = "usu_senha")
    private String usuSenha;

    @JsonIgnore
    @Column(name = "usu_dta_hora")
    @CreationTimestamp
    private LocalDateTime usuDtaHora;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "usuarios_grupos",
            joinColumns = { @JoinColumn(name = "ugr_usu_iden", referencedColumnName = "usu_iden") },
            inverseJoinColumns = { @JoinColumn(name = "ugr_grp_iden", referencedColumnName = "grp_iden") })
    private Collection<Grupo> gruposUsuario;

    //@JsonIgnore
    @JsonFormat
    @ManyToOne
    @JoinColumn(name = "usu_usu_iden", referencedColumnName = "usu_iden")
    private Usuario usuario;

}

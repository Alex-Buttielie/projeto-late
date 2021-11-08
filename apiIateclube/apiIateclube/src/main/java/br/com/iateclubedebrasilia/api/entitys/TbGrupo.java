package br.com.iateclubedebrasilia.api.entitys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TB_Grupo")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbGrupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_GRUPO", nullable = false)
    private Integer id;

    @Column(name = "DESCR_GRUPO", nullable = false, length = 25)
    private String descrGrupo;

}
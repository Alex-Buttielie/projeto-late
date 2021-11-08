package br.com.iateclubedebrasilia.api.entitys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "TB_Usuario_Sistema")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbUsuarioSistema {

    @Id
    @Column(name = "USER_ACESSO_SISTEMA", nullable = false, length = 50)
    private String id;

    @Column(name = "NOME_USUARIO_SISTEMA", nullable = false, length = 40)
    private String nomeUsuarioSistema;

    @Column(name = "SENHA_USUARIO_SISTEMA", length = 6)
    private String senhaUsuarioSistema;

    @Column(name = "CD_MATRICULA")
    private Integer cdMatricula;

    @Column(name = "SEQ_DEPENDENTE")
    private Integer seqDependente;

    @Column(name = "CD_CATEGORIA")
    private Integer cdCategoria;

    @Column(name = "DT_EXPIRACAO")
    private Instant dtExpiracao;

    @Column(name = "IC_ATIVO", length = 1)
    private String icAtivo;

    @Column(name = "DE_OBSERVACAO", length = 1000)
    private String deObservacao;
}
package br.com.iateclubedebrasilia.api.entitys;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TbPessoaId implements Serializable {
    private static final long serialVersionUID = 5643348030510029161L;
    @Column(name = "CD_MATRICULA", nullable = false)
    private Integer cdMatricula;
    @Column(name = "SEQ_DEPENDENTE", nullable = false)
    private Integer seqDependente;
    @Column(name = "CD_CATEGORIA", nullable = false)
    private Integer cdCategoria;

    public Integer getCdCategoria() {
        return cdCategoria;
    }

    public void setCdCategoria(Integer cdCategoria) {
        this.cdCategoria = cdCategoria;
    }

    public Integer getSeqDependente() {
        return seqDependente;
    }

    public void setSeqDependente(Integer seqDependente) {
        this.seqDependente = seqDependente;
    }

    public Integer getCdMatricula() {
        return cdMatricula;
    }

    public void setCdMatricula(Integer cdMatricula) {
        this.cdMatricula = cdMatricula;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seqDependente, cdMatricula, cdCategoria);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TbPessoaId entity = (TbPessoaId) o;
        return Objects.equals(this.seqDependente, entity.seqDependente) &&
                Objects.equals(this.cdMatricula, entity.cdMatricula) &&
                Objects.equals(this.cdCategoria, entity.cdCategoria);
    }
}
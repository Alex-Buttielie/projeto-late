package br.com.iateclubedebrasilia.api.entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name="GRUPOS")
public class Grupos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer grpIden;
    private String grpNome;
    private String grpDescricao;
    private LocalDate grpDtaHora;
    private Integer grpUsuIden;

    public Integer getGrpIden() {
        return grpIden;
    }

    public void setGrpIden(Integer grpIden) {
        this.grpIden = grpIden;
    }

    public String getGrpNome() {
        return grpNome;
    }

    public void setGrpNome(String grpNome) {
        this.grpNome = grpNome;
    }

    public String getGrpDescricao() {
        return grpDescricao;
    }

    public void setGrpDescricao(String grpDescricao) {
        this.grpDescricao = grpDescricao;
    }

    public LocalDate getGrpDtaHora() {
        return grpDtaHora;
    }

    public void setGrpDtaHora(LocalDate grpDtaHora) {
        this.grpDtaHora = grpDtaHora;
    }

    public Integer getGrpUsuIden() {
        return grpUsuIden;
    }

    public void setGrpUsuIden(Integer grpUsuIden) {
        this.grpUsuIden = grpUsuIden;
    }
}

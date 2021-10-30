package br.com.iateclubedebrasilia.api.entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private Integer grpUgrIden;

    public Grupos(Integer grpIden,
                  String grpNome,
                  String grpDescricao,
                  LocalDate grpDtaHora,
                  Integer grpUgrIden) {

        this.grpUgrIden = grpUgrIden;
        this.grpNome = grpNome;
        this.grpDescricao = grpDescricao;
        this.grpDtaHora = grpDtaHora;
        this.grpIden = grpIden;
    }

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

    public Integer getGrpUgrIden() {
        return grpUgrIden;
    }

    public void setGrpUgrIden(Integer grpUgrIden) {
        this.grpUgrIden = grpUgrIden;
    }
}

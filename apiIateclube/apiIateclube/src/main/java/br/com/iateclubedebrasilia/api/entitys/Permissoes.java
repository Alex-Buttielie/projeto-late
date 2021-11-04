package br.com.iateclubedebrasilia.api.entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERMISSOES")
public class Permissoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer perIden;
    private String perDescricao;
    private String perNome;
    private String perDtaHora;
    private Integer perUsuIden;

    public Integer getPerIden() {
        return perIden;
    }

    public void setPerIden(Integer perIden) {
        this.perIden = perIden;
    }

    public String getPerDescricao() {
        return perDescricao;
    }

    public void setPerDescricao(String perDescricao) {
        this.perDescricao = perDescricao;
    }

    public String getPerNome() {
        return perNome;
    }

    public void setPerNome(String perNome) {
        this.perNome = perNome;
    }

    public String getPerDtaHora() {
        return perDtaHora;
    }

    public void setPerDtaHora(String perDtaHora) {
        this.perDtaHora = perDtaHora;
    }

    public Integer getPerUsuIden() {
        return perUsuIden;
    }

    public void setPerUsuIden(Integer perUsuIden) {
        this.perUsuIden = perUsuIden;
    }
}

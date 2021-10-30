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

    public Permissoes(Integer perIden,
                      String perDescricao,
                      String perNome,
                      String perDtaHora,
                      Integer perUsuIden) {

        this.perIden = perIden;
        this.perDescricao = perDescricao;
        this.perNome = perNome;
        this.perDtaHora = perDtaHora;
        this.perUsuIden = perUsuIden;
    }

    public Integer getPerIden() {
        return perIden;
    }

    public String getPerDescricao() {
        return perDescricao;
    }

    public String getPerNome() {
        return perNome;
    }

    public String getPerDtaHora() {
        return perDtaHora;
    }

    public Integer getPerUsuIden() {
        return perUsuIden;
    }
}

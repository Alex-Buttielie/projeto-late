package br.com.iateclubedebrasilia.api.entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "USUARIOS")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usuIden;
    private String usuLogin;
    private String usuNome;
    private String usuSenha;
    private LocalDate usuDtaHora;
    private Integer usuUsuIden;

    public Usuarios( Integer usuIden,
                     String usuLogin,
                     String usuNome,
                     String usuSenha,
                     LocalDate usuDtaHora,
                     Integer usuUsuIden) {

        this.usuIden = usuIden;
        this.usuLogin = usuLogin;
        this.usuNome = usuNome;
        this.usuSenha = usuSenha;
        this.usuDtaHora = usuDtaHora;
        this.usuUsuIden = usuUsuIden;
    }

    public Integer getUsuIden() {
        return usuIden;
    }

    public void setUsuIden(Integer usuIden) {
        this.usuIden = usuIden;
    }

    public String getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public String getUsuNome() {
        return usuNome;
    }

    public void setUsuNome(String usuNome) {
        this.usuNome = usuNome;
    }

    public String getUsuSenha() {
        return usuSenha;
    }

    public void setUsuSenha(String usuSenha) {
        this.usuSenha = usuSenha;
    }

    public LocalDate getUsuDtaHora() {
        return usuDtaHora;
    }

    public void setUsuDtaHora(LocalDate usuDtaHora) {
        this.usuDtaHora = usuDtaHora;
    }

    public Integer getUsuUsuIden() {
        return usuUsuIden;
    }

    public void setUsuUsuIden(Integer usuUsuIden) {
        this.usuUsuIden = usuUsuIden;
    }
}

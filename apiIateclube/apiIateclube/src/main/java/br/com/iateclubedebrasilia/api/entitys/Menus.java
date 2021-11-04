package br.com.iateclubedebrasilia.api.entitys;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "MENUS")
public class Menus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menIden;
    private String menDescricao;
    private String menIcone;
    private Integer menOrdemMenu;
    private String menUrl;
    private Integer menNivel;
    private Integer menMenIden;
    @CreationTimestamp
    private LocalDate menDtaHora;
    private Integer menUsuIden;

    public Integer getMenIden() {
        return menIden;
    }

    public void setMenIden(Integer menIden) {
        this.menIden = menIden;
    }

    public String getMenDescricao() {
        return menDescricao;
    }

    public void setMenDescricao(String menDescricao) {
        this.menDescricao = menDescricao;
    }

    public String getMenIcone() {
        return menIcone;
    }

    public void setMenIcone(String menIcone) {
        this.menIcone = menIcone;
    }

    public Integer getMenOrdemMenu() {
        return menOrdemMenu;
    }

    public void setMenOrdemMenu(Integer menOrdemMenu) {
        this.menOrdemMenu = menOrdemMenu;
    }

    public String getMenUrl() {
        return menUrl;
    }

    public void setMenUrl(String menUrl) {
        this.menUrl = menUrl;
    }

    public Integer getMenNivel() {
        return menNivel;
    }

    public void setMenNivel(Integer menNivel) {
        this.menNivel = menNivel;
    }

    public Integer getMenMenIden() {
        return menMenIden;
    }

    public void setMenMenIden(Integer menMenIden) {
        this.menMenIden = menMenIden;
    }

    public LocalDate getMenDtaHora() {
        return menDtaHora;
    }

    public void setMenDtaHora(LocalDate menDtaHora) {
        this.menDtaHora = menDtaHora;
    }

    public Integer getMenUsuIden() {
        return menUsuIden;
    }

    public void setMenUsuIden(Integer menUsuIden) {
        this.menUsuIden = menUsuIden;
    }
}

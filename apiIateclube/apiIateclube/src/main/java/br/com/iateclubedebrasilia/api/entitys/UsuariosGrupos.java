package br.com.iateclubedebrasilia.api.entitys;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "USUARIOS_GRUPOS")
public class UsuariosGrupos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ugrIden;
    private Integer ugrUsuIden;
    private Integer ugrGrpIden;
    @CreationTimestamp
    private LocalDate ugrDtaHora;

    public Integer getUgrIden() {
        return ugrIden;
    }

    public void setUgrIden(Integer ugrIden) {
        this.ugrIden = ugrIden;
    }

    public Integer getUgrUsuIden() {
        return ugrUsuIden;
    }

    public void setUgrUsuIden(Integer ugrUsuIden) {
        this.ugrUsuIden = ugrUsuIden;
    }

    public Integer getUgrGrpIden() {
        return ugrGrpIden;
    }

    public void setUgrGrpIden(Integer ugrGrpIden) {
        this.ugrGrpIden = ugrGrpIden;
    }

    public LocalDate getUgrDtaHora() {
        return ugrDtaHora;
    }

    public void setUgrDtaHora(LocalDate ugrDtaHora) {
        this.ugrDtaHora = ugrDtaHora;
    }
}

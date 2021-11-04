package br.com.iateclubedebrasilia.api.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "MENU_PERMISSOES")
public class MenuPermissoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mpeInde;
    private Integer mpeMenIden;
    private Integer mpePerIden;

    public Integer getMpeInde() {
        return mpeInde;
    }

    public void setMpeInde(Integer mpeInde) {
        this.mpeInde = mpeInde;
    }

    public Integer getMpeMenIden() {
        return mpeMenIden;
    }

    public void setMpeMenIden(Integer mpeMenIden) {
        this.mpeMenIden = mpeMenIden;
    }

    public Integer getMpePerIden() {
        return mpePerIden;
    }

    public void setMpePerIden(Integer mpePerIden) {
        this.mpePerIden = mpePerIden;
    }
}



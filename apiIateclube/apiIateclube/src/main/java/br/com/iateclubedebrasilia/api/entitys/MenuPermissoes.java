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
    private Long mpeMen;
    private Integer mpeMenIden;
    private Integer mprGrpIden;

    public Long getMpeMen() {
        return mpeMen;
    }

    public void setMpeMen(Long mpeMen) {
        this.mpeMen = mpeMen;
    }

    public Integer getMpeMenIden() {
        return mpeMenIden;
    }

    public void setMpeMenIden(Integer mpeMenIden) {
        this.mpeMenIden = mpeMenIden;
    }

    public Integer getMprGrpIden() {
        return mprGrpIden;
    }

    public void setMprGrpIden(Integer mprGrpIden) {
        this.mprGrpIden = mprGrpIden;
    }
}



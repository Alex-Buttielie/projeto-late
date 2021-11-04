package br.com.iateclubedebrasilia.api.entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GRUPOS_PERMISSOES")
public class GruposPermissoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gpIden;
    private Integer gpeGrpIden;
    private Integer gpePerIden;

    public Integer getGpIden() {
        return gpIden;
    }

    public void setGpIden(Integer gpIden) {
        this.gpIden = gpIden;
    }

    public Integer getGpeGrpIden() {
        return gpeGrpIden;
    }

    public void setGpeGrpIden(Integer gpeGrpIden) {
        this.gpeGrpIden = gpeGrpIden;
    }

    public Integer getGpePerIden() {
        return gpePerIden;
    }

    public void setGpePerIden(Integer gpePerIden) {
        this.gpePerIden = gpePerIden;
    }
}

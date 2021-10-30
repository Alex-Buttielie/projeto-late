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
    private Integer grpIden;
    private Integer grpPerIden;

    public GruposPermissoes(Integer gpIden,
                            Integer grpIden,
                            Integer grpPerIden) {

        this.gpIden = gpIden;
        this.grpIden = grpIden;
        this.grpPerIden = grpPerIden;
    }

    public Integer getGpIden() {
        return gpIden;
    }

    public void setGpIden(Integer gpIden) {
        this.gpIden = gpIden;
    }

    public Integer getGrpIden() {
        return grpIden;
    }

    public void setGrpIden(Integer grpIden) {
        this.grpIden = grpIden;
    }

    public Integer getGrpPerIden() {
        return grpPerIden;
    }

    public void setGrpPerIden(Integer grpPerIden) {
        this.grpPerIden = grpPerIden;
    }
}

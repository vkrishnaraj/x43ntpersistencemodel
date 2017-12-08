package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class BDO_OHD implements Serializable {


    private static final long serialVersionUID = 5987745309850770831L;
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "bdo_ID")
    private BDO bdo;

    @OneToOne
    @JoinColumn(name = "ohd_id")
    private OHD ohd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BDO getBdo() {
        return bdo;
    }

    public void setBdo(BDO bdo) {
        this.bdo = bdo;
    }

    public OHD getOhd() {
        return ohd;
    }

    public void setOhd(OHD ohd) {
        this.ohd = ohd;
    }
}

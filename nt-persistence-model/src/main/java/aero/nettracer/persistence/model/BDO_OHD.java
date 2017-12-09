package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bdo_ohd")
public class BDO_OHD {

    private int id;
    private BDO bdo;
    private OHD ohd;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "bdo_id", updatable = false, nullable = false)
    public BDO getBdo() {
        return bdo;
    }

    public void setBdo(BDO bdo) {
        this.bdo = bdo;
    }

    @OneToOne
    @JoinColumn(name = "ohd_id", updatable = false, nullable = false)
    public OHD getOhd() {
        return ohd;
    }

    public void setOhd(OHD ohd) {
        this.ohd = ohd;
    }
}

package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bagtag_expeditetag_mapping")
public class BagTagExpediteTagMapping {

    private int id;
    private OHD ohd;
    private String claimnumOhd;
    private String primaryExpediteTagNumber;
    private String secondaryExpediteTagNumber;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    @OneToOne
    @JoinColumn(name = "ohd_id")
    public OHD getOhd() { return ohd; }

    public void setOhd(OHD ohd) { this.ohd = ohd; }

    @Column(name = "claimnum_ohd")
    public String getClaimnumOhd() { return claimnumOhd; }

    public void setClaimnumOhd(String claimnumOhd) { this.claimnumOhd = claimnumOhd; }

    @Column(name = "primary_expedite_tag")
    public String getPrimaryExpediteTagNumber() { return primaryExpediteTagNumber; }

    public void setPrimaryExpediteTagNumber(String primaryExpediteTagNumber) { this.primaryExpediteTagNumber = primaryExpediteTagNumber; }

    @Column(name = "secondary_expedite_tag")
    public String getSecondaryExpediteTagNumber() { return secondaryExpediteTagNumber; }

    public void setSecondaryExpediteTagNumber(String secondaryExpediteTagNumber) { this.secondaryExpediteTagNumber = secondaryExpediteTagNumber; }

}

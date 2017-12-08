package aero.nettracer.persistence.model;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bagtag_expeditetag_mapping")
public class BagTagExpediteTagMapping implements Serializable{
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    @JoinColumn(name = "ohd_id")
    @Fetch(FetchMode.SELECT)
    private OHD ohd;

    @Column(name = "claimnum_ohd")
    private String claimnumOhd;

    @Column(name = "primary_expedite_tag")
    private String primaryExpediteTagNumber;

    @Column(name = "secondary_expedite_tag")
    private String secondaryExpediteTagNumber;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public OHD getOhd() { return ohd; }

    public void setOhd(OHD ohd) { this.ohd = ohd; }

    public String getClaimnumOhd() { return claimnumOhd; }

    public void setClaimnumOhd(String claimnumOhd) { this.claimnumOhd = claimnumOhd; }

    public String getPrimaryExpediteTagNumber() { return primaryExpediteTagNumber; }

    public void setPrimaryExpediteTagNumber(String primaryExpediteTagNumber) { this.primaryExpediteTagNumber = primaryExpediteTagNumber; }

    public String getSecondaryExpediteTagNumber() { return secondaryExpediteTagNumber; }

    public void setSecondaryExpediteTagNumber(String secondaryExpediteTagNumber) { this.secondaryExpediteTagNumber = secondaryExpediteTagNumber; }

}

package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "lflossinfo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class LFLossInfo {

    private long id;
    private Date lossdate;
    private String destinationStationCode;
    private String originStationCode;
    private String agreementNumber;
    private String mvaNumber;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "loss_date")
    public Date getLossdate() {
        return lossdate;
    }

    public void setLossdate(Date lossdate) {
        this.lossdate = lossdate;
    }

    @Column(name = "dest_stn_code")
    public String getDestinationStationCode() {
        return destinationStationCode;
    }

    public void setDestinationStationCode(String destinationStationCode) {
        this.destinationStationCode = destinationStationCode;
    }

    @Column(name = "org_stn_code")
    public String getOriginStationCode() {
        return originStationCode;
    }

    public void setOriginStationCode(String originStationCode) {
        this.originStationCode = originStationCode;
    }

    @Column(name = "agreement_num")
    public String getAgreementNumber() {
        return agreementNumber;
    }

    public void setAgreementNumber(String agreementNumber) {
        this.agreementNumber = agreementNumber;
    }

    @Column(name = "mva_num")
    public String getMvaNumber() {
        return mvaNumber;
    }

    public void setMvaNumber(String mvaNumber) {
        this.mvaNumber = mvaNumber;
    }

}

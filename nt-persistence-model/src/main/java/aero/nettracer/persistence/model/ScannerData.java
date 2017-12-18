package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;

@Entity
@Table(name = "scanner_data")
public class ScannerData  {

    private long id;
    private String passengerName;
    private String pnr;
    private String tag;
    private Timestamp createDate;
    private String scanStation;
    private String scanLocation;
    private String scanType;
    private String scanningInformation;
    private String ohd;
    private String incident_id;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name ="passenger_name")
    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    @Column(name = "record_locator")
    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    @Column(name = "bag_tag_number")
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Column(name = "createdate")
    @Temporal(TemporalType.TIMESTAMP)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Column(name = "scanstation")
    public String getScanStation() {
        return scanStation;
    }

    public void setScanStation(String scanStation) {
        this.scanStation = scanStation;
    }

    @Column(name = "scanlocation")
    public String getScanLocation() {
        return scanLocation;
    }

    public void setScanLocation(String scanLocation) {
        this.scanLocation = scanLocation;
    }

    @Column(name = "scantype")
    public String getScanType() {
        return scanType;
    }

    public void setScanType(String scanType) {
        this.scanType = scanType;
    }

    @Column(name = "scanninginformation")
    public String getScanningInformation() {
        return scanningInformation;
    }

    public void setScanningInformation(String scanningInformation) {
        this.scanningInformation = scanningInformation;
    }

    @Column(name = "ohd")
    public String getOhd() {
        return ohd;
    }

    public void setOhd(String ohd) {
        this.ohd = ohd;
    }

    @Column(name = "incident_id")
    public String getIncident_id() {
        return incident_id;
    }

    public void setIncident_id(String incident_id) {
        this.incident_id = incident_id;
    }

}

package aero.nettracer.persistence.model;


import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by armel on 3/9/2017.
 */

@Entity
@Table(name = "scanner_data")
public class ScannerData implements Serializable {


    private long id;


    private String passengerName;
    private String pnr;
    private String tag;

    private Date dateTime;
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

    @Column(name = "record_locator")
    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getScanStation() {
        return scanStation;
    }

    public void setScanStation(String scanStation) {
        this.scanStation = scanStation;
    }

    public String getScanLocation() {
        return scanLocation;
    }

    public void setScanLocation(String scanLocation) {
        this.scanLocation = scanLocation;
    }

    @Column(name ="passenger_name")
    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }


    public String getOhd() {
        return ohd;
    }

    public void setOhd(String ohd) {
        this.ohd = ohd;
    }

    @Temporal(value = TemporalType.TIMESTAMP)
    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Column(name = "bag_tag_number")
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getScanningInformation() {
        return scanningInformation;
    }

    public void setScanningInformation(String scanningInformation) {
        this.scanningInformation = scanningInformation;
    }

    public String getScanType() {
        return scanType;
    }

    public void setScanType(String scanType) {
        this.scanType = scanType;
    }

    public String getIncident_id() {
        return incident_id;
    }

    public void setIncident_id(String incident_id) {
        this.incident_id = incident_id;
    }

}

package aero.nettracer.persistence.model;

import aero.nettracer.persistence.util.ScanStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;

@Entity
@Table(name="scanner_data_queue")
public class ScannerDataQueue  {

    private long id;
    private String incident_id;
    private String bagTagNumber;
    private Timestamp incidentCreateDateTime;
    private Timestamp createDate;
    private Timestamp scannedDateTime;
    private ScanStatus scanStatus = ScanStatus.PENDING;
    private String errorMessage;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "incident_id", nullable = false)
    public String getIncident_id() {
        return incident_id;
    }

    public void setIncident_id(String incident_id) {
        this.incident_id = incident_id;
    }

    @Column(name = "bag_tag_number", nullable = false)
    public String getBagTagNumber() {
        return bagTagNumber;
    }

    public void setBagTagNumber(String bagTagNumber) {
        this.bagTagNumber = bagTagNumber;
    }

    @Column(name = "incident_create_dateTime" , nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    public Timestamp getIncidentCreateDateTime() {
        return incidentCreateDateTime;
    }

    public void setIncidentCreateDateTime(Timestamp incidentCreateDateTime) {
        this.incidentCreateDateTime = incidentCreateDateTime;
    }

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name="scanned_dateTime")
    public Timestamp getScannedDateTime() {
        return scannedDateTime;
    }

    public void setScannedDateTime(Timestamp scannedDateTime) {
        this.scannedDateTime = scannedDateTime;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="scan_status")
    public ScanStatus getScanStatus() {
        return scanStatus;
    }

    public void setScanStatus(ScanStatus scanStatus) {
        this.scanStatus = scanStatus;
    }

    @Column(name = "error_message")
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}

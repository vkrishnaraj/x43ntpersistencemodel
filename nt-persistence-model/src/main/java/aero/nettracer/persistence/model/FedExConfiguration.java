package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "fedex_configuration")
public class FedExConfiguration implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "station_code")
    private String stationCode;

    @Column(name = "station_country_code")
    private String stationCountryCode;

    @Column(name = "account_for")
    private String accountFor;

    @Column(name = "account_number")
    private int accountNumber;

    @Column(name = "meter_number")
    private int meterNumber;

    @Column(name = "fedex_key")
    private String fedExKey;

    @Column(name = "fedex_password")
    private String fedExPassword;

    @Column(name = "sender_name")
    private String senderName;

    @Column(name = "sender_address1")
    private String senderAddress1;

    @Column(name = "sender_address2")
    private String senderAddress2;

    @Column(name = "sender_city")
    private String senderCity;

    @Column(name = "sender_state")
    private String senderState;

    @Column(name = "sender_province")
    private String senderProvince;

    @Column(name = "sender_postal_code")
    private String senderPostalCode;

    @Column(name = "sender_country_code")
    private String senderCountryCode;

    @Column(name = "sender_country_name")
    private String senderCountryName;

    @Column(name = "sender_phone")
    private String senderPhone;

    @Column(name = "allow_Sat_delivery")
    private boolean allowSatDelivery;

    @Column(name = "print_label_format")
    private String labelFormat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationCountryCode() {
        return stationCountryCode;
    }

    public void setStationCountryCode(String stationCountryCode) {
        this.stationCountryCode = stationCountryCode;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(int meterNumber) {
        this.meterNumber = meterNumber;
    }

    public String getFedExKey() {
        return fedExKey;
    }

    public void setFedExKey(String fedExKey) {
        this.fedExKey = fedExKey;
    }

    public String getFedExPassword() {
        return fedExPassword;
    }

    public void setFedExPassword(String fedExPassword) {
        this.fedExPassword = fedExPassword;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderAddress1() {
        return senderAddress1;
    }

    public void setSenderAddress1(String senderAddress1) {
        this.senderAddress1 = senderAddress1;
    }

    public String getSenderAddress2() {
        return senderAddress2;
    }

    public void setSenderAddress2(String senderAddress2) {
        this.senderAddress2 = senderAddress2;
    }

    public String getSenderCity() {
        return senderCity;
    }

    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    public String getSenderState() {
        return senderState;
    }

    public void setSenderState(String senderState) {
        this.senderState = senderState;
    }

    public String getSenderPostalCode() {
        return senderPostalCode;
    }

    public void setSenderPostalCode(String senderPostalCode) {
        this.senderPostalCode = senderPostalCode;
    }

    public String getSenderCountryCode() {
        return senderCountryCode;
    }

    public void setSenderCountryCode(String senderCountryCode) {
        this.senderCountryCode = senderCountryCode;
    }

    public String getSenderCountryName() {
        return senderCountryName;
    }

    public void setSenderCountryName(String senderCountryName) {
        this.senderCountryName = senderCountryName;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getAccountFor() {
        return accountFor;
    }

    public void setAccountFor(String accountFor) {
        this.accountFor = accountFor;
    }

    public String getSenderProvince() {
        return senderProvince;
    }

    public void setSenderProvince(String senderProvince) {
        this.senderProvince = senderProvince;
    }

    public boolean isAllowSatDelivery() {
        return allowSatDelivery;
    }

    public void setAllowSatDelivery(boolean allowSatDelivery) {
        this.allowSatDelivery = allowSatDelivery;
    }

    public String getLabelFormat() {
        return labelFormat;
    }

    public void setLabelFormat(String labelFormat) {
        this.labelFormat = labelFormat;
    }
}

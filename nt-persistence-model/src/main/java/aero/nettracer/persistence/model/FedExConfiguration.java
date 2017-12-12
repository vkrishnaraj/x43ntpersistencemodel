package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "fedex_configuration")
public class FedExConfiguration {

    private int id;
    private String stationCode;
    private String stationCountryCode;
    private String accountFor;
    private int accountNumber;
    private int meterNumber;
    private String fedExKey;
    private String fedExPassword;
    private String senderName;
    private String senderAddress1;
    private String senderAddress2;
    private String senderCity;
    private String senderState;
    private String senderProvince;
    private String senderPostalCode;
    private String senderCountryCode;
    private String senderCountryName;
    private String senderPhone;
    private boolean allowSatDelivery;
    private String labelFormat;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "station_code")
    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    @Column(name = "station_country_code")
    public String getStationCountryCode() {
        return stationCountryCode;
    }

    public void setStationCountryCode(String stationCountryCode) {
        this.stationCountryCode = stationCountryCode;
    }

    @Column(name = "account_number")
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Column(name = "meter_number")
    public int getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(int meterNumber) {
        this.meterNumber = meterNumber;
    }

    @Column(name = "fedex_key")
    public String getFedExKey() {
        return fedExKey;
    }

    public void setFedExKey(String fedExKey) {
        this.fedExKey = fedExKey;
    }

    @Column(name = "fedex_password")
    public String getFedExPassword() {
        return fedExPassword;
    }

    public void setFedExPassword(String fedExPassword) {
        this.fedExPassword = fedExPassword;
    }

    @Column(name = "sender_name")
    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    @Column(name = "sender_address1")
    public String getSenderAddress1() {
        return senderAddress1;
    }

    public void setSenderAddress1(String senderAddress1) {
        this.senderAddress1 = senderAddress1;
    }

    @Column(name = "sender_address2")
    public String getSenderAddress2() {
        return senderAddress2;
    }

    public void setSenderAddress2(String senderAddress2) {
        this.senderAddress2 = senderAddress2;
    }

    @Column(name = "sender_city")
    public String getSenderCity() {
        return senderCity;
    }

    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    @Column(name = "sender_state")
    public String getSenderState() {
        return senderState;
    }

    public void setSenderState(String senderState) {
        this.senderState = senderState;
    }

    @Column(name = "sender_postal_code")
    public String getSenderPostalCode() {
        return senderPostalCode;
    }

    public void setSenderPostalCode(String senderPostalCode) {
        this.senderPostalCode = senderPostalCode;
    }

    @Column(name = "sender_country_code")
    public String getSenderCountryCode() {
        return senderCountryCode;
    }

    public void setSenderCountryCode(String senderCountryCode) {
        this.senderCountryCode = senderCountryCode;
    }

    @Column(name = "sender_country_name")
    public String getSenderCountryName() {
        return senderCountryName;
    }

    public void setSenderCountryName(String senderCountryName) {
        this.senderCountryName = senderCountryName;
    }

    @Column(name = "sender_phone")
    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    @Column(name = "account_for")
    public String getAccountFor() {
        return accountFor;
    }

    public void setAccountFor(String accountFor) {
        this.accountFor = accountFor;
    }

    @Column(name = "sender_province")
    public String getSenderProvince() {
        return senderProvince;
    }

    public void setSenderProvince(String senderProvince) {
        this.senderProvince = senderProvince;
    }

    @Column(name = "allow_sat_delivery")
    public boolean isAllowSatDelivery() {
        return allowSatDelivery;
    }

    public void setAllowSatDelivery(boolean allowSatDelivery) {
        this.allowSatDelivery = allowSatDelivery;
    }

    @Column(name = "print_label_format")
    public String getLabelFormat() {
        return labelFormat;
    }

    public void setLabelFormat(String labelFormat) {
        this.labelFormat = labelFormat;
    }
}

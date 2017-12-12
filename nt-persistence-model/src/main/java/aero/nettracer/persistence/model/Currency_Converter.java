package aero.nettracer.persistence.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "currency_converter")
public class Currency_Converter {

    private int id;
    private String convertFrom;
    private String convertTo;
    private double convertAmount;
    private double convertResult;
    private Timestamp convertDateTime;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "convertFrom")
    public String getConvertFrom() {
        return convertFrom;
    }

    public void setConvertFrom(String convertFrom) {
        this.convertFrom = convertFrom;
    }

    @Column(name = "convertTo")
    public String getConvertTo() {
        return convertTo;
    }

    public void setConvertTo(String convertTo) {
        this.convertTo = convertTo;
    }

    @Column(name = "convertAmount")
    public double getConvertAmount() {
        return convertAmount;
    }

    public void setConvertAmount(double convertAmount) {
        this.convertAmount = convertAmount;
    }

    @Column(name = "convertResult")
    public double getConvertResult() {
        return convertResult;
    }

    public void setConvertResult(double convertResult) {
        this.convertResult = convertResult;
    }

    @Column(name = "convertDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    public Timestamp getConvertDateTime() {
        return convertDateTime;
    }

    public void setConvertDateTime(Timestamp convertDateTime) {
        this.convertDateTime = convertDateTime;
    }
}

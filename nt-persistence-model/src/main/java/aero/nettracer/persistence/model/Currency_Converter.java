package aero.nettracer.persistence.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "currency_converter")
public class Currency_Converter {
    private int id;
    private String convertFrom;
    private String convertTo;
    private double convertAmount;
    private double convertResult;
    private Date convertDateTime;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConvertFrom() {
        return convertFrom;
    }

    public void setConvertFrom(String convertFrom) {
        this.convertFrom = convertFrom;
    }

    public String getConvertTo() {
        return convertTo;
    }

    public void setConvertTo(String convertTo) {
        this.convertTo = convertTo;
    }

    public double getConvertAmount() {
        return convertAmount;
    }

    public void setConvertAmount(double convertAmount) {
        this.convertAmount = convertAmount;
    }

    public double getConvertResult() {
        return convertResult;
    }

    public void setConvertResult(double convertResult) {
        this.convertResult = convertResult;
    }

    public Date getConvertDateTime() {
        return convertDateTime;
    }

    public void setConvertDateTime(Date convertDateTime) {
        this.convertDateTime = convertDateTime;
    }
}

package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "dateformat")
public class NTDateFormat implements Serializable {
	private int dateFormatId;
	private String format;

	@Id
	@GeneratedValue
	public int getDateformat_ID() {
		return Dateformat_ID;
	}

	public void setDateformat_ID(int dateformat_ID) {
		Dateformat_ID = dateformat_ID;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
}
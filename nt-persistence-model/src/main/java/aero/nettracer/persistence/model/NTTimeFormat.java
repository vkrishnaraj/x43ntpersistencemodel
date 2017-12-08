package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "timeformat")
public class NTTimeFormat implements Serializable {
	private int Timeformat_ID;
	private String format;

	@Id
	@GeneratedValue
	public int getTimeformat_ID() {
		return Timeformat_ID;
	}

	public void setTimeformat_ID(int timeformat_ID) {
		Timeformat_ID = timeformat_ID;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
}
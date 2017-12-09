package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "timeformat")
public class NTTimeFormat implements Serializable {
	private int timeFormatId;
	private String format;

	@Id
	@GeneratedValue
	@Column(name = "timeformat_id", length = 11)
	public int getTimeFormatId() {
		return timeFormatId;
	}

	public void setTimeFormatId(int timeFormatId) {
		this.timeFormatId = timeFormatId;
	}




	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
}
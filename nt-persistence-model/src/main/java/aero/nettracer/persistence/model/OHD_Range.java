package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "OHD_Range")
public class OHD_Range implements Serializable {

	private long current_num;
	private String companycode_ID;

	@Id
	@GeneratedValue
	public long getCurrent_num() {
		return current_num;
	}

	public void setCurrent_num(long current_num) {
		this.current_num = current_num;
	}

	public String getCompanycode_ID() {
		return companycode_ID;
	}

	public void setCompanycode_ID(String companycode_ID) {
		this.companycode_ID = companycode_ID;
	}

}
package aero.nettracer.persistence.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name="Resolution")
public class Resolution implements Serializable {
	private int Resolution_ID;
	private String status;
	private String locale;
	private Company company;

	@ManyToOne
	@JoinColumn(name = "companycode_ID")
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	@Id
	@GeneratedValue
	public int getResolution_ID() {
		return Resolution_ID;
	}

	public void setResolution_ID(int resolution_ID) {
		Resolution_ID = resolution_ID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
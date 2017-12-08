package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "CountryCode")
public class CountryCode implements Serializable {
	private String CountryCode_ID;
	private String country;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Id
	public String getCountryCode_ID() {
		return CountryCode_ID;
	}

	public void setCountryCode_ID(String countryCode_ID) {
		CountryCode_ID = countryCode_ID;
	}

}
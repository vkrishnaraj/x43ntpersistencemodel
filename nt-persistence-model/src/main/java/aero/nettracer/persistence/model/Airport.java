package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "airport")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Airport implements Serializable {
	private static final long serialVersionUID = -8920424497356057481L;
	
	@Id @GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(length = 3)
	private String airport_code;
	
	@Column(length = 255)
	private String airport_desc;
	
	@Column(length = 2)
	private String locale;
	
	@Column(length = 3)
	private String country;
	
	@Column(length = 255)
	private String timezone;

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getAirport_code() {
		return airport_code;
	}

	public void setAirport_code(String airport_code) {
		this.airport_code = airport_code;
	}

	public String getAirport_desc() {
		return airport_desc;
	}

	public void setAirport_desc(String airport_desc) {
		this.airport_desc = airport_desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
}
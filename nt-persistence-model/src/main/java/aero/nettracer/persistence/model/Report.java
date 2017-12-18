package aero.nettracer.persistence.model;

import aero.nettracer.commons.utils.CommonsConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "report")
public class Report  {

	private int id;
	private int number;
	private String resource_key;
	private String locale = CommonsConstants.DEFAULT_LOCALE;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "number")
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Column(name = "resource_key", nullable=false)
	public String getResource_key() {
		return resource_key;
	}

	public void setResource_key(String resource_key) {
		this.resource_key = resource_key;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

}

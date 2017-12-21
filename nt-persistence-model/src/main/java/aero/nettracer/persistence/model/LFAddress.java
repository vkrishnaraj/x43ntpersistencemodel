package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.Proxy;

import aero.nettracer.commons.utils.GenericStringUtils;


@Entity
@Proxy(lazy = false)
public class LFAddress implements Serializable{

	private static final long serialVersionUID = 4392614284865636644L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="addr_1",length = 128)
	private String address1;
	
	@Column(name="addr_2",length = 128)
	private String address2;
	
	@Column(name="city",length = 128)
	private String city;
	
	@Column(name="state",length = 2)
	private String state;
	
	@Column(name="province",length = 128)
	private String province;
	
	@Column(name="zip",length = 16)
	private String zip;
	
	@Column(name="country",length = 3)
	private String country;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}
	
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryName() {
//		if (country != null && country.length() > 0) {
//			return TracerUtils.getCountry(country).getCountry();
//		}
		return "";
	}
	
	@Transient
	public boolean isEmpty() {
		boolean empty = true;
		if ((getAddress1() != null && !getAddress1().isEmpty())
				|| (getAddress2() != null && !getAddress2().isEmpty())
				|| (getCity() != null && !getCity().isEmpty())
				|| (getState() != null && !getState().isEmpty())
				|| (getProvince() != null && !getProvince().isEmpty())
				|| (getZip() != null && !getZip().isEmpty())
				|| (getCountry() != null && !getCountry().isEmpty())) {
			empty = false;
		}

		return empty;
	}
	
	@Transient
	public boolean isSameStateCountry(LFAddress other) {
		if (other == null) return true;
		if (GenericStringUtils.isDifferentIgnoreEmpty(this.getCountry(), other.getCountry())) return false;
		if ("US".equalsIgnoreCase(this.getCountry())) {
			return !GenericStringUtils.isDifferentIgnoreEmpty(this.getState(), other.getState());
		}
		return true;
	}
	
	@Transient
	public String getStateOrProvince() {
		return getState() != null ? getState() : getProvince() != null ? getProvince() : "";
	}
	
	@Override
	public String toString() {
		StringBuilder addressString = new StringBuilder();
		addressString.append(address1 != null ? address1 : "");
		addressString.append(address2 != null ? address2 : "");
		addressString.append(city != null ? city : "");
		addressString.append(state != null ? state : "");
		addressString.append(province != null ? province : "");
		addressString.append(zip != null ? zip : "");
		return addressString.toString();
	}
		
}

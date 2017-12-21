package aero.nettracer.persistence.model;

import aero.nettracer.commons.utils.GenericStringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "lfaddress")
public class LFAddress {

	private long id;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String province;
	private String zip;
	private String country;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="addr_1")
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name="addr_2")
	public String getAddress2() {
		return address2;
	}
	
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name="city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name="state")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name="province")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name="zip")
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column(name="country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

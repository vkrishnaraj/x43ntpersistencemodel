package aero.nettracer.persistence.model.audit;

import java.io.Serializable;
import java.util.Date;

import aero.nettracer.commons.utils.GenericDateUtils;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "audit_address")
public class Audit_Address implements Serializable {
	private int audit_address_id;
	private int Address_ID;
	private String address1;
	private String address2;
	private String city;
	private String zip;
	private String hotel;
	private String homephone;
	private String workphone;
	private String mobile;
	private String pager;
	private String altphone;
	private String email;
	private int addresstype;
	private boolean permanent;
	private String state_ID;
	private String countrycode_ID;
	private String province;
	private Date valid_bdate;
	private Date valid_edate;
	private String _DATEFORMAT; //for date time format purpose only, not
	
	private Audit_Passenger audit_passenger;

	@Id
	@GeneratedValue
	public int getAudit_address_id() {
		return audit_address_id;
	}

	public void setAudit_address_id(int audit_address_id) {
		this.audit_address_id = audit_address_id;
	}

	@ManyToOne
	@JoinColumn(name = "audit_passenger_id")
	public Audit_Passenger getAudit_passenger() {
		return audit_passenger;
	}

	public void setAudit_passenger(Audit_Passenger audit_passenger) {
		this.audit_passenger = audit_passenger;
	}

	public String getCountrycode_ID() {
		return countrycode_ID;
	}

	public void setCountrycode_ID(String countrycode_ID) {
		this.countrycode_ID = countrycode_ID;
	}

	public String getState_ID() {
		return state_ID;
	}

	public void setState_ID(String state_ID) {
		this.state_ID = state_ID;
	}

	public int getAddresstype() {
		return addresstype;
	}

	public void setAddresstype(int addresstype) {
		this.addresstype = addresstype;
	}

	@Column(name = "is_permanent")
	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean is_permanent) {
		this.permanent = is_permanent;
	}

	public int getAddress_ID() {
		return Address_ID;
	}

	public void setAddress_ID(int address_ID) {
		Address_ID = address_ID;
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

	public String getAltphone() {
		return altphone;
	}

	public void setAltphone(String altphone) {
		this.altphone = altphone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomephone() {
		return homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPager() {
		return pager;
	}

	public void setPager(String pager) {
		this.pager = pager;
	}

	public String getWorkphone() {
		return workphone;
	}

	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Date getValid_bdate() {
		return valid_bdate;
	}

	public void setValid_bdate(Date valid_bdate) {
		this.valid_bdate = valid_bdate;
	}

	public void setDispvalid_bdate(String s) {
		setValid_bdate(GenericDateUtils.convertToDate(s, get_DATEFORMAT(), null));
	}

	@Transient
	public String getDispvalid_bdate() {
		return GenericDateUtils.formatDate(getValid_bdate(), get_DATEFORMAT(), null, null);
	}

	public Date getValid_edate() {
		return valid_edate;
	}

	public void setValid_edate(Date valid_edate) {
		this.valid_edate = valid_edate;
	}

	public void setDispvalid_edate(String s) {
		setValid_edate(GenericDateUtils.convertToDate(s, get_DATEFORMAT(), null));
	}

	@Transient
	public String getDispvalid_edate() {
		return GenericDateUtils.formatDate(getValid_edate(), get_DATEFORMAT(), null, null);
	}

	@Transient
	public String get_DATEFORMAT() {
		return _DATEFORMAT;
	}

	public void set_DATEFORMAT(String _dateformat) {
		_DATEFORMAT = _dateformat;
	}

	/*@Transient
	public String getState() {
		if (state_ID != null && state_ID.length() > 0) {
			return TracerUtils.getState(state_ID).getState();
		}
		return "";
	}

	@Transient
	public String getCountry() {
		if (countrycode_ID != null && countrycode_ID.length() > 0) {
			return TracerUtils.getCountry(countrycode_ID).getCountry();
		}
		return "";
	}*/

}
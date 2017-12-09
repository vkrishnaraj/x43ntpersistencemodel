package aero.nettracer.persistence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	private int id;
	private String address1;
	private String address2;
	private String city;
	private String stateId;
	private String province;
	private String zip;
	private String hotel;
	private String homePhone;
	private String workPhone;
	private String mobile;
	private String pager;
	private String altPhone;
	private String email;
	private int addressType;
	private Passenger passenger;
	private String countryCode;
	private Date valid_bdate;
	private Date valid_edate;
	private boolean permanent;
	private String normalisedHomePhone;
	private String normalisedWorkPhone;
	private String normalisedMobilePhone;
	private String normalisedPager;
	private String normalisedAlternatePhone;
	private String hotelPhone;

	@Id
	@GeneratedValue
	@Column(name = "address_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "address1")
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "address2")
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state_id")
	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	@Column(name = "province")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "zip")
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column(name = "hotel")
	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	@Column(name = "homephone")
	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	@Column(name = "workphone")
	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	@Column(name = "mobile")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "pager")
	public String getPager() {
		return pager;
	}

	public void setPager(String pager) {
		this.pager = pager;
	}

	@Column(name = "altphone")
	public String getAltPhone() {
		return altPhone;
	}

	public void setAltPhone(String altPhone) {
		this.altPhone = altPhone;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "addresstype")
	public int getAddressType() {
		return addressType;
	}

	public void setAddressType(int addressType) {
		this.addressType = addressType;
	}

	@ManyToOne
	@JoinColumn(name = "passenger_id", nullable = false, updatable = false)
	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	@Column(name = "countrycode_id")
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@Column(name = "valid_bdate")
	public Date getValid_bdate() {
		return valid_bdate;
	}

	public void setValid_bdate(Date valid_bdate) {
		this.valid_bdate = valid_bdate;
	}

	@Column(name = "valid_edate")
	public Date getValid_edate() {
		return valid_edate;
	}

	public void setValid_edate(Date valid_edate) {
		this.valid_edate = valid_edate;
	}

	@Column(name = "is_permanent")
	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	@Column(name = "homephone_norm")
	public String getNormalisedHomePhone() {
		return normalisedHomePhone;
	}

	public void setNormalisedHomePhone(String normalisedHomePhone) {
		this.normalisedHomePhone = normalisedHomePhone;
	}

	@Column(name = "workphone_norm")
	public String getNormalisedWorkPhone() {
		return normalisedWorkPhone;
	}

	public void setNormalisedWorkPhone(String normalisedWorkPhone) {
		this.normalisedWorkPhone = normalisedWorkPhone;
	}

	@Column(name = "mobile_norm")
	public String getNormalisedMobilePhone() {
		return normalisedMobilePhone;
	}

	public void setNormalisedMobilePhone(String normalisedMobilePhone) {
		this.normalisedMobilePhone = normalisedMobilePhone;
	}

	@Column(name = "pager_norm")
	public String getNormalisedPager() {
		return normalisedPager;
	}

	public void setNormalisedPager(String normalisedPager) {
		this.normalisedPager = normalisedPager;
	}

	@Column(name = "altphone_norm")
	public String getNormalisedAlternatePhone() {
		return normalisedAlternatePhone;
	}

	public void setNormalisedAlternatePhone(String normalisedAlternatePhone) {
		this.normalisedAlternatePhone = normalisedAlternatePhone;
	}

	@Column(name = "hotelphone")
	public String getHotelPhone() {
		return hotelPhone;
	}

	public void setHotelPhone(String hotelPhone) {
		this.hotelPhone = hotelPhone;
	}
}
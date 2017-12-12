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
	private String state_ID;
	private String province;
	private String zip;
	private String hotel;
	private String homephone;
	private String workphone;
	private String mobile;
	private String pager;
	private String altphone;
	private String email;
	private int addresstype;
	private Passenger passenger;
	private String countrycode_ID;
	private Date valid_bdate;
	private Date valid_edate;
	private boolean permanent;
	private String homephone_norm;
	private String workphone_norm;
	private String mobile_norm;
	private String pager_norm;
	private String altphone_norm;
	private String hotelphone;

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
	public String getState_ID() {
		return state_ID;
	}

	public void setState_ID(String state_ID) {
		this.state_ID = state_ID;
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
	public String getHomephone() {
		return homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	@Column(name = "workphone")
	public String getWorkphone() {
		return workphone;
	}

	public void setWorkphone(String workphone) {
		this.workphone = workphone;
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
	public String getAltphone() {
		return altphone;
	}

	public void setAltphone(String altphone) {
		this.altphone = altphone;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "addresstype")
	public int getAddresstype() {
		return addresstype;
	}

	public void setAddresstype(int addresstype) {
		this.addresstype = addresstype;
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
	public String getCountrycode_ID() {
		return countrycode_ID;
	}

	public void setCountrycode_ID(String countrycode_ID) {
		this.countrycode_ID = countrycode_ID;
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
	public String getHomephone_norm() {
		return homephone_norm;
	}

	public void setHomephone_norm(String homephone_norm) {
		this.homephone_norm = homephone_norm;
	}

	@Column(name = "workphone_norm")
	public String getWorkphone_norm() {
		return workphone_norm;
	}

	public void setWorkphone_norm(String workphone_norm) {
		this.workphone_norm = workphone_norm;
	}

	@Column(name = "mobile_norm")
	public String getMobile_norm() {
		return mobile_norm;
	}

	public void setMobile_norm(String mobile_norm) {
		this.mobile_norm = mobile_norm;
	}

	@Column(name = "pager_norm")
	public String getPager_norm() {
		return pager_norm;
	}

	public void setPager_norm(String pager_norm) {
		this.pager_norm = pager_norm;
	}

	@Column(name = "altphone_norm")
	public String getAltphone_norm() {
		return altphone_norm;
	}

	public void setAltphone_norm(String altphone_norm) {
		this.altphone_norm = altphone_norm;
	}

	@Column(name = "hotelphone")
	public String getHotelphone() {
		return hotelphone;
	}

	public void setHotelphone(String hotelphone) {
		this.hotelphone = hotelphone;
	}
}
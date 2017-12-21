package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "bdo_passenger")
public class BDO_Passenger {
	
	private int id;
	private BDO bdo;
	private String firstname;
	private String lastname;
	private String middlename;
	private String address1;
	private String address2;
	private String city;
	private String state_ID;
	private String province;
	private String countrycode_ID;
	private String zip;
	private String hotel;
	private String homephone;
	private String workphone;
	private String mobile;
	private String pager;
	private String altphone;
	private String email;
	private Date valid_bdate;
	private Date valid_edate;
	private String hotelphone;

	@Id
	@GeneratedValue
	@Column(name = "bdo_passenger_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "bdo_id")
	public BDO getBdo() {
		return bdo;
	}

	public void setBdo(BDO bdo) {
		this.bdo = bdo;
	}

	@Column(name = "firstname")
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "middlename")
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "lastname")
	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
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

	@Column(name = "countrycode_id")
	public String getCountrycode_ID() {
		return countrycode_ID;
	}

	public void setCountrycode_ID(String countrycode_ID) {
		this.countrycode_ID = countrycode_ID;
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

	@Column(name = "valid_bdate")
	@Temporal(TemporalType.DATE)
	public Date getValid_bdate() {
		return valid_bdate;
	}

	public void setValid_bdate(Date valid_bdate) {
		this.valid_bdate = valid_bdate;
	}

	@Column(name = "valid_edate")
	@Temporal(TemporalType.DATE)
	public Date getValid_edate() {
		return valid_edate;
	}

	public void setValid_edate(Date valid_edate) {
		this.valid_edate = valid_edate;
	}

	@Column(name = "hotelphone")
	public String getHotelphone() {
		return hotelphone;
	}

	public void setHotelphone(String hotelphone) {
		this.hotelphone = hotelphone;
	}
}
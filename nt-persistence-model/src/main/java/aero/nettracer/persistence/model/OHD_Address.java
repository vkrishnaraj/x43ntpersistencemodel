package aero.nettracer.persistence.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ohd_address")
public class OHD_Address {
	
	private int id;
	private String address1 = "";
	private String address2 = "";
	private String city = "";
	private String state_ID = "";
	private String province = "";
	private String zip = "";
	private String homephone = "";
	private String workphone = "";
	private String mobile = "";
	private String pager = "";
	private String altphone = "";
	private String email = "";
	private int addresstype;
	private String countrycode_ID = "";
	private OHD_Passenger ohd_passenger;

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

	@Column(name = "countrycode_id")

	public String getCountrycode_ID() {
		return countrycode_ID;
	}

	public void setCountrycode_ID(String countrycode_ID) {
		this.countrycode_ID = countrycode_ID;
	}

	@ManyToOne
	@JoinColumn(name = "passenger_id")
	public OHD_Passenger getOhd_passenger() {
		return ohd_passenger;
	}

	public void setOhd_passenger(OHD_Passenger ohd_passenger) {
		this.ohd_passenger = ohd_passenger;
	}

}
package aero.nettracer.persistence.model.audit;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Audit_OHD_Address")
public class Audit_OHD_Address implements Serializable {
	private int id;
	private int Address_ID;
	private String address1 = "";
	private String address2 = "";
	private String zip = "";
	private String homephone = "";
	private String workphone = "";
	private String mobile = "";
	private String pager = "";
	private String city = "";
	private String altphone = "";
	private String email = "";
	private int addresstype;
	private String state_ID = "";
	private String countrycode_ID = "";
	private String province = "";
	
	private Audit_OHD_Passenger audit_ohd_passenger;


	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "audit_ohd_passenger_id")
	public Audit_OHD_Passenger getAudit_ohd_passenger() {
		return audit_ohd_passenger;
	}

	public void setAudit_ohd_passenger(Audit_OHD_Passenger audit_ohd_passenger) {
		this.audit_ohd_passenger = audit_ohd_passenger;
	}

	//NTFIXME
	/*@Transient
	public String getState() {
		if (state_ID != null && state_ID.length() > 0) {
			return TracerUtils.getState(state_ID).getState();
		}
		return "";
	}*/

	//NTFIXME
	/*@Transient
	public String getCountry() {
		if (countrycode_ID != null && countrycode_ID.length() > 0) {
			return TracerUtils.getCountry(countrycode_ID).getCountry();
		}
		return "";
	}*/

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

	//NTFIXME
	/*public boolean equals(Object obj) {
		Audit_OHD_Address aoi = (Audit_OHD_Address) obj;
		boolean ret = true;

		if (AuditOHDUtils.notEqualObjects(aoi.getAddress1(), this.getAddress1())
				|| AuditOHDUtils.notEqualObjects(aoi.getAddress2(), this.getAddress2())
				|| AuditOHDUtils.notEqualObjects(aoi.getZip(), this.getZip())
				|| AuditOHDUtils.notEqualObjects(aoi.getHomephone(), this.getHomephone())
				|| AuditOHDUtils.notEqualObjects(aoi.getWorkphone(), this.getWorkphone())
				|| AuditOHDUtils.notEqualObjects(aoi.getMobile(), this.getMobile())
				|| AuditOHDUtils.notEqualObjects(aoi.getCity(), this.getCity())
				|| AuditOHDUtils.notEqualObjects(aoi.getAltphone(), this.getAltphone())
				|| AuditOHDUtils.notEqualObjects(aoi.getEmail(), this.getEmail())
				|| AuditOHDUtils.notEqualObjects(aoi.getState(), this.getState())
				|| AuditOHDUtils.notEqualObjects(aoi.getCountry(), this.getCountry())
				|| AuditOHDUtils.notEqualObjects(aoi.getProvince(), this.getProvince())) {
			ret = false;
		}
		return ret;
	}*/

}
package aero.nettracer.persistence.model.audit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "audit_passenger")
public class Audit_Passenger implements Serializable {

	private int audit_passenger_id;
	private int Passenger_ID;
	private String jobtitle;
	private int salutation;
	private String firstname;
	private String middlename;
	private String lastname;
	private String driverslicense;
	private String dlstate;
	private String commonnum;
	private String countryofissue;
	private int isprimary;
	private Audit_AirlineMembership audit_membership;
	private Set<Audit_Address> addresses;

	private String driversLicenseProvince;
	private String driversLicenseCountry;

	private String passportNumber;
	private String passportIssuer;

	private Audit_Incident audit_incident;

	@Transient
	public List getAddress_list() {
		return new ArrayList((addresses != null ? addresses : new HashSet()));
	}

	@Id
	@GeneratedValue
	public int getAudit_passenger_id() {
		return audit_passenger_id;
	}

	public void setAudit_passenger_id(int audit_passenger_id) {
		this.audit_passenger_id = audit_passenger_id;
	}

	@ManyToOne
	@JoinColumn(name="audit_incident_id")
	public Audit_Incident getAudit_incident() {
		return audit_incident;
	}

	public void setAudit_incident(Audit_Incident audit_incident) {
		this.audit_incident = audit_incident;
	}

	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "audit_membership_id")
	public Audit_AirlineMembership getAudit_membership() {
		return audit_membership;
	}

	public void setAudit_membership(Audit_AirlineMembership audit_membership) {
		this.audit_membership = audit_membership;
	}

	@OneToMany(mappedBy = "audit_passenger")
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "address_ID")
	public Set<Audit_Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Audit_Address> addresses) {
		this.addresses = addresses;
	}

	public String getCommonnum() {
		return commonnum;
	}

	public void setCommonnum(String commonnum) {
		this.commonnum = commonnum;
	}

	public String getCountryofissue() {
		return countryofissue;
	}

	public void setCountryofissue(String countryofissue) {
		this.countryofissue = countryofissue;
	}

	public String getDlstate() {
		return dlstate;
	}

	public void setDlstate(String dlstate) {
		this.dlstate = dlstate;
	}

	public String getDriverslicense() {
		return driverslicense;
	}

	public void setDriverslicense(String driverslicense) {
		this.driverslicense = driverslicense;
	}

	@Transient
	public String getRedactedDriversLicense() {
		return driverslicense != null && !driverslicense.isEmpty() ? "*********" : "";
	}

	//NTFIXME
	/*@Transient
	public String getDecriptedDriversLicense() {
		try {
			return AES.decrypt(driverslicense);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}*/


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public int getPassenger_ID() {
		return Passenger_ID;
	}

	public void setPassenger_ID(int passenger_ID) {
		Passenger_ID = passenger_ID;
	}

	public int getSalutation() {
		return salutation;
	}

	public void setSalutation(int salutation) {
		this.salutation = salutation;
	}

	public int getIsprimary() {
		return isprimary;
	}

	public void setIsprimary(int isprimary) {
		this.isprimary = isprimary;
	}

	public Audit_Address getAddress(int i) {
		if (this.getAddresses() != null) {
			ArrayList t = new ArrayList(this.getAddresses());
			return (Audit_Address) t.get(i);
		} else return null;
	}

	public void addAddress(Audit_Address address) {
		if (this.getAddresses() == null) this.setAddresses(new LinkedHashSet());
		this.getAddresses().add(address);
	}

	@Column(name = "dlprovince")
	public String getDriversLicenseProvince() {
		return driversLicenseProvince;
	}

	public void setDriversLicenseProvince(String driversLicenseProvince) {
		this.driversLicenseProvince = driversLicenseProvince;
	}

	@Column(name = "dlcountry")
	public String getDriversLicenseCountry() {
		return driversLicenseCountry;
	}

	public void setDriversLicenseCountry(String driversLicenseCountry) {
		this.driversLicenseCountry = driversLicenseCountry;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPassportIssuer() {
		return passportIssuer;
	}

	public void setPassportIssuer(String passportIssuer) {
		this.passportIssuer = passportIssuer;
	}

	@Transient
	public String getRedactedPassportNumber() {
		return passportNumber != null && !passportNumber.isEmpty() ? "***************" : "";
	}
	
	public void setRedactedPassportNumber(String redactedPassportNumber) {
		// NOOP for struts
	}

	//NTFIXME
	/*public void setDecryptedPassportNumber(String decryptedPassportNumber) {
		if (decryptedPassportNumber == null || decryptedPassportNumber.isEmpty()) return;
		try {
			this.passportNumber = AES.encrypt(decryptedPassportNumber);
		} catch (Exception e) {
			e.printStackTrace();
			this.passportNumber = null;
		}
	}*/

	//NTFIXME
	/*@Transient
	public String getDecryptedPassportNumber() {
		try {
			return AES.decrypt(passportNumber);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}*/

}
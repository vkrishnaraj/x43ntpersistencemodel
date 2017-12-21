package aero.nettracer.persistence.model;

import aero.nettracer.persistence.util.AES;
import aero.nettracer.persistence.util.Phone;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.OrderBy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "passenger")
public class Passenger {

	//private final Logger log = LoggerFactory.getLogger(getClass());
	private int id;
	private Incident incident;
	private AirlineMembership membership;
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
	private int numRonKitsIssued;
	private String languageKey;
	private String languageFreeFlow;
	private String driversLicenseProvince;
	private String driversLicenseCountry;
	private String passportNumber;
	private String passportIssuer;
	private Set<Address> addresses;

	@Id
	@GeneratedValue
	@Column(name = "passenger_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "incident_id")
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "membership_id")
	public AirlineMembership getMembership() {
		return membership;
	}

	public void setMembership(AirlineMembership membership) {
		this.membership = membership;
	}

	@Column(name = "jobtitle")
	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	@Column(name = "salutation")
	public int getSalutation() {
		return salutation;
	}

	public void setSalutation(int salutation) {
		this.salutation = salutation;
	}

	@Column(name = "firstname")
	public String getFirstname() {
		return (firstname != null) ? firstname.trim() : firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "middlename")
	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	@Column(name = "lastname")
	public String getLastname() {
		return (lastname != null) ? lastname.trim() : lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "driverslicense")
	public String getDriverslicense() {
		return driverslicense;
	}

	public void setDriverslicense(String driverslicense) {
		this.driverslicense = driverslicense;
	}

	@Column(name = "dlstate")
	public String getDlstate() {
		return dlstate;
	}

	public void setDlstate(String dlstate) {
		this.dlstate = dlstate;
	}

	@Column(name = "commonnum")
	public String getCommonnum() {
		return commonnum;
	}

	public void setCommonnum(String commonnum) {
		this.commonnum = commonnum;
	}

	@Column(name = "countryofissue")
	public String getCountryofissue() {
		return countryofissue;
	}

	public void setCountryofissue(String countryofissue) {
		this.countryofissue = countryofissue;
	}

	@Column(name = "isprimary")
	public int getIsprimary() {
		return isprimary;
	}

	public void setIsprimary(int isprimary) {
		this.isprimary = isprimary;
	}

	@Column(name = "numronkitsissued")
	public int getNumRonKitsIssued() {
		return numRonKitsIssued;
	}

	public void setNumRonKitsIssued(int numRonKitsIssued) {
		this.numRonKitsIssued = numRonKitsIssued;
	}

	@Column(name = "languagekey")
	public String getLanguageKey() {
		return languageKey;
	}

	public void setLanguageKey(String languageKey) {
		this.languageKey = languageKey;
	}

	@Column(name = "languagefreeflow")
	public String getLanguageFreeFlow() {
		return languageFreeFlow;
	}

	public void setLanguageFreeFlow(String languageFreeFlow) {
		this.languageFreeFlow = languageFreeFlow;
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

	@Column(name = "passportnumber")
	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	@Column(name = "passportissuer")
	public String getPassportIssuer() {
		return passportIssuer;
	}

	public void setPassportIssuer(String passportIssuer) {
		this.passportIssuer = passportIssuer;
	}

	@OneToMany(mappedBy = "passenger")
	@OrderBy(clause = "address_id")
	public Set <Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}


	@Transient
	public String getAirlinememcompany() {
		String ret = "";
		
		if (membership != null && membership.getCompanycode_ID() != null) {
			ret = membership.getCompanycode_ID();
		}
		
		return ret;
	}

	@Transient
	public String getAirlinememstatus() {
		String ret = "";

		if (membership != null && membership.getMembershipstatus() != null) ret = membership
				.getMembershipstatus();

		return ret;
	}

	@Transient
	public String getAirlinememnumber() {
		String ret = "";

		if (membership != null && membership.getMembershipnum() != null) ret = membership
				.getMembershipnum();

		return ret;
	}

	@Transient
	public String getDecriptedDriversLicense() {
		try {
			return AES.decrypt(driverslicense);
		} catch (Exception e) {
			//log.error("Failed to decrypt DriversLicense = {}", driverslicense, e);
			return "";
		}
	}

	public void setDecriptedDriversLicense(String decriptedDriversLicense) {
		if(StringUtils.isNotBlank(decriptedDriversLicense)) {
			try {
				this.driverslicense = AES.encrypt(decriptedDriversLicense);
			} catch (Exception e) {
				//log.error("Failed to encrypt DriversLicense = {}", decriptedDriversLicense, e);
				this.driverslicense = null;
			}
		}

	}


	@Transient
	public String getSalutationdesc() {
		switch (getSalutation()) {
			case 0: return "Please Select";
			case 1: return "Dr.";
			case 2: return "Mr.";
			case 3: return "Ms.";
			case 4: return "Miss.";
			case 5: return "Mrs.";
			case 6: return "Other";
		}
		return "";
	}

	@Transient
	public String getDispsalutation() {
		return getSalutationdesc();
	}

	
	@Transient
	public Address getAddress(int i) {
		if (this.getAddresses() != null) {
			ArrayList<Address> t = new ArrayList<Address>(this.getAddresses());
			while (t.size() <= i) {
				Address adddd = new Address();
				adddd.setPassenger(this);
				addAddress(adddd);
				t = new ArrayList<Address>(this.getAddresses());
			}
			return (Address) t.get(i);
		} else return null;
	}

	public void addAddress(Address address) {
		if (this.getAddresses() == null) this.setAddresses(new HashSet<Address>());
		this.getAddresses().add(address);
	}

	@Transient
	public String getRedactedDriversLicense() {
		return driverslicense != null && !driverslicense.isEmpty() ? "*********" : "";
	}
	
	public void setRedactedDriversLicense(String redactedDriversLicense) {
		// NOOP for struts
	}

	@Transient
	public String getRedactedPassportNumber() {
		return passportNumber != null && !passportNumber.isEmpty() ? "***************" : "";
	}

	public void setDecryptedPassportNumber(String decryptedPassportNumber) {
		if (decryptedPassportNumber == null || decryptedPassportNumber.isEmpty()) return;
		try {
			this.passportNumber = AES.encrypt(decryptedPassportNumber);
		} catch (Exception e) {
			//log.error("Failed to encrypt PassportNumber = {}", passportNumber, e);
			this.passportNumber = null;
		}
	}

	@Transient
	public String getDecryptedPassportNumber() {
		try {
			return AES.decrypt(passportNumber);
		} catch (Exception e) {
			//log.error("Failed to decrypt PassportNumber = {}", passportNumber, e);
			return null;
		}
	}

	@Transient
	public List<Phone> getPhoneList(){
		ArrayList<Phone> phones = new ArrayList<Phone>();

		if(addresses != null){
			for(Address address:addresses){
				if(address.getAltphone() != null && !address.getAltphone().isEmpty()){
					Phone phone = new Phone();
					phone.setPhoneNumber(address.getAltphone());
					phone.setPhoneType(Phone.PhoneType.ALT);
					phones.add(phone);
				}
				if(address.getHomephone() != null && !address.getHomephone().isEmpty()){
					Phone phone = new Phone();
					phone.setPhoneNumber(address.getHomephone());
					phone.setPhoneType(Phone.PhoneType.HOME);
					phones.add(phone);
				}
				if(address.getHotelphone() != null && !address.getHotelphone().isEmpty()){
					Phone phone = new Phone();
					phone.setPhoneNumber(address.getHotelphone());
					phone.setPhoneType(Phone.PhoneType.HOTEL);
					phones.add(phone);
				}
				if(address.getMobile() != null && !address.getMobile().isEmpty()){
					Phone phone = new Phone();
					phone.setPhoneNumber(address.getMobile());
					phone.setPhoneType(Phone.PhoneType.MOBILE);
					phones.add(phone);
				}
				if(address.getWorkphone() != null && !address.getWorkphone().isEmpty()){
					Phone phone = new Phone();
					phone.setPhoneNumber(address.getWorkphone());
					phone.setPhoneType(Phone.PhoneType.WORK);
					phones.add(phone);
				}
				if(address.getPager() != null && !address.getPager().isEmpty()){
					Phone phone = new Phone();
					phone.setPhoneNumber(address.getPager());
					phone.setPhoneType(Phone.PhoneType.PAGER);
					phones.add(phone);
				}
			}
		}

		return phones;
	}

}
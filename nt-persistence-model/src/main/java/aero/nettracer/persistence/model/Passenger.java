package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import aero.nettracer.persistence.util.AES;
import aero.nettracer.persistence.util.Phone;
import com.cci.utils.parser.ElementNode;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "Passenger")
public class Passenger implements Serializable {
	private static final long serialVersionUID = -5464990122853221369L;

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	private int passengerId;
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
	private AirlineMembership membership;
	private Set<Address> addresses;
	private Incident incident;
	private int numRonKitsIssued;
	private String languageKey;
	private String languageFreeFlow;
	
	private String driversLicenseProvince;
	private String driversLicenseCountry;

	private String passportNumber;
	private String passportIssuer;

	public String toXML() {
		StringBuffer sb = new StringBuffer();

		sb.append("<passenger>");
		sb.append("<Passenger_ID>" + Passenger_ID + "</Passenger_ID>");
		sb.append("<firstname>" + getFirstname() + "</firstname>");
		sb.append("<middlename>" + middlename + "</middlename>");
		sb.append("<lastname>" + getLastname() + "</lastname>");
		sb.append("<isprimary>" + isprimary + "</isprimary>");
		sb.append("<jobtitle>" + jobtitle + "</jobtitle>");
		sb.append("<salutation>" + salutation + "</salutation>");
		sb.append("<driverslicense>" + driverslicense + "</driverslicense>");
		sb.append("<dlstate>" + dlstate + "</dlstate>");
		sb.append("<dlProvince>" + driversLicenseProvince + "</dlstate>");
		sb.append("<dlCountry>" + driversLicenseCountry + "</dlstate>");
		sb.append("<commonnumber>" + commonnum + "</commonnumber>");
		sb.append("<countryofissue>" + countryofissue + "</countryofissue>");
		if (membership == null) {
			sb.append("<airlinemembership></airlinemembership><airlinemembership_company></airlinemembership_company>");
		} else {
			sb.append("<airlinemembership>" + membership.getMembershipnum() + "</airlinemembership>");
			sb.append("<airlinemembership_company>" + membership.getCompanycode_ID()
					+ "</airlinemembership_company>");
		}
		sb.append("<addresses>");
		if (getAddresses() != null && getAddresses().size() > 0) {
			for (@SuppressWarnings("rawtypes")
			Iterator j = getAddresses().iterator(); j.hasNext();) {
				Address addr = (Address) j.next();
				sb.append(addr.toXML());
			}
		}
		sb.append("</addresses>");
		
		sb.append("</passenger>");
		return sb.toString();
	}

	public static Passenger XMLtoObject(ElementNode root) {
		Passenger obj = new Passenger();

		ElementNode child = null;
		AirlineMembership am = new AirlineMembership();
		
		
		for (@SuppressWarnings("rawtypes")
			 ListIterator i = root.get_children().listIterator(); i.hasNext();) {
			child = (ElementNode) i.next();
			if (child.getType().equals("Passenger_ID")) {
				obj.setPassenger_ID(parseInt(child.getTextContents()));
			} else if (child.getType().equals("firstname")) {
				obj.setFirstname(child.getTextContents());
			} else if (child.getType().equals("middlename")) {
				obj.setMiddlename(child.getTextContents());	
			} else if (child.getType().equals("lastname")) {
				obj.setLastname(child.getTextContents());
			} else if (child.getType().equals("isprimary")) {
				obj.setIsprimary(parseInt(child.getTextContents()));	
			} else if (child.getType().equals("jobtitle")) {
				obj.setJobtitle(child.getTextContents());
			} else if (child.getType().equals("salutation")) {
				obj.setSalutation(parseInt(child.getTextContents()));
			} else if (child.getType().equals("driverslicense")) {
				obj.setDriverslicense(child.getTextContents());
			} else if (child.getType().equals("dlstate")) {
				obj.setDlstate(child.getTextContents());
			} else if (child.getType().equals("driversLicenseProvince")) {
				obj.setDriversLicenseProvince(child.getTextContents());
			} else if (child.getType().equals("driversLicenseCountry")) {
				obj.setDriversLicenseCountry(child.getTextContents());
			} else if (child.getType().equals("commonnumber")) {
				obj.setCommonnum(child.getTextContents());
			} else if (child.getType().equals("countryofissue")) {
				obj.setCountryofissue(child.getTextContents());
			} else if (child.getType().equals("airlinemembership")) {
				am.setMembershipnum(child.getTextContents());
			} else if (child.getType().equals("airlinemembership_company")) {
				am.setCompanycode_ID(child.getTextContents());
			} else if (child.getType().equals("addresses")) {
				ArrayList<Address> al = new ArrayList<Address>();
				@SuppressWarnings({ "rawtypes" })
				ArrayList c = (ArrayList)child.getChildren();
				for (int z=0;z<c.size();z++) {
					al.add(Address.XMLtoObject((ElementNode)c.get(z)));
				}
				obj.setAddresses(new HashSet<Address>(al));
			}
			obj.setMembership(am);

		}

		return obj;
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

	@ManyToOne
	@JoinColumn(name = "membership_ID")
	@Cascade(CascadeType.ALL)
	public AirlineMembership getMembership() {
		return membership;
	}

	public void setMembership(AirlineMembership membership) {
		this.membership = membership;
	}

	@OneToMany(mappedBy = "passenger",fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "address_ID")
	public Set <Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	@ManyToOne
	@JoinColumn(name = "incident_ID")
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
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

	public String getFirstname() {
		return (firstname != null) ? firstname.trim() : firstname;
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
		return (lastname != null) ? lastname.trim() : lastname;
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
	public String getDecriptedDriversLicense() {
		try {
			return AES.decrypt(driverslicense);
		} catch (Exception e) {
			log.error("Failed to decrypt DriversLicense = {}", driverslicense, e);
			return "";
		}
	}

	public void setDecriptedDriversLicense(String decriptedDriversLicense) {
		if (decriptedDriversLicense == null || decriptedDriversLicense.isEmpty()) return;
		try {
			this.driverslicense = AES.encrypt(decriptedDriversLicense);
		} catch (Exception e) {
			log.error("Failed to encrypt DriversLicense = {}", decriptedDriversLicense, e);
			this.driverslicense = null;
		}
	}

	@Id
	@GeneratedValue
	public int getPassenger_ID() {
		return Passenger_ID;
	}

	public void setPassenger_ID(int passenger_ID) {
		Passenger_ID = passenger_ID;
	}

	public int getSalutation() {
		return salutation;
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

	
	public void setSalutation(int salutation) {
		this.salutation = salutation;
	}

	public int getIsprimary() {
		return isprimary;
	}

	public void setIsprimary(int isprimary) {
		this.isprimary = isprimary;
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

	public int getNumRonKitsIssued() {
		return numRonKitsIssued;
	}

	public void setNumRonKitsIssued(int numRonKitsIssued) {
		this.numRonKitsIssued = numRonKitsIssued;
	}

	public String getLanguageKey() {
		return languageKey;
	}

	public void setLanguageKey(String languageKey) {
		this.languageKey = languageKey;
	}

	public String getLanguageFreeFlow() {
		return languageFreeFlow;
	}

	public void setLanguageFreeFlow(String languageFreeFlow) {
		this.languageFreeFlow = languageFreeFlow;
	}

	@Transient
	public String getRedactedDriversLicense() {
		return driverslicense != null && !driverslicense.isEmpty() ? "*********" : "";
	}
	
	public void setRedactedDriversLicense(String redactedDriversLicense) {
		// NOOP for struts
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

	public void setDecryptedPassportNumber(String decryptedPassportNumber) {
		if (decryptedPassportNumber == null || decryptedPassportNumber.isEmpty()) return;
		try {
			this.passportNumber = AES.encrypt(decryptedPassportNumber);
		} catch (Exception e) {
			log.error("Failed to encrypt PassportNumber = {}", passportNumber, e);
			this.passportNumber = null;
		}
	}

	@Transient
	public String getDecryptedPassportNumber() {
		try {
			return AES.decrypt(passportNumber);
		} catch (Exception e) {
			log.error("Failed to decrypt PassportNumber = {}", passportNumber, e);
			return null;
		}
	}

	//NTFIXME - import aero.nettracer.legacy.persistence.util.Phone;
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

	public static int parseInt(String s) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return 0;
		}
	}
	
}
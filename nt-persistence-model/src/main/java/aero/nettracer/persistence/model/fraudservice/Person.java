package aero.nettracer.persistence.model.fraudservice;

import aero.nettracer.commons.utils.GenericStringUtils;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.apache.commons.codec.language.Soundex;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "person")
public class Person {

	private long id;
	private boolean ccContact;
	private Timestamp dateOfBirth;
	private String description;
	private String driversLicenseCountry;
	private String driversLicenseState;
	private String driversLicenseNumber;
	private String emailAddress;
	private String ffAirline;
	private String ffNumber;
	private String firstName;
	private String firstNameDmp;
	private String firstNameSoundex;
	private String lastName;
	private String lastNameDmp;
	private String lastNameSoundex;
	private String middleName;
	private String passportIssuer;
	private String passportNumber;
	private String socialSecurity;
	private boolean whiteListed;
	private FsClaim claim;
	private FsIncident incident;
	private Reservation reservation;
	private String driversLicenseProvince;
	private Set<Phone> phones;
	private Set<FsAddress> addresses;
	private Person parent;
	private long sortId;

	public Person() {
		this.sortId = System.nanoTime();
	}

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "cccontact")
	public boolean isCcContact() {
		return ccContact;
	}

	public void setCcContact(boolean ccContact) {
		this.ccContact = ccContact;
	}

	@Column(name = "dateofbirth")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Timestamp dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "driverslicensecountry")
	public String getDriversLicenseCountry() {
		return driversLicenseCountry;
	}

	public void setDriversLicenseCountry(String driversLicenseCountry) {
		this.driversLicenseCountry = driversLicenseCountry;
	}

	@Column(name = "driverslicensestate")
	public String getDriversLicenseState() {
		return driversLicenseState;
	}

	public void setDriversLicenseState(String driversLicenseState) {
		this.driversLicenseState = driversLicenseState;
	}

	@Column(name = "driverslicensenumber")
	public String getDriversLicenseNumber() {
		return this.driversLicenseNumber;
	}

	public void setTransferDriversLicenseNumber(String driversLicenseNumber) {
		this.driversLicenseNumber = driversLicenseNumber;
	}

	@Column(name = "emailaddress")
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Column(name = "ffairline")
	public String getFfAirline() {
		return ffAirline;
	}

	public void setFfAirline(String ffAirline) {
		this.ffAirline = ffAirline;
	}

	@Column(name = "ffnumber")
	public String getFfNumber() {
		return ffNumber;
	}

	public void setFfNumber(String ffNumber) {
		this.ffNumber = ffNumber;
	}

	@Column(name = "firstname")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
		try {
			this.setFirstNameSoundex((new Soundex()).encode(firstName));
			this.setFirstNameDmp((new DoubleMetaphone()).encode(firstName));
		} catch (Exception e) {
		}
	}

	@Column(name = "firstnamedmp")
	public String getFirstNameDmp() {
		return firstNameDmp;
	}

	public void setFirstNameDmp(String firstNameDmp) {
		this.firstNameDmp = firstNameDmp;
	}

	@Column(name = "firstnamesoundex")
	public String getFirstNameSoundex() {
		return firstNameSoundex;
	}

	public void setFirstNameSoundex(String firstNameSoundex) {
		this.firstNameSoundex = firstNameSoundex;
	}

	@Column(name = "lastname")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		try {
			this.setLastNameSoundex((new Soundex()).encode(lastName));
			this.setLastNameDmp((new DoubleMetaphone()).encode(lastName));
		} catch (Exception e) {
		}
	}

	@Column(name = "lastnamedmp")
	public String getLastNameDmp() {
		return lastNameDmp;
	}

	public void setLastNameDmp(String lastNameDmp) {
		this.lastNameDmp = lastNameDmp;
	}

	@Column(name = "lastnamesoundex")
	public String getLastNameSoundex() {
		return lastNameSoundex;
	}

	public void setLastNameSoundex(String lastNameSoundex) {
		this.lastNameSoundex = lastNameSoundex;
	}

	@Column(name = "middlename")
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "passportissuer")
	public String getPassportIssuer() {
		return passportIssuer;
	}

	public void setPassportIssuer(String passportIssuer) {
		this.passportIssuer = passportIssuer;
	}

	@Column(name = "passportnumber")
	public String getPassportNumber() {
		return this.passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	@Column(name = "socialsecurity")
	public String getSocialSecurity() {
		return this.socialSecurity;
	}

	public void setSocialSecurity(String socialSecurity) {
		this.socialSecurity = socialSecurity;
	}

	@Column(name = "whitelisted")
	public boolean isWhiteListed() {
		return whiteListed;
	}

	public void setWhiteListed(boolean whiteListed) {
		this.whiteListed = whiteListed;
	}

	@ManyToOne
	@JoinColumn(name = "claim_id")
	public FsClaim getClaim() {
		return claim;
	}

	public void setClaim(FsClaim claim) {
		this.claim = claim;
	}

	@ManyToOne
	@JoinColumn(name = "incident_id")
	public FsIncident getIncident() {
		return incident;
	}

	public void setIncident(FsIncident incident) {
		this.incident = incident;
	}

	@ManyToOne
	@JoinColumn(name = "reservation_id")
	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	@Column(name = "driverslicenseprovince")
	public String getDriversLicenseProvince() {
		return driversLicenseProvince;
	}

	public void setDriversLicenseProvince(String driversLicenseProvince) {
		this.driversLicenseProvince = driversLicenseProvince;
	}

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	public Set<Phone> getPhones() {
		if (phones == null) {
			return new LinkedHashSet<>();
		}
		Set<Phone> temp = new TreeSet<>(new Comparator<Phone>() {
			@Override
			public int compare(Phone o1, Phone o2) {
				return Long.compare(o1.getSortId(), o2.getSortId());
			}
		});
		temp.addAll(phones);
		phones = temp;
		return phones;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	public Set<FsAddress> getAddresses() {
		if (addresses == null) {
			addresses = new LinkedHashSet<>();
		} else {
			Set<FsAddress> temp = new TreeSet<>(new Comparator<FsAddress>() {
				@Override
				public int compare(FsAddress o1, FsAddress o2) {
					return Long.compare(o1.getSortId(), o2.getSortId());
				}
			});
			temp.addAll(addresses);
			addresses = temp;
		}
		return addresses;
	}

	public void setAddresses(Set<FsAddress> addresses) {
		this.addresses = addresses;
	}

	@Transient
	public Person getParent() {
		return parent;
	}

	public void setParent(Person parent) {
		this.parent = parent;
	}

	@Transient
	public long getSortId() {
		return this.sortId;
	}

	public void setSortId(long sortId ) {
		this.sortId = sortId;
	}

	@Transient
	public String getRedactedSocialSecurity() {
		String toReturn = "";
		if (socialSecurity != null && !socialSecurity.isEmpty()) {
			toReturn = "*********";
		}
		return toReturn;
	}

	@Transient
	public String getRedactedDriversLicenseNumber() {
		String toReturn = "";
		if (driversLicenseNumber != null && !driversLicenseNumber.isEmpty()) {
			toReturn = "*********";
		}
		return toReturn;
	}

	public void setDriversLicenseNumber(String driversLicenseNumber) {
		if (driversLicenseNumber != null && driversLicenseNumber.matches("[A-Za-z0-9]{5,15}")) {
			this.driversLicenseNumber = GenericStringUtils.sha1_256(driversLicenseNumber, true);
		} else if (driversLicenseNumber == null || driversLicenseNumber.trim().length() == 0) {
			this.driversLicenseNumber = null;
		}
	}

	@Transient
	public String getRedactedPassportNumber() {
		String toReturn = "";
		if (passportNumber != null && !passportNumber.isEmpty()) {
			toReturn = "***************";
		}
		return toReturn;
	}

	@Transient
	public String getDriversLicenseIssuer() {
		if (this.driversLicenseState != null
				&& this.driversLicenseState.length() > 0) {
			return this.driversLicenseState;
		} else if (this.driversLicenseProvince != null
				&& this.driversLicenseProvince.length() > 0) {
			return this.driversLicenseProvince;
		} else {
			return null;
		}
	}

	@Transient
	public FsAddress getAddress() {
		Set<FsAddress> adds = this.getAddresses();
		if (adds != null && !adds.isEmpty()) {
			return this.getAddresses().toArray(new FsAddress[0])[0];
		}
		return null;
	}

	public void setAddress(FsAddress address) {
		if (addresses == null) {
			addresses = new LinkedHashSet<FsAddress>();
		}

		if (address == null) {
			return;
		} else if (addresses.isEmpty()) {
			addresses.add(address);
		} else {
			for (FsAddress a : addresses) {
				if (a.getId() == address.getId()) {
					addresses.remove(a);
					addresses.add(address);
					break;
				}
			}
		}
	}


	// START PHONE STUFF HERE!!
	@Transient
	public String getHomePhone() {
		return getPhoneNumber(Phone.HOME);
	}

	public void setHomePhone(String homePhone) {
		setPhoneNumber(Phone.HOME, homePhone);
	}

	@Transient
	public String getWorkPhone() {
		return getPhoneNumber(Phone.WORK);
	}

	public void setWorkPhone(String workPhone) {
		setPhoneNumber(Phone.WORK, workPhone);
	}

	@Transient
	public String getMobilePhone() {
		return getPhoneNumber(Phone.MOBILE);
	}

	public void setMobilePhone(String mobilePhone) {
		setPhoneNumber(Phone.MOBILE, mobilePhone);
	}

	@Transient
	public String getPagerPhone() {
		return getPhoneNumber(Phone.PAGER);
	}

	public void setPagerPhone(String pagerPhone) {
		setPhoneNumber(Phone.PAGER, pagerPhone);
	}

	@Transient
	public String getAlternatePhone() {
		return getPhoneNumber(Phone.ALTERNATE);
	}

	public void setAlternatePhone(String alternatePhone) {
		setPhoneNumber(Phone.ALTERNATE, alternatePhone);
	}

	private String getPhoneNumber(int type) {
		return getPhone(type).getPhoneNumber();
	}

	private void setPhoneNumber(int type, String phoneNumber) {
		if (phoneNumber != null && !phoneNumber.isEmpty()) {
			Phone phone = getPhone(type);
			phone.setPhoneNumber(phoneNumber);

			boolean addPhone = true;
			Iterator<Phone> i = getPhones().iterator();
			while (i.hasNext()) {
				if (i.next().getType() == type) {
					addPhone = false;
					break;
				}
			}

			if (addPhone) {
				getPhones().add(phone);
			}
		} else {
			Iterator<Phone> i = getPhones().iterator();
			while (i.hasNext()) {
				if (i.next().getType() == type) {
					i.remove();
					break;
				}
			}
		}
	}

	private Phone getPhone(int type) {

		Phone phone = null;
		Phone candidate = null;
		Iterator<Phone> i = getPhones().iterator();
		while (i.hasNext()) {
			candidate = i.next();
			if (candidate.getType() == type) {
				phone = candidate;
				break;
			}
		}

		if (phone == null) {
			phone = new Phone();
			phone.setPerson(this);
			if (claim != null) {
				phone.setIncident(claim.getIncident());
			}
			phone.setType(type);
		}

		return phone;
	}

	public boolean isEmpty() {
		boolean empty = true;

		if ((firstName != null && !firstName.isEmpty())
				|| (lastName != null && !lastName.isEmpty())
				|| (middleName != null && !middleName.isEmpty())
				|| (socialSecurity != null && !socialSecurity.isEmpty())
				|| (driversLicenseNumber != null && !driversLicenseNumber.isEmpty())
				|| (driversLicenseState != null && !driversLicenseState.isEmpty())
				|| (driversLicenseProvince != null && !driversLicenseProvince.isEmpty())
				|| (passportNumber != null && !passportNumber.isEmpty())
				|| (passportIssuer != null && !passportIssuer.isEmpty())) {
			empty = false;
		}

		if (empty) {
			for (FsAddress a: addresses) {
				empty = a.isEmpty();
				if (!empty) {
					break;
				}
			}
		}

		if (empty) {
			for (Phone p: phones) {
				empty = p.isEmpty();
				if (!empty) {
					break;
				}
			}
		}

		return empty;
	}

	public Person clone() {
		Person clone = new Person();
		clone.setClaim(getClaim());

		clone.setLastName(getLastName());
		clone.setFirstName(getFirstName());
		clone.setMiddleName(getMiddleName());

		clone.setAddresses(new LinkedHashSet<FsAddress>());
		clone.getAddresses().add(new FsAddress());
		clone.getAddress().setPerson(clone);
		clone.getAddress().setAddress1(getAddress().getAddress1());
		clone.getAddress().setAddress2(getAddress().getAddress2());
		clone.getAddress().setCity(getAddress().getCity());
		clone.getAddress().setState(getAddress().getState());
		clone.getAddress().setProvince(getAddress().getProvince());
		clone.getAddress().setCountry(getAddress().getCountry());
		clone.getAddress().setZip(getAddress().getZip());

		clone.setPhones(new LinkedHashSet<Phone>());
		clone.setHomePhone(getHomePhone());
		clone.setMobilePhone(getMobilePhone());
		clone.setAlternatePhone(getAlternatePhone());
		clone.setWorkPhone(getWorkPhone());
		clone.setPagerPhone(getPagerPhone());

		clone.setEmailAddress(getEmailAddress());
		clone.setDriversLicenseNumber(getDriversLicenseNumber());
		clone.setDriversLicenseState(getDriversLicenseState());
		clone.setDriversLicenseProvince(getDriversLicenseProvince());
		clone.setDriversLicenseCountry(getDriversLicenseCountry());
		clone.setPassportNumber(getPassportNumber());
		clone.setPassportIssuer(getPassportIssuer());
		clone.setDateOfBirth(getDateOfBirth());
		clone.setFfAirline(getFfAirline());
		clone.setFfNumber(getFfNumber());

		return clone;
	}
}

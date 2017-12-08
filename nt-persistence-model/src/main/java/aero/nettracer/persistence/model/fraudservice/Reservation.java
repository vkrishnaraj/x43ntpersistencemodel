package aero.nettracer.persistence.model.fraudservice;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import aero.nettracer.persistence.model.fraudservice.detection.Whitelist;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

@Entity
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;

	@OneToOne(targetEntity = FsIncident.class)
	private FsIncident incident;
	private String airline;
	private String recordLocator;
	private Date travelDate;
	private String formOfPayment;
	private String ccType;
	private String ccNumber;
	private String ccNumLastFour;
//	private String ccLName;
//	private String ccFName;
//	private String ccMName;
	private int ccExpMonth;
	private int ccExpYear;

	@OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	@org.hibernate.annotations.OrderBy(clause = "id")
	@Fetch(FetchMode.SELECT)
	private Set<Segment> segments;

	@OneToOne(targetEntity = Whitelist.class, cascade = CascadeType.ALL)
	private Whitelist ccWhitelist;

	@OneToOne(targetEntity = Person.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="purchaser_id")
	private Person purchaser;

	private double ticketAmount;
	private int itinComplexity;
	private int tripLength;
	@OneToOne(targetEntity = PnrData.class, cascade = CascadeType.ALL, mappedBy = "reservation", fetch = FetchType.EAGER)
	private PnrData pnrData;

	@OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	@org.hibernate.annotations.OrderBy(clause = "id")
	@Fetch(FetchMode.SELECT)
	private Set<Person> passengers;

	@OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	@org.hibernate.annotations.OrderBy(clause = "id")
	@Fetch(FetchMode.SELECT)
	private Set<Phone> phones;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public FsIncident getIncident() {
		return incident;
	}

	public void setIncident(FsIncident incident) {
		this.incident = incident;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getRecordLocator() {
		return recordLocator;
	}

	public void setRecordLocator(String recordLocator) {
		this.recordLocator = recordLocator;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public String getFormOfPayment() {
		return formOfPayment;
	}

	public void setFormOfPayment(String formOfPayment) {
		this.formOfPayment = formOfPayment;
	}

	public String getRedactedCcNumber() {
//		String toReturn = "";
//		if ((ccNumber != null && !ccNumber.isEmpty()) || (getCcNumLastFour() != null && !getCcNumLastFour().isEmpty())) {
//			toReturn += "************" + getCcNumLastFour();
//		}
//		return toReturn;
		return getCcNumber();
	}

	public String getCcNumber() {
		return this.ccNumber;
	}

	public void setRedactedCcNumber(String ccNumber) {
		setCcNumber(ccNumber);
	}

	public void setCcNumber(String ccNumber) {
//		if (ccNumber != null && ccNumber.trim().length() > 0 && (ccNumber.matches("[0-9]{4,}"))) {
//			if (ccNumber.length() > 12) {
//				this.ccNumber = StringUtils.sha1_256(ccNumber,true);
//			} else {
//				this.ccNumber = null;
//			}
//			this.setCcNumLastFour(ccNumber.substring(ccNumber.length() - 4));
//		} else if(ccNumber == null || ccNumber.trim().length() == 0){
//			this.ccNumber = null;
//			this.ccNumLastFour = null;
//		}
		this.ccNumber = ccNumber;
	}

	public double getTicketAmount() {
		return ticketAmount;
	}

	public void setTicketAmount(double ticketAmount) {
		this.ticketAmount = ticketAmount;
	}

	public int getItinComplexity() {
		return itinComplexity;
	}

	public void setItinComplexity(int itinComplexity) {
		this.itinComplexity = itinComplexity;
	}

	public int getTripLength() {
		return tripLength;
	}

	public void setTripLength(int tripLength) {
		this.tripLength = tripLength;
	}

	public PnrData getPnrData() {
		return pnrData;
	}

	public void setPnrData(PnrData pnrData) {
		this.pnrData = pnrData;
	}

	public Set<Person> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<Person> passengers) {
		this.passengers = passengers;
	}

	public Set<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

	public Whitelist getCcWhitelist() {
		return ccWhitelist;
	}

	public void setCcWhitelist(Whitelist ccWhitelist) {
		this.ccWhitelist = ccWhitelist;
	}

	public Set<Segment> getSegments() {
		return segments;
	}

	public void setSegments(Set<Segment> segments) {
		this.segments = segments;
	}

	public String getCcType() {
		return ccType;
	}

	public void setCcType(String ccType) {
		this.ccType = ccType;
	}

//	public String getCcLName() {
//		return ccLName;
//	}
//
//	public void setCcLName(String ccLName) {
//		this.ccLName = ccLName;
//	}
//
//	public String getCcFName() {
//		return ccFName;
//	}
//
//	public void setCcFName(String ccFName) {
//		this.ccFName = ccFName;
//	}
//
//	public String getCcMName() {
//		return ccMName;
//	}
//
//	public void setCcMName(String ccMName) {
//		this.ccMName = ccMName;
//	}

	public int getCcExpMonth() {
		return ccExpMonth;
	}

	public void setCcExpMonth(int ccExpMonth) {
		this.ccExpMonth = ccExpMonth;
	}

	public int getCcExpYear() {
		return ccExpYear;
	}

	public void setCcExpYear(int ccExpYear) {
		this.ccExpYear = ccExpYear;
	}

	public String getCcNumLastFour() {
		return ccNumLastFour;
	}

	public void setCcNumLastFour(String ccNumLastFour) {
		this.ccNumLastFour = ccNumLastFour;
	}

	public Person getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(Person purchaser) {
		this.purchaser = purchaser;
	}

	public FsAddress getBillingAddress() {
		if(purchaser == null || purchaser.getAddresses() == null || purchaser.getAddresses().isEmpty()){
			return null;
		}
		return purchaser.getAddresses().toArray(new FsAddress[0])[0];
	}

	public void setBillingAddress(FsAddress billingAddress) {
		if(purchaser == null){
			return;
		}
		if(purchaser != null && purchaser.getAddresses() == null){
			purchaser.setAddresses(new HashSet<FsAddress>());
		}
		purchaser.getAddresses().clear();
		purchaser.getAddresses().add(billingAddress);
	}
}

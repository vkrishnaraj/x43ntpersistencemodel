package aero.nettracer.persistence.model.fraudservice;

import aero.nettracer.persistence.model.fraudservice.detection.Whitelist;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reservation")
public class Reservation {

	private long id;
	private String airline;
	private int ccExpMonth;
	private int ccExpYear;
	private String ccNumLastFour;
	private String ccNumber;
	private String ccType;
	private String formOfPayment;
	private int itinComplexity;
	private String recordLocator;
	private double ticketAmount;
	private Timestamp travelDate;
	private int tripLength;
	private Whitelist ccWhitelist;
	private FsIncident incident;
	private Person purchaser;
	private String ccFName;
	private String ccLName;
	private String ccMName;
	private Set<Segment> segments;
	private PnrData pnrData;
	private Set<Person> passengers;
	private Set<Phone> phones;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "airline")
	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	@Column(name = "ccexpmonth")
	public int getCcExpMonth() {
		return ccExpMonth;
	}

	public void setCcExpMonth(int ccExpMonth) {
		this.ccExpMonth = ccExpMonth;
	}

	@Column(name = "ccexpyear")
	public int getCcExpYear() {
		return ccExpYear;
	}

	public void setCcExpYear(int ccExpYear) {
		this.ccExpYear = ccExpYear;
	}

	@Column(name = "ccnumlastfour")
	public String getCcNumLastFour() {
		return ccNumLastFour;
	}

	public void setCcNumLastFour(String ccNumLastFour) {
		this.ccNumLastFour = ccNumLastFour;
	}

	@Column(name = "ccnumber")
	public String getCcNumber() {
		return this.ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	@Column(name = "cctype")
	public String getCcType() {
		return ccType;
	}

	public void setCcType(String ccType) {
		this.ccType = ccType;
	}

	@Column(name = "formofpayment")
	public String getFormOfPayment() {
		return formOfPayment;
	}

	public void setFormOfPayment(String formOfPayment) {
		this.formOfPayment = formOfPayment;
	}

	@Column(name = "itincomplexity")
	public int getItinComplexity() {
		return itinComplexity;
	}

	public void setItinComplexity(int itinComplexity) {
		this.itinComplexity = itinComplexity;
	}

	@Column(name = "recordlocator")
	public String getRecordLocator() {
		return recordLocator;
	}

	public void setRecordLocator(String recordLocator) {
		this.recordLocator = recordLocator;
	}

	@Column(name = "ticketamount")
	public double getTicketAmount() {
		return ticketAmount;
	}

	public void setTicketAmount(double ticketAmount) {
		this.ticketAmount = ticketAmount;
	}

	@Column(name = "traveldate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Timestamp travelDate) {
		this.travelDate = travelDate;
	}

	@Column(name = "triplength")
	public int getTripLength() {
		return tripLength;
	}

	public void setTripLength(int tripLength) {
		this.tripLength = tripLength;
	}

	@OneToOne(cascade = CascadeType.ALL)
	public Whitelist getCcWhitelist() {
		return ccWhitelist;
	}

	public void setCcWhitelist(Whitelist ccWhitelist) {
		this.ccWhitelist = ccWhitelist;
	}

	@OneToOne
	public FsIncident getIncident() {
		return incident;
	}

	public void setIncident(FsIncident incident) {
		this.incident = incident;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="purchaser_id")
	public Person getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(Person purchaser) {
		this.purchaser = purchaser;
	}

	@Column(name = "ccfname")
	public String getCcFName() {
		return ccFName;
	}

	public void setCcFName(String ccFName) {
		this.ccFName = ccFName;
	}

	@Column(name = "cclname")
	public String getCcLName() {
		return ccLName;
	}

	public void setCcLName(String ccLName) {
		this.ccLName = ccLName;
	}

	@Column(name = "ccmname")
	public String getCcMName() {
		return ccMName;
	}

	public void setCcMName(String ccMName) {
		this.ccMName = ccMName;
	}

	@OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
	@OrderBy(value = "id")
	public Set<Segment> getSegments() {
		return segments;
	}

	public void setSegments(Set<Segment> segments) {
		this.segments = segments;
	}

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "reservation")
	public PnrData getPnrData() {
		return pnrData;
	}

	public void setPnrData(PnrData pnrData) {
		this.pnrData = pnrData;
	}

	@OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
	@OrderBy(value = "id")
	public Set<Person> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<Person> passengers) {
		this.passengers = passengers;
	}

	@OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
	@OrderBy(value = "id")
	public Set<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

	public String getRedactedCcNumber() {
		return getCcNumber();
	}

	public void setRedactedCcNumber(String ccNumber) {
		setCcNumber(ccNumber);
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

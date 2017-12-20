package aero.nettracer.persistence.model.onlineclaims;

import aero.nettracer.commons.utils.CommonsUtils;
import aero.nettracer.persistence.model.Incident;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "oc_claim")
public class OnlineClaim {

	private long id;
	private int attemptToClaimAtArrival;
	private int bagClearCustoms;
	private int baggageReroutedEnRoute;
	private int bagsDelayed;
	private int bagsStillMissing;
	private int bagsTravelWith;
	private String businessName;
	private int chargedForExcessBaggage;
	private String checkedLocation;
	private String comments;
	private String declaredCurrency;
	private int declaredExcessValue;
	private String declaredValue;
	private int differentClaimCheck;
	private String emailAddress;
	private String filedPreviousAirline;
	private int filedPreviousClaim;
	private String filedPreviousClaimant;
	private Date filedPrevoiusDate;
	private String frequentFlierNumber;
	private int haveToRecheck;
	private String lastSawBaggage;
	private String occupation;
	private int passengersTravelingWithYou;
	private int reportedToAnotherAirline;
	private String reroutedAirlineCity;
	private String reroutedReason;
	private String socialSecurity;
	private String status;
	private Timestamp submitDate;
	private int ticketWithAnotherAirline;
	private int tsaInspected;
	private String tsaInspectionLocation;
	private int tsaNotePresent;
	private int wasBagInspected;
	private String whereDidYouFileReport;
	private String whereWasBaggageChecked;
	private Incident incident;
	private OCAddress mailingAddress;
	private OCAddress permanentAddress;
	private String paxClaimAmount;
	private String paxClaimDate;
	private String paxIpAddress;
	private String bagWeight;
	private String paxClaimAmountCurrency;
	private String checkedLocationDescription;
	private String reportedAirline;
	private String reportedCity;
	private String reportedFileNumber;
	private int privateInsurance;
	private String privateInsuranceName;
	private String privateInsuranceAddr;
	private int claimType;
	private Timestamp bagReceivedDate;
	private String foreignCurrencyEmail;
	private int requestForeignCurrency;
	private String reasonForTravel;
	private String lengthOfStay;
	private String ticketNumber;
	private String claimStatus;
	private Set<OCPhone> phone;
	private Set<OCItinerary> itinerary;
	private Set<OCBag> bag;
	private Set<OCMessage> messages;
	private Set<OCFile> file;
	private Set<OCPassenger> passenger;

	@Id
	@GeneratedValue
	@Column(name = "claimid")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "attempttoclaimatarrival")
	public int getAttemptToClaimAtArrival() {
		return attemptToClaimAtArrival;
	}

	public void setAttemptToClaimAtArrival(int attemptToClaimAtArrival) {
		this.attemptToClaimAtArrival = attemptToClaimAtArrival;
	}

	@Column(name = "bagclearcustoms")
	public int getBagClearCustoms() {
		return bagClearCustoms;
	}

	public void setBagClearCustoms(int bagClearCustoms) {
		this.bagClearCustoms = bagClearCustoms;
	}

	@Column(name = "baggagereroutedenroute")
	public int getBaggageReroutedEnRoute() {
		return baggageReroutedEnRoute;
	}

	public void setBaggageReroutedEnRoute(int baggageReroutedEnRoute) {
		this.baggageReroutedEnRoute = baggageReroutedEnRoute;
	}

	@Column(name = "bagsdelayed")
	public int getBagsDelayed() {
		return bagsDelayed;
	}

	public void setBagsDelayed(int bagsDelayed) {
		this.bagsDelayed = bagsDelayed;
	}

	@Column(name = "bagsstillmissing")
	public int getBagsStillMissing() {
		return bagsStillMissing;
	}

	public void setBagsStillMissing(int bagsStillMissing) {
		this.bagsStillMissing = bagsStillMissing;
	}

	@Column(name = "bagstravelwith")
	public int getBagsTravelWith() {
		return bagsTravelWith;
	}

	public void setBagsTravelWith(int bagsTravelWith) {
		this.bagsTravelWith = bagsTravelWith;
	}

	@Column(name = "businessname")
	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	@Column(name = "chargedforexcessbaggage")
	public int getChargedForExcessBaggage() {
		return chargedForExcessBaggage;
	}

	public void setChargedForExcessBaggage(int chargedForExcessBaggage) {
		this.chargedForExcessBaggage = chargedForExcessBaggage;
	}

	@Column(name = "checkedlocation")
	public String getCheckedLocation() {
		return checkedLocation;
	}

	public void setCheckedLocation(String checkedLocation) {
		this.checkedLocation = checkedLocation;
	}

	@Column(name = "comments", length=1500)
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Column(name = "declaredcurrency")
	public String getDeclaredCurrency() {
		return declaredCurrency;
	}

	public void setDeclaredCurrency(String declaredCurrency) {
		this.declaredCurrency = declaredCurrency;
	}

	@Column(name = "declaredexcessvalue")
	public int getDeclaredExcessValue() {
		return declaredExcessValue;
	}

	public void setDeclaredExcessValue(int declaredExcessValue) {
		this.declaredExcessValue = declaredExcessValue;
	}

	@Column(name = "declaredvalue")
	public String getDeclaredValue() {
		return declaredValue;
	}

	public void setDeclaredValue(String declaredValue) {
		this.declaredValue = declaredValue;
	}

	@Column(name = "differentclaimcheck")
	public int getDifferentClaimCheck() {
		return differentClaimCheck;
	}

	public void setDifferentClaimCheck(int differentClaimCheck) {
		this.differentClaimCheck = differentClaimCheck;
	}

	@Column(name = "emailaddress")
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Column(name = "filedpreviousairline")
	public String getFiledPreviousAirline() {
		return filedPreviousAirline;
	}

	public void setFiledPreviousAirline(String filedPreviousAirline) {
		this.filedPreviousAirline = filedPreviousAirline;
	}

	@Column(name = "filedpreviousclaim")
	public int getFiledPreviousClaim() {
		return filedPreviousClaim;
	}

	public void setFiledPreviousClaim(int filedPreviousClaim) {
		this.filedPreviousClaim = filedPreviousClaim;
	}

	@Column(name = "filedpreviousclaimant")
	public String getFiledPreviousClaimant() {
		return filedPreviousClaimant;
	}

	public void setFiledPreviousClaimant(String filedPreviousClaimant) {
		this.filedPreviousClaimant = filedPreviousClaimant;
	}

	@Column(name = "filedprevoiusdate")
	@Temporal(TemporalType.DATE)
	public Date getFiledPrevoiusDate() {
		return filedPrevoiusDate;
	}

	public void setFiledPrevoiusDate(Date filedPrevoiusDate) {
		this.filedPrevoiusDate = filedPrevoiusDate;
	}

	@Column(name = "frequentfliernumber")
	public String getFrequentFlierNumber() {
		return frequentFlierNumber;
	}

	public void setFrequentFlierNumber(String frequentFlierNumber) {
		this.frequentFlierNumber = frequentFlierNumber;
	}

	@Column(name = "havetorecheck")
	public int getHaveToRecheck() {
		return haveToRecheck;
	}

	public void setHaveToRecheck(int haveToRecheck) {
		this.haveToRecheck = haveToRecheck;
	}

	@Column(name = "lastsawbaggage")
	public String getLastSawBaggage() {
		return lastSawBaggage;
	}

	public void setLastSawBaggage(String lastSawBaggage) {
		this.lastSawBaggage = lastSawBaggage;
	}

	@Column(name = "occupation")
	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@Column(name = "passengerstravelingwithyou")
	public int getPassengersTravelingWithYou() {
		return passengersTravelingWithYou;
	}

	public void setPassengersTravelingWithYou(int passengersTravelingWithYou) {
		this.passengersTravelingWithYou = passengersTravelingWithYou;
	}

	@Column(name = "reportedtoanotherairline")
	public int getReportedToAnotherAirline() {
		return reportedToAnotherAirline;
	}

	public void setReportedToAnotherAirline(int reportedToAnotherAirline) {
		this.reportedToAnotherAirline = reportedToAnotherAirline;
	}

	@Column(name = "reroutedairlinecity")
	public String getReroutedAirlineCity() {
		return reroutedAirlineCity;
	}

	public void setReroutedAirlineCity(String reroutedAirlineCity) {
		this.reroutedAirlineCity = reroutedAirlineCity;
	}

	@Column(name = "reroutedreason")
	public String getReroutedReason() {
		return reroutedReason;
	}

	public void setReroutedReason(String reroutedReason) {
		this.reroutedReason = reroutedReason;
	}

	@Column(name = "socialsecurity")
	public String getSocialSecurity() {
		return socialSecurity;
	}

	public void setSocialSecurity(String socialSecurity) {
		this.socialSecurity = socialSecurity;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "submitdate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Timestamp submitDate) {
		this.submitDate = submitDate;
	}

	@Column(name = "ticketwithanotherairline")
	public int getTicketWithAnotherAirline() {
		return ticketWithAnotherAirline;
	}

	public void setTicketWithAnotherAirline(int ticketWithAnotherAirline) {
		this.ticketWithAnotherAirline = ticketWithAnotherAirline;
	}

	@Column(name = "tsainspected")
	public int getTsaInspected() {
		return tsaInspected;
	}

	public void setTsaInspected(int tsaInspected) {
		this.tsaInspected = tsaInspected;
	}

	@Column(name = "tsainspectionlocation")
	public String getTsaInspectionLocation() {
		return tsaInspectionLocation;
	}

	public void setTsaInspectionLocation(String tsaInspectionLocation) {
		this.tsaInspectionLocation = tsaInspectionLocation;
	}

	@Column(name = "tsanotepresent")
	public int getTsaNotePresent() {
		return tsaNotePresent;
	}

	public void setTsaNotePresent(int tsaNotePresent) {
		this.tsaNotePresent = tsaNotePresent;
	}

	@Column(name = "wasbaginspected")
	public int getWasBagInspected() {
		return wasBagInspected;
	}

	public void setWasBagInspected(int wasBagInspected) {
		this.wasBagInspected = wasBagInspected;
	}

	@Column(name = "wheredidyoufilereport")
	public String getWhereDidYouFileReport() {
		return whereDidYouFileReport;
	}

	public void setWhereDidYouFileReport(String whereDidYouFileReport) {
		this.whereDidYouFileReport = whereDidYouFileReport;
	}

	@Column(name = "wherewasbaggagechecked")
	public String getWhereWasBaggageChecked() {
		return whereWasBaggageChecked;
	}

	public void setWhereWasBaggageChecked(String whereWasBaggageChecked) {
		this.whereWasBaggageChecked = whereWasBaggageChecked;
	}

	@ManyToOne
	@JoinColumn(name = "incident_id", nullable = false)
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "mailingaddress_id")
	public OCAddress getMailingAddress() {
		return mailingAddress;
	}

	public void setMailingAddress(OCAddress mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "permanentaddress_id")
	public OCAddress getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(OCAddress permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	@Column(name = "paxclaimamount")
	public String getPaxClaimAmount() {
		return paxClaimAmount;
	}

	public void setPaxClaimAmount(String paxClaimAmount) {
		this.paxClaimAmount = paxClaimAmount;
	}

	@Column(name = "paxclaimdate")
	public String getPaxClaimDate() {
		return paxClaimDate;
	}

	public void setPaxClaimDate(String paxClaimDate) {
		this.paxClaimDate = paxClaimDate;
	}

	@Column(name = "paxipaddress")
	public String getPaxIpAddress() {
		return paxIpAddress;
	}

	public void setPaxIpAddress(String paxIpAddress) {
		this.paxIpAddress = paxIpAddress;
	}

	@Column(name = "bagweight")
	public String getBagWeight() {
		return bagWeight;
	}

	public void setBagWeight(String bagWeight) {
		this.bagWeight = bagWeight;
	}

	@Column(name = "paxclaimamountcurrency")
	public String getPaxClaimAmountCurrency() {
		return paxClaimAmountCurrency;
	}

	public void setPaxClaimAmountCurrency(String paxClaimAmountCurrency) {
		this.paxClaimAmountCurrency = paxClaimAmountCurrency;
	}

	@Column(name = "checkedlocationdescription")
	public String getCheckedLocationDescription() {
		return checkedLocationDescription;
	}

	public void setCheckedLocationDescription(String checkedLocationDescription) {
		this.checkedLocationDescription = checkedLocationDescription;
	}

	@Column(name = "reportedairline")
	public String getReportedAirline() {
		return reportedAirline;
	}

	public void setReportedAirline(String reportedAirline) {
		this.reportedAirline = reportedAirline;
	}

	@Column(name = "reportedcity")
	public String getReportedCity() {
		return reportedCity;
	}

	public void setReportedCity(String reportedCity) {
		this.reportedCity = reportedCity;
	}

	@Column(name = "reportedfilenumber")
	public String getReportedFileNumber() {
		return reportedFileNumber;
	}

	public void setReportedFileNumber(String reportedFileNumber) {
		this.reportedFileNumber = reportedFileNumber;
	}

	@Column(name = "privateinsurance")
	public int getPrivateInsurance() {
		return privateInsurance;
	}

	public void setPrivateInsurance(int privateInsurance) {
		this.privateInsurance = privateInsurance;
	}

	@Column(name = "privateinsurancename")
	public String getPrivateInsuranceName() {
		return privateInsuranceName;
	}

	public void setPrivateInsuranceName(String privateInsuranceName) {
		this.privateInsuranceName = privateInsuranceName;
	}

	@Column(name = "privateinsuranceaddr")
	public String getPrivateInsuranceAddr() {
		return privateInsuranceAddr;
	}

	public void setPrivateInsuranceAddr(String privateInsuranceAddr) {
		this.privateInsuranceAddr = privateInsuranceAddr;
	}

	@Column(name = "claimtype")
	public int getClaimType() {
		return claimType;
	}

	public void setClaimType(int claimType) {
		this.claimType = claimType;
	}

	@Column(name = "bagreceiveddate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getBagReceivedDate() {
		return bagReceivedDate;
	}

	public void setBagReceivedDate(Timestamp bagReceivedDate) {
		this.bagReceivedDate = bagReceivedDate;
	}

	@Column(name = "foreigncurrencyemail")
	public String getForeignCurrencyEmail() {
		return foreignCurrencyEmail;
	}

	public void setForeignCurrencyEmail(String foreignCurrencyEmail) {
		this.foreignCurrencyEmail = foreignCurrencyEmail;
	}

	@Column(name = "requestforeigncurrency")
	public int getRequestForeignCurrency() {
		return requestForeignCurrency;
	}

	public void setRequestForeignCurrency(int requestForeignCurrency) {
		this.requestForeignCurrency = requestForeignCurrency;
	}

	@Column(name = "reasonfortravel")
	public String getReasonForTravel() {
		return reasonForTravel;
	}

	public void setReasonForTravel(String reasonForTravel) {
		this.reasonForTravel = reasonForTravel;
	}

	@Column(name = "lengthofstay")
	public String getLengthOfStay() {
		return lengthOfStay;
	}

	public void setLengthOfStay(String lengthOfStay) {
		this.lengthOfStay = lengthOfStay;
	}

	@Column(name = "ticketnumber")
	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	@Column(name = "claimstatus")
	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	@OneToMany(mappedBy = "claim", cascade=CascadeType.ALL)
	@OrderBy(value = "id")
	public Set<OCPhone> getPhone() {
		return phone;
	}

	public void setPhone(Set<OCPhone> phone) {
		this.phone = phone;
	}

	@OneToMany(mappedBy = "claim", cascade=CascadeType.ALL)
	@OrderBy(value = "id")
	public Set<OCItinerary> getItinerary() {
		return itinerary;
	}

	public void setItinerary(Set<OCItinerary> itinerary) {
		this.itinerary = itinerary;
	}

	@OneToMany(mappedBy = "claim", cascade=CascadeType.ALL)
	@OrderBy(value = "bagId")
	public Set<OCBag> getBag() {
		return bag;
	}

	public void setBag(Set<OCBag> bag) {
		this.bag = bag;
	}

	@OneToMany(mappedBy = "claim", cascade=CascadeType.ALL)
	@OrderBy(value = "id")
	public Set<OCMessage> getMessages() {
		return messages;
	}

	public void setMessages(Set<OCMessage> messages) {
		this.messages = messages;
	}

	@OneToMany(mappedBy = "claim", cascade=CascadeType.ALL)
	@OrderBy(value = "id")
	public Set<OCFile> getFile() {
		return file;
	}

	public void setFile(Set<OCFile> file) {
		this.file = file;
	}

	@OneToMany(mappedBy = "claim", cascade=CascadeType.ALL)
	@OrderBy(value = "id")
	public Set<OCPassenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(Set<OCPassenger> passenger) {
		this.passenger = passenger;
	}

	@Transient
	public boolean isDelayed() {
		return CommonsUtils.isBitSet(getClaimType(), 0);
	}
	
	@Transient
	public boolean isMissing() {
		return CommonsUtils.isBitSet(getClaimType(), 1);
	}
	
	@Transient
	public boolean isDamaged() {
		return CommonsUtils.isBitSet(getClaimType(), 2);
	}
	
	@Transient
	public boolean isInterim() {
		return CommonsUtils.isBitSet(getClaimType(), 3);
	}

}

package aero.nettracer.persistence.model.claims;

import aero.nettracer.persistence.model.Incident;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "z_b6_claim_settlement")
public class ClaimSettlement {

	private long id;
	private String address1;
	private String address2;
	private String businessPhone;
	private String city;
	private String claimAgent;
	private String claimType;
	private String comments;
	private String countryCode_ID;
	private Timestamp dateStatusChange;
	private Timestamp dateTakeover;
	private Timestamp depreciationComplete;
	private Timestamp depreciationDue;
	private String email;
	private String fax;
	private Timestamp firstContact;
	private String firstName;
	private String homePhone;
	private String language;
	private String lastName;
	private String membership;
	private String mobilePhone;
	private String newComment;
	private Timestamp offerDue;
	private Timestamp offerSent;
	private String offerSentVia;
	private String pager;
	private Timestamp pplcDue;
	private Timestamp pplcReceived;
	private Timestamp pplcSent;
	private String pplcVia;
	private String province;
	private Timestamp releaseDue;
	private Timestamp revisitRequested;
	private String revisitedBy;
	private int salutation;
	private Timestamp secondContact;
	private String state_ID;
	private boolean verifyAddress;
	private boolean verifyBagColor;
	private boolean verifyBrand;
	private boolean verifyContents;
	private boolean verifyEmail;
	private boolean verifyFraudCC;
	private boolean verifyFraudName;
	private boolean verifyFraudPhone;
	private boolean verifyPhone;
	private boolean verifyTrace1;
	private boolean verifyTrace2;
	private boolean verifyTrace3;
	private String zip;
	private Incident incident;
	private double overall_weight;
	private List<ClaimSettlementBag> bagList;

	@Id
	@GeneratedValue
	@Column(name = "claimsettlementid")
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	@Column(name = "businessphone")
	public String getBusinessPhone() {
		return businessPhone;
	}

	public void setBusinessPhone(String businessPhone) {
		this.businessPhone = businessPhone;
	}

	@Column(name = "city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "claimagent")
	public String getClaimAgent() {
		return claimAgent;
	}

	public void setClaimAgent(String claimAgent) {
		this.claimAgent = claimAgent;
	}

	@Column(name = "claimType")
	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	@Column(name = "comments")
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Column(name = "countrycode_id")
	public String getCountryCode_ID() {
		return countryCode_ID;
	}

	public void setCountryCode_ID(String countryCode_ID) {
		this.countryCode_ID = countryCode_ID;
	}

	@Column(name = "datestatuschange")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getDateStatusChange() {
		return dateStatusChange;
	}

	public void setDateStatusChange(Timestamp dateStatusChange) {
		this.dateStatusChange = dateStatusChange;
	}

	@Column(name = "datetakeover")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getDateTakeover() {
		return dateTakeover;
	}

	public void setDateTakeover(Timestamp dateTakeover) {
		this.dateTakeover = dateTakeover;
	}

	@Column(name = "depreciationcomplete")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getDepreciationComplete() {
		return depreciationComplete;
	}

	public void setDepreciationComplete(Timestamp depreciationComplete) {
		this.depreciationComplete = depreciationComplete;
	}

	@Column(name = "depreciationdue")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getDepreciationDue() {
		return depreciationDue;
	}

	public void setDepreciationDue(Timestamp depreciationDue) {
		this.depreciationDue = depreciationDue;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "fax")
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "firstcontact")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getFirstContact() {
		return firstContact;
	}

	public void setFirstContact(Timestamp firstContact) {
		this.firstContact = firstContact;
	}

	@Column(name = "firstname")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "homephone")
	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	@Column(name = "language")
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name = "lastname")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "membership")
	public String getMembership() {
		return membership;
	}

	public void setMembership(String membership) {
		this.membership = membership;
	}

	@Column(name = "mobilephone")
	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	@Column(name = "newcomment")
	public String getNewComment() {
		return newComment;
	}

	public void setNewComment(String newComment) {
		this.newComment = newComment;
	}

	@Column(name = "offerdue")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getOfferDue() {
		return offerDue;
	}

	public void setOfferDue(Timestamp offerDue) {
		this.offerDue = offerDue;
	}

	@Column(name = "offersent")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getOfferSent() {
		return offerSent;
	}

	public void setOfferSent(Timestamp offerSent) {
		this.offerSent = offerSent;
	}

	@Column(name = "offersentvia")
	public String getOfferSentVia() {
		return offerSentVia;
	}

	public void setOfferSentVia(String offerSentVia) {
		this.offerSentVia = offerSentVia;
	}

	@Column(name = "pager")
	public String getPager() {
		return pager;
	}

	public void setPager(String pager) {
		this.pager = pager;
	}

	@Column(name = "pplcdue")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getPplcDue() {
		return pplcDue;
	}

	public void setPplcDue(Timestamp pplcDue) {
		this.pplcDue = pplcDue;
	}

	@Column(name = "pplcreceived")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getPplcReceived() {
		return pplcReceived;
	}

	public void setPplcReceived(Timestamp pplcReceived) {
		this.pplcReceived = pplcReceived;
	}

	@Column(name = "pplcsent")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getPplcSent() {
		return pplcSent;
	}

	public void setPplcSent(Timestamp pplcSent) {
		this.pplcSent = pplcSent;
	}

	@Column(name = "pplcvia")
	public String getPplcVia() {
		return pplcVia;
	}

	public void setPplcVia(String pplcVia) {
		this.pplcVia = pplcVia;
	}

	@Column(name = "province")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "releasedue")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getReleaseDue() {
		return releaseDue;
	}

	public void setReleaseDue(Timestamp releaseDue) {
		this.releaseDue = releaseDue;
	}

	@Column(name = "revisitrequested")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getRevisitRequested() {
		return revisitRequested;
	}

	public void setRevisitRequested(Timestamp revisitRequested) {
		this.revisitRequested = revisitRequested;
	}

	@Column(name = "revisitedby")
	public String getRevisitedBy() {
		return revisitedBy;
	}

	public void setRevisitedBy(String revisitedBy) {
		this.revisitedBy = revisitedBy;
	}

	@Column(name = "salutation")
	public int getSalutation() {
		return salutation;
	}

	public void setSalutation(int salutation) {
		this.salutation = salutation;
	}

	@Column(name = "secondcontact")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getSecondContact() {
		return secondContact;
	}

	public void setSecondContact(Timestamp secondContact) {
		this.secondContact = secondContact;
	}

	@Column(name = "state_id")
	public String getState_ID() {
		return state_ID;
	}

	public void setState_ID(String state_ID) {
		this.state_ID = state_ID;
	}

	@Column(name = "verifyaddress")
	public boolean isVerifyAddress() {
		return verifyAddress;
	}

	public void setVerifyAddress(boolean verifyAddress) {
		this.verifyAddress = verifyAddress;
	}

	@Column(name = "verifybagcolor")
	public boolean isVerifyBagColor() {
		return verifyBagColor;
	}

	public void setVerifyBagColor(boolean verifyBagColor) {
		this.verifyBagColor = verifyBagColor;
	}

	@Column(name = "verifybrand")
	public boolean isVerifyBrand() {
		return verifyBrand;
	}

	public void setVerifyBrand(boolean verifyBrand) {
		this.verifyBrand = verifyBrand;
	}

	@Column(name = "verifycontents")
	public boolean isVerifyContents() {
		return verifyContents;
	}

	public void setVerifyContents(boolean verifyContents) {
		this.verifyContents = verifyContents;
	}

	@Column(name = "verifyemail")
	public boolean isVerifyEmail() {
		return verifyEmail;
	}

	public void setVerifyEmail(boolean verifyEmail) {
		this.verifyEmail = verifyEmail;
	}

	@Column(name = "verifyfraudcc")
	public boolean isVerifyFraudCC() {
		return verifyFraudCC;
	}

	public void setVerifyFraudCC(boolean verifyFraudCC) {
		this.verifyFraudCC = verifyFraudCC;
	}

	@Column(name = "verifyfraudname")
	public boolean isVerifyFraudName() {
		return verifyFraudName;
	}

	public void setVerifyFraudName(boolean verifyFraudName) {
		this.verifyFraudName = verifyFraudName;
	}

	@Column(name = "verifyfraudphone")
	public boolean isVerifyFraudPhone() {
		return verifyFraudPhone;
	}

	public void setVerifyFraudPhone(boolean verifyFraudPhone) {
		this.verifyFraudPhone = verifyFraudPhone;
	}

	@Column(name = "verifyphone")
	public boolean isVerifyPhone() {
		return verifyPhone;
	}

	public void setVerifyPhone(boolean verifyPhone) {
		this.verifyPhone = verifyPhone;
	}

	@Column(name = "verifytrace1")
	public boolean isVerifyTrace1() {
		return verifyTrace1;
	}

	public void setVerifyTrace1(boolean verifyTrace1) {
		this.verifyTrace1 = verifyTrace1;
	}

	@Column(name = "verifytrace2")
	public boolean isVerifyTrace2() {
		return verifyTrace2;
	}

	public void setVerifyTrace2(boolean verifyTrace2) {
		this.verifyTrace2 = verifyTrace2;
	}

	@Column(name = "verifyTrace3")
	public boolean isVerifyTrace3() {
		return verifyTrace3;
	}

	public void setVerifyTrace3(boolean verifyTrace3) {
		this.verifyTrace3 = verifyTrace3;
	}

	@Column(name = "zip")
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@ManyToOne
	@JoinColumn(name = "incident_id", nullable = false)
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	@Column(name = "overall_weight")
	public double getOverall_weight() {
		return overall_weight;
	}

	public void setOverall_weight(double overall_weight) {
		this.overall_weight = overall_weight;
	}

	@OneToMany(mappedBy = "claimSettlement", cascade=CascadeType.ALL)
	@OrderColumn(name="position")
	public List<ClaimSettlementBag> getBagList() {
		return bagList;
	}

	public void setBagList(List<ClaimSettlementBag> bagList) {
		this.bagList = bagList;
	}
	
}

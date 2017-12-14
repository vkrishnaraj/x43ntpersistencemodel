package aero.nettracer.persistence.model.claims;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import aero.nettracer.persistence.model.Agent;
import aero.nettracer.persistence.model.Incident;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "z_b6_audit_claim_settlement")
public class AuditClaimSettlement {


	private long id;
	private String address1;
	private String address2;
	private String businessphone;
	private String city;
	private String claimagent;
	private long claimsettlementid;
	private String claimtype;
	private String comments;
	private String countrycode_id;
	private Timestamp datestatuschange;
	private Timestamp datetakeover;
	private Timestamp depreciationcomplete;
	private Timestamp depreciationdue;
	private String email;
	private String fax;
	private Timestamp firstcontact;
	private String firstname;
	private String homephone;
	private String language;
	private String lastname;
	private String membership;
	private String mobilephone;
	private String newcomment;
	private Timestamp offerdue;
	private Timestamp offersent;
	private String offersentvia;
	private String pager;
	private Timestamp pplcdue;
	private Timestamp pplcreceived;
	private Timestamp pplcsent;
	private String pplcvia;
	private String province;
	private String reason_modified;
	private Timestamp releasedue;
	private Timestamp revisitrequested;
	private String revisitedby;
	private int salutation;
	private Timestamp secondcontact;
	private String state_id;
	private Timestamp time_modified;
	private boolean verifyaddress;
	private boolean verifybagcolor;
	private boolean verifybrand;
	private boolean verifycontents;
	private boolean verifyemail;
	private boolean verifyfraudcc;
	private boolean verifyfraudname;
	private boolean verifyfraudphone;
	private boolean verifyphone;
	private boolean verifytrace1;
	private boolean verifytrace2;
	private boolean verifytrace3;
	private String zip;
	private Incident incident;
	private Agent modifyingagent;
	private double overall_weight;
	private List<AuditClaimSettlementBag> auditbaglist;


	@Id
	@GeneratedValue
	@Column(name = "auditClaimSettlementId")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "address1", length = 40)
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "address2", length = 40)
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "businessphone", length = 25)
	public String getBusinessphone() {
		return businessphone;
	}

	public void setBusinessphone(String businessphone) {
		this.businessphone = businessphone;
	}

	@Column(length = 50)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "claimagent", length = 25)
	public String getClaimagent() {
		return claimagent;
	}

	public void setClaimagent(String claimagent) {
		this.claimagent = claimagent;
	}

	@Column(name = "claimsettlementid")
	public long getClaimsettlementid() {
		return claimsettlementid;
	}

	public void setClaimsettlementid(long claimsettlementid) {
		this.claimsettlementid = claimsettlementid;
	}

	@Column(length = 25)
	public String getClaimtype() {
		return claimtype;
	}

	public void setClaimtype(String claimtype) {
		this.claimtype = claimtype;
	}

	@Basic
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Column(length = 2)
	public String getCountrycode_id() {
		return countrycode_id;
	}

	public void setCountrycode_id(String countrycode_id) {
		this.countrycode_id = countrycode_id;
	}

	@Basic
	public Timestamp getDatestatuschange() {
		return datestatuschange;
	}

	public void setDatestatuschange(Timestamp dateStatusChange) {
		this.datestatuschange = dateStatusChange;
	}

	@Basic
	public Timestamp getDatetakeover() {
		return datetakeover;
	}

	public void setDatetakeover(Timestamp dateTakeover) {
		this.datetakeover = dateTakeover;
	}

	@Basic
	public Timestamp getDepreciationcomplete() {
		return depreciationcomplete;
	}

	public void setDepreciationcomplete(Timestamp depreciationComplete) {
		this.depreciationcomplete = depreciationComplete;
	}

	@Basic
	public Timestamp getDepreciationdue() {
		return depreciationdue;
	}

	public void setDepreciationdue(Timestamp depreciationdue) {
		this.depreciationdue = depreciationdue;
	}

	@Column(length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 25)
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Basic
	public Timestamp getFirstcontact() {
		return firstcontact;
	}

	public void setFirstcontact(Timestamp firstContact) {
		this.firstcontact = firstContact;
	}

	@Column(length = 20)
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}

	@Column(length = 25)
	public String getHomephone() {
		return homephone;
	}

	public void setHomephone(String homePhone) {
		this.homephone = homePhone;
	}

	@Column(length = 25)
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(length = 20)
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastName) {
		this.lastname = lastName;
	}

	@Column(length = 20)
	public String getMembership() {
		return membership;
	}

	public void setMembership(String membership) {
		this.membership = membership;
	}

	@Column(length = 25)
	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilePhone) {
		this.mobilephone = mobilePhone;
	}

	@Basic
	public String getNewcomment() {
		return newcomment;
	}

	public void setNewcomment(String newComment) {
		this.newcomment = newComment;
	}

	@Basic
	public Timestamp getOfferdue() {
		return offerdue;
	}

	public void setOfferdue(Timestamp offerDue) {
		this.offerdue = offerDue;
	}

	@Basic
	public Timestamp getOffersent() {
		return offersent;
	}

	public void setOffersent(Timestamp offerSent) {
		this.offersent = offerSent;
	}

	@Column(length = 20)
	public String getOffersentvia() {
		return offersentvia;
	}

	public void setOffersentvia(String offerSentVia) {
		this.offersentvia = offerSentVia;
	}

	@Column(length = 25)
	public String getPager() {
		return pager;
	}

	public void setPager(String pager) {
		this.pager = pager;
	}

	@Basic
	public Timestamp getPplcdue() {
		return pplcdue;
	}

	public void setPplcdue(Timestamp pplcDue) {
		this.pplcdue = pplcDue;
	}

	@Basic
	public Timestamp getPplcreceived() {
		return pplcreceived;
	}

	public void setPplcreceived(Timestamp pplcReceived) {
		this.pplcreceived = pplcReceived;
	}

	@Column(name = "pplcSent")
	public Timestamp getPplcsent() {
		return pplcsent;
	}

	public void setPplcsent(Timestamp pplcSent) {
		this.pplcsent = pplcSent;
	}

	@Column(length = 20)
	public String getPplcvia() {
		return pplcvia;
	}

	public void setPplcvia(String pplcVia) {
		this.pplcvia = pplcVia;
	}

	@Column(length = 100)
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getReason_modified() {
		return reason_modified;
	}

	public void setReason_modified(String reason_modified) {
		this.reason_modified = reason_modified;
	}

	@Basic
	public Timestamp getReleasedue() {
		return releasedue;
	}

	public void setReleasedue(Timestamp releaseDue) {
		this.releasedue = releaseDue;
	}

	@Column(name = "revisitrequested")
	public Timestamp getRevisitrequested() {
		return revisitrequested;
	}

	public void setRevisitrequested(Timestamp revisitRequested) {
		this.revisitrequested = revisitRequested;
	}

	@Column(length = 20)
	public String getRevisitedby() {
		return revisitedby;
	}

	public void setRevisitedby(String revisitedBy) {
		this.revisitedby = revisitedBy;
	}

	@Basic
	public int getSalutation() {
		return salutation;
	}

	public void setSalutation(int salutation) {
		this.salutation = salutation;
	}

	@Column(name = "secondContact")
	public Timestamp getSecondcontact() {
		return secondcontact;
	}

	public void setSecondcontact(Timestamp secondContact) {
		this.secondcontact = secondContact;
	}

	@Column(length = 2)
	public String getState_id() {
		return state_id;
	}

	public void setState_id(String state_ID) {
		this.state_id = state_ID;
	}

	public Timestamp getTime_modified() {
		return time_modified;
	}

	public void setTime_modified(Timestamp time_modified) {
		this.time_modified = time_modified;
	}

	@Basic
	public boolean isVerifyaddress() {
		return verifyaddress;
	}

	public void setVerifyaddress(boolean verifyAddress) {
		this.verifyaddress = verifyAddress;
	}

	@Basic
	public boolean isVerifybagcolor() {
		return verifybagcolor;
	}

	public void setVerifyBagColor(boolean verifyBagColor) {
		this.verifybagcolor = verifyBagColor;
	}

	@Basic
	public boolean isVerifybrand() {
		return verifybrand;
	}

	public void setVerifybrand(boolean verifybrand) {
		this.verifybrand = verifybrand;
	}

	@Basic
	public boolean isVerifycontents() {
		return verifycontents;
	}

	public void setVerifycontents(boolean verifyContents) {
		this.verifycontents = verifyContents;
	}

	@Basic
	public boolean isVerifyemail() {
		return verifyemail;
	}

	public void setVerifyemail(boolean verifyEmail) {
		this.verifyemail = verifyEmail;
	}

	@Basic
	public boolean isVerifyfraudcc() {
		return verifyfraudcc;
	}

	public void setVerifyfraudcc(boolean verifyFraudCC) {
		this.verifyfraudcc = verifyFraudCC;
	}

	@Basic
	public boolean isVerifyfraudname() {
		return verifyfraudname;
	}

	public void setVerifyfraudname(boolean verifyFraudName) {
		this.verifyfraudname = verifyFraudName;
	}

	@Basic
	public boolean isVerifyfraudphone() {
		return verifyfraudphone;
	}

	public void setVerifyfraudphone(boolean verifyFraudPhone) {
		this.verifyfraudphone = verifyFraudPhone;
	}

	@Basic
	public boolean isVerifyphone() {
		return verifyphone;
	}

	public void setVerifyphone(boolean verifyPhone) {
		this.verifyphone = verifyPhone;
	}

	@Basic
	public boolean isVerifytrace1() {
		return verifytrace1;
	}

	public void setVerifytrace1(boolean verifyTrace1) {
		this.verifytrace1 = verifyTrace1;
	}

	@Basic
	public boolean isVerifytrace2() {
		return verifytrace2;
	}

	public void setVerifytrace2(boolean verifyTrace2) {
		this.verifytrace2 = verifyTrace2;
	}

	@Basic
	public boolean isVerifytrace3() {
		return verifytrace3;
	}

	public void setVerifytrace3(boolean verifytrace3) {
		this.verifytrace3 = verifytrace3;
	}

	@Column(length = 11)
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@ManyToOne(targetEntity = Incident.class)
	@JoinColumn(name = "incident_id", nullable = false)
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	@ManyToOne(targetEntity = Agent.class)
	@JoinColumn(name = "modifyingAgent", nullable = false)
	public Agent getModifyingagent() {
		return modifyingagent;
	}

	public void setModifyingagent(Agent modifyingAgent) {
		this.modifyingagent = modifyingAgent;
	}

	@Basic
	public double getOverall_weight() {
		return overall_weight;
	}

	public void setOverall_weight(double overall_weight) {
		this.overall_weight = overall_weight;
	}

	@OneToMany(mappedBy = "auditClaimSettlement", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@IndexColumn(name = "position")
	@Fetch(FetchMode.SELECT)
	public List<AuditClaimSettlementBag> getAuditbaglist() {
		return auditbaglist;
	}

	public void setAuditbaglist(List<AuditClaimSettlementBag> auditBagList) {
		this.auditbaglist = auditBagList;
	}

}

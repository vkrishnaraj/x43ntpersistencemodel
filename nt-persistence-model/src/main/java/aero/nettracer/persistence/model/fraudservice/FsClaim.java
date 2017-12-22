package aero.nettracer.persistence.model.fraudservice;

import aero.nettracer.commons.utils.GenericDateUtils;
import aero.nettracer.persistence.model.Agent;
import aero.nettracer.persistence.model.fraudservice.detection.Blacklist;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "fsclaim")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="subclass_type", discriminatorType = DiscriminatorType.STRING, length=16)
public class FsClaim {

	@Id
	@GeneratedValue
	protected long id;
	@Column(name="company_code")
	protected String companyCode;
	protected String airlineClaimId;
	protected double amountClaimed;
	protected String amountClaimedCurrency;
	protected double amountPaid;
	protected Timestamp claimDate;
	protected int claimProrateId;
	protected int claimType;
	protected boolean denied;
	protected int fraudStatus; // 0=unknown, 1 = believed fraud, 2=known fraud
	protected String ntIncidentId;
	protected String privateReasonForDenial;
	protected String publicReasonForDenial;
	protected int statusId;
	protected Timestamp travelDate;
	private Blacklist blacklist;
	protected File file;
	private FsIncident incident;
	protected String amountPaidCurrency;
	protected String claimRemark;
	protected Agent createagent;
	protected double totalLiability;
	protected double excessValueAmt;
	protected boolean ix;
	protected boolean carryon;
	protected String claimCheck;
	protected int fraudstatusId;
	private Set<Attachment> attachments;
	private Set<Person> claimants;
	private Set<Segment> segments;
	private Set<FsReceipt> receipts;
	private Set<FsIPAddress> ipAddresses;
	private Set<Phone> phones;
	protected Person claimant = null;
	private long remoteClaimId;
	protected String createagentname;

	public FsClaim() {

	}

	public FsClaim(long id){
		this.id = id;
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

	@Column(name = "company_code")
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	@Column(name = "airlineclaimid")
	public String getAirlineClaimId() {
		return airlineClaimId;
	}

	public void setAirlineClaimId(String airlineClaimId) {
		this.airlineClaimId = airlineClaimId;
	}

	@Column(name = "amountclaimed")
	public double getAmountClaimed() {
		return amountClaimed;
	}

	public void setAmountClaimed(double amountClaimed) {
		this.amountClaimed = amountClaimed;
	}

	@Column(name = "amountclaimedcurrency")
	public String getAmountClaimedCurrency() {
		return amountClaimedCurrency;
	}

	public void setAmountClaimedCurrency(String amountClaimedCurrency) {
		this.amountClaimedCurrency = amountClaimedCurrency;
	}

	@Column(name = "amountpaid")
	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	@Column(name = "claimdate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(Timestamp claimDate) {
		this.claimDate = claimDate;
	}

	@Column(name = "claimprorateid")
	public int getClaimProrateId() {
		return claimProrateId;
	}

	public void setClaimProrateId(int claimProrateId) {
		this.claimProrateId = claimProrateId;
	}

	@Column(name = "claimtype")
	public int getClaimType() {
		return claimType;
	}

	public void setClaimType(int claimType) {
		this.claimType = claimType;
	}

	@Column(name = "denied")
	public boolean isDenied() {
		return denied;
	}

	public void setDenied(boolean denied) {
		this.denied = denied;
	}

	@Column(name = "fraudstatus")
	public int getFraudStatus() {
		return fraudStatus;
	}

	public void setFraudStatus(int fraudStatus) {
		this.fraudStatus = fraudStatus;
	}

	@Column(name = "ntIncidentId")
	public String getNtIncidentId() {
		return ntIncidentId;
	}

	public void setNtIncidentId(String ntIncidentId) {
		this.ntIncidentId = ntIncidentId;
	}

	@Column(name = "privatereasonfordenial")
	public String getPrivateReasonForDenial() {
		return privateReasonForDenial;
	}

	public void setPrivateReasonForDenial(String privateReasonForDenial) {
		this.privateReasonForDenial = privateReasonForDenial;
	}

	@Column(name = "publicreasonfordenial")
	public String getPublicReasonForDenial() {
		return publicReasonForDenial;
	}

	public void setPublicReasonForDenial(String publicReasonForDenial) {
		this.publicReasonForDenial = publicReasonForDenial;
	}

	@Column(name = "statusid")
	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	@Column(name = "traveldate")
	public Timestamp getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Timestamp travelDate) {
		this.travelDate = travelDate;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "blacklist_id")
	public Blacklist getBlacklist() {
		return blacklist;
	}

	public void setBlacklist(Blacklist blacklist) {
		this.blacklist = blacklist;
	}

	@ManyToOne
	@JoinColumn(name = "file_id")
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@ManyToOne
	@JoinColumn(name = "incident_id")
	public FsIncident getIncident() {
		return incident;
	}

	public void setIncident(FsIncident incident) {
		this.incident = incident;
	}

	@Column(name = "amountpaidcurrency")
	public String getAmountPaidCurrency() {
		return amountPaidCurrency;
	}

	public void setAmountPaidCurrency(String amountPaidCurrency) {
		this.amountPaidCurrency = amountPaidCurrency;
	}

	@Column(name="claimremark")
	public String getClaimRemark() {
		return claimRemark;
	}

	public void setClaimRemark(String claimRemark) {
		this.claimRemark = claimRemark;
	}

	@ManyToOne
	@JoinColumn(name = "createagent_id", nullable = false)
	public Agent getCreateagent() {
		return createagent;
	}

	public void setCreateagent(Agent createagent) {
		this.createagent = createagent;
	}

	@Column(name = "totalliability")
	public double getTotalLiability(){
		return totalLiability;
	}

	public void setTotalLiability(double totalLiability){
		this.totalLiability=totalLiability;
	}

	@Column(name = "excessvalueamt")
	public double getExcessValueAmt(){
		return excessValueAmt;
	}

	public void setExcessValueAmt(double excessValueAmt){
		this.excessValueAmt=excessValueAmt;
	}

	@Column(name = "ix")
	public boolean isIx(){
		return ix;
	}

	public void setIx(boolean ix){
		this.ix=ix;
	}

	@Column(name = "carryon")
	public boolean isCarryon(){
		return carryon;
	}

	public void setCarryon(boolean carryon){
		this.carryon=carryon;
	}

	@Column(name = "claimcheck")
	public String getClaimCheck(){
		return claimCheck;
	}

	public void setClaimCheck(String claimCheck){
		this.claimCheck=claimCheck;
	}

	@Column(name = "fraudstatusid")
	public int getFraudStatusId() {
		return fraudstatusId;
	}

	public void setFraudStatusId(int statusId) {
		this.fraudstatusId = statusId;
	}

	@OneToMany(mappedBy = "claim", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy(value = "id")
	public Set<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(Set<Attachment> attachments) {
		this.attachments = attachments;
	}

	@OneToMany(mappedBy = "claim", cascade = CascadeType.ALL)
	public Set<Person> getClaimants() {
		if (claimants == null) {
			return new LinkedHashSet();
		}
		Set<Person> temp = new TreeSet<>(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return Long.compare(o1.getSortId(), o2.getSortId());
			}
		});
		temp.addAll(claimants);
		claimants = temp;
		return claimants;
	}

	public void setClaimants(Set<Person> claimants) {
		this.claimants = claimants;
	}

	@OneToMany(mappedBy = "claim", cascade = CascadeType.ALL)
	@OrderBy(value = "id")
	public Set<Segment> getSegments() {
		if (segments == null) {
			return new LinkedHashSet<>();
		}
		return segments;
	}

	public void setSegments(Set<Segment> segments) {
		this.segments = segments;
	}

	@OneToMany(mappedBy = "claim", cascade = CascadeType.ALL)
	@OrderBy(value = "id")
	public Set<FsReceipt> getReceipts() {
		return receipts;
	}

	public void setReceipts(Set<FsReceipt> receipts) {
		this.receipts = receipts;
	}

	@OneToMany(mappedBy = "claim", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy(value = "id")
	public Set<FsIPAddress> getIpAddresses() {
		return ipAddresses;
	}

	public void setIpAddresses(Set<FsIPAddress> ipAddresses) {
		this.ipAddresses = ipAddresses;
	}

	@OneToMany(mappedBy = "claim", cascade = CascadeType.ALL, orphanRemoval = true)
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

	@Transient
	public Person getClaimant() {
		if (claimant == null) {
			claimant = getClaimants().iterator().next();
		}
		return claimant;
	}

	@Transient
	public long getRemoteClaimId() {
		return remoteClaimId;
	}

	public void setRemoteClaimId(long remoteClaimId) {
		this.remoteClaimId = remoteClaimId;
	}

	@Transient
	public String getCreateagentname() {
		if(createagent!=null){
			return createagent.getUsername();
		} else {
			return createagentname;
		}

	}

	public void setCreateagentname(String createagentname) {
		this.createagentname=createagentname;
	}

	@Transient
	public String getDisClaimDate(String dateFormat) {
		return GenericDateUtils.formatDate(getClaimDate(), dateFormat, "", null);
	}

	@Transient
	public String getDisClaimantName() {
		String toReturn = "";
		toReturn += getClaimant().getLastName() + ", " + getClaimant().getFirstName();
		if (getClaimant().getMiddleName() != null && !getClaimant().getMiddleName().isEmpty()) {
			toReturn += ", " + getClaimant().getMiddleName();
		}
		return toReturn;
	}
}

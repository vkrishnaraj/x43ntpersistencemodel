package aero.nettracer.persistence.model.fraudservice;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import aero.nettracer.commons.utils.GenericDateUtils;
import aero.nettracer.persistence.model.Agent;
import aero.nettracer.persistence.model.fraudservice.detection.Blacklist;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Proxy;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="subclass_type", discriminatorType = DiscriminatorType.STRING, length=16)
public class FsClaim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	protected long id;
	protected long swapId;
	protected String airlineClaimId;
	protected String airline;
	protected int claimType;
	protected Date claimDate;
	protected Date travelDate;
	protected double amountClaimed;
	protected String amountClaimedCurrency;
	protected double amountPaid;
	protected String amountPaidCurrency;
	protected int fraudStatus; // 0=unknown, 1 = believed fraud, 2=known fraud
	protected boolean denied;
	protected String privateReasonForDenial;
	protected String publicReasonForDenial;
	protected String ntIncidentId;
	protected int claimProrateId;
	protected int statusId;
	protected int fraudstatusId;
	protected double totalLiability;
	protected double excessValueAmt;
	protected boolean ix;
	protected boolean carryon;
	protected String claimCheck;

	@Column(name="claimRemark",columnDefinition="text")
	protected String claimRemark;

//	@OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OneToMany(mappedBy = "claim", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderBy(clause = "id")
	@Fetch(FetchMode.SELECT)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private Set<Attachment> attachments;

	@Transient
	protected String createagentname;

	@ManyToOne
	@JoinColumn(name = "createagent_id")
	protected Agent createagent;

	@ManyToOne
	@JoinColumn(name = "file_id")
	protected File file;

	//	@OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OneToMany(mappedBy = "claim", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@OrderBy(clause = "id")
	@Fetch(FetchMode.SELECT)

	//TODO IMPORTANT - this annotation is needed by NetTracer, however, cannot be part of the claim_model.jar that NTFS uses.  If you are rebuilding the model jar, this annotation needs to be commented out - Loupas
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)

	private Set<Person> claimants;

	@OneToMany(mappedBy = "claim", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@org.hibernate.annotations.OrderBy(clause = "id")
	@Fetch(FetchMode.SELECT)

	//TODO IMPORTANT - this annotation is needed by NetTracer, however, cannot be part of the claim_model.jar that NTFS uses.  If you are rebuilding the model jar, this annotation needs to be commented out - Loupas
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)

	private Set<Segment> segments;

	@OneToMany(mappedBy = "claim", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@org.hibernate.annotations.OrderBy(clause = "id")
	@Fetch(FetchMode.SELECT)

	//TODO IMPORTANT - this annotation is needed by NetTracer, however, cannot be part of the claim_model.jar that NTFS uses.  If you are rebuilding the model jar, this annotation needs to be commented out - Loupas
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)

	private Set<FsReceipt> receipts;

	@OneToOne(targetEntity = Blacklist.class, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	private Blacklist blacklist;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "incident_id")
	private FsIncident incident;

	@OneToMany(mappedBy = "claim", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@org.hibernate.annotations.OrderBy(clause = "id")
	@Fetch(FetchMode.SELECT)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private Set<FsIPAddress> ipAddresses;

	@OneToMany(mappedBy = "claim", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@org.hibernate.annotations.OrderBy(clause = "id")
	@Fetch(FetchMode.SELECT)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private Set<Phone> phones;

	@Transient
	protected Person claimant = null;

	public FsClaim(long id){
		this.id = id;
	}

	public FsClaim() {
		// TODO Auto-generated constructor stub
	}

	public FsIncident getIncident() {
		return incident;
	}

	public void setIncident(FsIncident incident) {
		this.incident = incident;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return Returns the createagent that created this incident.
	 *
	 */
	@ManyToOne
	@JoinColumn(name = "createagent_id", nullable = false)
	public Agent getCreateagent() {
		return createagent;
	}

	/**
	 * @param createagent
	 *          The createagent to set.
	 */
	public void setCreateagent(Agent createagent) {
		this.createagent = createagent;
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

	public long getSwapId() {
		return swapId;
	}

	public void setSwapId(long swapId) {
		this.swapId = swapId;
	}

	public String getAirlineClaimId() {
		return airlineClaimId;
	}

	public void setAirlineClaimId(String airlineClaimId) {
		this.airlineClaimId = airlineClaimId;
	}


	public String getClaimRemark() {
		return claimRemark;
	}

	public void setClaimRemark(String claimRemark) {
		this.claimRemark = claimRemark;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public int getClaimType() {
		return claimType;
	}

	public void setClaimType(int claimType) {
		this.claimType = claimType;
	}

	public Date getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}

	public double getAmountClaimed() {
		return amountClaimed;
	}

	public void setAmountClaimed(double amountClaimed) {
		this.amountClaimed = amountClaimed;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getAmountPaidCurrency() {
		return amountPaidCurrency;
	}

	public void setAmountPaidCurrency(String amountPaidCurrency) {
		this.amountPaidCurrency = amountPaidCurrency;
	}

	public int getFraudStatus() {
		return fraudStatus;
	}

	public void setFraudStatus(int fraudStatus) {
		this.fraudStatus = fraudStatus;
	}

	public boolean isDenied() {
		return denied;
	}

	public void setDenied(boolean denied) {
		this.denied = denied;
	}

	public String getPrivateReasonForDenial() {
		return privateReasonForDenial;
	}

	public void setPrivateReasonForDenial(String privateReasonForDenial) {
		this.privateReasonForDenial = privateReasonForDenial;
	}

	public String getPublicReasonForDenial() {
		return publicReasonForDenial;
	}

	public void setPublicReasonForDenial(String publicReasonForDenial) {
		this.publicReasonForDenial = publicReasonForDenial;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public Blacklist getBlacklist() {
		return blacklist;
	}

	public void setBlacklist(Blacklist blacklist) {
		this.blacklist = blacklist;
	}

	public Set<Person> getClaimants() {
		if (claimants == null) {
			return new LinkedHashSet<>();
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

	public Set<Segment> getSegments() {
		if (segments == null) {
			return new LinkedHashSet<>();
		}
		return segments;
	}

	public void setSegments(Set<Segment> segments) {
		this.segments = segments;
	}

	public String getAmountClaimedCurrency() {
		return amountClaimedCurrency;
	}

	public void setAmountClaimedCurrency(String amountClaimedCurrency) {
		this.amountClaimedCurrency = amountClaimedCurrency;
	}

	public String getNtIncidentId() {
		return ntIncidentId;
	}

	public void setNtIncidentId(String ntIncidentId) {
		this.ntIncidentId = ntIncidentId;
	}

	public int getClaimProrateId() {
		return claimProrateId;
	}

	public void setClaimProrateId(int claimProrateId) {
		this.claimProrateId = claimProrateId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public int getFraudStatusId() {
		return fraudstatusId;
	}

	public void setFraudStatusId(int statusId) {
		this.fraudstatusId = statusId;
	}
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Set<FsReceipt> getReceipts() {
		return receipts;
	}

	public void setReceipts(Set<FsReceipt> receipts) {
		this.receipts = receipts;
	}

	public Set<FsIPAddress> getIpAddresses() {
		return ipAddresses;
	}

	public void setIpAddresses(Set<FsIPAddress> ipAddresses) {
		this.ipAddresses = ipAddresses;
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

	@Transient
	public Person getClaimant() {
		if (claimant == null) {
			claimant = getClaimants().iterator().next();
		}
		return claimant;
	}

	public Set<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(Set<Attachment> attachments) {
		this.attachments = attachments;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

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

	public double getTotalLiability(){
		return totalLiability;
	}

	public void setTotalLiability(double totalLiability){
		this.totalLiability=totalLiability;
	}

	public double getExcessValueAmt(){
		return excessValueAmt;
	}

	public void setExcessValueAmt(double excessValueAmt){
		this.excessValueAmt=excessValueAmt;
	}

	public void setIx(boolean ix){
		this.ix=ix;
	}

	public boolean isIx(){
		return ix;
	}

	public void setCarryon(boolean carryon){
		this.carryon=carryon;
	}

	public boolean isCarryon(){
		return carryon;
	}

	public String getClaimCheck(){
		return claimCheck;
	}

	public void setClaimCheck(String claimCheck){
		this.claimCheck=claimCheck;
	}
}

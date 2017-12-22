package aero.nettracer.persistence.model;

import aero.nettracer.commons.utils.GenericStringUtils;

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
import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lflost")
public class LFLost implements Cloneable {

	private long id;
	private int agentId;
	private int closeAgentId;
	private String locationStationCode;
	private int statusId;
	private String companyCode;
	private Timestamp openDate;
	private Timestamp closeDate;
	private Timestamp emailSentDate;
	private String remarks;
	private String vantiveNumber;
	private LFShipping shipment;
	private LFItem item;
	private LFPerson client;
	private LFLossInfo lossInfo;
	private boolean email1;
	private boolean email2;
	private boolean email3;
	private boolean email4;
	private boolean email5;
	private String firstName;
	private String middleName;
	private String lastName;
	private boolean foundEmail;
	private String feedback;
	private boolean emailPaymentRemind;
	private List<LFSegment> segments;
	private List<LFRemark> agentRemarks;
	private List<LFFile> files;
	private long lastLoaded;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "agent_id", nullable = false)
	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	@Column(name = "close_agent_id")
	public int getCloseAgentId() {
		return closeAgentId;
	}

	public void setCloseAgentId(int closeAgentId) {
		this.closeAgentId = closeAgentId;
	}

	@Column(name="loc_stn_code")
	public String getLocationStationCode() {
		return locationStationCode;
	}

	public void setLocationStationCode(String locationStationCode) {
		this.locationStationCode = locationStationCode;
	}

	@Column(name = "status_id", nullable = false)
	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	@Column(name="company_code")
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	@Column(name="open_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Timestamp openDate) {
		this.openDate = openDate;
	}

	@Column(name="close_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Timestamp closeDate) {
		this.closeDate = closeDate;
	}

	@Column(name="email_sent_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getEmailSentDate() {
		return emailSentDate;
	}

	public void setEmailSentDate(Timestamp emailSentDate) {
		this.emailSentDate = emailSentDate;
	}

	@Column(name="remarks")
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name="vantive_num")
	public String getVantiveNumber() {
		return vantiveNumber;
	}

	public void setVantiveNumber(String vantiveNumber) {
		this.vantiveNumber = vantiveNumber;
	}

	@OneToOne(cascade = CascadeType.ALL)
	public LFShipping getShipment() {
		return shipment;
	}

	public void setShipment(LFShipping shipment) {
		this.shipment = shipment;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "item_id")
	public LFItem getItem() {
		return item;
	}

	public void setItem(LFItem item) {
		this.item = item;
	}

	@OneToOne(cascade = CascadeType.ALL)
	public LFPerson getClient() {
		return client;
	}

	public void setClient(LFPerson client) {
		this.client = client;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "loss_info_id")
	public LFLossInfo getLossInfo() {
		return lossInfo;
	}

	public void setLossInfo(LFLossInfo lossInfo) {
		this.lossInfo = lossInfo;
	}

	@Column(name="email_1")
	public boolean isEmail1() {
		return email1;
	}

	public void setEmail1(boolean email1) {
		this.email1 = email1;
	}

	@Column(name="email_2")
	public boolean isEmail2() {
		return email2;
	}

	public void setEmail2(boolean email2) {
		this.email2 = email2;
	}

	@Column(name="email_3")
	public boolean isEmail3() {
		return email3;
	}

	public void setEmail3(boolean email3) {
		this.email3 = email3;
	}

	@Column(name="email_4")
	public boolean isEmail4() {
		return email4;
	}

	public void setEmail4(boolean email4) {
		this.email4 = email4;
	}

	@Column(name="email_5")
	public boolean isEmail5() {
		return email5;
	}

	public void setEmail5(boolean email5) {
		this.email5 = email5;
	}

	@Column(name="first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="middle_name")
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name="last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name="found_email")
	public boolean isFoundEmail() {
		return foundEmail;
	}

	public void setFoundEmail(boolean foundEmail) {
		this.foundEmail = foundEmail;
	}

	@Column(name="feedback")
	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Column(name="email_payment_remind")
	public boolean isEmailPaymentRemind() {
		return emailPaymentRemind;
	}

	public void setEmailPaymentRemind(boolean emailPaymentRemind) {
		this.emailPaymentRemind = emailPaymentRemind;
	}

	@OneToMany(mappedBy = "lost", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy(value = "id")
	public List<LFSegment> getSegments() {
		return segments;
	}

	public void setSegments(List<LFSegment> segments) {
		this.segments = segments;
	}

	@OneToMany(mappedBy = "lost", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy(value = "id")
	public List<LFRemark> getAgentRemarks() {
		return agentRemarks;
	}

	public void setAgentRemarks(List<LFRemark> agentRemarks) {
		this.agentRemarks = agentRemarks;
	}

	@OneToMany(mappedBy = "lost", cascade = CascadeType.ALL)
	public List<LFFile> getFiles() {
		return files;
	}

	public void setFiles(List<LFFile> files) {
		this.files = files;
	}

	@Transient
	public long getLastLoaded() {
		return lastLoaded;
	}

	public void setLastLoaded(long lastLoaded) {
		this.lastLoaded = lastLoaded;
	}

	@Transient
	public String getSegmentSQL() {//TODO this should be refactored NT-6064
		ArrayList<String> stations = new ArrayList<String>();
		stations.add(0 + "");
		if (segments != null) {
			for (LFSegment seg: segments) {
				stations.add(seg.getOriginStationCode() + "");
				stations.add(seg.getDestinationStationCode() + "");
			}
		}
		return "('" + GenericStringUtils.join(stations,"','") + "')";
	}

	@Transient //TODO this should be refactored NT-6064
	public boolean isEmail(int notice){
		switch (notice){
		case 1:return isEmail1();
		case 2:return isEmail2();
		case 3:return isEmail3();
		case 4:return isEmail4();
		case 5:return isEmail5();
		default:return false;
		}
	}
	
	@Transient //TODO this should be refactored NT-6064
	public void setEmail(int notice, boolean sent){
		switch (notice){
		case 1:setEmail1(sent);break;
		case 2:setEmail2(sent);break;
		case 3:setEmail3(sent);break;
		case 4:setEmail4(sent);break;
		case 5:setEmail5(sent);break;
		}
	}
	
	@Transient
	public List<LFPhone> getPhones() {
		List<LFPhone> phones = new ArrayList<LFPhone>();
		if (getItem() != null) {
			phones.add(getItem().getPhone());
		}

		if (getClient() != null && getClient().getPhones() != null) {
			phones.addAll(getClient().getPhones());
		}

		return phones;
	}
	
	@Transient
	public boolean hasClient() {
		return getClient() != null;
	}
	
	@Transient
	public boolean hasSegments() {
		return getSegments() != null && !getSegments().isEmpty();
	}

}


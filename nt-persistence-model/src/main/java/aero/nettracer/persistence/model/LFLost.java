package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Proxy;

import aero.nettracer.commons.utils.GenericStringUtils;

@Entity
@Proxy(lazy = false)
public class LFLost implements LFObject, Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7672592006533855019L;
	
	public LFLost() {
		
	}

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "agent_id", nullable = false)
	private int agentId;

	@Column(name = "close_agent_id", nullable = true)
	private int closeAgentId;
	
	@Column(name="loc_stn_code",length = 8)
	private String locationStationCode;

	@Column(name = "status_id", nullable = false)
	private int statusId;
	
	@Column(name="company_code",length = 8)
	private String companyCode;

	@Column(name="open_datetime")
	private Date openDate;

	@Column(name="close_datetime")
	private Date closeDate;

	@Column(name="email_sent_datetime")
	private Date emailSentDate;

	@Column(name="remarks",length = 255)
	private String remarks;
	
	@Column(name="vantive_num",length = 32)
	private String vantiveNumber;
	
	@OneToOne(targetEntity = aero.nettracer.persistence.model.LFShipping.class, cascade = CascadeType.ALL)
	private LFShipping shipment;

	@OneToOne(targetEntity = aero.nettracer.persistence.model.LFPerson.class, cascade = CascadeType.ALL)
	private LFPerson client;

	@OneToOne(targetEntity = aero.nettracer.persistence.model.LFLossInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "loss_info_id")
	private LFLossInfo lossInfo;

	@SuppressWarnings("deprecation")
	@OneToMany(mappedBy = "lost", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderBy(clause = "id")
	@Fetch(FetchMode.SELECT)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<LFSegment> segments;

	@OneToOne(targetEntity = LFItem.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "item_id")
	private LFItem item;
	
	@SuppressWarnings("deprecation")
	@OneToMany(mappedBy = "lost", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderBy(clause = "id")
	@Fetch(FetchMode.SELECT)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<LFRemark> agentRemarks;

	@SuppressWarnings("deprecation")
	@OneToMany(mappedBy = "lost", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<LFFile> files;
	
	@Column(name="email_1")
	private boolean email1;
	
	@Column(name="email_2")
	private boolean email2;
	
	@Column(name="email_3")
	private boolean email3;
	
	@Column(name="email_4")
	private boolean email4;
	
	@Column(name="email_5")
	private boolean email5;

	@Column(name="email_payment_remind")
	private boolean emailPaymentRemind;
	
	@Column(name="first_name",length = 32)
	private String firstName;
	
	@Column(name="middle_name",length = 32)
	private String middleName;
	
	@Column(name="last_name",length = 32)
	private String lastName;
	
	@Column(name="found_email")
	private boolean foundEmail;
	
	@Column(name="feedback",length = 512)
	private String feedback;
	
	@Transient
	private long lastLoaded;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public String getLocationStationCode() {
		return locationStationCode;
	}

	public void setLocationStationCode(String locationStationCode) {
		this.locationStationCode = locationStationCode;
	}
	
	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	
	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public LFPerson getClient() {
		return client;
	}

	public void setClient(LFPerson client) {
		this.client = client;
	}

	public LFShipping getShipment() {
		return shipment;
	}

	public void setShipment(LFShipping shipment) {
		this.shipment = shipment;
	}

	public LFLossInfo getLossInfo() {
		return lossInfo;
	}
	
	public void setLossInfo(LFLossInfo lossInfo) {
		this.lossInfo = lossInfo;
	}

	public Date getEmailSentDate() {
		return emailSentDate;
	}

	public void setEmailSentDate(Date emailSentDate) {
		this.emailSentDate = emailSentDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public LFItem getItem() {
		return item;
	}

	public void setItem(LFItem item) {
		this.item = item;
	}

	public int getCloseAgentId() {
		return closeAgentId;
	}

	public void setCloseAgentId(int closeAgentId) {
		this.closeAgentId = closeAgentId;
	}

	public String getVantiveNumber() {
		return vantiveNumber;
	}

	public void setVantiveNumber(String vantiveNumber) {
		this.vantiveNumber = vantiveNumber;
	}

	public void setAgentRemarks(List<LFRemark> agentRemarks) {
		this.agentRemarks = agentRemarks;
	}

	public List<LFRemark> getAgentRemarks() {
		return agentRemarks;
	}

	public void setEmail1(boolean email1) {
		this.email1 = email1;
	}

	public boolean isEmail1() {
		return email1;
	}

	public void setEmail2(boolean email2) {
		this.email2 = email2;
	}

	public boolean isEmail2() {
		return email2;
	}

	public boolean isEmail3() {
		return email3;
	}

	public void setEmail3(boolean email3) {
		this.email3 = email3;
	}

	public boolean isEmail4() {
		return email4;
	}

	public void setEmail4(boolean email4) {
		this.email4 = email4;
	}

	public boolean isEmail5() {
		return email5;
	}

	public void setEmail5(boolean email5) {
		this.email5 = email5;
	}
	
	public void setFoundEmail(boolean foundEmail) {
		this.foundEmail = foundEmail;
	}

	public boolean isFoundEmail() {
		return foundEmail;
	}

	public void setLastLoaded(long lastLoaded) {
		this.lastLoaded = lastLoaded;
	}

	public long getLastLoaded() {
		return lastLoaded;
	}

	public List<LFSegment> getSegments() {
		return segments;
	}

	public void setSegments(List<LFSegment> segments) {
		this.segments = segments;
	}

	public List<LFFile> getFiles() {
		return files;
	}

	public void setFiles(List<LFFile> files) {
		this.files = files;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
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

	public boolean isEmailPaymentRemind() {
		return emailPaymentRemind;
	}

	public void setEmailPaymentRemind(boolean emailPaymentRemind) {
		this.emailPaymentRemind = emailPaymentRemind;
	}

}


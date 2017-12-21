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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Proxy;


@Entity
@Proxy(lazy = false)
public class LFFound implements LFObject, Serializable {

	private static final long serialVersionUID = 2713442669778194028L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="agreement_num",length = 255)
	private String agreementNumber;
	
	@Column(name="mva_num",length = 32)
	private String mvaNumber;
	
	@Column(name="flight_num",length = 8)
	private String flightNumber;
	
	@Temporal(TemporalType.DATE)
	@Column(name="received_date")
	private Date receivedDate;
	
	@Column(name="found_datetime")
	private Date foundDate;
	
	@Column(name="delivered_datetime")
	private Date deliveredDate;
	
	@Column(name="check_num")
	private int checkNumber;
	
	@Column(name="check_amount")
	private double checkAmount;
	
	@Column(name="hold_for_pickup")
	private boolean holdForPickup;

	@Column(name ="loc_stn_code", length=8,nullable = false)
	private String locationStationCode;

	@Column(name ="hold_stn_code", length=8,nullable = false)
	private String holdingStationCode;
	
	@Column(name = "agent_id", nullable = false)
	private int agentId;
	
	@Column(name = "company_code",length = 3)
	private String companyCode;
	
	@Column(name = "salvage_box_id")
	private String salvageBoxId;
	
	@Column(name = "status_id", nullable = false)
	private int statusId;

	@OneToOne(targetEntity = LFItem.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "item_id")
	private LFItem item;
	
	@OneToOne(targetEntity = LFPerson.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id")
	private LFPerson client;
	
	@Column(name="barcode",length = 128)
	private String barcode;
	
	@SuppressWarnings("deprecation")
	@OneToMany(mappedBy = "found", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderBy(clause = "id")
	@Fetch(FetchMode.SELECT)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<LFRemark> agentRemarks;

	@SuppressWarnings("deprecation")
	@OneToMany(mappedBy = "found", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<LFFile> files;

	@Column(name="item_loc")
	private long itemLocation;
	
	@Column(name="bin_id",length = 8)
	private String binId; 
	
	@ManyToOne
	@JoinColumn(name = "salvage_id", nullable = true)
	@Fetch(FetchMode.SELECT)
	private LFSalvage salvage;
	
	@Column(name="receiptFile_id")
	private long receiptFileId;
	
	@Transient
	private long lastLoaded;
	
	@Column(name="forward_LFC_dateTime")
	private Date forwardLFCDate;
	
	@Column(name="LFC_accept_dateTime")
	private Date LFCacceptDate;

	private String seat;

	private String concourse;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getAgreementNumber() {
		return agreementNumber;
	}

	public void setAgreementNumber(String agreementNumber) {
		this.agreementNumber = agreementNumber;
	}
	
	public String getSalvageBoxId() {
		return salvageBoxId;
	}

	public void setSalvageBoxId(String salvageBoxId) {
		this.salvageBoxId = salvageBoxId;
	}

	public String getMvaNumber() {
		return mvaNumber;
	}

	public void setMvaNumber(String mvaNumber) {
		this.mvaNumber = mvaNumber;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Date getFoundDate() {
		return foundDate;
	}

	public void setFoundDate(Date foundDate) {
		this.foundDate = foundDate;
	}
	
	public LFItem getItem() {
		return item;
	}

	public void setItem(LFItem item) {
		this.item = item;
	}

	public LFPerson getClient() {
		return client;
	}

	public void setClient(LFPerson client) {
		this.client = client;
	}

	@Transient
	public List<LFItem> getItems() {//TODO is this needed???
		//TODO when an item is matched to a found, both the lost item and found item are associated to the LFLost.  
		//This method is to retreive the item associated with the lost.  //TODO this should be refactored NT-6064
		List<LFItem> items = new ArrayList<LFItem>();
		items.add(item);
		return items;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setAgentRemarks(List<LFRemark> agentRemarks) {
		this.agentRemarks = agentRemarks;
	}

	public List<LFRemark> getAgentRemarks() {
		return agentRemarks;
	}

	public long getItemLocation() {
		return itemLocation;
	}

	public void setItemLocation(long itemLocation) {
		this.itemLocation = itemLocation;
	}

	public String getBinId() {
		return binId;
	}

	public void setBinId(String binId) {
		this.binId = binId;
	}
	
	public boolean hasContactInfo() {
		return !client.isEmpty();
	}

	public Date getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	public Date getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(Date deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public int getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(int checkNumber) {
		this.checkNumber = checkNumber;
	}

	public double getCheckAmount() {
		return checkAmount;
	}

	public void setCheckAmount(double checkAmount) {
		this.checkAmount = checkAmount;
	}

	public LFSalvage getSalvage() {
		return salvage;
	}

	public void setSalvage(LFSalvage salvage) {
		this.salvage = salvage;
	}
	
	public void setLastLoaded(long lastLoaded) {
		this.lastLoaded = lastLoaded;
	}

	public long getLastLoaded() {
		return lastLoaded;
	}
	
	public boolean isHoldForPickup() {
		return holdForPickup;
	}
	
	public void setHoldForPickup(boolean holdForPickup) {
		this.holdForPickup = holdForPickup;
	}

	public String getLocationStationCode() {
		return locationStationCode;
	}

	public void setLocationStationCode(String locationStationCode) {
		this.locationStationCode = locationStationCode;
	}

	public String getHoldingStationCode() {
		return holdingStationCode;
	}

	public void setHoldingStationCode(String holdingStationCode) {
		this.holdingStationCode = holdingStationCode;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	
	public long getReceiptFileId() {
		return receiptFileId;
	}

	public void setReceiptFileId(long receiptFileId) {
		this.receiptFileId = receiptFileId;
	}
	
	public Date getForwardLFCDate() {
		return forwardLFCDate;
	}

	public void setForwardLFCDate(Date forwardLFCDate) {
		this.forwardLFCDate = forwardLFCDate;
	}
	
	public Date getLFCacceptDate() {
		return LFCacceptDate;
	}

	public void setLFCacceptDate(Date lFCacceptDate) {
		LFCacceptDate = lFCacceptDate;
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

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getConcourse() {
		return concourse;
	}

	public void setConcourse(String concourse) {
		this.concourse = concourse;
	}

	public List<LFFile> getFiles() {
		return files;
	}

	public void setFiles(List<LFFile> files) {
		this.files = files;
	}
}

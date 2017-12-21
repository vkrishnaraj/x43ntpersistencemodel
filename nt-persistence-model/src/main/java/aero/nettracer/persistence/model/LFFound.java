package aero.nettracer.persistence.model;

import org.hibernate.annotations.OrderBy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "lffound")
public class LFFound {

	private long id;
	private String agreementNumber;
	private String mvaNumber;
	private String flightNumber;
	private Date receivedDate;
	private Timestamp foundDate;
	private Timestamp deliveredDate;
	private Timestamp forwardLFCDate;
	private Timestamp LFCacceptDate;
	private int checkNumber;
	private double checkAmount;
	private boolean holdForPickup;
	private String locationStationCode;
	private String holdingStationCode;
	private int agentId;
	private String companyCode;
	private String salvageBoxId;
	private int statusId;
	private LFItem item;
	private LFPerson client;
	private String barcode;
	private long itemLocation;
	private String binId;
	private LFSalvage salvage;
	private long receiptFileId;
	private String seat;
	private String concourse;
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

	@Column(name="agreement_num")
	public String getAgreementNumber() {
		return agreementNumber;
	}

	public void setAgreementNumber(String agreementNumber) {
		this.agreementNumber = agreementNumber;
	}

	@Column(name="mva_num")
	public String getMvaNumber() {
		return mvaNumber;
	}

	public void setMvaNumber(String mvaNumber) {
		this.mvaNumber = mvaNumber;
	}

	@Column(name="flight_num")
	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="received_date")
	public Date getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	@Column(name="found_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getFoundDate() {
		return foundDate;
	}

	public void setFoundDate(Timestamp foundDate) {
		this.foundDate = foundDate;
	}

	@Column(name="delivered_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(Timestamp deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	@Column(name="forward_lfc_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getForwardLFCDate() {
		return forwardLFCDate;
	}

	public void setForwardLFCDate(Timestamp forwardLFCDate) {
		this.forwardLFCDate = forwardLFCDate;
	}

	@Column(name="lfc_accept_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getLFCacceptDate() {
		return LFCacceptDate;
	}

	public void setLFCacceptDate(Timestamp lFCacceptDate) {
		LFCacceptDate = lFCacceptDate;
	}

	@Column(name="check_num")
	public int getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(int checkNumber) {
		this.checkNumber = checkNumber;
	}

	@Column(name="check_amount")
	public double getCheckAmount() {
		return checkAmount;
	}

	public void setCheckAmount(double checkAmount) {
		this.checkAmount = checkAmount;
	}

	@Column(name="hold_for_pickup")
	public boolean isHoldForPickup() {
		return holdForPickup;
	}

	public void setHoldForPickup(boolean holdForPickup) {
		this.holdForPickup = holdForPickup;
	}

	@Column(name ="loc_stn_code", nullable = false)
	public String getLocationStationCode() {
		return locationStationCode;
	}

	public void setLocationStationCode(String locationStationCode) {
		this.locationStationCode = locationStationCode;
	}

	@Column(name ="hold_stn_code", nullable = false)
	public String getHoldingStationCode() {
		return holdingStationCode;
	}

	public void setHoldingStationCode(String holdingStationCode) {
		this.holdingStationCode = holdingStationCode;
	}

	@Column(name = "agent_id", nullable = false)
	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	@Column(name = "company_code")
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	@Column(name = "salvage_box_id")
	public String getSalvageBoxId() {
		return salvageBoxId;
	}

	public void setSalvageBoxId(String salvageBoxId) {
		this.salvageBoxId = salvageBoxId;
	}

	@Column(name = "status_id", nullable = false)
	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
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
	@JoinColumn(name = "client_id")
	public LFPerson getClient() {
		return client;
	}

	public void setClient(LFPerson client) {
		this.client = client;
	}

	@Column(name="barcode")
	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	@Column(name="item_loc")
	public long getItemLocation() {
		return itemLocation;
	}

	public void setItemLocation(long itemLocation) {
		this.itemLocation = itemLocation;
	}

	@Column(name="bin_id")
	public String getBinId() {
		return binId;
	}

	public void setBinId(String binId) {
		this.binId = binId;
	}

	@ManyToOne
	@JoinColumn(name = "salvage_id")
	public LFSalvage getSalvage() {
		return salvage;
	}

	public void setSalvage(LFSalvage salvage) {
		this.salvage = salvage;
	}

	@Column(name="receiptfile_id")
	public long getReceiptFileId() {
		return receiptFileId;
	}

	public void setReceiptFileId(long receiptFileId) {
		this.receiptFileId = receiptFileId;
	}

	@Column(name = "seat")
	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	@Column(name = "concourse")
	public String getConcourse() {
		return concourse;
	}

	public void setConcourse(String concourse) {
		this.concourse = concourse;
	}

	@OneToMany(mappedBy = "found", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy(clause = "id")
	public List<LFRemark> getAgentRemarks() {
		return agentRemarks;
	}

	public void setAgentRemarks(List<LFRemark> agentRemarks) {
		this.agentRemarks = agentRemarks;
	}

	@OneToMany(mappedBy = "found")
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
	public List<LFItem> getItems() {
		//TODO is this needed???
		//TODO when an item is matched to a found, both the lost item and found item are associated to the LFLost.
		//This method is to retreive the item associated with the lost.  //TODO this should be refactored NT-6064
		List<LFItem> items = new ArrayList<LFItem>();
		items.add(item);
		return items;
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

	public boolean hasContactInfo() {
		return !client.isEmpty();
	}

}

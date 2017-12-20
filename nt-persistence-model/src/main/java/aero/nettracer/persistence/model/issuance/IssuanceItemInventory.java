package aero.nettracer.persistence.model.issuance;

import aero.nettracer.persistence.model.Station;
import aero.nettracer.persistence.model.Status;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;

@Entity
@Table(name="issuance_item_inventory")
public class IssuanceItemInventory {

	private long id;
	private int tradeType;
	private String description;
	private String barcode;
	private Status inventoryStatus;
	private Station station;
	private IssuanceItem issuanceItem;
	private String incidentID;
	private Timestamp issueDate;
	private boolean verifiedIncident;
	private double cost;
	private String firstName;
	private String lastName;
	private String country;
	private String phoneNumber;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String province;
	private String zip;
	private String specialNeedDescription;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "trade_type")
	public int getTradeType() {
		return tradeType;
	}

	public void setTradeType(int tradeType) {
		this.tradeType = tradeType;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "barcode")
	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	@ManyToOne
	@JoinColumn(name = "inventory_status_id")
	public Status getInventoryStatus() {
		return inventoryStatus;
	}

	public void setInventoryStatus(Status inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}

	@ManyToOne
	@JoinColumn(name = "station_id")
	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	@ManyToOne
	@JoinColumn(name = "issuance_item_id")
	public IssuanceItem getIssuanceItem() {
		return issuanceItem;
	}

	public void setIssuanceItem(IssuanceItem issuanceItem) {
		this.issuanceItem = issuanceItem;
	}

	@Column(name="incident_id")
	public String getIncidentID() {
		return incidentID;
	}

	public void setIncidentID(String incidentID) {
		this.incidentID = incidentID;
	}

	@Column(name="issuedate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Timestamp issueDate) {
		this.issueDate = issueDate;
	}

	@Column(name="verified_incident")
	public boolean isVerifiedIncident() {
		return verifiedIncident;
	}

	public void setVerifiedIncident(boolean verifiedIncident) {
		this.verifiedIncident = verifiedIncident;
	}

	@Column(name = "cost")
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Column(name = "firstname")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastname")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "phonenumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	@Column(name = "city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "province")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "zip")
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column(name = "specialneeddescription")
	public String getSpecialNeedDescription() {
		return specialNeedDescription;
	}

	public void setSpecialNeedDescription(String specialNeedDescription) {
		this.specialNeedDescription = specialNeedDescription;
	}

}

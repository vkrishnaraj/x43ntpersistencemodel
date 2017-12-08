package aero.nettracer.persistence.model.issuance;

import java.util.Date;

import aero.nettracer.persistence.model.Agent;
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
import org.hibernate.annotations.Proxy;

@Entity
@Table(name="audit_issuance_item_inventory")
public class AuditIssuanceItemInventory {

	@Id
	@GeneratedValue
	@Column(name="audit_id")
	private long auditID;
	
	private long id;
	
	@Column(name = "trade_type")
	private int tradeType;

	@Column(name = "cost")
	private double cost;

	@Column(length = 100)
	private String description;
	
	@Column(length = 20)
	private String barcode;

	@ManyToOne
	@JoinColumn(name = "inventory_status_id")
	private Status inventoryStatus;
	
	@ManyToOne
	@JoinColumn(name = "station_id")
	private Station station;

	@ManyToOne
	@JoinColumn(name = "issuance_item_id")
	private IssuanceItem issuanceItem;
	
	@Column(name="incident_id", length=13)
	private String incidentID;

	@Column(name="issuedate", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date issueDate;
	
	@Column(length=150)
	private String reason;

	@ManyToOne
	@JoinColumn(name = "editagent_id")
	private Agent editAgent;

	@Column(name="editdate", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date editDate;
	
	@Column(name="verified_incident")
	private boolean verifiedIncident;
	
	@Column(length = 25)
	private String firstName;
	
	@Column(length = 25)
	private String lastName;

	@Column(length = 2)
	private String country;

	@Column(length = 20)
	private String phoneNumber;

	@Column(length = 100)
	private String address1;

	@Column(length = 100)
	private String address2;

	@Column(length = 50)
	private String city;

	@Column(length = 2)
	private String state;

	@Column(length = 20)
	private String province;

	@Column(length = 12)
	private String zip;

	@Column(length = 255)
	private String specialNeedDescription;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public IssuanceItem getIssuanceItem() {
		return issuanceItem;
	}

	public void setIssuanceItem(IssuanceItem issuanceItem) {
		this.issuanceItem = issuanceItem;
	}

	public long getAuditID() {
		return auditID;
	}

	public void setAuditID(long auditID) {
		this.auditID = auditID;
	}

	public String getIncidentID() {
		return incidentID;
	}

	public void setIncidentID(String incidentID) {
		this.incidentID = incidentID;
	}

	public Agent getEditAgent() {
		return editAgent;
	}

	public void setEditAgent(Agent editAgent) {
		this.editAgent = editAgent;
	}

	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	public int getTradeType() {
		return tradeType;
	}

	public void setTradeType(int tradeType) {
		this.tradeType = tradeType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Status getInventoryStatus() {
		return inventoryStatus;
	}

	public void setInventoryStatus(Status inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public boolean isVerifiedIncident() {
		return verifiedIncident;
	}

	public void setVerifiedIncident(boolean verifiedIncident) {
		this.verifiedIncident = verifiedIncident;
	}
		
	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getSpecialNeedDescription() {
		return specialNeedDescription;
	}

	public void setSpecialNeedDescription(String specialNeedDescription) {
		this.specialNeedDescription = specialNeedDescription;
	}

	//NTFIXME - Fix all below methods
	/*public String getFirstNameJavascript() {
		return firstName != null ? StringUtils.sanitizeForSingleQuoteJavascript(firstName) : "";
	}

	public String getLastNameJavascript() {
		return lastName != null ? StringUtils.sanitizeForSingleQuoteJavascript(lastName) : "";
	}

	public String getCountryJavascript() {
		return country != null ? StringUtils.sanitizeForSingleQuoteJavascript(country) : "";
	}

	public String getPhoneNumberJavascript() {
		return phoneNumber != null ? StringUtils.sanitizeForSingleQuoteJavascript(phoneNumber) : "";
	}

	public String getAddress1Javascript() {
		return address1 != null ? StringUtils.sanitizeForSingleQuoteJavascript(address1) : "";
	}

	public String getAddress2Javascript() {
		return address2 != null ? StringUtils.sanitizeForSingleQuoteJavascript(address2) : "";
	}

	public String getCityJavascript() {
		return city != null ? StringUtils.sanitizeForSingleQuoteJavascript(city) : "";
	}

	public String getStateJavascript() {
		return state != null ? StringUtils.sanitizeForSingleQuoteJavascript(state) : "";
	}
	
	public String getProvinceJavascript() {
		return province != null ? StringUtils.sanitizeForSingleQuoteJavascript(province) : "";
	}

	public String getZipJavascript() {
		return zip != null ? StringUtils.sanitizeForSingleQuoteJavascript(zip) : "";
	}

	public String getSpecialNeedDescriptionJavascript() {
		return specialNeedDescription != null ? StringUtils.sanitizeForSingleQuoteJavascript(specialNeedDescription) : "";
	}*/
	
}

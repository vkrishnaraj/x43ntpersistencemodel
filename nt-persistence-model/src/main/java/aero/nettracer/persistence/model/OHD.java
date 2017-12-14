/*
 * Created on Jul 13, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import aero.nettracer.commons.constant.GenericConstants;
import aero.nettracer.commons.utils.CommonsUtils;
import aero.nettracer.commons.utils.GenericDateUtils;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.OrderBy;


@Entity
@Table(name="ohd")
public class OHD {

	private String id;
	private Station foundAtStation;
	private Station holdingStation;
	private AirlineMembership membership;
	private String record_locator;
	private Agent agent;
	private Date founddate;
	private Time foundtime;
	private String claimnum;
	private String color;
	private Date bagarrivedate;
	private String type;
	private int xdescelement_ID_1;
	private int xdescelement_ID_2;
	private int xdescelement_ID_3;
	private int manufacturer_ID;
	private String manufacturer_other;
	private String storage_location;
	private Timestamp close_date;
	private Timestamp lastupdated;
	private Status status;
	private String firstname;
	private String lastname;
	private String middlename;
	private int ohd_type;
	private Status disposal_status;
	private WorldTracerFile wtFile;	// worldtracer id
	private int faultStation = 0;
	private int loss_code = 0;
	private boolean earlyBag;
	private String matched_incident;
	private boolean tagSentToWt;
	private int tagSentToWtStationId;
	private String claimchecknum_leading;
	private String claimchecknum_ticketingcode;
	private String claimchecknum_carriercode;
	private String claimchecknum_bagnumber;
	private Timestamp warehouseReceivedDate;
	private Timestamp warehouseSentDate;
	private String externaldesc;
	private int creationMethod;
	private String modifiedBy;
	private Timestamp modifiedDate;
	private String posId;
	private boolean lateCheckInd;
	private int specialCondition;
	private boolean noAddFees;
	private int other;
	private Timestamp inventoryDate;
	private double weight;
	private Set<OHD_Inventory> items;
	private Set<Remark> remarks;
	private Set<OHD_Passenger> passengers;
	private Set<OHD_Photo> photos;
	private Set<Task> tasks;
	private Set<ControlLog> controlLog;
	private Set<OHD_Itinerary> itinerary;
	private BagTagExpediteTagMapping bagTagExpediteTagMapping;
	private boolean formNoAddFees;


	@Id
	@Column(name = "ohd_id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="found_station_id")
	public Station getFoundAtStation() {
		return foundAtStation;
	}

	public void setFoundAtStation(Station foundAtStation) {
		this.foundAtStation = foundAtStation;
	}

	@ManyToOne
	@JoinColumn(name="holding_station_id")
	public Station getHoldingStation() {
		return holdingStation;
	}

	public void setHoldingStation(Station holdingStation) {
		this.holdingStation = holdingStation;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="membership_id")
	public AirlineMembership getMembership() {
		return membership;
	}

	public void setMembership(AirlineMembership membership) {
		this.membership = membership;
	}

	@Column(name = "record_locator")
	public String getRecord_locator() {
		return record_locator;
	}

	public void setRecord_locator(String record_locator) {
		this.record_locator = record_locator;
	}

	@ManyToOne
	@JoinColumn(name="agent_id")
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@Column(name = "founddate", nullable = false)
	@Temporal(value = TemporalType.DATE)
	public Date getFounddate() {
		return founddate;
	}

	public void setFounddate(Date founddate) {
		this.founddate = founddate;
	}

	@Column(name = "foundtime", nullable = false)
	@Temporal(value = TemporalType.TIME)
	public Time getFoundtime() {
		return foundtime;
	}

	public void setFoundtime(Time foundtime) {
		this.foundtime = foundtime;
	}

	@Column(name = "claimnum")
	public String getClaimnum() {
		return claimnum;
	}

	public void setClaimnum(String claimnum) {
		if (claimnum != null)
			claimnum = CommonsUtils.removeSpaces(claimnum);
		this.claimnum = claimnum;
	}

	@Column(name = "color")
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "bagarrivedate")
	@Temporal(value = TemporalType.DATE)
	public Date getBagarrivedate() {
		return bagarrivedate;
	}

	public void setBagarrivedate(Date bagarrivedate) {
		this.bagarrivedate = bagarrivedate;
	}

	@Column(name = "type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "xdescelement_ID_1")
	public int getXdescelement_ID_1() {
		return xdescelement_ID_1;
	}

	public void setXdescelement_ID_1(int xdescelement_ID_1) {
		this.xdescelement_ID_1 = xdescelement_ID_1;
	}

	@Column(name = "xdescelement_ID_2")
	public int getXdescelement_ID_2() {
		return xdescelement_ID_2;
	}

	public void setXdescelement_ID_2(int xdescelement_ID_2) {
		this.xdescelement_ID_2 = xdescelement_ID_2;
	}

	@Column(name = "xdescelement_ID_3")
	public int getXdescelement_ID_3() {
		return xdescelement_ID_3;
	}

	public void setXdescelement_ID_3(int xdescelement_ID_3) {
		this.xdescelement_ID_3 = xdescelement_ID_3;
	}

	@Column(name = "manufacturer_id")
	public int getManufacturer_ID() {
		return manufacturer_ID;
	}

	public void setManufacturer_ID(int manufacturer_ID) {
		this.manufacturer_ID = manufacturer_ID;
	}

	@Column(name = "manufacturer_other")
	public String getManufacturer_other() {
		return manufacturer_other;
	}

	public void setManufacturer_other(String manufacturer_other) {
		this.manufacturer_other = manufacturer_other;
	}

	@Column(name = "storage_location")
	public String getStorage_location() {
		return storage_location;
	}

	public void setStorage_location(String storage_location) {
		this.storage_location = storage_location;
	}

	@Column(name = "close_date")
	@Temporal(value = TemporalType.TIMESTAMP)
	public Timestamp getClose_date() {
		return close_date;
	}

	public void setClose_date(Timestamp close_date) {
		this.close_date = close_date;
	}

	@Column(name = "lastupdated", insertable = false, updatable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	public Timestamp getLastupdated() {
		return lastupdated;
	}

	public void setLastupdated(Timestamp lastupdated) {
		this.lastupdated = lastupdated;
	}

	@ManyToOne
	@JoinColumn(name="status_id")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Column(name = "firstname")
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "lastname")
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "middlename")
	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	@Column(name = "ohd_type")
	public int getOhd_type() {
		return ohd_type;
	}

	public void setOhd_type(int ohd_type) {
		this.ohd_type = ohd_type;
	}

	@ManyToOne
	@JoinColumn(name="disposal_status_id")
	public Status getDisposal_status() {
		return disposal_status;
	}

	public void setDisposal_status(Status disposal_status) {
		this.disposal_status = disposal_status;
	}

	@Embedded
	public WorldTracerFile getWtFile() {
		return wtFile;
	}

	public void setWtFile(WorldTracerFile wtFile) {
		this.wtFile = wtFile;
	}

	@Column(name="faultstation_id")
	public int getFaultstation_ID() {
		return faultStation;
	}

	public void setFaultstation_ID(int faultStation) {
		this.faultStation = faultStation;
	}

	@Column(name = "loss_code")
	public int getLoss_code() {
		return loss_code;
	}

	public void setLoss_code(int loss_code) {
		this.loss_code = loss_code;
	}

	@Column(name = "earlybag")
	public boolean isEarlyBag() {
		return earlyBag;
	}

	public void setEarlyBag(boolean earlyBag) {
		this.earlyBag = earlyBag;
	}

	@Column(name = "matched_incident")
	public String getMatched_incident() {
		return matched_incident;
	}

	public void setMatched_incident(String matchedIncident) {
		this.matched_incident = matchedIncident;
	}

	@Column(name = "tagSentToWt")
	public boolean isTagSentToWt() {
		return tagSentToWt;
	}

	public void setTagSentToWt(boolean tagSentToWt) {
		this.tagSentToWt = tagSentToWt;
	}

	@Column(name = "tagsenttowtstationid")
	public int getTagSentToWtStationId() {
		return tagSentToWtStationId;
	}

	public void setTagSentToWtStationId(int tagSentToWtStationId) {
		this.tagSentToWtStationId = tagSentToWtStationId;
	}

	@Column(name = "claimchecknum_leading")
	public String getClaimchecknum_leading() {
		return claimchecknum_leading;
	}

	public void setClaimchecknum_leading(String claimchecknum_leading) {
		this.claimchecknum_leading = claimchecknum_leading;
	}

	@Column(name = "claimchecknum_ticketingcode")
	public String getClaimchecknum_ticketingcode() {
		return claimchecknum_ticketingcode;
	}

	public void setClaimchecknum_ticketingcode(String claimchecknum_ticketingcode) {
		this.claimchecknum_ticketingcode = claimchecknum_ticketingcode;
	}

	@Column(name = "claimchecknum_carriercode")
	public String getClaimchecknum_carriercode() {
		return claimchecknum_carriercode;
	}

	public void setClaimchecknum_carriercode(String claimchecknum_carriercode) {
		this.claimchecknum_carriercode = claimchecknum_carriercode;
	}

	@Column(name = "claimchecknum_bagnumber")
	public String getClaimchecknum_bagnumber() {
		return claimchecknum_bagnumber;
	}

	public void setClaimchecknum_bagnumber(String claimchecknum_bagnumber) {
		this.claimchecknum_bagnumber = claimchecknum_bagnumber;
	}

	@Column(name = "warehouseReceivedDate")
	@Temporal(value = TemporalType.TIMESTAMP)
	public Timestamp getWarehouseReceivedDate() {
		return warehouseReceivedDate;
	}

	public void setWarehouseReceivedDate(Timestamp warehouseReceivedDate) {
		this.warehouseReceivedDate = warehouseReceivedDate;
	}

	@Temporal(value = TemporalType.TIMESTAMP)
	public Timestamp getWarehouseSentDate() {
		return warehouseSentDate;
	}

	public void setWarehouseSentDate(Timestamp warehouseSentDate) {
		this.warehouseSentDate = warehouseSentDate;
	}

	@Column(name = "externaldesc")
	public String getExternaldesc() {
		return externaldesc;
	}

	public void setExternaldesc(String externaldesc) {
		this.externaldesc = externaldesc;
	}

	@Column(name = "creationmethod")
	public int getCreationMethod() {
		return creationMethod;
	}

	public void setCreationMethod(int creationMethod) {
		this.creationMethod = creationMethod;
	}

	@Column(name = "modifiedby")
	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Column(name = "modifieddate")
	@Temporal(value = TemporalType.TIMESTAMP)
	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Column(name = "posId")
	public String getPosId() {
		return posId;
	}

	public void setPosId(String posId) {
		this.posId = posId;
	}

	@Column(name = "latecheckind")
	public boolean getLateCheckInd() {
		return lateCheckInd;
	}

	public void setLateCheckInd(boolean lateCheckInd) {
		this.lateCheckInd = lateCheckInd;
	}

	@Column(name = "specialcondition")
	public int getSpecialCondition() {
		return specialCondition;
	}

	public void setSpecialCondition(int specialCondition) {
		this.specialCondition = specialCondition;
	}

	@Column(name = "noaddfees")
	public boolean isNoAddFees() {
		return noAddFees;
	}

	public void setNoAddFees(boolean noAddFees) {
		this.noAddFees = noAddFees;
	}

	@Column(name = "other")
	public int getOther() {
		return other;
	}

	public void setOther(int other) {
		this.other = other;
	}

	@Temporal(value = TemporalType.TIMESTAMP)
	public Timestamp getInventoryDate() {
		return inventoryDate;
	}

	public void setInventoryDate(Timestamp inventoryDate) {
		this.inventoryDate = inventoryDate;
	}

	@Column(name = "weight")
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@OrderBy(clause="ohd_inventory_id")
	@OneToMany(mappedBy="ohd", cascade=CascadeType.ALL)
	public Set<OHD_Inventory> getItems() {
		return items;
	}

	public void setItems(Set<OHD_Inventory> items) {
		this.items = items;
	}

	@OrderBy(clause="createtime")
	@OneToMany(mappedBy="ohd", cascade=CascadeType.ALL)
	public Set<Remark> getRemarks() {
		return remarks;
	}

	public void setRemarks(Set<Remark> remarks) {
		this.remarks = remarks;
	}

	@OneToMany(mappedBy="ohd", cascade=CascadeType.ALL)
	public Set<OHD_Passenger> getPassengers() {
		if (passengers == null || passengers.size() == 0) {
			return passengers;
		}
		TreeSet<OHD_Passenger> sorted = new TreeSet<>(new OnHandPassengerIdComparator());
		sorted.addAll(passengers);
		return sorted;
	}

	public void setPassengers(Set<OHD_Passenger> passengers) {
		this.passengers = passengers;
	}

	@OrderBy(clause="Photo_ID")
	@OneToMany(mappedBy="ohd", cascade=CascadeType.ALL)
	public Set<OHD_Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<OHD_Photo> photos) {
		this.photos = photos;
	}

	@OrderBy(clause="due_date_time")
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="file_ref_number")
	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@OrderBy(clause="control_id")
	@OneToMany(mappedBy="ohd", cascade=CascadeType.ALL)
	public Set<ControlLog> getControlLog() {
		return controlLog;
	}

	public void setControlLog(Set<ControlLog> controlLog) {
		this.controlLog = controlLog;
	}

	@OrderBy(clause="itinerarytype,itinerary_id")
	@OneToMany(mappedBy="ohd", cascade=CascadeType.ALL)
	public Set<OHD_Itinerary> getItinerary() {
		return itinerary;
	}

	public void setItinerary(Set<OHD_Itinerary> itinerary) {
		this.itinerary = itinerary;
	}


	@OneToOne(mappedBy = "ohd", cascade = CascadeType.ALL)
	public BagTagExpediteTagMapping getBagTagExpediteTagMapping() {
		return bagTagExpediteTagMapping;
	}

	public void setBagTagExpediteTagMapping(BagTagExpediteTagMapping bagTagExpediteTagMapping) {
		this.bagTagExpediteTagMapping = bagTagExpediteTagMapping;
	}

	@Transient
	public boolean isFormNoAddFees() {
		return formNoAddFees;
	}

	public void setFormNoAddFees(boolean formNoAddFees) {
		this.formNoAddFees = formNoAddFees;
	}

	@Transient
	public Date getFullFoundDate() {
		return GenericDateUtils.convertToDate(getFounddate().toString() + " " + getFoundtime().toString(), GenericConstants.DB_DATETIMEFORMAT,
				null);
	}

	@Transient
	public OHD_Passenger getPassenger() {
		if (passengers != null && passengers.size() > 0)
			return (OHD_Passenger) (new ArrayList<OHD_Passenger>(getPassengers())).get(0);
		else {
			OHD_Passenger pass = new OHD_Passenger();
			pass.setFirstname("");
			pass.setMiddlename("");
			pass.setLastname("");
			return pass;
		}
	}

	class OnHandPassengerIdComparator implements Comparator<OHD_Passenger> {
		public int compare(OHD_Passenger p1, OHD_Passenger p2) {
			return Long.compare(p1.getSortId(), p2.getSortId());
		}
	}

	@Transient
	public ControlLog getLastLog() {
		if (this.getControlLog() != null) {
			for (Iterator<ControlLog> i = this.getControlLog().iterator(); i.hasNext();) {
				ControlLog log = (ControlLog) i.next();
				if (log.getEnd_date() == null || log.getEnd_date().equals("")) return log;
			}
		}
		return null;
	}

	@Transient
	public String getWt_id() {
		if(wtFile != null) {
			return wtFile.getWt_id();
		}
		return null;
	}


	@Transient
	public String format(String val) {
		if (val == null) return " ";
		else return val + " ";
	}


	@Transient
	public String getDispDestination() {
		if (itinerary == null || itinerary.isEmpty()) return "";
		Object[] items = itinerary.toArray();
		OHD_Itinerary itinerary = (OHD_Itinerary) items[items.length - 1];
		return itinerary.getLegto() != null ? itinerary.getLegto() : "";
	}

	@Transient
	public String getFullName() {
		StringBuilder fullName = new StringBuilder();
		boolean haveLast = lastname != null && !lastname.isEmpty();
		boolean haveFirst = firstname != null && !firstname.isEmpty();
		boolean haveMiddle = middlename != null && !middlename.isEmpty();
		
		if (haveLast) {
			fullName.append(getLastname());
		}
		
		if (haveFirst) {
			if (haveLast) {
				fullName.append(", ");
			}
			fullName.append(getFirstname());
		}
		
		if (haveMiddle) {
			if (haveLast || haveFirst) {
				fullName.append(" ");
			}
			fullName.append(getMiddlename());
		}
		
		return fullName.toString();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OHD [OHD_ID=");
		builder.append(id);
		builder.append(", foundAtStation=");
		builder.append(foundAtStation);
		builder.append(", holdingStation=");
		builder.append(holdingStation);
		builder.append(", storage_location=");
		builder.append(storage_location);
		builder.append(", agent=");
		builder.append(agent);
		builder.append(", foundtime=");
		builder.append(foundtime);
		builder.append(", founddate=");
		builder.append(founddate);
		builder.append(", bagarrivedate=");
		builder.append(bagarrivedate);
		builder.append(", inventoryDate=");
		builder.append(inventoryDate);
		builder.append(", warehouseSentDate=");
		builder.append(warehouseSentDate);
		builder.append(", warehouseReceivedDate=");
		builder.append(warehouseReceivedDate);
		builder.append(", claimnum=");
		builder.append(claimnum);
		builder.append(", claimchecknum_leading=");
		builder.append(claimchecknum_leading);
		builder.append(", claimchecknum_ticketingcode=");
		builder.append(claimchecknum_ticketingcode);
		builder.append(", claimchecknum_carriercode=");
		builder.append(claimchecknum_carriercode);
		builder.append(", claimchecknum_bagnumber=");
		builder.append(claimchecknum_bagnumber);
		builder.append(", color=");
		builder.append(color);
		builder.append(", type=");
		builder.append(type);
		builder.append(", ohd_type=");
		builder.append(ohd_type);
		builder.append(", lastname=");
		builder.append(lastname);
		builder.append(", firstname=");
		builder.append(firstname);
		builder.append(", middlename=");
		builder.append(middlename);
		builder.append(", membership=");
		builder.append(membership);
		builder.append(", record_locator=");
		builder.append(record_locator);
		builder.append(", xdescelement_ID_1=");
		builder.append(xdescelement_ID_1);
		builder.append(", xdescelement_ID_2=");
		builder.append(xdescelement_ID_2);
		builder.append(", xdescelement_ID_3=");
		builder.append(xdescelement_ID_3);
		builder.append(", manufacturer_ID=");
		builder.append(manufacturer_ID);
		builder.append(", manufacturer_other=");
		builder.append(manufacturer_other);
		builder.append(", status=");
		builder.append(status);
		builder.append(", disposal_status=");
		builder.append(disposal_status);
		builder.append(", earlyBag=");
		builder.append(earlyBag);
		builder.append(", matched_incident=");
		builder.append(matched_incident);
		builder.append(", externaldesc=");
		builder.append(externaldesc);
		builder.append(", specialCondition=");
		builder.append(specialCondition);
		builder.append(", items=");
		builder.append(items);
		builder.append(", remarks=");
		builder.append(remarks);
		builder.append(", passengers=");
		builder.append(passengers);
		builder.append(", photos=");
		builder.append(photos);
		builder.append(", tasks=");
		builder.append(tasks);
		builder.append(", controlLog=");
		builder.append(controlLog);
		builder.append(", itinerary=");
		builder.append(itinerary);
		builder.append(", close_date=");
		builder.append(close_date);
		builder.append(", lastupdated=");
		builder.append(lastupdated);
		builder.append(", wtFile=");
		builder.append(wtFile);
		builder.append(", faultStation=");
		builder.append(faultStation);
		builder.append(", loss_code=");
		builder.append(loss_code);
		builder.append(", tagSentToWt=");
		builder.append(tagSentToWt);
		builder.append(", tagSentToWtStationId=");
		builder.append(tagSentToWtStationId);
		builder.append(", creationMethod=");
		builder.append(creationMethod);
		builder.append(", modifiedBy=");
		builder.append(modifiedBy);
		builder.append(", modifiedDate=");
		builder.append(modifiedDate);
		builder.append(", posId=");
		builder.append(posId);
		builder.append(", lateCheckInd=");
		builder.append(lateCheckInd);
		builder.append(", other=");
		builder.append(other);
		builder.append(", noAddFees=");
		builder.append(noAddFees);
		builder.append("]");
		return builder.toString();
	}

	@Transient
	public int getCreationMethodDescription(){
		return creationMethod;
	}

	public void setCreationMethodDescription(int creationMethod){
		this.creationMethod = creationMethod;
	}

	@Transient
	public int getFaultStationCode() {
		return faultStation;
	}

	public void setFaultStationCode(int faultStation) {
		this.faultStation = faultStation;
	}

	@Transient
	public int getFaultStationCompanyCode() {
		return faultStation;
	}

	public void setFaultStationCompanyCode(String stationCompanyCode) {
		//do nothing
	}

	@Transient
	public int getTagSentToWtStationCode() {
		return tagSentToWtStationId;
	}


	public void setTagSentToWtStationCode(int tagSentToWtStationId) {
		this.tagSentToWtStationId = tagSentToWtStationId;
	}

	@Transient
	public int getTagSentToWtStationCompanyCode() {
		return tagSentToWtStationId;
	}

	public void setTagSentToWtStationCompanyCode(int tagSentToWtStationId) {
		//do nothing
	}

}
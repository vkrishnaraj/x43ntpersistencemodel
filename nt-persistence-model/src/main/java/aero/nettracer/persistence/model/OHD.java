/*
 * Created on Jul 13, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeSet;

import aero.nettracer.commons.constant.GenericConstants;
import aero.nettracer.commons.utils.CommonsUtils;
import aero.nettracer.commons.utils.GenericDateUtils;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;


@Entity
@Table(name="ohd")
public class OHD implements Serializable {
	
	private static final long serialVersionUID = -6651594161173132503L;
	
	
	private String ohdId;
	
	
	private Station foundAtStation;

	private Station holdingStation;

	private String storage_location;

	private Agent agent;

	private Date foundtime;

	private Date founddate;

	private Date bagarrivedate;

	private Date inventoryDate;

	private Date warehouseSentDate;

	private Date warehouseReceivedDate;


	private String claimnum;

	private String claimchecknum_leading;

	private String claimchecknum_ticketingcode;

	private String claimchecknum_carriercode;

	private String claimchecknum_bagnumber;

	private String color;

	private String type;
	private int ohd_type;
	private String lastname;
	private String firstname;
	private String middlename;

	private AirlineMembership membership;

	private String record_locator;
	private int xdescelement_ID_1;
	private int xdescelement_ID_2;
	private int xdescelement_ID_3;
	private int manufacturer_ID;
	private String manufacturer_other;

	private Status status;

	private Status disposal_status;

	private boolean earlyBag;

	private String matched_incident;

	private String externaldesc;

	private int specialCondition;

	private Set<OHD_Inventory> items;

	private Set<Remark> remarks;

	private Set<OHD_Passenger> passengers;

	private Set<OHD_Photo> photos;

	private Set<Task> tasks;

	private Set<ControlLog> controlLog;

	private Set<OHD_Itinerary> itinerary;

	private Date close_date;

	private Date lastupdated;

	private WorldTracerFile wtFile;	// worldtracer id

	private String _DATEFORMAT; // current login agent's date format

	private String _TIMEFORMAT; // current login agent's time format

	private TimeZone _TIMEZONE;

	private int faultStation = 0;

	private int loss_code = 0;
	private boolean tagSentToWt;
	private int tagSentToWtStationId;
	private int creationMethod;
	private String modifiedBy;

	private Date modifiedDate;

	private String posId;

	private boolean lateCheckInd;
	private int other;
	private boolean noAddFees;
	private boolean formNoAddFees;
	private double weight;

	private BagTagExpediteTagMapping bagTagExpediteTagMapping;

	@Transient
	public String getDisplaydate() {
		Date completedate = GenericDateUtils.convertToDate(this.getFounddate().toString() + " "
				+ this.getFoundtime().toString(), GenericConstants.DB_DATETIMEFORMAT, null);
		return GenericDateUtils.formatDate(completedate, _DATEFORMAT + " " + _TIMEFORMAT, null, _TIMEZONE);
	}

	@Transient
	public Date getFullFoundDate() {
		return GenericDateUtils.convertToDate(getFounddate().toString() + " " + getFoundtime().toString(), GenericConstants.DB_DATETIMEFORMAT,
				null);
	}


	public int getOhd_type() {
		return ohd_type;
	}

	public void setOhd_type(int ohd_type) {
		this.ohd_type = ohd_type;
	}

	@Temporal(value = TemporalType.DATE)
	public Date getBagarrivedate() {
		return bagarrivedate;
	}

	public void setBagarrivedate(Date bagarrivedate) {
		this.bagarrivedate = bagarrivedate;
	}

	@Temporal(value = TemporalType.TIMESTAMP)
	public Date getInventoryDate() {
		return inventoryDate;
	}

	public void setInventoryDate(Date inventoryDate) {
		this.inventoryDate = inventoryDate;
	}

	@Transient
	public String getDispInventoryDate() {
		return GenericDateUtils.formatDate(this.getInventoryDate(), _DATEFORMAT + " " + _TIMEFORMAT, null, _TIMEZONE);
	}

	@Temporal(value = TemporalType.DATE)
	public Date getWarehouseSentDate() {
		return warehouseSentDate;
	}

	public void setWarehouseSentDate(Date warehouseSentDate) {
		this.warehouseSentDate = warehouseSentDate;
	}

	@Temporal(value = TemporalType.DATE)
	public Date getWarehouseReceivedDate() {
		return warehouseReceivedDate;
	}

	public void setWarehouseReceivedDate(Date warehouseReceivedDate) {
		this.warehouseReceivedDate = warehouseReceivedDate;
	}

	@Temporal(value = TemporalType.TIMESTAMP)
	public Date getLastupdated() {
		return lastupdated;
	}

	public void setLastupdated(Date lastupdated) {
		this.lastupdated = lastupdated;
	}


	@Fetch(FetchMode.SELECT)
	@org.hibernate.annotations.OrderBy(clause="itinerarytype,itinerary_ID")
	@OneToMany(mappedBy="ohd", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<OHD_Itinerary> getItinerary() {
		return itinerary;
	}

	public void setItinerary(Set<OHD_Itinerary> itinerary) {
		this.itinerary = itinerary;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="membership_ID")
	public AirlineMembership getMembership() {
		return membership;
	}

	public void setMembership(AirlineMembership membership) {
		this.membership = membership;
	}

	public String getRecord_locator() {
		return record_locator;
	}

	public void setRecord_locator(String record_locator) {
		this.record_locator = record_locator;
	}

	@Fetch(FetchMode.SELECT)
	@org.hibernate.annotations.OrderBy(clause="due_date_time")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="file_ref_number")
	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@ManyToOne
	@JoinColumn(name="agent_ID")
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@Column(length = 13)
	public String getClaimnum() {
		return claimnum;
	}

	public void setClaimnum(String claimnum) {
		if (claimnum != null)
			claimnum = CommonsUtils.removeSpaces(claimnum);
		this.claimnum = claimnum;
	}

	@Column(length = 1)
	public String getClaimchecknum_leading() {
		return claimchecknum_leading;
	}

	public void setClaimchecknum_leading(String claimchecknum_leading) {
		this.claimchecknum_leading = claimchecknum_leading;
	}

	@Column(length = 50)
	public String getExternaldesc() {
		return externaldesc;
	}

	public void setExternaldesc(String externaldesc) {
		this.externaldesc = externaldesc;
	}

	@Column(length = 1)
	public String getClaimchecknum_ticketingcode() {
		return claimchecknum_ticketingcode;
	}

	public void setClaimchecknum_ticketingcode(String claimchecknum_ticketingcode) {
		this.claimchecknum_ticketingcode = claimchecknum_ticketingcode;
	}

	@Column(length = 2)
	public String getClaimchecknum_carriercode() {
		return claimchecknum_carriercode;
	}

	public void setClaimchecknum_carriercode(String claimchecknum_carriercode) {
		this.claimchecknum_carriercode = claimchecknum_carriercode;
	}

	@Column(length = 6)
	public String getClaimchecknum_bagnumber() {
		return claimchecknum_bagnumber;
	}

	public void setClaimchecknum_bagnumber(String claimchecknum_bagnumber) {
		this.claimchecknum_bagnumber = claimchecknum_bagnumber;
	}

	@Column(length = 2)
	public String getColor() {
		return color;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Fetch(FetchMode.SELECT)
	@org.hibernate.annotations.OrderBy(clause="OHD_Inventory_ID")
	@OneToMany(mappedBy="ohd", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<OHD_Inventory> getItems() {
		return items;
	}

	public void setItems(Set<OHD_Inventory> items) {
		this.items = items;
	}

	@Id
	public String getOHD_ID() {
		return OHD_ID;
	}

	public void setOHD_ID(String ohd_id) {
		OHD_ID = ohd_id;
	}

	@Fetch(FetchMode.SELECT)
	@org.hibernate.annotations.OrderBy(clause="createtime")
	@OneToMany(mappedBy="ohd", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<Remark> getRemarks() {
		return remarks;
	}

	public void setRemarks(Set<Remark> remarks) {
		this.remarks = remarks;
	}

	@ManyToOne
	@JoinColumn(name="status_ID")
	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}

	@ManyToOne
	@JoinColumn(name="disposal_status_id")
	public Status getDisposal_status() {
		return disposal_status;
	}

	public void setDisposal_status(Status disposal_status) {
		this.disposal_status = disposal_status;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getManufacturer_ID() {
		return manufacturer_ID;
	}

	public void setManufacturer_ID(int manufacturer_ID) {
		this.manufacturer_ID = manufacturer_ID;
	}

	public String getManufacturer_other() {
		return manufacturer_other;
	}

	public void setManufacturer_other(String manufacturer_other) {
		this.manufacturer_other = manufacturer_other;
	}

	public int getXdescelement_ID_1() {
		return xdescelement_ID_1;
	}

	public void setXdescelement_ID_1(int xdescelement_ID_1) {
		this.xdescelement_ID_1 = xdescelement_ID_1;
	}

	public int getXdescelement_ID_2() {
		return xdescelement_ID_2;
	}

	public void setXdescelement_ID_2(int xdescelement_ID_2) {
		this.xdescelement_ID_2 = xdescelement_ID_2;
	}

	public int getXdescelement_ID_3() {
		return xdescelement_ID_3;
	}

	public void setXdescelement_ID_3(int xdescelement_ID_3) {
		this.xdescelement_ID_3 = xdescelement_ID_3;
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

	@ManyToOne
	@JoinColumn(name="found_station_ID")
	public Station getFoundAtStation() {
		return foundAtStation;
	}

	public void setFoundAtStation(Station foundAtStation) {
		this.foundAtStation = foundAtStation;
	}

	@Temporal(value = TemporalType.TIME)
	public Date getFoundtime() {
		return foundtime;
	}

	public void setFoundtime(Date foundtime) {
		this.foundtime = foundtime;
	}

	class OnHandPassengerIdComparator implements Comparator<OHD_Passenger> {
		public int compare(OHD_Passenger p1, OHD_Passenger p2) {
			return Long.compare(p1.getSortId(), p2.getSortId());
		}
	}

	@Fetch(FetchMode.SELECT)
//	@org.hibernate.annotations.OrderBy(clause="passenger_id")
	@OneToMany(mappedBy="ohd", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<OHD_Passenger> getPassengers() {
		if (passengers == null || passengers.size() == 0) {
			return passengers;
		}

		TreeSet<OHD_Passenger> sorted = new TreeSet<OHD_Passenger>(new OnHandPassengerIdComparator());
		sorted.addAll(passengers);
		return sorted;
	}

	public void setPassengers(Set<OHD_Passenger> passengers) {
		this.passengers = passengers;
	}


	@Fetch(FetchMode.SELECT)
	@org.hibernate.annotations.OrderBy(clause="Photo_ID")
	@OneToMany(mappedBy="ohd", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<OHD_Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<OHD_Photo> photos) {
		this.photos = photos;
	}

	@Fetch(FetchMode.SELECT)
	@org.hibernate.annotations.OrderBy(clause="control_id")
	@OneToMany(mappedBy="ohd", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<ControlLog> getControlLog() {
		return controlLog;
	}

	public void setControlLog(Set<ControlLog> controlLog) {
		this.controlLog = controlLog;
	}

	@ManyToOne
	@JoinColumn(name="holding_station_ID")
	public Station getHoldingStation() {
		return holdingStation;
	}

	public void setHoldingStation(Station holdingStation) {
		this.holdingStation = holdingStation;
	}

	@Temporal(value = TemporalType.DATE)
	public Date getFounddate() {
		return founddate;
	}

	public void setFounddate(Date founddate) {
		this.founddate = founddate;
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
	public String get_DATEFORMAT() {
		return _DATEFORMAT;
	}

	public void set_DATEFORMAT(String _dateformat) {
		_DATEFORMAT = _dateformat;
	}

	@Transient
	public String get_TIMEFORMAT() {
		return _TIMEFORMAT;
	}

	public void set_TIMEFORMAT(String _timeformat) {
		_TIMEFORMAT = _timeformat;
	}

	@Transient
	public TimeZone get_TIMEZONE() {
		return _TIMEZONE;
	}

	public void set_TIMEZONE(TimeZone _timezone) {
		_TIMEZONE = _timezone;
	}

	public String getStorage_location() {
		return storage_location;
	}

	public void setStorage_location(String storage_location) {
		this.storage_location = storage_location;
	}

	@Temporal(value = TemporalType.TIMESTAMP)
	public Date getClose_date() {
		return close_date;
	}

	public void setClose_date(Date close_date) {
		this.close_date = close_date;
	}

	@Embedded
	public WorldTracerFile getWtFile() {
		return wtFile;
	}

	public void setWtFile(WorldTracerFile wtFile) {
		this.wtFile = wtFile;
	}

	@Transient
	public String getWt_id() {
		if(wtFile != null) {
			return wtFile.getWt_id();
		}
		return null;
	}

	@Column(name="faultstation_ID")
	public int getFaultstation_ID() {
		return faultStation;
	}

	public void setFaultstation_ID(int faultStation) {
		this.faultStation = faultStation;
	}

	public int getLoss_code() {
		return loss_code;
	}

	public void setLoss_code(int loss_code) {
		this.loss_code = loss_code;
	}

	public boolean isEarlyBag() {
		return earlyBag;
	}

	public void setEarlyBag(boolean earlyBag) {
		this.earlyBag = earlyBag;
	}


	@Transient
	public String format(String val) {
		if (val == null) return " ";
		else return val + " ";
	}

	@Column(length = 13)
	public String getMatched_incident() {
		return matched_incident;
	}

	public void setMatched_incident(String matchedIncident) {
		this.matched_incident = matchedIncident;
	}

	public boolean isTagSentToWt() {
  	return tagSentToWt;
  }

	public void setTagSentToWt(boolean tagSentToWt) {
  	this.tagSentToWt = tagSentToWt;
  }

	public int getTagSentToWtStationId() {
  	return tagSentToWtStationId;
  }

	public void setTagSentToWtStationId(int tagSentToWtStationId) {
  	this.tagSentToWtStationId = tagSentToWtStationId;
  }

	public int getCreationMethod() {
		return creationMethod;
	}

	public void setCreationMethod(int creationMethod) {
		this.creationMethod = creationMethod;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Temporal(value = TemporalType.TIMESTAMP)
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Column(length = 32)
	public String getPosId() {
		return posId;
	}

	public void setPosId(String posId) {
		this.posId = posId;
	}

	public boolean getLateCheckInd() {
		return lateCheckInd;
	}

	public void setLateCheckInd(boolean lateCheckInd) {
		this.lateCheckInd = lateCheckInd;
	}

	@Transient
	public String getDispDestination() {
		if (itinerary == null || itinerary.isEmpty()) return "";
		Object[] items = itinerary.toArray();
		OHD_Itinerary itinerary = (OHD_Itinerary) items[items.length - 1];
		return itinerary.getLegto() != null ? itinerary.getLegto() : "";
	}

	@Transient
	public String getDispModifiedDate() {
		String modDate = GenericDateUtils.formatDate(this.getModifiedDate(), _DATEFORMAT + " " + _TIMEFORMAT, null, _TIMEZONE);
		return modDate != null ? modDate.substring(0, modDate.lastIndexOf(' ')) : "";
	}

	@Transient
	public String getDispModifiedTime() {
		String modTime = GenericDateUtils.formatDate(this.getModifiedDate(), _DATEFORMAT + " " + _TIMEFORMAT, null, _TIMEZONE);
		return modTime != null ? modTime.substring(modTime.lastIndexOf(' '), modTime.length()) : "";
	}

	public int getOther() {
		return other;
	}

	public void setOther(int other) {
		this.other = other;
	}

	public boolean isNoAddFees() {
		return noAddFees;
	}

	public void setNoAddFees(boolean noAddFees) {
		this.noAddFees = noAddFees;
	}

	@Transient
	public boolean isFormNoAddFees() {
		return formNoAddFees;
	}

	public void setFormNoAddFees(boolean formNoAddFees) {
		this.formNoAddFees = formNoAddFees;
	}

	public int getSpecialCondition() {
		return specialCondition;
	}

	public void setSpecialCondition(int specialCondition) {
		this.specialCondition = specialCondition;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@OneToOne(mappedBy = "ohd", cascade = CascadeType.ALL)
	public BagTagExpediteTagMapping getBagTagExpediteTagMapping() {
		return bagTagExpediteTagMapping;
	}

	public void setBagTagExpediteTagMapping(BagTagExpediteTagMapping bagTagExpediteTagMapping) {
		this.bagTagExpediteTagMapping = bagTagExpediteTagMapping;
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
		builder.append(OHD_ID);
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
		builder.append(", _DATEFORMAT=");
		builder.append(_DATEFORMAT);
		builder.append(", _TIMEFORMAT=");
		builder.append(_TIMEFORMAT);
		builder.append(", _TIMEZONE=");
		builder.append(_TIMEZONE);
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
	
	/**
	 * If the founddate and foundtime attributes are not null, returns the combined date and time elements of the respective attributes into a
	 * single Date object.  
	 * 
	 * This method is marked as Deprecated and is only intended to be used by Dozer currently defined in the mapping ntcore/src/main/resources/dozer/dozerBeanMappingOnHand.xml
	 * for the following reason:
	 * 
	 * Since the foundtime by default is stored into database using the GMT time generated by com.bagnet.nettracer.tracing.utils.DateUtils.  However, the manner of which
	 * com.bagnet.nettracer.tracing.utils.DateUtils converts to GMT involves changing the Date itself by applying local timezone offset.  This is incorrect, however,
	 * since the legacy code and all legacy data is currently storing the time in the manner, retrieving the date we must use DateUtils.convertGMTDateToLocalTime to reverse the
	 * change done by the conversation to GMT.  To properly fix this issue will require extensive refactoring of our legacy code, however, this method was implement during a 
	 * code freeze period to fix a specific problem with a Dozer mapper.
	 * 
	 * @return
	 */
	@Transient
	@Deprecated
	public Date getFullFoundDateTime(){
		if(founddate != null && foundtime != null){
			return GenericDateUtils.convertGMTDateToLocalTime(GenericDateUtils.combineDateTime(founddate, foundtime));
		} else {
			return null;
		}
	}
	
	/**
	 * Sets the provide Date object to the founddate and foundtime attributes.
	 * 
	 * This method is marked as Deprecated and is only intended to be used by Dozer currently defined in the mapping ntcore/src/main/resources/dozer/dozerBeanMappingOnHand.xml
	 * for the following reason:
	 * 
	 * Since the foundtime by default is stored into database using the GMT time generated by com.bagnet.nettracer.tracing.utils.DateUtils.  However, the manner of which
	 * com.bagnet.nettracer.tracing.utils.DateUtils converts to GMT involves changing the Date itself by applying local timezone offset.  This is incorrect, however,
	 * since the legacy code and all legacy data is currently storing the time in the manner, this method will also use com.bagnet.nettracer.tracing.utils.DateUtils.convertToGMTDate
	 * Otherwise the DateTime that is set from dozerBeanMappingOnHand.xml will be persisted in an inconsistant manner as compared to the rest of the application.  
	 * To properly fix this issue will require extensive refactoring of our legacy code, however, this method was implement during a 
	 * code freeze period to fix a specific problem with a Dozer mapper.
	 * 
	 * @param dateTime
	 */
	@Transient
	@Deprecated
	public void setFullFoundDateTime(Date dateTime){
		if(dateTime != null){
			founddate = GenericDateUtils.convertToGMTDate(dateTime);
			foundtime = GenericDateUtils.convertToGMTDate(dateTime);
		} else {
			founddate = null;
			foundtime = null;
		}
	}

}
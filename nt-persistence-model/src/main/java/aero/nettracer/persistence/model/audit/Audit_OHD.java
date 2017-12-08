/*
 * Created on Jul 13, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model.audit;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import aero.nettracer.commons.constant.GenericConstants;
import aero.nettracer.commons.utils.GenericDateUtils;
import aero.nettracer.persistence.model.Agent;
import aero.nettracer.persistence.model.ControlLog;
import aero.nettracer.persistence.model.Station;
import aero.nettracer.persistence.model.Status;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name="Audit_OHD")
public class Audit_OHD implements Serializable {
	
	
	private static final long serialVersionUID = 6215494125447132503L;

	private int audit_ohd_id;
	
	private String OHD_ID;
	
	private Station foundAtStation;
	
	private Station holdingStation;
	
	private String storage_location;
	
	private Agent agent;
	
	private Date foundtime;
	
	private Date founddate;
	
	private Date bagarrivedate;

	private Date inventoryDate;
	
	private String claimnum;
	
	private String color;
	
	
	private String type;
	private int ohd_type;
	private String lastname;
	private String firstname;
	private String middlename;
	
	private Audit_AirlineMembership membership;

	private String record_locator;
	private int xdescelement_ID_1;
	private int xdescelement_ID_2;
	private int xdescelement_ID_3;
	private int manufacturer_ID;
	private String manufacturer_other;

	private Status status;

	private Status disposal_status;

	private Set<Audit_OHD_Inventory> items;

	private Set<Audit_OHD_Remark> remarks;

	private Set<Audit_OHD_Passenger> passengers;

	private Set<Audit_OHD_Photo> photos;

	private Set<Audit_ControlLog> controlLog;

	private Set<Audit_OHD_Itinerary> itinerary;

	private Date close_date;

	private String matched_incident;

	private String wt_id;

	private String _DATEFORMAT;

	private String _TIMEFORMAT;

	private TimeZone _TIMEZONE;

	private Agent modifying_agent;

	private String reason_modified;

	private Date time_modified;

	private int faultStation;

	private int loss_code;

	private String posId;

	private boolean lateCheckInd;

	@ManyToOne
	@JoinColumn(name="modifying_agent_ID")
	public Agent getModifying_agent() {
		return modifying_agent;
	}

	//NTFIXME
	/*@Transient
	public String getDesc1() {
		if (this.getXdescelement_ID_1() == 0) return "";

		return TracerUtils.getXdescelement(this.getXdescelement_ID_1()).getDescription();
	}*/

	//NTFIXME
	/*@Transient
	public String getDesc2() {
		if (this.getXdescelement_ID_2() == 0) return "";
		return TracerUtils.getXdescelement(this.getXdescelement_ID_2()).getDescription();
	}*/

	//NTFIXME
	/*@Transient
	public String getDesc3() {
		if (this.getXdescelement_ID_3() == 0) return "";
		return TracerUtils.getXdescelement(this.getXdescelement_ID_3()).getDescription();
	}*/

	//NTFIXME
	/*@Transient
	public String getDesc1Key() {
		if (this.getXdescelement_ID_1() == 0) return "NoDesc";

		return TracerUtils.getXdescelement(this.getXdescelement_ID_1()).getKey();
	}*/

	//NTFIXME
	/*@Transient
	public String getDesc2Key() {
		if (this.getXdescelement_ID_2() == 0) return "NoDesc";
		return TracerUtils.getXdescelement(this.getXdescelement_ID_2()).getKey();
	}*/

	//NTFIXME
	/*@Transient
	public String getDesc3Key() {
		if (this.getXdescelement_ID_3() == 0) return "NoDesc";
		return TracerUtils.getXdescelement(this.getXdescelement_ID_3()).getKey();
	}*/

	public void setModifying_agent(Agent modifying_agent) {
		this.modifying_agent = modifying_agent;
	}

	public String getReason_modified() {
		return reason_modified;
	}

	public void setReason_modified(String reason_modified) {
		this.reason_modified = reason_modified;
	}

	@Transient
	public String getDisplaytime_modified() {
		Date completedate = GenericDateUtils.convertToDate(this.getTime_modified().toString(),
				GenericConstants.DB_DATETIMEFORMAT, null);
		return GenericDateUtils.formatDate(completedate, _DATEFORMAT + " " + _TIMEFORMAT, null, _TIMEZONE);
	}

	@Transient
	public String getDisplaydate() {
		Date completedate = GenericDateUtils.convertToDate(this.getFounddate().toString() + " "
				+ this.getFoundtime().toString(), GenericConstants.DB_DATETIMEFORMAT, null);
		return GenericDateUtils.formatDate(completedate, _DATEFORMAT + " " + _TIMEFORMAT, null, _TIMEZONE);
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

	@Fetch(FetchMode.SELECT)
	@org.hibernate.annotations.OrderBy(clause="itinerarytype,departdate,schdeparttime")
	@OneToMany(mappedBy="ohd", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<Audit_OHD_Itinerary> getItinerary() {
		return itinerary;
	}

	public void setItinerary(Set<Audit_OHD_Itinerary> itinerary) {
		this.itinerary = itinerary;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="audit_membership_id")
	public Audit_AirlineMembership getMembership() {
		return membership;
	}

	@Temporal(value = TemporalType.TIMESTAMP)
	public Date getTime_modified() {
		return time_modified;
	}

	public void setTime_modified(Date time_modified) {
		this.time_modified = time_modified;
	}

	public void setMembership(Audit_AirlineMembership mem) {
		this.membership = mem;
	}

	public String getRecord_locator() {
		return record_locator;
	}

	@Id
	@GeneratedValue
	public int getAudit_ohd_id() {
		return audit_ohd_id;
	}

	public void setAudit_ohd_id(int audit_ohd_id) {
		this.audit_ohd_id = audit_ohd_id;
	}

	public void setRecord_locator(String record_locator) {
		this.record_locator = record_locator;
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
		this.claimnum = claimnum;
	}

	@Column(length = 13)
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
	public Set<Audit_OHD_Inventory> getItems() {
		return items;
	}

	public void setItems(Set<Audit_OHD_Inventory> items) {
		this.items = items;
	}

	public String getOHD_ID() {
		return OHD_ID;
	}

	public void setOHD_ID(String ohd_id) {
		OHD_ID = ohd_id;
	}

	@Fetch(FetchMode.SELECT)
	@org.hibernate.annotations.OrderBy(clause="createtime")
	@OneToMany(mappedBy="audit_ohd", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<Audit_OHD_Remark> getRemarks() {
		return remarks;
	}

	public void setRemarks(Set<Audit_OHD_Remark> remarks) {
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
	public Audit_OHD_Passenger getPassenger() {
		if (passengers != null && passengers.size() > 0) return (Audit_OHD_Passenger) (new ArrayList<Audit_OHD_Passenger>(
				passengers)).get(0);
		else {
			Audit_OHD_Passenger pass = new Audit_OHD_Passenger();
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

	@Fetch(FetchMode.SELECT)
	@org.hibernate.annotations.OrderBy(clause="passenger_id")
	@OneToMany(mappedBy="ohd", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<Audit_OHD_Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<Audit_OHD_Passenger> passengers) {
		this.passengers = passengers;
	}

	@Fetch(FetchMode.SELECT)
	@org.hibernate.annotations.OrderBy(clause="Photo_ID")
	@OneToMany(mappedBy="ohd", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<Audit_OHD_Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Audit_OHD_Photo> photos) {
		this.photos = photos;
	}

	@Fetch(FetchMode.SELECT)
	@org.hibernate.annotations.OrderBy(clause="control_id")
	@OneToMany(mappedBy="audit_ohd", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<Audit_ControlLog> getControlLog() {
		return controlLog;
	}

	public void setControlLog(Set<Audit_ControlLog> controlLog) {
		this.controlLog = controlLog;
	}

	@ManyToOne
	@JoinColumn(name="holding_station_ID")
	public Station getHoldingStation() {
		return holdingStation;
	}

	@Transient
	public String getDispCloseDate() {
		return GenericDateUtils.formatDate(this.getClose_date(), _DATEFORMAT + " " + _TIMEFORMAT, null,
				_TIMEZONE);
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
			for (Iterator i = this.getControlLog().iterator(); i.hasNext();) {
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

	//NTFIXME
	/*@Transient
	public String getManufacturer() {
		String ret = "";

		if (this.getManufacturer_ID() > 0) {
			if (this.getManufacturer_ID() == CommonsConstants.MANUFACTURER_OTHER_ID) {
				if (this.getManufacturer_other() != null && this.getManufacturer_other().length() > 0) {
					ret = this.getManufacturer_other();
				}
			} else {
				Manufacturer manuf = TracerUtils.getManufacturer(this.getManufacturer_ID());
				if (manuf != null) {
					ret = manuf.getDescription();
				}
			}
		}

		return ret;
	}*/

	public void setClose_date(Date close_date) {
		this.close_date = close_date;
	}

	public String getWt_id() {
		return wt_id;
	}

	public void setWt_id(String wt_id) {
		this.wt_id = wt_id;
	}

	@Transient
	public List<Audit_OHD_Passenger> getPassengerList() {
		return new ArrayList<Audit_OHD_Passenger>(this.passengers);
	}

	@Transient
	public List<Audit_OHD_Photo> getPhotoList() {
		return new ArrayList<Audit_OHD_Photo>(this.photos);
	}

	@Transient
	public List<Audit_OHD_Inventory> getItemList() {
		return new ArrayList<Audit_OHD_Inventory>(this.items);
	}

	@Transient
	public List<Audit_OHD_Remark> getRemarkList() {
		return new ArrayList<Audit_OHD_Remark>(this.remarks);
	}

	@Transient
	public List<Audit_OHD_Itinerary> getItineraryList() {
		return new ArrayList<Audit_OHD_Itinerary>(this.itinerary);
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

	@Column(length = 13)
	public String getMatched_incident() {
		return matched_incident;
	}

	public void setMatched_incident(String matched_incident) {
		this.matched_incident = matched_incident;
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
	public String getDispPosId() {
		return posId == null ? "" : posId;
	}
	
	@Transient
	public String getDispLateCheckInd() {
		return lateCheckInd ? "Yes" : "No";
	}
}
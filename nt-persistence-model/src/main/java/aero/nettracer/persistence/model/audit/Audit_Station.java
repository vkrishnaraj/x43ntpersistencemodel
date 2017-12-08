package aero.nettracer.persistence.model.audit;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;

import aero.nettracer.commons.constant.GenericConstants;
import aero.nettracer.commons.utils.GenericDateUtils;
import aero.nettracer.persistence.model.Agent;
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
import javax.persistence.Transient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "audit_station")
public class Audit_Station implements Serializable {

	private static final long serialVersionUID = -1823955137870279638L;

	@Id @GeneratedValue
	private int audit_station_id;
	
	@ManyToOne(targetEntity = Agent.class, fetch = FetchType.LAZY)
	@JoinColumn(name="modifying_agent_ID")
	@Fetch(FetchMode.SELECT)
	private Agent modifying_agent;

	private int station_ID;
	private String companycode_ID;
	private String stationcode;
	private String stationdesc;
	private String address1;
	private String address2;
	private String city;
	private String state_ID;
	private String countrycode_ID;
	private String province;
	private String zip;
	private String phone;
	private String airport_location;
	private String operation_hours;
	private String associated_airport;
	private String station_region;
	private String station_region_mgr;
	private double goal;
	private double region_goal;
	private boolean active;
	private boolean visible;
	private Date time_modified;
	private String reason_modified;
	private String lf_ship_from_addr1;
	private String lf_ship_from_addr2;
	private String lf_ship_from_city;
	private String lf_ship_from_state_ID;
	private String lf_ship_from_province;
	private String lf_ship_from_countrycode_ID;
	private String lf_ship_from_zip;
	private String lf_ship_from_phone;
	private String timezone;
	
	@Column(name="lf_hold_for_pickup")
	private boolean lfHoldForPickUp; 
	
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "audit_station")
	@org.hibernate.annotations.OrderBy(clause="id")
	@Fetch(FetchMode.SELECT)
	private Set<Audit_Carrier_Operation_Hours> auditCarrierHours;
	

	@Transient
	private String _DATEFORMAT;
	@Transient
	private String _TIMEFORMAT;
	@Transient
	private TimeZone _TIMEZONE;

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

	@Transient
	public String getDisplaytime_modified() {
		Date completedate = GenericDateUtils.convertToDate(this.getTime_modified().toString(),
				GenericConstants.DB_DATETIMEFORMAT, null);
		return GenericDateUtils.formatDate(completedate, _DATEFORMAT + " " + _TIMEFORMAT, null, _TIMEZONE);
	}

	/**
	 * @hibernate.many-to-one class="aero.nettracer.legacy.persistence.model.Agent"
	 *                        column="modifying_agent_ID"
	 * @return Returns the modifying_agent.
	 */
	public Agent getModifying_agent() {
		return modifying_agent;
	}

	//NTFIXME
	/*@Transient
	public String getState() {
		if (state_ID != null && state_ID.length() > 0) {
			return TracerUtils.getState(state_ID).getState();
		}
		return "";
	}*/

	//NTFIXME
	/*@Transient
	public String getCountry() {
		if (countrycode_ID != null && countrycode_ID.length() > 0) {
			return TracerUtils.getCountry(countrycode_ID).getCountry();
		}
		return "";
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

	public Date getTime_modified() {
		return time_modified;
	}

	public void setTime_modified(Date time_modified) {
		this.time_modified = time_modified;
	}

	public String getCountrycode_ID() {
		return countrycode_ID;
	}

	public void setCountrycode_ID(String countrycode_ID) {
		this.countrycode_ID = countrycode_ID;
	}

	public String getState_ID() {
		return state_ID;
	}

	public void setState_ID(String state_ID) {
		this.state_ID = state_ID;
	}

	public String getAirport_location() {
		return airport_location;
	}

	public void setAirport_location(String airport_location) {
		this.airport_location = airport_location;
	}

	public String getOperation_hours() {
		return operation_hours;
	}

	public void setOperation_hours(String operation_hours) {
		this.operation_hours = operation_hours;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public int getAudit_station_id() {
		return audit_station_id;
	}

	public void setAudit_station_id(int audit_station_id) {
		this.audit_station_id = audit_station_id;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAssociated_airport() {
		return associated_airport;
	}

	public void setAssociated_airport(String associated_airport) {
		this.associated_airport = associated_airport;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public int getStation_ID() {
		return station_ID;
	}

	public void setStation_ID(int station_ID) {
		this.station_ID = station_ID;
	}

	public String getStationcode() {
		return stationcode;
	}

	public void setStationcode(String stationcode) {
		this.stationcode = stationcode;
	}

	public String getStationdesc() {
		return stationdesc;
	}

	public void setStationdesc(String stationdesc) {
		this.stationdesc = stationdesc;
	}

	public String getCompanycode_ID() {
		return companycode_ID;
	}

	public void setCompanycode_ID(String companycode_ID) {
		this.companycode_ID = companycode_ID;
	}
	
	public String getStation_region() {
		return station_region;
	}

	public void setStation_region(String station_region) {
		this.station_region = station_region;
	}

	public String getStation_region_mgr() {
		return station_region_mgr;
	}

	public void setStation_region_mgr(String station_region_mgr) {
		this.station_region_mgr = station_region_mgr;
	}

	public double getGoal() {
		return goal;
	}

	public void setGoal(double goal) {
		this.goal = goal;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public void setRegion_goal(double region_goal) {
		this.region_goal = region_goal;
	}
	
	public double getRegion_goal() {
		return region_goal;
	}
	
	public String getLfShipFromAddress1() {
		return lf_ship_from_addr1;
	}

	public void setLfShipFromAddress1(String lf_ship_from_addr1) {
		this.lf_ship_from_addr1 = lf_ship_from_addr1;
	}

	public String getLfShipFromAddress2() {
		return lf_ship_from_addr2;
	}

	public void setLfShipFromAddress2(String lf_ship_from_addr2) {
		this.lf_ship_from_addr2 = lf_ship_from_addr2;
	}

	public String getLfShipFromCity() {
		return lf_ship_from_city;
	}

	public void setLfShipFromCity(String lf_ship_from_city) {
		this.lf_ship_from_city = lf_ship_from_city;
	}

	public String getLfShipFromStateId() {
		return lf_ship_from_state_ID;
	}

	public void setLfShipFromStateId(String lf_ship_from_state_ID) {
		this.lf_ship_from_state_ID = lf_ship_from_state_ID;
	}

	public String getLfShipFromCountryCodeId() {
		return lf_ship_from_countrycode_ID;
	}

	public void setLfShipFromCountryCodeId(String lf_ship_from_countrycode_ID) {
		this.lf_ship_from_countrycode_ID = lf_ship_from_countrycode_ID;
	}

	public String getLfShipFromZip() {
		return lf_ship_from_zip;
	}

	public void setLfShipFromZip(String lf_ship_from_zip) {
		this.lf_ship_from_zip = lf_ship_from_zip;
	}

	public String getLfShipFromPhone() {
		return lf_ship_from_phone;
	}

	public void setLfShipFromPhone(String lf_ship_from_phone) {
		this.lf_ship_from_phone = lf_ship_from_phone;
	}
	
	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public Set<Audit_Carrier_Operation_Hours> getAuditCarrierHours() {
		return auditCarrierHours;
	}

	public void setAuditCarrierHours(
			Set<Audit_Carrier_Operation_Hours> auditCarrierHours) {
		this.auditCarrierHours = auditCarrierHours;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getLfShipFromProvince() {
		return lf_ship_from_province;
	}

	public void setLfShipFromProvince(String lf_ship_from_province) {
		this.lf_ship_from_province = lf_ship_from_province;
	}
	
	public boolean isLfHoldForPickUp() {
		return lfHoldForPickUp;
	}

	public void setLfHoldForPickUp(boolean lfHoldForPickUp) {
		this.lfHoldForPickUp = lfHoldForPickUp;
	}

}
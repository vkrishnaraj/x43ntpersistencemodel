package aero.nettracer.persistence.model;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.OrderBy;

import javax.persistence.Cacheable;
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
import javax.persistence.Transient;
import java.util.Set;

@Entity
@Table(name = "station")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Station {

	private int id;
	private String stationcode;
	private Company company;
	private String stationdesc;
	private String address1;
	private String address2;
	private String city;
	private String state_ID;
	private String province;
	private CountryCode countryCode;
	private String zip;
	private boolean lfHoldForPickUp;
	private String lf_ship_from_addr1;
	private String lf_ship_from_addr2;
	private String lf_ship_from_city;
	private String lf_ship_from_state_ID;
	private String lf_ship_from_province;
	private String lf_ship_from_countrycode_ID;
	private String lf_ship_from_zip;
	private String lf_ship_from_phone;
	private String phone;
	private String airport_location;
	private String operation_hours;
	private String associated_airport;
	private String station_region;
	private String station_region_mgr;
	private double goal;
	private boolean active;
	private boolean visible;
	private int lz_ID;
	private int lz_lf_ID;
	private String wt_stationcode;
	private String email_language;
	private int priority;
	private Region region;
	private String timezone;
	private int fault_station_visibility;
	private boolean lockWithAssingnTo;
	private String contactName;
	private boolean auto_load_unassigned;
	private String countrycode_ID;
	private Set<Carrier_Operation_Hours> carrierHours;
	private long currentRegionId;
	private double currentGoal;
	private String stationinfo;

	public Station() { }

	public Station(int id) {
		this.id = id;
	}


	@Id
	@GeneratedValue
	@Column(name = "station_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "stationcode")
	public String getStationcode() {
		return stationcode;
	}

	public void setStationcode(String stationcode) {
		this.stationcode = stationcode;
	}

	@ManyToOne
	@JoinColumn(name="companycode_id")
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Column(name = ")")
	public String getStationdesc() {
		return stationdesc;
	}

	public void setStationdesc(String stationdesc) {
		this.stationdesc = stationdesc;
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

	@Column(name = "state_id")
	public String getState_ID() {
		return state_ID;
	}

	public void setState_ID(String state_ID) {
		this.state_ID = state_ID;
	}

	@Column(name = "province")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@OneToOne
	@JoinColumn(name="countrycode_ID", referencedColumnName="CountryCode_ID", updatable = false, insertable = false)
	public CountryCode getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(CountryCode countryCode) {
		this.countryCode = countryCode;
	}

	@Column(name = "zip")
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column(name = "lf_hold_for_pickup")
	public boolean isLfHoldForPickUp() {
		return lfHoldForPickUp;
	}

	public void setLfHoldForPickUp(boolean lfHoldForPickUp) {
		this.lfHoldForPickUp = lfHoldForPickUp;
	}

	@Column(name = "lf_ship_from_addr1")
	public String getLfShipFromAddress1() {
		return lf_ship_from_addr1;
	}

	public void setLfShipFromAddress1(String lf_ship_from_addr1) {
		this.lf_ship_from_addr1 = lf_ship_from_addr1;
	}

	@Column(name = "lf_ship_from_addr2")
	public String getLfShipFromAddress2() {
		return lf_ship_from_addr2;
	}

	public void setLfShipFromAddress2(String lf_ship_from_addr2) {
		this.lf_ship_from_addr2 = lf_ship_from_addr2;
	}

	@Column(name = "lf_ship_from_city")
	public String getLfShipFromCity() {
		return lf_ship_from_city;
	}

	public void setLfShipFromCity(String lf_ship_from_city) {
		this.lf_ship_from_city = lf_ship_from_city;
	}

	@Column(name = "lf_ship_from_state_id")
	public String getLfShipFromStateId() {
		return lf_ship_from_state_ID;
	}

	public void setLfShipFromStateId(String lf_ship_from_state_ID) {
		this.lf_ship_from_state_ID = lf_ship_from_state_ID;
	}

	@Column(name = "lf_ship_from_province")
	public String getLfShipFromProvince() {
		return lf_ship_from_province;
	}

	public void setLfShipFromProvince(String lf_ship_from_province) {
		this.lf_ship_from_province = lf_ship_from_province;
	}

	@Column(name = "lf_ship_from_countrycode_id")
	public String getLfShipFromCountryCodeId() {
		return lf_ship_from_countrycode_ID;
	}

	public void setLfShipFromCountryCodeId(String lf_ship_from_countrycode_ID) {
		this.lf_ship_from_countrycode_ID = lf_ship_from_countrycode_ID;
	}

	@Column(name = "lf_ship_from_zip")
	public String getLfShipFromZip() {
		return lf_ship_from_zip;
	}

	public void setLfShipFromZip(String lf_ship_from_zip) {
		this.lf_ship_from_zip = lf_ship_from_zip;
	}

	@Column(name = "lf_ship_from_phone")
	public String getLfShipFromPhone() {
		return lf_ship_from_phone;
	}

	public void setLfShipFromPhone(String lf_ship_from_phone) {
		this.lf_ship_from_phone = lf_ship_from_phone;
	}

	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "airport_location")
	public String getAirport_location() {
		return airport_location;
	}

	public void setAirport_location(String airport_location) {
		this.airport_location = airport_location;
	}

	@Column(name = "operation_hours")
	public String getOperation_hours() {
		return operation_hours;
	}

	public void setOperation_hours(String operation_hours) {
		this.operation_hours = operation_hours;
	}

	@Column(name = "associated_airport")
	public String getAssociated_airport() {
		return associated_airport;
	}

	public void setAssociated_airport(String associated_airport) {
		this.associated_airport = associated_airport;
	}

	@Column(name = "station_region")
	public String getStation_region() {
		return station_region;
	}

	public void setStation_region(String station_region) {
		this.station_region = station_region;
	}

	@Column(name = "station_region_mgr")
	public String getStation_region_mgr() {
		return station_region_mgr;
	}

	public void setStation_region_mgr(String station_region_mgr) {
		this.station_region_mgr = station_region_mgr;
	}

	@Column(name = "goal")
	public double getGoal() {
		return goal;
	}

	public void setGoal(double goal) {
		this.goal = goal;
	}

	@Column(name = "active")
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Column(name = "visible")
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Column(name = "lz_id")
	public int getLz_ID() {
		return lz_ID;
	}

	public void setLz_ID(int lz_id) {
		this.lz_ID = lz_id;
	}

	@Column(name = "lz_lf_id")
	public int getLz_lf_ID() {
		return lz_lf_ID;
	}

	public void setLz_lf_ID(int lz_lf_id) {
		this.lz_lf_ID = lz_lf_id;
	}

	@Column(name = "wt_stationcode")
	public String getWt_stationcode() {
		return wt_stationcode;
	}

	public void setWt_stationcode(String wt_stationcode) {
		this.wt_stationcode = wt_stationcode;
	}

	@Column(name = "email_language")
	public String getEmailLanguage() {
		return email_language;
	}

	public void setEmailLanguage(String email_language) {
		this.email_language = email_language;
	}

	@Column(name = "priority")
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@ManyToOne
	@JoinColumn(name="region_id")
	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@Column(name = "timezone")
	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	@Column(name = "fault_station_visibility")
	public int getFaultStationVisibility() {
		return fault_station_visibility;
	}

	public void setFaultStationVisibility(int fault_station_visibility) {
		this.fault_station_visibility = fault_station_visibility;
	}

	@Column(name = "lockwithassingnto")
	public boolean isLockWithAssingnTo() {
		return lockWithAssingnTo;
	}

	public void setLockWithAssingnTo(boolean lockWithAssingnTo) {
		this.lockWithAssingnTo = lockWithAssingnTo;
	}

	@Column(name = "contactname")
	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	@Column(name = "auto_load_unassigned")
	public boolean isAuto_load_unassigned() {
		return auto_load_unassigned;
	}

	public void setAuto_load_unassigned(boolean auto_load_unassigned) {
		this.auto_load_unassigned = auto_load_unassigned;
	}

	@Column(name = "countrycode_id")
	public String getCountrycode_ID() {
		return countrycode_ID;
	}

	public void setCountrycode_ID(String countrycode_ID) {
		this.countrycode_ID = countrycode_ID;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "station")
	@OrderBy(clause="id")
	public Set<Carrier_Operation_Hours> getCarrierHours() {
		return carrierHours;
	}

	public void setCarrierHours(Set<Carrier_Operation_Hours> carrierHours) {
		this.carrierHours = carrierHours;
	}

	@Column(name = "currentregionid")
	public long getCurrentRegionId() {
		return currentRegionId;
	}

	public void setCurrentRegionId(long currentRegionId) {
		this.currentRegionId = currentRegionId;
	}

	@Transient
	public double getCurrentGoal() {
		return currentGoal;
	}

	public void setCurrentGoal(double currentGoal) {
		this.currentGoal = currentGoal;
	}

	@Transient
	public String getStationinfo() {
		String moreInfo = (StringUtils.isBlank(this.state_ID)? "" : ", " + this.state_ID)
				+ (StringUtils.isBlank(this.stationcode)? "" : " - " + this.stationcode);
		return this.stationdesc + moreInfo;
	}

	@Transient
	public int getLZStationCode() {
		return lz_ID;
	}

	@Transient
	public int getLZStationCompanyCode() {
		return lz_ID;
	}

	public boolean isThisOhdLz() {
		return (this.id == this.getCompany().getVariable().getOhd_lz());
	}

}
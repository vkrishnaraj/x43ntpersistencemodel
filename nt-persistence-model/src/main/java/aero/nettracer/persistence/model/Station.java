package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Cacheable;
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
import javax.persistence.Table;
import javax.persistence.Transient;
import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "station")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Station implements Serializable {

	private static final long serialVersionUID = -8920424497356057481L;
	
	@Id @GeneratedValue
	private int station_ID;
	
	@ManyToOne(targetEntity = Company.class)
	@JoinColumn(name="companycode_ID")
	@Fetch(FetchMode.SELECT)
	private Company company;
	
	@ManyToOne(targetEntity = Region.class)
	@JoinColumn(name="region_id")
	@Fetch(FetchMode.SELECT)
	private Region region;
	
	private int lz_ID;
	private int lz_lf_ID;
	private String stationcode;
	private String stationdesc;
	private String address1;
	private String address2;
	private String city;
	private String state_ID;
	private String province;
	private String countrycode_ID;
	private String zip;
	private String phone;
	private String airport_location;
	private String operation_hours;
	private String associated_airport;
	private String station_region;
	private String station_region_mgr;
	private double goal;
	private boolean active;
	private boolean visible;
	private String wt_stationcode;
	private String email_language;
	private int priority;
	private String lf_ship_from_addr1;
	private String lf_ship_from_addr2;
	private String lf_ship_from_city;
	private String lf_ship_from_state_ID;
	private String lf_ship_from_province;
	private String lf_ship_from_countrycode_ID;
	private String lf_ship_from_zip;
	private String lf_ship_from_phone;
	private String timezone;
	private int fault_station_visibility;
	private String contactName;

	private boolean lockWithAssingnTo;

	private boolean auto_load_unassigned;

	@Column(name="lf_hold_for_pickup")
	private boolean lfHoldForPickUp;

	@OneToOne
	@JoinColumn(name="countrycode_ID", referencedColumnName="CountryCode_ID", updatable = false, insertable = false)
	private CountryCode countryCode;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "station")
	@org.hibernate.annotations.OrderBy(clause="id")
	@Fetch(FetchMode.SELECT)
	private Set<Carrier_Operation_Hours> carrierHours;

	@Transient
	private long currentRegionId;
	@Transient
	private double currentGoal;
	@Transient
	private String stationinfo;

	public Set<Carrier_Operation_Hours> getCarrierHours() {
		return carrierHours;
	}

	public void setCarrierHours(Set<Carrier_Operation_Hours> carrierHours) {
		this.carrierHours = carrierHours;
	}

	public Station() { }

	public Station(int station_ID) {
		this.station_ID = station_ID;
	}

	public int getStation_ID() {
		return station_ID;
	}

	public void setStation_ID(int station_ID) {
		this.station_ID = station_ID;
	}

	public String getWt_stationcode() {
		return wt_stationcode;
	}

	public void setWt_stationcode(String wt_stationcode) {
		this.wt_stationcode = wt_stationcode;
	}

	public int getLz_ID() {
		return lz_ID;
	}

	public void setLz_ID(int lz_id) {
		this.lz_ID = lz_id;
	}

	public int getLz_lf_ID() {
		return lz_lf_ID;
	}

	public void setLz_lf_ID(int lz_lf_id) {
		this.lz_lf_ID = lz_lf_id;
	}

	public String getCountrycode_ID() {
		//return (countrycode_ID == null || countrycode_ID.length() ==  0 ? PropertyBMO.getValue(PropertyBMO.PROPERTY_DEFAULT_COUNTRY) : countrycode_ID);
		return countrycode_ID;
	}

	public void setCountrycode_ID(String countrycode_ID) {
		this.countrycode_ID = countrycode_ID;
	}

	public String getLfShipFromProvince() {
		return lf_ship_from_province;
	}

	public void setLfShipFromProvince(String lf_ship_from_province) {
		this.lf_ship_from_province = lf_ship_from_province;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
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

	public String getStationinfo() {
		String moreInfo = (StringUtils.isBlank(this.state_ID)? "" : ", " + this.state_ID)
						+ (StringUtils.isBlank(this.stationcode)? "" : " - " + this.stationcode);
		return this.stationdesc + moreInfo;
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

	public String toString() {
		StringBuffer sb = new StringBuffer(200);
		sb.append("Station ID=" + this.getStation_ID() + " station code=" + this.getStationcode()
				+ " station desc=" + this.getStationdesc());
		return sb.toString();
	}

	public String toXML() {
		StringBuffer sb = new StringBuffer();
		sb.append("<station>");
		sb.append("<Station_ID>" + station_ID + "</Station_ID>");
		sb.append("<companycode>" + this.getCompany().getCompanyCode_ID() + "</companycode>");
		sb.append("<stationcode>" + this.getStationcode() + "</stationcode>");
		sb.append("</station>");

		return sb.toString();
	}

	public boolean isThisOhdLz() {
		return (this.station_ID == this.getCompany().getVariable().getOhd_lz());
	}

	public String getEmailLanguage() {
		return email_language;
	}

	public void setEmailLanguage(String email_language) {
		this.email_language = email_language;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Region getRegion() {
		return region;
	}

	public void setCurrentRegionId(long currentRegionId) {
		this.currentRegionId = currentRegionId;
	}

	public long getCurrentRegionId() {
		return currentRegionId;
	}

	public void setCurrentGoal(double currentGoal) {
		this.currentGoal = currentGoal;
	}

	public double getCurrentGoal() {
		return currentGoal;
	}

	@Transient
	public int getLZStationCode() {
		return lz_ID;
	}

	@Transient
	public int getLZStationCompanyCode() {
		return lz_ID;
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

	public boolean isLfHoldForPickUp() {
		return lfHoldForPickUp;
	}

	public void setLfHoldForPickUp(boolean lfHoldForPickUp) {
		this.lfHoldForPickUp = lfHoldForPickUp;
	}

	public int getFaultStationVisibility() {
		return fault_station_visibility;
	}

	public void setFaultStationVisibility(int fault_station_visibility) {
		this.fault_station_visibility = fault_station_visibility;
	}

	public boolean isLockWithAssingnTo() {
		return lockWithAssingnTo;
	}

	public void setLockWithAssingnTo(boolean lockWithAssingnTo) {
		this.lockWithAssingnTo = lockWithAssingnTo;
	}

	//NTFIXME
	/*@Transient
	public static Station getMappedObject(TypeStation foundStation) {
		if(foundStation == null) {
			return null;
		}
		Station station = new Station();
		station.setStationcode(foundStation.getStationCode());
		return station;
	}*/

	public CountryCode getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(CountryCode countryCode) {
		this.countryCode = countryCode;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public boolean isAuto_load_unassigned() {
		return auto_load_unassigned;
	}

	public void setAuto_load_unassigned(boolean auto_load_unassigned) {
		this.auto_load_unassigned = auto_load_unassigned;
	}
}
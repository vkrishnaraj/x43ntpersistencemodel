package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import aero.nettracer.commons.constant.GenericConstants;
import aero.nettracer.commons.utils.GenericDateUtils;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Incident")
public class TraceIncident implements Serializable {

	private int version;
	private String Incident_ID;
	private Date createdate;
	private Date createtime;
	private String recordlocator;
	private Date lastupdated;
	private Date ohd_lasttraced;
	private Set<TracePassenger> passengers;
	private List<TraceItem> itemlist;
	private Set itinerary;
	private Set<TraceIncident_Claimcheck> claimchecks;
	private String _DATEFORMAT;
	private String _TIMEFORMAT;
	private TimeZone _TIMEZONE;

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@OneToMany(mappedBy = "incident", fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "claimcheck_ID")
	public Set<TraceIncident_Claimcheck> getClaimchecks() {
		return claimchecks;
	}

	public void setClaimchecks(Set<TraceIncident_Claimcheck> claimchecks) {
		this.claimchecks = claimchecks;
	}

	@OneToMany(mappedBy = "incident", fetch=FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	public List<TraceItem> getItemlist() {
		return itemlist;
	}

	public void setItemlist(List<TraceItem> itemlist) {
		this.itemlist = itemlist;
	}

	@OneToMany(mappedBy = "incident", fetch=FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "passenger_id")
	public Set<TracePassenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<TracePassenger> passengers) {
		this.passengers = passengers;
	}

	@OneToMany(mappedBy = "incident", fetch= FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "departdate,schdeparttime,itinerary_ID")
	public Set<TraceItinerary> getItinerary() {
		return itinerary;
	}

	public void setItinerary(Set<TraceItinerary> itinerary) {
		this.itinerary = itinerary;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getLastupdated() {
		return lastupdated;
	}

	public void setLastupdated(Date lastupdated) {
		this.lastupdated = lastupdated;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Transient
	public String getDisplaydate() {
		Date completedate = GenericDateUtils.convertToDate(getCreatedate().toString()
				+ " " + getCreatetime().toString(), GenericConstants.DB_DATETIMEFORMAT,
				null);
		return GenericDateUtils.formatDate(completedate, _DATEFORMAT + " " + _TIMEFORMAT,
				null, _TIMEZONE);
	}

	@Transient
	public Date getFullCreateDate() {
		return GenericDateUtils.convertToDate(getCreatedate().toString() + " "
				+ getCreatetime().toString(), GenericConstants.DB_DATETIMEFORMAT, null);
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

	@Id
	public String getIncident_ID() {
		return Incident_ID;
	}

	public void setIncident_ID(String incident_ID) {
		Incident_ID = incident_ID;
	}

	public String getRecordlocator() {
		return recordlocator;
	}

	public void setRecordlocator(String recordlocator) {
		this.recordlocator = recordlocator;
	}

	public Date getOhd_lasttraced() {
		return ohd_lasttraced;
	}

	public void setOhd_lasttraced(Date ohd_lasttraced) {
		this.ohd_lasttraced = ohd_lasttraced;
	}

	@Transient
	public String getRcreatedate() {
		Date completedate = GenericDateUtils.convertToDate(getCreatedate().toString(),
				GenericConstants.DB_DATEFORMAT, null);
		return GenericDateUtils.formatDate(completedate, _DATEFORMAT, null, _TIMEZONE);
	}

	@Transient
	public String getRcreatetime() {
		Date completedate = GenericDateUtils.convertToDate(getCreatetime().toString(),
				GenericConstants.DB_TIMEFORMAT, null);
		return GenericDateUtils.formatDate(completedate, _TIMEFORMAT, null, _TIMEZONE);
	}

}
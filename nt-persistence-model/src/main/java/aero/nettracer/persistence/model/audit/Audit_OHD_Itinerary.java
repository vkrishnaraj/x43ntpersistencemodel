package aero.nettracer.persistence.model.audit;

import java.io.Serializable;
import java.util.Date;

import aero.nettracer.commons.utils.GenericDateUtils;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Audit_ohd_itinerary")
public class Audit_OHD_Itinerary implements Serializable {

	private int id;
	private int Itinerary_ID;
	private int itinerarytype; //0-passenger, 1 - bagrouting
	private String legfrom;
	private String legto;
	private int legfrom_type;
	private int legto_type;
	private Date departdate;
	private Date arrivedate;
	private String airline;
	private String flightnum;
	private Date schdeparttime;
	private Date scharrivetime;
	private Date actdeparttime;
	private Date actarrivetime;
	private Audit_OHD ohd;

	private String _DATEFORMAT;
	private String _TIMEFORMAT;

	@ManyToOne
	@JoinColumn(name = "audit_ohd_id")
	public Audit_OHD getOhd() {
		return ohd;
	}

	public void setOhd(Audit_OHD ohd) {
		this.ohd = ohd;
	}
	
	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getFlightnum() {
		return flightnum;
	}

	public void setFlightnum(String flightnum) {
		this.flightnum = (flightnum != null ? flightnum.toUpperCase() : flightnum);
	}

	public int getItinerary_ID() {
		return Itinerary_ID;
	}

	public void setItinerary_ID(int itinerary_ID) {
		Itinerary_ID = itinerary_ID;
	}

	public int getItinerarytype() {
		return itinerarytype;
	}

	public void setItinerarytype(int itinerarytype) {
		this.itinerarytype = itinerarytype;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLegfrom() {
		return legfrom;
	}

	public void setLegfrom(String legfrom) {
		this.legfrom = (legfrom != null ? legfrom.toUpperCase() : legfrom);
	}

	public String getLegto() {
		return legto;
	}

	public void setLegto(String legto) {
		this.legto = (legto != null ? legto.toUpperCase() : legto);
	}

	public int getLegfrom_type() {
		return legfrom_type;
	}

	public void setLegfrom_type(int legfrom_type) {
		this.legfrom_type = legfrom_type;
	}

	public int getLegto_type() {
		return legto_type;
	}

	public void setLegto_type(int legto_type) {
		this.legto_type = legto_type;
	}

	@Temporal(TemporalType.DATE)
	public Date getArrivedate() {
		return arrivedate;
	}

	public void setArrivedate(Date arrivedate) {
		this.arrivedate = arrivedate;
	}

	public void setDisarrivedate(String s) {
		setArrivedate(GenericDateUtils.convertToDate(s, get_DATEFORMAT(), null));
	}

	@Transient
	public String getDisarrivedate() {
		return GenericDateUtils.formatDate(getArrivedate(), get_DATEFORMAT(), null, null);
	}

	@Temporal(TemporalType.DATE)
	public Date getDepartdate() {
		return departdate;
	}

	public void setDepartdate(Date departdate) {
		this.departdate = departdate;
	}

	public void setDisdepartdate(String s) {
		setDepartdate(GenericDateUtils.convertToDate(s, get_DATEFORMAT(), null));
	}

	@Transient
	public String getDisdepartdate() {
		return GenericDateUtils.formatDate(getDepartdate(), get_DATEFORMAT(), null, null);
	}

	@Temporal(TemporalType.TIME)
	public Date getActarrivetime() {
		return actarrivetime;
	}

	public void setActarrivetime(Date actarrivetime) {
		this.actarrivetime = actarrivetime;
	}

	public void setDisactarrivetime(String s) {
		setActarrivetime(GenericDateUtils.convertToDate(s, get_TIMEFORMAT(), null));
	}

	@Transient
	public String getDisactarrivetime() {
		return GenericDateUtils.formatDate(getActarrivetime(), get_TIMEFORMAT(), null, null);
	}

	@Temporal(TemporalType.TIME)
	public Date getActdeparttime() {
		return actdeparttime;
	}

	public void setActdeparttime(Date actdeparttime) {
		this.actdeparttime = actdeparttime;
	}

	public void setDisactdeparttime(String s) {
		setActdeparttime(GenericDateUtils.convertToDate(s, get_TIMEFORMAT(), null));
	}

	@Transient
	public String getDisactdeparttime() {
		return GenericDateUtils.formatDate(getActdeparttime(), get_TIMEFORMAT(), null, null);
	}

	@Temporal(TemporalType.TIME)
	public Date getScharrivetime() {
		return scharrivetime;
	}

	public void setScharrivetime(Date scharrivetime) {
		this.scharrivetime = scharrivetime;
	}

	public void setDisscharrivetime(String s) {
		setScharrivetime(GenericDateUtils.convertToDate(s, get_TIMEFORMAT(), null));
	}

	@Transient
	public String getDisscharrivetime() {
		return GenericDateUtils.formatDate(getScharrivetime(), get_TIMEFORMAT(), null, null);
	}

	@Temporal(TemporalType.TIME)
	public Date getSchdeparttime() {
		return schdeparttime;
	}

	public void setSchdeparttime(Date schdeparttime) {
		this.schdeparttime = schdeparttime;
	}

	public void setDisschdeparttime(String s) {
		setSchdeparttime(GenericDateUtils.convertToDate(s, get_TIMEFORMAT(), null));
	}

	@Transient
	public String getDisschdeparttime() {
		return GenericDateUtils.formatDate(getSchdeparttime(), get_TIMEFORMAT(), null, null);
	}

	@Transient
	public String get_DATEFORMAT() {
		if (_DATEFORMAT == null && ohd != null) _DATEFORMAT = ohd.getAgent().getDateformat()
				.getFormat();
		return _DATEFORMAT;
	}

	public void set_DATEFORMAT(String _dateformat) {
		_DATEFORMAT = _dateformat;
	}

	@Transient
	public String get_TIMEFORMAT() {
		if (_TIMEFORMAT == null && ohd != null) _TIMEFORMAT = ohd.getAgent().getTimeformat()
				.getFormat();
		return _TIMEFORMAT;
	}

	public void set_TIMEFORMAT(String _timeformat) {
		_TIMEFORMAT = _timeformat;
	}

	//NTFIXME
	/*public boolean equals(Object obj) {
		Audit_OHD_Itinerary aoi = (Audit_OHD_Itinerary) obj;
		boolean ret = true;

		if (AuditOHDUtils.notEqualObjects(aoi.getActarrivetime(), this.getActarrivetime())
				|| AuditOHDUtils.notEqualObjects(aoi.getActdeparttime(), this.getActdeparttime())
				|| AuditOHDUtils.notEqualObjects(aoi.getAirline(), this.getAirline())
				|| AuditOHDUtils.notEqualObjects(aoi.getArrivedate(), this.getArrivedate())
				|| AuditOHDUtils.notEqualObjects(aoi.getDepartdate(), this.getDepartdate())
				|| AuditOHDUtils.notEqualObjects(aoi.getFlightnum(), this.getFlightnum())
				|| AuditOHDUtils.notEqualObjects(aoi.getLegfrom(), this.getLegfrom())
				|| AuditOHDUtils.notEqualObjects(aoi.getLegto(), this.getLegto())
				|| AuditOHDUtils.notEqualObjects(aoi.getScharrivetime(), this.getScharrivetime())
				|| AuditOHDUtils.notEqualObjects(aoi.getSchdeparttime(), this.getSchdeparttime())) {
			ret = false;
		}
		return ret;
	}*/

}
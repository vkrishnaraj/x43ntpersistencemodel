package aero.nettracer.persistence.model;

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
@Table(name = "wt_fwd_log_itinerary")
public class WT_FWD_Log_Itinerary implements Serializable {
	private int Itinerary_ID;
	private int itinerarytype; //0-passenger, 1 - bagrouting
	private String legfrom;
	private String legto;
	private Date departdate;
	private String airline;
	private String flightnum;
	private WT_FWD_Log log;

	private String _DATEFORMAT;
	private String _TIMEFORMAT;



	@ManyToOne
	@JoinColumn(name = "wt_fwd_log_id")
	public WT_FWD_Log getLog() {
		return log;
	}

	public void setLog(WT_FWD_Log log) {
		this.log = log;
	}

	public String getFlightnum() {
		return flightnum;
	}

	public void setFlightnum(String flightnum) {
		this.flightnum = flightnum;
		if (this.flightnum != null) this.flightnum = (this.flightnum).toUpperCase();
	}
	@Id
	@GeneratedValue
	public int getItinerary_ID() {
		return Itinerary_ID;
	}

	public void setItinerary_ID(int itinerary_ID) {
		Itinerary_ID = itinerary_ID;
	}


	public String getLegfrom() {
		return legfrom;
	}

	public void setLegfrom(String legfrom) {
		this.legfrom = legfrom;
		if (this.legfrom != null) this.legfrom = (this.legfrom).toUpperCase();

	}

	public String getLegto() {
		return legto;
	}

	public void setLegto(String legto) {
		this.legto = legto;
		if (this.legto != null) this.legto = (this.legto).toUpperCase();

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

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
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

	public int getItinerarytype() {
		return itinerarytype;
	}

	public void setItinerarytype(int itinerarytype) {
		this.itinerarytype = itinerarytype;
	}
}
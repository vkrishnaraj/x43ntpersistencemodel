/*
 * Created on Jul 13, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
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
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "ohd_log_itinerary")
public class OHD_Log_Itinerary implements Serializable {
	private int itinerary_ID;
	private int itinerarytype;
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
	private OHD_Log log;
	private boolean notify;

	private String _DATEFORMAT;
	private String _TIMEFORMAT;

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	@ManyToOne
	@JoinColumn(name = "ohdlog_id")
	public OHD_Log getLog() {
		return log;
	}

	public void setLog(OHD_Log log) {
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
		return itinerary_ID;
	}

	public void setItinerary_ID(int itinerary_ID) {
		this.itinerary_ID = itinerary_ID;
	}

	public int getItinerarytype() {
		return itinerarytype;
	}

	public void setItinerarytype(int itinerarytype) {
		this.itinerarytype = itinerarytype;
	}

	public String getLegfrom() {
		return legfrom;
	}

	public void setLegfrom(String legfrom) {
		this.legfrom = legfrom;
		if (this.legfrom != null){
			this.legfrom = (this.legfrom).toUpperCase();
			if(!this.legfrom.matches("[A-Z]{3}")){
				this.legfrom = null;
			}
		}
		
	}

	public String getLegto() {
		return legto;
	}

	public void setLegto(String legto) {
		this.legto = legto;
		if (this.legto != null){
			this.legto = (this.legto).toUpperCase();
			if(!this.legto.matches("[A-Z]{3}")){
				this.legto = null;
			}
		}

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
	public boolean isNotify() {
		return notify;
	}

	public void setNotify(boolean notify) {
		this.notify = notify;
	}

	@Transient
	public int getLegToTypeDescription(){
		return legto_type;
	}

	public void setLegToTypeDescription(int legto_type){
		this.legto_type = legto_type;
	}

	@Transient
	public int getLegFromTypeDescription(){
		return legfrom_type;
	}

	public void setLegFromTypeDescription(int legfrom_type){
		this.legfrom_type = legfrom_type;
	}

	public int getItineraryTypeDescription() {
		return itinerarytype;
	}

	public void setItineraryTypeDescription(int itinerarytype) {
		this.itinerarytype = itinerarytype;
	}
}


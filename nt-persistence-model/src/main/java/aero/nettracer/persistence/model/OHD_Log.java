package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import aero.nettracer.commons.utils.GenericDateUtils;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "OHD_Log")
public class OHD_Log implements Serializable {

	private static final long serialVersionUID = -1754832116819197388L;
	private int OHDLog_ID;
	private String expeditenum;
	private String message;
	private Agent forwarding_agent;
	private OHD ohd;
	private int destStationCode;
	private int ohd_request_id;
	private Date forward_time;
	private Set<OHD_Log_Itinerary> itinerary;
	private int log_status;
	private ProactiveNotification pcn;

	private String _DATEFORMAT;
	private String _TIMEFORMAT;
	private TimeZone _TIMEZONE;

	private String destStation;
	private String destCompany;

	@Transient
	public List<OHD_Log_Itinerary> getItinerarylist() {
		if (itinerary == null || itinerary.size() < 1)
			return null;

		return new ArrayList<OHD_Log_Itinerary>(itinerary);
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

	@Transient
	public String getDestCompany() {
		return destCompany;
	}

	@Transient
	public String getDestStation() {
		return destStation;
	}

	public void setDestStation(String destStation) {
		this.destStation = destStation;
	}

	public void setDestCompany(String destCompany) {
		this.destCompany = destCompany;
	}

	@Transient
	public String getDispForwardTime() {
		return GenericDateUtils.formatDate(this.getForward_time(), _DATEFORMAT + " "
				+ _TIMEFORMAT, null, _TIMEZONE);
	}

	@OneToMany(mappedBy = "log", fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "itinerarytype,departdate,schdeparttime")
	public Set<OHD_Log_Itinerary> getItinerary() {
		return itinerary;
	}

	public void setItinerary(Set<OHD_Log_Itinerary> itinerary) {
		this.itinerary = itinerary;
	}

	public int getDestStationCode() {
		return destStationCode;
	}

	public void setDestStationCode(int destStationCode) {
		this.destStationCode = destStationCode;
	}

	public int getOhd_request_id() {
		return ohd_request_id;
	}

	public void setOhd_request_id(int ohd_request_id) {
		this.ohd_request_id = ohd_request_id;
	}

	public String getExpeditenum() {
		return expeditenum;
	}

	public void setExpeditenum(String expeditenum) {
		this.expeditenum = expeditenum;
	}

	public Date getForward_time() {
		return forward_time;
	}

	public void setForward_time(Date forward_time) {
		this.forward_time = forward_time;
	}

	@ManyToOne
	@JoinColumn(name = "send_agent_id")
	public Agent getForwarding_agent() {
		return forwarding_agent;
	}

	public void setForwarding_agent(Agent forwarding_agent) {
		this.forwarding_agent = forwarding_agent;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Id
	@GeneratedValue
	public int getOHDLog_ID() {
		return OHDLog_ID;
	}

	public void setOHDLog_ID(int log_ID) {
		OHDLog_ID = log_ID;
	}

	@ManyToOne
	@JoinColumn(name = "ohd_id")
	public OHD getOhd() {
		return ohd;
	}

	public void setOhd(OHD ohd) {
		this.ohd = ohd;
	}

	public int getLog_status() {
		return log_status;
	}

	public void setLog_status(int log_status) {
		this.log_status = log_status;
	}

	@ManyToOne
	@JoinColumn(name = "pcn")
	public ProactiveNotification getPcn() {
		return pcn;
	}

	public void setPcn(ProactiveNotification pcn) {
		this.pcn = pcn;
	}

	@Transient
	public String getDispDestinationAirline() {
		if (itinerary == null || itinerary.isEmpty())
			return "";
		Object[] items = itinerary.toArray();
		OHD_Log_Itinerary itinerary = (OHD_Log_Itinerary) items[items.length - 1];
		return itinerary.getAirline() != null ? itinerary.getAirline() : "";
	}

	@Transient
	public String getDispDestinationFlightnum() {
		if (itinerary == null || itinerary.isEmpty())
			return "";
		Object[] items = itinerary.toArray();
		OHD_Log_Itinerary itinerary = (OHD_Log_Itinerary) items[items.length - 1];
		return itinerary.getFlightnum() != null ? itinerary.getFlightnum() : "";
	}

	@Transient
	public int getLogStatusDescription(){
		return log_status;
	}

	public void setLogStatusDescription(int log_status){
		this.log_status = log_status;
	}

}
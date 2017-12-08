package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import aero.nettracer.commons.utils.GenericDateUtils;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "wt_fwd_log")
public class WT_FWD_Log implements Serializable {
	public int wt_fwd_log_id;
	public OHD ohd;
	public String place_in_file;
	public int fwd_station_id;
	public String bagtag;
	public String ebagtag;
	public String expeditenum;
	public String passenger1;
	public String passenger2;
	public String passenger3;
	public int loss_code;
	public String reason_for_loss;
	public String fault_station;
	public String fault_terminal;
	public String supplementary_information;
	public String teletype_address1;
	public String teletype_address2;
	public String teletype_address3;
	public String teletype_address4;

	public Agent forwarding_agent;
	public Date forward_date;
	public int fwd_status;

	private Set<WT_FWD_Log_Itinerary> itinerary;


	private String _DATEFORMAT;
	private String _TIMEFORMAT;
	private TimeZone _TIMEZONE;

	@Transient
	public List getItinerarylist() {
		if (itinerary == null || itinerary.size() < 1) return null;

		return new ArrayList(itinerary);
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
	public String getDispForwardTime() {
		return GenericDateUtils.formatDate(this.getForward_date(), _DATEFORMAT + " " + _TIMEFORMAT, null,
				_TIMEZONE);
	}

	@OneToMany(mappedBy = "log")
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "departdate")
	public Set<WT_FWD_Log_Itinerary> getItinerary() {
		return itinerary;
	}

	public void setItinerary(Set<WT_FWD_Log_Itinerary> itinerary) {
		this.itinerary = itinerary;
	}


	public String getExpeditenum() {
		return expeditenum;
	}

	public void setExpeditenum(String expeditenum) {
		this.expeditenum = expeditenum;
	}

	@ManyToOne
	@JoinColumn(name = "fwd_agent_id")
	public Agent getForwarding_agent() {
		return forwarding_agent;
	}

	public void setForwarding_agent(Agent forwarding_agent) {
		this.forwarding_agent = forwarding_agent;
	}

	@Id
	@GeneratedValue
	public int getWt_fwd_log_id() {
		return wt_fwd_log_id;
	}

	public void setWt_fwd_log_id(int wt_fwd_log_id) {
		this.wt_fwd_log_id = wt_fwd_log_id;
	}

	@ManyToOne
	@JoinColumn(name = "OHD_ID")
	public OHD getOhd() {
		return ohd;
	}

	public void setOhd(OHD ohd) {
		this.ohd = ohd;
	}

	public int getFwd_station_id() {
		return fwd_station_id;
	}

	public void setFwd_station_id(int fwd_station_id) {
		this.fwd_station_id = fwd_station_id;
	}

	public String getBagtag() {
		return bagtag;
	}

	public void setBagtag(String bagtag) {
		this.bagtag = bagtag;
	}

	public int getLoss_code() {
		return loss_code;
	}

	public void setLoss_code(int loss_code) {
		this.loss_code = loss_code;
	}

	public String getReason_for_loss() {
		return reason_for_loss;
	}

	public void setReason_for_loss(String reason_for_loss) {
		this.reason_for_loss = reason_for_loss;
	}

	public String getFault_station() {
		return fault_station;
	}

	public void setFault_station(String fault_station) {
		this.fault_station = fault_station;
	}

	public String getFault_terminal() {
		return fault_terminal;
	}

	public void setFault_terminal(String fault_terminal) {
		this.fault_terminal = fault_terminal;
	}

	public String getTeletype_address1() {
		return teletype_address1;
	}

	public void setTeletype_address1(String teletype_address1) {
		this.teletype_address1 = teletype_address1;
	}

	public String getTeletype_address2() {
		return teletype_address2;
	}

	public void setTeletype_address2(String teletype_address2) {
		this.teletype_address2 = teletype_address2;
	}

	public String getTeletype_address3() {
		return teletype_address3;
	}

	public void setTeletype_address3(String teletype_address3) {
		this.teletype_address3 = teletype_address3;
	}

	public String getTeletype_address4() {
		return teletype_address4;
	}

	public void setTeletype_address4(String teletype_address4) {
		this.teletype_address4 = teletype_address4;
	}

	@Temporal(TemporalType.DATE)
	public Date getForward_date() {
		return forward_date;
	}

	public void setForward_date(Date forward_date) {
		this.forward_date = forward_date;
	}

	public int getFwd_status() {
		return fwd_status;
	}

	public void setFwd_status(int fwd_status) {
		this.fwd_status = fwd_status;
	}

	public String getPlace_in_file() {
		return place_in_file;
	}

	public void setPlace_in_file(String place_in_file) {
		this.place_in_file = place_in_file;
	}

	public String getSupplementary_information() {
		return supplementary_information;
	}

	public void setSupplementary_information(String supplementary_information) {
		this.supplementary_information = supplementary_information;
	}

	public String getPassenger1() {
		return passenger1;
	}

	public void setPassenger1(String passenger1) {
		this.passenger1 = passenger1;
	}

	public String getPassenger2() {
		return passenger2;
	}

	public void setPassenger2(String passenger2) {
		this.passenger2 = passenger2;
	}

	public String getPassenger3() {
		return passenger3;
	}

	public void setPassenger3(String passenger3) {
		this.passenger3 = passenger3;
	}

	public String getEbagtag() {
		return ebagtag;
	}

	public void setEbagtag(String ebagtag) {
		this.ebagtag = ebagtag;
	}

}
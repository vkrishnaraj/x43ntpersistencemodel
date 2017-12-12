package aero.nettracer.persistence.model;

import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable
public class GeneralRemark {
	

	private Agent agent;
	private String remarktext;
	private Date remarkdate;
	private int type;

	private String _DATEFORMAT;
	private String _TIMEFORMAT;
	private TimeZone _TIMEZONE;

	@ManyToOne
	@JoinColumn(name = "agent_ID", nullable = false)
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	public String getRemarktext() {
		return remarktext;
	}
	
	public void setRemarktext(String remarktext) {
		this.remarktext = remarktext;
	}
	
	public Date getRemarkdate() {
		return remarkdate;
	}

	public void setRemarkdate(Date remarkdate) {
		this.remarkdate = remarkdate;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public int getType() {
		return type;
	}

	public String get_DATEFORMAT() {
		return _DATEFORMAT;
	}

	public void set_DATEFORMAT(String _dateformat) {
		_DATEFORMAT = _dateformat;
	}

	public String get_TIMEFORMAT() {
		return _TIMEFORMAT;
	}

	public void set_TIMEFORMAT(String _timeformat) {
		_TIMEFORMAT = _timeformat;
	}

	public TimeZone get_TIMEZONE() {
		return _TIMEZONE;
	}

	public void set_TIMEZONE(TimeZone _timezone) {
		_TIMEZONE = _timezone;
	}

	
}

package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;

import aero.nettracer.commons.utils.GenericDateUtils;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


@Embeddable
public class GeneralRemark implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7624184475644182733L;
	@ManyToOne
	@JoinColumn(name = "agent_ID", nullable = false)
	private Agent agent;
	private String remarktext;
	private Date remarkdate;
	private int type;

	@Transient
	private String _DATEFORMAT;

	@Transient
	private String _TIMEFORMAT;

	@Transient
	private TimeZone _TIMEZONE;

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

	public String getDispcreatetime() {
		return GenericDateUtils.formatDate(remarkdate, get_DATEFORMAT()
				+ " " + get_TIMEFORMAT(), null, get_TIMEZONE());
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

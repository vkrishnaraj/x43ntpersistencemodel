package aero.nettracer.persistence.model.audit;

import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;

import aero.nettracer.commons.constant.GenericConstants;
import aero.nettracer.commons.utils.GenericDateUtils;
import aero.nettracer.persistence.model.Agent;
import aero.nettracer.persistence.model.NTDateFormat;
import aero.nettracer.persistence.model.NTTimeFormat;
import aero.nettracer.persistence.model.Station;
import aero.nettracer.persistence.model.UserGroup;
import aero.nettracer.persistence.model.Work_Shift;
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
@Table(name = "Audit_Agent")
public class Audit_Agent implements Serializable {

	private int audit_agent_id;
	private int Agent_ID;
	private Station station;
	private UserGroup group;
	private String firstname;
	private String mname;
	private String lastname;
	private int timeout;
	private String username;
	private String password;
	private boolean active;
	private String defaultlocale;
	private String currentlocale;
	private String defaultcurrency;
	private String defaulttimezone;
	private String currenttimezone;
	private Work_Shift shift;
	private NTDateFormat dateformat;
	private NTTimeFormat timeformat;
	private String companycode_ID;

	private Date last_logged_on;
	private int is_online;

	private Agent modifying_agent;
	private Date time_modified;
	private String reason_modified;
	
	private int is_wt_user;
	
	private boolean ws_enabled;
	private boolean web_enabled;
	private int max_ws_sessions;

	private boolean resetPassword;
	private boolean accountLocked;
	
	private boolean inboundQueue;

	private String _DATEFORMAT; // current login agent's date format
	private String _TIMEFORMAT; // current login agent's time format
	private TimeZone _TIMEZONE; // timezone

	@Transient
	public String getDisplaytime_modified() {
		Date completedate = GenericDateUtils.convertToDate(this.getTime_modified().toString(),
				GenericConstants.DB_DATETIMEFORMAT, null);
		return GenericDateUtils.formatDate(completedate, _DATEFORMAT + " " + _TIMEFORMAT, null, _TIMEZONE);
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

	@ManyToOne
	@JoinColumn(name = "modifying_agent_ID")
	public Agent getModifying_agent() {
		return modifying_agent;
	}

	public void setModifying_agent(Agent modifying_agent) {
		this.modifying_agent = modifying_agent;
	}

	public String getReason_modified() {
		return reason_modified;
	}

	public void setReason_modified(String reason_modified) {
		this.reason_modified = reason_modified;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getTime_modified() {
		return time_modified;
	}

	public void setTime_modified(Date time_modified) {
		this.time_modified = time_modified;
	}

	@ManyToOne
	@JoinColumn(name = "shift_id")
	public Work_Shift getShift() {
		return shift;
	}

	public void setShift(Work_Shift shift) {
		this.shift = shift;
	}

	@ManyToOne
	@JoinColumn(name = "dateformat_ID")
	public NTDateFormat getDateformat() {
		return dateformat;
	}

	public void setDateformat(NTDateFormat dateformat) {
		this.dateformat = dateformat;
	}

	@ManyToOne
	@JoinColumn(name = "timeformat_ID")
	public NTTimeFormat getTimeformat() {
		return timeformat;
	}

	public void setTimeformat(NTTimeFormat timeformat) {
		this.timeformat = timeformat;
	}

	@Transient
	public String getInitial() {
		StringBuffer sb = new StringBuffer(3);
		if (firstname != null && firstname.length() > 1) {
			sb.append(firstname.substring(0, 1));
		}
		if (mname != null && mname.length() > 1) {
			sb.append(mname.substring(0, 1));
		}
		if (lastname != null && lastname.length() > 1) {
			sb.append(lastname.substring(0, 1));
		}
		return sb.toString();
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Id
	@GeneratedValue
	public int getAudit_agent_id() {
		return audit_agent_id;
	}

	public void setAudit_agent_id(int audit_agent_id) {
		this.audit_agent_id = audit_agent_id;
	}

	public int getAgent_ID() {
		return Agent_ID;
	}

	public void setAgent_ID(int agent_ID) {
		Agent_ID = agent_ID;
	}

	public String getCurrentlocale() {
		return currentlocale;
	}

	public void setCurrentlocale(String currentlocale) {
		this.currentlocale = currentlocale;
	}

	public String getDefaultcurrency() {
		return defaultcurrency;
	}

	public String getCompanycode_ID() {
		return companycode_ID;
	}

	public void setCompanycode_ID(String companycode_ID) {
		this.companycode_ID = companycode_ID;
	}

	public void setDefaultcurrency(String defaultcurrency) {
		this.defaultcurrency = defaultcurrency;
	}

	public String getDefaultlocale() {
		return defaultlocale;
	}

	public void setDefaultlocale(String defaultlocale) {
		this.defaultlocale = defaultlocale;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCurrenttimezone() {
		return currenttimezone;
	}

	public void setCurrenttimezone(String currenttimezone) {
		this.currenttimezone = currenttimezone;
	}

	public String getDefaulttimezone() {
		return defaulttimezone;
	}

	public void setDefaulttimezone(String defaulttimezone) {
		this.defaulttimezone = defaulttimezone;
	}

	@ManyToOne
	@JoinColumn(name = "usergroup_ID")
	public UserGroup getGroup() {
		return group;
	}

	public void setGroup(UserGroup group) {
		this.group = group;
	}

	@ManyToOne
	@JoinColumn(name = "station_ID")
	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public int getIs_online() {
		return is_online;
	}

	public void setIs_online(int is_online) {
		this.is_online = is_online;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getLast_logged_on() {
		return last_logged_on;
	}

	public void setLast_logged_on(Date last_logged_on) {
		this.last_logged_on = last_logged_on;
	}
	
	public int getIs_wt_user() {
		return is_wt_user;
	}

	public void setIs_wt_user(int is_wt_user) {
		this.is_wt_user = is_wt_user;
	}

	public boolean isWs_enabled() {
		return ws_enabled;
	}

	public void setWs_enabled(boolean ws_enabled) {
		this.ws_enabled = ws_enabled;
	}

	public boolean isWeb_enabled() {
		return web_enabled;
	}

	public void setWeb_enabled(boolean web_enabled) {
		this.web_enabled = web_enabled;
	}

	public int getMax_ws_sessions() {
		return max_ws_sessions;
	}

	public void setMax_ws_sessions(int max_ws_sessions) {
		this.max_ws_sessions = max_ws_sessions;
	}
	
	public boolean isReset_password() {
		return resetPassword;
	}

	public void setReset_password(boolean resetPassword) {
		this.resetPassword = resetPassword;
	}

	public boolean isAccount_locked() {
		return accountLocked;
	}

	public void setAccount_locked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	public boolean isInboundQueue() {
		return inboundQueue;
	}

	public void setInboundQueue(boolean inboundQueue) {
		this.inboundQueue = inboundQueue;
	}
}
/*
 * Created on Jul 14, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "agent")
public class Agent {

	private int id;
	private String firstname;
	private String mname;
	private String lastname;
	private int timeout;
	private String username;
	private String password;
	private boolean active;
	private Station station;
	private String companycode_ID;
	private String defaultlocale;
	private String currentlocale;
	private String defaultcurrency;
	private String defaulttimezone;
	private String currenttimezone;
	private NTDateFormat dateformat;
	private NTTimeFormat timeformat;
	private Work_Shift shift;
	private UserGroup userGroup;
	private Timestamp last_logged_on;
	private int is_online;
	private Date last_pass_reset_date;
	private int is_wt_user;
	private boolean ws_enabled;
	private int max_ws_sessions;
	private boolean web_enabled;
	private boolean resetPassword;
	private boolean accountLocked;
	private int failedLogins;
	private boolean inboundQueue;
	private double loadPercentage;
	private boolean inbound;
	private boolean acaa;
	private boolean damaged;
	private boolean load_unassigned;

	public Agent() { }

	public Agent(int id) {
		this.id = id;
	}

	@Id
	@GeneratedValue
	@Column(name = "agent_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "firstname")
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "mname")
	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	@Column(name = "lastname")
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "timeout")
	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "active")
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@ManyToOne
	@JoinColumn(name = "station_id")
	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	@Column(name = "companycode_id")
	public String getCompanycode_ID() {
		return companycode_ID;
	}

	public void setCompanycode_ID(String companycode_ID) {
		this.companycode_ID = companycode_ID;
	}

	@Column(name = "defaultlocale")
	public String getDefaultlocale() {
		return defaultlocale;
	}

	public void setDefaultlocale(String defaultlocale) {
		this.defaultlocale = defaultlocale;
	}

	@Column(name = "currentlocale")
	public String getCurrentlocale() {
		return currentlocale;
	}

	public void setCurrentlocale(String currentlocale) {
		this.currentlocale = currentlocale;
	}

	@Column(name = "defaultcurrency")
	public String getDefaultcurrency() {
		return defaultcurrency;
	}

	public void setDefaultcurrency(String defaultcurrency) {
		this.defaultcurrency = defaultcurrency;
	}

	@Column(name = "defaulttimezone")
	public String getDefaulttimezone() {
		return defaulttimezone;
	}

	public void setDefaulttimezone(String defaulttimezone) {
		this.defaulttimezone = defaulttimezone;
	}

	@Column(name = "currenttimezone")
	public String getCurrenttimezone() {
		return currenttimezone;
	}

	public void setCurrenttimezone(String currenttimezone) {
		this.currenttimezone = currenttimezone;
	}

	@ManyToOne
	@JoinColumn(name = "dateformat_id")
	public NTDateFormat getDateformat() {
		return dateformat;
	}

	public void setDateformat(NTDateFormat dateformat) {
		this.dateformat = dateformat;
	}

	@ManyToOne
	@JoinColumn(name = "timeformat_id")
	public NTTimeFormat getTimeformat() {
		return timeformat;
	}

	public void setTimeformat(NTTimeFormat timeformat) {
		this.timeformat = timeformat;
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
	@JoinColumn(name = "usergroup_id")
	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	@Column(name = "last_logged_on")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getLast_logged_on() {
		return last_logged_on;
	}

	public void setLast_logged_on(Timestamp last_logged_on) {
		this.last_logged_on = last_logged_on;
	}

	@Column(name = "is_online")
	public int getIs_online() {
		return is_online;
	}

	public void setIs_online(int is_online) {
		this.is_online = is_online;
	}

	@Column(name = "last_pass_reset_date")
	public Date getLast_pass_reset_date() {
		return last_pass_reset_date;
	}

	public void setLast_pass_reset_date(Date last_pass_reset_date) {
		this.last_pass_reset_date = last_pass_reset_date;
	}

	@Column(name = "is_wt_user")
	public int getIs_wt_user() {
		return is_wt_user;
	}

	public void setIs_wt_user(int is_wt_user) {
		this.is_wt_user = is_wt_user;
	}


	@Column(name = "ws_enabled")
	public boolean isWs_enabled() {
		return ws_enabled;
	}

	public void setWs_enabled(boolean ws_enabled) {
		this.ws_enabled = ws_enabled;
	}

	@Column(name = "max_ws_sessions")
	public int getMax_ws_sessions() {
		return max_ws_sessions;
	}

	public void setMax_ws_sessions(int max_ws_sessions) {
		this.max_ws_sessions = max_ws_sessions;
	}

	@Column(name = "web_enabled")
	public boolean isWeb_enabled() {
		return web_enabled;
	}

	public void setWeb_enabled(boolean web_enabled) {
		this.web_enabled = web_enabled;
	}

	@Column(name = "reset_password")
	public boolean isResetPassword() {
		return resetPassword;
	}

	public void setResetPassword(boolean resetPassword) {
		this.resetPassword = resetPassword;
	}

	@Column(name = "account_locked")
	public boolean isAccountLocked() {
		return accountLocked;
	}

	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	@Column(name = "failed_logins")
	public int getFailedLogins() {
		return failedLogins;
	}

	public void setFailedLogins(int failedLogins) {
		this.failedLogins = failedLogins;
	}

	@Column(name = "inboundQueue")
	public boolean isInboundQueue() {
		return inboundQueue;
	}

	public void setInboundQueue(boolean inboundQueue) {
		this.inboundQueue = inboundQueue;
	}

	@Column(name = "loadpercentage")
	public double getLoadPercentage() {
		return loadPercentage;
	}

	public void setLoadPercentage(double loadPercentage) {
		this.loadPercentage = loadPercentage;
	}

	@Column(name = "inbound")
	public boolean isInbound() {
		return inbound;
	}

	public void setInbound(boolean inbound) {
		this.inbound = inbound;
	}

	@Column(name = "acaa")
	public boolean isAcaa() {
		return acaa;
	}

	public void setAcaa(boolean acaa) {
		this.acaa = acaa;
	}

	@Column(name = "damaged")
	public boolean isDamaged() {
		return damaged;
	}

	public void setDamaged(boolean damaged) {
		this.damaged = damaged;
	}

	@Column(name = "load_unassigned")
	public boolean isLoad_unassigned() {
		return load_unassigned;
	}

	public void setLoad_unassigned(boolean load_unassigned) {
		this.load_unassigned = load_unassigned;
	}

	@Transient
	public String getStationCode() {
		return station.getStationcode();
	}
}
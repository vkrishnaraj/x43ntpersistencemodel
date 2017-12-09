/*
 * Created on Jul 14, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "agent")
public class Agent {

	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private int timeout;
	private String userName;
	private String password;
	private boolean active;
	private Station station;
	private String companyCode;
	private String defaultLocale;
	private String currentLocale;
	private String defaultCurrency;
	private String defaultTimezone;
	private String currentTimezone;
	private NTDateFormat dateFormat;
	private NTTimeFormat timeFormat;
	private Work_Shift shift;
	private UserGroup userGroup;
	private Timestamp lastLoggedOn;
	private int online;
	private Date lastPasswordResetDate;
	private int wtUser;
	private boolean wsEnabled;
	private int maxWsSessions;
	private boolean webEnabled;
	private boolean resetPassword;
	private boolean accountLocked;
	private int failedLogins;
	private boolean inboundQueue;
	private double loadPercentage;
	private boolean inbound;
	private boolean acaa;
	private boolean damaged;
	private boolean loadUnassigned;

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
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "mname")
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "lastname")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "timeout")
	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	@Column(name = "username")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	@Column(name = "defaultlocale")
	public String getDefaultLocale() {
		return defaultLocale;
	}

	public void setDefaultLocale(String defaultLocale) {
		this.defaultLocale = defaultLocale;
	}

	@Column(name = "currentlocale")
	public String getCurrentLocale() {
		return currentLocale;
	}

	public void setCurrentLocale(String currentLocale) {
		this.currentLocale = currentLocale;
	}

	@Column(name = "defaultcurrency")
	public String getDefaultCurrency() {
		return defaultCurrency;
	}

	public void setDefaultCurrency(String defaultCurrency) {
		this.defaultCurrency = defaultCurrency;
	}

	@Column(name = "defaulttimezone")
	public String getDefaultTimezone() {
		return defaultTimezone;
	}

	public void setDefaultTimezone(String defaultTimezone) {
		this.defaultTimezone = defaultTimezone;
	}

	@Column(name = "currenttimezone")
	public String getCurrentTimezone() {
		return currentTimezone;
	}

	public void setCurrentTimezone(String currentTimezone) {
		this.currentTimezone = currentTimezone;
	}

	@ManyToOne
	@JoinColumn(name = "dateformat_id")
	public NTDateFormat getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(NTDateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	@ManyToOne
	@JoinColumn(name = "timeformat_id")
	public NTTimeFormat getTimeFormat() {
		return timeFormat;
	}

	public void setTimeFormat(NTTimeFormat timeFormat) {
		this.timeFormat = timeFormat;
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
	public Timestamp getLastLoggedOn() {
		return lastLoggedOn;
	}

	public void setLastLoggedOn(Timestamp lastLoggedOn) {
		this.lastLoggedOn = lastLoggedOn;
	}

	@Column(name = "is_online")
	public int getOnline() {
		return online;
	}

	public void setOnline(int online) {
		this.online = online;
	}

	@Column(name = "last_pass_reset_date")
	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}

	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}

	@Column(name = "is_wt_user")
	public int getWtUser() {
		return wtUser;
	}

	public void setWtUser(int wtUser) {
		this.wtUser = wtUser;
	}

	@Column(name = "ws_enabled")
	public boolean isWsEnabled() {
		return wsEnabled;
	}

	public void setWsEnabled(boolean wsEnabled) {
		this.wsEnabled = wsEnabled;
	}

	@Column(name = "max_ws_sessions")
	public int getMaxWsSessions() {
		return maxWsSessions;
	}

	public void setMaxWsSessions(int maxWsSessions) {
		this.maxWsSessions = maxWsSessions;
	}

	@Column(name = "web_enabled")
	public boolean isWebEnabled() {
		return webEnabled;
	}

	public void setWebEnabled(boolean webEnabled) {
		this.webEnabled = webEnabled;
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
	public boolean isLoadUnassigned() {
		return loadUnassigned;
	}

	public void setLoadUnassigned(boolean loadUnassigned) {
		this.loadUnassigned = loadUnassigned;
	}
}
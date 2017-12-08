/*
 * Created on Jul 14, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "agent")
public class Agent implements Serializable {

	private static final long serialVersionUID = 6039540000777064696L;

	private int Agent_ID;
	private Station station;
	private int usergroup_id;
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
	private int is_wt_user;
	private boolean resetPassword;
	private int failedLogins;

	private Date last_logged_on;
	private int is_online;
	private Date last_pass_reset_date;
	private boolean accountLocked;

	private boolean web_enabled;
	private boolean ws_enabled;
	private int max_ws_sessions;
	private UserGroup cachedGroup = null;

	private boolean inboundQueue;
	private double loadpercentage;
	private boolean inbound;
	private boolean acaa;
	private boolean damaged;

	private boolean load_unassigned;

	public Agent() { }

	public Agent(int Agent_ID) {
		this.Agent_ID = Agent_ID;
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
			sb.append(firstname.substring(0, 1).toUpperCase());
		}
		if (mname != null && mname.length() > 1) {
			sb.append(mname.substring(0, 1).toUpperCase());
		}
		if (lastname != null && lastname.length() > 1) {
			sb.append(lastname.substring(0, 1).toUpperCase());
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

	public int getUsergroup_id() {
		return usergroup_id;
	}

	public void setUsergroup_id(int usergroup_id) {
		this.usergroup_id = usergroup_id;
		cachedGroup = null;
	}

	@Transient
	public UserGroup getGroup() {
		return cachedGroup;
	}

	public void setGroup(UserGroup group) {
		this.cachedGroup = group;
		this.usergroup_id = group.getUserGroup_ID();
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

	public Date getLast_logged_on() {
		return last_logged_on;
	}

	public void setLast_logged_on(Date last_logged_on) {
		this.last_logged_on = last_logged_on;
	}
	

	public Date getLast_pass_reset_date() {
		return last_pass_reset_date;
	}

	public void setLast_pass_reset_date(Date last_pass_reset_date) {
		this.last_pass_reset_date = last_pass_reset_date;
	}
	
	
	public boolean isWeb_enabled() {
		return web_enabled;
	}

	public void setWeb_enabled(boolean web_enabled) {
		this.web_enabled = web_enabled;
	}

	public boolean isWs_enabled() {
		return ws_enabled;
	}

	public void setWs_enabled(boolean ws_enabled) {
		this.ws_enabled = ws_enabled;
	}
	
	public int getMax_ws_sessions() {
		return max_ws_sessions;
	}

	public void setMax_ws_sessions(int max_ws_sessions) {
		this.max_ws_sessions = max_ws_sessions;
	}

	public int getIs_wt_user() {
		return is_wt_user;
	}

	public void setIs_wt_user(int is_wt_user) {
		this.is_wt_user = is_wt_user;
	}
	
	public boolean isReset_password() {
		return resetPassword;
	}

	public void setReset_password(boolean resetPassword) {
		this.resetPassword = resetPassword;
	}

	public int getFailed_logins() {
		return failedLogins;
	}

	public void setFailed_logins(int failedLogins) {
		this.failedLogins = failedLogins;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer(2000);
		sb.append("Agent ID=" + this.getAgent_ID() + " fname=" + this.getFirstname() + " lname="
				+ this.getLastname() + " timeout=" + this.getTimeout() + " username=" + this.getUsername()
				+ " password=" + this.getPassword() + " active=" + this.isActive() + " dlocale="
				+ this.getDefaultlocale() + " clocale=" + this.getCurrentlocale() + " dcure="
				+ this.getDefaultcurrency());
		sb.append("\n\t " + this.getStation());
		return sb.toString();
	}

	public String toXML() {
		StringBuffer sb = new StringBuffer("<agent>");
		sb.append("<Agent_ID>" + Agent_ID + "</Agent_ID>");
		sb.append("<username>" + username + "</username>");
		sb.append(station.toXML());
		sb.append("</agent>");
		return sb.toString();
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

	public double getLoadpercentage() {
		return loadpercentage;
	}

	public void setLoadpercentage(double loadpercentage) {
		this.loadpercentage = loadpercentage;
	}	
	
	public boolean getInbound() {
		return inbound;
	}

	public void setInbound(boolean inbound) {
		this.inbound = inbound;
	}	

	public boolean getAcaa() {
		return acaa;
	}

	public void setAcaa(boolean acaa) {
		this.acaa = acaa;
	}	

	public boolean getDamaged() {
		return damaged;
	}

	public void setDamaged(boolean damaged) {
		this.damaged = damaged;
	}

	public boolean isLoad_unassigned() {
		return load_unassigned;
	}

	public void setLoad_unassigned(boolean load_unassigned) {
		this.load_unassigned = load_unassigned;
	}
}
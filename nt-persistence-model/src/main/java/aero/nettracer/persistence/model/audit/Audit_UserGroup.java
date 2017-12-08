package aero.nettracer.persistence.model.audit;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;

import aero.nettracer.commons.constant.GenericConstants;
import aero.nettracer.commons.utils.GenericDateUtils;
import aero.nettracer.persistence.model.Agent;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "Audit_UserGroup")
public class Audit_UserGroup implements Serializable {

	private int audit_id;
	private int UserGroup_ID;
	private String description;
	private String description2;
	private String companycode_ID;
	private Set<Audit_GroupComponentPolicy> componentPolicies;
	private double luvlimit;
	private double bsolimit;
	private String autoProvisionGroupName;
	private Agent modifying_agent;
	private Date time_modified;
	private String reason_modified;
	private String _DATEFORMAT; // current login agent's date format
	private String _TIMEFORMAT; // current login agent's time format
	private TimeZone _TIMEZONE; // timezone

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
	public String getDisplaytime_modified() {
		Date completedate = GenericDateUtils.convertToDate(this.getTime_modified().toString(),
				GenericConstants.DB_DATETIMEFORMAT, null);
		return GenericDateUtils.formatDate(completedate, _DATEFORMAT + " " + _TIMEFORMAT, null, _TIMEZONE);
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

	@OneToMany(mappedBy = "audit_usergroup",fetch= FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "audit_policy_id")
	public Set<Audit_GroupComponentPolicy> getComponentPolicies() {
		return componentPolicies;
	}

	public void setComponentPolicies(Set<Audit_GroupComponentPolicy> componentPolicies) {
		this.componentPolicies = componentPolicies;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription2() {
		return description2;
	}

	public void setDescription2(String description) {
		this.description2 = description;
	}

	public int getUserGroup_ID() {
		return UserGroup_ID;
	}

	public void setUserGroup_ID(int userGroup_ID) {
		UserGroup_ID = userGroup_ID;
	}

	public String getCompanycode_ID() {
		return companycode_ID;
	}

	public void setCompanycode_ID(String companycode_ID) {
		this.companycode_ID = companycode_ID;
	}

	@Id
	@GeneratedValue
	public int getAudit_id() {
		return audit_id;
	}

	public void setAudit_id(int audit_id) {
		this.audit_id = audit_id;
	}
	
	public double getLuvlimit() {
		return luvlimit;
	}
	
	public void setLuvlimit(double luvlimit) {
		this.luvlimit = luvlimit;
	}
	
	public double getBsolimit() {
		return bsolimit;
	}
	
	public void setBsolimit(double bsolimit) {
		this.bsolimit = bsolimit;
	}

	public String getAutoProvisionGroupName() {
		return autoProvisionGroupName;
	}

	public void setAutoProvisionGroupName(String autoProvisionGroupName) {
		this.autoProvisionGroupName = autoProvisionGroupName;
	}
	
}
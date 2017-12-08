package aero.nettracer.persistence.model.audit;

import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;

import aero.nettracer.commons.constant.GenericConstants;
import aero.nettracer.commons.utils.GenericDateUtils;
import aero.nettracer.persistence.model.Agent;
import aero.nettracer.persistence.model.DeliverCompany;
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
@Table(name = "audit_deliver_servicelevel")
public class Audit_Deliver_ServiceLevel implements Serializable {
	
	private int audit_servicelevel_id;
	private int servicelevel_ID;
	private String description;
	private DeliverCompany delivercompany;
	private boolean active;
	private Agent modifying_agent;
	private Date time_modified;
	private String reason_modified;
	private String service_code;
	private String _DATEFORMAT; // current login agent's date format
	private String _TIMEFORMAT; // current login agent's time format
	private TimeZone _TIMEZONE; // timezone
	
	@Id
	@GeneratedValue
	public int getAudit_servicelevel_id() {
		return audit_servicelevel_id;
	}

	public void setAudit_servicelevel_id(int audit_servicelevel_id) {
		this.audit_servicelevel_id = audit_servicelevel_id;
	}
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}

	
	public int getServicelevel_ID() {
		return servicelevel_ID;
	}

	public void setServicelevel_ID(int servicelevel_ID) {
		this.servicelevel_ID = servicelevel_ID;
	}
	
	@ManyToOne
	@JoinColumn(name = "delivercompany_ID")
	public DeliverCompany getDelivercompany() {
		return delivercompany;
	}

	public void setDelivercompany(DeliverCompany delivercompany) {
		this.delivercompany = delivercompany;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	public String getService_code() {
		return service_code;
	}

	public void setService_code(String service_code) {
		this.service_code = service_code;
	}
	
}
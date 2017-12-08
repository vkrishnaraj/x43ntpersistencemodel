package aero.nettracer.persistence.model.audit;

import java.io.Serializable;
import java.util.TimeZone;

import aero.nettracer.commons.constant.GenericConstants;
import aero.nettracer.commons.utils.GenericDateUtils;
import aero.nettracer.persistence.model.Agent;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Audit_Remark")
public class Audit_Remark implements Serializable {

	private int id;
	private int Remark_ID;
	private Agent agent;
	private String createtime;
	private String remarktext = "";
	private int remarktype;
	private String _DATEFORMAT;
	private String _TIMEFORMAT;
	private TimeZone _TIMEZONE;
	private boolean secure; 
	
	private Audit_Incident audit_incident;

	private Integer subtype;
	private Integer callBackStatus;

	@ManyToOne
	@JoinColumn(name = "audit_incident_id")
	public Audit_Incident getAudit_incident() {
		return audit_incident;
	}

	public void setAudit_incident(Audit_Incident audit_incident) {
		this.audit_incident = audit_incident;
	}

	@ManyToOne
	@JoinColumn(name = "agent_ID")
	public Agent getAgent() {
		return agent;
	}

	@Transient
	public String getAgentStation() {
		if (agent != null) return agent.getStation().getStationcode();
		else return null;
	}

	@Transient
	public String getAgentUsername() {
		if (agent != null) return agent.getUsername();
		else return null;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public String getCreatetime() {
		return createtime;
	}

	@Transient
	public String getDispcreatetime() {
		return GenericDateUtils.formatDate(createtime, GenericConstants.DB_DATETIMEFORMAT, get_DATEFORMAT()
				+ " " + get_TIMEFORMAT(), null, get_TIMEZONE());
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public int getRemark_ID() {
		return Remark_ID;
	}

	public void setRemark_ID(int remark_ID) {
		Remark_ID = remark_ID;
	}

	public String getRemarktext() {
		return remarktext;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRemarktext(String remarktext) {
		this.remarktext = remarktext;
	}

	public int getRemarktype() {
		return remarktype;
	}

	public void setRemarktype(int remarktype) {
		this.remarktype = remarktype;
	}
	
	@Transient
	public String getReadonlyremarktext() {
		if(remarktext != null)
		{
			return remarktext.replaceAll("\r\n", "<br>");
		}
		else
		{
			return "";
		}
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

	//NTFIXME
	/*public boolean equals(Object obj) {
		Audit_Remark aam = (Audit_Remark) obj;
		boolean ret = true;

		if (AuditOHDUtils.notEqualObjects(aam.getRemarktext(), this.getRemarktext())) {
			ret = false;
		}
		return ret;
	}*/
	
	public boolean isSecure() {
		return secure;
	}

	public void setSecure(boolean secure) {
		this.secure = secure;
	}

	@Transient
	public Integer getSubtype() {
		return subtype;
	}

	public void setRemarkSubtype(Integer remarkSubtype) {
		this.subtype = remarkSubtype;
	}

	@Column(name = "callback_status")
	public Integer getCallBackStatus() {
		return this.callBackStatus;
	}

	public void setCallBackStatus(Integer actionStatus) {
		this.callBackStatus = actionStatus;
	}
}
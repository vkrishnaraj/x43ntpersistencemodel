package aero.nettracer.persistence.model.salvage;

import aero.nettracer.commons.constant.GenericConstants;
import aero.nettracer.commons.utils.CommonsConstants;
import aero.nettracer.commons.utils.GenericDateUtils;
import aero.nettracer.persistence.model.Agent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.TimeZone;

@Entity
@Table(name = "salvage_remark")
public class SalvageRemark {

	private int id;
	private Agent agent;
	private Timestamp createtime;
	private String remarktext = "";
	private int remarktype;

	@Id
	@GeneratedValue
	@Column(name="remark_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "agent_id", nullable = false)
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@Column(name = "createtime")
	@Temporal(value = TemporalType.TIMESTAMP)
	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	@Lob
	@Column(name = "remarktext")
	public String getRemarktext() {
		return remarktext;
	}

	public void setRemarktext(String remarktext) {
		this.remarktext = remarktext;
	}

	@Column(name = "remarktype")
	public int getRemarktype() {
		return remarktype;
	}

	public void setRemarktype(int remarktype) {
		this.remarktype = remarktype;
	}	
	
	@Transient
	public String getDispcreatetime() {
		return GenericDateUtils.formatDate(createtime, get_DATEFORMAT() + " " + get_TIMEFORMAT(), null, get_TIMEZONE());
	}

	@Transient
	public String get_DATEFORMAT() {
		if (getAgent() != null) {
			return agent.getDateformat().getFormat();
		}
		return GenericConstants.DISPLAY_DATEFORMAT;
	}

	@Transient
	public String get_TIMEFORMAT() {
		if (getAgent() != null) {
			return agent.getTimeformat().getFormat();
		}
		return GenericConstants.DISPLAY_TIMEFORMAT;
	}

	@Transient
	public TimeZone get_TIMEZONE() {
		if (getAgent() != null) {
			return TimeZone.getTimeZone(agent.getDefaulttimezone());
		}
		return TimeZone.getTimeZone(CommonsConstants.DEFAULT_AGENT_TIMEZONE);
	}

	@Transient
	public String getAgentStation() {
		if (agent != null) return agent.getStationCode();
		else return null;
	}

	@Transient
	public String getAgentUsername() {
		if (agent != null) return agent.getUsername();
		else return null;
	}

}

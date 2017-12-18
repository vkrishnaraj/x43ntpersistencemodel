package aero.nettracer.persistence.model;

import aero.nettracer.persistence.util.RemarkType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.sql.Timestamp;

@Entity
@Table(name = "remark")
public class Remark {

	private int id;
	private Agent agent;
	private Timestamp createtime;
	private String remarktext = "";
	private Incident incident;
	private OHD ohd;
	private int remarktype;
	private boolean secure;
	private ForwardLink forwardLink;
	private BDO bdo;
	private ExpensePayout expensePayout;
	private Integer subtype;
  	private Integer callBackStatus;
	private String label;

	@Id
	@GeneratedValue
	@Column(name = "remark_id")
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
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	@Column(name = "remarktext")
	public String getRemarktext() {
		return remarktext;
	}

	public void setRemarktext(String remarktext) {
		this.remarktext = remarktext;
	}

	@ManyToOne
	@JoinColumn(name = "incident_id")
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	@ManyToOne
	@JoinColumn(name = "ohd_id")
	public OHD getOhd() {
		return ohd;
	}

	public void setOhd(OHD ohd) {
		this.ohd = ohd;
	}

	@Column(name = "remarktype")
	public int getRemarktype() {
		return remarktype;
	}

	public void setRemarktype(int remarktype) {
		this.remarktype = remarktype;
	}

	@Column(name = "secure")
	public boolean isSecure() {
		return secure;
	}

	public void setSecure(boolean secure) {
		this.secure = secure;
	}

	@OneToOne
	@JoinColumn(name = "forwardlink_id")
	public ForwardLink getForwardLink() {
		return forwardLink;
	}

	public void setForwardLink(ForwardLink forwardLink) {
		this.forwardLink = forwardLink;
	}

	@OneToOne
	@JoinColumn(name = "bdo_id")
	public BDO getBdo() {
		return bdo;
	}

	public void setBdo(BDO bdo) {
		this.bdo = bdo;
	}

	@ManyToOne
	@JoinColumn(name = "expensepayout_id")
	public ExpensePayout getExpensePayout() {
		return expensePayout;
	}

	public void setExpensePayout(ExpensePayout expensePayout) {
		this.expensePayout = expensePayout;
	}

	@Column(name = "subtype")
	public Integer getSubtype() {
		return subtype;
	}

	public void setSubtype(Integer subtype) {
		this.subtype = subtype;
	}

	@Column(name = "callback_status")
	public Integer getCallBackStatus() {
		return this.callBackStatus;
	}

	public void setCallBackStatus(Integer actionStatus) {
		this.callBackStatus = actionStatus;
	}

	@Transient
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Transient
	public String getAgentStationCode() {
		if (agent != null) return agent.getStationCode();
		else return null;
	}
	@Transient
	public String getAgentUsername() {
		if (agent != null) return agent.getUsername();
		else return null;
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
	public String getRemarkTypeDescription() {
		return RemarkType.getDescriptionByKey(remarktype);
	}

	public void setRemarkTypeDescription(String description) {
		remarktype = RemarkType.getKeyByDescription(description);
	}

}
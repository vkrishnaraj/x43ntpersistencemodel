package aero.nettracer.persistence.model.communications;

import aero.nettracer.persistence.model.Agent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;

@Entity
@Table(name = "incident_activity_remark")
public class IncidentActivityRemark {
	
	private long id;
	private Agent agent;
	private Timestamp createDate;
	private String remarkText;
	private IncidentActivity incidentActivity;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "agent", nullable = false)
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "createdate")
	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "remarktext", nullable = false)
	public String getRemarkText() {
		return remarkText;
	}

	public void setRemarkText(String remarkText) {
		this.remarkText = remarkText;
	}

	@ManyToOne
	@JoinColumn(name = "incidentActivity", nullable = false)
	public IncidentActivity getIncidentActivity() {
		return incidentActivity;
	}

	public void setIncidentActivity(IncidentActivity incidentActivity) {
		this.incidentActivity = incidentActivity;
	}

}

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

@Entity
@Table(name = "label")
public class Label {

	private long id;
	private Agent agent;
	private String text;
	private Timestamp lastUpdate;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long labelId) {
		this.id = labelId;
	}

	@Column(name = "text")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "lastupdate", insertable = false, updatable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@ManyToOne
	@JoinColumn(name = "agent_id", nullable = false)
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@Transient
	public String getHtmlFormatedText() {
		return (text == null || text.trim().isEmpty()) ? "</br>" : text.replaceAll("[\n\r]", "</br>");
	}
}

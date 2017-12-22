package aero.nettracer.persistence.model;

import javax.persistence.CascadeType;
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
@Table(name = "lfremark")
public class LFRemark {

	private long id;
	private long calltime;
	private int outcome;
	private int agentId;
	private String remarktext;
	private Timestamp remarkdate;
	private int type;
	private LFFound found;
	private LFLost lost;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="calltime")
	public long getCalltime() {
		return calltime;
	}

	public void setCalltime(long calltime) {
		this.calltime = calltime;
	}

	@Column(name = "outcome")
	public int getOutcome() {
		return outcome;
	}

	public void setOutcome(int outcome) {
		this.outcome = outcome;
	}

	@Column(name = "agent_id", nullable = false)
	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	@Column(name="remark_text",length = 2048)
	public String getRemarktext() {
		return remarktext;
	}

	public void setRemarktext(String remarktext) {
		this.remarktext = remarktext;
	}

	@Column(name="remark_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getRemarkdate() {
		return remarkdate;
	}

	public void setRemarkdate(Timestamp remarkdate) {
		this.remarkdate = remarkdate;
	}

	@Column(name="remark_type")
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "found_id")
	public LFFound getFound() {
		return found;
	}

	public void setFound(LFFound found) {
		this.found = found;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lost_id")
	public LFLost getLost() {
		return lost;
	}

	public void setLost(LFLost lost) {
		this.lost = lost;
	}

}

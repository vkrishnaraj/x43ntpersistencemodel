package aero.nettracer.persistence.model.wtq;

import aero.nettracer.persistence.model.Agent;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.sql.Timestamp;

@Entity
@Table(name="wt_queue")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="wtq_action", discriminatorType = DiscriminatorType.STRING)
public abstract class WorldTracerQueue {

	//stored in db as string, max length of 20 chars
	public static enum WtqStatus {PENDING, SUCCESS, FAIL, REPLACED, CANCELED, LOCKED}
	
	private long id;
	private int attempts;
	private Timestamp createdate;
	private WtqStatus status = WtqStatus.PENDING;
	private Agent agent = null;
	private WorldTracerQueue replacement = null;
	private String error_detail = null;

	@Id
	@GeneratedValue
	@Column(name = "wt_queue_id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "attempts")
	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	@Column(name = "createdate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="wtq_status", nullable=false)
	public WtqStatus getStatus() {
		return status;
	}

	public void setStatus(WtqStatus status) {
		this.status = status;
	}

	@ManyToOne
	@JoinColumn(name="agent_id", nullable = false)
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@ManyToOne
	@JoinColumn(name = "replacement_id")
	public WorldTracerQueue getReplacement() {
		return replacement;
	}

	public void setReplacement(WorldTracerQueue replacement) {
		this.replacement = replacement;
	}

	@Column(name = "error_detail")
	public String getError_detail() {
		return error_detail;
	}

	public void setError_detail(String error_detail) {
		this.error_detail = error_detail;
	}

	@Transient
	public abstract String getExistsQuery();
	
	@Transient
	public abstract Object[] getExistsParameters();

}

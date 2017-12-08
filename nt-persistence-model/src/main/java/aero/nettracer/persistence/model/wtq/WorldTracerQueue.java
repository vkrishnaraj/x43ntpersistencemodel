package aero.nettracer.persistence.model.wtq;

import java.io.Serializable;
import java.util.Date;

import aero.nettracer.commons.utils.CommonsUtils;
import aero.nettracer.persistence.model.Agent;
import javax.persistence.Basic;
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
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name="wt_queue")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="wtq_action", discriminatorType = DiscriminatorType.STRING)
public abstract class WorldTracerQueue implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4144455648325224860L;

	//stored in db as string, max length of 20 chars
	public static enum WtqStatus {PENDING, SUCCESS, FAIL, REPLACED, CANCELED, LOCKED}
	
	private long wt_queue_id;

	private Agent agent = null;
	private Date createdate = CommonsUtils.getGMTDate();
	private int attempts = 0;
	private WtqStatus status = WtqStatus.PENDING;
	private WorldTracerQueue replacement = null;
	private String error_detail = null;


	@Id @GeneratedValue
	public long getWt_queue_id() {
		return wt_queue_id;
	}

	private void setWt_queue_id(long wt_queue_id) {
		this.wt_queue_id = wt_queue_id;
	}

	@ManyToOne(targetEntity = Agent.class)
	@JoinColumn(name="agent_id", nullable = false)
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@Basic
	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Column(nullable=false)
	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public String getError_detail() {
		return error_detail;
	}

	public void setError_detail(String error_detail) {
		this.error_detail = error_detail;
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable=false, length = 20, name="wtq_status" )
	public WtqStatus getStatus() {
		return status;
	}

	public void setStatus(WtqStatus status) {
		this.status = status;
	}
	
	@ManyToOne(targetEntity = WorldTracerQueue.class)
	@JoinColumn(name = "replacement_id", nullable = true)
	public WorldTracerQueue getReplacement() {
		return replacement;
	}

	public void setReplacement(WorldTracerQueue replacement) {
		this.replacement = replacement;
	}
	
	@Transient
	public abstract String getExistsQuery();
	
	@Transient
	public abstract Object[] getExistsParameters();

}

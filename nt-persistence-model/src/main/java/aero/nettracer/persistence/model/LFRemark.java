package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class LFRemark implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5769095740895350735L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="calltime")
	private long calltime;
	
	@Column(name="outcome")
	private int outcome;

	@Column(name = "agent_id", nullable = false)
	private int agentId;
	
	@Column(name="remark_text",length = 2048)
	private String remarktext;
	
	@Column(name="remark_datetime")
	private Date remarkdate;
	
	@Column(name="remark_type")
	private int type;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "found_id", nullable = true)
	@Fetch(FetchMode.SELECT)
	private LFFound found;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lost_id", nullable = true)
	@Fetch(FetchMode.SELECT)
	private LFLost lost;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCalltime() {
		return calltime;
	}

	public void setCalltime(long calltime) {
		this.calltime = calltime;
	}

	public int getOutcome() {
		return outcome;
	}

	public void setOutcome(int outcome) {
		this.outcome = outcome;
	}

	public void setFound(LFFound found) {
		this.found = found;
	}

	public LFFound getFound() {
		return found;
	}

	public void setLost(LFLost lost) {
		this.lost = lost;
	}

	public LFLost getLost() {
		return lost;
	}

	
	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public String getRemarktext() {
		return remarktext;
	}

	public void setRemarktext(String remarktext) {
		this.remarktext = remarktext;
	}

	public Date getRemarkdate() {
		return remarkdate;
	}

	public void setRemarkdate(Date remarkdate) {
		this.remarkdate = remarkdate;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}

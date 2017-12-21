package aero.nettracer.persistence.model.detection;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import aero.nettracer.persistence.util.AES;
import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = true)
public class LFMatchDetail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8133424320220693299L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="description",length = 255)
	private String description;
	
	@Column(name="lost_value",length = 255)
	private String lostValue;
	
	@Column(name="found_value",length = 255)
	private String foundValue;
	
	@ManyToOne(targetEntity = aero.nettracer.persistence.model.detection.LFMatchHistory.class)
	@JoinColumn(name="match_history_id")
	private LFMatchHistory matchHistory;

	@Column(name="score")
	private double score;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LFMatchHistory getMatchHistory() {
		return matchHistory;
	}

	public void setMatchHistory(LFMatchHistory matchHistory) {
		this.matchHistory = matchHistory;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getScore() {
		return score;
	}

	public String getLostValue() {
		return AES.decrypt(lostValue);
	}

	public void setLostValue(String lostValue) {
		this.lostValue = AES.encrypt(lostValue);
	}

	public String getFoundValue() {
		return AES.decrypt(foundValue);
	}

	public void setFoundValue(String foundValue) {
		this.foundValue = AES.encrypt(foundValue);
	}

}

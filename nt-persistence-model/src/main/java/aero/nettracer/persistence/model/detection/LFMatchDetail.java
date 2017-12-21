package aero.nettracer.persistence.model.detection;

import aero.nettracer.persistence.util.AES;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lfmatchdetail")
public class LFMatchDetail {
	
	private long id;
	private String description;
	private LFMatchHistory matchHistory;
	private double score;
	private String lostValue;
	private String foundValue;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	@JoinColumn(name="match_history_id")
	public LFMatchHistory getMatchHistory() {
		return matchHistory;
	}

	public void setMatchHistory(LFMatchHistory matchHistory) {
		this.matchHistory = matchHistory;
	}

	@Column(name = "score")
	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Column(name="lost_value")
	public String getLostValue() {
		return AES.decrypt(lostValue);
	}

	public void setLostValue(String lostValue) {
		this.lostValue = AES.encrypt(lostValue);
	}

	@Column(name="found_value")
	public String getFoundValue() {
		return AES.decrypt(foundValue);
	}

	public void setFoundValue(String foundValue) {
		this.foundValue = AES.encrypt(foundValue);
	}

}

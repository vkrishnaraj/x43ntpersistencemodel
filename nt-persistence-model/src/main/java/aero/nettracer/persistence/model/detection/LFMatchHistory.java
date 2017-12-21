package aero.nettracer.persistence.model.detection;

import aero.nettracer.commons.utils.CommonsConstants;
import aero.nettracer.persistence.model.LFFound;
import aero.nettracer.persistence.model.LFLost;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "lfmatchhistory")
public class LFMatchHistory {

	private long id;
	private LFFound found;
	private LFLost lost;
	private int statusId;
	private double score;
	private Timestamp matchTimeStamp;
	private List<LFMatchDetail> details;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@OneToOne
	public LFFound getFound() {
		return found;
	}

	public void setFound(LFFound found) {
		this.found = found;
	}

	@OneToOne
	public LFLost getLost() {
		return lost;
	}

	public void setLost(LFLost lost) {
		this.lost = lost;
	}

	@Column(name = "status_id", nullable = false)
	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	@Column(name = "score")
	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Column(name = "match_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getMatchTimeStamp() {
		return matchTimeStamp;
	}

	public void setMatchTimeStamp(Timestamp matchTimeStamp) {
		this.matchTimeStamp = matchTimeStamp;
	}

	@OneToMany(mappedBy = "matchHistory", cascade = CascadeType.ALL)
	public List<LFMatchDetail> getDetails() {
		return details;
	}

	public void setDetails(List<LFMatchDetail> details) {
		this.details = details;
	}
	
	@Transient
	public double getTotalScore(){
		if(details == null){
			return 0;
		}
		double score = 0;
		for(LFMatchDetail detail:details){
			score += detail.getScore();
		}
		return score;
	}

	public boolean hasClosedLostOrFoundReport(){
		return (getLost().getStatusId() == CommonsConstants.LF_STATUS_CLOSED || getFound().getStatusId() == CommonsConstants.LF_STATUS_CLOSED);
	}

}

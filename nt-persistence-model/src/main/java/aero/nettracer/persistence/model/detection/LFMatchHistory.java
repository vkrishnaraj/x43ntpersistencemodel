package aero.nettracer.persistence.model.detection;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

import aero.nettracer.lfservice.constants.LFServiceConstants;
import aero.nettracer.persistence.model.LFFound;
import aero.nettracer.persistence.model.LFLost;

@Entity
@Proxy(lazy = false)
public class LFMatchHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2203263893678251215L;

	@Id
	@GeneratedValue
	private long id;
	
	@OneToOne(targetEntity = aero.nettracer.persistence.model.LFLost.class, cascade = {})//cascade needs to be none
	@Fetch(FetchMode.SELECT)
	private LFLost lost;
	
	@OneToOne(targetEntity = aero.nettracer.persistence.model.LFFound.class, cascade = {})//cascade needs to be none
	@Fetch(FetchMode.SELECT)
	private LFFound found;
	
	@OneToMany(mappedBy = "matchHistory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<LFMatchDetail> details;
	
	@Column(name = "status_id", nullable = false)
	private int statusId;
	
	@Column(name="score")
	private double score;
	
	@Column(name="match_datetime")
	private Date matchTimeStamp;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LFLost getLost() {
		return lost;
	}

	public void setLost(LFLost lost) {
		this.lost = lost;
	}

	public LFFound getFound() {
		return found;
	}

	public void setFound(LFFound found) {
		this.found = found;
	}

	public List<LFMatchDetail> getDetails() {
		return details;
	}

	public void setDetails(List<LFMatchDetail> details) {
		this.details = details;
	}
	
	@Transient
	//TODO this should be refactored NT-6064
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

	public void setScore(double score) {
		this.score = score;
	}

	public double getScore() {
		return score;
	}

	public Date getMatchTimeStamp() {
		return matchTimeStamp;
	}

	public void setMatchTimeStamp(Date matchTimeStamp) {
		this.matchTimeStamp = matchTimeStamp;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	
	public boolean hasClosedLostOrFoundReport(){
		return (getLost().getStatusId() == LFServiceConstants.LF_STATUS_CLOSED || getFound().getStatusId() == LFServiceConstants.LF_STATUS_CLOSED);
	}
}

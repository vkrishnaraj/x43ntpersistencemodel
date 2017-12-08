package aero.nettracer.persistence.model.onlineclaims;

import java.util.Date;

import aero.nettracer.persistence.model.communications.IncidentActivity;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "oc_file")
public class OCFile {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne(targetEntity = OnlineClaim.class)
	@JoinColumn(name = "claimId", nullable = false)
	private OnlineClaim claim;

	@ManyToOne(targetEntity = IncidentActivity.class)
	@JoinColumn(name = "incActId", nullable = true)
	private IncidentActivity incAct;

	@Column(length = 100)
	private String filename;

	@Column(length = 1000)
	private String path;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUploaded;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateViewed;
	
	@Basic
	private boolean interim;
	
	private boolean publish;
	private int statusId;
	private Date dateTimeDeleted;
	private String agentDeleted;	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Date getDateUploaded() {
		return dateUploaded;
	}

	public void setDateUploaded(Date dateUploaded) {
		this.dateUploaded = dateUploaded;
	}

	public Date getDateViewed() {
		return dateViewed;
	}

	public void setDateViewed(Date dateViewed) {
		this.dateViewed = dateViewed;
	}

	public OnlineClaim getClaim() {
		return claim;
	}

	public void setClaim(OnlineClaim claim) {
		this.claim = claim;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isInterim() {
		return interim;
	}

	public void setInterim(boolean interim) {
		this.interim = interim;
	}
	
	public IncidentActivity getIncAct(){
		return incAct;
	}
	
	public void setIncAct(IncidentActivity incAct){
		this.incAct=incAct;
	}

	public boolean isPublish() {
		return publish;
	}

	public void setPublish(boolean publish) {
		this.publish = publish;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public Date getDateTimeDeleted() {
		return dateTimeDeleted;
	}

	public void setDateTimeDeleted(Date dateTimeDeleted) {
		this.dateTimeDeleted = dateTimeDeleted;
	}

	public String getAgentDeleted() {
		return agentDeleted;
	}

	public void setAgentDeleted(String agentDeleted) {
		this.agentDeleted = agentDeleted;
	}

}

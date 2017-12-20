package aero.nettracer.persistence.model.onlineclaims;

import aero.nettracer.persistence.model.communications.IncidentActivity;

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
@Table(name = "oc_file")
public class OCFile {

	private long id;
	private Timestamp dateUploaded;
	private String filename;
	private OnlineClaim claim;
	private boolean interim;
	private String path;
	private IncidentActivity incAct;
	private boolean publish;
	private Timestamp dateViewed;
	private int statusId;
	private Timestamp dateTimeDeleted;
	private String agentDeleted;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getDateUploaded() {
		return dateUploaded;
	}

	public void setDateUploaded(Timestamp dateUploaded) {
		this.dateUploaded = dateUploaded;
	}

	@Column(name = "filename")
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@ManyToOne
	@JoinColumn(name = "claimid", nullable = false)
	public OnlineClaim getClaim() {
		return claim;
	}

	public void setClaim(OnlineClaim claim) {
		this.claim = claim;
	}

	@Column(name = "interim")
	public boolean isInterim() {
		return interim;
	}

	public void setInterim(boolean interim) {
		this.interim = interim;
	}

	@Column(name = "path")
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@ManyToOne
	@JoinColumn(name = "incactid")
	public IncidentActivity getIncAct(){
		return incAct;
	}

	public void setIncAct(IncidentActivity incAct){
		this.incAct=incAct;
	}

	@Column(name = "publish")
	public boolean isPublish() {
		return publish;
	}

	public void setPublish(boolean publish) {
		this.publish = publish;
	}

	@Column(name = "dateviewed")
	public Timestamp getDateViewed() {
		return dateViewed;
	}

	public void setDateViewed(Timestamp dateViewed) {
		this.dateViewed = dateViewed;
	}

	@Column(name = "statusid")
	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	@Column(name = "datetimedeleted")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getDateTimeDeleted() {
		return dateTimeDeleted;
	}

	public void setDateTimeDeleted(Timestamp dateTimeDeleted) {
		this.dateTimeDeleted = dateTimeDeleted;
	}

	@Column(name = "agentdeleted")
	public String getAgentDeleted() {
		return agentDeleted;
	}

	public void setAgentDeleted(String agentDeleted) {
		this.agentDeleted = agentDeleted;
	}

}

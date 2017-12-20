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
@Table(name = "oc_message")
public class OCMessage {

	private long id;
	private OnlineClaim claim;
	private IncidentActivity incAct;
	private Timestamp dateCreated;
	private String username;
	private String message;
	private Timestamp dateReviewed;
	private boolean publish;
	private int statusId;
	private Timestamp dateTimeDeleted;
	private String agentDeleted;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId(){
		return id;
	}

	public void setId(long id){
		this.id=id;
	}

	@ManyToOne
	@JoinColumn(name = "claimId", nullable = false)
	public OnlineClaim getClaim(){
		return claim;
	}

	public void setClaim(OnlineClaim claim){
		this.claim=claim;
	}

	@ManyToOne
	@JoinColumn(name = "incActId")
	public IncidentActivity getIncAct(){
		return incAct;
	}
	
	public void setIncAct(IncidentActivity incAct){
		this.incAct=incAct;
	}

	@Column(name = "datecreated")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "message")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "datereviewed")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getDateReviewed() {
		return dateReviewed;
	}

	public void setDateReviewed(Timestamp dateReviewed) {
		this.dateReviewed = dateReviewed;
	}

	@Column(name = "publish")
	public boolean isPublish() {
		return publish;
	}

	public void setPublish(boolean publish) {
		this.publish = publish;
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

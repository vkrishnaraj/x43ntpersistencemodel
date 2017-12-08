package aero.nettracer.persistence.model.onlineclaims;

import java.util.Date;

import aero.nettracer.persistence.model.communications.IncidentActivity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "oc_message")
public class OCMessage {
	@Id
	@GeneratedValue
	long id;

	@ManyToOne(targetEntity = OnlineClaim.class)
	@JoinColumn(name = "claimId", nullable = false)
	private OnlineClaim claim;

	@ManyToOne(targetEntity = IncidentActivity.class)
	@JoinColumn(name = "incActId", nullable = true)
	private IncidentActivity incAct;


	private String message;
	private Date dateCreated;
	private Date dateReviewed;
	private String username;
	private boolean publish;
	private int statusId;
	private Date dateTimeDeleted;
	private String agentDeleted;

	public long getId(){
		return id;
	}

	public void setId(long id){
		this.id=id;
	}

	public OnlineClaim getClaim(){
		return claim;
	}

	public void setClaim(OnlineClaim claim){
		this.claim=claim;
	}

	
	public IncidentActivity getIncAct(){
		return incAct;
	}
	
	public void setIncAct(IncidentActivity incAct){
		this.incAct=incAct;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateReviewed() {
		return dateReviewed;
	}

	public void setDateReviewed(Date dateReviewed) {
		this.dateReviewed = dateReviewed;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

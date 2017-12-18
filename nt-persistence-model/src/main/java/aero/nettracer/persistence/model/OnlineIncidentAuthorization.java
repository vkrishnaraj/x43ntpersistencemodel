package aero.nettracer.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "online_incident_authorization")
public class OnlineIncidentAuthorization {

	private int id;
	private String firstName;
	private String lastName;
	private String pnr;
	private String incidentID;
	private Date expireTime;
	private ProactiveNotification pcn;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "pnr")
	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	@Column(name="incident_id")
	public String getIncidentID() {
		return incidentID;
	}

	public void setIncidentID(String incidentID) {
		this.incidentID = incidentID;
	}

	@Column(name="expire_time")
	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	@OneToOne(mappedBy = "oia", cascade = CascadeType.ALL)
	public ProactiveNotification getPcn() {
		return pcn;
	}

	public void setPcn(ProactiveNotification pcn) {
		this.pcn = pcn;
	}

}

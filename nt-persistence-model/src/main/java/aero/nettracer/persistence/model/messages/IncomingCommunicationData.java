package aero.nettracer.persistence.model.messages;

import java.util.Date;

public class IncomingCommunicationData {

	private String incident_ID;
	private String firstname;
	private String lastname;
	private Date communicationdate;
	public IncomingCommunicationData(String incident_ID, String firstname,
			String lastname, Date communicationdate) {
		super();
		this.incident_ID = incident_ID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.communicationdate = communicationdate;
	}
	public String getIncident_ID() {
		return incident_ID;
	}
	public void setIncident_ID(String incident_ID) {
		this.incident_ID = incident_ID;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getCommunicationdate() {
		return communicationdate;
	}
	public void setCommunicationdate(Date communicationdate) {
		this.communicationdate = communicationdate;
	}
	
}

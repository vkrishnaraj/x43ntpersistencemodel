package aero.nettracer.persistence.model.taskmanager;


import aero.nettracer.persistence.model.Incident;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = true)
public class MorningDutiesTask extends GeneralTask {
	
	Incident incident;



	@ManyToOne(targetEntity = Incident.class)
	@JoinColumn(name = "incident_id")
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}
}

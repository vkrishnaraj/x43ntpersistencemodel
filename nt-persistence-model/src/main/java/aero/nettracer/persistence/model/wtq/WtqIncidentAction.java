package aero.nettracer.persistence.model.wtq;

import aero.nettracer.persistence.model.Incident;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Proxy;

@Entity
public abstract class WtqIncidentAction extends WorldTracerQueue {
	private Incident incident;
	
	public WtqIncidentAction() {}
	
	public WtqIncidentAction(Incident incident) {
		this.incident = incident;
	}
	
	@ManyToOne(targetEntity = Incident.class)
	@JoinColumn(name = "incident_id")
	public Incident getIncident() {
		return incident;
	}
	
	public void setIncident(Incident incident) {
		this.incident = incident;
	}
	
	@Override
	@Transient
	public String getExistsQuery() {
		return "from WtqIncidentAction wia where wia.incident.incident_ID = ? and wia.status = ?";
	}

	@Override
	@Transient
	public Object[] getExistsParameters() {
		return new Object[] {incident.getIncident_ID(), this.getStatus()};
	}
}

package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "deliver_servicelevel")
public class Deliver_ServiceLevel {

	private int servicelevel_ID;
	private DeliverCompany delivercompany;
	private String description;
	private boolean active;
	private String service_code;
	private double defaultCost;
	private String mapped_actual_service;
	
	@Id
	@GeneratedValue
	@Column(name = "servicelevel_id")
	public int getServicelevel_ID() {
		return servicelevel_ID;
	}

	public void setServicelevel_ID(int servicelevel_ID) {
		this.servicelevel_ID = servicelevel_ID;
	}

	@ManyToOne
	@JoinColumn(name = "delivercompany_id", nullable = false)
	public DeliverCompany getDelivercompany() {
		return delivercompany;
	}

	public void setDelivercompany(DeliverCompany delivercompany) {
		this.delivercompany = delivercompany;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}

	@Column(name = "active")
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Column(name = "service_code")
	public String getService_code() {
		return service_code;
	}

	public void setService_code(String service_code) {
		this.service_code = service_code;
	}

	@Column(name = "defaultcost")
	public double getDefaultCost() {
		return defaultCost;
	}

	public void setDefaultCost(double defaultCost) {
		this.defaultCost = defaultCost;
	}

	public String getMapped_actual_service() {
		return mapped_actual_service;
	}

	public void setMapped_actual_service(String mapped_actual_service) {
		this.mapped_actual_service = mapped_actual_service;
	}
}
package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "deliver_servicelevel")
public class Deliver_ServiceLevel implements Serializable {
	private int servicelevel_ID;
	private String description;
	private DeliverCompany delivercompany;
	private boolean active;
	private String service_code;
	private double defaultCost;
	private String mapped_actual_service;
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}

	@Id
	@GeneratedValue
	public int getServicelevel_ID() {
		return servicelevel_ID;
	}

	public void setServicelevel_ID(int servicelevel_ID) {
		this.servicelevel_ID = servicelevel_ID;
	}

	@ManyToOne
	@JoinColumn(name = "delivercompany_ID")
	public DeliverCompany getDelivercompany() {
		return delivercompany;
	}

	public void setDelivercompany(DeliverCompany delivercompany) {
		this.delivercompany = delivercompany;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getService_code() {
		return service_code;
	}

	public void setService_code(String service_code) {
		this.service_code = service_code;
	}

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
package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Proxy;


@Entity
@Table(name = "delivercompany")
public class DeliverCompany implements Serializable {

	private int delivercompany_ID;
	private String name;
	private String address;
	private String phone;
	private Set<Deliver_ServiceLevel> servicelevels;
	private boolean active;
	private Company company;
	private DeliveryIntegrationType delivery_integration_type;
	private String integration_key;


	public String getIntegration_key() {
		return integration_key;
	}

	public void setIntegration_key(String integration_key) {
		this.integration_key = integration_key;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Id
	@GeneratedValue
	public int getDelivercompany_ID() {
		return delivercompany_ID;
	}

	public void setDelivercompany_ID(int delivercompany_ID) {
		this.delivercompany_ID = delivercompany_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "delivercompany")
	@OrderBy(clause = "description")
	public Set<Deliver_ServiceLevel> getServicelevels() {
		return servicelevels;
	}

	public void setServicelevels(Set<Deliver_ServiceLevel> servicelevels) {
		this.servicelevels = servicelevels;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@ManyToOne
	@JoinColumn(name = "companycode_ID")
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	public boolean equals(Object o) {
		boolean match = false;
		
		try {
			DeliverCompany obj = (DeliverCompany)o;
			if (obj.getDelivercompany_ID() == this.getDelivercompany_ID()) {
				match = true;
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return match;
	}

	@Enumerated(EnumType.STRING)
	public DeliveryIntegrationType getDelivery_integration_type() {
		return delivery_integration_type;
	}

	public void setDelivery_integration_type(
			DeliveryIntegrationType delivery_integration_type) {
		this.delivery_integration_type = delivery_integration_type;
	}
	
	public void setDelivery_integration_type(
			int delivery_integration_type) {
		DeliveryIntegrationType[] array = DeliveryIntegrationType.values();
		for (DeliveryIntegrationType item: array) {
			if (item.ordinal() == delivery_integration_type) {
				this.delivery_integration_type = item;
			}
		}
	}

	/*@Transient
	public String getDeliveryIntegrationTypeString() {
		if(delivery_integration_type!=null){
			return DeliveryIntegrationTypeUtils.getIntegrationTypeString(delivery_integration_type);
		} else {
			return DeliveryIntegrationTypeUtils.getIntegrationTypeString(DeliveryIntegrationType.NONE);
		}

	}*/


}
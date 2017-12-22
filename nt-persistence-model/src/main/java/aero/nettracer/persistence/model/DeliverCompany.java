package aero.nettracer.persistence.model;

import aero.nettracer.persistence.util.DeliveryIntegrationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.Set;


@Entity
@Table(name = "delivercompany")
public class DeliverCompany {

	private int id;
	private String name;
	private String address;
	private String customId;
	private boolean active;
	private Company company;
	private String phone;
	private DeliveryIntegrationType delivery_integration_type;
	private String integration_key;
	private Set<Deliver_ServiceLevel> servicelevels;

	@Id
	@GeneratedValue
	@Column(name = "delivercompany_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "custom_id")
	public String getCustomId() {
		return customId;
	}

	public void setCustomId(String customId) {
		this.customId = customId;
	}

	@Column(name = "active")
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

	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Enumerated(EnumType.STRING)
	public DeliveryIntegrationType getDelivery_integration_type() {
		return delivery_integration_type;
	}

	public void setDelivery_integration_type(DeliveryIntegrationType delivery_integration_type) {
		this.delivery_integration_type = delivery_integration_type;
	}

	@Column(name = "integration_key")
	public String getIntegration_key() {
		return integration_key;
	}

	public void setIntegration_key(String integration_key) {
		this.integration_key = integration_key;
	}

	@OneToMany(mappedBy = "delivercompany")
	@OrderBy(value = "description")
	public Set<Deliver_ServiceLevel> getServicelevels() {
		return servicelevels;
	}

	public void setServicelevels(Set<Deliver_ServiceLevel> servicelevels) {
		this.servicelevels = servicelevels;
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

}
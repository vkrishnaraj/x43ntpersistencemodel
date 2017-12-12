package aero.nettracer.persistence.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

import aero.nettracer.persistence.util.DeliveryIntegrationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.OrderBy;

@Entity
@Table(name = "bdo")
public class BDO {

	private int id;
	private Incident incident;
	private Agent agent;
	private Date createdate;
	private Time createtime;
	private DeliverCompany delivercompany;
	private Deliver_ServiceLevel servicelevel;
	private Station station = new Station();
	private String companycode_ID;
	private Date deliverydate;
	private DeliveryIntegrationType deliveryIntegrationType;
	private String deliveryIntegrationId;
	private int integrationDeliverCompanyId;
	private boolean canceled;
	private Timestamp lastDeliveryUpdate;
	private DeliveryStatusType deliveryStatus;
	private double origDelivCost;
	private Date pickupdate;
	private Time pickuptime;
	private double distance;
	private int pickuptz_id;
	private List<OHD> onhands;
	private Set<BDO_Passenger> passengers;
	private Set<Item> items;

	@Id
	@GeneratedValue
	@Column(name = "bdo_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "incident_id")
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	@ManyToOne
	@JoinColumn(name = "agent_id", nullable = false)
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@Column(name = "createdate", updatable = false)
	@Temporal(TemporalType.DATE)
	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Column(name = "createtime", updatable = false)
	@Temporal(TemporalType.TIME)
	public Time getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Time createtime) {
		this.createtime = createtime;
	}

	@ManyToOne
	@JoinColumn(name = "delivercompany_id")
	public DeliverCompany getDelivercompany() {
		return delivercompany;
	}

	public void setDelivercompany(DeliverCompany delivercompany) {
		this.delivercompany = delivercompany;
	}

	@ManyToOne
	@JoinColumn(name = "servicelevel_id")
	public Deliver_ServiceLevel getServicelevel() {
		return servicelevel;
	}

	public void setServicelevel(Deliver_ServiceLevel servicelevel) {
		this.servicelevel = servicelevel;
	}

	@ManyToOne
	@JoinColumn(name = "station_id")
	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	@Column(name = "companycode_id")
	public String getCompanycode_ID() {
		return companycode_ID;
	}

	public void setCompanycode_ID(String companycode_ID) {
		this.companycode_ID = companycode_ID;
	}

	@Column(name = "deliverydate")
	@Temporal(value = TemporalType.DATE)
	public Date getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(Date deliverydate) {
		this.deliverydate = deliverydate;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "delivery_integration_type")
	public DeliveryIntegrationType getDeliveryIntegrationType() {
		return deliveryIntegrationType;
	}

	public void setDeliveryIntegrationType(DeliveryIntegrationType deliveryIntegrationType) {
		this.deliveryIntegrationType = deliveryIntegrationType;
	}

	@Column(name = "delivery_integration_id")
	public String getDeliveryIntegrationId() {
		return deliveryIntegrationId;
	}

	public void setDeliveryIntegrationId(String deliveryIntegrationId) {
		this.deliveryIntegrationId = deliveryIntegrationId;
	}

	@Column(name = "integrationdelivercompany_id")
	public int getIntegrationDeliverCompanyId() {
		return integrationDeliverCompanyId;
	}

	public void setIntegrationDeliverCompanyId(int integrationDeliverCompanyId) {
		this.integrationDeliverCompanyId = integrationDeliverCompanyId;
	}

	@Column(name = "canceled")
	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}

	@Column(name = "lastdeliveryupdate")
	public Timestamp getLastDeliveryUpdate() {
		return lastDeliveryUpdate;
	}

	public void setLastDeliveryUpdate(Timestamp lastDeliveryUpdate) {
		this.lastDeliveryUpdate = lastDeliveryUpdate;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "deliverystatus")
	public DeliveryStatusType getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(DeliveryStatusType deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	@Column(name = "origdelivcost")
	public double getOrigDelivCost() {
		return origDelivCost;
	}

	public void setOrigDelivCost(double origDelivCost) {
		this.origDelivCost = origDelivCost;
	}

	@Column(name = "pickupdate")
	@Temporal(TemporalType.DATE)
	public Date getPickupdate() {
		return pickupdate;
	}

	public void setPickupdate(Date pickupdate) {
		this.pickupdate = pickupdate;
	}

	@Column(name = "pickuptime")
	@Temporal(TemporalType.TIME)
	public Time getPickuptime() {
		return pickuptime;
	}

	public void setPickuptime(Time pickuptime) {
		this.pickuptime = pickuptime;
	}

	@Column(name = "distance")
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Column(name = "pickuptz_id")
	public int getPickuptz_id() {
		return pickuptz_id;
	}

	public void setPickuptz_id(int pickuptz_id) {
		this.pickuptz_id = pickuptz_id;
	}

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "bdo_ohd", joinColumns = @JoinColumn(name = "bdo_id", referencedColumnName = "bdo_id"), inverseJoinColumns = @JoinColumn(name = "ohd_id", referencedColumnName = "ohd_id"))
	public List<OHD> getOnhands() {
		return onhands;
	}

	public void setOnhands(List<OHD> onhands) {
		this.onhands = onhands;
	}

	@OneToMany
	@OrderBy(clause = "bdo_passenger_id")
	public Set<BDO_Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<BDO_Passenger> passengers) {
		this.passengers = passengers;
	}

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "item_bdo", joinColumns = @JoinColumn(name = "bdo_id", referencedColumnName = "bdo_id"), inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "item_id"))
	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}
}
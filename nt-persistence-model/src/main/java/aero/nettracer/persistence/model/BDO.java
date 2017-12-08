/*
 * Created on Jul 14, 2004
 *
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TimeZone;

import aero.nettracer.commons.constant.GenericConstants;
import aero.nettracer.commons.utils.CommonsConstants;
import aero.nettracer.commons.utils.GenericDateUtils;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * @author Administrator
 */

@Entity
public class BDO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 808096229983825702L;
	
	@Id
	@GeneratedValue
	private int BDO_ID;
	
	@ManyToOne
	@JoinColumn(name = "delivercompany_ID")
	private DeliverCompany delivercompany;

	@ManyToOne
	@JoinColumn(name = "servicelevel_ID")
	private Deliver_ServiceLevel servicelevel;

	@ManyToOne
	@JoinColumn(name = "station_ID")
	private Station station = new Station();

	private String companycode_ID;

	@ManyToOne
	@JoinColumn(name = "agent_ID", nullable = false)
	private Agent agent;

	@Temporal(value = TemporalType.DATE)
	private Date createdate;

	@Temporal(value = TemporalType.TIME)
	private Date createtime;

	@Temporal(value = TemporalType.DATE)
	private Date deliverydate;

	@Temporal(value = TemporalType.DATE)
	private Date pickupdate;

	@Temporal(value = TemporalType.TIME)
	private Date pickuptime;

	private int pickuptz_id;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "bdo_id")
	private Set<BDO_OHD> bdoOhd;

	@ManyToOne
	@JoinColumn(name = "Incident_ID")
	private Incident incident;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@org.hibernate.annotations.OrderBy(clause = "bdo_passenger_ID")
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "bdo_ID")
	private Set<BDO_Passenger> passengers; // passenger name and addresses

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@org.hibernate.annotations.OrderBy(clause = "item_ID")
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "bdo_id")
	private Set<Item_BDO> item_bdo;

	@Transient
	private String _DATEFORMAT; // current login agent's date format

	@Transient
	private String _TIMEFORMAT; // current login agent's time format

	@Transient
	private TimeZone _TIMEZONE;

	@Enumerated(EnumType.STRING)
	private DeliveryIntegrationType delivery_integration_type;

	private String delivery_integration_id;
	private int integrationDelivercompany_ID;

	@OneToOne
	@JoinColumn(name="bdo_id", referencedColumnName="bdo_id")
	private Remark remark;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "bdo_id")
	private Set<ExpensePayout> expensePayouts;

	private boolean canceled;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date lastDeliveryUpdate;

	@Enumerated(EnumType.STRING)
	private DeliveryStatusType deliveryStatus;

	private double origDelivCost;
	private double distance;

	@Transient
	private OHD ohd;


	public Date getLastDeliveryUpdate() {
  	return lastDeliveryUpdate;
  }

	public void setLastDeliveryUpdate(Date lastDeliveryUpdate) {
  	this.lastDeliveryUpdate = lastDeliveryUpdate;
  }


	/**
	 * @return Returns the passengers.
	 */
	public Set<BDO_Passenger> getPassengers() {
		return passengers;
	}

	/**
	 * @param passengers
	 *          The passengers to set.
	 */
	public void setPassengers(Set<BDO_Passenger> passengers) {
		this.passengers = passengers;
	}

	public Set<Item> getItems() {
		LinkedHashSet<Item> set = new LinkedHashSet<Item>();
		if (item_bdo != null) {
			for (Item_BDO i: item_bdo) {
				set.add(i.getItem());
			}
		}
		return set;
	}

	/**
	 * @return Returns the bagcount.
	 */
	public int getBagcount() {
		if (item_bdo != null && item_bdo.size() > 0) return item_bdo.size();
		else if (incident == null && bdoOhd != null) return bdoOhd.size();
		else return 0;
	}

	/**
	 * @return Returns the agent.
	 */
	public Agent getAgent() {
		return agent;
	}

	/**
	 * @param agent
	 *          The agent to set.
	 */
	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public String getAgentinit() {
		return agent.getUsername();
	}

	/**
	 * @return Returns the bDO_ID.
	 */
	public int getBDO_ID() {
		return BDO_ID;
	}

	/**
	 * @param bdo_id
	 *          The bDO_ID to set.
	 */
	public void setBDO_ID(int bdo_id) {
		BDO_ID = bdo_id;
	}

	public String getBDO_ID_ref() {
		StringBuffer s = new StringBuffer();
		s.append("BDO");
		String num = Integer.toString(BDO_ID);
		// padd new number to # digits that total length will equal to
		// tracingconstants.incident_len
		for (int i = 0; i < CommonsConstants.INCIDENT_LEN - num.length() - 3; i++) {
			s.append("0");
		}
		s.append(num);
		return s.toString();
	}

	/**
	 * @return Returns the companycode_ID.
	 */
	public String getCompanycode_ID() {
		return companycode_ID;
	}

	/**
	 * @param companycode_ID
	 *          The companycode_ID to set.
	 */
	public void setCompanycode_ID(String companycode_ID) {
		this.companycode_ID = companycode_ID;
	}

	/**
	 * @return Returns the createdate.
	 */
	public Date getCreatedate() {
		return createdate;
	}

	/**
	 * @param createdate
	 *          The createdate to set.
	 */
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	/**
	 * @return Returns the createtime.
	 */
	public Date getCreatetime() {
		return createtime;
	}

	/**
	 * @param createtime
	 *          The createtime to set.
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getDispcreatetime() {
		Date tempdate = GenericDateUtils.convertToDate( GenericDateUtils.formatDate(getCreatedate(), GenericConstants.DB_DATEFORMAT, null, null) + " "
				+ GenericDateUtils.formatDate(getCreatetime(), GenericConstants.DB_TIMEFORMAT, null, null),GenericConstants.DB_DATETIMEFORMAT,null);

		return GenericDateUtils.formatDate(tempdate, _DATEFORMAT + " " + _TIMEFORMAT, null, _TIMEZONE);
	}

	/**Get date and time then format to yyyy-MM-dd HH:mm:ss format for return
	 *
	 * @return the pickuptime for display only
	 */
	public String getDisppickuptime() {
		Date tempdate = GenericDateUtils.convertToDate( GenericDateUtils.formatDate(getPickupdate(), GenericConstants.DB_DATEFORMAT, null, null) + " "
				+ GenericDateUtils.formatDate(getPickuptime(), GenericConstants.DB_TIMEFORMAT, null, null),GenericConstants.DB_DATETIMEFORMAT,null);

		return GenericDateUtils.formatDate(tempdate, _DATEFORMAT + " " + _TIMEFORMAT, null, _TIMEZONE);
	}

	/**
	 * @return Returns the delivercompany.
	 */
	public DeliverCompany getDelivercompany() {
		return delivercompany;
	}

	/**
	 * @param delivercompany
	 *          The delivercompany to set.
	 */
	public void setDelivercompany(DeliverCompany delivercompany) {
		this.delivercompany = delivercompany;
	}

	/**
	 * @return Returns the servicelevel.
	 */
	public Deliver_ServiceLevel getServicelevel() {
		return servicelevel;
	}

	/**
	 * @param servicelevel
	 *          The servicelevel to set.
	 */
	public void setServicelevel(Deliver_ServiceLevel servicelevel) {
		this.servicelevel = servicelevel;
	}

	/**
	 * @return Returns the deliverydate.
	 */
	public Date getDeliverydate() {
		return deliverydate;
	}

	/**
	 * @param deliverydate
	 *          The deliverydate to set.
	 */
	public void setDeliverydate(Date deliverydate) {
		this.deliverydate = deliverydate;
	}

	public String getDispdeliverydate() {
		return GenericDateUtils.formatDate(getDeliverydate(), _DATEFORMAT, null, null);
	}

	/**
	 * @return Returns the pickupdate.
	 */
	public Date getPickupdate() {
		return pickupdate;
	}

	/**
	 * @param pickupdate
	 *          The pickupdate to set.
	 */
	public void setPickupdate(Date pickupdate) {
		this.pickupdate = pickupdate;
	}

	/**
	 * @return Returns the pickuptime.
	 */
	public Date getPickuptime() {
		return pickuptime;
	}

	/**
	 * @param pickuptime
	 *          The pickuptime to set.
	 */
	public void setPickuptime(Date pickuptime) {
		this.pickuptime = pickuptime;
	}

	public String getDisppickupdate() {
		return GenericDateUtils.formatDate(getPickupdate(), _DATEFORMAT, null, null);
	}

	/**
	 * @return Returns the station.
	 */
	public Station getStation() {
		return station;
	}

	/**
	 * @param station
	 *          The station to set.
	 */
	public void setStation(Station station) {
		this.station = station;
	}

	public Set<BDO_OHD> getBdoOhd() {
		return bdoOhd;
	}

	public void setBdoOhd(Set<BDO_OHD> bdoOhd) {
		this.bdoOhd = bdoOhd;
	}

	/**
	 * @return Returns the incident.
	 */
	public Incident getIncident() {
		return incident;
	}

	/**
	 * @param incident
	 *          The incident to set.
	 */
	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	public BDO_Passenger getPassenger(int i) {
		if (this.getPassengers() != null) {
			ArrayList<BDO_Passenger> t = new ArrayList<BDO_Passenger>(this.getPassengers());
			return (BDO_Passenger) t.get(i);
		} else return null;
	}

	/**
	 * @return Returns the _DATEFORMAT.
	 */
	public String get_DATEFORMAT() {
		return _DATEFORMAT;
	}

	/**
	 * @param _dateformat
	 *          The _DATEFORMAT to set.
	 */
	public void set_DATEFORMAT(String _dateformat) {
		_DATEFORMAT = _dateformat;
	}

	/**
	 * @return Returns the _TIMEFORMAT.
	 */
	public String get_TIMEFORMAT() {
		return _TIMEFORMAT;
	}

	/**
	 * @param _timeformat
	 *          The _TIMEFORMAT to set.
	 */
	public void set_TIMEFORMAT(String _timeformat) {
		_TIMEFORMAT = _timeformat;
	}

	/**
	 * @return Returns the _TIMEZONE.
	 */
	public TimeZone get_TIMEZONE() {
		return _TIMEZONE;
	}

	/**
	 * @param _timezone
	 *          The _TIMEZONE to set.
	 */
	public void set_TIMEZONE(TimeZone _timezone) {
		_TIMEZONE = _timezone;
	}

	/**
	 * @return the delivery_integration_type
	 */
	public DeliveryIntegrationType getDelivery_integration_type() {
		return delivery_integration_type;
	}

	/**
	 * @param delivery_integration_type the delivery_integration_type to set
	 */
	public void setDelivery_integration_type(
			DeliveryIntegrationType delivery_integration_type) {
		this.delivery_integration_type = delivery_integration_type;
	}

	/**
	 * @return Returns unique ID provided by delivery company.
	 */
	public String getDelivery_integration_id() {
		return delivery_integration_id;
	}

	/**
	 * @param delivery_integration_id
	 */
	public void setDelivery_integration_id(String delivery_integration_id) {
		this.delivery_integration_id = delivery_integration_id;

	}

	/**
	 * @return the integrationDelivercompany
	 */
	public int getIntegrationDelivercompany_ID() {
		return integrationDelivercompany_ID;
	}

	/**
	 * @param integrationDelivercompany_ID the integrationDelivercompany to set
	 */
	public void setIntegrationDelivercompany_ID(
			int integrationDelivercompany_ID) {
		this.integrationDelivercompany_ID = integrationDelivercompany_ID;
	}

	/**
	 * @return Returns the items.
	 */
	public Set<ExpensePayout> getExpensePayouts() {
		return expensePayouts;
	}

	public void setExpensePayouts(Set<ExpensePayout> expensePayouts) {
		this.expensePayouts = expensePayouts;
	}

	public ExpensePayout getExpensePayout() {
		if (expensePayouts == null || expensePayouts.size() == 0) {
			return null;
		}
		return (ExpensePayout) expensePayouts.toArray()[0];
	}

	public void setExpensePayout(ExpensePayout createNewBdoPayout) {
		expensePayouts = new HashSet<ExpensePayout>();
		if(createNewBdoPayout != null){
			expensePayouts.add(createNewBdoPayout);
		}
	}

	/**
	 * @return
	 */
	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}

	/**
	 * @return Returns the items.
	 */
	public Set<Item_BDO> getItem_bdo() {
		return item_bdo;
	}

	public void setItem_bdo(Set<Item_BDO> item_bdo) {
		this.item_bdo = item_bdo;
	}

	/**
	 * @return the delivery_integration_type
	 */
	public DeliveryStatusType getDeliveryStatus() {
  	return deliveryStatus;
  }

	public void setDeliveryStatus(DeliveryStatusType deliveryStatus) {
  	this.deliveryStatus = deliveryStatus;
  }

	/**
	 * @return the origDelivCost
	 */
	public double getOrigDelivCost() {
		return origDelivCost;
	}

	/**
	 * @param origDelivCost the origDelivCost to set
	 */
	public void setOrigDelivCost(double origDelivCost) {
		this.origDelivCost = origDelivCost;
	}

	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	/**
	 * @return the pickuptz
	 */
	public int getPickuptz_id() {
		return pickuptz_id;
	}

	public void setPickuptz_id(int pickuptz_id) {
		this.pickuptz_id = pickuptz_id;
	}

	public Remark getRemark() {
		return remark;
	}

	public void setRemark(Remark remark) {
		this.remark = remark;
	}

	public OHD getOhd() {
		if(this.bdoOhd != null && this.bdoOhd.size() == 1) {
			return this.bdoOhd.iterator().next().getOhd();
		}
		return ohd;
	}

	public void setOhd(OHD ohd) {
		if(bdoOhd == null) {
			bdoOhd = new LinkedHashSet<BDO_OHD>();
		}
		BDO_OHD bdoOhdObj = new BDO_OHD();
		bdoOhdObj.setOhd(ohd);
		bdoOhdObj.setBdo(this);
		bdoOhd.add(bdoOhdObj);
		this.ohd = ohd;
	}

	//This method is just to support integration with delivery systems for a BDO with multiple Onhands.
	public void setOhdRef(OHD ohd) {
		this.ohd = ohd;
	}
}
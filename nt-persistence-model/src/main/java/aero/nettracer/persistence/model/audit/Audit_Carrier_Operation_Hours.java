package aero.nettracer.persistence.model.audit;

import java.io.Serializable;
import java.util.Date;

import aero.nettracer.persistence.model.Agent;
import aero.nettracer.persistence.model.Carrier_Operation_Hours;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "audit_carrier_operation_hours")
public class Audit_Carrier_Operation_Hours implements Serializable {

	private static final long serialVersionUID = -1823955137870279638L;

	@Id @GeneratedValue
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carrier_operation_hours_id", nullable = false)
	@Fetch(FetchMode.SELECT)
	private Carrier_Operation_Hours carrier_operation_hours;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "audit_station_id", nullable = false)
	@Fetch(FetchMode.SELECT)
	private Audit_Station audit_station;
	private String day_of_week;
	private Date starttime;
	private Date endtime;

	@ManyToOne(targetEntity = Agent.class, fetch = FetchType.LAZY)
	@JoinColumn(name="modifying_agent_ID")
	@Fetch(FetchMode.SELECT)
	private Agent modifying_agent;
	private Date time_modified;

	public Agent getModifying_agent() {
		return modifying_agent;
	}

	public void setModifying_agent(Agent modifying_agent) {
		this.modifying_agent = modifying_agent;
	}

	public Date getTime_modified() {
		return time_modified;
	}

	public void setTime_modified(Date time_modified) {
		this.time_modified = time_modified;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDay_of_week() {
		return day_of_week;
	}

	public void setDay_of_week(String day_of_week) {
		this.day_of_week = day_of_week;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Carrier_Operation_Hours getCarrier_operation_hours() {
		return carrier_operation_hours;
	}

	public void setCarrier_operation_hours(
			Carrier_Operation_Hours carrier_operation_hours) {
		this.carrier_operation_hours = carrier_operation_hours;
	}

	public Audit_Station getAudit_station() {
		return audit_station;
	}

	public void setAudit_station(Audit_Station audit_station) {
		this.audit_station = audit_station;
	}

}
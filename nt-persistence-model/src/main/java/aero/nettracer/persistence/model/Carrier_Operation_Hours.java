package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import aero.nettracer.persistence.model.audit.Audit_Carrier_Operation_Hours;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;


@Entity
@Table(name = "carrier_operation_hours")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Carrier_Operation_Hours implements Serializable {

	private static final long serialVersionUID = -8920424497356057481L;

	@Id @GeneratedValue
	private int carrier_operation_hours_id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Station_ID", nullable = false)
	@Fetch(FetchMode.SELECT)
	private Station station;

	@Column(length = 3)
	private String day_of_week;

	@Temporal(value = TemporalType.TIME)
	private Date starttime;

	@Temporal(value = TemporalType.TIME)
	private Date endtime;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "carrier_operation_hours")
	@Fetch(FetchMode.SELECT)
	private Set<Audit_Carrier_Operation_Hours> auditCarrierHours;

	public Carrier_Operation_Hours() { }

	public Carrier_Operation_Hours(int carrier_operation_hours_id) {
		this.carrier_operation_hours_id = carrier_operation_hours_id;
	}


	public int getCarrier_operation_hours_id() {
		return carrier_operation_hours_id;
	}

	public void setCarrier_operation_hours_id(int carrier_operation_hours_id) {
		this.carrier_operation_hours_id = carrier_operation_hours_id;
	}


	public String getDay_of_week() {
		return day_of_week;
	}

	public void setDay_of_week(String day_of_week) {
		this.day_of_week = day_of_week;
	}


	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
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


	public Set<Audit_Carrier_Operation_Hours> getAuditCarrierHours() {
		return auditCarrierHours;
	}

	public void setAuditCarrierHours(
			Set<Audit_Carrier_Operation_Hours> auditCarrierHours) {
		this.auditCarrierHours = auditCarrierHours;
	}
}
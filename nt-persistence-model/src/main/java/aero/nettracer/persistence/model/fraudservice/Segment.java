package aero.nettracer.persistence.model.fraudservice;

import aero.nettracer.commons.utils.GenericDateUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "segment")
public class Segment {

	private long id;
	private int legfrom_type;
	private int legto_type;
	private String airline;
	private String arrival;
	private Timestamp createDate;
	private Date arrivedate;
	private String departure;
	private String flight;
	private Time schdeparttime;
	private Time scharrivetime;
	private Time actdeparttime;
	private Time actarrivetime;
	private FsClaim claim;
	private FsIncident incident;
	private Reservation reservation;
	private String dateFormat;
	private String timeFormat;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "legfrom_type")
	public int getLegfrom_type() {
		return legfrom_type;
	}

	public void setLegfrom_type(int legfrom_type) {
		this.legfrom_type = legfrom_type;
	}

	@Column(name = "legto_type")
	public int getLegto_type() {
		return legto_type;
	}

	public void setLegto_type(int legto_type) {
		this.legto_type = legto_type;
	}

	@Column(name = "airline")
	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	@Column(name = "arrival")
	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	@Column(name = "createdate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "arrivedate")
	@Temporal(TemporalType.DATE)
	public Date getArrivedate() {
		return arrivedate;
	}

	public void setArrivedate(Date arrivedate) {
		this.arrivedate = arrivedate;
	}

	@Column(name = "departure")
	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	@Column(name = "flight")
	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	@Column(name = "schdeparttime")
	@Temporal(TemporalType.TIME)
	public Time getSchdeparttime() {
		return schdeparttime;
	}

	public void setSchdeparttime(Time schdeparttime) {
		this.schdeparttime = schdeparttime;
	}

	@Column(name = "scharrivetime")
	@Temporal(TemporalType.TIME)
	public Time getScharrivetime() {
		return scharrivetime;
	}

	public void setScharrivetime(Time scharrivetime) {
		this.scharrivetime = scharrivetime;
	}

	@Column(name = "actdeparttime")
	@Temporal(TemporalType.TIME)
	public Time getActdeparttime() {
		return actdeparttime;
	}

	public void setActdeparttime(Time actdeparttime) {
		this.actdeparttime = actdeparttime;
	}

	@Column(name = "actarrivetime")
	@Temporal(TemporalType.TIME)
	public Time getActarrivetime() {
		return actarrivetime;
	}

	public void setActarrivetime(Time actarrivetime) {
		this.actarrivetime = actarrivetime;
	}

	@ManyToOne
	public FsClaim getClaim() {
		return claim;
	}

	public void setClaim(FsClaim claim) {
		this.claim = claim;
	}

	@ManyToOne
	public FsIncident getIncident() {
		return incident;
	}

	public void setIncident(FsIncident incident) {
		this.incident = incident;
	}

	@ManyToOne
	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	@Transient
	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	@Transient
	public String getTimeFormat() {
		return timeFormat;
	}

	public void setTimeFormat(String timeFormat) {
		this.timeFormat = timeFormat;
	}

	public String getDisArrivedate() {
		return GenericDateUtils.formatDate(arrivedate, dateFormat, "", null);
	}

	public void setDisArrivedate(String date) {
		setArrivedate(GenericDateUtils.convertToDate(date, dateFormat, null));
	}

}

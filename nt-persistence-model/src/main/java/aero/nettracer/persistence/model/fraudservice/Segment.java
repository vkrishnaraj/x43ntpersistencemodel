package aero.nettracer.persistence.model.fraudservice;

import java.io.Serializable;
import java.util.Date;

import aero.nettracer.commons.utils.GenericDateUtils;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

@Entity
public class Segment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	private Date date;
	private Date arrivedate;
	private String departure;
	private String arrival;
	private int legfrom_type;
	private int legto_type;
	private String airline;
	private String flight;
	private Date schdeparttime;
	private Date scharrivetime;
	private Date actdeparttime;
	private Date actarrivetime;
	@ManyToOne(targetEntity = Reservation.class)
	@Fetch(FetchMode.SELECT)
	private Reservation reservation;
	@ManyToOne(targetEntity = FsIncident.class)
	@Fetch(FetchMode.SELECT)
	private FsIncident incident;
	@ManyToOne(targetEntity = FsClaim.class)
	@Fetch(FetchMode.SELECT)
	private FsClaim claim;

	@Transient
	private String dateFormat;
	@Transient
	private String timeFormat;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDisDate() {
		return GenericDateUtils.formatDate(date, dateFormat, "", null);
	}

	public void setDisDate(String date) {
		setDate(GenericDateUtils.convertToDate(date, dateFormat, null));
	}

	public Date getArrivedate() {
		return arrivedate;
	}

	public void setArrivedate(Date arrivedate) {
		this.arrivedate = arrivedate;
	}

	public String getDisArrivedate() {
		return GenericDateUtils.formatDate(arrivedate, dateFormat, "", null);
	}

	public void setDisArrivedate(String date) {
		setArrivedate(GenericDateUtils.convertToDate(date, dateFormat, null));
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public int getLegfrom_type() {
		return legfrom_type;
	}

	public void setLegfrom_type(int legfrom_type) {
		this.legfrom_type = legfrom_type;
	}

	public int getLegto_type() {
		return legto_type;
	}

	public void setLegto_type(int legto_type) {
		this.legto_type = legto_type;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public Date getSchdeparttime() {
		return schdeparttime;
	}

	public void setSchdeparttime(Date schdeparttime) {
		this.schdeparttime = schdeparttime;
	}

	@Transient
	public String getDisschdeparttime() {
		return GenericDateUtils.formatDate(getSchdeparttime(), getTimeFormat(), null, null);
	}

	public void setDisschdeparttime(String s) {
		setSchdeparttime(GenericDateUtils.convertToDate(s, getTimeFormat(), null));
	}

	public Date getScharrivetime() {
		return scharrivetime;
	}

	public void setScharrivetime(Date scharrivetime) {
		this.scharrivetime = scharrivetime;
	}

	@Transient
	public String getDisscharrivetime() {
		return GenericDateUtils.formatDate(getScharrivetime(), getTimeFormat(), null, null);
	}

	public void setDisscharrivetime(String s) {
		setScharrivetime(GenericDateUtils.convertToDate(s, getTimeFormat(), null));
	}

	public Date getActdeparttime() {
		return actdeparttime;
	}

	public void setActdeparttime(Date actdeparttime) {
		this.actdeparttime = actdeparttime;
	}

	@Transient
	public String getDisactdeparttime() {
		return GenericDateUtils.formatDate(getActdeparttime(), getTimeFormat(), null, null);
	}

	public void setDisactdeparttime(String s) {
		setActdeparttime(GenericDateUtils.convertToDate(s, getTimeFormat(), null));
	}

	public Date getActarrivetime() {
		return actarrivetime;
	}

	public void setActarrivetime(Date actarrivetime) {
		this.actarrivetime = actarrivetime;
	}

	@Transient
	public String getDisactarrivetime() {
		return GenericDateUtils.formatDate(getActarrivetime(), getTimeFormat(), null, null);
	}

	public void setDisactarrivetime(String s) {
		setActarrivetime(GenericDateUtils.convertToDate(s, getTimeFormat(), null));
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public FsIncident getIncident() {
		return incident;
	}

	public void setIncident(FsIncident incident) {
		this.incident = incident;
	}

	public FsClaim getClaim() {
		return claim;
	}

	public void setClaim(FsClaim claim) {
		this.claim = claim;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getTimeFormat() {
		return timeFormat;
	}

	public void setTimeFormat(String timeFormat) {
		this.timeFormat = timeFormat;
	}
}

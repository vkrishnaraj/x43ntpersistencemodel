package aero.nettracer.persistence.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "itinerary")
public class Itinerary {

	private int id;
	private int itinerarytype; //0-passenger, 1 - bagrouting
	private String legfrom;
	private String legto;
	private int legfrom_type;
	private int legto_type;
	private Date departdate;
	private Date arrivedate;
	private String flightnum;
	private Time schdeparttime;
	private Time scharrivetime;
	private Time actdeparttime;
	private Time actarrivetime;
	private Incident incident;
	private String airline;
	private String seatClass;

	@Id
	@GeneratedValue
	@Column(name = "itinerary_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "itinerarytype")
	public int getItinerarytype() {
		return itinerarytype;
	}

	public void setItinerarytype(int itinerarytype) {
		this.itinerarytype = itinerarytype;
	}

	@Column(name = "legfrom")
	public String getLegfrom() {
		return legfrom;
	}

	public void setLegfrom(String legfrom) {
		this.legfrom = (legfrom != null ? legfrom.toUpperCase() : legfrom);
	}

	@Column(name = "legto")
	public String getLegto() {
		return legto;
	}

	public void setLegto(String legto) {
		this.legto = (legto != null ? legto.toUpperCase() : legto);
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

	@Column(name = "departdate")
	@Temporal(TemporalType.DATE)
	public Date getDepartdate() {
		return departdate;
	}

	public void setDepartdate(Date departdate) {
		this.departdate = departdate;
	}

	@Column(name = "arrivedate")
	@Temporal(TemporalType.DATE)
	public Date getArrivedate() {
		return arrivedate;
	}

	public void setArrivedate(Date arrivedate) {
		this.arrivedate = arrivedate;
	}

	@Column(name = "flightnum")
	public String getFlightnum() {
		return flightnum;
	}

	public void setFlightnum(String flightnum) {
		this.flightnum = (flightnum != null ? flightnum.toUpperCase() : flightnum);
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
	@JoinColumn(name = "incident_id")
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	@Column(name = "airline")
	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	@Column(name = "seatclass")
	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}

}
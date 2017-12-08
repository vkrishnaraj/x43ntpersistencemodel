package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "ohd_itinerary")
public class TraceOHD_Itinerary implements Serializable {

	private static final long serialVersionUID = 1L;
	private int Itinerary_ID;
	private int itinerarytype; //0-passenger, 1 - bagrouting
	private String legfrom = "";
	private String legto = "";
	private int legfrom_type;
	private int legto_type;
	private Date departdate;
	private Date arrivedate;
	private String airline = "";
	private String flightnum = "";
	private Date schdeparttime;
	private Date scharrivetime;
	private Date actdeparttime;
	private Date actarrivetime;
	private TraceOHD ohd;

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	@ManyToOne
	@JoinColumn(name = "ohd_ID")
	public TraceOHD getOhd() {
		return ohd;
	}

	public void setOhd(TraceOHD ohd) {
		this.ohd = ohd;
	}

	public String getFlightnum() {
		return flightnum;
	}

	public void setFlightnum(String flightnum) {
		this.flightnum = (flightnum != null ? flightnum.toUpperCase() : flightnum);
	}

	@Id
	@GeneratedValue
	public int getItinerary_ID() {
		return Itinerary_ID;
	}

	public void setItinerary_ID(int itinerary_ID) {
		Itinerary_ID = itinerary_ID;
	}

	public int getItinerarytype() {
		return itinerarytype;
	}

	public void setItinerarytype(int itinerarytype) {
		this.itinerarytype = itinerarytype;
	}

	public String getLegfrom() {
		return legfrom;
	}

	public void setLegfrom(String legfrom) {
		this.legfrom = (legfrom != null ? legfrom.toUpperCase() : legfrom);
	}

	public String getLegto() {
		return legto;
	}

	public void setLegto(String legto) {
		this.legto = (legto != null ? legto.toUpperCase() : legto);
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

	@Temporal(TemporalType.DATE)
	public Date getArrivedate() {
		return arrivedate;
	}

	public void setArrivedate(Date arrivedate) {
		this.arrivedate = arrivedate;
	}

	@Temporal(TemporalType.DATE)
	public Date getDepartdate() {
		return departdate;
	}

	public void setDepartdate(Date departdate) {
		this.departdate = departdate;
	}

	@Temporal(TemporalType.TIME)
	public Date getActarrivetime() {
		return actarrivetime;
	}

	public void setActarrivetime(Date actarrivetime) {
		this.actarrivetime = actarrivetime;
	}

	@Temporal(TemporalType.TIME)
	public Date getActdeparttime() {
		return actdeparttime;
	}

	public void setActdeparttime(Date actdeparttime) {
		this.actdeparttime = actdeparttime;
	}

	@Temporal(TemporalType.TIME)
	public Date getScharrivetime() {
		return scharrivetime;
	}

	public void setScharrivetime(Date scharrivetime) {
		this.scharrivetime = scharrivetime;
	}

	@Temporal(TemporalType.TIME)
	public Date getSchdeparttime() {
		return schdeparttime;
	}

	public void setSchdeparttime(Date schdeparttime) {
		this.schdeparttime = schdeparttime;
	}

}
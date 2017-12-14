package aero.nettracer.persistence.model;

import java.sql.Time;
import java.util.Date;
import java.util.ListIterator;

import aero.nettracer.commons.constant.GenericConstants;
import aero.nettracer.commons.utils.GenericDateUtils;
import com.cci.utils.parser.ElementNode;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

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

	public String toXML() {
		StringBuffer sb = new StringBuffer();
		sb.append("<itinerary_leg>");
		sb.append("<id>" + id + "</id>");
		sb.append("<itinerarytype>" + itinerarytype + "</itinerarytype>");
		sb.append("<from>" + legfrom + "</from>");
		sb.append("<fromtype>" + legfrom_type + "</fromtype>");
		sb.append("<to>" + legto + "</to>");
		sb.append("<totype>" + legto_type + "</totype>");
		sb.append("<departdate>" + (departdate == null ? "" : departdate.toString()) + "</departdate>");
		sb.append("<arrivedate>" + (arrivedate == null ? "" : arrivedate.toString()) + "</arrivedate>");
		sb.append("<airline>" + airline.toString() + "</airline>");
		sb.append("<flightnum>" + flightnum.toString() + "</flightnum>");
		sb.append("<schdeparttime>" + (schdeparttime == null ? "" : schdeparttime.toString()) + "</schdeparttime>");
		sb.append("<scharrivetime>" + (scharrivetime == null ? "" : scharrivetime.toString()) + "</scharrivetime>");
		sb.append("<actdeparttime>" + (actdeparttime == null ? "" : actdeparttime.toString()) + "</actdeparttime>");
		sb.append("<actarrivetime>" + (actarrivetime == null ? "" : actarrivetime.toString()) + "</actarrivetime>");
		sb.append("</itinerary_leg>");

		return sb.toString();
	}

	@ManyToOne
	@JoinColumn(name = "incident_ID")
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	public String getFlightnum() {
		return flightnum;
	}

	public void setFlightnum(String flightnum) {
		this.flightnum = (flightnum != null ? flightnum.toUpperCase() : flightnum);
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
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

	@Transient
	public int getLegToTypeDescription(){
		return legto_type;
	}

	public void setLegToTypeDescription(int legto_type){
		this.legto_type = legto_type;
	}

	@Transient
	public int getLegFromTypeDescription(){
		return legfrom_type;
	}

	public void setLegFromTypeDescription(int legfrom_type){
		this.legfrom_type = legfrom_type;
	}

	public int getItineraryTypeDescription() {
		return itinerarytype;
	}

	public void setItineraryTypeDescription(int itinerarytype) {
		this.itinerarytype = itinerarytype;
	}

	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}

	public static int parseInt(String s) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return 0;
		}
	}

	public static double parseDouble(String s) {
		try {
			return Double.parseDouble(s);
		} catch (Exception e) {
			return 0;
		}
	}
}
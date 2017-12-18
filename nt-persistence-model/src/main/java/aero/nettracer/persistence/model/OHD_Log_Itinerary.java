package aero.nettracer.persistence.model;

import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "ohd_log_itinerary")
public class OHD_Log_Itinerary {

	private int id;
	private int itinerarytype;
	private String legfrom;
	private String legto;
	private int legfrom_type;
	private int legto_type;
	private Date departdate;
	private Date arrivedate;
	private Time schdeparttime;
	private Time scharrivetime;
	private String flightnum;
	private OHD_Log log;
	private String airline;
	private boolean notify;

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
	@Pattern(regexp = "[A-Z]{3}")
	@ColumnTransformer(write = "UPPER(legfrom)")
	public String getLegfrom() {
		return legfrom;
	}

	public void setLegfrom(String legfrom) {
		this.legfrom = legfrom;
	}

	@Column(name = "legto")
	@Pattern(regexp = "[A-Z]{3}")
	@ColumnTransformer(write = "UPPER(legto)")
	public String getLegto() {
		return legto;
	}

	public void setLegto(String legto) {
		this.legto = legto;
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
	public Date getDepartdate() {
		return departdate;
	}

	public void setDepartdate(Date departdate) {
		this.departdate = departdate;
	}

	@Column(name = "arrivedate")
	public Date getArrivedate() {
		return arrivedate;
	}

	public void setArrivedate(Date arrivedate) {
		this.arrivedate = arrivedate;
	}

	@Column(name = "schdeparttime")
	public Time getSchdeparttime() {
		return schdeparttime;
	}

	public void setSchdeparttime(Time schdeparttime) {
		this.schdeparttime = schdeparttime;
	}

	@Column(name = "scharrivetime")
	public Time getScharrivetime() {
		return scharrivetime;
	}

	public void setScharrivetime(Time scharrivetime) {
		this.scharrivetime = scharrivetime;
	}

	@Column(name = "flightnum")
	@ColumnTransformer(write = "UPPER(flightnum)")
	public String getFlightnum() {
		return flightnum;
	}

	public void setFlightnum(String flightnum) {
		this.flightnum = flightnum;
	}

	@ManyToOne
	@JoinColumn(name = "ohdlog_id")
	public OHD_Log getLog() {
		return log;
	}

	public void setLog(OHD_Log log) {
		this.log = log;
	}

	@Column(name = "airline")
	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	@Transient
	public boolean isNotify() {
		return notify;
	}

	public void setNotify(boolean notify) {
		this.notify = notify;
	}

}


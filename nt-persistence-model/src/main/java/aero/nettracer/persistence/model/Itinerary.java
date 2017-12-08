package aero.nettracer.persistence.model;

import java.io.Serializable;
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
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Itinerary")
public class Itinerary implements Serializable {
	private int Itinerary_ID;
	private int itinerarytype; //0-passenger, 1 - bagrouting
	private String legfrom;
	private String legto;
	private int legfrom_type;
	private int legto_type;
	private Date departdate;
	private Date arrivedate;
	private String airline;
	private String flightnum;
	private Date schdeparttime;
	private Date scharrivetime;
	private Date actdeparttime;
	private Date actarrivetime;
	private Incident incident;
	
	private String _DATEFORMAT;
	private String _TIMEFORMAT;

	private String seatClass;

	public String toXML() {
		StringBuffer sb = new StringBuffer();
		sb.append("<itinerary_leg>");
		sb.append("<Itinerary_ID>" + Itinerary_ID + "</Itinerary_ID>");
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

	public static Itinerary XMLtoObject(ElementNode root) {
		Itinerary obj = new Itinerary();

		ElementNode child = null, grandchild = null, ggrandchild = null, gggrandchild = null;

		for (ListIterator i = root.get_children().listIterator(); i.hasNext();) {
			child = (ElementNode) i.next();
			if (child.getType().equals("Itinerary_ID")) {
				obj.setItinerary_ID(parseInt(child.getTextContents()));
			} else if (child.getType().equals("itinerarytype")) {
				obj.setItinerarytype(parseInt(child.getTextContents()));	
			} else if (child.getType().equals("from")) {
				obj.setLegfrom(child.getTextContents());
			} else if (child.getType().equals("fromtype")) {
				obj.setLegfrom_type(parseInt(child.getTextContents()));	
			} else if (child.getType().equals("to")) {
				obj.setLegto(child.getTextContents());
			} else if (child.getType().equals("totype")) {
				obj.setLegto_type(parseInt(child.getTextContents()));	
			} else if (child.getType().equals("departdate")) {
				obj.setDepartdate(GenericDateUtils.convertToDate(child.getTextContents(),
						GenericConstants.DB_DATEFORMAT, null));
			} else if (child.getType().equals("arrivedate")) {
				obj.setArrivedate(GenericDateUtils.convertToDate(child.getTextContents(),
						GenericConstants.DB_DATEFORMAT, null));
			} else if (child.getType().equals("airline")) {
				obj.setAirline(child.getTextContents());
			} else if (child.getType().equals("flightnum")) {
				obj.setFlightnum(child.getTextContents());
			} else if (child.getType().equals("schdeparttime")) {
				obj.setSchdeparttime(GenericDateUtils.convertToDate(child.getTextContents(),
						GenericConstants.DB_TIMEFORMAT, null));
			} else if (child.getType().equals("scharrivetime")) {
				obj.setScharrivetime(GenericDateUtils.convertToDate(child.getTextContents(),
						GenericConstants.DB_TIMEFORMAT, null));
			} else if (child.getType().equals("actdeparttime")) {
				obj.setActdeparttime(GenericDateUtils.convertToDate(child.getTextContents(),
						GenericConstants.DB_TIMEFORMAT, null));
			} else if (child.getType().equals("actarrivetime")) {
				obj.setActarrivetime(GenericDateUtils.convertToDate(child.getTextContents(),
						GenericConstants.DB_TIMEFORMAT, null));
				
			}
			

		}
		
		
		
		return obj;
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

	public void setDisarrivedate(String s) {
		setArrivedate(GenericDateUtils.convertToDate(s, get_DATEFORMAT(), null));
	}

	@Transient
	public String getDisarrivedate() {
		return GenericDateUtils.formatDate(getArrivedate(), get_DATEFORMAT(), null, null);
	}

	@Temporal(TemporalType.DATE)
	public Date getDepartdate() {
		return departdate;
	}

	public void setDepartdate(Date departdate) {
		this.departdate = departdate;
	}

	public void setDisdepartdate(String s) {
		setDepartdate(GenericDateUtils.convertToDate(s, get_DATEFORMAT(), null));
	}

	@Transient
	public String getDisdepartdate() {
		return GenericDateUtils.formatDate(getDepartdate(), get_DATEFORMAT(), null, null);
	}

	@Temporal(TemporalType.TIME)
	public Date getActarrivetime() {
		return actarrivetime;
	}

	public void setActarrivetime(Date actarrivetime) {
		this.actarrivetime = actarrivetime;
	}

	public void setDisactarrivetime(String s) {
		setActarrivetime(GenericDateUtils.convertToDate(s, get_TIMEFORMAT(), null));
	}

	@Transient
	public String getDisactarrivetime() {
		return GenericDateUtils.formatDate(getActarrivetime(), get_TIMEFORMAT(), null, null);
	}

	@Temporal(TemporalType.TIME)
	public Date getActdeparttime() {
		return actdeparttime;
	}

	public void setActdeparttime(Date actdeparttime) {
		this.actdeparttime = actdeparttime;
	}

	public void setDisactdeparttime(String s) {
		setActdeparttime(GenericDateUtils.convertToDate(s, get_TIMEFORMAT(), null));
	}

	@Transient
	public String getDisactdeparttime() {
		return GenericDateUtils.formatDate(getActdeparttime(), get_TIMEFORMAT(), null, null);
	}

	@Temporal(TemporalType.TIME)
	public Date getScharrivetime() {
		return scharrivetime;
	}

	public void setScharrivetime(Date scharrivetime) {
		this.scharrivetime = scharrivetime;
	}

	public void setDisscharrivetime(String s) {
		setScharrivetime(GenericDateUtils.convertToDate(s, get_TIMEFORMAT(), null));
	}

	@Transient
	public String getDisscharrivetime() {
		return GenericDateUtils.formatDate(getScharrivetime(), get_TIMEFORMAT(), null, null);
	}

	@Temporal(TemporalType.TIME)
	public Date getSchdeparttime() {
		return schdeparttime;
	}

	public void setSchdeparttime(Date schdeparttime) {
		this.schdeparttime = schdeparttime;
	}

	public void setDisschdeparttime(String s) {
		setSchdeparttime(GenericDateUtils.convertToDate(s, get_TIMEFORMAT(), null));
	}

	@Transient
	public String getDisschdeparttime() {
		return GenericDateUtils.formatDate(getSchdeparttime(), get_TIMEFORMAT(), null, null);
	}

	@Transient
	public String get_DATEFORMAT() {
		if (_DATEFORMAT == null && incident != null) _DATEFORMAT = incident.getAgent().getDateformat()
				.getFormat();
		return _DATEFORMAT;
	}

	public void set_DATEFORMAT(String _dateformat) {
		_DATEFORMAT = _dateformat;
	}

	@Transient
	public String get_TIMEFORMAT() {
		if (_TIMEFORMAT == null && incident != null) _TIMEFORMAT = incident.getAgent().getTimeformat()
				.getFormat();
		return _TIMEFORMAT;
	}

	public void set_TIMEFORMAT(String _timeformat) {
		_TIMEFORMAT = _timeformat;
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
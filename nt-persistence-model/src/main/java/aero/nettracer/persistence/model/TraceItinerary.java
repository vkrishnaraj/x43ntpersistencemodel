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

@Entity
@Table(name = "Itinerary")
public class TraceItinerary implements Serializable {
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
	private TraceIncident incident;

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
				obj.setId(parseInt(child.getTextContents()));
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
	public TraceIncident getIncident() {
		return incident;
	}

	public void setIncident(TraceIncident incident) {
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

	public Date getArrivedate() {
		return arrivedate;
	}

	public void setArrivedate(Date arrivedate) {
		this.arrivedate = arrivedate;
	}

	public Date getDepartdate() {
		return departdate;
	}

	public void setDepartdate(Date departdate) {
		this.departdate = departdate;
	}

	public Date getActarrivetime() {
		return actarrivetime;
	}

	public void setActarrivetime(Date actarrivetime) {
		this.actarrivetime = actarrivetime;
	}

	public Date getActdeparttime() {
		return actdeparttime;
	}

	public void setActdeparttime(Date actdeparttime) {
		this.actdeparttime = actdeparttime;
	}

	public Date getScharrivetime() {
		return scharrivetime;
	}

	public void setScharrivetime(Date scharrivetime) {
		this.scharrivetime = scharrivetime;
	}

	public Date getSchdeparttime() {
		return schdeparttime;
	}

	public void setSchdeparttime(Date schdeparttime) {
		this.schdeparttime = schdeparttime;
	}

	private static int parseInt(String s) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return 0;
		}
	}

}
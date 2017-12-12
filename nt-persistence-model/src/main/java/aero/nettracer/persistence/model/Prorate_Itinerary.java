package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.ListIterator;

import aero.nettracer.commons.constant.GenericConstants;
import aero.nettracer.commons.utils.CommonsConstants;
import aero.nettracer.commons.utils.CommonsUtils;
import aero.nettracer.commons.utils.GenericDateUtils;
import com.cci.utils.parser.ElementNode;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Prorate_Itinerary")
public class Prorate_Itinerary implements Serializable {
	private int prorate_Itinerary_ID;
	private String airline;
	private String flightnum;
	private Date departdate;
	private String legfrom;
	private String legto;
	private double miles;
	private double percentage;
	private double share;
	private String currency_ID;
	private int claimprorate_ID;

	private String _DATEFORMAT;
	
	private ClaimProrate claimProrate;

	public String toXML() {
		StringBuffer sb = new StringBuffer();

		sb.append("<itinerary_leg>");
		sb.append("<prorate_Itinerary_ID>" + prorate_Itinerary_ID + "</prorate_Itinerary_ID>");
		sb.append("<airline>" + (airline != null ? airline : "") + "</airline>");
		sb.append("<flightnum>" + (flightnum != null ? flightnum : "") + "</flightnum>");
		sb.append("<legfrom>" + (legfrom != null ? legfrom : "") + "</legfrom>");
		sb.append("<legto>" + (legto != null ? legto : "") + "</legto>");
		sb.append("<departdate>" + (departdate == null ? "" : departdate.toString()) + "</departdate>");
		sb.append("<miles>" + miles + "</miles>");
		sb.append("<percentage>" + percentage + "</percentage>");
		sb.append("<share>" + share + "</share>");
		sb.append("<currency_ID>" + currency_ID + "</currency_ID>");
		sb.append("</itinerary_leg>");

		return sb.toString();
	}

	//NTFIXME
	public static Prorate_Itinerary XMLtoObject(ElementNode root) {
		Prorate_Itinerary obj = new Prorate_Itinerary();

		ElementNode child = null, grandchild = null, ggrandchild = null, gggrandchild = null;

		boolean break_main = false;

		for (ListIterator i = root.get_children().listIterator(); i.hasNext();) {
			child = (ElementNode) i.next();
			if (child.getType().equals("prorate_Itinerary_ID")) {
				obj.setProrate_Itinerary_ID(parseInt(child.getTextContents()));
			} else if (child.getType().equals("airline")) {
				obj.setAirline(child.getTextContents());
			} else if (child.getType().equals("flightnum")) {
				obj.setFlightnum(child.getTextContents());
			} else if (child.getType().equals("legfrom")) {
				obj.setLegfrom(child.getTextContents());
			} else if (child.getType().equals("legto")) {
				obj.setLegto(child.getTextContents());
			} else if (child.getType().equals("departdate")) {
				obj.setDepartdate(GenericDateUtils.convertToDate(child.getTextContents(),
						GenericConstants.DB_DATEFORMAT, null));
			} else if (child.getType().equals("miles")) {
				obj.setMiles(parseDouble(child.getTextContents()));
			} else if (child.getType().equals("percentage")) {
				obj.setPercentage(parseDouble(child.getTextContents()));
			} else if (child.getType().equals("share")) {
				obj.setShare(parseDouble(child.getTextContents()));
			} else if (child.getType().equals("currency_ID")) {
				obj.setCurrency_ID(child.getTextContents());
			}

		}

		return obj;
	}

	public String getCurrency_ID() {
		return currency_ID;
	}

	public void setCurrency_ID(String currency_ID) {
		this.currency_ID = currency_ID;
	}

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

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getFlightnum() {
		return flightnum;
	}

	public void setFlightnum(String flightnum) {
		this.flightnum = flightnum;
	}

	public String getLegfrom() {
		return legfrom;
	}

	public void setLegfrom(String legfrom) {
		this.legfrom = legfrom;
	}

	public String getLegto() {
		return legto;
	}

	public void setLegto(String legto) {
		this.legto = legto;
	}

	public double getMiles() {
		return miles;
	}

	public void setMiles(double miles) {
		this.miles = miles;
	}

	@Transient
	public String getDismiles() {
		return CommonsConstants.DECIMALFORMAT.format(getMiles());
	}

	public void setDismiles(String s) {
		setMiles(CommonsUtils.convertToDouble(s));
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	@Transient
	public String getDispercentage() {
		return CommonsConstants.DECIMALFORMAT.format(getPercentage());
	}

	public void setDispercentage(String s) {
		setPercentage(CommonsUtils.convertToDouble(s));
	}

	@Id
	@GeneratedValue
	public int getProrate_Itinerary_ID() {
		return prorate_Itinerary_ID;
	}

	public void setProrate_Itinerary_ID(int prorate_Itinerary_ID) {
		this.prorate_Itinerary_ID = prorate_Itinerary_ID;
	}

	@Column(name = "shared")
	public double getShare() {
		return share;
	}

	@ManyToOne
	@JoinColumn(name = "claimprorate_ID")
	public ClaimProrate getClaimprorate() {
		return claimprorate;
	}

	public void setClaimprorate(ClaimProrate claimprorate) {
		this.claimprorate = claimprorate;
	}
	
	public void setShare(double share) {
		this.share = share;
	}

	@Transient
	public String getDisshare() {
		return CommonsConstants.DECIMALFORMAT.format(getShare());
	}

	public void setDisshare(String s) {
		setShare(CommonsUtils.convertToDouble(s));
	}

	@Transient
	public int getClaimprorate_ID() {
		return claimprorate.getClaimprorate_ID();
	}

	@Transient
	public String get_DATEFORMAT() {
		return _DATEFORMAT;
	}

	public void set_DATEFORMAT(String _dateformat) {
		_DATEFORMAT = _dateformat;
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
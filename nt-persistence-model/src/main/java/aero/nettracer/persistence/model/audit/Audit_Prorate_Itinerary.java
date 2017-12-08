package aero.nettracer.persistence.model.audit;

import java.io.Serializable;
import java.util.Date;

import aero.nettracer.commons.utils.CommonsConstants;
import aero.nettracer.commons.utils.CommonsUtils;
import aero.nettracer.commons.utils.GenericDateUtils;
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
@Table(name = "audit_Prorate_Itinerary")
public class Audit_Prorate_Itinerary implements Serializable {
	private int audit_prorate_itinerary_id;

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

	private String _DATEFORMAT;
	private Audit_ClaimProrate audit_claimprorate;

	@Id
	@GeneratedValue
	public int getAudit_prorate_itinerary_id() {
		return audit_prorate_itinerary_id;
	}

	public void setAudit_prorate_itinerary_id(int audit_prorate_itinerary_id) {
		this.audit_prorate_itinerary_id = audit_prorate_itinerary_id;
	}

	@ManyToOne
	@JoinColumn(name = "audit_claimprorate_id")
	public Audit_ClaimProrate getAudit_claimprorate() {
		return audit_claimprorate;
	}

	public void setAudit_claimprorate(Audit_ClaimProrate audit_claimprorate) {
		this.audit_claimprorate = audit_claimprorate;
	}

	public String getCurrency_ID() {
		return currency_ID;
	}

	public void setCurrency_ID(String currency_ID) {
		this.currency_ID = currency_ID;
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

	public int getProrate_Itinerary_ID() {
		return prorate_Itinerary_ID;
	}

	public void setProrate_Itinerary_ID(int prorate_Itinerary_ID) {
		this.prorate_Itinerary_ID = prorate_Itinerary_ID;
	}

	public double getShare() {
		return share;
	}

	public void setShare(double share) {
		this.share = share;
	}

	@Transient
	public String getDisshare() {
		return CommonsConstants.DECIMALFORMAT.format(getShare());
	}

	@Transient
	public void getDisshare(String s) {
		setShare(CommonsUtils.convertToDouble(s));
	}

	@Transient
	public String get_DATEFORMAT() {
		return _DATEFORMAT;
	}

	public void set_DATEFORMAT(String _dateformat) {
		_DATEFORMAT = _dateformat;
	}
}
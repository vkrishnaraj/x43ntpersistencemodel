package aero.nettracer.persistence.model;

import aero.nettracer.commons.utils.CommonsConstants;
import aero.nettracer.commons.utils.CommonsUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Table(name = "prorate_itinerary")
public class Prorate_Itinerary {

	private int id;
	private ClaimProrate claimProrate;
	private String flightnum;
	private Date departdate;
	private String legfrom;
	private String legto;
	private double miles;
	private double percentage;
	private double share;
	private String currency_ID;
	private String airline;
	private int claimprorate_ID;

	@Id
	@GeneratedValue
	@Column(name = "prorate_itinerary_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "claimprorate_id")
	public ClaimProrate getClaimProrate() {
		return claimProrate;
	}

	public void setClaimProrate(ClaimProrate claimProrate) {
		this.claimProrate = claimProrate;
	}

	@Column(name = "flightnum")
	public String getFlightnum() {
		return flightnum;
	}

	public void setFlightnum(String flightnum) {
		this.flightnum = flightnum;
	}

	@Column(name = "departdate")
	@Temporal(TemporalType.DATE)
	public Date getDepartdate() {
		return departdate;
	}

	public void setDepartdate(Date departdate) {
		this.departdate = departdate;
	}

	@Column(name = "legfrom")
	public String getLegfrom() {
		return legfrom;
	}

	public void setLegfrom(String legfrom) {
		this.legfrom = legfrom;
	}

	@Column(name = "legto")
	public String getLegto() {
		return legto;
	}

	public void setLegto(String legto) {
		this.legto = legto;
	}

	@Column(name = "miles")
	public double getMiles() {
		return miles;
	}

	public void setMiles(double miles) {
		this.miles = miles;
	}

	@Column(name = "percentage")
	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	@Column(name = "shared")
	public double getShare() {
		return share;
	}

	public void setShare(double share) {
		this.share = share;
	}

	@Column(name = "currency_id")
	public String getCurrency_ID() {
		return currency_ID;
	}

	public void setCurrency_ID(String currency_ID) {
		this.currency_ID = currency_ID;
	}

	@Column(name = "airline")
	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	@Transient
	public String getDismiles() {
		return CommonsConstants.DECIMALFORMAT.format(getMiles());
	}

	public void setDismiles(String s) {
		setMiles(CommonsUtils.convertToDouble(s));
	}

	@Transient
	public String getDispercentage() {
		return CommonsConstants.DECIMALFORMAT.format(getPercentage());
	}

	public void setDispercentage(String s) {
		setPercentage(CommonsUtils.convertToDouble(s));
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
		return claimProrate.getId();
	}

}
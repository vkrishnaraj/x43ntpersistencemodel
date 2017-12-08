package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import aero.nettracer.commons.constant.GenericConstants;
import aero.nettracer.commons.utils.GenericDateUtils;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "OHD")
public class TraceOHD implements Serializable {

	private static final long serialVersionUID = 1L;
	private String OHD_ID;
	private Date foundtime;
	private Date founddate;
	private Date bagarrivedate;
	private String claimnum;
	private String color;
	private String type;
	private int ohd_type;
	private String lastname;
	private String firstname;
	private String middlename;
	private AirlineMembership membership;
	private String record_locator;
	private int xdescelement_ID_1;
	private int xdescelement_ID_2;
	private int xdescelement_ID_3;
	private int manufacturer_ID;
	private String manufacturer_other;
	private String externaldesc;
	private Status status;
	private Set<TraceOHD_Inventory> items;
	private Set<TraceOHD_Passenger> passengers;
	private Set<TraceOHD_Itinerary> itinerary;
	private Date close_date;
	private Date lastupdated;

	@Transient
	public Date getFullFoundDate() {
		return GenericDateUtils.convertToDate(getFounddate().toString() + " " + getFoundtime().toString(), GenericConstants.DB_DATETIMEFORMAT,
				null);
	}

	public int getOhd_type() {
		return ohd_type;
	}

	public void setOhd_type(int ohd_type) {
		this.ohd_type = ohd_type;
	}

	@Temporal(TemporalType.DATE)
	public Date getBagarrivedate() {
		return bagarrivedate;
	}

	public void setBagarrivedate(Date bagarrivedate) {
		this.bagarrivedate = bagarrivedate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getLastupdated() {
		return lastupdated;
	}

	public void setLastupdated(Date lastupdated) {
		this.lastupdated = lastupdated;
	}

	@OneToMany(mappedBy = "ohd", fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "itinerarytype,departdate,schdeparttime,itinerary_ID")
	public Set<TraceOHD_Itinerary> getItinerary() {
		return itinerary;
	}

	public void setItinerary(Set<TraceOHD_Itinerary> itinerary) {
		this.itinerary = itinerary;
	}

	@ManyToOne
	@JoinColumn(name = "membership_ID")
	@Cascade(CascadeType.ALL)
	public AirlineMembership getMembership() {
		return membership;
	}

	public void setMembership(AirlineMembership membership) {
		this.membership = membership;
	}

	public String getRecord_locator() {
		return record_locator;
	}

	public void setRecord_locator(String record_locator) {
		this.record_locator = record_locator;
	}

	public String getExternaldesc() {
		return externaldesc;
	}

	public void setExternaldesc(String externaldesc) {
		this.externaldesc = externaldesc;
	}

	public String getClaimnum() {
		return claimnum;
	}

	public void setClaimnum(String claimnum) {
		this.claimnum = claimnum;
	}

	public String getColor() {
		return color;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@OneToMany(mappedBy = "ohd", fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "OHD_Inventory_ID")
	public Set<TraceOHD_Inventory> getItems() {
		return items;
	}

	public void setItems(Set<TraceOHD_Inventory> items) {
		this.items = items;
	}

	@Id
	public String getOHD_ID() {
		return OHD_ID;
	}

	public void setOHD_ID(String ohd_id) {
		OHD_ID = ohd_id;
	}

	@ManyToOne
	@JoinColumn(name = "status_ID")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getManufacturer_ID() {
		return manufacturer_ID;
	}

	public void setManufacturer_ID(int manufacturer_ID) {
		this.manufacturer_ID = manufacturer_ID;
	}

	public String getManufacturer_other() {
		return manufacturer_other;
	}

	public void setManufacturer_other(String manufacturer_other) {
		this.manufacturer_other = manufacturer_other;
	}

	public int getXdescelement_ID_1() {
		return xdescelement_ID_1;
	}

	public void setXdescelement_ID_1(int xdescelement_ID_1) {
		this.xdescelement_ID_1 = xdescelement_ID_1;
	}

	public int getXdescelement_ID_2() {
		return xdescelement_ID_2;
	}

	public void setXdescelement_ID_2(int xdescelement_ID_2) {
		this.xdescelement_ID_2 = xdescelement_ID_2;
	}

	public int getXdescelement_ID_3() {
		return xdescelement_ID_3;
	}

	public void setXdescelement_ID_3(int xdescelement_ID_3) {
		this.xdescelement_ID_3 = xdescelement_ID_3;
	}

	@Temporal(TemporalType.TIME)
	public Date getFoundtime() {
		return foundtime;
	}

	public void setFoundtime(Date foundtime) {
		this.foundtime = foundtime;
	}

	@OneToMany(mappedBy = "ohd", fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "passenger_id")
	public Set<TraceOHD_Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<TraceOHD_Passenger> passengers) {
		this.passengers = passengers;
	}

	@Temporal(TemporalType.DATE)
	public Date getFounddate() {
		return founddate;
	}

	public void setFounddate(Date founddate) {
		this.founddate = founddate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getClose_date() {
		return close_date;
	}

	//NTFIXME
	/*@Transient
	public String getManufacturer() {
		String ret = "";

		if (this.getManufacturer_ID() > 0) {
			if (this.getManufacturer_ID() == CommonsConstants.MANUFACTURER_OTHER_ID) {
				if (this.getManufacturer_other() != null && this.getManufacturer_other().length() > 0) {
					ret = this.getManufacturer_other();
				}
			} else {
				Manufacturer manuf = TracerUtils.getManufacturer(this.getManufacturer_ID());
				if (manuf != null) {
					ret = manuf.getDescription();
				}
			}
		}

		return ret;
	}*/

	public void setClose_date(Date close_date) {
		this.close_date = close_date;
	}
	
	public String format(String val) {
		if (val == null) return " ";
		else return val + " ";
	}
}
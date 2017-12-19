package aero.nettracer.persistence.model.datafeed;

import org.hibernate.annotations.Formula;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity
@Table(name = "z_ws_flight_info")
public class FlightInfo {

	private long id;
	private String arrivalCity;
	private Timestamp arrivalDate;
	private int connPax;
	private String departureCity;
	private Timestamp departureDate;
	private String flightNum;
	private int totalPax;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "arrivalcity")
	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	@Column(name = "arrivaldate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Timestamp arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	@Column(name = "connpax")
	public int getConnPax() {
		return connPax;
	}

	public void setConnPax(int connPax) {
		this.connPax = connPax;
	}
	@Column(name = "departurecity")
	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	@Column(name = "departureDate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Timestamp departureDate) {
		this.departureDate = departureDate;
	}

	@Column(name = "flightNum")
	public String getFlightNum() {
		return flightNum;
	}

	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}

	@Column(name = "totalpax")
	public int getTotalPax() {
		return totalPax;
	}

	public void setTotalPax(int totalPax) {
		this.totalPax = totalPax;
	}

	//TODO
	//Warning this is MySQL specific, if any company other than WestJet uses this, it will have to be moved to compnay specific code
	@Formula("DATE(departureDate)")
	public Date getTruncDepartDate() {
		if (this.departureDate == null)
			return null;
		Calendar c = new GregorianCalendar();
		c.setTime(this.departureDate);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
	
	private void setTruncDepartDate(Date truncDepartDate) {
		
	}

}

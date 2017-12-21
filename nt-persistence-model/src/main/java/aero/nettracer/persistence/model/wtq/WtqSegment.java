package aero.nettracer.persistence.model.wtq;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;

@Embeddable
@Table(name = "wtq_segment")
public class WtqSegment {

	private long id;
	private String airline;
	private Timestamp arrivalTime;
	private Timestamp arrivedate;
	private Timestamp departdate;
	private Timestamp departureTime;
	private String flightnum;
	private String legfrom;
	private String legto;

	@Id
	@GeneratedValue
	@Column(name = "segment_id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="airline", nullable = false)
	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	@Column(name = "arrivaltime", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Timestamp arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	@Column(name="arrivedate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getArrivedate() {
		return arrivedate;
	}

	public void setArrivedate(Timestamp arrivedate) {
		this.arrivedate = arrivedate;
	}

	@Column(name="departdate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getDepartdate() {
		return departdate;
	}

	public void setDepartdate(Timestamp departdate) {
		this.departdate = departdate;
	}

	@Column(name="departureTime", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Timestamp departureTime) {
		this.departureTime = departureTime;
	}

	@Column(name = "flightnum", nullable = false)
	public String getFlightnum() {
		return flightnum;
	}

	public void setFlightnum(String flightnum) {
		this.flightnum = flightnum;
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

}

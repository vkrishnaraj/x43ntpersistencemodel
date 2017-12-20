package aero.nettracer.persistence.model.onlineclaims;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;

@Entity
@Table(name = "oc_itinerary")
public class OCItinerary {

	private long id;
	private String airline;
	private String arrivalCity;
	private Timestamp createdate;
	private String departureCity;
	private String flightNum;
	private OnlineClaim claim;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "airline")
	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	@Column(name = "arrivalcity")
	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	@Column(name = "createdate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	@Column(name = "departurecity")
	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	@Column(name = "flightnum")
	public String getFlightNum() {
		return flightNum;
	}

	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}

	@ManyToOne
	@JoinColumn(name = "claimId", nullable = false)
	public OnlineClaim getClaim() {
		return claim;
	}

	public void setClaim(OnlineClaim claim) {
		this.claim = claim;
	}
}

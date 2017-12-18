package aero.nettracer.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "proactivenotification")
public class ProactiveNotification {

	public static final int STATUS_OPEN = 81;
	public static final int STATUS_CLOSED = 82;
	
	private long id;
	private String locator;
	private String missedFlightAirline;
	private Timestamp missedFlightDate;
	private String missedFlightDestination;
	private String missedFlightNumber;
	private String name;
	private Station destinationStation;
	private Incident incident;
	private Status status;
	private int passIndex;
	private OnlineIncidentAuthorization oia;
	private Set<OHD_Log> ohd_logs;
	private boolean finalFlightsMatch;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "locator")
	public String getLocator() {
		return locator;
	}

	public void setLocator(String locator) {
		this.locator = locator;
	}

	@Column(name = "missedflightairline")
	public String getMissedFlightAirline() {
		return missedFlightAirline;
	}

	public void setMissedFlightAirline(String missedFlightAirline) {
		this.missedFlightAirline = missedFlightAirline;
	}

	@Column(name = "missedflightdate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getMissedFlightDate() {
		return missedFlightDate;
	}

	public void setMissedFlightDate(Timestamp missedFlightDate) {
		this.missedFlightDate = missedFlightDate;
	}

	@Column(name = "missedflightdestination")
	public String getMissedFlightDestination() {
		return missedFlightDestination;
	}

	public void setMissedFlightDestination(String missedFlightDestination) {
		this.missedFlightDestination = missedFlightDestination;
	}

	@Column(name = "missedflightnumber")
	public String getMissedFlightNumber() {
		return missedFlightNumber;
	}

	public void setMissedFlightNumber(String missedFlightNumber) {
		this.missedFlightNumber = missedFlightNumber;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name = "destinationstation_id", nullable = false)
	public Station getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(Station destinationStation) {
		this.destinationStation = destinationStation;
	}

	@ManyToOne
	@JoinColumn(name = "incident_id")
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	@ManyToOne
	@JoinColumn(name = "status_id", nullable = false)
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Column(name = "passindex")
	public int getPassIndex() {
		return passIndex;
	}

	public void setPassIndex(int passIndex) {
		this.passIndex = passIndex;
	}

	@OneToOne
	@JoinColumn(name = "oia_id")
	public OnlineIncidentAuthorization getOia() {
		return oia;
	}

	public void setOia(OnlineIncidentAuthorization oia) {
		this.oia = oia;
	}

	@OneToMany(mappedBy = "pcn", cascade = CascadeType.ALL)
	public Set<OHD_Log> getOhd_logs() {
		return ohd_logs;
	}

	public void setOhd_logs(Set<OHD_Log> ohd_log) {
		this.ohd_logs = ohd_log;
	}

	@Transient
	public boolean isFinalFlightsMatch() {
		return finalFlightsMatch;
	}

	public void setFinalFlightsMatch(boolean finalFlightsMatch) {
		this.finalFlightsMatch = finalFlightsMatch;
	}

	public static int getSTATUS_OPEN() {
		return STATUS_OPEN;
	}

	public static int getSTATUS_CLOSED() {
		return STATUS_CLOSED;
	}

}

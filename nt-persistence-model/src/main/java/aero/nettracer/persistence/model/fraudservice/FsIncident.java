package aero.nettracer.persistence.model.fraudservice;

import aero.nettracer.commons.utils.GenericDateUtils;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "fsincident")
public class FsIncident {

	private long id;
	private String companyCode;
	private String airlineIncidentId;
	private Timestamp incidentCreated;
	private String incidentDescription;
	private int incidentType;
	private int itinComplexity;
	private int numberDaysOpen;
	private int numberOfBdos;
	private String remarks;
	private Timestamp timestampClosed;
	private Timestamp timestampOpen;
	private Set<Segment> segments;
	private File file;
	private Reservation reservation;
	private Set<Bag> bags;
	private Set<Person> passengers;

	public FsIncident() {

	}

	public FsIncident(long id){
		this.id = id;
	}

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "company_code")
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	@Column(name = "ailrlineincidentid", unique = true)
	public String getAirlineIncidentId() {
		return airlineIncidentId;
	}

	public void setAirlineIncidentId(String airlineIncidentId) {
		this.airlineIncidentId = airlineIncidentId;
	}

	@Column(name = "incidentcreated")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getIncidentCreated() {
		return incidentCreated;
	}

	public void setIncidentCreated(Timestamp incidentCreated) {
		this.incidentCreated = incidentCreated;
	}

	@Column(name = "incidentdescription")
	public String getIncidentDescription() {
		return incidentDescription;
	}

	public void setIncidentDescription(String incidentDescription) {
		this.incidentDescription = incidentDescription;
	}

	@Column(name = "incidenttype")
	public int getIncidentType() {
		return incidentType;
	}

	public void setIncidentType(int incidentType) {
		this.incidentType = incidentType;
	}

	@Column(name = "itincomplexity")
	public int getItinComplexity() {
		return itinComplexity;
	}

	public void setItinComplexity(int itinComplexity) {
		this.itinComplexity = itinComplexity;
	}

	@Column(name = "numberdaysopen")
	public int getNumberDaysOpen() {
		return numberDaysOpen;
	}

	public void setNumberDaysOpen(int numberDaysOpen) {
		this.numberDaysOpen = numberDaysOpen;
	}

	@Column(name = "numberofbdos")
	public int getNumberOfBdos() {
		return numberOfBdos;
	}

	public void setNumberOfBdos(int numberOfBdos) {
		this.numberOfBdos = numberOfBdos;
	}

	@Column(name = "remarks")
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "timestampclosed")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getTimestampClosed() {
		return timestampClosed;
	}

	public void setTimestampClosed(Timestamp timestampClosed) {
		this.timestampClosed = timestampClosed;
	}

	@Column(name = "timestampopen")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getTimestampOpen() {
		return timestampOpen;
	}

	public void setTimestampOpen(Timestamp timestampOpen) {
		this.timestampOpen = timestampOpen;
	}

	@OneToMany(mappedBy = "incident", cascade = CascadeType.ALL)
	@OrderBy(value = "id")
	public Set<Segment> getSegments() {
		return segments;
	}

	public void setSegments(Set<Segment> segments) {
		this.segments = segments;
	}

	@OneToOne
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "incident")
	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	@OneToMany(mappedBy = "incident", cascade = CascadeType.ALL)
	@OrderBy(value = "id")
	public Set<Bag> getBags() {
		return bags;
	}

	public void setBags(Set<Bag> bags) {
		this.bags = bags;
	}

	@OneToMany(mappedBy = "incident", cascade = CascadeType.ALL)
	@OrderBy(value = "id")
	public Set<Person> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<Person> passengers) {
		this.passengers = passengers;
	}

	@Transient
	public String getDisOpenDate(String dateFormat) {
		return getDisDate(timestampOpen, dateFormat);
	}

	private String getDisDate(Date date, String dateFormat) {
		return GenericDateUtils.formatDate(date, dateFormat, "", null);
	}

}

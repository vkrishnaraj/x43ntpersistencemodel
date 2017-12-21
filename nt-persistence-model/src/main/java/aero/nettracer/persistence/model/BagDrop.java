package aero.nettracer.persistence.model;

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
@Table(name = "bagdrop")
public class BagDrop {

	private long id;
	private Timestamp createDate;
	private Timestamp lastUpdated;
	private String arrivalStationCode;
	private String originStationCode;
	private int entryMethod;
	private Timestamp bagDropTime;
	private Timestamp schArrivalDate;
	private Timestamp actArrivalDate;
	private String airline;
	private String flight;
	private Agent createAgent;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "createDate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "lastUpdated")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Column(name = "arrivalStationCode")
	public String getArrivalStationCode() {
		return arrivalStationCode;
	}

	public void setArrivalStationCode(String arrivalStationCode) {
		this.arrivalStationCode = arrivalStationCode;
	}

	@Column(name = "originStationCode")
	public String getOriginStationCode() {
		return originStationCode;
	}

	public void setOriginStationCode(String originStationCode) {
		this.originStationCode = originStationCode;
	}

	@Column(name = "entryMethod")
	public int getEntryMethod() {
		return entryMethod;
	}

	public void setEntryMethod(int entryMethod) {
		this.entryMethod = entryMethod;
	}

	@Column(name = "bagDropTime")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getBagDropTime() {
		return bagDropTime;
	}

	public void setBagDropTime(Timestamp bagDropTime) {
		this.bagDropTime = bagDropTime;
	}

	@Column(name = "schArrivalDate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getSchArrivalDate() {
		return schArrivalDate;
	}

	public void setSchArrivalDate(Timestamp schArrivalDate) {
		this.schArrivalDate = schArrivalDate;
	}

	@Column(name = "actArrivalDate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getActArrivalDate() {
		return actArrivalDate;
	}

	public void setActArrivalDate(Timestamp actArrivalDate) {
		this.actArrivalDate = actArrivalDate;
	}

	@Column(name = "airline")
	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	@Column(name = "flight")
	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	@ManyToOne
	@JoinColumn(name = "createagent_id")
	public Agent getCreateAgent() {
		return createAgent;
	}

	public void setCreateAgent(Agent createAgent) {
		this.createAgent = createAgent;
	}
}

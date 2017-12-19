package aero.nettracer.persistence.model.fraudservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pnrdata")
public class PnrData {

	private long id;
	private String airline;
	private String pnrData;
	private String recordLocator;
	private Reservation reservation;

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

	@Column(name = "pnrdata")
	public String getPnrData() {
		return pnrData;
	}

	public void setPnrData(String pnrData) {
		this.pnrData = pnrData;
	}

	@Column(name = "recordlocator")
	public String getRecordLocator() {
		return recordLocator;
	}

	public void setRecordLocator(String recordLocator) {
		this.recordLocator = recordLocator;
	}

	@OneToOne
	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

}

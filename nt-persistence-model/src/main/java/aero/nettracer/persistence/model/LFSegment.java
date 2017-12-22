package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="lfsegment")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class LFSegment {

	private long id;
	private String companyCode;
	private String flightNumber;
	private String originStationCode;
	private String destinationStationCode;
	private LFLost lost;
	private String seat;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="comp_code")
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	@Column(name="flight_num")
	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	@Column(name="org_stn_code")
	public String getOriginStationCode() {
		return originStationCode;
	}

	public void setOriginStationCode(String originStationCode) {
		this.originStationCode = originStationCode;
	}

	@Column(name="dest_stn_code")
	public String getDestinationStationCode() {
		return destinationStationCode;
	}

	public void setDestinationStationCode(String destinationStationCode) {
		this.destinationStationCode = destinationStationCode;
	}

	@ManyToOne
	@JoinColumn(name = "lost_id")
	public LFLost getLost() {
		return lost;
	}

	public void setLost(LFLost lost) {
		this.lost = lost;
	}

	@Column(name = "seat")
	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

}

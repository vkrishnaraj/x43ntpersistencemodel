package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="lfsegment")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class LFSegment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3566745444509507964L;

	@Id
	@GeneratedValue
	private long id;

	@Column(name="comp_code",length = 8)
	private String companyCode;
	
	@Column(name="flight_num",length = 8)
	private String flightNumber;
	
	@Column(name="org_stn_code",length = 8)
	private String originStationCode;
	
	@Column(name="dest_stn_code",length = 8)
	private String destinationStationCode;

	private String seat;
	
	@ManyToOne
	@JoinColumn(name = "lost_id", nullable = true)
	@Fetch(FetchMode.SELECT)
	private LFLost lost;

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public LFLost getLost() {
		return lost;
	}

	public void setLost(LFLost lost) {
		this.lost = lost;
	}

	public String getOriginStationCode() {
		return originStationCode;
	}

	public void setOriginStationCode(String originStationCode) {
		this.originStationCode = originStationCode;
	}

	public String getDestinationStationCode() {
		return destinationStationCode;
	}

	public void setDestinationStationCode(String destinationStationCode) {
		this.destinationStationCode = destinationStationCode;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}
}

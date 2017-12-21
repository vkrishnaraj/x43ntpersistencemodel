package aero.nettracer.persistence.model.wtq;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("REQUEST_QOH")
public class WtqRequestQoh extends WtqRequestOhd {

	private String bagTagNumber;
	private String fromStation;
	private String fromAirline;

	@Column(name="bag_tag")
	public String getBagTagNumber() {
		return bagTagNumber;
	}

	public void setBagTagNumber(String bagTagNumber) {
		this.bagTagNumber = bagTagNumber;
	}

	@Column(name="from_station")
	public String getFromStation() {
		return fromStation;
	}

	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}

	@Column(name="from_airline")
	public String getFromAirline() {
		return fromAirline;
	}

	public void setFromAirline(String fromAirline) {
		this.fromAirline = fromAirline;
	}

	@Override
	@Transient
	public Object[] getExistsParameters() {
		return new Object[] {this.getBagTagNumber(), this.getStatus()};
	}

	@Override
	@Transient
	public String getExistsQuery() {
		return "from WtqRequestOhd roh where roh.bagTagNumber = ? and status = ?";
	}

}

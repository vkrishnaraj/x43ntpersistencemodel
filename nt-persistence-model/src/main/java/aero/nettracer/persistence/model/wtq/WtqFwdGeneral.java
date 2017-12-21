package aero.nettracer.persistence.model.wtq;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "FWD_GENERAL")
public class WtqFwdGeneral extends WtqFwd {

	public WtqFwdGeneral() {
	}

	private int lossCode;
	private String lossComments;
	private String from_station;

	@Column(name = "losscode")
	public int getLossCode() {
		return lossCode;
	}

	public void setLossCode(int lossCode) {
		this.lossCode = lossCode;
	}

	@Column(name = "losscomments")
	public String getLossComments() {
		return lossComments;
	}

	public void setLossComments(String lossComments) {
		this.lossComments = lossComments;
	}
	
	@Column(name = "from_station")
	public String getFrom_station() {
		return from_station;
	}

	public void setFrom_station(String from_station) {
		this.from_station = from_station;
	}

}

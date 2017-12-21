package aero.nettracer.persistence.model.wtq;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("ERASE_AF")
public class WtqEraseActionFile extends WorldTracerQueue {
	
	private String af_id;

	@Column(name = "af_id")
	public String getAf_id() {
		return af_id;
	}

	public void setAf_id(String af_id) {
		this.af_id = af_id;
	}

	@Override
	@Transient
	public Object[] getExistsParameters() {
		return new Object[] {af_id, WtqStatus.PENDING};
	}

	@Override
	@Transient
	public String getExistsQuery() {
		return "from WtqEraseActionFile where af_id = ? and status = ?";
	}
}

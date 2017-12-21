package aero.nettracer.persistence.model.wtq;

import aero.nettracer.persistence.model.OHD;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "FWD_OHD")
public class WtqFwdOhd extends WtqFwd {

	public WtqFwdOhd() {
	}

	private OHD ohd;
	
	@ManyToOne
	@JoinColumn(name = "ohd_id")
	public OHD getOhd() {
		return ohd;
	}
	
	public void setOhd(OHD ohd) {
		this.ohd = ohd;
	}
}

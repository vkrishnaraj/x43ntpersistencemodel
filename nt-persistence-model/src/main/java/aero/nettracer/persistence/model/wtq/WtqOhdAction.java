package aero.nettracer.persistence.model.wtq;

import aero.nettracer.persistence.model.OHD;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Proxy;

@Entity
public abstract class WtqOhdAction extends WorldTracerQueue {
	private OHD ohd;
	
	public WtqOhdAction() { }
	
	public WtqOhdAction(OHD ohd) {
		this.ohd = ohd;
	}
	
	@ManyToOne(targetEntity = OHD.class)
	@JoinColumn(name = "ohd_id")
	public OHD getOhd() {
		return ohd;
	}

	@Override
	@Transient
	public String getExistsQuery() {
		return "from WtqOhdAction woa where woa.ohd.OHD_ID = ? and woa.status = ?";
	}

	@Override
	@Transient
	public Object[] getExistsParameters() {
		return new Object[] {ohd.getOHD_ID(), this.getStatus()};
	}

	public void setOhd(OHD ohd) {
		this.ohd = ohd;
	}
	
}

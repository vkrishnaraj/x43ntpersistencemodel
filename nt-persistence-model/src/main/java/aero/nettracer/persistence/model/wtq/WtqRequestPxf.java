package aero.nettracer.persistence.model.wtq;

import aero.nettracer.persistence.model.WT_PXF;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import java.util.Set;

@Entity
@DiscriminatorValue("REQUEST_PXF")

public class WtqRequestPxf extends WtqIncidentAction {

	public WtqRequestPxf() {
	}

	private String furtherInfo;
	private WT_PXF pxf;
	private Set<String> teletypes;

	@Column(name = "furtherinfo")
	public String getFurtherInfo() {
		return furtherInfo;
	}

	public void setFurtherInfo(String furtherInfo) {
		this.furtherInfo = furtherInfo;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pxf")
	public WT_PXF getPxf() {
		return pxf;
	}

	public void setPxf(WT_PXF pxf) {
		this.pxf = pxf;
	}

	@ElementCollection
	@JoinTable(name = "wtq_teletype", joinColumns=@JoinColumn(name="wt_queue_id"))
	@Column(name = "ttype_address", nullable = false)
	public Set<String> getTeletypes() {
		return teletypes;
	}

	public void setTeletypes(Set<String> teletypes) {
		this.teletypes = teletypes;
	}
	
	@Override
	@Transient
	public Object[] getExistsParameters() {
		return new Object[] {this.getPxf(), this.getStatus()};
	}

	@Override
	@Transient
	public String getExistsQuery() {
		return "from WtqRequestPxf wtqrpxf where wtqrpxf.pxf = ? and status = ?";
	}
	
}

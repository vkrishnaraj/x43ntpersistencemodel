package aero.nettracer.persistence.model.wtq;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Transient;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("REQUEST_OHD")
public class WtqRequestOhd extends WtqIncidentAction {

	public WtqRequestOhd() {
		// TODO Auto-generated constructor stub
	}

	private String furtherInfo;
	private String wt_ohd;
	private Set<String> teletypes;
	private Set<String> paxName = new HashSet<String>();

	@Column(name = "furtherinfo")
	public String getFurtherInfo() {
		return furtherInfo;
	}

	public void setFurtherInfo(String furtherInfo) {
		this.furtherInfo = furtherInfo;
	}

	@Column(name = "wt_ohd")
	public String getWt_ohd() {
		return wt_ohd;
	}

	public void setWt_ohd(String wt_ohd) {
		this.wt_ohd = wt_ohd;
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

	@ElementCollection
	@JoinTable(name = "wtq_name", joinColumns = @JoinColumn(name = "wt_queue_id"))
	@Column(name = "pax_name", nullable = false)
	public Set<String> getPaxName() {
		return paxName;
	}

	public void setPaxName(Set<String> paxName) {
		this.paxName = paxName;
	}

	@Override
	@Transient
	public Object[] getExistsParameters() {
		return new Object[] {this.getWt_ohd(), this.getStatus()};
	}

	@Override
	@Transient
	public String getExistsQuery() {
		return "from WtqRequestOhd roh where roh.wt_ohd = ? and status = ?";
	}

}

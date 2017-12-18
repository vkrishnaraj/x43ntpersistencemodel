package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class WorldTracerFile {

	private WTStatus wt_status;
	private String wt_id;
	
	public WorldTracerFile() {}
	
	public WorldTracerFile(String id) {
		this.wt_status = WTStatus.ACTIVE;
		this.wt_id = id;
	}
	
	public WorldTracerFile(String wt_id, WTStatus wtStatus) {
		this.wt_id = wt_id;
		this.wt_status = wtStatus;
	}

	@Enumerated(EnumType.STRING)
	public WTStatus getWt_status() {
		return wt_status;
	}
	public void setWt_status(WTStatus wt_status) {
		this.wt_status = wt_status;
	}
	
	@Column(name = "wt_id")
	public String getWt_id() {
		return wt_id;
	}
	public void setWt_id(String wt_id) {
		this.wt_id = wt_id;
	}
	
	@Override
	public boolean equals(Object otherObject) {
		// TODO Auto-generated method stub
		if(this == otherObject) return true;
		if(otherObject == null) return false;
		if(!(otherObject instanceof WorldTracerFile)) return false;
		
		if(wt_id == null || wt_status == null) return false;
		
		WorldTracerFile o = (WorldTracerFile) otherObject;
		return (wt_id == null ? o.wt_id == null : wt_id.equals(o.wt_id))
				&& (wt_status == null ? o.wt_status == null : wt_status.equals(o.wt_status));
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 37 * result + (wt_status == null ? 0 : wt_status.hashCode());
		result = 37 * result + (wt_id == null ? 0 : wt_id.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return String.format("%s:%s", wt_id, wt_status);
	}

	public static enum WTStatus {
		ACTIVE, SUSPENDED, CLOSED
	}
}

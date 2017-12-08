package aero.nettracer.persistence.model.audit;

import java.io.Serializable;

import aero.nettracer.persistence.model.OHD;
import aero.nettracer.persistence.model.Station;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Audit_file_control")
public class Audit_ControlLog implements Serializable {

	private int id;
	private int control_id;
	private String start_date;
	private String end_date;
	private Station controlling_station;
	
	private Audit_OHD audit_ohd;
	private OHD ohd;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "audit_ohd_id")
	public Audit_OHD getAudit_ohd() {
		return audit_ohd;
	}

	public void setAudit_ohd(Audit_OHD audit_ohd) {
		this.audit_ohd = audit_ohd;
	}

	@ManyToOne
	@JoinColumn(name = "file_ref_number")
	public OHD getOhd() {
		return ohd;
	}

	public void setOhd(OHD ohd) {
		this.ohd = ohd;
	}

	public int getControl_id() {
		return control_id;
	}

	public void setControl_id(int control_id) {
		this.control_id = control_id;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	@ManyToOne
	@JoinColumn(name = "controlling_station_id")
	public Station getControlling_station() {
		return controlling_station;
	}

	public void setControlling_station(Station controlling_station) {
		this.controlling_station = controlling_station;
	}
}
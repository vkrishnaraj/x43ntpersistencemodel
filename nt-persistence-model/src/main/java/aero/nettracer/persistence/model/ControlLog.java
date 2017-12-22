package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;

@Entity
@Table(name = "file_control")
public class ControlLog {

	private int control_id;
	private Timestamp start_date;
	private Timestamp end_date;
	private Station controlling_station;
	private OHD ohd;

	@Id
	@GeneratedValue
	public int getControl_id() {
		return control_id;
	}

	public void setControl_id(int control_id) {
		this.control_id = control_id;
	}

	@ManyToOne
	@JoinColumn(name = "file_ref_number")
	public OHD getOhd() {
		return ohd;
	}

	public void setOhd(OHD ohd) {
		this.ohd = ohd;
	}

	@Column(name = "start_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getStart_date() {
		return start_date;
	}

	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}

	@Column(name = "end_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Timestamp end_date) {
		this.end_date = end_date;
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
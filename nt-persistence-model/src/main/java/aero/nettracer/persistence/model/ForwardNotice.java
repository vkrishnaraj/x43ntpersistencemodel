package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "forwardnotice")
public class ForwardNotice {

	public static final int OPEN_STATUS = 0;
	public static final int CLOSED_STATUS = 1;
	private static final String MSG_KEY = "FORWARD_NOTICE_KEY_";

	private long id;
	private int status;
	private OHD_Log forward;
	private Station station;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@ManyToOne
	@JoinColumn(name = "ohd_log_id")
	public OHD_Log getForward() {
		return forward;
	}

	public void setForward(OHD_Log forward) {
		this.forward = forward;
	}

	@ManyToOne
	@JoinColumn(name = "station_id")
	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public String getKey() {
		return MSG_KEY + getStatus();
	}

}
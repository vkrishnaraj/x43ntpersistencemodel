package aero.nettracer.persistence.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Time;


@Entity
@Table(name = "carrier_operation_hours")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Carrier_Operation_Hours {

	private int id;
	private Station station;
	private String day_of_week;
	private Time starttime;
	private Time endtime;

	@Id
	@GeneratedValue
	@Column(name = "carrier_operation_hours_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "station_id", nullable = false)
	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	@Column(name = "day_of_week")
	public String getDay_of_week() {
		return day_of_week;
	}

	public void setDay_of_week(String day_of_week) {
		this.day_of_week = day_of_week;
	}

	@Column(name = "starttime")
	@Temporal(TemporalType.TIME)
	public Time getStarttime() {
		return starttime;
	}

	public void setStarttime(Time starttime) {
		this.starttime = starttime;
	}

	@Column(name = "endtime")
	@Temporal(TemporalType.TIME)
	public Time getEndtime() {
		return endtime;
	}

	public void setEndtime(Time endtime) {
		this.endtime = endtime;
	}
}
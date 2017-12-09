package aero.nettracer.persistence.model;

import java.io.Serializable;

import aero.nettracer.persistence.model.wtq.WorldTracerQueue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Proxy;


@Entity
@Table(name = "wtq_pxf")
public class WT_PXF {

	private int id;
	private String airline_1;
	private String airline_2;
	private String airline_3;
	private String airline_4;
	private String airline_5;
	private String area_1;
	private String area_2;
	private String area_3;
	private String area_4;
	private String area_5;
	private int destination = 3;
	private String station_1;
	private String station_2;
	private String station_3;
	private String station_4;
	private String station_5;
	private WorldTracerQueue worldTracerQueue;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "airline_1", length = 255)
	public String getAirline_1() {
		return airline_1;
	}

	public void setAirline_1(String airline_1) {
		this.airline_1 = airline_1;
	}

	@Column(name = "airline_2", length = 255)
	public String getAirline_2() {
		return airline_2;
	}

	public void setAirline_2(String airline_2) {
		this.airline_2 = airline_2;
	}

	@Column(name = "airline_3", length = 255)
	public String getAirline_3() {
		return airline_3;
	}

	public void setAirline_3(String airline_3) {
		this.airline_3 = airline_3;
	}

	@Column(name = "airline_4", length = 255)
	public String getAirline_4() {
		return airline_4;
	}

	public void setAirline_4(String airline_4) {
		this.airline_4 = airline_4;
	}

	@Column(name = "airline_5", length = 255)
	public String getAirline_5() {
		return airline_5;
	}

	public void setAirline_5(String airline_5) {
		this.airline_5 = airline_5;
	}

	@Column(name = "area_1", length = 255)
	public String getArea_1() {
		return area_1;
	}

	public void setArea_1(String area_1) {
		this.area_1 = area_1;
	}

	@Column(name = "area_2", length = 255)
	public String getArea_2() {
		return area_2;
	}

	public void setArea_2(String area_2) {
		this.area_2 = area_2;
	}

	@Column(name = "area_3", length = 255)
	public String getArea_3() {
		return area_3;
	}

	public void setArea_3(String area_3) {
		this.area_3 = area_3;
	}

	@Column(name = "area_4", length = 255)
	public String getArea_4() {
		return area_4;
	}

	public void setArea_4(String area_4) {
		this.area_4 = area_4;
	}

	@Column(name = "area_5", length = 255)
	public String getArea_5() {
		return area_5;
	}

	public void setArea_5(String area_5) {
		this.area_5 = area_5;
	}

	@Column(name = "destination", length = 11)
	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	@Column(name = "station_1", length = 3)
	public String getStation_1() {
		return station_1;
	}

	public void setStation_1(String station_1) {
		this.station_1 = station_1;
	}

	@Column(name = "station_2", length = 3)
	public String getStation_2() {
		return station_2;
	}

	public void setStation_2(String station_2) {
		this.station_2 = station_2;
	}

	@Column(name = "station_3", length = 3)
	public String getStation_3() {
		return station_3;
	}

	public void setStation_3(String station_3) {
		this.station_3 = station_3;
	}

	@Column(name = "station_4", length = 3)
	public String getStation_4() {
		return station_4;
	}

	public void setStation_4(String station_4) {
		this.station_4 = station_4;
	}

	@Column(name = "station_5", length = 3)
	public String getStation_5() {
		return station_5;
	}

	public void setStation_5(String station_5) {
		this.station_5 = station_5;
	}

	@OneToOne
	@JoinColumn(name = "wt_queue_id")
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.PERSIST})
	public WorldTracerQueue getWorldTracerQueue() {
		return worldTracerQueue;
	}

	public void setWorldTracerQueue(WorldTracerQueue worldTracerQueue) {
		this.worldTracerQueue = worldTracerQueue;
	}
}

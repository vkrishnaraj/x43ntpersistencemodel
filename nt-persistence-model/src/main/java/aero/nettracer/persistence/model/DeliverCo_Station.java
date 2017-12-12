package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "deliverco_station")
public class DeliverCo_Station {

	private int id;
	private DeliverCompany delivercompany;
	private Station station;


	@Id
	@GeneratedValue
	@Column(name = "deliverco_station_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "delivercompany_id", nullable = false)
	public DeliverCompany getDelivercompany() {
		return delivercompany;
	}

	public void setDelivercompany(DeliverCompany delivercompany) {
		this.delivercompany = delivercompany;
	}

	@ManyToOne
	@JoinColumn(name = "station_id", nullable = false)
	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}
}
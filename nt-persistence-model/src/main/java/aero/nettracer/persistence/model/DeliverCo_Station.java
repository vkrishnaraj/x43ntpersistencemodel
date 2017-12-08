package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "deliverco_station")
public class DeliverCo_Station implements Serializable {
	private int deliverco_station_ID;
	private int station_ID;
	private DeliverCompany delivercompany;

	@Id
	@GeneratedValue
	public int getDeliverco_station_ID() {
		return deliverco_station_ID;
	}

	public void setDeliverco_station_ID(int deliverco_station_ID) {
		this.deliverco_station_ID = deliverco_station_ID;
	}

	public int getStation_ID() {
		return station_ID;
	}

	public void setStation_ID(int station_ID) {
		this.station_ID = station_ID;
	}

	@ManyToOne
	@JoinColumn(name = "delivercompany_ID")
	public DeliverCompany getDelivercompany() {
		return delivercompany;
	}


	public void setDelivercompany(DeliverCompany delivercompany) {
		this.delivercompany = delivercompany;
	}
}
package aero.nettracer.persistence.model.issuance;

import aero.nettracer.persistence.model.Station;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="issuance_item_quantity")
public class IssuanceItemQuantity {

	@Id
	@GeneratedValue
	private long id;
	
	private int quantity;
	
	@Column(name="minimum_active_quantity")
	private int minimuActiveQuantity;
	
	@ManyToOne
	@JoinColumn(name = "station_id")
	private Station station;

	@ManyToOne
	@JoinColumn(name = "issuance_item_id")
	private IssuanceItem issuanceItem;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public IssuanceItem getIssuanceItem() {
		return issuanceItem;
	}

	public void setIssuanceItem(IssuanceItem issuanceItem) {
		this.issuanceItem = issuanceItem;
	}

	public int getMinimuActiveQuantity() {
		return minimuActiveQuantity;
	}

	public void setMinimuActiveQuantity(int minimuActiveQuantity) {
		this.minimuActiveQuantity = minimuActiveQuantity;
	}
	
}

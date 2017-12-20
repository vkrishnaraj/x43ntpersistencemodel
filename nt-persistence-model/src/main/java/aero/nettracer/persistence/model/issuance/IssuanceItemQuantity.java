package aero.nettracer.persistence.model.issuance;

import aero.nettracer.persistence.model.Station;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="issuance_item_quantity")
public class IssuanceItemQuantity {

	private long id;
	private int quantity;
	private int minimuActiveQuantity;
	private Station station;
	private IssuanceItem issuanceItem;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "quantity")
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name="minimum_active_quantity")
	public int getMinimuActiveQuantity() {
		return minimuActiveQuantity;
	}

	public void setMinimuActiveQuantity(int minimuActiveQuantity) {
		this.minimuActiveQuantity = minimuActiveQuantity;
	}

	@ManyToOne
	@JoinColumn(name = "station_id")
	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	@ManyToOne
	@JoinColumn(name = "issuance_item_id")
	public IssuanceItem getIssuanceItem() {
		return issuanceItem;
	}

	public void setIssuanceItem(IssuanceItem issuanceItem) {
		this.issuanceItem = issuanceItem;
	}

}

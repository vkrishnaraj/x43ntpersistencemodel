package aero.nettracer.persistence.model.salvage;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salvage_item")
public class SalvageItem {

	private int id;
	private String description = "";
	private String lostAndFoundId;
	private int quantity = 1;
	private int type; // valid values are: 0 - default, 1-low value, 2-high value
	private SalvageBox box;

	@Id
	@GeneratedValue
	@Column(name="item_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="lostandfound_id")
	public String getLostAndFoundId() {
		return this.lostAndFoundId;
	}

	public void setLostAndFoundId(String lostAndFoundId) {
		this.lostAndFoundId = lostAndFoundId;
	}

	@Column(name="quantity")
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@ManyToOne
	@JoinColumn(name = "box_id", nullable = false)
	@Fetch(FetchMode.SELECT)
	public SalvageBox getBox() {
		return box;
	}

	public void setBox(SalvageBox box) {
		this.box = box;
	}
	
	@Column(name="type")
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}

}

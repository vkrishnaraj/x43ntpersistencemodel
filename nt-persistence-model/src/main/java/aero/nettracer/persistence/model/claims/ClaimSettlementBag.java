package aero.nettracer.persistence.model.claims;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "z_b6_claim_settlement_bag")
public class ClaimSettlementBag {

	private long id;
	private String color;
	private String manufacturer;
	private String type;
	private ClaimSettlement claimsettlement;
	private int position;
	private List<SettlementBagInventory> inventory;

	@Id
	@GeneratedValue
	@Column(name = "bagid")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "color")
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "manufacturer")
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Column(name = "type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@ManyToOne
	@JoinColumn(name = "claimsettlementid", nullable = false)
	public ClaimSettlement getClaimsettlement() {
		return claimsettlement;
	}

	public void setClaimsettlement(ClaimSettlement claimsettlement) {
		this.claimsettlement = claimsettlement;
	}

	@Column(name = "position")
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@OneToMany(mappedBy = "claimSettlementBag", cascade=CascadeType.ALL)
	@OrderColumn(name="position")
	public List<SettlementBagInventory> getInventory() {
		return inventory;
	}

	public void setInventory(List<SettlementBagInventory> inventory) {
		this.inventory = inventory;
	}

}

package aero.nettracer.persistence.model.claims;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "z_b6_claim_settlement_bag")
public class ClaimSettlementBag {

	@Id
	@GeneratedValue
	private long bagId;
	
	@Basic
	private int position;

	@Column(length = 2)
	private String color;

	@Column(length = 2)
	private String type;

	@Column(length = 100)
	private String manufacturer;

	@ManyToOne(targetEntity = ClaimSettlement.class)
	@JoinColumn(name = "claimSettlementId", nullable = false)
	private ClaimSettlement claimSettlement;

	@OneToMany(mappedBy = "claimSettlementBag", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@IndexColumn(name="position")
	@Fetch(FetchMode.SELECT)
	private List<SettlementBagInventory> inventory;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public ClaimSettlement getClaimSettlement() {
		return claimSettlement;
	}

	public void setClaimSettlement(ClaimSettlement claimSettlement) {
		this.claimSettlement = claimSettlement;
	}

	public long getBagId() {
		return bagId;
	}

	public void setBagId(long bagId) {
		this.bagId = bagId;
	}

	public List<SettlementBagInventory> getInventory() {
		return inventory;
	}

	public void setInventory(List<SettlementBagInventory> inventory) {
		this.inventory = inventory;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
}

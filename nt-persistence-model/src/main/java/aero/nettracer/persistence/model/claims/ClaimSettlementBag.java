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


	private long id;
	private String color;
	private String manufacturer;
	private String type;
	private ClaimSettlement claimsettlement;
	private int position;
	private List<SettlementBagInventory> inventory;


	@Id
	@GeneratedValue
	@Column(name = "bagId")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(length = 2)
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(length = 100)
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Column(length = 2)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@ManyToOne(targetEntity = ClaimSettlement.class)
	@JoinColumn(name = "claimSettlementId", nullable = false)
	public ClaimSettlement getClaimsettlement() {
		return claimsettlement;
	}

	public void setClaimsettlement(ClaimSettlement claimsettlement) {
		this.claimsettlement = claimsettlement;
	}

	@Basic
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@OneToMany(mappedBy = "claimSettlementBag", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@IndexColumn(name="position")
	@Fetch(FetchMode.SELECT)
	public List<SettlementBagInventory> getInventory() {
		return inventory;
	}

	public void setInventory(List<SettlementBagInventory> inventory) {
		this.inventory = inventory;
	}

}

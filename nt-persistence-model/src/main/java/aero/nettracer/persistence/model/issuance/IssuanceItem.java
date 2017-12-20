package aero.nettracer.persistence.model.issuance;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.text.DecimalFormat;
import java.util.Set;

@Entity
@Table(name="issuance_item")
public class IssuanceItem {

	private long id;
	private IssuanceCategory category;
	private String description;
	boolean active;
	private double cost;
	private Set<IssuanceItemQuantity> quantityItems;
	private Set<IssuanceItemInventory> inventoryItems;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="issuance_category_id")
	public IssuanceCategory getCategory() {
		return this.category;
	}

	public void setCategory(IssuanceCategory category) {
		this.category = category;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "active")
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Column(name = "cost")
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@OrderBy(value="station_id")
	@OneToMany(mappedBy="issuanceItem", cascade=CascadeType.ALL)
	public Set<IssuanceItemQuantity> getQuantityItems() {
		return quantityItems;
	}

	public void setQuantityItems(Set<IssuanceItemQuantity> quantityItems) {
		this.quantityItems = quantityItems;
	}

	@OrderBy(value="station_id")
	@OneToMany(mappedBy="issuanceItem", cascade=CascadeType.ALL)
	public Set<IssuanceItemInventory> getInventoryItems() {
		return inventoryItems;
	}

	public void setInventoryItems(Set<IssuanceItemInventory> inventoryItems) {
		this.inventoryItems = inventoryItems;
	}

	@Transient
	public String getDispCost() {
		DecimalFormat df = new DecimalFormat("#0.00");
		return df.format(getCost());
	}
	
	public void setDispCost(String dispCost) {
		this.cost = Double.parseDouble(dispCost);
	}
	
	public boolean isInventoryIssuanceItem() {
		return inventoryItems != null && !inventoryItems.isEmpty();
	}

	@Transient
	public String getInventoryIssuanceItemBarcode() {
		if (this.isInventoryIssuanceItem()) {
			return inventoryItems.toArray(new IssuanceItemInventory[0])[0].getBarcode();
		}
		return "";
	}
	
}

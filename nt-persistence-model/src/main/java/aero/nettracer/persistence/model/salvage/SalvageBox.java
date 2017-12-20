package aero.nettracer.persistence.model.salvage;

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
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "salvage_box")
public class SalvageBox {

	public static final int TYPE_DEFAULT = 0;
	public static final int TYPE_LOW_VALUE = 1;
	public static final int TYPE_HIGH_VALUE = 2;
	
	
	private int id;
	private String description;
	private int displayId;
	private int type; // valid values are: 0 - default, 1-low value, 2-high value
	private Salvage salvage;
	private Set<SalvageItem> salvageItems;
	
	@Id
	@GeneratedValue
	@Column(name="box_id")
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
	
	@Column(name="display_id", nullable=false)
	public int getDisplayId() {
		return this.displayId;
	}
	
	public void setDisplayId(int displayId) {
		this.displayId = displayId;
	}

	@Column(name="type")
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	@ManyToOne
	@JoinColumn(name = "salvage_id", nullable = false)
	public Salvage getSalvage() {
		return salvage;
	}
	
	public void setSalvage(Salvage salvage) {
		this.salvage = salvage;
	}

	@OneToMany(mappedBy = "box", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy(value = "item_id")
	public Set<SalvageItem> getSalvageItems() {
		return salvageItems;
	}
	
	public void setSalvageItems(Set<SalvageItem> salvageItems) {
		this.salvageItems = salvageItems;
	}

	@Transient
	public SalvageItem getSalvageItem(int i) {
		ArrayList<SalvageItem> itemList;
		if (getSalvageItems() != null && i < getSalvageItems().size()) {
			itemList = new ArrayList<SalvageItem>(getSalvageItems());
			return itemList.get(i);
		}
		return null;
		
	}

}

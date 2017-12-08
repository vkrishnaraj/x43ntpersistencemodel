package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "item_inventory")
public class TraceItem_Inventory implements Serializable {

	private long inventory_ID;
	private int categorytype_ID = 0;
	private String description = "";
	private TraceItem item;
	private String tempcat;
	
	private static ConcurrentHashMap<Integer, String> cachedCategoryMap = new ConcurrentHashMap<Integer, String>();

	//NTFIXME
	/*@Transient
	public String getCategoryKey() {
		String category = null;
		if (categorytype_ID != 0) {
			category = CategoryBMO.getCategory(categorytype_ID, null).getKey();
		}

		if (category == null) category = "";
		return category;
	}*/

	@Transient
	public ConcurrentHashMap<Integer, String> getCachedCategoryMap() {
		return cachedCategoryMap;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategorytype_ID() {
		return categorytype_ID;
	}

	public void setCategorytype_ID(int categorytype_id) {
		this.categorytype_ID = categorytype_id;
	}

	@Id
	@GeneratedValue
	public long getInventory_ID() {
		return inventory_ID;
	}

	public void setInventory_ID(long inventory_ID) {
		this.inventory_ID = inventory_ID;
	}

	@ManyToOne
	@JoinColumn(name = "item_ID")
	public TraceItem getItem() {
		return item;
	}

	public void setItem(TraceItem item) {
		this.item = item;
	}

	@Transient
	public String getTempcat() {
		return tempcat;
	}

	public void setTempcat(String tempcat) {
		this.tempcat = tempcat;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Inventory ID=" + this.getInventory_ID());
		sb.append(" Category type=" + this.getCategorytype_ID());
		//sb.append(" Item type=" + this.getOHD_itemtype_ID());
		sb.append(" Description=" + this.getDescription());
		return sb.toString();
	}
}
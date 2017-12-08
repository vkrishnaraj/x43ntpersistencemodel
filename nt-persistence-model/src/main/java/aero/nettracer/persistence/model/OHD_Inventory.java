package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "OHD_Inventory")
public class OHD_Inventory implements Serializable {

	private static final long serialVersionUID = 4475797198872929839L;
	private long OHD_Inventory_ID;
	private int OHD_categorytype_ID = 0;
	private String description = "";
	private OHD ohd;
	private static ConcurrentHashMap<Integer, String> cachedCategoryString = new ConcurrentHashMap<Integer, String>();

	//NTFIXME
	/*@Transient
	public String getCachedCategory() {
		Integer key = new Integer(OHD_categorytype_ID);
		if (OHD_categorytype_ID != 0) {
			if (cachedCategoryString.containsKey(key)) {
				return cachedCategoryString.get(key);
			} else {
				String category = getCategory();
				cachedCategoryString.put(key, category);
				return category;
			}
		}
		return "";
	}*/

	//NTFIXME
	/*@Transient
	public String getCategoryKey() {
		String category = null;
		if (OHD_categorytype_ID != 0) {
			category = CategoryBMO.getCategory(OHD_categorytype_ID, null).getKey();
		}

		if (category == null) category = "";
		return category;
	}*/

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getOHD_categorytype_ID() {
		return OHD_categorytype_ID;
	}

	public void setOHD_categorytype_ID(int ohd_categorytype_id) {
		OHD_categorytype_ID = ohd_categorytype_id;
	}

	@Id
	@GeneratedValue
	public long getOHD_Inventory_ID() {
		return OHD_Inventory_ID;
	}

	public void setOHD_Inventory_ID(long inventory_ID) {
		OHD_Inventory_ID = inventory_ID;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "OHD_ID")
	public OHD getOhd() {
		return ohd;
	}

	public void setOhd(OHD ohd) {
		this.ohd = ohd;
	}
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Inventory ID=" + this.getOHD_Inventory_ID());
		sb.append(" Category type=" + this.getOHD_categorytype_ID());
		//sb.append(" Item type=" + this.getOHD_itemtype_ID());
		sb.append(" Description=" + this.getDescription());
		return sb.toString();
	}
}
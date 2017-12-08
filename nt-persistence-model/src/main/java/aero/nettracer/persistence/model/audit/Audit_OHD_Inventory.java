package aero.nettracer.persistence.model.audit;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Audit_OHD_Inventory")
public class Audit_OHD_Inventory implements Serializable {

	private int id;
	private long OHD_Inventory_ID;
	private int OHD_categorytype_ID = 0;
	private String description = "";
	
	private Audit_OHD ohd;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "audit_ohd_id")
	public Audit_OHD getOhd() {
		return ohd;
	}

	public void setOhd(Audit_OHD ohd) {
		this.ohd = ohd;
	}

	//NTFIXME
	/*@Transient
	public String getCategory() {
		String category = null;
		if (OHD_categorytype_ID != 0) {
			category = CategoryBMO.getCategory("" + OHD_categorytype_ID, "en").getDescription();
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

	public long getOHD_Inventory_ID() {
		return OHD_Inventory_ID;
	}

	public void setOHD_Inventory_ID(long inventory_ID) {
		OHD_Inventory_ID = inventory_ID;
	}

	//NTFIXME
	/*public boolean equals(Object obj) {
		Audit_OHD_Inventory aoi = (Audit_OHD_Inventory) obj;
		boolean ret = true;

		if (AuditOHDUtils.notEqualObjects(aoi.getCategory(), this.getCategory())
				|| AuditOHDUtils.notEqualObjects(aoi.getDescription(), this.getDescription())) {
			ret = false;
		}
		return ret;
	}*/

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Inventory ID=" + this.getOHD_Inventory_ID());
		sb.append(" Category type=" + this.getOHD_categorytype_ID());
		//sb.append(" Item type=" + this.getOHD_itemtype_ID());
		sb.append(" Description=" + this.getDescription());
		return sb.toString();
	}
}
package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Incident_Assoc")
public class Incident_Assoc implements Serializable {
	private int ID;
	private String assoc_ID;
	private String incident_ID;
	private int itemtype_ID;

	public String getAssoc_ID() {
		return assoc_ID;
	}

	public void setAssoc_ID(String assoc_ID) {
		this.assoc_ID = assoc_ID;
	}

	@Id
	@GeneratedValue
	public int getID() {
		return ID;
	}

	public void setID(int id) {
		ID = id;
	}

	public String getIncident_ID() {
		return incident_ID;
	}

	public void setIncident_ID(String incident_ID) {
		this.incident_ID = incident_ID;
	}

	public int getItemtype_ID() {
		return itemtype_ID;
	}

	public void setItemtype_ID(int itemtype_ID) {
		this.itemtype_ID = itemtype_ID;
	}
	
	@Transient
	public ItemType getItemTypeObject(){
		ItemType itemType = new ItemType();
		itemType.setItemType_ID(itemtype_ID);
		return itemType;
	}

	public void setItemTypeObject(ItemType itemType){
		itemtype_ID = itemType.getItemType_ID();
	}
}
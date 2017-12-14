package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "incident_assoc")
public class Incident_Assoc {

	private int id;
	private String assoc_ID;
	private String incident_ID;
	private int itemtype_ID;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "assoc_id")
	public String getAssoc_ID() {
		return assoc_ID;
	}

	public void setAssoc_ID(String assoc_ID) {
		this.assoc_ID = assoc_ID;
	}

	@Column(name = "incident_id")
	public String getIncident_ID() {
		return incident_ID;
	}

	public void setIncident_ID(String incident_ID) {
		this.incident_ID = incident_ID;
	}

	@Column(name = "itemtype_ID")
	public int getItemtype_ID() {
		return itemtype_ID;
	}

	public void setItemtype_ID(int itemtype_ID) {
		this.itemtype_ID = itemtype_ID;
	}
	
	@Transient
	public ItemType getItemTypeObject(){
		ItemType itemType = new ItemType();
		itemType.setId(itemtype_ID);
		return itemType;
	}

	public void setItemTypeObject(ItemType itemType){
		itemtype_ID = itemType.getId();
	}
}
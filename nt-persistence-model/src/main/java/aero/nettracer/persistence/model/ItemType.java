package aero.nettracer.persistence.model;

import aero.nettracer.persistence.model.i8n.LocaleBasedObject;
import aero.nettracer.persistence.util.ItemTypeDescription;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "itemtype")
public class ItemType extends LocaleBasedObject {

	private int id;
	private String description;
	private String MSG_KEY = "ITEMTYPE_";

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Transient
	public String getKey() {
		return MSG_KEY + id;
	}
	
	public String getKey(int id) {
		return MSG_KEY + id;
	}

	@Transient
	public String getTypeItemTypeDescription(){
		return ItemTypeDescription.getNameFromKey(getId());
	}

	public void setTypeItemTypeDescription(String type){
		id = ItemTypeDescription.getKeyFromName(type);
	}
	
}
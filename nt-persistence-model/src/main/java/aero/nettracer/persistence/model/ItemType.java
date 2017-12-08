package aero.nettracer.persistence.model;

import java.io.Serializable;

import aero.nettracer.persistence.model.i8n.LocaleBasedObject;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "ItemType")
public class ItemType extends LocaleBasedObject implements Serializable {
	
	public enum TypeDescription{
		LOST(1,"LOST_DELAY"),
		MISSING_ARTICLES(2,"MISSING_ARTICLES"),
		DAMAGE(3,"DAMAGE"),
		UNKNOWN(4,"UNKNOWN");
		
		private final int key;
		private final String name;
		
		TypeDescription(int key, String name){
			this.key = key;
			this.name = name;
		}

		public int getKey() {
			return key;
		}

		public String getName() {
			return name;
		}
		
		public static String getNameFromKey(int key){
			for(TypeDescription d: TypeDescription.values()){
				if(d.getKey() == key){
					return d.getName();
				}
			}
			return null;
		}
		
		public static int getKeyFromName(String name){
			for(TypeDescription d: TypeDescription.values()){
				if(d.getName().equalsIgnoreCase(name)){
					return d.getKey();
				}
			}
			return UNKNOWN.getKey();
		}
	}
	
	private int ItemType_ID;
	private static String MSG_KEY = "ITEMTYPE_";
	private String description;
	private String typeItemTypeDescription;

	@Id
	@GeneratedValue
	public int getItemType_ID() {
		return ItemType_ID;
	}

	public void setItemType_ID(int itemType_ID) {
		ItemType_ID = itemType_ID;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Transient
	public String getKey() {
		return MSG_KEY + ItemType_ID;
	}
	
	public static String getKey(int id) {
		return MSG_KEY + id;
	}

	@Transient
	public String getTypeItemTypeDescription(){
		return ItemType.TypeDescription.getNameFromKey(getItemType_ID());
	}

	public void setTypeItemTypeDescription(String type){
		ItemType_ID = ItemType.TypeDescription.getKeyFromName(type);
	}
	
}
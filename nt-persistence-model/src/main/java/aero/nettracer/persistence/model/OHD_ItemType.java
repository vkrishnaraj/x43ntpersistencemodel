package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "OHD_ItemType")
public class OHD_ItemType implements Serializable {
	private int OHD_ItemType_ID;
	private String itemtype;
	private String locale;

	public String getItemtype() {
		return itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	@Id
	@GeneratedValue
	public int getOHD_ItemType_ID() {
		return OHD_ItemType_ID;
	}

	public void setOHD_ItemType_ID(int itemType_ID) {
		OHD_ItemType_ID = itemType_ID;
	}
}
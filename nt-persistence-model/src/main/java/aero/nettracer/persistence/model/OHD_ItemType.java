package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ohd_itemtype")
public class OHD_ItemType {

	private int id;
	private String itemtype;
	private String locale;

	@Id
	@GeneratedValue
	@Column(name = "ohd_itemtype_id")
	public int getId() {
		return id;
	}

	public void setId(int itemType_ID) {
		id = itemType_ID;
	}

	@Column(name = "itemtype")
	public String getItemtype() {
		return itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	@Column(name = "locale")
	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
}
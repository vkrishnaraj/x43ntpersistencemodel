/*
 * Created on Jul 13, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

import aero.nettracer.commons.utils.CommonsConstants;
import aero.nettracer.commons.utils.CommonsUtils;
import aero.nettracer.commons.utils.GenericDateUtils;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name="item_inventory")
public class Item_Inventory implements Serializable {
	
	private static final long serialVersionUID = 2908666209811401337L;

	private long inventory_ID;
	
	private int categorytype_ID = 0;
	
	private String description = "";
	
	private Item item;

	private String tempcat;	// this stores category name for matching

	private String _DATEFORMAT; // current login agent's date format

	private TimeZone _TIMEZONE;

	private Date enteredDate;

	private Date purchaseDate;

	private double invItemCost;

	private String invItemCurrency;

	private int itemStatusId;

	private static ConcurrentHashMap<Integer, String> cachedCategoryMap = new ConcurrentHashMap<Integer, String>();

	//NTFIXME
	/*@Transient
	public String getCachedCategory() {
		Integer key = new Integer(categorytype_ID);
		if (categorytype_ID != 0) {
			if (cachedCategoryMap.containsKey(key)) {
				return cachedCategoryMap.get(key);
			} else {
				String category = getCategory();
				cachedCategoryMap.put(key, category);
				return category;
			}
		}
		return "";
	}*/

	//NTFIXME
	/*@Transient
	public String getCategory() {
		String category = null;
		if (categorytype_ID != 0) {
			category = CategoryBMO.getCategory(categorytype_ID, "en").getDescription();
		}

		if (category == null) category = "";
		return category;

	}
*/
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

	@Column(length = 255)
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


	@Fetch(FetchMode.SELECT)
	@ManyToOne
	@JoinColumn(name = "item_ID", nullable = false)
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Transient
	public String getTempcat() {
		return tempcat;
	}

	public void setTempcat(String tempcat) {
		this.tempcat = tempcat;
	}
	
	@Temporal(value = TemporalType.DATE)
	public Date getEnteredDate() {
		return enteredDate;
	}

	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}


	@Temporal(value = TemporalType.DATE)
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Transient
	public String get_DATEFORMAT() {
		return _DATEFORMAT;
	}

	public void set_DATEFORMAT(String _DATEFORMAT) {
		this._DATEFORMAT = _DATEFORMAT;
	}

	@Transient
	public TimeZone get_TIMEZONE() {
		return _TIMEZONE;
	}

	public void set_TIMEZONE(TimeZone _TIMEZONE) {
		this._TIMEZONE = _TIMEZONE;
	}

	@Transient
	public String getDispEnteredDate() {
		return GenericDateUtils.formatDate(getEnteredDate(), _DATEFORMAT, null, null);
	}
	
	@Transient
	public String getDispPurchaseDate() {
		return GenericDateUtils.formatDate(getPurchaseDate(), _DATEFORMAT, null, null);
	}

	public void setDispPurchaseDate(String date) {
		this.purchaseDate = GenericDateUtils.convertToDate(date, _DATEFORMAT, null, _TIMEZONE);
	}

	public double getInvItemCost() {
		return invItemCost;
	}

	public void setInvItemCost(double invItemCost) {
		this.invItemCost = invItemCost;
	}
	
	@Transient
	public String getDispInvItemCost() {
		if (getInvItemCost() != 0)
			return CommonsConstants.DECIMALFORMAT.format(getInvItemCost());
		else
			return "";
	}

	public void setDispInvItemCost(String s) {
		setInvItemCost(CommonsUtils.convertToDouble(s));
	}


	@Column(length = 3)
	public String getInvItemCurrency() {
		return invItemCurrency;
	}

	public void setInvItemCurrency(String invItemCurrency) {
		this.invItemCurrency = invItemCurrency;
	}

	public int getItemStatusId() {
		return itemStatusId;
	}

	public void setItemStatusId(int itemStatusId) {
		this.itemStatusId = itemStatusId;
	}
	
	@Transient
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Inventory ID=" + this.getInventory_ID());
		sb.append(" Category type=" + this.getCategorytype_ID());
		//sb.append(" Item type=" + this.getOHD_itemtype_ID());
		sb.append(" Description=" + this.getDescription());
		return sb.toString();
	}
}
/*
 * Created on Jul 13, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model.audit;

import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;

import aero.nettracer.commons.utils.CommonsConstants;
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
@Table(name="audit_item_inventory")
public class Audit_Item_Inventory implements Serializable {
	
	private static final long serialVersionUID = 6763744120832196547L;
	
	private int id;
	
	private long inventory_ID;
	private int categorytype_ID = 0;
	//private int OHD_itemtype_ID;
	
	private String description = "";
	
	private Audit_Item audit_item;

	private String _DATEFORMAT; // current login agent's date format

	private TimeZone _TIMEZONE;

	private Date enteredDate;

	private Date purchaseDate;

	private double invItemCost;

	private String invItemCurrency;

	private int itemStatusId;

	//NTFIXME
	/*@Transient
	public String getCategory() {
		String category = null;
		if (categorytype_ID != 0) {
			category = CategoryBMO.getCategory("" + categorytype_ID, "en").getDescription();
		}

		if (category == null) category = "";
		return category;

	}*/

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


	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Fetch(FetchMode.SELECT)
	@ManyToOne
	@JoinColumn(name = "audit_item_ID")
	public Audit_Item getAudit_item() {
		return audit_item;
	}

	public void setAudit_item(Audit_Item audit_item) {
		this.audit_item = audit_item;
	}

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

	
	public long getInventory_ID() {
		return inventory_ID;
	}

	
	public void setInventory_ID(long inventory_ID) {
		this.inventory_ID = inventory_ID;
	}

	@Temporal(value = TemporalType.DATE)
	public Date getEnteredDate() {
		return enteredDate;
	}

	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}
	
	@Transient
	public String getDispEnteredDate() {
		return GenericDateUtils.formatDate(getEnteredDate(), _DATEFORMAT, null, _TIMEZONE);
	}

	@Temporal(value = TemporalType.DATE)
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	@Transient
	public String getDispPurchaseDate() {
		return GenericDateUtils.formatDate(getPurchaseDate(), _DATEFORMAT, null, _TIMEZONE);
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
	

	@Column(length = 255)
	public String getInvItemCurrency() {
		return invItemCurrency;
	}

	public void setInvItemCurrency(String invItemCurrency) {
		this.invItemCurrency = invItemCurrency;
	}

	//NTFIXME
	/*@Transient
	public String getDispInvItemCurrency() {
		return getInvItemCurrency() != null ? CurrencyUtils.getCurrency(getInvItemCurrency()).getDescription() : "";
	}*/
	
	
	public int getItemStatusId() {
		return itemStatusId;
	}

	public void setItemStatusId(int itemStatusId) {
		this.itemStatusId = itemStatusId;
	}

	//NTFIXME
	/*@Transient
	public String getDispItemStatus() {
		return TracerUtils.getText(Status.getKey(getItemStatusId()), (String) null);
	}*/

	@Transient
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Inventory ID=" + this.getInventory_ID());
		sb.append(" Category type=" + this.getCategorytype_ID());
		//sb.append(" Item type=" + this.getOHD_itemtype_ID());
		sb.append(" Description=" + this.getDescription());
		return sb.toString();
	}

	//NTFIXME
	/*@Transient
	public boolean equals(Object obj) {
		Audit_Item_Inventory aoi = (Audit_Item_Inventory) obj;
		boolean ret = true;

		if (AuditOHDUtils.notEqualObjects(aoi.getCategory(), this.getCategory())
				|| AuditOHDUtils.notEqualObjects(aoi.getDescription(), this.getDescription())) {
			ret = false;
		}
		return ret;
	}*/

}
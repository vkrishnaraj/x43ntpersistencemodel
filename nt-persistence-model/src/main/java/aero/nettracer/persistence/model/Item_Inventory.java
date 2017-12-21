package aero.nettracer.persistence.model;

import aero.nettracer.commons.utils.CommonsConstants;
import aero.nettracer.commons.utils.CommonsUtils;

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
import java.util.Date;

@Entity
@Table(name="item_inventory")
public class Item_Inventory {
	
	private long id;
	private Item item;
	private int categorytype_ID = 0;
	private String description = "";
	private Date enteredDate;
	private Date purchaseDate;
	private double invItemCost;
	private String invItemCurrency;
	private int itemStatusId;
	private String tempcat;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "item_id", nullable = false)
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Column(name = "categorytype_id")
	public int getCategorytype_ID() {
		return categorytype_ID;
	}

	public void setCategorytype_ID(int categorytype_id) {
		this.categorytype_ID = categorytype_id;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(value = TemporalType.DATE)
	@Column(name = "entereddate")
	public Date getEnteredDate() {
		return enteredDate;
	}

	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}

	@Temporal(value = TemporalType.DATE)
	@Column(name = "purchasedate")
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Column(name = "invitemcost")
	public double getInvItemCost() {
		return invItemCost;
	}

	public void setInvItemCost(double invItemCost) {
		this.invItemCost = invItemCost;
	}

	@Column(name = "invitemcurrency")
	public String getInvItemCurrency() {
		return invItemCurrency;
	}

	public void setInvItemCurrency(String invItemCurrency) {
		this.invItemCurrency = invItemCurrency;
	}

	@Column(name = "itemstatusid")
	public int getItemStatusId() {
		return itemStatusId;
	}

	public void setItemStatusId(int itemStatusId) {
		this.itemStatusId = itemStatusId;
	}

	@Transient
	public String getTempcat() {
		return tempcat;
	}

	public void setTempcat(String tempcat) {
		this.tempcat = tempcat;
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

	@Transient
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Inventory ID=" + this.getId());
		sb.append(" Category type=" + this.getCategorytype_ID());
		//sb.append(" Item type=" + this.getOHD_itemtype_ID());
		sb.append(" Description=" + this.getDescription());
		return sb.toString();
	}
}
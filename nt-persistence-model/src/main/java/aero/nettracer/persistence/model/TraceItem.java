package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import aero.nettracer.commons.utils.CommonsUtils;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Item")
public class TraceItem implements Serializable {
	private int Item_ID;
	private int bagnumber;
	private int itemtype_ID;
	private Status status;
	private String claimchecknum;
	private String color;
	private String bagtype;
	private int xdescelement_ID_1;
	private int xdescelement_ID_2;
	private int xdescelement_ID_3;
	private int manufacturer_ID;
	private String manufacturer_other;
	private String fnameonbag;
	private String mnameonbag;
	private String lnameonbag;
	private String externaldesc;
	private String arrivedonflightnum;
	private String arrivedonairline_ID;
	private Date arrivedondate;
	private Date purchaseDate;
	private TraceIncident incident;
	private Set<TraceItem_Inventory> inventory;
	private List inventorylist;
	private String OHD_ID;
	private String tempOHD_ID;
	private int is_in_station;
	private double bag_weight;
	private String bag_weight_unit;

	public double getBag_weight() {
		return bag_weight;
	}

	public void setBag_weight(double bag_weight) {
		this.bag_weight = roundToTwoDecimals(bag_weight);
	}

	public String getBag_weight_unit() {
		return bag_weight_unit;
	}

	public void setBag_weight_unit(String bag_weight_unit) {
		this.bag_weight_unit = bag_weight_unit;
	}

	@Transient
	public String getDispstatus() {
		String ret = "";

		if (status != null)
			ret = status.getKey();

		return ret;
	}

	//NTFIXME
	/*@Transient
	public String getManufacturer() {
		String ret = "";

		if (this.getManufacturer_ID() > 0) {
			if (this.getManufacturer_ID() == CommonsConstants.MANUFACTURER_OTHER_ID) {
				if (this.getManufacturer_other() != null
						&& this.getManufacturer_other().length() > 0) {
					ret = this.getManufacturer_other();
				}
			} else {
				Manufacturer manuf = TracerUtils.getManufacturer(this
						.getManufacturer_ID());
				if (manuf != null) {
					ret = manuf.getDescription();
				}
			}
		}

		return ret;
	}*/

	@ManyToOne
	@JoinColumn(name = "status_ID")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getOHD_ID() {
		return OHD_ID;
	}

	public void setOHD_ID(String ohd_id) {
		OHD_ID = ohd_id;
	}

	@Transient
	public String getTempOHD_ID() {
		return tempOHD_ID;
	}

	public void setTempOHD_ID(String tempOHD_ID) {
		this.tempOHD_ID = tempOHD_ID;
	}

	@Transient
	public int getIs_in_station() {
		return is_in_station;
	}

	public void setIs_in_station(int is_in_station) {
		this.is_in_station = is_in_station;
	}

	public int getItemtype_ID() {
		return itemtype_ID;
	}

	public void setItemtype_ID(int itemtype_ID) {
		this.itemtype_ID = itemtype_ID;
	}

	public void setExternaldesc(String externaldesc) {
		this.externaldesc = externaldesc;
	}

	public String getExternaldesc() {
		return externaldesc;
	}

	public int getBagnumber() {
		return bagnumber;
	}

	public void setBagnumber(int bagnumber) {
		this.bagnumber = bagnumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Id
	@GeneratedValue
	public int getItem_ID() {
		return Item_ID;
	}

	public void setItem_ID(int item_ID) {
		Item_ID = item_ID;
	}

	@OneToMany(mappedBy = "item")
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "inventory_ID")
	public Set<TraceItem_Inventory> getInventory() {
		if (inventorylist == null)
			return null;
		return new LinkedHashSet(inventorylist);
	}

	public void setInventory(Set<TraceItem_Inventory> inventory) {
		this.inventory = inventory;
		if (inventory != null)
			this.inventorylist = new ArrayList(inventory);
	}

	@Transient
	public List getInventorylist() {
		if (inventorylist == null)
			inventorylist = new ArrayList();
		return inventorylist;
	}

	public void setInventorylist(List inventorylist) {
		this.inventorylist = inventorylist;
	}

	public String getBagtype() {
		return bagtype;
	}

	public void setBagtype(String bagtype) {
		this.bagtype = bagtype;
	}

	public String getArrivedonairline_ID() {
		return arrivedonairline_ID;
	}

	public void setArrivedonairline_ID(String arrivedonairline_ID) {
		this.arrivedonairline_ID = arrivedonairline_ID;
	}

	public Date getArrivedondate() {
		return arrivedondate;
	}

	public void setArrivedondate(Date arrivedondate) {
		this.arrivedondate = arrivedondate;
	}

	public String getArrivedonflightnum() {
		return arrivedonflightnum;
	}

	public void setArrivedonflightnum(String arrivedonflightnum) {
		this.arrivedonflightnum = arrivedonflightnum;
	}

	public String getClaimchecknum() {
		return claimchecknum;
	}

	public void setClaimchecknum(String claimchecknum) {
		if (claimchecknum != null)
			claimchecknum = CommonsUtils.removeSpaces(claimchecknum);
		this.claimchecknum = claimchecknum;
	}

	public String getFnameonbag() {
		return fnameonbag;
	}

	public void setFnameonbag(String fnameonbag) {
		this.fnameonbag = fnameonbag;
	}

	public String getLnameonbag() {
		return lnameonbag;
	}

	public void setLnameonbag(String lnameonbag) {
		this.lnameonbag = lnameonbag;
	}

	public String getMnameonbag() {
		return mnameonbag;
	}

	public void setMnameonbag(String mnameonbag) {
		this.mnameonbag = mnameonbag;
	}

	public int getManufacturer_ID() {
		return manufacturer_ID;
	}

	public void setManufacturer_ID(int manufacturer_ID) {
		this.manufacturer_ID = manufacturer_ID;
	}

	public String getManufacturer_other() {
		return manufacturer_other;
	}

	public void setManufacturer_other(String manufacturer_other) {
		this.manufacturer_other = manufacturer_other;
	}

	public int getXdescelement_ID_1() {
		return xdescelement_ID_1;
	}

	public void setXdescelement_ID_1(int xdescelement_ID_1) {
		this.xdescelement_ID_1 = xdescelement_ID_1;
	}

	public int getXdescelement_ID_2() {
		return xdescelement_ID_2;
	}

	public void setXdescelement_ID_2(int xdescelement_ID_2) {
		this.xdescelement_ID_2 = xdescelement_ID_2;
	}

	public int getXdescelement_ID_3() {
		return xdescelement_ID_3;
	}

	public void setXdescelement_ID_3(int xdescelement_ID_3) {
		this.xdescelement_ID_3 = xdescelement_ID_3;
	}

	@Column(name = "purchase_date")
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	//NTFIXME
	/*@Transient
	public String getManuname() {
		if (manufacturer_ID <= 0)
			return "";
		Manufacturer manu = TracerUtils.getManufacturer(manufacturer_ID);
		return manu.getDescription();
	}*/

	//NTFIXME
	/*@Transient
	public String getXdescelement1() {
		if (xdescelement_ID_1 <= 0)
			return "";
		XDescElement xd = TracerUtils.getXdescelement(xdescelement_ID_1);
		return xd.getDescription();
	}*/

	//NTFIXME
	/*@Transient
	public String getXdescelement2() {
		if (xdescelement_ID_2 <= 0)
			return "";
		XDescElement xd = TracerUtils.getXdescelement(xdescelement_ID_2);
		return xd.getDescription();
	}*/

	//NTFIXME
	@Transient
	/*public String getXdescelement3() {
		if (xdescelement_ID_3 <= 0)
			return "";
		XDescElement xd = TracerUtils.getXdescelement(xdescelement_ID_3);
		return xd.getDescription();
	}*/

	//NTFIXME
	/*@Transient
	public String getX1() {
		if (xdescelement_ID_1 <= 0)
			return "";
		XDescElement xd = TracerUtils.getXdescelement(xdescelement_ID_1);
		return xd.getCode();
	}*/

	//NTFIXME
	/*@Transient
	public String getX2() {
		if (xdescelement_ID_2 <= 0)
			return "";
		XDescElement xd = TracerUtils.getXdescelement(xdescelement_ID_2);
		return xd.getCode();
	}*/

	//NTFIXME
	/*@Transient
	public String getX3() {
		if (xdescelement_ID_3 <= 0)
			return "";
		XDescElement xd = TracerUtils.getXdescelement(xdescelement_ID_3);
		return xd.getCode();
	}*/

	//NTFIXME
	/*@Transient
	public String getXdescelement1Key() {
		if (xdescelement_ID_1 <= 0)
			return "";
		XDescElement xd = TracerUtils.getXdescelement(xdescelement_ID_1);
		return xd.getKey();
	}*/

	//NTFIXME
	/*@Transient
	public String getXdescelement2Key() {
		if (xdescelement_ID_2 <= 0)
			return "";
		XDescElement xd = TracerUtils.getXdescelement(xdescelement_ID_2);
		return xd.getKey();
	}*/

	//NTFIXME
	/*@Transient
	public String getXdescelement3Key() {
		if (xdescelement_ID_3 <= 0)
			return "";
		XDescElement xd = TracerUtils.getXdescelement(xdescelement_ID_3);
		return xd.getKey();
	}*/

	private double roundToTwoDecimals(double d) {
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		return Double.valueOf(twoDForm.format(d));
	}

	@ManyToOne
	@JoinColumn(name = "incident_ID")
	public TraceIncident getIncident() {
		return incident;
	}

	public void setIncident(TraceIncident incident) {
		this.incident = incident;
	}

}
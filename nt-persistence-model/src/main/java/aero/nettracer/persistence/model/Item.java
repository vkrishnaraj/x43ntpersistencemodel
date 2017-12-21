/*
 * Created on Jul 13, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model;


import aero.nettracer.commons.utils.CommonsConstants;
import aero.nettracer.commons.utils.CommonsUtils;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.OrderBy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="item")
public class Item {

	private int id;
	private Status status;
	private int bagnumber;
	private Incident incident;
	private int itemtype_ID;
	private String OHD_ID;
	private String claimchecknum;
	private String color;
	private String bagtype;
	private int xdescelement_ID_1;
	private int xdescelement_ID_2;
	private int xdescelement_ID_3;
	private int manufacturer_ID;
	private String manufacturer_other;
	private int lvlofdamage;
	private String damage;
	private Resolution resolution;
	private String resolutiondesc;
	private double cost;
	private String drafts;
	private String currency_ID;
	private String fnameonbag;
	private String mnameonbag;
	private String lnameonbag;
	private String arrivedonairline_ID;
	private Date arrivedondate;
	private String arrivedonflightnum;
	private int wt_bag_selected;
	private Date purchaseDate;
	private double bag_weight;
	private String bag_weight_unit;
	private int replacementBagIssued;
	private String claimchecknum_leading;
	private String claimchecknum_ticketingcode;
	private String claimchecknum_carriercode;
	private String claimchecknum_bagnumber;
	private int childRestraint;
	private String externaldesc;
	private String posId;
	private String expediteTagNum;
	private int specialCondition;
	private boolean noAddFees;
	private int other;
	private int assistDeviceType;
	private String assistDeviceCheck;
	private int lossCode;
	private Station faultStation;
	private Set<Item_Photo> photos;
	private Set<Item_Inventory> inventory;
	private Set<Item_BDO> item_bdo;
	private boolean damageEditable;
	private BDO bdo;
	private List<Item_Inventory> inventorylist;
	private String tempOHD_ID;
	private int is_in_station;
	private List<Item_Photo> photolist;
	private String locale;
	private boolean isItemOrBdoCanceled;
	private boolean bdoChosen = false;
	private List<DropDownConfiguration> damageDescList = Collections.emptyList();
	private String damageDescSelectedVal;

	public Item() {
	}

	public Item(int itemtype) {
		this.itemtype_ID = itemtype;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="status_id" )
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getBagnumber() {
		return bagnumber;
	}

	public void setBagnumber(int bagnumber) {
		this.bagnumber = bagnumber;
	}

	@ManyToOne
	@JoinColumn(name="incident_id", nullable = false)
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	@Column(name = "itemtype_id")
	public int getItemtype_ID() {
		return itemtype_ID;
	}

	public void setItemtype_ID(int itemtype_ID) {
		this.itemtype_ID = itemtype_ID;
	}

	@Column(name = "ohd_id")
	public String getOHD_ID() {
		return OHD_ID;
	}

	public void setOHD_ID(String ohd_id) {
		OHD_ID = ohd_id;
	}

	@Column(name = "claimchecknum")
	public String getClaimchecknum() {
		return claimchecknum;
	}

	public void setClaimchecknum(String claimchecknum) {
		if (claimchecknum != null)
			claimchecknum = CommonsUtils.removeSpaces(claimchecknum);
		this.claimchecknum = claimchecknum;
	}

	@Column(name = "color")
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "bagtype")
	public String getBagtype() {
		return bagtype;
	}

	public void setBagtype(String bagtype) {
		this.bagtype = bagtype;
	}

	@Column(name = "xdescelement_id_1")
	public int getXdescelement_ID_1() {
		return xdescelement_ID_1;
	}

	public void setXdescelement_ID_1(int xdescelement_ID_1) {
		this.xdescelement_ID_1 = xdescelement_ID_1;
	}

	@Column(name = "xdescelement_id_2")
	public int getXdescelement_ID_2() {
		return xdescelement_ID_2;
	}

	public void setXdescelement_ID_2(int xdescelement_ID_2) {
		this.xdescelement_ID_2 = xdescelement_ID_2;
	}

	@Column(name = "xdescelement_id_3")
	public int getXdescelement_ID_3() {
		return xdescelement_ID_3;
	}

	public void setXdescelement_ID_3(int xdescelement_ID_3) {
		this.xdescelement_ID_3 = xdescelement_ID_3;
	}

	@Column(name = "manufacturer_id")
	public int getManufacturer_ID() {
		return manufacturer_ID;
	}

	public void setManufacturer_ID(int manufacturer_ID) {
		this.manufacturer_ID = manufacturer_ID;
	}

	@Column(name = "manufacturer_other")
	public String getManufacturer_other() {
		return manufacturer_other;
	}

	public void setManufacturer_other(String manufacturer_other) {
		this.manufacturer_other = manufacturer_other;
	}

	@Column(name = "lvlofdamage")
	public int getLvlofdamage() {
		return lvlofdamage;
	}

	public void setLvlofdamage(int lvlofdamage) {
		this.lvlofdamage = lvlofdamage;
	}

	@Column(name = "damage")
	public String getDamage() {
		return damage;
	}

	public void setDamage(String damage) {
		this.damage = damage;
	}

	@ManyToOne
	@JoinColumn(name="resolution_id")
	public Resolution getResolution() {
		return resolution;
	}

	public void setResolution(Resolution resolution) {
		this.resolution = resolution;
	}

	@Column(name = "resolutiondesc")
	public String getResolutiondesc() {
		return resolutiondesc;
	}

	public void setResolutiondesc(String resolutiondesc) {
		this.resolutiondesc = resolutiondesc;
	}

	@Column(name = "cost")
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Column(name = "drafts")
	public String getDrafts() {
		return drafts;
	}

	public void setDrafts(String drafts) {
		this.drafts = drafts;
	}

	@Column(name = "currency_id")
	public String getCurrency_ID() {
		return currency_ID;
	}

	public void setCurrency_ID(String currency_ID) {
		this.currency_ID = currency_ID;
	}

	@Column(name = "fnameonbag")
	public String getFnameonbag() {
		return fnameonbag;
	}

	public void setFnameonbag(String fnameonbag) {
		this.fnameonbag = fnameonbag;
	}

	@Column(name = "mnameonbag")
	public String getMnameonbag() {
		return mnameonbag;
	}

	public void setMnameonbag(String mnameonbag) {
		this.mnameonbag = mnameonbag;
	}

	@Column(name = "lnameonbag")
	public String getLnameonbag() {
		return lnameonbag;
	}

	public void setLnameonbag(String lnameonbag) {
		this.lnameonbag = lnameonbag;
	}

	@Column(name = "arrivedonairline_id")
	public String getArrivedonairline_ID() {
		return arrivedonairline_ID;
	}

	public void setArrivedonairline_ID(String arrivedonairline_ID) {
		this.arrivedonairline_ID = arrivedonairline_ID;
	}

	@Column(name = "arrivedondate")
	@Temporal(value = TemporalType.DATE)
	public Date getArrivedondate() {
		return arrivedondate;
	}

	public void setArrivedondate(Date arrivedondate) {
		this.arrivedondate = arrivedondate;
	}

	@Column(name = "arrivedonflightnum")
	public String getArrivedonflightnum() {
		return arrivedonflightnum;
	}

	public void setArrivedonflightnum(String arrivedonflightnum) {
		this.arrivedonflightnum = arrivedonflightnum;
	}

	@Column(name = "wt_bag_selected")
	public int getWt_bag_selected() {
		return wt_bag_selected;
	}

	public void setWt_bag_selected(int wt_bag_selected) {
		this.wt_bag_selected = wt_bag_selected;
	}

	@Column(name="purchase_date")
	@Temporal(value = TemporalType.DATE)
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Column(name = "bag_weight")
	public double getBag_weight() {
		return bag_weight;
	}

	public void setBag_weight(double bag_weight) {
		this.bag_weight = roundToTwoDecimals(bag_weight);
	}

	@Column(name = "bag_weight_unit")
	public String getBag_weight_unit() {
		return bag_weight_unit;
	}

	public void setBag_weight_unit(String bag_weight_unit) {
		this.bag_weight_unit = bag_weight_unit;
	}

	@Column(name = "replacementbagissued")
	public int getReplacementBagIssued() {
		return replacementBagIssued;
	}

	public void setReplacementBagIssued(int replacementBagIssued) {
		this.replacementBagIssued = replacementBagIssued;
	}

	@Column(name = "claimchecknum_leading")
	public String getClaimchecknum_leading() {
		return claimchecknum_leading;
	}

	public void setClaimchecknum_leading(String claimchecknum_leading) {
		this.claimchecknum_leading = claimchecknum_leading;
	}

	@Column(name = "claimchecknum_ticketingcode")
	public String getClaimchecknum_ticketingcode() {
		return claimchecknum_ticketingcode;
	}

	public void setClaimchecknum_ticketingcode(String claimchecknum_ticketingcode) {
		this.claimchecknum_ticketingcode = claimchecknum_ticketingcode;
	}

	@Column(name = "claimchecknum_carriercode")
	public String getClaimchecknum_carriercode() {
		return claimchecknum_carriercode;
	}

	public void setClaimchecknum_carriercode(String claimchecknum_carriercode) {
		this.claimchecknum_carriercode = claimchecknum_carriercode;
	}

	@Column(name = "claimchecknum_bagnumber")
	public String getClaimchecknum_bagnumber() {
		return claimchecknum_bagnumber;
	}

	public void setClaimchecknum_bagnumber(String claimchecknum_bagnumber) {
		this.claimchecknum_bagnumber = claimchecknum_bagnumber;
	}

	@Column(name ="childrestraint")
	public int getChildRestraint() {
		return childRestraint;
	}

	public void setChildRestraint(int childRestraint) {
		this.childRestraint = childRestraint;
	}

	@Column(name = "externaldesc")
	public String getExternaldesc() {
		return externaldesc;
	}

	public void setExternaldesc(String externaldesc) {
		this.externaldesc = externaldesc;
	}

	@Column(name = "posid")
	public String getPosId() {
		return posId;
	}

	public void setPosId(String posId) {
		this.posId = posId;
	}

	@Column(name = "expeditetagnum")
	public String getExpediteTagNum() {
		return expediteTagNum;
	}

	public void setExpediteTagNum(String expediteTagNum) {
		this.expediteTagNum = expediteTagNum;
	}

	@Column(name = "specialcondition")
	public int getSpecialCondition() {
		return specialCondition;
	}

	public void setSpecialCondition(int specialCondition) {
		this.specialCondition = specialCondition;
	}

	@Column(name = "noaddfees")
	public boolean isNoAddFees() {
		return noAddFees;
	}

	public void setNoAddFees(boolean noAddFees) {
		this.noAddFees = noAddFees;
	}

	@Column(name = "other")
	public int getOther() {
		return other;
	}

	public void setOther(int other) {
		this.other = other;
	}

	@Column(name = "assistdevicetype")
	public int getAssistDeviceType() {
		return assistDeviceType;
	}

	public void setAssistDeviceType(int assistDeviceType) {
		this.assistDeviceType = assistDeviceType;
	}

	@Column(name = "assistdevicecheck")
	public String getAssistDeviceCheck() {
		return assistDeviceCheck;
	}

	public void setAssistDeviceCheck(String assistDeviceCheck) {
		this.assistDeviceCheck = assistDeviceCheck;
	}

	@Column(name = "losscode")
	public int getLossCode() {
		return lossCode;
	}

	public void setLossCode(int lossCode) {
		this.lossCode = lossCode;
	}

	@ManyToOne
	@JoinColumn(name="faultStation_id")
	@NotFound(action=NotFoundAction.IGNORE)
	public Station getFaultStation() {
		return faultStation;
	}

	public void setFaultStation(Station faultStation) {
		this.faultStation=faultStation;
	}


	@OrderBy(clause="photo_id")
	@OneToMany(mappedBy="item", cascade=CascadeType.ALL)
	public Set<Item_Photo> getPhotos() {
		if (photolist == null)
			return null;
		return new LinkedHashSet<Item_Photo>(photolist);
	}

	public void setPhotos(Set<Item_Photo> photos) {
		this.photos = photos;
		if (photos != null) this.photolist = new ArrayList<Item_Photo>(photos);
	}

	@OrderBy(clause="inventory_id")
	@OneToMany(mappedBy="item", cascade=CascadeType.ALL)
	public Set<Item_Inventory> getInventory() {
		if (inventorylist == null)
			return null;
		return new LinkedHashSet<Item_Inventory>(inventorylist);
	}

	public void setInventory(Set<Item_Inventory> inventory) {
		this.inventory = inventory;
		if (inventory != null) this.inventorylist = new ArrayList<Item_Inventory>(inventory);
	}

	@OrderBy(clause="bdo_id")
	@OneToMany(mappedBy="item", cascade=CascadeType.ALL)
	public Set<Item_BDO> getItem_bdo() {
		return item_bdo;
	}

	public void setItem_bdo(Set<Item_BDO> item_bdo) {
		this.item_bdo = item_bdo;
	}

	@Transient
	public boolean isDamageEditable() {
		return damageEditable;
	}

	public void setDamageEditable(boolean damageEditable) {
		this.damageEditable = damageEditable;
	}

	@Transient
	public BDO getBdo() {
		if (item_bdo == null || item_bdo.size() == 0) {
			return null;
		} else {
			Iterator<Item_BDO> i = item_bdo.iterator();
			Item_BDO last = null;
			while(i.hasNext()) {
				last = (Item_BDO) i.next();
			}

			bdo = last.getBdo();
			isItemOrBdoCanceled = last.isCanceled() || bdo.isCanceled();
			return bdo;
		}
	}

	@Transient
	public List<Item_Inventory> getInventorylist() {
		if (inventorylist == null)
			inventorylist = new ArrayList<Item_Inventory>();
		return inventorylist;
	}

	public void setInventorylist(List<Item_Inventory> inventorylist) {
		this.inventorylist = inventorylist;
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

	@Transient
	public List<Item_Photo> getPhotolist() {
		if (photolist == null)
			photolist = new ArrayList<Item_Photo>();
		return photolist;
	}

	public void setPhotolist(List<Item_Photo> photolist) {
		this.photolist = photolist;
	}

	@Transient
	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	@Transient
	public boolean isItemOrBdoCanceled() {
		return isItemOrBdoCanceled;
	}

	public void setItemOrBdoCanceled(boolean isItemOrBdoCanceled) {
		this.isItemOrBdoCanceled = isItemOrBdoCanceled;
	}

	@Transient
	public boolean isBdoEntryCanceled() {
		if (bdo == null) {
			getBdo();
		}
		return isItemOrBdoCanceled;
	}

	@Transient
	public boolean isBdoChosen() {
		return bdoChosen;
	}

	public void setBdoChosen(boolean bdoChosen) {
		this.bdoChosen = bdoChosen;
	}

	@Transient
	public List<DropDownConfiguration> getDamageDescList() {
		return damageDescList;
	}

	public void setDamageDescList(List<DropDownConfiguration> damageDescList) {
		this.damageDescList = damageDescList;
	}

	@Transient
	public String getDamageDescSelectedVal() {
		return damageDescSelectedVal;
	}

	public void setDamageDescSelectedVal(String damageDescSelectedVal) {
		this.damageDescSelectedVal = damageDescSelectedVal;
	}

	@Transient
	public String getDispcost() {
		return String.valueOf(cost);
	}

	@Transient
	public String getDisplvlofdamage() {
		String ret = "";

		if (lvlofdamage == CommonsConstants.DAMAGE_MINOR)
			ret = "Minor";
		else if (lvlofdamage == CommonsConstants.DAMAGE_MAJOR)
			ret = "Major";
		else if (lvlofdamage == CommonsConstants.DAMAGE_COMPLETE)
			ret = "Complete";
		return ret;
	}

	@Transient
	public String getDispstatus() {
		String ret = "";

		if (status != null)
			ret = status.getKey();

		return ret;
	}

	@Transient
	public String getDiscost() {
		if (getCost() != 0)
			return CommonsConstants.DECIMALFORMAT.format(getCost());
		else
			return "";
	}

	public void setDiscost(String s) {
		setCost(CommonsUtils.convertToDouble(s));
	}
	
	@Transient
	private double roundToTwoDecimals(double d) {
    	DecimalFormat twoDForm = new DecimalFormat("#.##");
    	return Double.valueOf(twoDForm.format(d));
	}

	@Transient
	public int getFaultStation_id() {
		if(getFaultStation()==null)
			return 0;
		return getFaultStation().getStation_ID();
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
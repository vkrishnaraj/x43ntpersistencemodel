/*
 * Created on Jul 13, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import aero.nettracer.commons.utils.CommonsConstants;
import aero.nettracer.commons.utils.CommonsUtils;
import aero.nettracer.commons.utils.GenericDateUtils;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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

	//Start
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

	//End












	private boolean damageEditable;























	private BDO bdo;

	private Set<Item_BDO> item_bdo;

	private String _DATEFORMAT;
	//private int categorytype_ID = 0;

	private Set<Item_Photo> photoes;

	private Set<Item_Inventory> inventory;

	private List<Item_Photo> photolist;

	private List<Item_Inventory> inventorylist;



	private String tempOHD_ID;

	private int is_in_station; // is the matched ohd in station?

	private String locale;



	private boolean isItemOrBdoCanceled;


















	private boolean bdoChosen = false;

	private List<DropDownConfiguration> damageDescList = Collections.emptyList();

	private String damageDescSelectedVal;

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



	public int getWt_bag_selected() {
		return wt_bag_selected;
	}

	public void setWt_bag_selected(int wt_bag_selected) {
		this.wt_bag_selected = wt_bag_selected;
	}

	@Transient
	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public Item() {
		super();
	}

	@Transient
	public String getDispcost() {
		return "" + cost;
	}

	public Item(int itemtype) {
		this.itemtype_ID = itemtype;
	}

	//NTFIXME
	/*@Transient
	public JRBeanCollectionDataSource getPhotosForReport() {
		if (photoes == null || photoes.size() < 1)
			return null;

		return new JRBeanCollectionDataSource(new ArrayList<Item_Photo>(photoes));
	}*/

	//NTFIXME
	/*@Transient
	public JRBeanCollectionDataSource getInventoriesForReport() {
		if (inventory == null || inventory.size() < 1)
			return null;

		return new JRBeanCollectionDataSource(new ArrayList<Item_Inventory>(inventory));
	}*/

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

	//NTFIXME
	/*@Transient
	public String getCurrency() {
		String ret = "";

		if (currency_ID != null && currency_ID.length() > 0 && !currency_ID.equals("0")) {
			ret = CurrencyUtils.getCurrency(currency_ID).getDescription();
		}

		return ret;
	}*/

	@Transient
	public String getDispstatus() {
		String ret = "";

		if (status != null)
			ret = status.getKey();

		return ret;
	}

	//NTFIXME
	/*@Transient
	public String getCachedManufacturerDescription() {
		String ret = "";

		if (this.getManufacturer_ID() > 0) {
			if (this.getManufacturer_ID() == TracingConstants.MANUFACTURER_OTHER_ID) {
				if (this.getManufacturer_other() != null && this.getManufacturer_other().length() > 0) {
					ret = this.getManufacturer_other();
				}
			} else {
				ret = TracerUtils.getCachedManufacturerDescription(this.getManufacturer_ID());
			}
		}

		return ret;
	}*/

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
	public boolean isBdoEntryCanceled() {
		if (bdo == null) {
			getBdo();
		}
		return isItemOrBdoCanceled;
	}

	@Fetch(FetchMode.SELECT)
	@org.hibernate.annotations.OrderBy(clause="photo_ID")
	@OneToMany(mappedBy="item", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<Item_Photo> getPhotoes() {
		if (photolist == null)
			return null;
		return new LinkedHashSet<Item_Photo>(photolist);
	}

	public void setPhotoes(Set<Item_Photo> photoes) {
		this.photoes = photoes;
		if (photoes != null) this.photolist = new ArrayList<Item_Photo>(photoes);
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

	@Column(length=3)
	public String getCurrency_ID() {
		return currency_ID;
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

	public void setCurrency_ID(String currency_ID) {
		this.currency_ID = currency_ID;
	}

	@Fetch(FetchMode.SELECT)
	@ManyToOne
	@JoinColumn(name="resolution_ID")
	public Resolution getResolution() {
		return resolution;
	}

	public void setResolution(Resolution resolution) {
		this.resolution = resolution;
	}

	@Column(length = 2)
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
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
	
	@Column(length = 255)
	public String getDamage() {
		return damage;
	}

	public void setDamage(String damage) {
		this.damage = damage;
	}

	@Column(length=30)
	public String getDrafts() {
		return drafts;
	}

	public void setDrafts(String drafts) {
		this.drafts = drafts;
	}

	@Fetch(FetchMode.SELECT)
	@org.hibernate.annotations.OrderBy(clause="inventory_ID")
	@OneToMany(mappedBy="item", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<Item_Inventory> getInventory() {
		if (inventorylist == null)
			return null;
		return new LinkedHashSet<Item_Inventory>(inventorylist);
	}

	public void setInventory(Set<Item_Inventory> inventory) {
		this.inventory = inventory;
		if (inventory != null) this.inventorylist = new ArrayList<Item_Inventory>(inventory);
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

	public int getLvlofdamage() {
		return lvlofdamage;
	}

	public void setLvlofdamage(int lvlofdamage) {
		this.lvlofdamage = lvlofdamage;
	}

	@Column(length = 2)
	public String getBagtype() {
		return bagtype;
	}

	public void setBagtype(String bagtype) {
		this.bagtype = bagtype;
	}

	@Column(name ="childrestraint", length = 2)
	public int getChildRestraint() {
		return childRestraint;
	}

	public void setChildRestraint(int childRestraint) {
		this.childRestraint = childRestraint;
	}

	@Column(length=3)
	public String getArrivedonairline_ID() {
		return arrivedonairline_ID;
	}

	public void setExternaldesc(String externaldesc) {
		this.externaldesc = externaldesc;
	}

	@Column(length=50)
	public String getExternaldesc() {
		return externaldesc;
	}

	public void setArrivedonairline_ID(String arrivedonairline_ID) {
		this.arrivedonairline_ID = arrivedonairline_ID;
	}

	@Temporal(value = TemporalType.DATE)
	public Date getArrivedondate() {
		return arrivedondate;
	}

	public void setArrivedondate(Date arrivedondate) {
		this.arrivedondate = arrivedondate;
	}

	public void setDisarrivedondate(String s) {
		setArrivedondate(GenericDateUtils.convertToDate(s, get_DATEFORMAT(), null));
	}

	@Transient
	public String getDisarrivedondate() {
		return GenericDateUtils.formatDate(getArrivedondate(), get_DATEFORMAT(), null, null);
	}

	@Column(length=5)
	public String getArrivedonflightnum() {
		return arrivedonflightnum;
	}

	public void setArrivedonflightnum(String arrivedonflightnum) {
		this.arrivedonflightnum = arrivedonflightnum;
	}
	
	//NTFIXME
	/*@Transient
	private void setClaimSearchParams(String claimchecknum) {
		if (claimchecknum != null && claimchecknum.length() > 3 && claimchecknum.length() <= 12) {
			String leading = null;
			String ticketing = null;
			String carrier = null;
			String bagnum = null;
			
			*//*
	    	 * Check if claimchecknum is Untagged Bagtag and mark carrier and bagnum if so	
	    	 *//*
			if(claimchecknum.substring(0, 3).toUpperCase().equals(TracingConstants.UTB_CHECK)){
				ticketing = claimchecknum.substring(0, 3);
				bagnum = claimchecknum.substring(3);
			} else if (claimchecknum.length() == 8) {
				carrier = claimchecknum.substring(0, 2);
				ticketing = LookupAirlineCodes.getThreeDigitTicketingCode(carrier);
				bagnum = claimchecknum.substring(2);
			} else if (claimchecknum.length() == 9) {
				ticketing = claimchecknum.substring(0, 3);
				carrier = LookupAirlineCodes.getTwoLetterAirlineCode(ticketing);
				bagnum = claimchecknum.substring(3);
			} else if (claimchecknum.length() == 10) {
				leading = claimchecknum.substring(0, 1);
				ticketing = claimchecknum.substring(1, 4);
				carrier = LookupAirlineCodes.getTwoLetterAirlineCode(ticketing);
				bagnum = claimchecknum.substring(4);
			} else if (claimchecknum.length() == 12) {
				leading = claimchecknum.substring(0, 1);
				ticketing = claimchecknum.substring(1, 4);
				carrier = LookupAirlineCodes.getTwoLetterAirlineCode(ticketing);
				bagnum = claimchecknum.substring(4);
			}
			
			if ((leading != null && leading.matches("^[0-9]{1}$")) || leading == null) {
				setClaimchecknum_leading(leading);
			}
			setClaimchecknum_carriercode(carrier);
			setClaimchecknum_ticketingcode(ticketing);
			setClaimchecknum_bagnumber(bagnum);
		}
	}*/

	@Column(length = 1)
	public String getClaimchecknum_leading() {
		return claimchecknum_leading;
	}

	public void setClaimchecknum_leading(String claimchecknum_leading) {
		this.claimchecknum_leading = claimchecknum_leading;
	}

	@Column(length = 3)
	public String getClaimchecknum_ticketingcode() {
		return claimchecknum_ticketingcode;
	}

	public void setClaimchecknum_ticketingcode(String claimchecknum_ticketingcode) {
		this.claimchecknum_ticketingcode = claimchecknum_ticketingcode;
	}

	@Column(length = 2)
	public String getClaimchecknum_carriercode() {
		return claimchecknum_carriercode;
	}

	public void setClaimchecknum_carriercode(String claimchecknum_carriercode) {
		this.claimchecknum_carriercode = claimchecknum_carriercode;
	}

	@Column(length = 6)
	public String getClaimchecknum_bagnumber() {
		return claimchecknum_bagnumber;
	}

	public void setClaimchecknum_bagnumber(String claimchecknum_bagnumber) {
		this.claimchecknum_bagnumber = claimchecknum_bagnumber;
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

	public String getResolutiondesc() {
		return resolutiondesc;
	}

	public void setResolutiondesc(String resolutiondesc) {
		this.resolutiondesc = resolutiondesc;
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

	@Transient
	public String get_DATEFORMAT() {
		return _DATEFORMAT;
	}

	public void set_DATEFORMAT(String _dateformat) {
		_DATEFORMAT = _dateformat;
	}

	@Column(name="purchase_date")
	@Temporal(value = TemporalType.DATE)
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	//NTFIXME
	/*@Transient
	public String getXdescelement2() {
		if (xdescelement_ID_2 <= 0) return "";
		XDescElement xd = TracerUtils.getXdescelement(xdescelement_ID_2);
		return xd.getDescription();
	}*/

	//NTFIXME
	/*@Transient
	public String getXdescelement3() {
		if (xdescelement_ID_3 <= 0) return "";
		XDescElement xd = TracerUtils.getXdescelement(xdescelement_ID_3);
		return xd.getDescription();
	}*/

	//NTFIXME
	/*@Transient
	public String getX1() {
		if (xdescelement_ID_1 <= 0) return "";
		XDescElement xd = TracerUtils.getXdescelement(xdescelement_ID_1);
		return xd.getCode();
	}*/

	//NTFIXME
	/*@Transient
	public String getX2() {
		if (xdescelement_ID_2 <= 0) return "";
		XDescElement xd = TracerUtils.getXdescelement(xdescelement_ID_2);
		return xd.getCode();
	}*/

	//NTFIXME
	/*@Transient
	public String getX3() {
		if (xdescelement_ID_3 <= 0) return "";
		XDescElement xd = TracerUtils.getXdescelement(xdescelement_ID_3);
		return xd.getCode();
	}*/

	//NTFIXME
	/*@Transient
	public String getXdescelement1Key() {
		if (xdescelement_ID_1 <= 0) return "";
		XDescElement xd = TracerUtils.getXdescelement(xdescelement_ID_1);
		return xd.getKey();
	}*/

	//NTFIXME
	/*@Transient
	public String getXdescelement2Key() {
		if (xdescelement_ID_2 <= 0) return "";
		XDescElement xd = TracerUtils.getXdescelement(xdescelement_ID_2);
		return xd.getKey();
	}*/

	//NTFIXME
	/*@Transient
	public String getXdescelement3Key() {
		if (xdescelement_ID_3 <= 0) return "";
		XDescElement xd = TracerUtils.getXdescelement(xdescelement_ID_3);
		return xd.getKey();
	}*/

	@Fetch(FetchMode.SELECT)
	@org.hibernate.annotations.OrderBy(clause="bdo_ID")
	@OneToMany(mappedBy="item", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<Item_BDO> getItem_bdo() {
		return item_bdo;
	}

	public void setItem_bdo(Set<Item_BDO> item_bdo) {
		this.item_bdo = item_bdo;
	}
	
	@Transient
	private double roundToTwoDecimals(double d) {
    	DecimalFormat twoDForm = new DecimalFormat("#.##");
    	return Double.valueOf(twoDForm.format(d));
	}

	public int getReplacementBagIssued() {
		return replacementBagIssued;
	}

	public void setReplacementBagIssued(int replacementBagIssued) {
		this.replacementBagIssued = replacementBagIssued;
	}

	@Column(length = 32)
	public String getPosId() {
		return posId;
	}

	public void setPosId(String posId) {
		this.posId = posId;
	}

	@Column(length = 12)
	public String getExpediteTagNum() {
		return expediteTagNum;
	}

	public void setExpediteTagNum(String expediteTagNum) {
		this.expediteTagNum = expediteTagNum;
	}

	public int getSpecialCondition() {
		return specialCondition;
	}

	public void setSpecialCondition(int specialCondition) {
		this.specialCondition = specialCondition;
	}

	public int getOther() {
		return other;
	}

	public void setOther(int other) {
		this.other = other;
	}

	public boolean isNoAddFees() {
		return noAddFees;
	}

	public void setNoAddFees(boolean noAddFees) {
		this.noAddFees = noAddFees;
	}

	@Column(length = 12)
	public int getAssistDeviceType() {
		return assistDeviceType;
	}

	public void setAssistDeviceType(int assistDeviceType) {
		this.assistDeviceType = assistDeviceType;
	}

	public String getAssistDeviceCheck() {
		return assistDeviceCheck;
	}

	public void setAssistDeviceCheck(String assistDeviceCheck) {
		this.assistDeviceCheck = assistDeviceCheck;
	}

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
	
	@Transient
	public int getFaultStation_id() {
		if(getFaultStation()==null)
			return 0;
		return getFaultStation().getStation_ID();

	}

	//NTFIXME
	/*public void setFaultStation_id(int station_id) {
		if(station_id!=0){
			Station s=StationBMO.getStation(station_id);
			if(s!=null)
				setFaultStation(s);
			else 
				setFaultStation(null);
		} else {
			setFaultStation(null);
		}
	}*/
	
	/**
	 * Method to get the number of NonCancelled BDOs the Item is associated with
	 */
	/*@Transient
	public long countBdos(){
		return BDOUtils.findBDOByItemCount(getId());
	}*/
	
	/**
	 * Method to check status of item to see if it's delivered.
	 * If status is unavailable, it is assumed the item is not delivered
	 */
	/*@Transient
	public boolean isNotDelivered(){
		if(getStatus()!=null)
			return getStatus().getStatus_ID()!=TracingConstants.ITEM_STATUS_PROCESSFORDELIVERY;
		return true;
	}*/

	@Transient
	public boolean isBdoChosen() {
		return bdoChosen;
	}

	public void setBdoChosen(boolean bdoChosen) {
		this.bdoChosen = bdoChosen;
	}
	
	@Transient
	public ItemType getItemTypeObject(){
		ItemType itemType = new ItemType();
		itemType.setItemType_ID(itemtype_ID);
		return itemType;
	}
	
	public void setItemTypeObject(ItemType itemType){
		itemtype_ID = itemType.getItemType_ID();
	}

	@Transient
	public boolean isItemOrBdoCanceled() {
		return isItemOrBdoCanceled;
	}

	public void setItemOrBdoCanceled(boolean isItemOrBdoCanceled) {
		this.isItemOrBdoCanceled = isItemOrBdoCanceled;
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
	public boolean isDamageEditable() {
		return damageEditable;
	}

	public void setDamageEditable(boolean damageEditable) {
		this.damageEditable = damageEditable;
	}
}
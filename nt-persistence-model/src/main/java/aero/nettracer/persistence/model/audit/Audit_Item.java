/*
 * Created on Jul 13, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model.audit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import aero.nettracer.commons.utils.CommonsConstants;
import aero.nettracer.commons.utils.CommonsUtils;
import aero.nettracer.commons.utils.GenericDateUtils;
import aero.nettracer.persistence.model.Resolution;
import aero.nettracer.persistence.model.Station;
import aero.nettracer.persistence.model.Status;
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
import org.hibernate.annotations.Proxy;

@Entity
@Table(name="audit_Item")
public class Audit_Item implements Serializable {

	private static final long serialVersionUID = 5652336568947032404L;

	private int audit_item_id;

	private int Item_ID;
	private int bagnumber;
	private int itemtype_ID;

	private Status status;

	private String claimchecknum; // ohd claimcheck matched with (for mishandled
	// only)

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
	private String arrivedonflightnum;

	private String arrivedonairline_ID;

	private Date arrivedondate;

	private String _DATEFORMAT;

	private Set<Audit_Item_Photo> photoes;

	private Set<Audit_Item_Inventory> inventory;

	private List<Audit_Item_Photo> photolist;

	private List<Audit_Item_Inventory> inventorylist;

	private String OHD_ID; // ohd_id matched with (for mishandled only)

	private int is_in_station; // is the matched ohd in station?

	private Audit_Incident audit_incident;

	private String posId;

	private String expediteTagNum;

	private int specialCondition;

	private String assistDeviceType;

	private String assistDeviceCheck;

	private int lossCode;

	private Station faultStation=new Station();

	private Double bag_weight;
	private String bag_weight_unit;


	public Double getBag_weight() {
		return bag_weight;
	}

	public void setBag_weight(Double bag_weight) {
		this.bag_weight = bag_weight;
	}

	public String getBag_weight_unit() {
		return bag_weight_unit;
	}

	public void setBag_weight_unit(String bag_weight_unit) {
		this.bag_weight_unit = bag_weight_unit;
	}


	public Audit_Item() {
		super();
	}

	public Audit_Item(int itemtype) {
		this.itemtype_ID = itemtype;
	}


	@Id
	@GeneratedValue
	public int getAudit_item_id() {
		return audit_item_id;
	}


	public void setAudit_item_id(int audit_item_id) {
		this.audit_item_id = audit_item_id;
	}

	@ManyToOne
	@JoinColumn(name="audit_incident_id")
	public Audit_Incident getAudit_incident() {
		return audit_incident;
	}

	public void setAudit_incident(Audit_Incident audit_incident) {
		this.audit_incident = audit_incident;
	}



	@Fetch(FetchMode.SELECT)
	@org.hibernate.annotations.OrderBy(clause="photo_ID")
	@OneToMany(mappedBy="audit_item", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<Audit_Item_Photo> getPhotoes() {
		if (photolist == null) return null;
		return new LinkedHashSet<Audit_Item_Photo>(photolist);
	}


	public void setPhotoes(Set<Audit_Item_Photo> photoes) {
		this.photoes = photoes;
		if (photoes != null) this.photolist = new ArrayList<Audit_Item_Photo>(photoes);
	}


	@Transient
	public List<Audit_Item_Photo> getPhotolist() {
		if (photolist == null) photolist = new ArrayList<Audit_Item_Photo>();
		return photolist;
	}


	public void setPhotolist(List<Audit_Item_Photo> photolist) {
		this.photolist = photolist;
	}

	@Fetch(FetchMode.SELECT)
	@ManyToOne
	@JoinColumn(name="status_ID")
	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}

	@Column(length = 3)
	public String getCurrency_ID() {
		return currency_ID;
	}


	public String getOHD_ID() {
		return OHD_ID;
	}


	public void setOHD_ID(String ohd_id) {
		OHD_ID = ohd_id;
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


	public int getItemtype_ID() {
		return itemtype_ID;
	}


	public void setItemtype_ID(int itemtype_ID) {
		this.itemtype_ID = itemtype_ID;
	}

	public int getBagnumber() {
		return bagnumber;
	}


	public void setBagnumber(int bagnumber) {
		this.bagnumber = bagnumber;
	}

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
		if (getCost() != 0) return CommonsConstants.DECIMALFORMAT.format(getCost());
		else return "";
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

	@Column(length = 30)
	public String getDrafts() {
		return drafts;
	}

	public void setDrafts(String drafts) {
		this.drafts = drafts;
	}

	public int getItem_ID() {
		return Item_ID;
	}

	public void setItem_ID(int item_ID) {
		Item_ID = item_ID;
	}

	@Fetch(FetchMode.SELECT)
	@org.hibernate.annotations.OrderBy(clause="inventory_ID")
	@OneToMany(mappedBy="audit_item", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<Audit_Item_Inventory> getInventory() {
		if (inventorylist == null)
			return null;
		return new LinkedHashSet<Audit_Item_Inventory>(inventorylist);
	}

	public void setInventory(Set<Audit_Item_Inventory> inventory) {
		this.inventory = inventory;
		if (inventory != null) this.inventorylist = new ArrayList<Audit_Item_Inventory>(inventory);
	}

	@Transient
	public List<Audit_Item_Inventory> getInventorylist() {
		if (inventorylist == null)
			inventorylist = new ArrayList<Audit_Item_Inventory>();
		return inventorylist;
	}

	public void setInventorylist(List<Audit_Item_Inventory> inventorylist) {
		this.inventorylist = inventorylist;
	}

	@Column(length = 4)
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

	@Column(length = 3)
	public String getArrivedonairline_ID() {
		return arrivedonairline_ID;
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

	public String getArrivedonflightnum() {
		return arrivedonflightnum;
	}

	public void setArrivedonflightnum(String arrivedonflightnum) {
		this.arrivedonflightnum = arrivedonflightnum;
	}

	@Column(length = 13)
	public String getClaimchecknum() {
		return claimchecknum;
	}

	public void setClaimchecknum(String claimchecknum) {
		if (claimchecknum != null) claimchecknum = CommonsUtils.removeSpaces(claimchecknum);
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

	//NTFIXME
	/*@Transient
	public String getManufacturer() {
		String ret = "";

		if (this.getManufacturer_ID() > 0) {
			if (this.getManufacturer_ID() == CommonsConstants.MANUFACTURER_OTHER_ID) {
				if (this.getManufacturer_other() != null && this.getManufacturer_other().length() > 0) {
					ret = this.getManufacturer_other();
				}
			} else {
				Manufacturer manuf = TracerUtils.getManufacturer(this.getManufacturer_ID());
				if (manuf != null) {
					ret = manuf.getDescription();
				}
			}
		}

		return ret;
	}*/

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

	// for passenger view only pages

	//NTFIXME
	/*@Transient
	public String getManuname() {
		if (manufacturer_ID <= 0) return "";
		Manufacturer manu = TracerUtils.getManufacturer(manufacturer_ID);
		return manu.getDescription();
	}*/

	//NTFIXME
	/*@Transient
	public String getXdescelement1() {
		if (xdescelement_ID_1 <= 0) return "";
		XDescElement xd = TracerUtils.getXdescelement(xdescelement_ID_1);
		return xd.getDescription();
	}*/

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

	//NTFIXME
	/*@Transient
	public String getDispSpecialCondition() {
		switch (getSpecialCondition()) {
			case TracingConstants.SPECIAL_CONDITION_OVERWEIGHT:
				return TracingConstants.SPECIAL_CONDITION_NAME_OVERWEIGHT;
			case TracingConstants.SPECIAL_CONDITION_OVERSIZED:
				return TracingConstants.SPECIAL_CONDITION_NAME_OVERSIZED;
			case TracingConstants.SPECIAL_CONDITION_BOTH:
				return TracingConstants.SPECIAL_CONDITION_NAME_BOTH;
			default:
				return "";
		}
	}*/

	@Column(length = 100)
	public String getAssistDeviceType() {
		return assistDeviceType;
	}

	public void setAssistDeviceType(String assistDeviceType) {
		this.assistDeviceType = assistDeviceType;
	}

	@Column(length = 12)
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
		this.faultStation = faultStation;
	}

	@Transient
	public String getFaultStationCode(){
		if(getFaultStation()!=null){
			return getFaultStation().getStationcode();
		} else {
			return "";
		}
	}

}
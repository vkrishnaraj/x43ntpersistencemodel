package aero.nettracer.persistence.model.onlineclaims;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "oc_bag")
public class OCBag {
	
	private long id;
	private boolean bagArrive;
	private String bagColor;
	private String bagType;
	private String brand;
	private String externalMarkings;
	private boolean feet;
	private boolean hardSided;
	private boolean locks;
	private String nameOnBag;
	private boolean nameTag;
	private boolean pockets;
	private boolean pullStrap;
	private Date purchaseDate;
	private boolean retractibleHandle;
	private boolean ribbonsOrMarkings;
	private boolean softSided;
	private String tag;
	private boolean trim;
	private boolean wheels;
	private boolean zippers;
	private OnlineClaim claim;
	private String bagOwner;
	private String bagCurrency;
	private String bagValue;
	private boolean leather;
	private boolean metal;
	private String trimDescription;
	private Set<OCContents> contents;

	@Id
	@GeneratedValue
	@Column(name = "bagid")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "bagarrive")
	public boolean isBagArrive() {
		return bagArrive;
	}

	public void setBagArrive(boolean bagArrive) {
		this.bagArrive = bagArrive;
	}

	@Column(name = "bagcolor")
	public String getBagColor() {
		return bagColor;
	}

	public void setBagColor(String bagColor) {
		this.bagColor = bagColor;
	}

	@Column(name = "bagtype")
	public String getBagType() {
		return bagType;
	}

	public void setBagType(String bagType) {
		this.bagType = bagType;
	}

	@Column(name = "brand")
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Column(name = "externalmarkings")
	public String getExternalMarkings() {
		return externalMarkings;
	}

	public void setExternalMarkings(String externalMarkings) {
		this.externalMarkings = externalMarkings;
	}

	@Column(name = "feet")
	public boolean isFeet() {
		return feet;
	}

	public void setFeet(boolean feet) {
		this.feet = feet;
	}

	@Column(name = "hardsided")
	public boolean isHardSided() {
		return hardSided;
	}

	public void setHardSided(boolean hardSided) {
		this.hardSided = hardSided;
	}

	@Column(name = "locks")
	public boolean isLocks() {
		return locks;
	}

	public void setLocks(boolean locks) {
		this.locks = locks;
	}

	@Column(name = "nameonbag")
	public String getNameOnBag() {
		return nameOnBag;
	}

	public void setNameOnBag(String nameOnBag) {
		this.nameOnBag = nameOnBag;
	}

	@Column(name = "nametag")
	public boolean isNameTag() {
		return nameTag;
	}

	public void setNameTag(boolean nameTag) {
		this.nameTag = nameTag;
	}

	@Column(name = "pockets")
	public boolean isPockets() {
		return pockets;
	}

	public void setPockets(boolean pockets) {
		this.pockets = pockets;
	}

	@Column(name = "pullstrap")
	public boolean isPullStrap() {
		return pullStrap;
	}

	public void setPullStrap(boolean pullStrap) {
		this.pullStrap = pullStrap;
	}

	@Column(name = "purchasedate")
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Column(name = "retractiblehandle")
	public boolean isRetractibleHandle() {
		return retractibleHandle;
	}

	public void setRetractibleHandle(boolean retractibleHandle) {
		this.retractibleHandle = retractibleHandle;
	}

	@Column(name = "ribbonsormarkings")
	public boolean isRibbonsOrMarkings() {
		return ribbonsOrMarkings;
	}

	public void setRibbonsOrMarkings(boolean ribbonsOrMarkings) {
		this.ribbonsOrMarkings = ribbonsOrMarkings;
	}

	@Column(name = "softsided")
	public boolean isSoftSided() {
		return softSided;
	}

	public void setSoftSided(boolean softSided) {
		this.softSided = softSided;
	}

	@Column(name = "tag")
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Column(name = "trim")
	public boolean isTrim() {
		return trim;
	}

	public void setTrim(boolean trim) {
		this.trim = trim;
	}

	@Column(name = "wheels")
	public boolean isWheels() {
		return wheels;
	}

	public void setWheels(boolean wheels) {
		this.wheels = wheels;
	}

	@Column(name = "zippers")
	public boolean isZippers() {
		return zippers;
	}

	public void setZippers(boolean zippers) {
		this.zippers = zippers;
	}

	@ManyToOne
	@JoinColumn(name = "claimId", nullable = false)
	public OnlineClaim getClaim() {
		return claim;
	}

	public void setClaim(OnlineClaim claim) {
		this.claim = claim;
	}

	@Column(name = "bagowner")
	public String getBagOwner() {
		return bagOwner;
	}

	public void setBagOwner(String bagOwner) {
		this.bagOwner = bagOwner;
	}

	@Column(name = "bagcurrency")
	public String getBagCurrency() {
		return bagCurrency;
	}

	public void setBagCurrency(String bagCurrency) {
		this.bagCurrency = bagCurrency;
	}

	@Column(name = "bagvalue")
	public String getBagValue() {
		return bagValue;
	}

	public void setBagValue(String bagValue) {
		this.bagValue = bagValue;
	}

	@Column(name = "leather")
	public boolean isLeather() {
		return leather;
	}

	public void setLeather(boolean leather) {
		this.leather = leather;
	}

	@Column(name = "metal")
	public boolean isMetal() {
		return metal;
	}

	public void setMetal(boolean metal) {
		this.metal = metal;
	}

	@Column(name = "trimdescription")
	public String getTrimDescription() {
		return trimDescription;
	}

	public void setTrimDescription(String trimDescription) {
		this.trimDescription = trimDescription;
	}

	@OneToMany(mappedBy = "bag", cascade=CascadeType.ALL)
	@OrderBy(value = "id")
	public Set<OCContents> getContents() {
  	return contents;
  }

	public void setContents(Set<OCContents> contents) {
  	this.contents = contents;
  }

	@Transient
	public String getGrandTotal() {
		if (getContents() != null) {
			double total = 0D;
			String currency = null;
			for (OCContents cont : getContents()) {
				if (currency == null) {
					currency = cont.getCurrency();
				} else if (!currency.equals(cont.getCurrency())) {
					return "Multiple Currencies.";
				}
				total += cont.getPrice();
			}
			total = Math.round(total * 100)/100.0D;
			return total + "";
		}
		return "0.00";
	}
	
	public void setGrandTotal(String grandTotal) {
	}

}

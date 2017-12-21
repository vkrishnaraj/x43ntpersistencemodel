package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Proxy;


@Entity
@Proxy(lazy = false)
public class LFItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6744394382570717223L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="serial_num",length = 255)
	private String serialNumber;
	
	@Column(name="brand",length = 255)
	private String brand;
	
	@Column(name="description",length = 512)
	private String description;
	
	@Column(name="category")
	private long category;
	
	@Column(name="sub_category")
	private long subCategory;
	
	@Column(name="color",length = 2)
	private String color;

	@Column(name="tracking_num",length = 128)
	private String trackingNumber;
	
	@Column(name="type")
	private int type;
	
	@Column(name="long_description",length = 2048)
	private String longDescription;
	
	@Column(name="returnable")
	private int returnable;
	
	@Column(name="weight")
	private float weight;
	
	@Column(name="delivery_rejected")
	private boolean deliveryRejected;

	@Column(name="case_color",length = 2)
	private String caseColor;
	
	@Column(name="model",length = 255)
	private String model;
	
	@Column(name="item_condition",length = 16)
	private String itemCondition;
	
	@Column(name="size",length = 255)
	private String size;
	
	@OneToOne(targetEntity = LFPhone.class, cascade = CascadeType.ALL)
	private LFPhone phone;
	
	@Column(name = "status_id", nullable = true)
	private int dispositionStatusId;

	@OneToOne(targetEntity = LFLost.class, cascade = CascadeType.ALL)
	private LFLost lost;

	@OneToOne(targetEntity = LFFound.class, cascade = CascadeType.ALL)
	private LFFound found;
	
	@Column(name="removal_reason",length = 16)
	private String removalReason;

	@Column(name="forward_tracking_num",length = 128)
	private String forwardtrackingNumber;

	@Column(name="homingpin_category")
	private long homingPinCategory;

	@Column(name="homingpin_code")
	private String homingPinCode;

	@Column(name="lost_location")
	private long lostLocations;

	@Column(name="found_by")
	private long foundByLocations;

	@Column(name="found_info",length = 2048)
	private String foundByInfo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getCategory() {
		return category;
	}

	public void setCategory(long category) {
		this.category = category;
	}

	public long getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(long subCategory) {
		this.subCategory = subCategory;
	}

	public LFLost getLost() {
		return lost;
	}

	public void setLost(LFLost lost) {
		this.lost = lost;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setFound(LFFound found) {
		this.found = found;
	}

	public LFFound getFound() {
		return found;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getReturnable() {
		return returnable;
	}

	public void setReturnable(int returnable) {
		this.returnable = returnable;
	}

	public boolean getDeliveryRejected() {
		return deliveryRejected;
	}

	public void setDeliveryRejected(boolean deliveryRejected) {
		this.deliveryRejected = deliveryRejected;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getRemovalReason() {
		return removalReason;
	}

	public void setRemovalReason(String removalReason) {
		this.removalReason = removalReason;
	}

	public int getDispositionStatusId() {
		return dispositionStatusId;
	}

	public void setDispositionStatusId(int dispositionStatusId) {
		this.dispositionStatusId = dispositionStatusId;
	}
	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getCaseColor() {
		return caseColor;
	}

	public void setCaseColor(String caseColor) {
		this.caseColor = caseColor;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getItemCondition() {
		return itemCondition;
	}

	public void setItemCondition(String itemCondition) {
		this.itemCondition = itemCondition;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public LFPhone getPhone() {
		return phone;
	}

	public void setPhone(LFPhone phone) {
		this.phone = phone;
	}

	public String getForwardtrackingNumber() {
		return forwardtrackingNumber;
	}

	public void setForwardtrackingNumber(String forwardtrackingNumber) {
		this.forwardtrackingNumber = forwardtrackingNumber;
	}

	public long getHomingPinCategory() {
		return homingPinCategory;
	}

	public void setHomingPinCategory(long homingPinCategory) {
		this.homingPinCategory = homingPinCategory;
	}

	public String getHomingPinCode() {
		return homingPinCode;
	}

	public void setHomingPinCode(String homingPinCode) {
		this.homingPinCode = homingPinCode;
	}

	public long getLostLocations() {
		return lostLocations;
	}

	public void setLostLocations(long lostLocations) {
		this.lostLocations = lostLocations;
	}

	public long getFoundByLocations() {
		return foundByLocations;
	}

	public void setFoundByLocations(long foundByLocations) {
		this.foundByLocations = foundByLocations;
	}

	public String getFoundByInfo() {
		return foundByInfo;
	}

	public void setFoundByInfo(String foundByInfo) {
		this.foundByInfo = foundByInfo;
	}
}

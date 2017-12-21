package aero.nettracer.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lfitem")
public class LFItem {

	private long id;
	private String serialNumber;
	private String brand;
	private String description;
	private long category;
	private long subCategory;
	private String color;
	private String trackingNumber;
	private int type;
	private String longDescription;
	private int returnable;
	private float weight;
	private boolean deliveryRejected;
	private String caseColor;
	private String model;
	private String itemCondition;
	private String size;
	private LFPhone phone;
	private int dispositionStatusId;
	private LFLost lost;
	private LFFound found;
	private String forwardtrackingNumber;
	private String removalReason;
	private long homingPinCategory;
	private String homingPinCode;
	private long lostLocations;
	private long foundByLocations;
	private String foundByInfo;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "serialnumber")
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Column(name="brand")
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="category")
	public long getCategory() {
		return category;
	}

	public void setCategory(long category) {
		this.category = category;
	}

	@Column(name="sub_category")
	public long getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(long subCategory) {
		this.subCategory = subCategory;
	}

	@Column(name="color")
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name="tracking_num")
	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	@Column(name="type")
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column(name="long_description")
	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	@Column(name="returnable")
	public int getReturnable() {
		return returnable;
	}

	public void setReturnable(int returnable) {
		this.returnable = returnable;
	}

	@Column(name="weight")
	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	@Column(name="delivery_rejected")
	public boolean isDeliveryRejected() {
		return deliveryRejected;
	}

	public void setDeliveryRejected(boolean deliveryRejected) {
		this.deliveryRejected = deliveryRejected;
	}

	@Column(name="case_color")
	public String getCaseColor() {
		return caseColor;
	}

	public void setCaseColor(String caseColor) {
		this.caseColor = caseColor;
	}

	@Column(name="model")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name="item_condition")
	public String getItemCondition() {
		return itemCondition;
	}

	public void setItemCondition(String itemCondition) {
		this.itemCondition = itemCondition;
	}

	@Column(name="size")
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@OneToOne(cascade = CascadeType.ALL)
	public LFPhone getPhone() {
		return phone;
	}

	public void setPhone(LFPhone phone) {
		this.phone = phone;
	}

	@Column(name = "status_id")
	public int getDispositionStatusId() {
		return dispositionStatusId;
	}

	public void setDispositionStatusId(int dispositionStatusId) {
		this.dispositionStatusId = dispositionStatusId;
	}

	@OneToOne(cascade = CascadeType.ALL)
	public LFLost getLost() {
		return lost;
	}

	public void setLost(LFLost lost) {
		this.lost = lost;
	}

	@OneToOne(cascade = CascadeType.ALL)
	public LFFound getFound() {
		return found;
	}

	public void setFound(LFFound found) {
		this.found = found;
	}

	@Column(name="forward_tracking_num")
	public String getForwardtrackingNumber() {
		return forwardtrackingNumber;
	}

	public void setForwardtrackingNumber(String forwardtrackingNumber) {
		this.forwardtrackingNumber = forwardtrackingNumber;
	}

	@Column(name="removal_reason")
	public String getRemovalReason() {
		return removalReason;
	}

	public void setRemovalReason(String removalReason) {
		this.removalReason = removalReason;
	}

	@Column(name="homingpin_category")
	public long getHomingPinCategory() {
		return homingPinCategory;
	}

	public void setHomingPinCategory(long homingPinCategory) {
		this.homingPinCategory = homingPinCategory;
	}

	@Column(name="homingpin_code")
	public String getHomingPinCode() {
		return homingPinCode;
	}

	public void setHomingPinCode(String homingPinCode) {
		this.homingPinCode = homingPinCode;
	}

	@Column(name="lost_location")
	public long getLostLocations() {
		return lostLocations;
	}

	public void setLostLocations(long lostLocations) {
		this.lostLocations = lostLocations;
	}

	@Column(name="found_by")
	public long getFoundByLocations() {
		return foundByLocations;
	}

	public void setFoundByLocations(long foundByLocations) {
		this.foundByLocations = foundByLocations;
	}

	@Column(name="found_info")
	public String getFoundByInfo() {
		return foundByInfo;
	}

	public void setFoundByInfo(String foundByInfo) {
		this.foundByInfo = foundByInfo;
	}

}

package aero.nettracer.persistence.model;

import java.util.Date;

import aero.nettracer.persistence.model.fraudservice.Attachment;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.apache.commons.lang3.math.NumberUtils;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "depreciation_item")
public class Depreciation_Item {

	private int id;
	private String description;
	private double amountClaimed;
	private Date datePurchase; 
	private Depreciation_Category category;
	private int proofOwnership;
	private boolean notCoveredCoc;
	private double calcValue;
	private double claimValue;
	private Claim_Depreciation claimDepreciation;
	private String item;
	private int quantity;
	private String manufacturer;
	private String color;
	private String size;
	private String gender;
	private String purchaseLocation;
	private Attachment receipt;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "amountClaimed")
	public double getAmountClaimed() {
		return amountClaimed;
	}

	public void setAmountClaimed(double amountClaimed) {
		this.amountClaimed = amountClaimed;
	}

	@Column(name = "datePurchase")
	public Date getDatePurchase() {
		return datePurchase;
	}

	public void setDatePurchase(Date datePurchase) {
		this.datePurchase = datePurchase;
	}

	@ManyToOne
	@JoinColumn(name = "category_id")
	@NotFound(action=NotFoundAction.IGNORE)
	public Depreciation_Category getCategory() {
		return category;
	}

	public void setCategory(Depreciation_Category category) {
		this.category = category;
	}

	@Column(name = "proofOwnership")
	public int getProofOwnership() {
		return proofOwnership;
	}

	public void setProofOwnership(int proofOwnership) {
		this.proofOwnership = proofOwnership;
	}

	@Column(name = "notCoveredCoc")
	public boolean isNotCoveredCoc() {
		return notCoveredCoc;
	}

	public void setNotCoveredCoc(boolean notCoveredCoc) {
		this.notCoveredCoc = notCoveredCoc;
	}

	@Column(name = "calcValue")
	public double getCalcValue() {
		return calcValue;
	}

	public void setCalcValue(double calcValue) {
		this.calcValue = calcValue;
	}

	@Column(name = "claimValue")
	public double getClaimValue() {
		return claimValue;
	}

	public void setClaimValue(double claimValue) {
		this.claimValue = claimValue;
	}

	@ManyToOne
	@JoinColumn(name = "claim_depreciation_id", nullable = false)
	public Claim_Depreciation getClaimDepreciation() {
		return claimDepreciation;
	}

	public void setClaimDepreciation(Claim_Depreciation claimDepreciation) {
		this.claimDepreciation = claimDepreciation;
	}

	@Column(name = "item")
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Column(name = "quantity")
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "manufacturer")
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Column(name = "color")
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "size")
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Column(name = "gender")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "purchaseLocation")
	public String getPurchaseLocation() {
		return purchaseLocation;
	}

	public void setPurchaseLocation(String purchaseLocation) {
		this.purchaseLocation = purchaseLocation;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "receipt_id")
	@NotFound(action = NotFoundAction.IGNORE)
	public Attachment getReceipt() {
		return receipt;
	}

	public void setReceipt(Attachment receipt) {
		this.receipt = receipt;
	}

	@Transient
	public void setProofOwnership(String proofOwnership) {
		setProofOwnership(NumberUtils.isNumber(proofOwnership)?Integer.parseInt(proofOwnership):0);
	}

	@Transient
	public int getCategoryId() {
		if(category!=null)
			return category.getId();
		else 
			return 0;
	}

	@Transient
	public String getRefNum() {
		if(getClaimDepreciation().getClaim()!=null &&getClaimDepreciation().getClaim().getIncident()!=null
				&& getClaimDepreciation().getClaim().getIncident().getAirlineIncidentId()!=null && getClaimDepreciation().getClaim().getIncident().getAirlineIncidentId().length()>0){
			return getClaimDepreciation().getClaim().getIncident().getAirlineIncidentId();
		} else {
			return "";
		}
	}
	
	@Transient
	public String getClaimId() {
		if(getClaimDepreciation().getClaim()!=null && getClaimDepreciation().getClaim().getId()!=0){
			return String.valueOf(getClaimDepreciation().getClaim().getId());
		} else {
			return "";
		}
	}
	
	@Transient
	public String getClaimTypeVal() {
		if(getClaimDepreciation().getClaimType()!=null && getClaimDepreciation().getClaimType().getDescription()!=null 
				&& getClaimDepreciation().getClaimType().getDescription().length()>0){
			return getClaimDepreciation().getClaimType().getDescription();
		} else {
			return "";
		}
	}

	@Transient
	public String getCurrency() {

		if(getClaimDepreciation()!=null && getClaimDepreciation().getCurrency()!=null && getClaimDepreciation().getCurrency().length()>0){
			return getClaimDepreciation().getCurrency();
		} else {
			return "";
		}
	}

	@Transient
	public String getCategoryName() {
		if(getCategory()!=null && getCategory().getName()!=null && getCategory().getName().length()>0){
			return getCategory().getName();
		} else {
			return "";
		}
		
	}
	
	@Transient
	public String getProofOwn() {
		if(proofOwnership==0)
			return "No Proof";
		else if(proofOwnership==1){
			return "Check";
		} else if(proofOwnership==2){
			return "Photo";
		} else if(proofOwnership==3){
			return "Appraisal";
		} else if(proofOwnership==4){
			return "CC Receipt";
		} else if(proofOwnership==5){
			return "Receipt";
		} else {
			return "";
		}
	}
	
	@Transient
	public void setDispAmountClaimed(String amountClaimed){
		setAmountClaimed(NumberUtils.isNumber(amountClaimed)?Double.parseDouble(amountClaimed):0);
	}

	@Transient
	public void setDispCalcValue(String calcValue){
		setCalcValue(NumberUtils.isNumber(calcValue)?Double.parseDouble(calcValue):0);
	}

	@Transient
	public void setDispClaimValue(String claimValue){
		setClaimValue(NumberUtils.isNumber(claimValue)?Double.parseDouble(claimValue):0);
	}

	@Transient
	public String getCoc(){
		if(isNotCoveredCoc()){
			return "Not Covered";
		} else {
			return "";
		}
	}

}

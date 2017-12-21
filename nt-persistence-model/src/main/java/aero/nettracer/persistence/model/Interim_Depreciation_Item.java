package aero.nettracer.persistence.model;

import aero.nettracer.persistence.model.fraudservice.Attachment;
import org.apache.commons.lang3.math.NumberUtils;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

import static aero.nettracer.commons.utils.CommonsConstants.DECIMALFORMAT;

@Entity
@Table(name = "interim_depreciation_item")
public class Interim_Depreciation_Item {

    private int id;
    private String description;
    private double amountClaimed;
    private Date datePurchase;
    private Depreciation_Category category;
    private int proofOwnership;
    private boolean notCoveredCoc;
    private double calcValue;
    private double claimValue;
    private boolean paid;
    private Interim_Claim_Depreciation interimClaimDepreciation;
    private String item;
    private int quantity;
    private String manufacturer;
    private String color;
    private String size;
    private String gender;
    private String purchaseLocation;
    private Attachment receipt = new Attachment();

    @Id
    @GeneratedValue
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

    @Column(name = "amountclaimed")
    public double getAmountClaimed() {
        return amountClaimed;
    }

    public void setAmountClaimed(double amountClaimed) {
        this.amountClaimed = amountClaimed;
    }

    @Column(name = "datepurchase")
    public Date getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(Date datePurchase) {
        this.datePurchase = datePurchase;
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotFound(action= NotFoundAction.IGNORE)
    public Depreciation_Category getCategory() {
        return category;
    }

    public void setCategory(Depreciation_Category category) {
        this.category = category;
    }

    @Column(name = "proofownership")
    public int getProofOwnership() {
        return proofOwnership;
    }

    public void setProofOwnership(int proofOwnership) {
        this.proofOwnership = proofOwnership;
    }

    @Column(name = "notcoveredcoc")
    public boolean isNotCoveredCoc() {
        return notCoveredCoc;
    }

    public void setNotCoveredCoc(boolean notCoveredCoc) {
        this.notCoveredCoc = notCoveredCoc;
    }

    @Column(name = "calcvalue")
    public double getCalcValue() {
        return calcValue;
    }

    public void setCalcValue(double calcValue) {
        this.calcValue = calcValue;
    }

    @Column(name = "claimvalue")
    public double getClaimValue() {
        return claimValue;
    }

    public void setClaimValue(double claimValue) {
        this.claimValue = claimValue;
    }

    @Column(name = "paid")
    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @ManyToOne
    @JoinColumn(name = "interim_claim_depreciation_id", nullable = false)
    public Interim_Claim_Depreciation getInterimClaimDepreciation() {
        return interimClaimDepreciation;
    }

    public void setInterimClaimDepreciation(Interim_Claim_Depreciation interimClaimDepreciation) {
        this.interimClaimDepreciation = interimClaimDepreciation;
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

    @Column(name = "purchaselocation")
    public String getPurchaseLocation() {
        return purchaseLocation;
    }

    public void setPurchaseLocation(String purchaseLocation) {
        this.purchaseLocation = purchaseLocation;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receipt_id", nullable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    public Attachment getReceipt() {
        return receipt;
    }

    public void setReceipt(Attachment receipt) {
        this.receipt = receipt;
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
        if(getInterimClaimDepreciation().getClaim()!=null &&getInterimClaimDepreciation().getClaim().getIncident()!=null
                && getInterimClaimDepreciation().getClaim().getIncident().getAirlineIncidentId()!=null && getInterimClaimDepreciation().getClaim().getIncident().getAirlineIncidentId().length()>0){
            return getInterimClaimDepreciation().getClaim().getIncident().getAirlineIncidentId();
        } else {
            return "";
        }
    }

    @Transient
    public String getClaimId() {
        if(getInterimClaimDepreciation().getClaim()!=null && getInterimClaimDepreciation().getClaim().getId()!=0){
            return String.valueOf(getInterimClaimDepreciation().getClaim().getId());
        } else {
            return "";
        }
    }

    @Transient
    public String getClaimTypeVal() {
        if(getInterimClaimDepreciation().getClaimType()!=null && getInterimClaimDepreciation().getClaimType().getDescription()!=null
                && getInterimClaimDepreciation().getClaimType().getDescription().length()>0){
            return getInterimClaimDepreciation().getClaimType().getDescription();
        } else {
            return "";
        }
    }

    @Transient
    public String getCurrency() {
        if(getInterimClaimDepreciation()!=null && getInterimClaimDepreciation().getCurrency()!=null && getInterimClaimDepreciation().getCurrency().length()>0){
            return getInterimClaimDepreciation().getCurrency();
        } else {
            return "";
        }
    }

    @Transient
    public String getApprovedTotal() {
        if(getInterimClaimDepreciation()!=null){
            return DECIMALFORMAT.format(getInterimClaimDepreciation().getTotalApprovedPayout());
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
    public String getClaimTotal() {
        if(getInterimClaimDepreciation()!=null){
            return DECIMALFORMAT.format(getInterimClaimDepreciation().getTotalClaim());
        } else {
            return "0.00";
        }
    }

    @Transient
    public String getValueTotal() {

        if(getInterimClaimDepreciation()!=null){
            return DECIMALFORMAT.format(getInterimClaimDepreciation().getTotalValue());
        } else
            return "0.00";
    }

    @Transient
    public String getDispClaimValue() {
        if(getClaimValue()!=0){
            return DECIMALFORMAT.format(getClaimValue());
        } else {
            return "0.00";
        }
    }

    @Transient
    public String getDispCalcValue() {
        if(getCalcValue()!=0){
            return DECIMALFORMAT.format(getCalcValue());
        } else
            return "0.00";

    }

    @Transient
    public String getDispAmountClaimed() {
        if(getAmountClaimed()!=0){
            return DECIMALFORMAT.format(getAmountClaimed());
        }else
            return "0.00";
    }

     @Transient
    public String getDepamount(){
        return DECIMALFORMAT.format(getAmountClaimed()-getClaimValue());
    }

    @Transient
    public String getPercent(){
        double divisor = getAmountClaimed()!=0?getAmountClaimed():1;
        return DECIMALFORMAT.format(((getAmountClaimed()-getClaimValue())/divisor)*100)+"%";
    }

    @Transient
    public void setDispAmountClaimed(String amountClaimed) {
        setAmountClaimed(NumberUtils.isNumber(amountClaimed)?Double.parseDouble(amountClaimed):0);
    }

    @Transient
    public void setDispCalcValue(String calcValue){
        setCalcValue(NumberUtils.isNumber(calcValue)?Double.parseDouble(calcValue):0);
    }

    @Transient
    public void setDispClaimValue(String claimValue) {
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

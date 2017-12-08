package aero.nettracer.persistence.model;

import java.util.Date;

import aero.nettracer.commons.utils.CommonsConstants;
import aero.nettracer.commons.utils.GenericDateUtils;
import aero.nettracer.persistence.model.fraudservice.Attachment;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Proxy;

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

    private String item;
    private int quantity;
    private String manufacturer;
    private String color;
    private String size;
    private String gender;
    private String purchaseLocation;
    private Attachment receipt = new Attachment();

    private Interim_Claim_Depreciation interimClaimDepreciation;

    private String _DATEFORMAT; // current login agent's date format

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "interim_claim_depreciation_id", nullable = false)
    @Fetch(FetchMode.SELECT)
    public Interim_Claim_Depreciation getInterimClaimDepreciation() {
        return interimClaimDepreciation;
    }

    public void setInterimClaimDepreciation(Interim_Claim_Depreciation interimClaimDepreciation) {
        this.interimClaimDepreciation = interimClaimDepreciation;
    }

    public double getClaimValue() {
        return claimValue;
    }

    public void setClaimValue(double claimValue) {
        this.claimValue = claimValue;
    }

    public double getCalcValue() {
        return calcValue;
    }

    public void setCalcValue(double calcValue) {
        this.calcValue = calcValue;
    }

    public boolean isNotCoveredCoc() {
        return notCoveredCoc;
    }

    public void setNotCoveredCoc(boolean notCoveredCoc) {
        this.notCoveredCoc = notCoveredCoc;
    }

    public int getProofOwnership() {
        return proofOwnership;
    }

    public void setProofOwnership(int proofOwnership) {
        this.proofOwnership = proofOwnership;
    }

    @Transient
    public void setProofOwnership(String proofOwnership) {
        int p=0;
        try{
            p=Integer.valueOf(proofOwnership);
        } catch (Exception e){

        }
        setProofOwnership(p);
    }

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = true)
    @NotFound(action= NotFoundAction.IGNORE)
    @Fetch(FetchMode.SELECT)
    public Depreciation_Category getCategory() {
        return category;
    }

    public void setCategory(Depreciation_Category category) {
        this.category = category;
    }

    @Transient
    public int getCategoryId() {
        if(category!=null)
            return category.getId();
        else
            return 0;
    }

    /*public void setCategoryId(int categoryId) {
        if(categoryId!=0){
            Depreciation_Category cat= CategoryBMO.getDepreciationCategory(categoryId);
            if(cat!=null){
                this.category=cat;
            } else {
                this.category=new Depreciation_Category();
                this.category.setId(categoryId);
            }
        } else {
            this.category=null;
        }
    }*/

    public Date getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(Date datePurchase) {
        this.datePurchase = datePurchase;
    }

    public double getAmountClaimed() {
        return amountClaimed;
    }

    public void setAmountClaimed(double amountClaimed) {
        this.amountClaimed = amountClaimed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPurchaseLocation() {
        return purchaseLocation;
    }

    public void setPurchaseLocation(String purchaseLocation) {
        this.purchaseLocation = purchaseLocation;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "receipt_id", nullable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    @Fetch(FetchMode.SELECT)
    public Attachment getReceipt() {
        return receipt;
    }

    public void setReceipt(Attachment receipt) {
        this.receipt = receipt;
    }

    @Transient
    public String get_DATEFORMAT() {
        return _DATEFORMAT;
    }

    @Transient
    public void set_DATEFORMAT(String _DATEFORMAT) {
        this._DATEFORMAT = _DATEFORMAT;
    }

    @Transient
    public void setDispDatePurchase(String s) {
        setDatePurchase(GenericDateUtils.convertToDate(s, _DATEFORMAT, null));
    }

    @Transient
    public String getDispDatePurchase() {
        return GenericDateUtils.formatDate(getDatePurchase(), _DATEFORMAT, null, null);
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
    public String getDateCalc() {
        if(getInterimClaimDepreciation()!=null && getInterimClaimDepreciation().getDispDateCalculate()!=null
                && getInterimClaimDepreciation().getDispDateCalculate().length()>0){
            return getInterimClaimDepreciation().getDispDateCalculate();
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
            return CommonsConstants.DECIMALFORMAT.format(getInterimClaimDepreciation().getTotalApprovedPayout());
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
            return CommonsConstants.DECIMALFORMAT.format(getInterimClaimDepreciation().getTotalClaim());
        } else {
            return "0.00";
        }
    }

    @Transient
    public String getValueTotal() {

        if(getInterimClaimDepreciation()!=null){
            return CommonsConstants.DECIMALFORMAT.format(getInterimClaimDepreciation().getTotalValue());
        } else
            return "0.00";
    }

    @Transient
    public String getDispClaimValue() {
        if(getClaimValue()!=0){
            return CommonsConstants.DECIMALFORMAT.format(getClaimValue());
        } else {
            return "0.00";
        }
    }

    @Transient
    public String getDispCalcValue() {
        if(getCalcValue()!=0){
            return CommonsConstants.DECIMALFORMAT.format(getCalcValue());
        } else
            return "0.00";

    }

    @Transient
    public String getDispAmountClaimed() {
        if(getAmountClaimed()!=0){
            return CommonsConstants.DECIMALFORMAT.format(getAmountClaimed());
        }else
            return "0.00";
    }

    @Transient
    public void setDispAmountClaimed(String amountClaimed){
        double ac=0;
        try{
            ac=Double.valueOf(amountClaimed);
        } catch (Exception e) {

        }
        setAmountClaimed(ac);

    }

    @Transient
    public void setDispCalcValue(String calcValue){
        double cv=0;
        try{
            cv=Double.valueOf(calcValue);
        } catch (Exception e) {

        }
        setCalcValue(cv);

    }

    @Transient
    public void setDispClaimValue(String claimValue){
        double cv=0;
        try{
            cv=Double.valueOf(claimValue);
        } catch (Exception e) {

        }
        setClaimValue(cv);

    }

    @Transient
    public String getCoc(){
        if(isNotCoveredCoc()){
            return "Not Covered";
        } else {
            return "";
        }
    }

    @Transient
    public String getDepamount(){
        return CommonsConstants.DECIMALFORMAT.format(getAmountClaimed()-getClaimValue());
    }

    @Transient
    public String getPercent(){
        double divisor = getAmountClaimed()!=0?getAmountClaimed():1;
        return CommonsConstants.DECIMALFORMAT.format(((getAmountClaimed()-getClaimValue())/divisor)*100)+"%";
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}

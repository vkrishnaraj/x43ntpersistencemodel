package aero.nettracer.persistence.model;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.annotations.OrderBy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "interim_claim_depreciation")
public class Interim_Claim_Depreciation {

    private int id;
    private Claim claim;
    private Date dateCalculate;
    private Claim_Type claimType;
    private double totalWeight;
    private double maxLiablity;
    private String weightMetric;
    private String currency;
    private double totalClaimed;
    private double additionalDepreciation;
    private double totalApprovedPayout;
    private double finalApprovedPayout;
    private List<Interim_Depreciation_Item> interimitemlist=new ArrayList<Interim_Depreciation_Item>();

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name="claim_id")
    public Claim getClaim() {
        return claim;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }

    @Column(name = "datecalculate")
    public Date getDateCalculate() {
        return dateCalculate;
    }

    public void setDateCalculate(Date dateCalculate) {
        this.dateCalculate = dateCalculate;
    }

    @ManyToOne
    @JoinColumn(name = "claimType_id")
    public Claim_Type getClaimType() {
        return claimType;
    }

    public void setClaimType(Claim_Type claimType) {
        this.claimType = claimType;
    }

    @Column(name = "totalweight")
    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    @Column(name = "maxliablity")
    public double getMaxLiablity() {
        return maxLiablity;
    }

    public void setMaxLiablity(double maxLiablity) {
        this.maxLiablity = maxLiablity;
    }

    @Column(name = "weightmetric")
    public String getWeightMetric() {
        return weightMetric;
    }

    public void setWeightMetric(String weightMetric) {
        this.weightMetric = weightMetric;
    }

    @Column(name = "currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Column(name = "totalclaimed")
    public double getTotalClaimed() {
        return totalClaimed;
    }

    public void setTotalClaimed(double totalClaimed) {
        this.totalClaimed = totalClaimed;
    }

    @Column(name = "additionaldepreciation")
    public double getAdditionalDepreciation() {
        return additionalDepreciation;
    }

    public void setAdditionalDepreciation(double additionalDepreciation) {
        this.additionalDepreciation = additionalDepreciation;
    }

    @Column(name = "totalapprovedpayout")
    public double getTotalApprovedPayout() {
        return totalApprovedPayout;
    }

    public void setTotalApprovedPayout(double totalApprovedPayout) {
        this.totalApprovedPayout = totalApprovedPayout;
    }

    @Column(name = "finalapprovedpayout")
    public double getFinalApprovedPayout() {
        return finalApprovedPayout;
    }

    public void setFinalApprovedPayout(double finalApprovedPayout) {
        this.finalApprovedPayout = finalApprovedPayout;
    }

    @OneToMany(mappedBy = "interimClaimDepreciation", cascade = CascadeType.ALL)
    @OrderBy(clause = "id")
    public List<Interim_Depreciation_Item> getInterimitemlist() {
        return interimitemlist;
    }

    public void setInterimitemlist(List<Interim_Depreciation_Item> interimitemlist) {
        this.interimitemlist = interimitemlist;
    }

    @Transient
    public int getClaimTypeId() {
        return claimType == null ? 0 : claimType.getId();
    }

    @Transient
    public double getTotalClaim(){
        double tc=0;
        if(CollectionUtils.isNotEmpty(interimitemlist))
            for(Interim_Depreciation_Item di:interimitemlist){
                tc+=di.getAmountClaimed();
            }
        return tc;
    }

    @Transient
    public double getTotalValue(){
        double tv=0;
        if(CollectionUtils.isNotEmpty(interimitemlist))
            for(Interim_Depreciation_Item di:interimitemlist){
                tv+=di.getClaimValue();
            }
        return tv;
    }

    @Transient
    public String getClaimAirlineIncidentId() {
        return claim == null ? "" :claim.getAirlineIncidentId();
    }

    @Transient
    public String getClaimId() {
        return claim == null ? "" : String.valueOf(claim.getId());
    }

    @Transient
    public String getClaimTypeDescription() {
        return claimType == null ? "" : claimType.getDescription();
    }

}

package aero.nettracer.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "claim_depreciation")
public class Claim_Depreciation {

	private int id;
	private Claim claim;
	private Claim_Type claimType;
	private Date dateCalculate; 
	private double totalWeight;
	private double maxLiablity;
	private String weightMetric;
	private String currency;
	private double totalClaimed;
	private double additionalDepreciation;
	private double totalApprovedPayout;
	private List<Depreciation_Item> itemList=new ArrayList<>();

	@Id
	@GeneratedValue
	@Column(name = "id")
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

	@ManyToOne
	@JoinColumn(name = "claimtype_id", nullable = true)
	public Claim_Type getClaimType() {
		return claimType;
	}

	public void setClaimType(Claim_Type claimType) {
		this.claimType = claimType;
	}

	@Column(name = "datecalculate")
	@Temporal(TemporalType.DATE)
	public Date getDateCalculate() {
		return dateCalculate;
	}

	public void setDateCalculate(Date dateCalculate) {
		this.dateCalculate = dateCalculate;
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

	@Column(name = "additionalDepreciation")
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

	@OneToMany(mappedBy = "claimDepreciation", cascade = CascadeType.ALL)
	@OrderBy(value = "id")
	public List<Depreciation_Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Depreciation_Item> itemList) {
		this.itemList = itemList;
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

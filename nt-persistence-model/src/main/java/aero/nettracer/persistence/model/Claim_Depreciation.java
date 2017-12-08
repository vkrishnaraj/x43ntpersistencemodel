package aero.nettracer.persistence.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import aero.nettracer.commons.utils.GenericDateUtils;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

/**
 * @author Sean Fine
 * Class representing Claim Depreciation object
 */
@Entity
@Table(name = "claim_depreciation")
public class Claim_Depreciation {

	private int id;
	private Date dateCalculate; 
	private double totalWeight;
	private double maxLiablity;
	private String weightMetric;
	private String currency;
	private double totalClaimed;
	private double additionalDepreciation;
	private double totalApprovedPayout;
	
	private Claim_Type claimType;
	private Claim claim;

	private List<Depreciation_Item> itemlist=new ArrayList<Depreciation_Item>();

	private String _DATEFORMAT; // current login agent's date format

	@Id @GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToOne(targetEntity =  Claim.class)
	@JoinColumn(name="claim_id")
	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

	public Date getDateCalculate() {
		return dateCalculate;
	}

	public void setDateCalculate(Date dateCalculate) {
		this.dateCalculate = dateCalculate;
	}

	@ManyToOne
	@JoinColumn(name = "claimType_id", nullable = true)
	@Fetch(FetchMode.SELECT)
	public Claim_Type getClaimType() {
		return claimType;
	}

	public void setClaimType(Claim_Type claimType) {
		this.claimType = claimType;
	}

	@Transient
	public int getClaimTypeId() {
		if(claimType!=null)
			return claimType.getId();
		else 
			return 0;
	}

	/*public void setClaimTypeId(int claimTypeId) {
		if(claimTypeId!=0){
			Claim_Type type=ClaimBMO.getClaimTypeById(claimTypeId);
			if(type!=null){
				this.claimType=type;
			} else {
				this.claimType=new Claim_Type();
				this.claimType.setId(claimTypeId);
			}
		} else {
			this.claimType=null;
		}
	}*/

	@OneToMany(mappedBy = "claimDepreciation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@org.hibernate.annotations.OrderBy(clause = "id")
	public List<Depreciation_Item> getItemlist() {
		return itemlist;
	}

	public void setItemlist(List<Depreciation_Item> itemlist) {
		this.itemlist = itemlist;
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
	public void setDispDateCalculate(String s) {
		setDateCalculate(GenericDateUtils.convertToDate(s, _DATEFORMAT, null));
	}

	@Transient
	public String getDispDateCalculate() {
		return GenericDateUtils.formatDate(getDateCalculate(), _DATEFORMAT, null, null);
	}

	public String getWeightMetric() {
		return weightMetric;
	}

	public void setWeightMetric(String weightMetric) {
		this.weightMetric = weightMetric;
	}

	public double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}

	public double getMaxLiablity() {
		return maxLiablity;
	}

	public void setMaxLiablity(double maxLiablity) {
		this.maxLiablity = maxLiablity;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getTotalClaimed() {
		return totalClaimed;
	}

	public void setTotalClaimed(double totalClaimed) {
		this.totalClaimed = totalClaimed;
	}

	public double getAdditionalDepreciation() {
		return additionalDepreciation;
	}

	public void setAdditionalDepreciation(double additionalDepreciation) {
		this.additionalDepreciation = additionalDepreciation;
	}

	public double getTotalApprovedPayout() {
		return totalApprovedPayout;
	}

	public void setTotalApprovedPayout(double totalApprovedPayout) {
		this.totalApprovedPayout = totalApprovedPayout;
	}
	
	@Transient
	public String getDispTotalApprovedPayout() {

		DecimalFormat format = (DecimalFormat) java.text.NumberFormat
				.getInstance();
		format.applyPattern("##0.00");
		format.setMinimumFractionDigits(2);
		return format.format(totalApprovedPayout);
	}

	@Transient
	public void setDispTotalApprovedPayout(String totalApprovedPayout) {
		double tap=0;
		try{
			tap=Double.valueOf(totalApprovedPayout);
		} catch (Exception e) {
			
		}
		setTotalApprovedPayout(tap);
	}

	@Transient
	public double getTotalClaim(){
		double tc=0;
		if(itemlist!=null && itemlist.size()>0)
			for(Depreciation_Item di:itemlist){
				tc+=di.getAmountClaimed();
			}
		return tc;
	}

	@Transient
	public double getTotalValue(){
		double tv=0;
		if(itemlist!=null && itemlist.size()>0)
			for(Depreciation_Item di:itemlist){
				tv+=di.getClaimValue();
			}
		return tv;
	}
	
}

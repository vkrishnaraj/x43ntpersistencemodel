package aero.nettracer.persistence.model.audit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "audit_ClaimProrate")
public class Audit_ClaimProrate implements Serializable {

	private int audit_claimprorate_id;
	private int Claimprorate_ID;
	private Date createdate;
	private String companycode_ID;
	private String file_reference;
	private int pir_attached;
	private int claim_attached;
	private int confirmpayment_attached;
	private int all_prorate;
	private String all_prorate_reason;
	private int remit;
	private double remit_amount;
	private String currency_ID;
	private String remit_to;
	private int clearing_bill;
	private String prorate_officer;
	private String sita_address;
	private String fax_number;
	private double total_percentage;
	private double total_share;
	private Set<Audit_Prorate_Itinerary> prorate_itineraries;

	@Id
	@GeneratedValue
	public int getAudit_claimprorate_id() {
		return audit_claimprorate_id;
	}

	public void setAudit_claimprorate_id(int audit_claimprorate_id) {
		this.audit_claimprorate_id = audit_claimprorate_id;
	}

	@OneToMany(mappedBy = "audit_claimprorate")
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "prorate_itinerary_ID")
	public Set<Audit_Prorate_Itinerary> getProrate_itineraries() {
		return prorate_itineraries;
	}

	public void setProrate_itineraries(Set<Audit_Prorate_Itinerary> prorate_itineraries) {
		this.prorate_itineraries = prorate_itineraries;
	}

	@Transient
	public ArrayList getPi_list() {
		return new ArrayList((prorate_itineraries != null ? prorate_itineraries : new HashSet()));
	}

	public int getAll_prorate() {
		return all_prorate;
	}

	public void setAll_prorate(int all_prorate) {
		this.all_prorate = all_prorate;
	}

	public String getAll_prorate_reason() {
		return all_prorate_reason;
	}

	public void setAll_prorate_reason(String all_prorate_reason) {
		this.all_prorate_reason = all_prorate_reason;
	}

	public int getClaim_attached() {
		return claim_attached;
	}

	public void setClaim_attached(int claim_attached) {
		this.claim_attached = claim_attached;
	}

	@Column(name = "Claimprorate_ID")
	public int getClaimprorate_ID() {
		return Claimprorate_ID;
	}

	public void setClaimprorate_ID(int claimprorate_ID) {
		Claimprorate_ID = claimprorate_ID;
	}

	public int getClearing_bill() {
		return clearing_bill;
	}

	public void setClearing_bill(int clearing_bill) {
		this.clearing_bill = clearing_bill;
	}

	public String getCompanycode_ID() {
		return companycode_ID;
	}

	public void setCompanycode_ID(String companycode_ID) {
		this.companycode_ID = companycode_ID;
	}

	public int getConfirmpayment_attached() {
		return confirmpayment_attached;
	}

	public void setConfirmpayment_attached(int confirmpayment_attached) {
		this.confirmpayment_attached = confirmpayment_attached;
	}

	@Temporal(TemporalType.DATE)
	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getCurrency_ID() {
		return currency_ID;
	}

	public void setCurrency_ID(String currency_ID) {
		this.currency_ID = currency_ID;
	}

	public String getFax_number() {
		return fax_number;
	}

	public void setFax_number(String fax_number) {
		this.fax_number = fax_number;
	}

	public String getFile_reference() {
		return file_reference;
	}

	public void setFile_reference(String file_reference) {
		this.file_reference = file_reference;
	}

	public int getPir_attached() {
		return pir_attached;
	}

	public void setPir_attached(int pir_attached) {
		this.pir_attached = pir_attached;
	}

	public String getProrate_officer() {
		return prorate_officer;
	}

	public void setProrate_officer(String prorate_officer) {
		this.prorate_officer = prorate_officer;
	}

	public int getRemit() {
		return remit;
	}

	public void setRemit(int remit) {
		this.remit = remit;
	}

	public double getRemit_amount() {
		return remit_amount;
	}

	public void setRemit_amount(double remit_amount) {
		this.remit_amount = remit_amount;
	}

	public String getRemit_to() {
		return remit_to;
	}

	public void setRemit_to(String remit_to) {
		this.remit_to = remit_to;
	}

	public String getSita_address() {
		return sita_address;
	}

	public void setSita_address(String sita_address) {
		this.sita_address = sita_address;
	}

	public double getTotal_percentage() {
		return total_percentage;
	}

	public void setTotal_percentage(double total_percentage) {
		this.total_percentage = total_percentage;
	}

	public double getTotal_share() {
		return total_share;
	}

	public void setTotal_share(double total_share) {
		this.total_share = total_share;
	}
}
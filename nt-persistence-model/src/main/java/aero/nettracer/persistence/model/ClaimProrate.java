package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;

import aero.nettracer.commons.constant.GenericConstants;
import aero.nettracer.commons.utils.GenericDateUtils;
import com.cci.utils.parser.ElementNode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "ClaimProrate")
public class ClaimProrate implements Serializable {
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
	private Set prorate_itineraries;

	public String toXML() {
		StringBuffer sb = new StringBuffer();
		sb.append("<claimprorate>");
		sb.append("<Claimprorate_ID>" + Claimprorate_ID + "</Claimprorate_ID>");
		sb.append("<createdate>" + createdate.toString() + "</createdate>");
		sb.append("<companycode_ID>" + companycode_ID + "</companycode_ID>");
		sb.append("<pir_attached>" + pir_attached + "</pir_attached>");
		sb.append("<claim_attached>" + claim_attached + "</claim_attached>");
		sb.append("<confirmpayment_attached>" + confirmpayment_attached + "</confirmpayment_attached>");
		sb.append("<all_prorate>" + all_prorate + "</all_prorate>");
		sb.append("<all_prorate_reason>" + all_prorate_reason + "</all_prorate_reason>");
		sb.append("<remit>" + remit + "</remit>");
		sb.append("<remit_amount>" + remit_amount + "</remit_amount>");
		sb.append("<currency_ID>" + currency_ID + "</currency_ID>");
		sb.append("<remit_to>" + remit_to + "</remit_to>");
		sb.append("<clearing_bill>" + clearing_bill + "</clearing_bill>");
		sb.append("<prorate_officer>" + prorate_officer + "</prorate_officer>");
		sb.append("<sita_address>" + sita_address + "</sita_address>");
		sb.append("<fax_number>" + fax_number + "</fax_number>");
		sb.append("<total_percentage>" + total_percentage + "</total_percentage>");
		sb.append("<total_share>" + total_share + "</total_share>");

		sb.append("<prorate_itineraries>");
		if (this.getProrate_itineraries() != null && this.getProrate_itineraries().size() > 0) {
			for (Iterator i = this.getProrate_itineraries().iterator(); i.hasNext();) {
				Prorate_Itinerary itinerary = (Prorate_Itinerary) i.next();
				sb.append(itinerary.toXML());
			}
		}
		sb.append("</prorate_itineraries>");
		sb.append("</claimprorate>");
		return sb.toString();

	}

	public static ClaimProrate XMLtoObject(ElementNode root) {
		ClaimProrate obj = new ClaimProrate();

		ElementNode child = null, grandchild = null, ggrandchild = null, gggrandchild = null;

		Station st = new Station();
		for (ListIterator i = root.get_children().listIterator(); i.hasNext();) {
			child = (ElementNode) i.next();
			if (child.getType().equals("Claimprorate_ID")) {
				obj.setClaimprorate_ID(parseInt(child.getTextContents()));
			} else if (child.getType().equals("createdate")) {
				obj.setCreatedate(GenericDateUtils.convertToDate(child.getTextContents(),
						GenericConstants.DB_DATEFORMAT, null));
			} else if (child.getType().equals("companycode_ID")) {
				obj.setCompanycode_ID(child.getTextContents());
			} else if (child.getType().equals("pir_attached")) {
				obj.setPir_attached(parseInt(child.getTextContents()));
			} else if (child.getType().equals("claim_attached")) {
				obj.setClaim_attached(parseInt(child.getTextContents()));
			} else if (child.getType().equals("confirmpayment_attached")) {
				obj.setConfirmpayment_attached(parseInt(child.getTextContents()));
			} else if (child.getType().equals("all_prorate")) {
				obj.setAll_prorate(parseInt(child.getTextContents()));
			} else if (child.getType().equals("all_prorate_reason")) {
				obj.setAll_prorate_reason(child.getTextContents());
			} else if (child.getType().equals("remit")) {
				obj.setRemit(parseInt(child.getTextContents()));
			} else if (child.getType().equals("remit_amount")) {
				obj.setRemit_amount(parseDouble(child.getTextContents()));
			} else if (child.getType().equals("currency_ID")) {
				obj.setCurrency_ID(child.getTextContents());
			} else if (child.getType().equals("remit_to")) {
				obj.setRemit_to(child.getTextContents());
			} else if (child.getType().equals("clearing_bill")) {
				obj.setClearing_bill(parseInt(child.getTextContents()));
			} else if (child.getType().equals("prorate_officer")) {
				obj.setProrate_officer(child.getTextContents());
			} else if (child.getType().equals("sita_address")) {
				obj.setSita_address(child.getTextContents());
			} else if (child.getType().equals("fax_number")) {
				obj.setFax_number(child.getTextContents());
			} else if (child.getType().equals("total_percentage")) {
				obj.setTotal_percentage(parseDouble(child.getTextContents()));
			} else if (child.getType().equals("total_share")) {
				obj.setTotal_share(parseDouble(child.getTextContents()));
			} else if (child.getType().equals("prorate_itineraries")) {
				ArrayList al = new ArrayList();
				ArrayList c = (ArrayList)child.getChildren();
				for (int z=0;z<c.size();z++) {
					al.add(Prorate_Itinerary.XMLtoObject((ElementNode)c.get(z)));
				}
				obj.setProrate_itineraries(new HashSet(al));
			}


		}


		return obj;
	}

	@OneToMany(mappedBy = "claimprorate", fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "prorate_itinerary_ID")
	public Set<Prorate_Itinerary> getProrate_itineraries() {
		return prorate_itineraries;
	}

	public void setProrate_itineraries(Set<Prorate_Itinerary> prorate_itineraries) {
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

	@Id
	@GeneratedValue
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

	public static int parseInt(String s) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return 0;
		}
	}

	public static double parseDouble(String s) {
		try {
			return Double.parseDouble(s);
		} catch (Exception e) {
			return 0;
		}
	}
}
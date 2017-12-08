package aero.nettracer.persistence.model.audit;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Audit_AirlineMembership")
public class Audit_AirlineMembership implements Serializable {
	private int audit_membership_id;
	private int Membership_ID;
	private String membershipnum;
	private String membershipstatus;
	private String companycode_ID;

	@Id
	@GeneratedValue
	public int getAudit_membership_id() {
		return audit_membership_id;
	}

	public void setAudit_membership_id(int audit_membership_id) {
		this.audit_membership_id = audit_membership_id;
	}

	public String getCompanycode_ID() {
		return companycode_ID;
	}

	public void setCompanycode_ID(String companycode_ID) {
		this.companycode_ID = companycode_ID;
	}

	public int getMembership_ID() {
		return Membership_ID;
	}

	public void setMembership_ID(int membership_ID) {
		Membership_ID = membership_ID;
	}

	public String getMembershipstatus() {
		return membershipstatus;
	}

	public void setMembershipstatus(String membershipstatus) {
		this.membershipstatus = membershipstatus;
	}

	public String getMembershipnum() {
		return membershipnum;
	}

	public void setMembershipnum(String membershipnum) {
		this.membershipnum = membershipnum;
	}

	public boolean equals(Object obj) {
		Audit_AirlineMembership aam = (Audit_AirlineMembership) obj;
		boolean ret = true;

		if (notEqualObjects(aam.getMembershipnum(), this.getMembershipnum())
				|| notEqualObjects(aam.getMembershipstatus(), this.getMembershipstatus())
				|| notEqualObjects(aam.getCompanycode_ID(), this.getCompanycode_ID())) {
			ret = false;
		}
		return ret;
	}

	private boolean notEqualObjects(Object val1, Object val2) {
		boolean ret = false;

		if (val1 != val2) {
			if (val1 == null || val2 == null || !val1.equals(val2)) {
				ret = true;
			}
		}
		return ret;
	}
}
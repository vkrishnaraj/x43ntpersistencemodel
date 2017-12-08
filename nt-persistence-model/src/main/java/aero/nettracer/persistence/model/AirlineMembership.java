package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "AirlineMembership")
public class AirlineMembership implements Serializable {
	private int membership_ID;
	private String membershipnum = "";
	private String membershipstatus = "";
	private String companycode_ID;

	public String getCompanycode_ID() {
		return companycode_ID;
	}

	public void setCompanycode_ID(String companycode_ID) {
		this.companycode_ID = companycode_ID;
	}

	@Id
	@GeneratedValue
	public int getMembership_ID() {
		return membership_ID;
	}

	public void setMembership_ID(int membership_ID) {
		this.membership_ID = membership_ID;
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


}
package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airlinemembership")
public class AirlineMembership {

	private int id;
	private String companycode_ID;
	private String membershipnum;
	private String membershipstatus;

	@Id
	@GeneratedValue
	@Column(name = "membership_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "companycode_id")
	public String getCompanycode_ID() {
		return companycode_ID;
	}

	public void setCompanycode_ID(String companycode_ID) {
		this.companycode_ID = companycode_ID;
	}

	@Column(name = "membershipnum")
	public String getMembershipnum() {
		return membershipnum;
	}

	public void setMembershipnum(String membershipnum) {
		this.membershipnum = membershipnum;
	}

	@Column(name = "membershipstatus")
	public String getMembershipstatus() {
		return membershipstatus;
	}

	public void setMembershipstatus(String membershipstatus) {
		this.membershipstatus = membershipstatus;
	}
}
/*
 * Created on Jul 14, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "companycode")
public class Company {

	private String id;
	private String companydesc;
	private String address1;
	private String address2;
	private String city;
	private String state_ID;
	private String countrycode_ID;
	private String zip;
	private Company_Specific_Variable variable;
	private String phone;
	private String email_address;


	private List<Company_specific_irregularity_code> irregularity_codes;

	@Id
	@Column(name = "companycode_id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "companydesc")
	public String getCompanydesc() {
		return companydesc;
	}

	public void setCompanydesc(String companydesc) {
		this.companydesc = companydesc;
	}

	@Column(name = "address1")
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "address2")
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state_id")
	public String getState_ID() {
		return state_ID;
	}

	public void setState_ID(String state_ID) {
		this.state_ID = state_ID;
	}

	@Column(name = "countrycode_id")
	public String getCountrycode_ID() {
		return countrycode_ID;
	}

	public void setCountrycode_ID(String countrycode_ID) {
		this.countrycode_ID = countrycode_ID;
	}

	@Column(name = "zip")
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@ManyToOne
	@JoinColumn(name = "variablecode")
	public Company_Specific_Variable getVariable() {
		return variable;
	}

	public void setVariable(Company_Specific_Variable variable) {
		this.variable = variable;
	}

	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "email_address")
	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	public List<Company_specific_irregularity_code> getIrregularity_codes() {
		return irregularity_codes;
	}

	public void setIrregularity_codes(List<Company_specific_irregularity_code> irregularity_codes) {
		this.irregularity_codes = irregularity_codes;
	}
}
package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ohd_range")
public class OHD_Range {

	private long id;
	private String companycode_ID;

	@Id
	@GeneratedValue
	@Column(name = "current_num")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "companycode_id")
	public String getCompanycode_ID() {
		return companycode_ID;
	}

	public void setCompanycode_ID(String companycode_ID) {
		this.companycode_ID = companycode_ID;
	}

}
package aero.nettracer.persistence.model.fraudservice;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fsreceipt")
public class FsReceipt {

	private long id;
	private int ccExpMonth;
	private int ccExpYear;
	private String ccLastFour;
	private String ccType;
	private String company;
	private FsClaim claim;
	private FsAddress address;
	private Phone phone;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "ccexpmonth")
	public int getCcExpMonth() {
		return ccExpMonth;
	}

	public void setCcExpMonth(int ccExpMonth) {
		this.ccExpMonth = ccExpMonth;
	}

	@Column(name = "ccexpyear")
	public int getCcExpYear() {
		return ccExpYear;
	}

	public void setCcExpYear(int ccExpYear) {
		this.ccExpYear = ccExpYear;
	}

	@Column(name = "cclastfour")
	public String getCcLastFour() {
		return ccLastFour;
	}

	public void setCcLastFour(String ccLastFour) {
		this.ccLastFour = ccLastFour;
	}

	@Column(name = "cctype")
	public String getCcType() {
		return ccType;
	}

	public void setCcType(String ccType) {
		this.ccType = ccType;
	}

	@Column(name = "company")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@ManyToOne
	public FsClaim getClaim() {
		return claim;
	}

	public void setClaim(FsClaim claim) {
		this.claim = claim;
	}

	@OneToOne(mappedBy = "receipt", cascade = CascadeType.ALL, orphanRemoval = true)
	public FsAddress getAddress() {
		return address;
	}

	public void setAddress(FsAddress address) {
		this.address = address;
	}

	@OneToOne(mappedBy = "receipt", cascade = CascadeType.ALL, orphanRemoval = true)
	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

}

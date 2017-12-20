package aero.nettracer.persistence.model.onlineclaims;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "oc_phone")
public class OCPhone {

	private long id;
	private String phoneNumber;
	private String phoneType;
	private OnlineClaim claim;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "phonenumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "phonetype")
	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	@ManyToOne
	@JoinColumn(name = "claimId", nullable = false)
	public OnlineClaim getClaim() {
		return claim;
	}

	public void setClaim(OnlineClaim claim) {
		this.claim = claim;
	}
}

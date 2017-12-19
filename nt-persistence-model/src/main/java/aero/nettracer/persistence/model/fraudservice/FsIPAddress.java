package aero.nettracer.persistence.model.fraudservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FsIPAddress {

	private long id;
	private String ipAddress;
	private FsClaim claim;
	private String association;
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "ipaddress")
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@ManyToOne
	@JoinColumn(name = "claim_id")
	public FsClaim getClaim() {
		return claim;
	}

	public void setClaim(FsClaim claim) {
		this.claim = claim;
	}

	@Column(name = "association")
	public void setAssociation(String association) {
		this.association = association;
	}

	public String getAssociation() {
		return association;
	}
	
}

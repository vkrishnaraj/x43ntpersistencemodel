package aero.nettracer.persistence.model.fraudservice.detection;

import aero.nettracer.persistence.model.fraudservice.FsClaim;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Proxy;

@Entity
public class InternalSummary {
	@Id
	@GeneratedValue
	private long id;
	
	@OneToOne(targetEntity = FsClaim.class)
	private FsClaim claim;
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public FsClaim getClaim() {
		return claim;
	}

	public void setClaim(FsClaim claim) {
		this.claim = claim;
	}
}

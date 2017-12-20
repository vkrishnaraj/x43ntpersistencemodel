package aero.nettracer.persistence.model.fraudservice.detection;

import aero.nettracer.persistence.model.fraudservice.FsClaim;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "internalsummary")
public class InternalSummary {

	private long id;
	private String description;
	private FsClaim claim;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToOne
	@JoinColumn(name = "claim_id")
	public FsClaim getClaim() {
		return claim;
	}

	public void setClaim(FsClaim claim) {
		this.claim = claim;
	}

}

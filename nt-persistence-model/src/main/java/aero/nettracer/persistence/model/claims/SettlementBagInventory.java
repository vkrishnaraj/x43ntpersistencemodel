package aero.nettracer.persistence.model.claims;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "z_b6_claim_settlement_inventory")
public class SettlementBagInventory {

	private long id;
	private int categorytype_id;
	private String description;
	private ClaimSettlementBag claimsettlementbag;
	private int position;
	private boolean flaggedforremoval;

	@Id
	@GeneratedValue
	@Column(name="inventoryid")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "categorytype_id")
	public int getCategorytype_id() {
		return categorytype_id;
	}

	public void setCategorytype_id(int categorytype_id) {
		this.categorytype_id = categorytype_id;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	@JoinColumn(name = "bagid", nullable = false)
	public ClaimSettlementBag getClaimsettlementbag() {
		return claimsettlementbag;
	}

	public void setClaimsettlementbag(ClaimSettlementBag claimsettlementbag) {
		this.claimsettlementbag = claimsettlementbag;
	}

	@Column(name = "position")
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Transient
	public boolean isFlaggedforremoval() {
		return flaggedforremoval;
	}

	public void setFlaggedforremoval(boolean flaggedforremoval) {
		this.flaggedforremoval = flaggedforremoval;
	}
}

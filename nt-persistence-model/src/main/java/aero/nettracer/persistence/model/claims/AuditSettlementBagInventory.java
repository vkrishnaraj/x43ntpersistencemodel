package aero.nettracer.persistence.model.claims;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "z_b6_audit_claim_settlement_inventory")
public class AuditSettlementBagInventory {


	private long id;
	private int categorytype_id;
	private String description;
	private int position;
	private AuditClaimSettlementBag auditclaimsettlementbag;
	private boolean flaggedforremoval;

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Basic
	public int getCategorytype_id() {
		return categorytype_id;
	}

	public void setCategorytype_id(int categorytype_id) {
		this.categorytype_id = categorytype_id;
	}

	@Basic
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Basic
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@ManyToOne(targetEntity = AuditClaimSettlementBag.class)
	@JoinColumn(name = "auditBagId", nullable = false)
	public AuditClaimSettlementBag getAuditclaimsettlementbag() {
		return auditclaimsettlementbag;
	}

	public void setAuditclaimsettlementbag(
			AuditClaimSettlementBag auditclaimsettlementbag) {
		this.auditclaimsettlementbag = auditclaimsettlementbag;
	}

	@Transient
	public boolean isFlaggedforremoval() {
		return flaggedforremoval;
	}

	public void setFlaggedforremoval(boolean flaggedforremoval) {
		this.flaggedforremoval = flaggedforremoval;
	}


}

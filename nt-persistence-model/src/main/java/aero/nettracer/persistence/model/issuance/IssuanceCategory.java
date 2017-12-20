package aero.nettracer.persistence.model.issuance;

import aero.nettracer.persistence.model.Company;
import aero.nettracer.persistence.model.documents.templates.Template;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="issuance_category")
public class IssuanceCategory {
	
	private long id;
	private String description;
	private Company company;
	private boolean active;
	private boolean lostdelay;
	private boolean damage;
	private boolean missing;
	private boolean inventory;
	private Template template;
	private boolean limitByPassenger;
	private boolean copyDescription;
	private Set<IssuanceItem> items;

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

	@ManyToOne
	@JoinColumn(name="company_code_id", nullable=false)
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Column(name = "active")
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Column(name = "lostdelay")
	public boolean isLostdelay() {
		return lostdelay;
	}

	public void setLostdelay(boolean lostdelay) {
		this.lostdelay = lostdelay;
	}

	@Column(name = "damage")
	public boolean isDamage() {
		return damage;
	}

	public void setDamage(boolean damage) {
		this.damage = damage;
	}

	@Column(name = "missing")
	public boolean isMissing() {
		return missing;
	}

	public void setMissing(boolean missing) {
		this.missing = missing;
	}

	@Column(name = "inventory")
	public boolean isInventory() {
		return inventory;
	}

	public void setInventory(boolean inventory) {
		this.inventory = inventory;
	}

	@ManyToOne
	@JoinColumn(name="document_id" )
	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	@Column(name = "limitbypassenger")
	public boolean isLimitByPassenger() {
		return limitByPassenger;
	}

	public void setLimitByPassenger(boolean limitByPassenger) {
		this.limitByPassenger = limitByPassenger;
	}

	@Column(name = "copydescription")
	public boolean isCopyDescription() {
		return copyDescription;
	}

	public void setCopyDescription(boolean copyDescription) {
		this.copyDescription = copyDescription;
	}

	@OrderBy(value="description")
	@OneToMany(mappedBy="category", cascade=CascadeType.ALL)
	public Set<IssuanceItem> getItems() {
		return items;
	}

	public void setItems(Set<IssuanceItem> items) {
		this.items = items;
	}

}

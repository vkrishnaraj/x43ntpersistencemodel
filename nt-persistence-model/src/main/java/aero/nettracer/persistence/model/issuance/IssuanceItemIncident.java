package aero.nettracer.persistence.model.issuance;

import aero.nettracer.persistence.model.Agent;
import aero.nettracer.persistence.model.Incident;
import aero.nettracer.persistence.model.documents.Document;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.sql.Timestamp;

@Entity
@Table(name="issuance_item_incident")
public class IssuanceItemIncident {

	private long id;
	private int quantity;
	private boolean returned;
	private Timestamp returnDate;
	private IssuanceItemQuantity issuanceItemQuantity;
	private IssuanceItemInventory issuanceItemInventory;
	private Incident incident;
	private Timestamp issueDate;
	private Agent issueAgent;
	private Document document;
	boolean updated = false;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "quantity")
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "returned")
	public boolean isReturned() {
		return returned;
	}

	public void setReturned(boolean returned) {
		this.returned = returned;
	}

	@Column(name="returndate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}

	@ManyToOne
	@JoinColumn(name = "issuance_item_quantity_id")
	public IssuanceItemQuantity getIssuanceItemQuantity() {
		return issuanceItemQuantity;
	}

	public void setIssuanceItemQuantity(IssuanceItemQuantity issuanceItemQuantity) {
		this.issuanceItemQuantity = issuanceItemQuantity;
	}

	@ManyToOne
	@JoinColumn(name = "issuance_item_inventory_id")
	public IssuanceItemInventory getIssuanceItemInventory() {
		return issuanceItemInventory;
	}

	public void setIssuanceItemInventory(IssuanceItemInventory issuanceItemInventory) {
		this.issuanceItemInventory = issuanceItemInventory;
	}

	@ManyToOne
	@JoinColumn(name = "incident_id")
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	@Column(name="issuedate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Timestamp issueDate) {
		this.issueDate = issueDate;
	}

	@ManyToOne
	@JoinColumn(name = "issueagent_id")
	public Agent getIssueAgent() {
		return issueAgent;
	}

	public void setIssueAgent(Agent issueAgent) {
		this.issueAgent = issueAgent;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "document_id")
	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	@Transient
	public boolean isUpdated() {
		return updated;
	}

	public void setUpdated(boolean updated) {
		this.updated = updated;
	}
	
}

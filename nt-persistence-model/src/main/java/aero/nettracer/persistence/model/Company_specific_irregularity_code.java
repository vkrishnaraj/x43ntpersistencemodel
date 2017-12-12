/*
 * Created on Jul 13, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "company_irregularity_codes")
public class Company_specific_irregularity_code {

	private int id;
	private int loss_code;
	private String description;
	private Company company;
	private int report_type;
	private boolean show_to_limited_users;
	private boolean active;
	private boolean controllable;
	private boolean departStation;
	private boolean transferStation;
	private boolean destinationStation;
	private boolean anyStation;
	private BagMartReasonGroup reasonGroup;

	@Id
	@GeneratedValue
	@Column(name = "code_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "loss_code")
	public int getLoss_code() {
		return loss_code;
	}

	public void setLoss_code(int loss_code) {
		this.loss_code = loss_code;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	@JoinColumn(name = "companycode_id")
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Column(name = "report_type")
	public int getReport_type() {
		return report_type;
	}

	public void setReport_type(int report_type) {
		this.report_type = report_type;
	}

	@Column(name = "show_to_limited_users")
	public boolean isShow_to_limited_users() {
		return show_to_limited_users;
	}

	public void setShow_to_limited_users(boolean show_to_limited_users) {
		this.show_to_limited_users = show_to_limited_users;
	}

	@Column(name = "active")
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Column(name = "controllable")
	public boolean isControllable() {
		return controllable;
	}

	public void setControllable(boolean controllable) {
		this.controllable = controllable;
	}

	@Column(name = "departstation")
	public boolean isDepartStation() {
		return departStation;
	}

	public void setDepartStation(boolean departStation) {
		this.departStation = departStation;
	}

	@Column(name = "transferstation")
	public boolean isTransferStation() {
		return transferStation;
	}

	public void setTransferStation(boolean transferStation) {
		this.transferStation = transferStation;
	}

	@Column(name = "destinationstation")
	public boolean isDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(boolean destinationStation) {
		this.destinationStation = destinationStation;
	}

	@Column(name = "anystation")
	public boolean isAnyStation() {
		return anyStation;
	}

	public void setAnyStation(boolean anyStation) {
		this.anyStation = anyStation;
	}

	@ManyToOne
	@JoinColumn(name="reasongrouping_id")
	public BagMartReasonGroup getReasonGroup() {
		return reasonGroup;
	}

	public void setReasonGroup(BagMartReasonGroup reasonGroup) {
		this.reasonGroup = reasonGroup;
	}
}
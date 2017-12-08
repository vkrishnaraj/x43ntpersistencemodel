/*
 * Created on Jul 13, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "company_irregularity_codes")
public class Company_specific_irregularity_code implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6577844701884219201L;
	private int code_id;
	private int loss_code;
	private String description;
	private int report_type;
	private boolean show_to_limited_users;
	private boolean active;
	private boolean controllable;
	private boolean transferStation;
	private boolean departStation;
	private boolean destinationStation;
	private boolean anyStation;


	private Company company;
	private BagMartReasonGroup reasonGroup;

	public int getReport_type() {
		return report_type;
	}

	public void setReport_type(int report_type) {
		this.report_type = report_type;
	}

	@Id
	@GeneratedValue
	public int getCode_id() {
		return code_id;
	}

	public void setCode_id(int code_id) {
		this.code_id = code_id;
	}

	@ManyToOne
	@JoinColumn(name = "companycode_id")
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLoss_code() {
		return loss_code;
	}

	public void setLoss_code(int loss_code) {
		this.loss_code = loss_code;
	}

	@Transient
	public String getCombination() {
		return loss_code + " - " + description;
	}

	public boolean isShow_to_limited_users() {
		return show_to_limited_users;
	}

	public void setShow_to_limited_users(boolean show_to_limited_users) {
		this.show_to_limited_users = show_to_limited_users;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isControllable() {
		return controllable;
	}

	public void  setControllable(boolean controllable) {
		this.controllable = controllable;
	}

	@Transient
	public String getActiveDisp() {
		return active ? "Yes" : "No";
	}

	@Transient
	public String getControllableDisp() {
		return controllable ? "Yes" : "No";
	}

	@Transient
	public String getCodeDescription(){
		return getLoss_code()+" - "+getDescription();
	}

	public boolean isTransferStation() {
		return transferStation;
	}

	public void setTransferStation(boolean transferStation) {
		this.transferStation = transferStation;
	}

	public boolean isDepartStation() {
		return departStation;
	}

	public void setDepartStation(boolean departStation) {
		this.departStation = departStation;
	}

	public boolean isDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(boolean destinationStation) {
		this.destinationStation = destinationStation;
	}

	public boolean isAnyStation() {
		return anyStation;
	}

	public void setAnyStation(boolean anyStation) {
		this.anyStation = anyStation;
	}

	@ManyToOne
	@JoinColumn(name="reasonGrouping_Id")
	public BagMartReasonGroup getReasonGroup() {
		return reasonGroup;
	}

	public void setReasonGroup(BagMartReasonGroup reasonGroup) {
		this.reasonGroup = reasonGroup;
	}

	@Override
	public String toString() {
		return String
				.format("Company_specific_irregularity_code [code_id=%s, loss_code=%s, description=%s, report_type=%s, company=%s]",
						code_id, loss_code, description, report_type, company);
	}
	
	
}
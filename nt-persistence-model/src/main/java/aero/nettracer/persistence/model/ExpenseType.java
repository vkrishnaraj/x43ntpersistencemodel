package aero.nettracer.persistence.model;

import aero.nettracer.persistence.model.i8n.LocaleBasedObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ExpenseType")
public class ExpenseType extends LocaleBasedObject {

	private int id;
	private Company company;
	public static final String MSG_KEY = "EXPENSETYPE_KEY_";

	@Id
	@GeneratedValue
	@Column(name = "expensetype_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "companycode_id")
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Transient
	public String getKey() {
		return MSG_KEY + id;
	}
}
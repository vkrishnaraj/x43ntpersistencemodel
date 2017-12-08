package aero.nettracer.persistence.model;

import java.io.Serializable;

import aero.nettracer.persistence.model.i8n.LocaleBasedObject;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "ExpenseType")
public class ExpenseType extends LocaleBasedObject implements Serializable {
	private int Expensetype_ID;
	private Company company;
	public static final String MSG_KEY = "EXPENSETYPE_KEY_";

	@ManyToOne
	@JoinColumn(name = "companycode_ID")
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Id
	@GeneratedValue
	public int getExpensetype_ID() {
		return Expensetype_ID;
	}

	public void setExpensetype_ID(int expensetype_ID) {
		Expensetype_ID = expensetype_ID;
	}

	@Transient
	public String getKey() {
		return MSG_KEY + Expensetype_ID;
	}
}
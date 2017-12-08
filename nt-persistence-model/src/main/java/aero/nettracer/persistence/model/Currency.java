package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Currency")
public class Currency implements Serializable {
	private String Currency_ID;
	private String description;

	@Id
	public String getCurrency_ID() {
		return Currency_ID;
	}

	public void setCurrency_ID(String currency_ID) {
		Currency_ID = currency_ID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Transient
	public String getId_desc() {
		return Currency_ID + " - " + description;
	}

}
package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "localereceipt")
public class ReceiptDbLocale {

	private String id;
	private String locale_description;

	@Id
	@Column(name = "locale_id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "locale_description", nullable = false)
	public String getLocale_description() {
		return locale_description;
	}

	public void setLocale_description(String locale_description) {
		this.locale_description = locale_description;
	}
}
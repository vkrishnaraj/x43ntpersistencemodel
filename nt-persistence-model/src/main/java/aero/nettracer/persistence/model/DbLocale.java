package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Locale")
public class DbLocale implements Serializable {
	private String locale_id;
	private String locale_description;

	public String getLocale_description() {
		return locale_description;
	}

	public void setLocale_description(String locale_description) {
		this.locale_description = locale_description;
	}

	@Id
	public String getLocale_id() {
		return locale_id;
	}

	public void setLocale_id(String locale_id) {
		this.locale_id = locale_id;
	}
}
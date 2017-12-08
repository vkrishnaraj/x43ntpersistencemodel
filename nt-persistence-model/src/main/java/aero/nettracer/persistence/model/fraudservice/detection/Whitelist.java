package aero.nettracer.persistence.model.fraudservice.detection;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Proxy;

@Entity
/**
 * This class should be used to provide reference for
 * data that is white listed.  An example would be a 
 * valid and common phone number, especially for an
 * incident which might be associated with a hotel.
 * 
 * We do not want to display matches to hotel phone
 * numbers if possible.
 */
public class Whitelist implements Serializable {
	@Id
	@GeneratedValue
	private long id;
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

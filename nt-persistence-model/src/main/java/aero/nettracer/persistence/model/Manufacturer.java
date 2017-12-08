package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Manufacturer")
public class Manufacturer implements Serializable {
	private int Manufacturer_ID;
	private String description;
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Id
	@GeneratedValue
	public int getManufacturer_ID() {
		return Manufacturer_ID;
	}

	public void setManufacturer_ID(int manufacturer_ID) {
		Manufacturer_ID = manufacturer_ID;
	}
}
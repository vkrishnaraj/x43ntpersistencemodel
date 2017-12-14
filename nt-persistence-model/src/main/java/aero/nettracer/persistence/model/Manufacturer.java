package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "manufacturer")
public class Manufacturer {

	private int Manufacturer_ID;
	private String description;

	@Id
	@GeneratedValue
	@Column(name = "manufacturer_id")
	public int getManufacturer_ID() {
		return Manufacturer_ID;
	}

	public void setManufacturer_ID(int manufacturer_ID) {
		Manufacturer_ID = manufacturer_ID;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
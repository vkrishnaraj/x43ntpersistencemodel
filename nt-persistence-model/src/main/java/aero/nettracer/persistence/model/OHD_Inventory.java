package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ohd_inventory")
public class OHD_Inventory {

	private long id;
	private OHD ohd;
	private int OHD_categorytype_ID = 0;
	private String description = "";

	@Id
	@GeneratedValue
	@Column(name = "ohd_inventory_id")
	public long getId() {
		return id;
	}

	public void setId(long inventory_ID) {
		id = inventory_ID;
	}

	@ManyToOne
	@JoinColumn(name = "ohd_id")
	public OHD getOhd() {
		return ohd;
	}

	public void setOhd(OHD ohd) {
		this.ohd = ohd;
	}

	@Column(name = "ohd_categorytype_id")
	public int getOHD_categorytype_ID() {
		return OHD_categorytype_ID;
	}

	public void setOHD_categorytype_ID(int ohd_categorytype_id) {
		OHD_categorytype_ID = ohd_categorytype_id;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
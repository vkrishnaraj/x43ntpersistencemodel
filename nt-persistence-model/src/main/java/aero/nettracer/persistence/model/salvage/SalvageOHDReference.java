package aero.nettracer.persistence.model.salvage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salvage_ohd_reference")
public class SalvageOHDReference {
	
	private int id;
	private String ohdId;
	private Salvage salvage;

	@Id
	@GeneratedValue
	@Column(name="ohd_ref_id")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="ohd_id", nullable=false)
	public String getOhdId() {
		return ohdId;
	}

	public void setOhdId(String ohdId) {
		this.ohdId = ohdId;
	}

	@ManyToOne
	@JoinColumn(name = "salvage_id")
	public Salvage getSalvage() {
		return salvage;
	}

	public void setSalvage(Salvage salvage) {
		this.salvage = salvage;
	}

}

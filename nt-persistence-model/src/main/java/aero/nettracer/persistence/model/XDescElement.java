package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "xdescelement")
public class XDescElement {

	private int id;
	private String code;
	private String description;

	private String MSG_KEY = "DESCELEMENT_";

	@Id
	@GeneratedValue
	@Column(name = "xdesc_id")
	public int getId() {
		return id;
	}

	public void setId(int desc_ID) {
		id = desc_ID;
	}

	@Column(name = "code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Transient
	public String getKey() {
		return MSG_KEY + code;
	}

}
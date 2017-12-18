package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "priority")
public class Priority {

	private int id;
	private String description;
	private String MSG_KEY = "PRIORITY_KEY_";

	@Id
	@GeneratedValue
	@Column(name = "priority_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return MSG_KEY + id;
	}
}
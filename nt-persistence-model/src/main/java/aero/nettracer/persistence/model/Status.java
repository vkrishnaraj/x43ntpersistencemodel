package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "status")
public class Status {
	
	private static String MSG_KEY = "STATUS_KEY_";

	private int id;
	private String description;
	private int table_ID;

	public Status() { }

	public Status(int id) {
		this.id = id;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "status_id")
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

	@Column(name = "table_id")
	public int getTable_ID() {
		return table_ID;
	}

	public void setTable_ID(int table_ID) {
		this.table_ID = table_ID;
	}

	@Transient
	public String getKey() {
		return MSG_KEY + id;
	}
	
	public static String getKey(int id) {
		return MSG_KEY + id;
	}

}
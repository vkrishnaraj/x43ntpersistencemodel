package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "permission")
public class SystemPermission {

	private int id;
	private String permission_name;
	private String permission_desc;

	@Id
	@GeneratedValue
	@Column(name = "permission_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "permission_name")
	public String getPermission_name() {
		return permission_name;
	}

	public void setPermission_name(String permission_name) {
		this.permission_name = permission_name;
	}

	@Column(name = "permission_desc")
	public String getPermission_desc() {
		return permission_desc;
	}

	public void setPermission_desc(String permission_desc) {
		this.permission_desc = permission_desc;
	}

}
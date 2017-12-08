package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Permission")
public class SystemPermission implements Serializable {
	private int permission_id;
	private String permission_name;
	private String permission_desc;

	public String getPermission_desc() {
		return permission_desc;
	}

	public void setPermission_desc(String permission_desc) {
		this.permission_desc = permission_desc;
	}

	@Id
	@GeneratedValue
	public int getPermission_id() {
		return permission_id;
	}

	public void setPermission_id(int permission_id) {
		this.permission_id = permission_id;
	}

	public String getPermission_name() {
		return permission_name;
	}

	public void setPermission_name(String permission_name) {
		this.permission_name = permission_name;
	}


	public String toString() {
		StringBuffer sb = new StringBuffer(200);
		sb.append("SystemPermission ID=" + this.getPermission_id() + " Name="
				+ this.getPermission_name() + " Description=" + this.getPermission_desc());
		return sb.toString();
	}
}
package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "webservice_session")
public class Webservice_Session {

	private int id;
	private String username;
	private String companycode_id;
	private String session_id;
	private Timestamp date_active;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "companycode_id")
	public String getCompanycode_id() {
		return companycode_id;
	}

	public void setCompanycode_id(String companycode_id) {
		this.companycode_id = companycode_id;
	}

	@Column(name = "session_id")
	public String getSession_id() {
		return session_id;
	}

	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	@Column(name = "date_active")
	public Timestamp getDate_active() {
		return date_active;
	}

	public void setDate_active(Timestamp date_active) {
		this.date_active = date_active;
	}

}

package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "webservice_session")
public class Webservice_Session implements Serializable{
	private int id;
	private String username;
	private String companycode_id;
	private String session_id;
	private Date date_active;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCompanycode_id() {
		return companycode_id;
	}

	public void setCompanycode_id(String companycode_id) {
		this.companycode_id = companycode_id;
	}

	public String getSession_id() {
		return session_id;
	}

	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	public Date getDate_active() {
		return date_active;
	}

	public void setDate_active(Date date_active) {
		this.date_active = date_active;
	}
	
	
}

package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usergroupnamemap")
public class UsergroupNameMap {

	private long id;
	private String ldapName;
	private String ntName;
	private int ntGroupId;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "ldapname")
	public String getLdapName() {
		return ldapName;
	}

	public void setLdapName(String ldapName) {
		this.ldapName = ldapName;
	}

	@Column(name = "ntname")
	public String getNtName() {
		return ntName;
	}

	public void setNtName(String ntName) {
		this.ntName = ntName;
	}

	@Column(name = "ntGroupId")
	public int getNtGroupId() {
		return ntGroupId;
	}

	public void setNtGroupId(int ntGroupId) {
		this.ntGroupId = ntGroupId;
	}

}

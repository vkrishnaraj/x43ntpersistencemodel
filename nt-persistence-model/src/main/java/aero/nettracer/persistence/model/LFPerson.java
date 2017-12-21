package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
public class LFPerson implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7228145418177131087L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="last_name",length = 32)
	private String lastName;
	
	@Column(name="first_name",length = 32)
	private String firstName;
	
	@Column(name="middle_name",length = 32)
	private String middleName;
	
	@Column(name="email",length = 128)
	private String email;

	@Column(name="secondary_email",length = 128)
	private String secondaryEmail;
	
	@OneToOne(targetEntity = aero.nettracer.persistence.model.LFAddress.class, cascade = CascadeType.ALL)
	private LFAddress address;
	
	@SuppressWarnings("deprecation")
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderBy(clause = "id")
	@Fetch(FetchMode.SELECT)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<LFPhone> phones;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public LFAddress getAddress() {
		return address;
	}

	public void setAddress(LFAddress address) {
		this.address = address;
	}

	public List<LFPhone> getPhones() {
		return phones;
	}

	public void setPhones(List<LFPhone> phones) {
		this.phones = phones;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}

	//TODO this should be refactored NT-6064
	public boolean isEmpty() {
		boolean empty = true;
		
		if (getEmail() != null && !getEmail().isEmpty()) {
			empty = false;
		}
		
		if (empty) {
			empty = address.isEmpty();
		}
		
		if (empty) {
			for (LFPhone p: phones) {
				empty = p.isEmpty();
				if (!empty) {
					break;
				}
			}
		}
		
		return empty;
	}
	
	public boolean hasAddress() {
		return getAddress() != null;
	}
	
}

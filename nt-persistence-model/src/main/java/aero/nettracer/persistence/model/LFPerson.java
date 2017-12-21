package aero.nettracer.persistence.model;

import org.hibernate.annotations.OrderBy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "lfperson")
public class LFPerson {

	private long id;
	private String lastName;
	private String firstName;
	private String middleName;
	private String email;
	private LFAddress address;
	private String secondaryEmail;
	private List<LFPhone> phones;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name="first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="middle_name")
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToOne(cascade = CascadeType.ALL)
	public LFAddress getAddress() {
		return address;
	}

	public void setAddress(LFAddress address) {
		this.address = address;
	}

	@Column(name="secondary_email")
	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy(clause = "id")
	public List<LFPhone> getPhones() {
		return phones;
	}

	public void setPhones(List<LFPhone> phones) {
		this.phones = phones;
	}

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

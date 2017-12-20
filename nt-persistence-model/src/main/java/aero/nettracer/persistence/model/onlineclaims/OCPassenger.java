package aero.nettracer.persistence.model.onlineclaims;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "oc_passenger")
public class OCPassenger {

	private long id;
	private OnlineClaim claim;
	private String accept;
	private String firstName;
	private String lastName;
	private String middleInitial;
	private String salutation;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "claimid", nullable = false)
	public OnlineClaim getClaim() {
		return claim;
	}

	public void setClaim(OnlineClaim claim) {
		this.claim = claim;
	}

	@Column(name = "accept")
	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	@Column(name = "firstname")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastname")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "middleinitial")
	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	@Column(name = "salutation")
	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

}

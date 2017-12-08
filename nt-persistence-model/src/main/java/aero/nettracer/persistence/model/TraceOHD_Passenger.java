package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "OHD_Passenger")
public class TraceOHD_Passenger implements Serializable {

	private static final long serialVersionUID = 1L;
	public int passenger_id;
	public String firstname = "";
	public String middlename = "";
	public String lastname = "";
	public int isprimary = 1;
	public Set<TraceOHD_Address> addresses;
	private TraceOHD ohd;

	//NTFIXME
	/*@Transient
	public JRBeanCollectionDataSource getAddressesForReport() {
		if (addresses == null || addresses.size() < 1) return null;

		return new JRBeanCollectionDataSource(new ArrayList(addresses));
	}*/

	public int getIsprimary() {
		return isprimary;
	}

	public void setIsprimary(int isprimary) {
		this.isprimary = isprimary;
	}

	@ManyToOne
	@JoinColumn(name = "OHD_ID")
	public TraceOHD getOhd() {
		return ohd;
	}

	public void setOhd(TraceOHD ohd) {
		this.ohd = ohd;
	}

	@OneToMany(mappedBy = "ohd_passenger", fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "Address_ID")
	public Set<TraceOHD_Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<TraceOHD_Address> addresses) {
		this.addresses = addresses;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	@Id
	@GeneratedValue
	public int getPassenger_id() {
		return passenger_id;
	}

	public void setPassenger_id(int passenger_id) {
		this.passenger_id = passenger_id;
	}

	public TraceOHD_Address getAddress(int i) {
		if (this.getAddresses() != null && i < this.getAddresses().size()) {
			ArrayList t = new ArrayList(this.getAddresses());
			return (TraceOHD_Address) t.get(i);
		} else return null;
	}

	public void addAddress(TraceOHD_Address address) {
		if (this.getAddresses() == null) this.setAddresses(new HashSet());
		this.getAddresses().add(address);
	}

}
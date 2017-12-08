package aero.nettracer.persistence.model.audit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Audit_OHD_Passenger")
public class Audit_OHD_Passenger implements Serializable {
	private int id;
	public int passenger_id;
	public String firstname;
	public String middlename;
	public String lastname;
	public int isprimary = 1;
	public Set<Audit_OHD_Address> addresses;
	
	private Audit_OHD ohd;

	@ManyToOne
	@JoinColumn(name = "audit_ohd_id")
	public Audit_OHD getOhd() {
		return ohd;
	}

	public void setOhd(Audit_OHD ohd) {
		this.ohd = ohd;
	}
		
	@Transient
	public List getAddressList() {
		return new ArrayList((addresses != null ? addresses : new HashSet()));
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	@OneToMany(mappedBy = "audit_ohd_passenger")
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "Address_ID")
	public Set<Audit_OHD_Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Audit_OHD_Address> addresses) {
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

	public int getPassenger_id() {
		return passenger_id;
	}

	public void setPassenger_id(int passenger_id) {
		this.passenger_id = passenger_id;
	}


	public Audit_OHD_Address getAddress(int i) {
		if (this.getAddresses() != null) {
			ArrayList t = new ArrayList(this.getAddresses());
			return (Audit_OHD_Address) t.get(i);
		} else return null;
	}

	public void addAddress(Audit_OHD_Address address) {
		if (this.getAddresses() == null) this.setAddresses(new LinkedHashSet());
		this.getAddresses().add(address);
	}

	//NTFIXME
	/*public boolean equals(Object obj) {
		Audit_OHD_Passenger aoi = (Audit_OHD_Passenger) obj;
		boolean ret = true;

		if (AuditOHDUtils.notEqualObjects(aoi.getFirstname(), this.getFirstname())
				|| AuditOHDUtils.notEqualObjects(aoi.getMiddlename(), this.getMiddlename())
				|| AuditOHDUtils.notEqualObjects(aoi.getLastname(), this.getLastname())) {
			ret = false;
		} else {
			//check for the address List..
			List thisAddressList = this.getAddressList();
			List compAddressList = aoi.getAddressList();

			if (thisAddressList != compAddressList) {
				if (thisAddressList == null || compAddressList == null) ret = false;
				else if (thisAddressList.size() != compAddressList.size()) ret = false;
				else {
					//Size of the sets are equal; compare each item.
					for (int j = 0; j < thisAddressList.size(); j++) {
						Audit_OHD_Address addr1 = (Audit_OHD_Address) thisAddressList.get(j);
						Audit_OHD_Address addr2 = (Audit_OHD_Address) compAddressList.get(j);

						if (AuditOHDUtils.notEqualObjects(addr1, addr2)) {
							ret = false;
						}
					}
				}
			}
		}
		return ret;
	}*/

}
package aero.nettracer.persistence.model;

import aero.nettracer.persistence.util.Phone;
import org.hibernate.annotations.OrderBy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ohd_passenger")
public class OHD_Passenger {

	public int id;
	public String firstname = "";
	public String middlename = "";
	public String lastname = "";
	private OHD ohd;
	public int isprimary = 1;
	public Set<OHD_Address> addresses;
	private long sortId;

	public OHD_Passenger() {
		sortId = System.nanoTime();
	}

	@Id
	@GeneratedValue
	@Column(name = "passenger_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "firstname")
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "middlename")
	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	@Column(name = "lastname")
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@ManyToOne
	@JoinColumn(name = "OHD_ID")
	public OHD getOhd() {
		return ohd;
	}

	public void setOhd(OHD ohd) {
		this.ohd = ohd;
	}

	@Column(name = "isprimary")
	public int getIsprimary() {
		return isprimary;
	}

	public void setIsprimary(int isprimary) {
		this.isprimary = isprimary;
	}


	@OneToMany(mappedBy = "ohd_passenger", cascade = CascadeType.ALL)
	@OrderBy(clause = "address_id")
	public Set<OHD_Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<OHD_Address> addresses) {
		this.addresses = addresses;
	}


	@Transient
	public long getSortId() {
		return sortId;
	}

	public OHD_Address getAddress(int i) {
		if (this.getAddresses() != null && i < this.getAddresses().size()) {
			ArrayList t = new ArrayList(this.getAddresses());
			return (OHD_Address) t.get(i);
		} else return null;
	}

	public void addAddress(OHD_Address address) {
		if (this.getAddresses() == null) this.setAddresses(new HashSet());
		this.getAddresses().add(address);
	}

	@Transient
	public List<Phone> getPhoneList(){
		ArrayList<Phone> phones = new ArrayList<Phone>();
		
		if(addresses != null){
			for(OHD_Address address:addresses){
				if(address.getAltphone() != null && !address.getAltphone().isEmpty()){
					Phone phone = new Phone();
					phone.setPhoneNumber(address.getAltphone());
					phone.setPhoneType(Phone.PhoneType.ALT);
					phones.add(phone);
				}
				if(address.getHomephone() != null && !address.getHomephone().isEmpty()){
					Phone phone = new Phone();
					phone.setPhoneNumber(address.getHomephone());
					phone.setPhoneType(Phone.PhoneType.HOME);
					phones.add(phone);
				}
				if(address.getMobile() != null && !address.getMobile().isEmpty()){
					Phone phone = new Phone();
					phone.setPhoneNumber(address.getMobile());
					phone.setPhoneType(Phone.PhoneType.MOBILE);
					phones.add(phone);
				}
				if(address.getWorkphone() != null && !address.getWorkphone().isEmpty()){
					Phone phone = new Phone();
					phone.setPhoneNumber(address.getWorkphone());
					phone.setPhoneType(Phone.PhoneType.WORK);
					phones.add(phone);
				}
				if(address.getPager() != null && !address.getPager().isEmpty()){
					Phone phone = new Phone();
					phone.setPhoneNumber(address.getPager());
					phone.setPhoneType(Phone.PhoneType.PAGER);
					phones.add(phone);
				}
			}
		}
		
		return phones;
	}

	public void setPhoneList(List<Phone>phones){
		//DO NOTHING, will need to implement when we implement receiving service incident
		//DO NOT DELETE. It will break dozer
	}

}
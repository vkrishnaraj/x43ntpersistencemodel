package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import aero.nettracer.persistence.util.Phone;
import com.cci.utils.parser.ElementNode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "OHD_Passenger")
public class OHD_Passenger implements Serializable {

	public OHD_Passenger() {
		sortId = System.nanoTime();
	}

	private long sortId;

	public int passenger_id;
	public String firstname = "";
	public String middlename = "";
	public String lastname = "";
	public int isprimary = 1;
	public Set<OHD_Address> addresses;

	private OHD ohd;

	public String toXML() {

		StringBuffer sb = new StringBuffer();
		sb.append("<passenger>");
		sb.append("<Passenger_ID>" + passenger_id + "</Passenger_ID>");
		sb.append("<firstname>" + firstname + "</firstname>");
		sb.append("<middlename>" + middlename + "</middlename>");
		sb.append("<lastname>" + lastname + "</lastname>");
		sb.append("<isprimary>" + isprimary + "</isprimary>");
		sb.append("<addresses>");
		if (getAddresses() != null && getAddresses().size() > 0) {
			for (Iterator j = getAddresses().iterator(); j.hasNext();) {
				OHD_Address addr = (OHD_Address) j.next();
				sb.append(addr.toXML());
			}
		}
		sb.append("</addresses>");
		sb.append("</passenger>");
		return sb.toString();
	}


	public static OHD_Passenger XMLtoObject(ElementNode root) {
		OHD_Passenger obj = new OHD_Passenger();

		ElementNode child = null, grandchild = null, ggrandchild = null, gggrandchild = null;

		for (ListIterator i = root.get_children().listIterator(); i.hasNext();) {
			child = (ElementNode) i.next();
			if (child.getType().equals("Passenger_ID")) {
				obj.setPassenger_id(parseInt(child.getTextContents()));
			} else if (child.getType().equals("firstname")) {
				obj.setFirstname(child.getTextContents());
			} else if (child.getType().equals("middlename")) {
				obj.setMiddlename(child.getTextContents());
			} else if (child.getType().equals("lastname")) {
				obj.setLastname(child.getTextContents());
			} else if (child.getType().equals("isprimary")) {
				obj.setIsprimary(parseInt(child.getTextContents()));
			}else if (child.getType().equals("addresses")) {
				ArrayList al = new ArrayList();
				ArrayList c = (ArrayList)child.getChildren();
				for (int z=0;z<c.size();z++) {
					al.add(OHD_Address.XMLtoObject((ElementNode)c.get(z)));
				}
				obj.setAddresses(new HashSet(al));
			}
		}

		return obj;
	}

	@Transient
	public long getSortId() {
		return sortId;
	}

	public int getIsprimary() {
		return isprimary;
	}

	public void setIsprimary(int isprimary) {
		this.isprimary = isprimary;
	}

	@ManyToOne
	@JoinColumn(name = "OHD_ID")
	public OHD getOhd() {
		return ohd;
	}

	public void setOhd(OHD ohd) {
		this.ohd = ohd;
	}

	@OneToMany(mappedBy = "ohd_passenger", fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "Address_ID")
	public Set<OHD_Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<OHD_Address> addresses) {
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

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Passenger ID=" + this.getPassenger_id());
		sb.append(" Firstname=" + this.getFirstname());
		sb.append(" Middlename=" + this.getMiddlename());
		sb.append(" Lastname=" + this.getLastname());
		sb.append(" IsPrimary=" + this.getIsprimary());
		if (this.getAddresses() != null) {
			for (Iterator i = this.getAddresses().iterator(); i.hasNext();) {
				OHD_Address address = (OHD_Address) i.next();
				//System.out.println(address);
			}
		}
		return sb.toString();
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

	public static int parseInt(String s) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return 0;
		}
	}

}
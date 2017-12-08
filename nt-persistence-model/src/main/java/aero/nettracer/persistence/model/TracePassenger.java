package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;

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
@Table(name = "Passenger")
public class TracePassenger implements Serializable {
	private int Passenger_ID;
	private String jobtitle;
	private int salutation;
	private String firstname;
	private String middlename;
	private String lastname;
	private String driverslicense;
	private String dlstate;
	private String commonnum;
	private String countryofissue;
	private int isprimary;
	private AirlineMembership membership;
	private Set<TraceAddress> addresses;
	private TraceIncident incident;

	public String toXML() {
		StringBuffer sb = new StringBuffer();

		sb.append("<passenger>");
		sb.append("<Passenger_ID>" + Passenger_ID + "</Passenger_ID>");
		sb.append("<firstname>" + firstname + "</firstname>");
		sb.append("<middlename>" + middlename + "</middlename>");
		sb.append("<lastname>" + lastname + "</lastname>");
		sb.append("<isprimary>" + isprimary + "</isprimary>");
		sb.append("<jobtitle>" + jobtitle + "</jobtitle>");
		sb.append("<salutation>" + salutation + "</salutation>");
		sb.append("<driverslicense>" + driverslicense + "</driverslicense>");
		sb.append("<dlstate>" + dlstate + "</dlstate>");
		sb.append("<commonnumber>" + commonnum + "</commonnumber>");
		sb.append("<countryofissue>" + countryofissue + "</countryofissue>");
		if (membership == null) {
			sb.append("<airlinemembership></airlinemembership><airlinemembership_company></airlinemembership_company>");
		} else {
			sb.append("<airlinemembership>" + membership.getMembershipnum() + "</airlinemembership>");
			sb.append("<airlinemembership_company>" + membership.getCompanycode_ID()
					+ "</airlinemembership_company>");
		}
		sb.append("<addresses>");
		if (getAddresses() != null && getAddresses().size() > 0) {
			for (Iterator j = getAddresses().iterator(); j.hasNext();) {
				Address addr = (Address) j.next();
				sb.append(addr.toXML());
			}
		}
		sb.append("</addresses>");

		sb.append("</passenger>");
		return sb.toString();
	}

	public static Passenger XMLtoObject(ElementNode root) {
		Passenger obj = new Passenger();

		ElementNode child = null, grandchild = null, ggrandchild = null, gggrandchild = null;
		AirlineMembership am = new AirlineMembership();


		for (ListIterator i = root.get_children().listIterator(); i.hasNext();) {
			child = (ElementNode) i.next();
			if (child.getType().equals("Passenger_ID")) {
				obj.setPassenger_ID(parseInt(child.getTextContents()));
			} else if (child.getType().equals("firstname")) {
				obj.setFirstname(child.getTextContents());
			} else if (child.getType().equals("middlename")) {
				obj.setMiddlename(child.getTextContents());
			} else if (child.getType().equals("lastname")) {
				obj.setLastname(child.getTextContents());
			} else if (child.getType().equals("isprimary")) {
				obj.setIsprimary(parseInt(child.getTextContents()));
			} else if (child.getType().equals("jobtitle")) {
				obj.setJobtitle(child.getTextContents());
			} else if (child.getType().equals("salutation")) {
				obj.setSalutation(parseInt(child.getTextContents()));
			} else if (child.getType().equals("driverslicense")) {
				obj.setDriverslicense(child.getTextContents());
			} else if (child.getType().equals("dlstate")) {
				obj.setDlstate(child.getTextContents());
			} else if (child.getType().equals("commonnumber")) {
				obj.setCommonnum(child.getTextContents());
			} else if (child.getType().equals("countryofissue")) {
				obj.setCountryofissue(child.getTextContents());
			} else if (child.getType().equals("airlinemembership")) {
				am.setMembershipnum(child.getTextContents());
			} else if (child.getType().equals("airlinemembership_company")) {
				am.setCompanycode_ID(child.getTextContents());
			} else if (child.getType().equals("addresses")) {
				ArrayList al = new ArrayList();
				ArrayList c = (ArrayList)child.getChildren();
				for (int z=0;z<c.size();z++) {
					al.add(Address.XMLtoObject((ElementNode)c.get(z)));
				}
				obj.setAddresses(new HashSet(al));
			}
			obj.setMembership(am);

		}

		return obj;
	}

	//NTFIXME
	/*@Transient
	public String getDispcountryofissue() {
		if (countryofissue != null && countryofissue.length() > 0) {
			return TracerUtils.getCountry(countryofissue).getCountry();
		}
		return "";
	}*/

	@Transient
	public String getAirlinememcompany() {
		String ret = "";

		if (membership != null && membership.getCompanycode_ID() != null) {
			ret = membership.getCompanycode_ID();
		}

		return ret;
	}

	@Transient
	public String getAirlinememstatus() {
		String ret = "";

		if (membership != null && membership.getMembershipstatus() != null) ret = membership
				.getMembershipstatus();

		return ret;
	}

	@Transient
	public String getAirlinememnumber() {
		String ret = "";

		if (membership != null && membership.getMembershipnum() != null) ret = membership
				.getMembershipnum();

		return ret;
	}

	@ManyToOne
	@JoinColumn(name = "membership_ID")
	@Cascade(CascadeType.ALL)
	public AirlineMembership getMembership() {
		return membership;
	}

	public void setMembership(AirlineMembership membership) {
		this.membership = membership;
	}

	@OneToMany(mappedBy = "passenger", fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "address_ID")
	public Set<TraceAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<TraceAddress> addresses) {
		this.addresses = addresses;
	}

	@ManyToOne
	@JoinColumn(name = "incident_ID")
	public TraceIncident getIncident() {
		return incident;
	}

	public void setIncident(TraceIncident incident) {
		this.incident = incident;
	}

	public String getCommonnum() {
		return commonnum;
	}

	public void setCommonnum(String commonnum) {
		this.commonnum = commonnum;
	}

	public String getCountryofissue() {
		return countryofissue;
	}

	public void setCountryofissue(String countryofissue) {
		this.countryofissue = countryofissue;
	}


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
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

	public String getDlstate() {
		return dlstate;
	}

	public void setDlstate(String dlstate) {
		this.dlstate = dlstate;
	}

	//NTFIXME
	/*@Transient
	public String getDispdlstate() {
		if (dlstate != null && dlstate.length() > 0) {
			return TracerUtils.getState(dlstate).getState();
		}
		return "";
	}*/

	public String getDriverslicense() {
		return driverslicense;
	}

	public void setDriverslicense(String driverslicense) {
		this.driverslicense = driverslicense;
	}

	@Id
	@GeneratedValue
	public int getPassenger_ID() {
		return Passenger_ID;
	}

	public void setPassenger_ID(int passenger_ID) {
		Passenger_ID = passenger_ID;
	}

	public int getSalutation() {
		return salutation;
	}

	@Transient
	public String getSalutationdesc() {
		switch (getSalutation()) {
			case 0: return "Please Select";
			case 1: return "Dr.";
			case 2: return "Mr.";
			case 3: return "Ms.";
			case 4: return "Miss.";
			case 5: return "Mrs.";
			case 6: return "Other";
		}
		return "";
	}

	@Transient
	public String getDispsalutation() {
		return getSalutationdesc();
	}


	public void setSalutation(int salutation) {
		this.salutation = salutation;
	}

	public int getIsprimary() {
		return isprimary;
	}

	public void setIsprimary(int isprimary) {
		this.isprimary = isprimary;
	}

	public Address getAddress(int i) {
		if (this.getAddresses() != null) {
			ArrayList t = new ArrayList(this.getAddresses());
			while (t.size() <= i) {
				TraceAddress adddd = new TraceAddress();
				adddd.setPassenger(this);
				addAddress(adddd);
				t = new ArrayList(this.getAddresses());
			}
			return (Address) t.get(i);
		} else return null;
	}

	public void addAddress(TraceAddress address) {
		if (this.getAddresses() == null) this.setAddresses(new HashSet());
		this.getAddresses().add(address);
	}

	private static int parseInt(String s) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return 0;
		}
	}

}
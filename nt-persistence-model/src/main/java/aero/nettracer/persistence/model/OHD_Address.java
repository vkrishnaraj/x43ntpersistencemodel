package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.ListIterator;

import com.cci.utils.parser.ElementNode;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "OHD_Address")
public class OHD_Address implements Serializable {
	
	private int Address_ID;
	private String address1 = "";
	private String address2 = "";
	private String zip = "";
	private String homephone = "";
	private String workphone = "";
	private String mobile = "";
	private String pager = "";
	private String city = "";
	private String altphone = "";
	private String email = "";
	private int addresstype;
	private String state_ID = "";
	private String countrycode_ID = "";
	private String province = "";
	private OHD_Passenger ohd_passenger;

	public String toXML() {
		StringBuffer sb = new StringBuffer();

		sb.append("<address>");
		sb.append("<Address_ID>" + getAddress_ID() + "</Address_ID>");
		sb.append("<address1>" + getAddress1() + "</address1>");
		sb.append("<address2>" + getAddress2() + "</address2>");
		sb.append("<city>" + getCity() + "</city>");
		sb.append("<state_ID>" + getState_ID() + "</state_ID>");
		sb.append("<province>" + getProvince() + "</province>");
		sb.append("<zip>" + getZip() + "</zip>");
		sb.append("<countrycode_ID>" + getCountrycode_ID() + "</countrycode_ID>");
		sb.append("<homephone>" + getHomephone() + "</homephone>");
		sb.append("<workphone>" + getWorkphone() + "</workphone>");
		sb.append("<mobile>" + getMobile() + "</mobile>");
		sb.append("<pager>" + getPager() + "</pager>");
		sb.append("<altphone>" + getAltphone() + "</altphone>");
		sb.append("<email>" + getEmail() + "</email>");
		sb.append("</address>");

		return sb.toString();
	}

	/*//NTFIXME
	@Transient
	public String getState() {
		if (state_ID != null && state_ID.length() > 0) {
			return TracerUtils.getState(state_ID).getState();
		}
		return "";
	}*/

	//NTFIXME
	@Transient
	/*public String getCountry() {
		if (countrycode_ID != null && countrycode_ID.length() > 0) {
			return TracerUtils.getCountry(countrycode_ID).getCountry();
		}
		return "";
	}*/

	public String getCountrycode_ID() {
		return countrycode_ID;
	}

	public void setCountrycode_ID(String countrycode_ID) {
		this.countrycode_ID = countrycode_ID;
	}

	public String getState_ID() {
		return state_ID;
	}

	public void setState_ID(String state_ID) {
		this.state_ID = state_ID;
	}

	public int getAddresstype() {
		return addresstype;
	}

	public void setAddresstype(int addresstype) {
		this.addresstype = addresstype;
	}

	@Id
	@GeneratedValue
	public int getAddress_ID() {
		return Address_ID;
	}

	public void setAddress_ID(int address_ID) {
		Address_ID = address_ID;
	}

	@ManyToOne
	@JoinColumn(name = "passenger_id")
	public OHD_Passenger getOhd_passenger() {
		return ohd_passenger;
	}

	public void setOhd_passenger(OHD_Passenger ohd_passenger) {
		this.ohd_passenger = ohd_passenger;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAltphone() {
		return altphone;
	}

	public void setAltphone(String altphone) {
		this.altphone = altphone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomephone() {
		return homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPager() {
		return pager;
	}

	public void setPager(String pager) {
		this.pager = pager;
	}

	public String getWorkphone() {
		return workphone;
	}

	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer(512);
		sb.append("Address ID=" + this.getAddress_ID());
		sb.append(" address1=" + this.getAddress1());
		sb.append(" address2=" + this.getAddress2());
		sb.append(" city=" + this.getCity());
		sb.append(" zip=" + this.getZip());
		sb.append(" homephone=" + this.getHomephone());
		sb.append(" workphone=" + this.getWorkphone());
		sb.append(" mobile=" + this.getMobile());
		sb.append(" pager=" + this.getPager());
		sb.append(" altphone=" + this.getAltphone());
		sb.append(" email=" + this.getEmail());
		sb.append(" addresstype=" + this.getAddresstype());
		sb.append(" state_ID=" + this.getState_ID());
		sb.append(" countrycode_ID=" + this.getCountrycode_ID());
		return sb.toString();
	}

	public static OHD_Address XMLtoObject(ElementNode root) {
		OHD_Address obj = new OHD_Address();

		ElementNode child = null, grandchild = null, ggrandchild = null, gggrandchild = null;

		boolean break_main = false;

		for (ListIterator i = root.get_children().listIterator(); i.hasNext();) {
			child = (ElementNode) i.next();
			if (child.getType().equals("Address_ID")) {
				obj.setAddress_ID(parseInt(child.getTextContents()));
			} else if (child.getType().equals("address1")) {
				obj.setAddress1(child.getTextContents());
			} else if (child.getType().equals("address2")) {
				obj.setAddress2(child.getTextContents());
			} else if (child.getType().equals("city")) {
				obj.setCity(child.getTextContents());
			} else if (child.getType().equals("state_ID")) {
				obj.setState_ID(child.getTextContents());
			} else if (child.getType().equals("province")) {
				obj.setProvince(child.getTextContents());
			} else if (child.getType().equals("zip")) {
				obj.setZip(child.getTextContents());
			} else if (child.getType().equals("countrycode_ID")) {
				obj.setCountrycode_ID(child.getTextContents());
			} else if (child.getType().equals("homephone")) {
				obj.setHomephone(child.getTextContents());
			} else if (child.getType().equals("workphone")) {
				obj.setWorkphone(child.getTextContents());
			} else if (child.getType().equals("mobile")) {
				obj.setMobile(child.getTextContents());
			} else if (child.getType().equals("pager")) {
				obj.setPager(child.getTextContents());
			} else if (child.getType().equals("altphone")) {
				obj.setAltphone(child.getTextContents());
			} else if (child.getType().equals("email")) {
				obj.setEmail(child.getTextContents());
			}
		}
		return obj;
	}

	public static int parseInt(String s) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return 0;
		}
	}
	
}
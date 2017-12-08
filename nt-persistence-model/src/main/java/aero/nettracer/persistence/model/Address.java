package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.ListIterator;

import aero.nettracer.commons.constant.GenericConstants;
import aero.nettracer.commons.utils.GenericDateUtils;
import com.cci.utils.parser.ElementNode;
import com.cci.utils.parser.XMLParser;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "address")
public class Address implements Serializable {
	private int Address_ID;

	private String address1;
	private String address2;
	private String city;
	private String zip;
	private String hotel;
	private String hotelphone;
	private String homephone;
	private String workphone;
	private String mobile;
	private String pager;
	private String altphone;
	private String email;
	private int addresstype;
	private boolean permanent;
	private String state_ID;
	private String countrycode_ID;
	private String province;
	private String homephone_norm;
	private String workphone_norm;
	private String mobile_norm;
	private String pager_norm;
	private String altphone_norm;

	private Date valid_bdate;
	private Date valid_edate;

	private Passenger passenger;

	private String _DATEFORMAT; //for date time format purpose only, not

	private String country;

	/*@Transient
	public String getState() {
		if (state_ID != null && state_ID.length() > 0) {
			return TracerUtils.getState(state_ID).getState();
		}
		return "";
	}*/
	@Transient
	public String getCountry() {
		/*if (countrycode_ID != null && countrycode_ID.length() > 0) {
			return TracerUtils.getCountry(countrycode_ID).getCountry();
		}
		return "";*/
		return (country == null)? "" :country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@ManyToOne
	@JoinColumn(name = "Passenger_ID")
	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	

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

	@Column(name = "is_permanent")
	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	@Id
	@GeneratedValue
	public int getAddress_ID() {
		return Address_ID;
	}

	public void setAddress_ID(int address_ID) {
		Address_ID = address_ID;
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

	public String getHotelphone() {
		return hotelphone;
	}

	public void setHotelphone(String hotelphone) {
		this.hotelphone = hotelphone;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
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

	public Date getValid_bdate() {
		return valid_bdate;
	}

	public void setValid_bdate(Date valid_bdate) {
		this.valid_bdate = valid_bdate;
	}

	@Transient
	public String getDispvalid_bdate() {
		return GenericDateUtils.formatDate(getValid_bdate(), get_DATEFORMAT(), null, null);
	}

	public void setDispvalid_bdate(String s) {
		setValid_bdate(GenericDateUtils.convertToDate(s, get_DATEFORMAT(), null));
	}

	public Date getValid_edate() {
		return valid_edate;
	}

	public void setValid_edate(Date valid_edate) {
		this.valid_edate = valid_edate;
	}

	@Transient
	public String getDispvalid_edate() {
		return GenericDateUtils.formatDate(getValid_edate(), get_DATEFORMAT(), null, null);
	}

	public void setDispvalid_edate(String s) {
		setValid_edate(GenericDateUtils.convertToDate(s, get_DATEFORMAT(), null));
	}

	public String getHomephone_norm() {
		return homephone_norm;
	}

	public void setHomephone_norm(String homephone_norm) {
		this.homephone_norm = homephone_norm;
	}

	public String getWorkphone_norm() {
		return workphone_norm;
	}

	public void setWorkphone_norm(String workphone_norm) {
		this.workphone_norm = workphone_norm;
	}

	public String getMobile_norm() {
		return mobile_norm;
	}

	public void setMobile_norm(String mobile_norm) {
		this.mobile_norm = mobile_norm;
	}

	public String getPager_norm() {
		return pager_norm;
	}

	public void setPager_norm(String pager_norm) {
		this.pager_norm = pager_norm;
	}

	public String getAltphone_norm() {
		return altphone_norm;
	}

	public void setAltphone_norm(String altphone_norm) {
		this.altphone_norm = altphone_norm;
	}

	@Transient
	public String get_DATEFORMAT() {
		return _DATEFORMAT;
	}

	public void set_DATEFORMAT(String _dateformat) {
		_DATEFORMAT = _dateformat;
	}

	public String toXML() {
		StringBuffer sb = new StringBuffer();

		sb.append("<address>");
		sb.append("<Address_ID>" + getAddress_ID() + "</Address_ID>");
		sb.append("<address1>" + getAddress1() + "</address1>");
		sb.append("<address2>" + getAddress2() + "</address2>");
		sb.append("<city>" + getCity() + "</city>");
		sb.append("<state_ID>" + getState_ID() + "</state_ID>");
		sb.append("<province>" + getProvince() + "</province>");
		sb.append("<hotel>" + getHotel() + "</hotel>");
		sb.append("<zip>" + getZip() + "</zip>");
		sb.append("<countrycode_ID>" + getCountrycode_ID() + "</countrycode_ID>");
		sb.append("<homephone>" + getHomephone() + "</homephone>");
		sb.append("<workphone>" + getWorkphone() + "</workphone>");
		sb.append("<mobile>" + getMobile() + "</mobile>");
		sb.append("<pager>" + getPager() + "</pager>");
		sb.append("<altphone>" + getAltphone() + "</altphone>");
		sb.append("<email>" + getEmail() + "</email>");
		sb.append("<valid_bdate>" + (valid_bdate != null ? valid_bdate.toString() : "")
				+ "</valid_bdate>");
		sb.append("<valid_edate>" + (valid_edate != null ? valid_edate.toString() : "")
				+ "</valid_edate>");

		sb.append("</address>");

		return sb.toString();
	}

	public static Address XMLtoObject(ElementNode root) {
		Address obj = new Address();

		XMLParser parser = null;

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
			} else if (child.getType().equals("hotel")) {
				obj.setHotel(child.getTextContents());
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
			} else if (child.getType().equals("valid_bdate")) {
				obj.setValid_bdate(GenericDateUtils.convertToDate(child.getTextContents(),
						GenericConstants.DB_DATEFORMAT, null));
			} else if (child.getType().equals("valid_edate")) {
				obj.setValid_edate(GenericDateUtils.convertToDate(child.getTextContents(),
						GenericConstants.DB_DATEFORMAT, null));
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
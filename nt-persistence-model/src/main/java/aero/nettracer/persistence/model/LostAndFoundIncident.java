package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;

import aero.nettracer.commons.utils.GenericDateUtils;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "lost_found")
public class LostAndFoundIncident implements Serializable {

	private String file_ref_number;
	private Agent filing_agent;
	private String finding_agent_name;
	private String customer_firstname;
	private String customer_mname;
	private String customer_lastname;
	private String customer_address1;
	private String customer_address2;
	private String customer_city;
	private String customer_state_ID;
	private String customer_countrycode_ID;
	private String customer_province;
	private String customer_zip;
	private String customer_email;
	private String customer_tel;
	private Date create_date;
	private Date dateFoundLost;
	private String location;
	private String item_description;
	private Status disposal_status;
	private Status report_status;
	private Date close_date;
	private Agent closing_agent;
	private Station create_station;
	private int report_type;
	private int category_id;
	private int readonly;
	private String remark;
	private Set<LostAndFound_Photo> photos;

	private String languageKey;
	private String languageFreeFlow;

	private String _DATEFORMAT; // current login agent's date format
	private String _TIMEFORMAT; // current login agent's time format
	private TimeZone _TIMEZONE; // timezone

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Transient
	public String get_DATEFORMAT() {
		return _DATEFORMAT;
	}

	public void set_DATEFORMAT(String _dateformat) {
		_DATEFORMAT = _dateformat;
	}

	@Transient
	public String get_TIMEFORMAT() {
		return _TIMEFORMAT;
	}

	public void set_TIMEFORMAT(String _timeformat) {
		_TIMEFORMAT = _timeformat;
	}

	@Transient
	public TimeZone get_TIMEZONE() {
		return _TIMEZONE;
	}

	public void set_TIMEZONE(TimeZone _timezone) {
		_TIMEZONE = _timezone;
	}

	@Transient
	public String getDispCreateTime() {
		if (this.create_date != null && !this.create_date.equals("")) {
			return GenericDateUtils.formatDate(this.getCreate_date(), _DATEFORMAT + " " + _TIMEFORMAT, null,
					_TIMEZONE);
		}
		return "";
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getClose_date() {
		return close_date;
	}

	public void setClose_date(Date close_date) {
		this.close_date = close_date;
	}

	@ManyToOne
	@JoinColumn(name = "closing_agent_id")
	public Agent getClosing_agent() {
		return closing_agent;
	}

	public void setClosing_agent(Agent closing_agent) {
		this.closing_agent = closing_agent;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getCustomer_address1() {
		return customer_address1;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateFoundLost() {
		return dateFoundLost;
	}

	public void setDateFoundLost(Date dateFoundLost) {
		this.dateFoundLost = dateFoundLost;
	}

	public String getCustomer_countrycode_ID() {
		return customer_countrycode_ID;
	}

	public void setCustomer_countrycode_ID(String customer_countrycode_ID) {
		this.customer_countrycode_ID = customer_countrycode_ID;
	}

	public String getCustomer_firstname() {
		return customer_firstname;
	}

	public void setCustomer_firstname(String customer_firstname) {
		this.customer_firstname = customer_firstname;
	}

	public String getCustomer_lastname() {
		return customer_lastname;
	}

	public void setCustomer_lastname(String customer_lastname) {
		this.customer_lastname = customer_lastname;
	}

	public String getCustomer_mname() {
		return customer_mname;
	}

	public void setCustomer_mname(String customer_mname) {
		this.customer_mname = customer_mname;
	}

	public void setCustomer_address1(String customer_address1) {
		this.customer_address1 = customer_address1;
	}

	public String getCustomer_address2() {
		return customer_address2;
	}

	public void setCustomer_address2(String customer_address2) {
		this.customer_address2 = customer_address2;
	}

	public String getCustomer_city() {
		return customer_city;
	}

	public void setCustomer_city(String customer_city) {
		this.customer_city = customer_city;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_province() {
		return customer_province;
	}

	public void setCustomer_province(String customer_province) {
		this.customer_province = customer_province;
	}

	public String getCustomer_state_ID() {
		return customer_state_ID;
	}

	public void setCustomer_state_ID(String customer_state_ID) {
		this.customer_state_ID = customer_state_ID;
	}

	public String getCustomer_zip() {
		return customer_zip;
	}

	public void setCustomer_zip(String customer_zip) {
		this.customer_zip = customer_zip;
	}

	@ManyToOne
	@JoinColumn(name = "create_station_id")
	public Station getCreate_station() {
		return create_station;
	}

	public void setCreate_station(Station create_station) {
		this.create_station = create_station;
	}

	public String getCustomer_tel() {
		return customer_tel;
	}

	public void setCustomer_tel(String customer_tel) {
		this.customer_tel = customer_tel;
	}

	@ManyToOne
	@JoinColumn(name = "disposal_status_id")
	public Status getDisposal_status() {
		return disposal_status;
	}

	public void setDisposal_status(Status disposal_status) {
		this.disposal_status = disposal_status;
	}

	@Id
	public String getFile_ref_number() {
		return file_ref_number;
	}

	public void setFile_ref_number(String file_ref_number) {
		this.file_ref_number = file_ref_number;
	}

	@ManyToOne
	@JoinColumn(name = "filing_agent_id")
	public Agent getFiling_agent() {
		return filing_agent;
	}

	public void setFiling_agent(Agent filing_agent) {
		this.filing_agent = filing_agent;
	}

	public String getFinding_agent_name() {
		return finding_agent_name;
	}

	public void setFinding_agent_name(String finding_agent_name) {
		this.finding_agent_name = finding_agent_name;
	}

	public String getItem_description() {
		return item_description;
	}

	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@OneToMany(mappedBy = "lostandfoundincident")
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "Photo_ID")
	public Set<LostAndFound_Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<LostAndFound_Photo> photos) {
		this.photos = photos;
	}

	public int getReadonly() {
		return readonly;
	}

	public void setReadonly(int readonly) {
		this.readonly = readonly;
	}

	@ManyToOne
	@JoinColumn(name = "report_status_id")
	public Status getReport_status() {
		return report_status;
	}

	public void setReport_status(Status report_status) {
		this.report_status = report_status;
	}

	public int getReport_type() {
		return report_type;
	}

	public void setReport_type(int report_type) {
		this.report_type = report_type;
	}
	
	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	//NTFIXEME
	/*@Transient
	public String getState() {
		if (customer_state_ID != null && customer_state_ID.length() > 0) {
			return TracerUtils.getState(customer_state_ID).getState();
		}
		return "";
	}*/

	//NTFIXEME
	/*@Transient
	public String getCountry() {
		return TracerUtils.getCountry(getCustomer_countrycode_ID()).getCountry();
	}*/

	public String format(String val) {
		if (val == null) return " ";
		else return val + " ";
	}

	public String getLanguageKey() {
		return languageKey;
	}

	public void setLanguageKey(String languageKey) {
		this.languageKey = languageKey;
	}

	public String getLanguageFreeFlow() {
		return languageFreeFlow;
	}

	public void setLanguageFreeFlow(String languageFreeFlow) {
		this.languageFreeFlow = languageFreeFlow;
	}

}
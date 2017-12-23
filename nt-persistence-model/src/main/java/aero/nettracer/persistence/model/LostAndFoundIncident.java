package aero.nettracer.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "lost_found")
public class LostAndFoundIncident {

	private String id;
	private Agent filing_agent;
	private String finding_agent_name;
	private String customer_firstname;
	private String customer_mname;
	private String customer_lastname;
	private String customer_address1;
	private String customer_address2;
	private String customer_city;
	private String customer_state_ID;
	private String customer_province;
	private String customer_countrycode_ID;
	private String customer_zip;
	private String customer_tel;
	private String customer_email;
	private Timestamp create_date;
	private String location;
	private String item_description;
	private Status disposal_status;
	private Station create_station;
	private Timestamp close_date;
	private Status report_status;
	private Agent closing_agent;
	private String remark;
	private int report_type;
	private Timestamp dateFoundLost;
	private int category_id;
	private String languageKey;
	private String languageFreeFlow;
	private int readonly;
	private Set<LostAndFound_Photo> photos;

	@Id
	@Column(name = "file_ref_number")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "filing_agent_id")
	public Agent getFiling_agent() {
		return filing_agent;
	}

	public void setFiling_agent(Agent filing_agent) {
		this.filing_agent = filing_agent;
	}

	@Column(name = "finding_agent_name")
	public String getFinding_agent_name() {
		return finding_agent_name;
	}

	public void setFinding_agent_name(String finding_agent_name) {
		this.finding_agent_name = finding_agent_name;
	}

	@Column(name = "customer_firstname")
	public String getCustomer_firstname() {
		return customer_firstname;
	}

	public void setCustomer_firstname(String customer_firstname) {
		this.customer_firstname = customer_firstname;
	}

	@Column(name = "customer_mname")
	public String getCustomer_mname() {
		return customer_mname;
	}

	public void setCustomer_mname(String customer_mname) {
		this.customer_mname = customer_mname;
	}

	@Column(name = "customer_mname")
	public String getCustomer_lastname() {
		return customer_lastname;
	}

	public void setCustomer_lastname(String customer_lastname) {
		this.customer_lastname = customer_lastname;
	}

	@Column(name = "customer_address1")
	public String getCustomer_address1() {
		return customer_address1;
	}

	public void setCustomer_address1(String customer_address1) {
		this.customer_address1 = customer_address1;
	}

	@Column(name = "customer_address2")
	public String getCustomer_address2() {
		return customer_address2;
	}

	public void setCustomer_address2(String customer_address2) {
		this.customer_address2 = customer_address2;
	}

	@Column(name = "customer_city")
	public String getCustomer_city() {
		return customer_city;
	}

	public void setCustomer_city(String customer_city) {
		this.customer_city = customer_city;
	}

	@Column(name = "customer_state_id")
	public String getCustomer_state_ID() {
		return customer_state_ID;
	}

	public void setCustomer_state_ID(String customer_state_ID) {
		this.customer_state_ID = customer_state_ID;
	}

	@Column(name = "customer_province")
	public String getCustomer_province() {
		return customer_province;
	}

	public void setCustomer_province(String customer_province) {
		this.customer_province = customer_province;
	}

	@Column(name = "customer_countrycode_id")
	public String getCustomer_countrycode_ID() {
		return customer_countrycode_ID;
	}

	public void setCustomer_countrycode_ID(String customer_countrycode_ID) {
		this.customer_countrycode_ID = customer_countrycode_ID;
	}

	@Column(name = "customer_zip")
	public String getCustomer_zip() {
		return customer_zip;
	}

	public void setCustomer_zip(String customer_zip) {
		this.customer_zip = customer_zip;
	}

	@Column(name = "customer_tel")
	public String getCustomer_tel() {
		return customer_tel;
	}

	public void setCustomer_tel(String customer_tel) {
		this.customer_tel = customer_tel;
	}

	@Column(name = "customer_email")
	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	@Column(name = "create_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}

	@Column(name = "location")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "item_description")
	public String getItem_description() {
		return item_description;
	}

	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}

	@ManyToOne
	@JoinColumn(name = "disposal_status_id")
	public Status getDisposal_status() {
		return disposal_status;
	}

	public void setDisposal_status(Status disposal_status) {
		this.disposal_status = disposal_status;
	}

	@ManyToOne
	@JoinColumn(name = "create_station_id")
	public Station getCreate_station() {
		return create_station;
	}

	public void setCreate_station(Station create_station) {
		this.create_station = create_station;
	}

	@Column(name = "close_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getClose_date() {
		return close_date;
	}

	public void setClose_date(Timestamp close_date) {
		this.close_date = close_date;
	}

	@ManyToOne
	@JoinColumn(name = "report_status_id")
	public Status getReport_status() {
		return report_status;
	}

	public void setReport_status(Status report_status) {
		this.report_status = report_status;
	}

	@ManyToOne
	@JoinColumn(name = "closing_agent_id")
	public Agent getClosing_agent() {
		return closing_agent;
	}

	public void setClosing_agent(Agent closing_agent) {
		this.closing_agent = closing_agent;
	}

	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "report_type")
	public int getReport_type() {
		return report_type;
	}

	public void setReport_type(int report_type) {
		this.report_type = report_type;
	}

	@Column(name = "datefoundlost")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getDateFoundLost() {
		return dateFoundLost;
	}

	public void setDateFoundLost(Timestamp dateFoundLost) {
		this.dateFoundLost = dateFoundLost;
	}

	@Column(name = "category_id")
	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	@Column(name = "languageKey")
	public String getLanguageKey() {
		return languageKey;
	}

	public void setLanguageKey(String languageKey) {
		this.languageKey = languageKey;
	}

	@Column(name = "languagefreeflow")
	public String getLanguageFreeFlow() {
		return languageFreeFlow;
	}

	public void setLanguageFreeFlow(String languageFreeFlow) {
		this.languageFreeFlow = languageFreeFlow;
	}

	@Column(name = "readonly")
	public int getReadonly() {
		return readonly;
	}

	public void setReadonly(int readonly) {
		this.readonly = readonly;
	}

	@OneToMany(mappedBy = "lostandfoundincident", cascade = CascadeType.ALL)
	@OrderBy(value = "Photo_ID")
	public Set<LostAndFound_Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<LostAndFound_Photo> photos) {
		this.photos = photos;
	}

}
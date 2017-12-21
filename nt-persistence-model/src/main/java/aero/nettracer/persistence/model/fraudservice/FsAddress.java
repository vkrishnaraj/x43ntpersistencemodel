package aero.nettracer.persistence.model.fraudservice;

import aero.nettracer.persistence.model.fraudservice.detection.AddressWhiteList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "fsaddress")
public class FsAddress {

	private long id;
	private String address1;
	private String address2;
	private String city;
	private String country;
	private String province;
	private String state;
	private String zip;
	private Person person;
	private Reservation reservation;
	private FsReceipt receipt;
	private AddressWhiteList whitelist;

	@Transient
	private long sortId;

	public FsAddress() {
		this.sortId = System.nanoTime();
	}

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "address1")
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "address2")
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "province")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "state")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "zip")
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@ManyToOne
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@ManyToOne
	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	@OneToOne
	public FsReceipt getReceipt() {
		return receipt;
	}

	public void setReceipt(FsReceipt receipt) {
		this.receipt = receipt;
	}

	@ManyToOne
	public AddressWhiteList getWhitelist() {
		return whitelist;
	}

	public void setWhitelist(AddressWhiteList whitelist) {
		this.whitelist = whitelist;
	}

	@Transient
	public long getSortId() {
		return this.sortId;
	}

	public void setSortId(long sortId) {
		this.sortId = sortId;
	}

	public boolean isEmpty() {
		boolean empty = true;
		if ((address1 != null && !address1.isEmpty())
				|| (address2 != null && !address2.isEmpty())
				|| (city != null && !city.isEmpty())
				|| (state != null && !state.isEmpty())
				|| (province != null && !province.isEmpty())
				|| (zip != null && !zip.isEmpty())) {
			empty = false;
		}

		return empty;
	}

}

package aero.nettracer.persistence.model.fraudservice;

import aero.nettracer.persistence.model.fraudservice.detection.PhoneWhiteList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "phone")
public class Phone {

	public static final int HOME = 1;
	public static final int MOBILE = 2;
	public static final int WORK = 3;
	public static final int ALTERNATE = 4;
	public static final int PAGER = 5;

	private long id;
	private String phoneNumber;
	private int type;
	private FsIncident incident;
	private Person person;
	private Reservation reservation;
	private FsReceipt receipt;
	private PhoneWhiteList whitelist;
	private String association;
	private FsClaim claim;
	private long sortId;

	public Phone() {
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

	@Column(name = "phonenumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "type")
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@ManyToOne
	public FsIncident getIncident() {
		return incident;
	}

	public void setIncident(FsIncident incident) {
		this.incident = incident;
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
	public PhoneWhiteList getWhitelist() {
		return whitelist;
	}

	public void setWhitelist(PhoneWhiteList whitelist) {
		this.whitelist = whitelist;
	}

	@Column(name = "association")
	public String getAssociation() {
		return association;
	}

	public void setAssociation(String association) {
		this.association = association;
	}

	@ManyToOne
	public FsClaim getClaim() {
		return claim;
	}

	public void setClaim(FsClaim claim) {
		this.claim = claim;
	}

	@Transient
	public long getSortId() {
		return this.sortId;
	}

	public void setSortId(long sortId) {
		this.sortId = sortId;
	}

	public boolean isEmpty() {
		return phoneNumber != null && !phoneNumber.isEmpty();
	}

}

package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lfphone")
public class LFPhone {

	//TODO this should be refactored NT-6064
	public static final int PRIMARY = 1;
	public static final int SECONDARY = 2;
	
	public static final int HOME = 3;
	public static final int MOBILE = 4;
	public static final int WORK = 5;
	public static final int ALTERNATE = 6;
	
	private long id;
	private String phoneNumber;
	private String extension;
	private int numberType;
	private int phoneType;
	private LFPerson person;
	private LFItem item;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="phone_num")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name="extension")
	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {

		if(extension!=null && extension.replaceAll("[^\\d.]", "").length()>0){
			extension=extension.replaceAll("[^\\d.]", "");
			this.extension = extension;
		}
	}

	@Column(name="number_type")
	public int getNumberType() {
		return numberType;
	}

	public void setNumberType(int numberType) {
		this.numberType = numberType;
	}

	@Column(name="phone_type")
	public int getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(int phoneType) {
		this.phoneType = phoneType;
	}

	@ManyToOne
	@JoinColumn(name = "person_id")
	public LFPerson getPerson() {
		return person;
	}

	public void setPerson(LFPerson person) {
		this.person = person;
	}

	@OneToOne
	@JoinColumn(name = "item_id")
	public LFItem getItem() {
		return item;
	}

	public void setItem(LFItem item) {
		this.item = item;
	}
	
	public static String normalizePhone(String phone){
		if (phone == null) return null;
		StringBuffer sb = new StringBuffer(100);
		for (int i = 0; i < phone.length(); i++) {
			char c = phone.charAt(i);
			if (Character.isDigit(c)) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public boolean isEmpty() {
		boolean empty = true;
		if ((getPhoneNumber() != null && !getPhoneNumber().isEmpty())) {
			empty = false;
		}
		return empty;
	}
	
}

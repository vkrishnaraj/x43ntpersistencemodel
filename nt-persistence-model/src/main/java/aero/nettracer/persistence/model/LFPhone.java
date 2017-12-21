package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;


@Entity
@Proxy(lazy = false)
public class LFPhone implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2558668661501822735L;
	
	//TODO this should be refactored NT-6064
	public static final int PRIMARY = 1;
	public static final int SECONDARY = 2;
	
	public static final int HOME = 3;
	public static final int MOBILE = 4;
	public static final int WORK = 5;
	public static final int ALTERNATE = 6;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="phone_num",length = 32)
	private String phoneNumber;
	
	@Column(name="extension",length = 32)
	private String extension;
	
	/* Primary/Secondary */
	@Column(name="number_type")
	private int numberType;
	
	/* Home/Mobile/Work/Alternate */
	@Column(name="phone_type")
	private int phoneType;
	
	@ManyToOne
	@JoinColumn(name = "person_id", nullable = true)
	@Fetch(FetchMode.SELECT)
	private LFPerson person;
	
	@OneToOne
	@JoinColumn(name = "item_id", nullable = true)
	@Fetch(FetchMode.SELECT)
	private LFItem item;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public int getNumberType() {
		return numberType;
	}

	public void setNumberType(int numberType) {
		this.numberType = numberType;
	}
	
	public int getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(int phoneType) {
		this.phoneType = phoneType;
	}

	public LFPerson getPerson() {
		return person;
	}

	public void setPerson(LFPerson person) {
		this.person = person;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {

		if(extension!=null && extension.replaceAll("[^\\d.]", "").length()>0){
			extension=extension.replaceAll("[^\\d.]", "");
			this.extension = extension;
		}
	}
	
	//TODO this should be refactored NT-6064
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

	public void setItem(LFItem item) {
		this.item = item;
	}

	public LFItem getItem() {
		return item;
	}
	
	//TODO this should be refactored NT-6064
	public boolean isEmpty() {
		boolean empty = true;
		if ((getPhoneNumber() != null && !getPhoneNumber().isEmpty())) {
			empty = false;
		}
		return empty;
	}
	
}

package aero.nettracer.persistence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
public class LFTransactionLog {

	private static final long serialVersionUID = -4770369543842583765L;
	
	@Id
	@GeneratedValue
	long id;
	
	@Column(name="entry_datetime")
	Date entrydate;
	
	@Column(name="ref_id")
	String refId;
	
	String description;
	
	@Column(name="elapse_time")
	long elapseTime;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getEntrydate() {
		return entrydate;
	}
	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}
	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String desc) {
		this.description = desc;
	}
	public long getElapseTime() {
		return elapseTime;
	}
	public void setElapseTime(long elapseTime) {
		this.elapseTime = elapseTime;
	}
	
	
}

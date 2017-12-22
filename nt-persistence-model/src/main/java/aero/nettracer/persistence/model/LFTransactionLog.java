package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;

@Entity
@Table(name = "lftransactionlog")
public class LFTransactionLog {

	private long id;
	private Timestamp entrydate;
	private String refId;
	private String description;
	private long elapseTime;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="entry_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(Timestamp entrydate) {
		this.entrydate = entrydate;
	}

	@Column(name="ref_id")
	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="elapse_time")
	public long getElapseTime() {
		return elapseTime;
	}

	public void setElapseTime(long elapseTime) {
		this.elapseTime = elapseTime;
	}

}

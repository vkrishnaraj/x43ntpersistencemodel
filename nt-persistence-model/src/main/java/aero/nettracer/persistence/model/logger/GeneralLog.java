package aero.nettracer.persistence.model.logger;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;

@Entity
@Table(name="generallog")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="trans", discriminatorType = DiscriminatorType.STRING, length=16)
@DiscriminatorValue("GENERAL")
public class GeneralLog {

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

	@Column(name = "entrydate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(Timestamp entrydate) {
		this.entrydate = entrydate;
	}

	@Column(name = "refid")
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

	public void setDescription(String desc) {
		this.description = desc;
	}

	@Column(name = "elapsetime")
	public long getElapseTime() {
		return elapseTime;
	}

	public void setElapseTime(long elapseTime) {
		this.elapseTime = elapseTime;
	}

}

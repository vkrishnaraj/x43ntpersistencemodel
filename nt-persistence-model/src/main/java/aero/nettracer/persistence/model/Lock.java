package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import java.sql.Timestamp;

@Entity
@Table(name = "global_lock", uniqueConstraints = @UniqueConstraint(columnNames={"locktype", "lockkey"}))
public class Lock {
	
	private long id;
	private Timestamp createDate;
	private Timestamp expirationDate;
	private String lockKey;
	private LockType lockType;
	private String owner;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "locktype")
	public LockType getLockType() {
		return lockType;
	}

	public void setLockType(LockType lockType) {
		this.lockType = lockType;
	}

	@Column(name = "lockkey")
	public String getLockKey() {
		return lockKey;
	}

	public void setLockKey(String lockKey) {
		this.lockKey = lockKey;
	}

	@Column(name = "owner")
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Column(name = "createdate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Timestamp expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public static enum LockType{
		AF_COUNT, AF_SUMMARY, AF_DETAIL, TM_INCIDENT, LF_FOUND, DISPUTE, INCIDENT_ACTIVITY, BAG_CENTRAL
	};
}

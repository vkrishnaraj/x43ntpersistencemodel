package aero.nettracer.persistence.model;

import org.hibernate.annotations.OrderBy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "lfsalvage")
public class LFSalvage {

	private long id;
	private int agentId;
	private int statusId;
	private String companyCode;
	private String locationStationCode;
	private Timestamp createdDate;
	private Timestamp closedDate;
	private String name;
	private List<LFFound> items;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "agent_id", nullable = false)
	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	@Column(name = "status_id", nullable = false)
	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	@Column(name="company_code")
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	@Column(name="loc_stn_code",length = 8)
	public String getLocationStationCode() {
		return locationStationCode;
	}

	public void setLocationStationCode(String locationStationCode) {
		this.locationStationCode = locationStationCode;
	}

	@Column(name="created_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name="closed_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(Timestamp closedDate) {
		this.closedDate = closedDate;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "salvage", cascade = CascadeType.ALL)
	@OrderBy(clause = "id")
	public List<LFFound> getItems() {
		return items;
	}
	
	public void setItems(List<LFFound> items) {
		this.items = items;
	}

}

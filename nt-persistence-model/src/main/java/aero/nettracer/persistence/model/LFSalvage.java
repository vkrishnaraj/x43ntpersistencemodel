package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
//import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Proxy;


@Entity
@Proxy(lazy = false)
public class LFSalvage implements Serializable {
	
	private static final long serialVersionUID = 5806495189281178779L;

	@Id
	@GeneratedValue
	private long id;

	@Column(name="name")
	private String name;
	
	@Column(name = "agent_id", nullable = false)
	private int agentId;
	
	@Column(name = "status_id", nullable = false)
	private int statusId;
	
	@Column(name="loc_stn_code",length = 8)
	private String locationStationCode;

	@Column(name="company_code",length = 8)
	private String companyCode;
	
	@OneToMany(mappedBy = "salvage", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderBy(clause = "id")
	@Fetch(FetchMode.SELECT)
	private List<LFFound> items;
	
	@Column(name="created_datetime")
	private Date createdDate;
	
	@Column(name="closed_datetime")
	private Date closedDate;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<LFFound> getItems() {
		return items;
	}
	
	public void setItems(List<LFFound> items) {
		this.items = items;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public Date getClosedDate() {
		return closedDate;
	}
	
	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getLocationStationCode() {
		return locationStationCode;
	}

	public void setLocationStationCode(String locationStationCode) {
		this.locationStationCode = locationStationCode;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
}

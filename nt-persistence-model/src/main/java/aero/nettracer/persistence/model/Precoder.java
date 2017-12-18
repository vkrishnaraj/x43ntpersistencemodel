package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name="precoder")
public class Precoder {

	long id;
	Incident incident;
	Date createdate;
	int losscode;
	Station faultStation;
	String remark;
	
	@Id
	@GeneratedValue
	@Column(name = "precoder_id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@OneToOne
	@JoinColumn(name = "incident_id")
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	@Column(name = "createdate")
	@Temporal(value = TemporalType.DATE)
	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
	@Column(name = "losscode")
	public int getLosscode() {
		return losscode;
	}

	public void setLosscode(int losscode) {
		this.losscode = losscode;
	}
	
	@ManyToOne
	@JoinColumn(name = "faultstation_id")
	public Station getFaultStation() {
		return faultStation;
	}

	public void setFaultStation(Station faultStation) {
		this.faultStation = faultStation;
	}
	
	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}

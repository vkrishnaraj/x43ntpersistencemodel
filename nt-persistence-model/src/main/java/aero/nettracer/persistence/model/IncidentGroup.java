package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "incident_group")
public class IncidentGroup implements Serializable {

	private int id;
	private String name;
	private String joiningCondition;
	private String whereClause;
	private int incidentGroupPriority;
	private boolean isVIP;

	@Id
	@GeneratedValue
	@Column(name="incident_group_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="joining_condition")
	public String getJoiningCondition() {
		return joiningCondition;
	}

	public void setJoiningCondition(String joiningCondition) {
		this.joiningCondition = joiningCondition;
	}

	@Column(name="where_clause")
	public String getWhereClause() {
		return whereClause;
	}

	public void setWhereClause(String whereClause) {
		this.whereClause = whereClause;
	}

	@Column(name="incident_group_priority")
	public int getIncidentGroupPriority() {
		return incidentGroupPriority;
	}

	public void setIncidentGroupPriority(int incidentGroupPriority) {
		this.incidentGroupPriority = incidentGroupPriority;
	}

	@Column(name="isVIP")
	public boolean isVIP() {
		return isVIP;
	}

	public void setVIP(boolean VIP) {
		isVIP = VIP;
	}
}
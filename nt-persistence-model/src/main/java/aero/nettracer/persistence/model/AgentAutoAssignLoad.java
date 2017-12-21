package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "agent_autoassign_load")
public class AgentAutoAssignLoad {

	private AgentIncidentGroup agentIncidentGroup;
	private int weight;

	@EmbeddedId
	public AgentIncidentGroup getAgentIncidentGroup() {
		return agentIncidentGroup;
	}

	public void setAgentIncidentGroup(AgentIncidentGroup agentIncidentGroup) {
		this.agentIncidentGroup = agentIncidentGroup;
	}

	@Column(name="weight", nullable = false)
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
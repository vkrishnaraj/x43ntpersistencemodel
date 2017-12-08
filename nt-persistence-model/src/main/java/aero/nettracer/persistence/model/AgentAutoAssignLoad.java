package aero.nettracer.persistence.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "agent_autoassign_load")
public class AgentAutoAssignLoad implements Serializable {

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
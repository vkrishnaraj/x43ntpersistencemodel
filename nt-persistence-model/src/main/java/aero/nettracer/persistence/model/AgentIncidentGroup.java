package aero.nettracer.persistence.model;

import javax.persistence.Column;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AgentIncidentGroup {

    private String agentUserName;
    private String incidentGroupName;

    public AgentIncidentGroup() {}

    public AgentIncidentGroup(String agentUserName, String incidentGroupName) {
        this.agentUserName = agentUserName;
        this.incidentGroupName = incidentGroupName;
    }
    @Column(name = "agent_username")
    public String getAgentUserName() {
        return agentUserName;
    }

    public void setAgentUserName(String agentUserName) {
        this.agentUserName = agentUserName;
    }

    @Column(name = "incident_group_name")
    public String getIncidentGroupName() {
        return incidentGroupName;
    }

    public void setIncidentGroupName(String incidentGroupName) {
        this.incidentGroupName = incidentGroupName;
    }

    @Override
    public boolean equals(Object aig) {
        if (!(aig instanceof AgentIncidentGroup)) {
            return false;
        }

        AgentIncidentGroup agentIncidentGroup = (AgentIncidentGroup) aig;
        return (!StringUtils.isBlank(this.agentUserName) && !StringUtils.isBlank(this.incidentGroupName)
                && !StringUtils.isBlank(agentIncidentGroup.getAgentUserName()) && !StringUtils.isBlank(agentIncidentGroup.getIncidentGroupName())
                && this.agentUserName.equals(agentIncidentGroup.getAgentUserName()) && this.incidentGroupName.equals(agentIncidentGroup.getIncidentGroupName()));
    }

    @Override
    public int hashCode () {
        return agentUserName.hashCode() + incidentGroupName.hashCode();
    }
}

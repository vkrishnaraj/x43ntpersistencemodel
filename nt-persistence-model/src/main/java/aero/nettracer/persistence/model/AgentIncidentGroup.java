package aero.nettracer.persistence.model;

import org.apache.commons.lang.StringUtils;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Wen Yan on 10/8/2017.
 */
@Embeddable
public class AgentIncidentGroup implements Serializable {

    private String agent_username;
    private String incident_group_name;

    public AgentIncidentGroup() {}

    public AgentIncidentGroup(String agent_username, String incident_group_name) {
        this.agent_username = agent_username;
        this.incident_group_name = incident_group_name;
    }

    public String getAgent_username() {
        return agent_username;
    }

    public void setAgent_username(String agent_username) {
        this.agent_username = agent_username;
    }

    public String getIncident_group_name() {
        return incident_group_name;
    }

    public void setIncident_group_name(String incident_group_name) {
        this.incident_group_name = incident_group_name;
    }

    @Override
    public boolean equals(Object aig) {
        if (!(aig instanceof AgentIncidentGroup)) {
            return false;
        }

        AgentIncidentGroup agentIncidentGroup = (AgentIncidentGroup) aig;
        return (!StringUtils.isBlank(this.agent_username) && !StringUtils.isBlank(this.incident_group_name)
                && !StringUtils.isBlank(agentIncidentGroup.getAgent_username()) && !StringUtils.isBlank(agentIncidentGroup.getIncident_group_name())
                && this.agent_username.equals(agentIncidentGroup.getAgent_username()) && this.incident_group_name.equals(agentIncidentGroup.getIncident_group_name()));
    }

    @Override
    public int hashCode () {
        return agent_username.hashCode() + incident_group_name.hashCode();
    }
}

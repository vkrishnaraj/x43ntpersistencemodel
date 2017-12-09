package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "agent_logger")
public class Agent_Logger {

    private int id;
    private int agentId;
    private String companyCode;
    private Timestamp  logInTime;
    private Timestamp logOffTime;
    private boolean expired;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="agent_id")
    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    @Column(name = "companycode_id")
    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    @Column(name = "log_in_time")
    @Temporal(TemporalType.TIMESTAMP)
    public Timestamp getLogInTime() {
        return logInTime;
    }

    public void setLogInTime(Timestamp logInTime) {
        this.logInTime = logInTime;
    }

    @Column(name = "log_off_time")
    @Temporal(TemporalType.TIMESTAMP)
    public Timestamp getLogOffTime() {
        return logOffTime;
    }

    public void setLogOffTime(Timestamp logOffTime) {
        this.logOffTime = logOffTime;
    }

    @Column(name = "expired")
    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }
}
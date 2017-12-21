package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;

@Entity
@Table(name = "agent_logger")
public class Agent_Logger {

    private int id;
    private int agent_ID;
    private String companycode_ID;
    private Timestamp  log_in_time;
    private Timestamp log_off_time;
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
    public int getAgent_ID() {
        return agent_ID;
    }

    public void setAgent_ID(int agent_ID) {
        this.agent_ID = agent_ID;
    }

    @Column(name = "companycode_id")
    public String getCompanycode_ID() {
        return companycode_ID;
    }

    public void setCompanycode_ID(String companycode_ID) {
        this.companycode_ID = companycode_ID;
    }

    @Column(name = "log_in_time")
    @Temporal(TemporalType.TIMESTAMP)
    public Timestamp getLog_in_time() {
        return log_in_time;
    }

    public void setLog_in_time(Timestamp log_in_time) {
        this.log_in_time = log_in_time;
    }

    @Column(name = "log_off_time")
    @Temporal(TemporalType.TIMESTAMP)
    public Timestamp getLog_off_time() {
        return log_off_time;
    }

    public void setLog_off_time(Timestamp log_off_time) {
        this.log_off_time = log_off_time;
    }

    @Column(name = "expired")
    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }
}
package aero.nettracer.persistence.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name = "company_irregularity_code_groups")
public class BagMartReasonGroup
{
    @Id
    @GeneratedValue
    private int id;
    private String description;

    public final static String BSO_ERROR="BSO Error";
    public final static String CHECK_IN_ERROR="Check In Error";
    public final static String CREATED_IN_ERROR="Created In Error";
    public final static String DAMAGE="Damage";
    public final static String FAILED_TO_LOAD="Failed To Load";
    public final static String INTERLINE="Interline";
    public final static String LOADING_ERROR="Loading Error";
    public final static String LOST_BAGS="Lost Bags";
    public final static String MISSING_ITEMS="Missing Items";
    public final static String NO_FAULT="No Fault";
    public final static String NOT_CODED="Not Coded";
    public final static String OPS_ISSUES="Ops Issues";
    public final static String REMOTE_CHECKIN="Remote Checkin";
    public final static String REROUTE_ERROR="Reroute Error";
    public final static String TRANSFER_ERROR="Transfer Error";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReasonGroup() {
        return description;
    }

    public void setReasonGroup(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


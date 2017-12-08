package aero.nettracer.persistence.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by thinkel on 7/6/2017.
 */

@Entity
@Table(name = "claim_questionnaire")
public class Claim_Questionnaire implements Serializable {

    private static final long serialVersionUID = 8259636336942271239L;

    private long id;
    private boolean immediatelyReported;
    private String causeForReportDelay;
    private String reportingMethod;
    private boolean interlineReported;
    private boolean recentlyReported;
    private String recentReportDescription;
    private boolean excessWeightCharged;
    private String lastWitnessLocation;
    private boolean customsInspectionWitnessed;
    private String customsInspectionLocation;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean getImmediatelyReported() {
        return immediatelyReported;
    }

    public void setImmediatelyReported(boolean immediatelyReported) {
        this.immediatelyReported = immediatelyReported;
    }

    public String getCauseForReportDelay() {
        return causeForReportDelay;
    }

    public void setCauseForReportDelay(String causeForReportDelay) {
        this.causeForReportDelay = causeForReportDelay;
    }

    public String getReportingMethod() {
        return reportingMethod;
    }

    public void setReportingMethod(String reportingMethod) {
        this.reportingMethod = reportingMethod;
    }

    public boolean getInterlineReported() {
        return interlineReported;
    }

    public void setInterlineReported(boolean interlineReported) {
        this.interlineReported = interlineReported;
    }

    public boolean getRecentlyReported() {
        return recentlyReported;
    }

    public void setRecentlyReported(boolean recentlyReported) {
        this.recentlyReported = recentlyReported;
    }

    public String getRecentReportDescription() {
        return recentReportDescription;
    }

    public void setRecentReportDescription(String recentReportDescription) {
        this.recentReportDescription = recentReportDescription;
    }

    public boolean getExcessWeightCharged() {
        return excessWeightCharged;
    }

    public void setExcessWeightCharged(boolean excessWeightCharged) {
        this.excessWeightCharged = excessWeightCharged;
    }

    public String getLastWitnessLocation() {
        return lastWitnessLocation;
    }

    public void setLastWitnessLocation(String lastWitnessLocation) {
        this.lastWitnessLocation = lastWitnessLocation;
    }

    public boolean getCustomsInspectionWitnessed() {
        return customsInspectionWitnessed;
    }

    public void setCustomsInspectionWitnessed(boolean customsInspectionWitnessed) {
        this.customsInspectionWitnessed = customsInspectionWitnessed;
    }

    public String getCustomsInspectionLocation() {
        return customsInspectionLocation;
    }

    public void setCustomsInspectionLocation(String customsInspectionLocation) {
        this.customsInspectionLocation = customsInspectionLocation;
    }
}

package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "claim_questionnaire")
public class Claim_Questionnaire {

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
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "immediatelyreported")
    public boolean getImmediatelyReported() {
        return immediatelyReported;
    }

    public void setImmediatelyReported(boolean immediatelyReported) {
        this.immediatelyReported = immediatelyReported;
    }

    @Column(name = "causeforreportdelay")
    public String getCauseForReportDelay() {
        return causeForReportDelay;
    }

    public void setCauseForReportDelay(String causeForReportDelay) {
        this.causeForReportDelay = causeForReportDelay;
    }

    @Column(name = "reportingmethod")
    public String getReportingMethod() {
        return reportingMethod;
    }

    public void setReportingMethod(String reportingMethod) {
        this.reportingMethod = reportingMethod;
    }

    @Column(name = "interlinereported")
    public boolean getInterlineReported() {
        return interlineReported;
    }

    public void setInterlineReported(boolean interlineReported) {
        this.interlineReported = interlineReported;
    }

    @Column(name = "recentlyreported")
    public boolean getRecentlyReported() {
        return recentlyReported;
    }

    public void setRecentlyReported(boolean recentlyReported) {
        this.recentlyReported = recentlyReported;
    }

    @Column(name = "recentreportdescription")
    public String getRecentReportDescription() {
        return recentReportDescription;
    }

    public void setRecentReportDescription(String recentReportDescription) {
        this.recentReportDescription = recentReportDescription;
    }

    @Column(name = "excessweightcharged")
    public boolean getExcessWeightCharged() {
        return excessWeightCharged;
    }

    public void setExcessWeightCharged(boolean excessWeightCharged) {
        this.excessWeightCharged = excessWeightCharged;
    }

    @Column(name = "lastwitnesslocation")
    public String getLastWitnessLocation() {
        return lastWitnessLocation;
    }

    public void setLastWitnessLocation(String lastWitnessLocation) {
        this.lastWitnessLocation = lastWitnessLocation;
    }

    @Column(name = "customsinspectionwitnessed")
    public boolean getCustomsInspectionWitnessed() {
        return customsInspectionWitnessed;
    }

    public void setCustomsInspectionWitnessed(boolean customsInspectionWitnessed) {
        this.customsInspectionWitnessed = customsInspectionWitnessed;
    }

    @Column(name = "customsinspectionlocation")
    public String getCustomsInspectionLocation() {
        return customsInspectionLocation;
    }

    public void setCustomsInspectionLocation(String customsInspectionLocation) {
        this.customsInspectionLocation = customsInspectionLocation;
    }
}

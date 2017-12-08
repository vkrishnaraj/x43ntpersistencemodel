/*
 * Created on Jul 14, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model.audit;

import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;

import aero.nettracer.commons.constant.GenericConstants;
import aero.nettracer.commons.utils.GenericDateUtils;
import aero.nettracer.persistence.model.Agent;
import aero.nettracer.persistence.model.Company;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "audit_work_shift")
public class Audit_Work_Shift implements Serializable {

    private int audit_shift_id;
    private int shift_id;
    private String shift_code;
    private String shift_description;
    private Company company;
    private String locale;
    private Agent modifying_agent;
    private Date time_modified;
    private String reason_modified;
    private String _DATEFORMAT; // current login agent's date format
    private String _TIMEFORMAT; // current login agent's time format
    private TimeZone _TIMEZONE; // timezone

    @Transient
    public String get_DATEFORMAT() {
        return _DATEFORMAT;
    }

    public void set_DATEFORMAT(String _dateformat) {
        _DATEFORMAT = _dateformat;
    }

    @Transient
    public String get_TIMEFORMAT() {
        return _TIMEFORMAT;
    }

    public void set_TIMEFORMAT(String _timeformat) {
        _TIMEFORMAT = _timeformat;
    }

    @Transient
    public TimeZone get_TIMEZONE() {
        return _TIMEZONE;
    }

    public void set_TIMEZONE(TimeZone _timezone) {
        _TIMEZONE = _timezone;
    }

    @Transient
    public String getDisplaytime_modified() {
        Date completedate = GenericDateUtils.convertToDate(this.getTime_modified().toString(),
                GenericConstants.DB_DATETIMEFORMAT, null);
        return GenericDateUtils.formatDate(completedate, _DATEFORMAT + " " + _TIMEFORMAT, null, _TIMEZONE);
    }

    @ManyToOne
    @JoinColumn(name= "modifying_agent_id")
    public Agent getModifying_agent() {
        return modifying_agent;
    }

    public void setModifying_agent(Agent modifying_agent) {
        this.modifying_agent = modifying_agent;
    }

    public String getReason_modified() {
        return reason_modified;
    }

    public void setReason_modified(String reason_modified) {
        this.reason_modified = reason_modified;
    }

    public Date getTime_modified() {
        return time_modified;
    }

    public void setTime_modified(Date time_modified) {
        this.time_modified = time_modified;
    }

    public String getShift_code() {
        return shift_code;
    }

    public void setShift_code(String shift_code) {
        this.shift_code = shift_code;
    }

    @ManyToOne
    @JoinColumn(name= "companycode_id")
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getShift_description() {
        return shift_description;
    }

    public void setShift_description(String shift_description) {
        this.shift_description = shift_description;
    }

    public int getShift_id() {
        return shift_id;
    }

    public void setShift_id(int shift_id) {
        this.shift_id = shift_id;
    }

    @Id
    @GeneratedValue
    public int getAudit_shift_id() {
        return audit_shift_id;
    }

    public void setAudit_shift_id(int audit_shift_id) {
        this.audit_shift_id = audit_shift_id;
    }
}
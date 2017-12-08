package aero.nettracer.persistence.model.audit;

import java.io.Serializable;

import aero.nettracer.commons.utils.CommonsConstants;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Audit_company_specific_variable")
public class Audit_Company_Specific_Variable implements Serializable {
	
	private static final long serialVersionUID = 4117915546129100198L;
	private int id;
	private int total_threads;
	private int seconds_wait;
	private double min_match_percent;
	private int mbr_to_lz_days;
	private int damaged_to_lz_days;
	private int miss_to_lz_days;
	private int ohd_to_lz_days;
	private int report_method;
	private int default_station_code;
	private int default_loss_code;
	private boolean email_customer; // send email to customer after report creation or
	private double min_interim_approval_check;
	private double min_interim_approval_voucher; 
	private double min_interim_approval_miles;
	private double min_interim_approval_incidental;
	private double min_interim_approval_cc_refund;
	private int mbr_to_wt_days;
	private int ohd_to_wt_hours;
	private int oal_ohd_hours;
	private int oal_inc_hours;
	private int audit_ohd;
	private int audit_lost_found;
	private int audit_lost_delayed;
	private int audit_damaged;
	private int audit_missing_articles;
	private int audit_agent;
	private int audit_group;
	private int audit_company;
	private int audit_shift;
	private int audit_station;
	private int audit_loss_codes;
	private int audit_claims;
	private int audit_airport;
	private int audit_delivery_companies;
	private int max_image_file_size;
	private String email_host;
	private int email_port;
	private String email_from;
	private String email_to;
	private String blindEmail;
	private int pass_expire_days;
	private int max_failed_logins;
	private int ws_enabled;
	private int secure_password;
	private int lz_mode;
	private int ohd_lz;
	private int scannerDefaultBack;
	private int scannerDefaultForward;
	private boolean autoCloseOhd;
	private boolean auto_wt_amend;
	private int min_pass_size;
	private int pass_x_history;
	
	//AUTO CLOSE
	private int auto_close_days_back;
	private int auto_close_ld_code;
	private int auto_close_dam_code;
	private int auto_close_pil_code;
	private int auto_close_ld_station;
	private int auto_close_dam_station;
	private int auto_close_pil_station;
	private String status_message;	
	

	//incident locking
	private int incident_lock_mins;
	
	//bagdrop
	private int bagdrop_autorefresh_mins;
	

	/**
	 * Variable to determine the last amount of days to include incidents for a PNR Prepopulation Check. -Sean Fine
	 */
	private int pnr_last_x_days;

	private int issuance_edit_last_x_days;

	private int default_ld_loss_code;
	private int default_ld_fault_station;
	private int default_ms_loss_code;
	private int default_ms_fault_station;
	private int default_dm_loss_code;
	private int default_dm_fault_station;

	// Online Claims automated email interval
	private int auto_pplc_email_ld;
	private int auto_pplc_email_dm;
	private int auto_pplc_email_ms;

	public int getDefault_loss_code() {
		return default_loss_code;
	}

	public void setDefault_loss_code(int default_loss_code) {
		this.default_loss_code = default_loss_code;
	}
	
	public int getMax_image_file_size() {
		return max_image_file_size;
	}

	public void setMax_image_file_size(int max_image_file_size) {
		this.max_image_file_size = max_image_file_size;
	}

	public double getMin_interim_approval_check() {
		return min_interim_approval_check;
	}

	public void setMin_interim_approval_check(double min_interim_approval_check) {
		this.min_interim_approval_check = min_interim_approval_check;
	}

	public double getMin_interim_approval_miles() {
		return min_interim_approval_miles;
	}

	public void setMin_interim_approval_miles(double min_interim_approval_miles) {
		this.min_interim_approval_miles = min_interim_approval_miles;
	}
	
	
	public double getMin_interim_approval_incidental() {
		return min_interim_approval_incidental;
	}
	
	public void setMin_interim_approval_incidental(double min_interim_approval_incidental) {
		this.min_interim_approval_incidental = min_interim_approval_incidental;
	}
	
	public double getMin_interim_approval_cc_refund() {
		return min_interim_approval_cc_refund;
	}
	
	public void setMin_interim_approval_cc_refund(double min_interim_approval_cc_refund) {
		this.min_interim_approval_cc_refund = min_interim_approval_cc_refund;
	}
	
	public double getMin_interim_approval_voucher() {
		return min_interim_approval_voucher;
	}

	public void setMin_interim_approval_voucher(double min_interim_approval_voucher) {
		this.min_interim_approval_voucher = min_interim_approval_voucher;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAudit_airport() {
		return audit_airport;
	}

	public void setAudit_airport(int audit_airport) {
		this.audit_airport = audit_airport;
	}

	public int getAudit_agent() {
		return audit_agent;
	}

	public void setAudit_agent(int audit_agent) {
		this.audit_agent = audit_agent;
	}

	public int getAudit_company() {
		return audit_company;
	}

	public void setAudit_company(int audit_company) {
		this.audit_company = audit_company;
	}

	public int getAudit_damaged() {
		return audit_damaged;
	}

	public void setAudit_damaged(int audit_damaged) {
		this.audit_damaged = audit_damaged;
	}

	public int getAudit_group() {
		return audit_group;
	}

	public void setAudit_group(int audit_group) {
		this.audit_group = audit_group;
	}

	public int getAudit_loss_codes() {
		return audit_loss_codes;
	}

	public void setAudit_loss_codes(int audit_loss_codes) {
		this.audit_loss_codes = audit_loss_codes;
	}

	public int getAudit_lost_delayed() {
		return audit_lost_delayed;
	}

	public void setAudit_lost_delayed(int audit_lost_delayed) {
		this.audit_lost_delayed = audit_lost_delayed;
	}

	public int getAudit_lost_found() {
		return audit_lost_found;
	}

	public void setAudit_lost_found(int audit_lost_found) {
		this.audit_lost_found = audit_lost_found;
	}

	public int getAudit_missing_articles() {
		return audit_missing_articles;
	}

	public void setAudit_missing_articles(int audit_missing_articles) {
		this.audit_missing_articles = audit_missing_articles;
	}

	public int getAudit_shift() {
		return audit_shift;
	}

	public void setAudit_shift(int audit_shift) {
		this.audit_shift = audit_shift;
	}

	public int getAudit_station() {
		return audit_station;
	}

	public void setAudit_station(int audit_station) {
		this.audit_station = audit_station;
	}

	public int getAudit_ohd() {
		return audit_ohd;
	}

	public void setAudit_ohd(int audit_ohd) {
		this.audit_ohd = audit_ohd;
	}

	public int getAudit_claims() {
		return audit_claims;
	}

	public void setAudit_claims(int audit_claims) {
		this.audit_claims = audit_claims;
	}

	public int getDefault_station_code() {
		return default_station_code;
	}

	public void setDefault_station_code(int default_station_code) {
		this.default_station_code = default_station_code;
	}

	public double getMin_match_percent() {
		return min_match_percent;
	}

	public void setMin_match_percent(double min_match_percent) {
		this.min_match_percent = min_match_percent;
	}

	public int getSeconds_wait() {
		return seconds_wait;
	}

	public void setSeconds_wait(int seconds_wait) {
		this.seconds_wait = seconds_wait;
	}

	public int getTotal_threads() {
		return total_threads;
	}

	public void setTotal_threads(int total_threads) {
		this.total_threads = total_threads;
	}

	public int getMbr_to_lz_days() {
		return mbr_to_lz_days;
	}

	public void setMbr_to_lz_days(int mbr_to_lz_days) {
		this.mbr_to_lz_days = mbr_to_lz_days;
	}

	public int getDamaged_to_lz_days() {
		return damaged_to_lz_days;
	}

	public void setDamaged_to_lz_days(int damaged_to_lz_days) {
		this.damaged_to_lz_days = damaged_to_lz_days;
	}
	
	public int getMiss_to_lz_days() {
		return miss_to_lz_days;
	}

	public void setMiss_to_lz_days(int miss_to_lz_days) {
		this.miss_to_lz_days = miss_to_lz_days;
	}
	
	public int getOhd_to_lz_days() {
		return ohd_to_lz_days;
	}

	public void setOhd_to_lz_days(int ohd_to_lz_days) {
		this.ohd_to_lz_days = ohd_to_lz_days;
	}

	public int getReport_method() {
		return report_method;
	}

	public void setReport_method(int report_method) {
		this.report_method = report_method;
	}

	public String getEmail_from() {
		return email_from;
	}

	public void setEmail_from(String email_from) {
		this.email_from = email_from;
	}

	public String getEmail_host() {
		return email_host;
	}

	public void setEmail_host(String email_host) {
		this.email_host = email_host;
	}

	@Column(name = "blind_cc")
	public String getBlindEmail() {
		return blindEmail;
	}
	
	public void setBlindEmail(String blindEmail) {
		this.blindEmail = blindEmail;
	}

	public int getEmail_port() {
		return email_port;
	}

	public void setEmail_port(int email_port) {
		this.email_port = email_port;
	}

	public String getEmail_to() {
		return email_to;
	}

	public void setEmail_to(String email_to) {
		this.email_to = email_to;
	}
	

	public int getAudit_delivery_companies() {
		return audit_delivery_companies;
	}

	public void setAudit_delivery_companies(int audit_delivery_companies) {
		this.audit_delivery_companies = audit_delivery_companies;
	}

	public int getPass_expire_days() {
		return pass_expire_days;
	}

	public void setPass_expire_days(int pass_expire_days) {
		this.pass_expire_days = pass_expire_days;
	}
	
	public int getMax_failed_logins() {
		return max_failed_logins;
	}

	public void setMax_failed_logins(int max_failed_logins) {
		this.max_failed_logins = max_failed_logins;
	}

	public int getWs_enabled() {
		return ws_enabled;
	}

	public void setWs_enabled(int ws_enabled) {
		this.ws_enabled = ws_enabled;
	}

	public int getMbr_to_wt_days() {
		return mbr_to_wt_days;
	}

	public void setMbr_to_wt_days(int mbr_to_wt_days) {
		this.mbr_to_wt_days = mbr_to_wt_days;
	}

	public int getOhd_to_wt_hours() {
		return ohd_to_wt_hours;
	}

	public void setOhd_to_wt_hours(int ohd_to_wt_hours) {
		this.ohd_to_wt_hours = ohd_to_wt_hours;
	}

	public int getSecure_password() {
		return secure_password;
	}

	public void setSecure_password(int secure_password) {
		this.secure_password = secure_password;
	}

	public int getOhd_lz() {
		return ohd_lz;
	}

	public void setOhd_lz(int ohd_lz) {
		this.ohd_lz = ohd_lz;
	}

	public int getLz_mode() {
		return lz_mode;
	}

	public void setLz_mode(int lz_mode) {
		this.lz_mode = lz_mode;
	}

	public int getScannerDefaultBack() {
		return scannerDefaultBack;
	}

	public void setScannerDefaultBack(int scannerDefaultBack) {
		this.scannerDefaultBack = scannerDefaultBack;
	}

	public int getScannerDefaultForward() {
		return scannerDefaultForward;
	}

	public void setScannerDefaultForward(int scannerDefaultForward) {
		this.scannerDefaultForward = scannerDefaultForward;
	}

	public int getOal_ohd_hours() {
		return oal_ohd_hours;
	}

	public void setOal_ohd_hours(int oal_ohd_hours) {
		this.oal_ohd_hours = oal_ohd_hours;
	}

	public int getOal_inc_hours() {
		return oal_inc_hours;
	}

	public void setOal_inc_hours(int oal_inc_hours) {
		this.oal_inc_hours = oal_inc_hours;
	}

	public boolean isAuto_wt_amend() {
		return auto_wt_amend;
	}

	public void setAuto_wt_amend(boolean auto_wt_amend) {
		this.auto_wt_amend = auto_wt_amend;
	}
	
	public boolean isEmail_customer() {
		return email_customer;
	}
	public void setEmail_customer(boolean email_customer) {
		this.email_customer = email_customer;
	}
	
	public boolean isAutoCloseOhd() {
		return autoCloseOhd;
	}
	
	public void setAutoCloseOhd(boolean autoCloseOhd) {
		this.autoCloseOhd = autoCloseOhd;
	}
	public void setMin_pass_size(int min_pass_size) {
		this.min_pass_size = min_pass_size;
	}

	public int getMin_pass_size() {
		return min_pass_size;
	}
	public void setPass_x_history(int pass_x_history) {
		this.pass_x_history = pass_x_history;
	}

	public int getPass_x_history() {
		return pass_x_history;
	}
	
	public void setAuto_close_days_back(int auto_close_days_back) {
		this.auto_close_days_back = auto_close_days_back;
	}

	public int getAuto_close_days_back() {
		return auto_close_days_back;
	}
	
	public void setAuto_close_ld_code(int auto_close_ld_code) {
		this.auto_close_ld_code = auto_close_ld_code;
	}

	public int getAuto_close_ld_code() {
		return auto_close_ld_code;
	}
	
	public void setAuto_close_dam_code(int auto_close_dam_code) {
		this.auto_close_dam_code = auto_close_dam_code;
	}

	public int getAuto_close_dam_code() {
		return auto_close_dam_code;
	}
	
	public void setAuto_close_pil_code(int auto_close_pil_code) {
		this.auto_close_pil_code = auto_close_pil_code;
	}

	public int getAuto_close_pil_code() {
		return auto_close_pil_code;
	}
	
	public void setAuto_close_ld_station(int auto_close_ld_station) {
		this.auto_close_ld_station = auto_close_ld_station;
	}

	public int getAuto_close_ld_station() {
		return auto_close_ld_station;
	}
	
	public void setAuto_close_dam_station(int auto_close_dam_station) {
		this.auto_close_dam_station = auto_close_dam_station;
	}

	public int getAuto_close_dam_station() {
		return auto_close_dam_station;
	}
	
	public void setAuto_close_pil_station(int auto_close_pil_station) {
		this.auto_close_pil_station = auto_close_pil_station;
	}

	public int getAuto_close_pil_station() {
		return auto_close_pil_station;
	}
	
	
	public void setIncident_lock_mins(int incident_lock_mins) {
		this.incident_lock_mins = incident_lock_mins;
	}

	public int getIncident_lock_mins() {
		return incident_lock_mins;
	}
	

	public int getPnr_last_x_days() {
		return pnr_last_x_days;
	}
	
	public void setPnr_last_x_days(int pnr_last_x_days) {
		this.pnr_last_x_days = pnr_last_x_days;
	}

	public int getIssuance_edit_last_x_days() {
		return issuance_edit_last_x_days;
	}
	
	public void setIssuance_edit_last_x_days(int issuance_edit_last_x_days) {
		this.issuance_edit_last_x_days = issuance_edit_last_x_days;
	}

	public String getStatus_message() {
		if (status_message == null) return "";
		return status_message;
	}

	public void setStatus_message(String status_message) {
		this.status_message = status_message;
	}

	public int getBagdrop_autorefresh_mins() {
		return bagdrop_autorefresh_mins;
	}
	public void setBagdrop_autorefresh_mins(int bagdrop_autorefresh_mins) {
		this.bagdrop_autorefresh_mins = bagdrop_autorefresh_mins;
	}
			

	public int getDefault_ld_loss_code() {
		return default_ld_loss_code;
	}

	public void setDefault_ld_loss_code(int default_ld_loss_code) {
		this.default_ld_loss_code = default_ld_loss_code;
	}

	public int getDefault_ld_fault_station() {
		return default_ld_fault_station;
	}
	
	public void setDefault_ld_fault_station(int default_ld_fault_station) {
		this.default_ld_fault_station = default_ld_fault_station;
	}

	public int getDefault_ms_loss_code() {
		return default_ms_loss_code;
	}
	
	public void setDefault_ms_loss_code(int default_ms_loss_code) {
		this.default_ms_loss_code = default_ms_loss_code;
	}

	public int getDefault_ms_fault_station() {
		return default_ms_fault_station;
	}
	
	public void setDefault_ms_fault_station(int default_ms_fault_station) {
		this.default_ms_fault_station = default_ms_fault_station;
	}

	public int getDefault_dm_loss_code() {
		return default_dm_loss_code;
	}
	
	public void setDefault_dm_loss_code(int default_dm_loss_code) {
		this.default_dm_loss_code = default_dm_loss_code;
	}
	
	private String getDefaultStation( int id ) {
		switch ( id ) {
		    case CommonsConstants.DEFAULT_CREATED :
			    return  "Creation Station";
		    case CommonsConstants.DEFAULT_ORIGIN:
		    	return  "Origin Station" ;
		    case CommonsConstants.DEFAULT_DESTINATION:
		    	return  "Destination Station" ;
		    default:
		    	return  "None" ;
		   
		}
	}

	@Transient
	public String getDefault_dm_fault_station_Str() {
		return getDefaultStation(default_dm_fault_station);
	}

	@Transient
	public int getDefault_dm_fault_station() {
		return default_dm_fault_station;
	}

	@Transient
	public String getDefault_ld_fault_station_Str() {
		return getDefaultStation(default_ld_fault_station);
	}

	@Transient
	public String getDefault_ms_fault_station_Str() {
		return getDefaultStation(default_ms_fault_station);
	}

	public void setDefault_dm_fault_station(int default_dm_fault_station) {
		this.default_dm_fault_station = default_dm_fault_station;
	}

	/**
	 * @return
	 * @hibernate.property type="integer"
	 */
	public int getAuto_pplc_email_ld() {
		return auto_pplc_email_ld;
	}

	public void setAuto_pplc_email_ld(int auto_pplc_email_ld) {
		this.auto_pplc_email_ld = auto_pplc_email_ld;
	}

	/**
	 * @return
	 * @hibernate.property type="integer"
	 */
	public int getAuto_pplc_email_dm() {
		return auto_pplc_email_dm;
	}

	public void setAuto_pplc_email_dm(int auto_pplc_email_dm) {
		this.auto_pplc_email_dm = auto_pplc_email_dm;
	}

	/**
	 * @return
	 * @hibernate.property type="integer"
	 */
	public int getAuto_pplc_email_ms() {
		return auto_pplc_email_ms;
	}

	public void setAuto_pplc_email_ms(int auto_pplc_email_ms) {
		this.auto_pplc_email_ms = auto_pplc_email_ms;
	}
}
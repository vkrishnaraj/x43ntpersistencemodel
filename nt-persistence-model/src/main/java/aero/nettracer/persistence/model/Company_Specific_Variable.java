package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "company_specific_variable")
public class Company_Specific_Variable {

	private String companyCode_ID;
	private int total_threads;
	private int seconds_wait;
	private double min_match_percent;
	private int mbr_to_lz_days;
	private int damaged_to_lz_days;
	private int miss_to_lz_days;
	private int ohd_to_lz_days;
	private int ohd_lz;
	private int lz_mode;
	private int report_method;
	private int default_station_code;
	private int default_loss_code;
	private boolean email_customer;
	private boolean autoCloseOhd;
	private boolean fraudReview;
	private double min_interim_approval_check;
	private double min_interim_approval_miles;
	private double min_interim_approval_voucher;
	private double min_interim_approval_incidental;
	private double min_interim_approval_cc_refund;
    private int bak_nttracer_data_days;
    private int bak_nttracer_ohd_data_days;
    private int bak_nttracer_lostfound_data_days;
	private int mbr_to_wt_days;
	private int ohd_to_wt_hours;
	private int oal_ohd_hours;
	private int oal_inc_hours;
	private boolean auto_wt_amend;
	private String wt_user;
	private String wt_pass;
	private int retrieve_actionfile_interval;
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
	private int pass_expire_days;
	private int max_failed_logins;
	private int webs_enabled;
	private int secure_password;
	private String wt_url;
	private String wt_airlinecode;
	private int wt_enabled;
	private int wt_write_enabled;
	private int scannerDefaultBack;
	private int scannerDefaultForward;
	private String blindEmail;
	private int min_pass_size;
	private int pass_x_history;
	private String status_message;
	private int bagdrop_autorefresh_mins;
	private int default_ld_loss_code;
	private int default_ld_fault_station;
	private int default_ms_loss_code;
	private int default_ms_fault_station;
	private int default_dm_loss_code;
	private int default_dm_fault_station;
	private int pnr_last_x_days;
	private int issuance_edit_last_x_days;
	private int auto_close_days_back;
	private int auto_close_ld_code;
	private int auto_close_dam_code;
	private int auto_close_pil_code;
	private int auto_close_ld_station;
	private int auto_close_dam_station;
	private int auto_close_pil_station;
	private int incident_lock_mins;
	private int auto_close_ohd_days_back;
	private int auto_pplc_email_ld;
	private int auto_pplc_email_dm;
	private int auto_pplc_email_ms;
	private Date auto_email_pplc_turnup;

	@Column(name = "companycode_id")
	public String getCompanyCode_ID() {
		return companyCode_ID;
	}

	public void setCompanyCode_ID(String companyCode_ID) {
		this.companyCode_ID = companyCode_ID;
	}

	@Column(name = "total_threads")
	public int getTotal_threads() {
		return total_threads;
	}

	public void setTotal_threads(int total_threads) {
		this.total_threads = total_threads;
	}

	@Column(name = "seconds_wait")
	public int getSeconds_wait() {
		return seconds_wait;
	}

	public void setSeconds_wait(int seconds_wait) {
		this.seconds_wait = seconds_wait;
	}

	@Column(name = "min_match_percent")
	public double getMin_match_percent() {
		return min_match_percent;
	}

	public void setMin_match_percent(double min_match_percent) {
		this.min_match_percent = min_match_percent;
	}

	@Column(name = "mbr_to_lz_days")
	public int getMbr_to_lz_days() {
		return mbr_to_lz_days;
	}

	public void setMbr_to_lz_days(int mbr_to_lz_days) {
		this.mbr_to_lz_days = mbr_to_lz_days;
	}

	@Column(name = "damaged_to_lz_days")
	public int getDamaged_to_lz_days() {
		return damaged_to_lz_days;
	}

	public void setDamaged_to_lz_days(int damaged_to_lz_days) {
		this.damaged_to_lz_days = damaged_to_lz_days;
	}

	@Column(name = "miss_to_lz_days")
	public int getMiss_to_lz_days() {
		return miss_to_lz_days;
	}

	public void setMiss_to_lz_days(int miss_to_lz_days) {
		this.miss_to_lz_days = miss_to_lz_days;
	}

	@Column(name = "ohd_to_lz_days")
	public int getOhd_to_lz_days() {
		return ohd_to_lz_days;
	}

	public void setOhd_to_lz_days(int ohd_to_lz_days) {
		this.ohd_to_lz_days = ohd_to_lz_days;
	}

	@Column(name = "ohd_lz")
	public int getOhd_lz() {
		return ohd_lz;
	}

	public void setOhd_lz(int ohd_lz) {
		this.ohd_lz = ohd_lz;
	}

	@Column(name = "lz_mode")
	public int getLz_mode() {
		return lz_mode;
	}

	public void setLz_mode(int lz_mode) {
		this.lz_mode = lz_mode;
	}

	@Column(name = "report_method")
	public int getReport_method() {
		return report_method;
	}

	public void setReport_method(int report_method) {
		this.report_method = report_method;
	}

	@Column(name = "default_station_code")
	public int getDefault_station_code() {
		return default_station_code;
	}

	public void setDefault_station_code(int default_station_code) {
		this.default_station_code = default_station_code;
	}

	@Column(name = "default_loss_code")
	public int getDefault_loss_code() {
		return default_loss_code;
	}

	public void setDefault_loss_code(int default_loss_code) {
		this.default_loss_code = default_loss_code;
	}

	@Column(name = "email_customer")
	public boolean isEmail_customer() {
		return email_customer;
	}

	public void setEmail_customer(boolean email_customer) {
		this.email_customer = email_customer;
	}

	@Column(name = "autoCloseOhd")
	public boolean isAutoCloseOhd() {
		return autoCloseOhd;
	}

	public void setAutoCloseOhd(boolean autoCloseOhd) {
		this.autoCloseOhd = autoCloseOhd;
	}

	@Column(name = "fraudReview")
	public boolean isFraudReview() {
		return fraudReview;
	}

	public void setFraudReview(boolean fraudReview) {
		this.fraudReview = fraudReview;
	}

	@Column(name = "min_interim_approval_check")
	public double getMin_interim_approval_check() {
		return min_interim_approval_check;
	}

	public void setMin_interim_approval_check(double min_interim_approval_check) {
		this.min_interim_approval_check = min_interim_approval_check;
	}

	@Column(name = "min_interim_approval_miles")
	public double getMin_interim_approval_miles() {
		return min_interim_approval_miles;
	}

	public void setMin_interim_approval_miles(double min_interim_approval_miles) {
		this.min_interim_approval_miles = min_interim_approval_miles;
	}

	@Column(name = "min_interim_approval_voucher")
	public double getMin_interim_approval_voucher() {
		return min_interim_approval_voucher;
	}

	public void setMin_interim_approval_voucher(double min_interim_approval_voucher) {
		this.min_interim_approval_voucher = min_interim_approval_voucher;
	}

	@Column(name = "min_interim_approval_incidental")
	public double getMin_interim_approval_incidental() {
		return min_interim_approval_incidental;
	}

	public void setMin_interim_approval_incidental(double min_interim_approval_incidental) {
		this.min_interim_approval_incidental = min_interim_approval_incidental;
	}

	@Column(name = "min_interim_approval_cc_refund")
	public double getMin_interim_approval_cc_refund() {
		return min_interim_approval_cc_refund;
	}

	public void setMin_interim_approval_cc_refund(double min_interim_approval_cc_refund) {
		this.min_interim_approval_cc_refund = min_interim_approval_cc_refund;
	}

	@Column(name = "bak_nttracer_data_days")
	public int getBak_nttracer_data_days() {
		return bak_nttracer_data_days;
	}

	public void setBak_nttracer_data_days(int bak_nttracer_data_days) {
		this.bak_nttracer_data_days = bak_nttracer_data_days;
	}

	@Column(name = "bak_nttracer_ohd_data_days")
	public int getBak_nttracer_ohd_data_days() {
		return bak_nttracer_ohd_data_days;
	}

	public void setBak_nttracer_ohd_data_days(int bak_nttracer_ohd_data_days) {
		this.bak_nttracer_ohd_data_days = bak_nttracer_ohd_data_days;
	}

	@Column(name = "bak_nttracer_lostfound_data_days")
	public int getBak_nttracer_lostfound_data_days() {
		return bak_nttracer_lostfound_data_days;
	}

	public void setBak_nttracer_lostfound_data_days(int bak_nttracer_lostfound_data_days) {
		this.bak_nttracer_lostfound_data_days = bak_nttracer_lostfound_data_days;
	}

	@Column(name = "mbr_to_wt_days")
	public int getMbr_to_wt_days() {
		return mbr_to_wt_days;
	}

	public void setMbr_to_wt_days(int mbr_to_wt_days) {
		this.mbr_to_wt_days = mbr_to_wt_days;
	}

	@Column(name = "ohd_to_wt_hours")
	public int getOhd_to_wt_hours() {
		return ohd_to_wt_hours;
	}

	public void setOhd_to_wt_hours(int ohd_to_wt_hours) {
		this.ohd_to_wt_hours = ohd_to_wt_hours;
	}

	@Column(name = "oal_ohd_hours")
	public int getOal_ohd_hours() {
		return oal_ohd_hours;
	}

	public void setOal_ohd_hours(int oal_ohd_hours) {
		this.oal_ohd_hours = oal_ohd_hours;
	}

	@Column(name = "oal_inc_hours")
	public int getOal_inc_hours() {
		return oal_inc_hours;
	}

	public void setOal_inc_hours(int oal_inc_hours) {
		this.oal_inc_hours = oal_inc_hours;
	}

	@Column(name = "auto_wt_amend")
	public boolean isAuto_wt_amend() {
		return auto_wt_amend;
	}

	public void setAuto_wt_amend(boolean auto_wt_amend) {
		this.auto_wt_amend = auto_wt_amend;
	}

	@Column(name = "wt_user")
	public String getWt_user() {
		return wt_user;
	}

	public void setWt_user(String wt_user) {
		this.wt_user = wt_user;
	}

	@Column(name = "wt_pass")
	public String getWt_pass() {
		return wt_pass;
	}

	public void setWt_pass(String wt_pass) {
		this.wt_pass = wt_pass;
	}

	@Column(name = "retrieve_actionfile_interval")
	public int getRetrieve_actionfile_interval() {
		return retrieve_actionfile_interval;
	}

	public void setRetrieve_actionfile_interval(int retrieve_actionfile_interval) {
		this.retrieve_actionfile_interval = retrieve_actionfile_interval;
	}

	@Column(name = "audit_ohd")
	public int getAudit_ohd() {
		return audit_ohd;
	}

	public void setAudit_ohd(int audit_ohd) {
		this.audit_ohd = audit_ohd;
	}

	@Column(name = "audit_lost_found")
	public int getAudit_lost_found() {
		return audit_lost_found;
	}

	public void setAudit_lost_found(int audit_lost_found) {
		this.audit_lost_found = audit_lost_found;
	}

	@Column(name = "audit_lost_delayed")
	public int getAudit_lost_delayed() {
		return audit_lost_delayed;
	}

	public void setAudit_lost_delayed(int audit_lost_delayed) {
		this.audit_lost_delayed = audit_lost_delayed;
	}

	@Column(name = "audit_damaged")
	public int getAudit_damaged() {
		return audit_damaged;
	}

	public void setAudit_damaged(int audit_damaged) {
		this.audit_damaged = audit_damaged;
	}

	@Column(name = "audit_missing_articles")
	public int getAudit_missing_articles() {
		return audit_missing_articles;
	}

	public void setAudit_missing_articles(int audit_missing_articles) {
		this.audit_missing_articles = audit_missing_articles;
	}

	@Column(name = "audit_agent")
	public int getAudit_agent() {
		return audit_agent;
	}

	public void setAudit_agent(int audit_agent) {
		this.audit_agent = audit_agent;
	}

	@Column(name = "audit_group")
	public int getAudit_group() {
		return audit_group;
	}

	public void setAudit_group(int audit_group) {
		this.audit_group = audit_group;
	}

	@Column(name = "audit_company")
	public int getAudit_company() {
		return audit_company;
	}

	public void setAudit_company(int audit_company) {
		this.audit_company = audit_company;
	}

	@Column(name = "audit_shift")
	public int getAudit_shift() {
		return audit_shift;
	}

	public void setAudit_shift(int audit_shift) {
		this.audit_shift = audit_shift;
	}

	@Column(name = "audit_station")
	public int getAudit_station() {
		return audit_station;
	}

	public void setAudit_station(int audit_station) {
		this.audit_station = audit_station;
	}

	@Column(name = "audit_loss_codes")
	public int getAudit_loss_codes() {
		return audit_loss_codes;
	}

	public void setAudit_loss_codes(int audit_loss_codes) {
		this.audit_loss_codes = audit_loss_codes;
	}

	@Column(name = "audit_claims")
	public int getAudit_claims() {
		return audit_claims;
	}

	public void setAudit_claims(int audit_claims) {
		this.audit_claims = audit_claims;
	}

	@Column(name = "audit_airport")
	public int getAudit_airport() {
		return audit_airport;
	}

	public void setAudit_airport(int audit_airport) {
		this.audit_airport = audit_airport;
	}

	@Column(name = "audit_delivery_companies")
	public int getAudit_delivery_companies() {
		return audit_delivery_companies;
	}

	public void setAudit_delivery_companies(int audit_delivery_companies) {
		this.audit_delivery_companies = audit_delivery_companies;
	}

	@Column(name = "max_image_file_size")
	public int getMax_image_file_size() {
		return max_image_file_size;
	}

	public void setMax_image_file_size(int max_image_file_size) {
		this.max_image_file_size = max_image_file_size;
	}

	@Column(name = "email_host")
	public String getEmail_host() {
		return email_host;
	}

	public void setEmail_host(String email_host) {
		this.email_host = email_host;
	}

	@Column(name = "email_port")
	public int getEmail_port() {
		return email_port;
	}

	public void setEmail_port(int email_port) {
		this.email_port = email_port;
	}

	@Column(name = "email_from")
	public String getEmail_from() {
		return email_from;
	}

	public void setEmail_from(String email_from) {
		this.email_from = email_from;
	}

	@Column(name = "email_to")
	public String getEmail_to() {
		return email_to;
	}

	public void setEmail_to(String email_to) {
		this.email_to = email_to;
	}

	@Column(name = "pass_expire_days")
	public int getPass_expire_days() {
		return pass_expire_days;
	}

	public void setPass_expire_days(int pass_expire_days) {
		this.pass_expire_days = pass_expire_days;
	}

	@Column(name = "max_failed_logins")
	public int getMax_failed_logins() {
		return max_failed_logins;
	}

	public void setMax_failed_logins(int max_failed_logins) {
		this.max_failed_logins = max_failed_logins;
	}

	@Column(name = "webs_enabled")
	public int getWebs_enabled() {
		return webs_enabled;
	}

	public void setWebs_enabled(int webs_enabled) {
		this.webs_enabled = webs_enabled;
	}

	@Column(name = "secure_password")
	public int getSecure_password() {
		return secure_password;
	}

	public void setSecure_password(int secure_password) {
		this.secure_password = secure_password;
	}

	@Column(name = "wt_url")
	public String getWt_url() {
		return wt_url;
	}

	public void setWt_url(String wt_url) {
		this.wt_url = wt_url;
	}

	@Column(name = "wt_airlinecode")
	public String getWt_airlinecode() {
		return wt_airlinecode;
	}

	public void setWt_airlinecode(String wt_airlinecode) {
		this.wt_airlinecode = wt_airlinecode;
	}

	@Column(name = "wt_enabled")
	public int getWt_enabled() {
		return wt_enabled;
	}

	public void setWt_enabled(int wt_enabled) {
		this.wt_enabled = wt_enabled;
	}

	@Column(name = "wt_write_enabled")
	public int getWt_write_enabled() {
		return wt_write_enabled;
	}

	public void setWt_write_enabled(int wt_write_enabled) {
		this.wt_write_enabled = wt_write_enabled;
	}

	@Column(name = "scannerDefaultBack")
	public int getScannerDefaultBack() {
		return scannerDefaultBack;
	}

	public void setScannerDefaultBack(int scannerDefaultBack) {
		this.scannerDefaultBack = scannerDefaultBack;
	}

	@Column(name = "scannerDefaultForward")
	public int getScannerDefaultForward() {
		return scannerDefaultForward;
	}

	public void setScannerDefaultForward(int scannerDefaultForward) {
		this.scannerDefaultForward = scannerDefaultForward;
	}

	@Column(name = "blindEmail")
	public String getBlindEmail() {
		return blindEmail;
	}

	public void setBlindEmail(String blindEmail) {
		this.blindEmail = blindEmail;
	}

	@Column(name = "min_pass_size")
	public int getMin_pass_size() {
		return min_pass_size;
	}

	public void setMin_pass_size(int min_pass_size) {
		this.min_pass_size = min_pass_size;
	}

	@Column(name = "pass_x_history")
	public int getPass_x_history() {
		return pass_x_history;
	}

	public void setPass_x_history(int pass_x_history) {
		this.pass_x_history = pass_x_history;
	}

	@Column(name = "status_message")
	public String getStatus_message() {
		return status_message;
	}

	public void setStatus_message(String status_message) {
		this.status_message = status_message;
	}

	@Column(name = "bagdrop_autorefresh_mins")
	public int getBagdrop_autorefresh_mins() {
		return bagdrop_autorefresh_mins;
	}

	public void setBagdrop_autorefresh_mins(int bagdrop_autorefresh_mins) {
		this.bagdrop_autorefresh_mins = bagdrop_autorefresh_mins;
	}

	@Column(name = "default_ld_loss_code")
	public int getDefault_ld_loss_code() {
		return default_ld_loss_code;
	}

	public void setDefault_ld_loss_code(int default_ld_loss_code) {
		this.default_ld_loss_code = default_ld_loss_code;
	}

	@Column(name = "default_ld_fault_station")
	public int getDefault_ld_fault_station() {
		return default_ld_fault_station;
	}

	public void setDefault_ld_fault_station(int default_ld_fault_station) {
		this.default_ld_fault_station = default_ld_fault_station;
	}

	@Column(name = "default_ms_loss_code")
	public int getDefault_ms_loss_code() {
		return default_ms_loss_code;
	}

	public void setDefault_ms_loss_code(int default_ms_loss_code) {
		this.default_ms_loss_code = default_ms_loss_code;
	}

	@Column(name = "default_ms_fault_station")
	public int getDefault_ms_fault_station() {
		return default_ms_fault_station;
	}

	public void setDefault_ms_fault_station(int default_ms_fault_station) {
		this.default_ms_fault_station = default_ms_fault_station;
	}

	@Column(name = "default_dm_loss_code")
	public int getDefault_dm_loss_code() {
		return default_dm_loss_code;
	}

	public void setDefault_dm_loss_code(int default_dm_loss_code) {
		this.default_dm_loss_code = default_dm_loss_code;
	}

	@Column(name = "default_dm_fault_station")
	public int getDefault_dm_fault_station() {
		return default_dm_fault_station;
	}

	public void setDefault_dm_fault_station(int default_dm_fault_station) {
		this.default_dm_fault_station = default_dm_fault_station;
	}

	@Column(name = "pnr_last_x_days")
	public int getPnr_last_x_days() {
		return pnr_last_x_days;
	}

	public void setPnr_last_x_days(int pnr_last_x_days) {
		this.pnr_last_x_days = pnr_last_x_days;
	}

	@Column(name = "issuance_edit_last_x_days")
	public int getIssuance_edit_last_x_days() {
		return issuance_edit_last_x_days;
	}

	public void setIssuance_edit_last_x_days(int issuance_edit_last_x_days) {
		this.issuance_edit_last_x_days = issuance_edit_last_x_days;
	}

	@Column(name = "auto_close_days_back")
	public int getAuto_close_days_back() {
		return auto_close_days_back;
	}

	public void setAuto_close_days_back(int auto_close_days_back) {
		this.auto_close_days_back = auto_close_days_back;
	}

	@Column(name = "auto_close_ld_code")
	public int getAuto_close_ld_code() {
		return auto_close_ld_code;
	}

	public void setAuto_close_ld_code(int auto_close_ld_code) {
		this.auto_close_ld_code = auto_close_ld_code;
	}

	@Column(name = "auto_close_dam_code")
	public int getAuto_close_dam_code() {
		return auto_close_dam_code;
	}

	public void setAuto_close_dam_code(int auto_close_dam_code) {
		this.auto_close_dam_code = auto_close_dam_code;
	}

	@Column(name = "auto_close_pil_code")
	public int getAuto_close_pil_code() {
		return auto_close_pil_code;
	}

	public void setAuto_close_pil_code(int auto_close_pil_code) {
		this.auto_close_pil_code = auto_close_pil_code;
	}

	@Column(name = "auto_close_ld_station")
	public int getAuto_close_ld_station() {
		return auto_close_ld_station;
	}

	public void setAuto_close_ld_station(int auto_close_ld_station) {
		this.auto_close_ld_station = auto_close_ld_station;
	}

	@Column(name = "auto_close_dam_station")
	public int getAuto_close_dam_station() {
		return auto_close_dam_station;
	}

	public void setAuto_close_dam_station(int auto_close_dam_station) {
		this.auto_close_dam_station = auto_close_dam_station;
	}

	@Column(name = "auto_close_pil_station")
	public int getAuto_close_pil_station() {
		return auto_close_pil_station;
	}

	public void setAuto_close_pil_station(int auto_close_pil_station) {
		this.auto_close_pil_station = auto_close_pil_station;
	}

	@Column(name = "incident_lock_mins")
	public int getIncident_lock_mins() {
		return incident_lock_mins;
	}

	public void setIncident_lock_mins(int incident_lock_mins) {
		this.incident_lock_mins = incident_lock_mins;
	}

	@Column(name = "auto_close_ohd_days_back")
	public int getAuto_close_ohd_days_back() {
		return auto_close_ohd_days_back;
	}

	public void setAuto_close_ohd_days_back(int auto_close_ohd_days_back) {
		this.auto_close_ohd_days_back = auto_close_ohd_days_back;
	}

	@Column(name = "auto_pplc_email_ld")
	public int getAuto_pplc_email_ld() {
		return auto_pplc_email_ld;
	}

	public void setAuto_pplc_email_ld(int auto_pplc_email_ld) {
		this.auto_pplc_email_ld = auto_pplc_email_ld;
	}

	@Column(name = "auto_pplc_email_dm")
	public int getAuto_pplc_email_dm() {
		return auto_pplc_email_dm;
	}

	public void setAuto_pplc_email_dm(int auto_pplc_email_dm) {
		this.auto_pplc_email_dm = auto_pplc_email_dm;
	}

	@Column(name = "auto_pplc_email_ms")
	public int getAuto_pplc_email_ms() {
		return auto_pplc_email_ms;
	}

	public void setAuto_pplc_email_ms(int auto_pplc_email_ms) {
		this.auto_pplc_email_ms = auto_pplc_email_ms;
	}

	@Column(name = "auto_email_pplc_turnup")
	@Temporal(TemporalType.DATE)
	public Date getAuto_email_pplc_turnup() {
		return auto_email_pplc_turnup;
	}

	public void setAuto_email_pplc_turnup(Date auto_email_pplc_turnup) {
		this.auto_email_pplc_turnup = auto_email_pplc_turnup;
	}
}
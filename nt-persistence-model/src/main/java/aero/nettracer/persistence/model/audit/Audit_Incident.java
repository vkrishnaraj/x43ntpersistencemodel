package aero.nettracer.persistence.model.audit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import aero.nettracer.commons.constant.GenericConstants;
import aero.nettracer.commons.utils.GenericDateUtils;
import aero.nettracer.persistence.model.Agent;
import aero.nettracer.persistence.model.ItemType;
import aero.nettracer.persistence.model.Station;
import aero.nettracer.persistence.model.Status;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Audit_Incident")
public class Audit_Incident implements Serializable {

	private static final long serialVersionUID = 1L;
	private int audit_incident_id;
	private String Incident_ID;
	private Station stationcreated;
	private Station stationassigned;
	private Station faultstation;
	private Agent agent;
	private Agent agentassigned;
	private Date createdate;
	private Date createtime;
	private Date closedate;
	private String recordlocator;
	private String manualreportnum;
	private String ticketnumber;
	private int reportmethod;
	private String checkedlocation;
	private int numpassengers;
	private int numbagchecked;
	private int numbagreceived;
	private int voluntaryseparation;
	private int courtesyreport;
	private int tsachecked;
	private int customcleared;
	private int nonrevenue;
	private ItemType itemtype;
	private Status status;
	private int loss_code;
	private Date ohd_lasttraced;
	private String wt_id;
	private Set<Audit_Passenger> passengers;
	private List<Audit_Item> itemlist;
	private Set<Audit_Articles> articles;
	private Set<Audit_Remark> remarks;
	private Set<Audit_Itinerary> itinerary;
	private long oc_claim_id;
	private Set<Audit_Incident_Claimcheck> claimchecks;
	private String instructions;
	private ArrayList itinerary_list;
	private ArrayList claimcheck_list;
	private ArrayList passenger_list;
	private String _DATEFORMAT;
	private String _TIMEFORMAT;
	private TimeZone _TIMEZONE;
	private Agent modify_agent;
	private Date modify_time;
	private String modify_reason;
	private String language;
	private boolean locked = false;
	private String revenueCode;
	private int tracingStatus;
	private Date tracingStarted;
	private Date tracingComplete;
	private Agent tracingAgent;
	private Date rxTimestamp;
	private int courtesyReasonId;
	private String courtesyDescription;
	private boolean paxCommEnabled;
	private Date assignedDate;
	private Date paxPplcEnabled;

	@Column(name = "tracing_status_id")
	public int getTracingStatus() {
		return tracingStatus;
	}

	public void setTracingStatus(int tracingStatus) {
		this.tracingStatus = tracingStatus;
	}

	public Date getTracingStarted() {
		return tracingStarted;
	}

	public void setTracingStarted(Date tracingStarted) {
		this.tracingStarted = tracingStarted;
	}

	public Date getTracingComplete() {
		return tracingComplete;
	}

	public void setTracingComplete(Date tracingComplete) {
		this.tracingComplete = tracingComplete;
	}

	@ManyToOne
	@JoinColumn(name = "tracing_agent_ID")
	public Agent getTracingAgent() {
		return tracingAgent;
	}

	public void setTracingAgent(Agent tracingAgent) {
		this.tracingAgent = tracingAgent;
	}

	@Column(name = "revenue_code")
	public String getRevenueCode() {
		return revenueCode;
	}

	public void setRevenueCode(String revenueCode) {
		this.revenueCode = revenueCode;
	}

	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public Double getOverall_weight() {
		return overall_weight;
	}

	public void setOverall_weight(Double overall_weight) {
		this.overall_weight = overall_weight;
	}

	public String getOverall_weight_unit() {
		return overall_weight_unit;
	}

	public void setOverall_weight_unit(String overall_weight_unit) {
		this.overall_weight_unit = overall_weight_unit;
	}

	private Double overall_weight;
	private String overall_weight_unit;

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	private long checklist_version;    // for auto checklist

	public long getChecklist_version() {
		return checklist_version;
	}

	public void setChecklist_version(long checklist_version) {
		this.checklist_version = checklist_version;
	}

	@ManyToOne
	@JoinColumn(name = "modify_agent_id")
	public Agent getModify_agent() {
		return modify_agent;
	}

	public void setModify_agent(Agent modify_agent) {
		this.modify_agent = modify_agent;
	}

	public String getModify_reason() {
		return modify_reason;
	}

	public void setModify_reason(String modify_reason) {
		this.modify_reason = modify_reason;
	}

	public Date getModify_time() {
		return modify_time;
	}

	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}

	@Transient
	public String getDispmodify_time() {
		Date completedate = GenericDateUtils.convertToDate(getModify_time().toString(),
				GenericConstants.DB_DATETIMEFORMAT, null);
		return GenericDateUtils.formatDate(completedate, _DATEFORMAT + " " + _TIMEFORMAT, null, _TIMEZONE);
	}

	@Id
	@GeneratedValue
	public int getAudit_incident_id() {
		return audit_incident_id;
	}

	public void setAudit_incident_id(int audit_incident_id) {
		this.audit_incident_id = audit_incident_id;
	}

	@ManyToOne
	@JoinColumn(name = "status_ID")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@ManyToOne
	@JoinColumn(name = "itemType_ID")
	public ItemType getItemtype() {
		return itemtype;
	}

	public void setItemtype(ItemType itemtype) {
		this.itemtype = itemtype;
	}

	@ManyToOne
	@JoinColumn(name = "agent_ID")
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@ManyToOne
	@JoinColumn(name = "agentassigned_ID")
	public Agent getAgentassigned() {
		return agentassigned;
	}

	public void setAgentassigned(Agent agentassigned) {
		this.agentassigned = agentassigned;
	}

	@ManyToOne
	@JoinColumn(name = "stationassigned_ID")
	public Station getStationassigned() {
		return stationassigned;
	}

	public void setStationassigned(Station stationassigned) {
		this.stationassigned = stationassigned;
	}

	@ManyToOne
	@JoinColumn(name = "stationcreated_ID")
	public Station getStationcreated() {
		return stationcreated;
	}

	public void setStationcreated(Station stationcreated) {
		this.stationcreated = stationcreated;
	}

	@ManyToOne
	@JoinColumn(name = "faultstation_ID")
	public Station getFaultstation() {
		return faultstation;
	}

	public void setFaultstation(Station faultstation) {
		this.faultstation = faultstation;
	}

	@OneToMany(mappedBy = "audit_incident")
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "claimcheck_ID")
	public Set<Audit_Incident_Claimcheck> getClaimchecks() {
		return claimchecks;
	}

	public void setClaimchecks(Set<Audit_Incident_Claimcheck> claimchecks) {
		this.claimchecks = claimchecks;
		this.claimcheck_list = (claimchecks != null ? new ArrayList(claimchecks) : new ArrayList());
	}

	@OneToMany(mappedBy = "audit_incident", fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	public List<Audit_Item> getItemlist() {
		return itemlist;
	}

	public void setItemlist(List<Audit_Item> itemlist) {
		this.itemlist = itemlist;
	}

	@OneToMany(mappedBy = "audit_incident", fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "articles_ID DESC")
	public Set<Audit_Articles> getArticles() {
		return articles;
	}

	public void setArticles(Set<Audit_Articles> articles) {
		this.articles = articles;
	}

	@OneToMany(mappedBy = "audit_incident")
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "passenger_id")
	public Set<Audit_Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<Audit_Passenger> passengers) {
		this.passengers = passengers;
		this.passenger_list = (passengers != null ? new ArrayList(passengers) : new ArrayList());
	}

	@OneToMany(mappedBy = "audit_incident", fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "createtime")
	public Set<Audit_Remark> getRemarks() {
		return remarks;
	}

	public void setRemarks(Set<Audit_Remark> remarks) {
		this.remarks = remarks;
	}

	@OneToMany(mappedBy = "audit_incident")
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "itinerary_ID")
	public Set<Audit_Itinerary> getItinerary() {
		return itinerary;
	}

	public void setItinerary(Set<Audit_Itinerary> itinerary) {
		this.itinerary = itinerary;
		this.itinerary_list = (itinerary != null ? new ArrayList(itinerary) : new ArrayList());
	}

	public String getCheckedlocation() {
		return checkedlocation;
	}

	public void setCheckedlocation(String checkedlocation) {
		this.checkedlocation = checkedlocation;
	}

	public int getCourtesyreport() {
		return courtesyreport;
	}

	public void setCourtesyreport(int courtesyreport) {
		this.courtesyreport = courtesyreport;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Transient
	public String getDisplaydate() {
		Date completedate = GenericDateUtils.convertToDate(getCreatedate().toString() + " "
				+ getCreatetime().toString(), GenericConstants.DB_DATETIMEFORMAT, null);
		return GenericDateUtils.formatDate(completedate, _DATEFORMAT + " " + _TIMEFORMAT, null, _TIMEZONE);
	}

	@Column(name = "close_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getClosedate() {
		return closedate;
	}

	public void setClosedate(Date closedate) {
		this.closedate = closedate;
	}

	@Transient
	public String getDispclosedate() {
		return GenericDateUtils.formatDate(getClosedate(), get_DATEFORMAT() + " " + get_TIMEFORMAT(), null, get_TIMEZONE());
	}

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

	public String getIncident_ID() {
		return Incident_ID;
	}

	public void setIncident_ID(String incident_ID) {
		Incident_ID = incident_ID;
	}

	public int getNumbagchecked() {
		return numbagchecked;
	}

	public void setNumbagchecked(int numbagchecked) {
		this.numbagchecked = numbagchecked;
	}

	public int getNumbagreceived() {
		return numbagreceived;
	}

	public void setNumbagreceived(int numbagreceived) {
		this.numbagreceived = numbagreceived;
	}

	public int getNumpassengers() {
		return numpassengers;
	}

	public void setNumpassengers(int numpassengers) {
		this.numpassengers = numpassengers;
	}

	public int getReportmethod() {
		return reportmethod;
	}

	public void setReportmethod(int reportmethod) {
		this.reportmethod = reportmethod;
	}

	public String getTicketnumber() {
		return ticketnumber;
	}

	public void setTicketnumber(String ticketnumber) {
		this.ticketnumber = ticketnumber;
	}

	public int getTsachecked() {
		return tsachecked;
	}

	public void setTsachecked(int tsachecked) {
		this.tsachecked = tsachecked;
	}

	public int getCustomcleared() {
		return customcleared;
	}

	public void setCustomcleared(int customcleared) {
		this.customcleared = customcleared;
	}

	public int getVoluntaryseparation() {
		return voluntaryseparation;
	}

	public void setVoluntaryseparation(int voluntaryseparation) {
		this.voluntaryseparation = voluntaryseparation;
	}

	public String getManualreportnum() {
		return manualreportnum;
	}

	public void setManualreportnum(String manualreportnum) {
		this.manualreportnum = manualreportnum;
	}

	public String getRecordlocator() {
		return recordlocator;
	}

	public void setRecordlocator(String recordlocator) {
		this.recordlocator = recordlocator;
	}

	public int getNonrevenue() {
		return nonrevenue;
	}

	public void setNonrevenue(int nonrevenue) {
		this.nonrevenue = nonrevenue;
	}

	public Date getOhd_lasttraced() {
		return ohd_lasttraced;
	}

	public void setOhd_lasttraced(Date ohd_lasttraced) {
		this.ohd_lasttraced = ohd_lasttraced;
	}

	public int getLoss_code() {
		return loss_code;
	}

	public void setLoss_code(int loss_code) {
		this.loss_code = loss_code;
	}
	
	public String getWt_id() {
		return wt_id;
	}

	public void setWt_id(String wt_id) {
		this.wt_id = wt_id;
	}

	@Transient
	public ArrayList getItinerary_list() {
		return itinerary_list;
	}

	@Transient
	public ArrayList getClaimcheck_list() {
		return claimcheck_list;
	}

	@Transient
	public ArrayList getPassenger_list() {
		return passenger_list;
	}

	@Transient
	public ArrayList getRemark_list() {
		return new ArrayList((remarks != null ? remarks : new HashSet()));
	}

	@Transient
	public ArrayList getArticle_list() {
		return new ArrayList((articles != null ? articles : new HashSet()));
	}

	public long getOc_claim_id() {
  	return oc_claim_id;
  }
	public void setOc_claim_id(long oc_claim_id) {
  	this.oc_claim_id = oc_claim_id;
  }
	
	public Date getRxTimestamp() {
		return rxTimestamp;
	}

	public void setRxTimestamp(Date rxTimestamp) {
		this.rxTimestamp = rxTimestamp;
	}

	@Transient
	public String getDispRxTimestamp() {
		return getRxTimestamp() != null ? GenericDateUtils.formatDate(getRxTimestamp(), get_DATEFORMAT() + " " + get_TIMEFORMAT(), null, get_TIMEZONE()) : " ";
	}

	public int getCourtesyReasonId() {
		return courtesyReasonId;
	}

	public void setCourtesyReasonId(int courtesyReasonId) {
		this.courtesyReasonId = courtesyReasonId;
	}

	//NTFIXME
	/*@Transient
	public String getDispCourtesyReason() {
		return TracerUtils.getText(Status.getKey(getCourtesyReasonId()), (String) null);
	}*/

	public String getCourtesyDescription() {
		return courtesyDescription;
	}

	public void setCourtesyDescription(String courtesyDescription) {
		this.courtesyDescription = courtesyDescription;
	}

	@Column(name = "pax_comm_enabled")
	public boolean isPaxCommEnabled() {
		return this.paxCommEnabled;
	}

	public void setPaxCommEnabled(boolean isEnabled) {
		this.paxCommEnabled = isEnabled;
	}

	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	public Date getPaxPplcEnabled() {
		return this.paxPplcEnabled;
	}

	@Transient
	public String getDispPaxPplcEnabled() {
		return GenericDateUtils.formatDate(getPaxPplcEnabled(), get_DATEFORMAT() + " " + get_TIMEFORMAT(), null, get_TIMEZONE());
	}

	public void setPaxPplcEnabled(Date paxPplcEnabled) {
		this.paxPplcEnabled = paxPplcEnabled;
	}
}

/*
 * Created on Jul 13, 2004
 *
 */
package aero.nettracer.persistence.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import aero.nettracer.persistence.model.communications.IncidentActivity;
import aero.nettracer.persistence.model.dr.Dispute;
import aero.nettracer.persistence.model.issuance.IssuanceItemIncident;
import aero.nettracer.persistence.model.taskmanager.FourDayTask;
import aero.nettracer.persistence.model.taskmanager.ThreeDayTask;
import aero.nettracer.persistence.model.taskmanager.TwoDayTask;
import aero.nettracer.persistence.util.ReportMethod;
import aero.nettracer.persistence.util.TracingStatus;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OrderBy;

@Entity
@Table(name = "incident")
public class Incident {

	private String id;
	private ItemType itemtype;
	private Station stationcreated;
	private Station stationassigned;
	private Station faultstation;
	private int loss_code;
	private Agent agent;
	private Agent agentassigned;
	private String recordlocator;
	private String manualreportnum;
	private Status status;
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
	private Timestamp lastupdated;
	private Timestamp ohd_lasttraced;
	private Date createdate;
	private Time createtime;
	private Timestamp closedate;
	private int version;
	private WorldTracerFile wtFile;
	private Timestamp printedreceipt;
	private String language;
	private long checklist_version;
	private Double overall_weight;
	private String overall_weight_unit;
	private boolean locked = false;
	private long oc_claim_id;
	private String revenueCode;
	private boolean codeLocked = false;
	private boolean stationLocked = false;
	private int tracingStatus;
	private DeliveryInstructions deliveryInstructions;
	private Timestamp tracingStarted;
	private Timestamp tracingComplete;
	private Agent tracingAgent;
	private String wtCompanyCode;
	private String wtStationCode;
	private Timestamp rxTimestamp;
	private int courtesyReasonId;
	private String courtesyDescription;
	private int custCommId;
	private int claimStatusId;
	private int cbn;
	private boolean paxCommEnabled = true;
	private Timestamp paxview_login_date;
	private Timestamp assignedDate;
	private boolean prioritized;
	private Timestamp paxPplcEnabled;
	private CrmFile crmFile;
	private Dispute dispute;
	private IncidentControl incidentControl;
	private Set<ExpensePayout> expenses;
	private Set<Incident_Claimcheck> claimchecks;
	private List<Item> itemlist;
	private Set<Articles> articles;
	private Set<Passenger> passengers;
	private Set<Remark> remarks;
	private Set<Itinerary> itinerary;
	private Set<Claim> claims;
	private List<IssuanceItemIncident> issuanceItemIncidents;
	private Set<IncidentActivity> activities;
	private TwoDayTask twoDayTask;
	private ThreeDayTask threeDayTask;
	private FourDayTask fourDayTask;

	//Start

	@Id
	@GeneratedValue
	@Column(name = "incident_id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "itemtype_id", nullable = false)
	public ItemType getItemtype() {
		return itemtype;
	}

	public void setItemtype(ItemType itemtype) {
		this.itemtype = itemtype;
	}

	@ManyToOne
	@JoinColumn(name = "stationcreated_id", nullable = false)
	public Station getStationcreated() {
		return stationcreated;
	}

	public void setStationcreated(Station stationcreated) {
		this.stationcreated = stationcreated;
	}

	@ManyToOne
	@JoinColumn(name = "stationassigned_id", nullable = false)
	public Station getStationassigned() {
		return stationassigned;
	}

	public void setStationassigned(Station stationassigned) {
		this.stationassigned = stationassigned;
	}

	@ManyToOne
	@JoinColumn(name = "faultstation_id")
	public Station getFaultstation() {
		return faultstation;
	}

	public void setFaultstation(Station faultstation) {
		this.faultstation = faultstation;
	}

	@Column(name = "loss_code")
	public int getLoss_code() {
		return loss_code;
	}

	public void setLoss_code(int loss_code) {
		this.loss_code = loss_code;
	}

	@ManyToOne
	@JoinColumn(name = "agent_id", nullable = false)
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@ManyToOne
	@JoinColumn(name = "agentassigned_id")
	public Agent getAgentassigned() {
		return agentassigned;
	}

	public void setAgentassigned(Agent agentassigned) {
		this.agentassigned = agentassigned;
	}

	@Column(name = "recordlocator")
	public String getRecordlocator() {
		return recordlocator;
	}

	public void setRecordlocator(String recordlocator) {
		this.recordlocator = recordlocator;
	}

	@Column(name = "manualreportnum")
	public String getManualreportnum() {
		return manualreportnum;
	}

	public void setManualreportnum(String manualreportnum) {
		this.manualreportnum = manualreportnum;
	}

	@ManyToOne
	@JoinColumn(name = "status_id", nullable = false)
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Column(name = "ticketnumber")
	public String getTicketnumber() {
		return ticketnumber;
	}

	public void setTicketnumber(String ticketnumber) {
		this.ticketnumber = ticketnumber;
	}

	@Column(name = "reportmethod")
	public int getReportmethod() {
		return reportmethod;
	}

	public void setReportmethod(int reportmethod) {
		this.reportmethod = reportmethod;
	}

	@Column(name = "checkedlocation", columnDefinition = "char")
	public String getCheckedlocation() {
		return checkedlocation;
	}

	public void setCheckedlocation(String checkedlocation) {
		this.checkedlocation = checkedlocation;
	}

	@Column(name = "numpassengers")
	public int getNumpassengers() {
		return numpassengers;
	}

	public void setNumpassengers(int numpassengers) {
		this.numpassengers = numpassengers;
	}

	@Column(name = "numbagchecked")
	public int getNumbagchecked() {
		return numbagchecked;
	}

	public void setNumbagchecked(int numbagchecked) {
		this.numbagchecked = numbagchecked;
	}

	@Column(name = "numbagreceived")
	public int getNumbagreceived() {
		return numbagreceived;
	}

	public void setNumbagreceived(int numbagreceived) {
		this.numbagreceived = numbagreceived;
	}

	@Column(name = "voluntaryseparation")
	public int getVoluntaryseparation() {
		return voluntaryseparation;
	}

	public void setVoluntaryseparation(int voluntaryseparation) {
		this.voluntaryseparation = voluntaryseparation;
	}

	@Column(name = "courtesyreport")
	public int getCourtesyreport() {
		return courtesyreport;
	}

	public void setCourtesyreport(int courtesyreport) {
		this.courtesyreport = courtesyreport;
	}

	@Column(name = "tsachecked")
	public int getTsachecked() {
		return tsachecked;
	}

	public void setTsachecked(int tsachecked) {
		this.tsachecked = tsachecked;
	}

	@Column(name = "customcleared")
	public int getCustomcleared() {
		return customcleared;
	}

	public void setCustomcleared(int customcleared) {
		this.customcleared = customcleared;
	}

	@Column(name = "nonrevenue")
	public int getNonrevenue() {
		return nonrevenue;
	}

	public void setNonrevenue(int nonrevenue) {
		this.nonrevenue = nonrevenue;
	}

	@Column(name = "lastupdated", insertable = false, updatable = false, nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	public Timestamp getLastupdated() {
		return lastupdated;
	}

	public void setLastupdated(Timestamp lastupdated) {
		this.lastupdated = lastupdated;
	}

	@Column(name = "ohd_lasttraced")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getOhd_lasttraced() {
		return ohd_lasttraced;
	}

	public void setOhd_lasttraced(Timestamp ohd_lasttraced) {
		this.ohd_lasttraced = ohd_lasttraced;
	}

	@Column(name = "createdate")
	@Temporal(value = TemporalType.DATE)
	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Column(name = "createtime")
	@Temporal(value = TemporalType.TIME)
	public Time getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Time createtime) {
		this.createtime = createtime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "close_date")
	public Timestamp getClosedate() {
		return closedate;
	}

	public void setClosedate(Timestamp closedate) {
		this.closedate = closedate;
	}

	@Column(name = "version")
	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Embedded
	public WorldTracerFile getWtFile() {
		return wtFile;
	}

	public void setWtFile(WorldTracerFile wtFile) {
		this.wtFile = wtFile;
	}

	@Column(name = "printedreceipt")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getPrintedreceipt() {
		return printedreceipt;
	}

	public void setPrintedreceipt(Timestamp printedreceipt) {
		this.printedreceipt = printedreceipt;
	}

	@Column(name = "language")
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name = "checklist_version")
	public long getChecklist_version() {
		return checklist_version;
	}

	public void setChecklist_version(long checklist_version) {
		this.checklist_version = checklist_version;
	}

	@Column(name = "overall_weight")
	public Double getOverall_weight() {
		return overall_weight;
	}

	public void setOverall_weight(Double overall_weight) {
		this.overall_weight = roundToTwoDecimals(overall_weight);
	}

	@Column(name = "overall_weight_unit")
	public String getOverall_weight_unit() {
		return overall_weight_unit;
	}

	public void setOverall_weight_unit(String overall_weight_unit) {
		this.overall_weight_unit = overall_weight_unit;
	}

	@Column(name = "locked", nullable = false)
	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	@Column(name = "oc_claim_id")
	public long getOc_claim_id() {
		return oc_claim_id;
	}

	public void setOc_claim_id(long oc_claim_id) {
		this.oc_claim_id = oc_claim_id;
	}

	@Column(name = "revenue_code")
	public String getRevenueCode() {
		return revenueCode;
	}

	public void setRevenueCode(String revenueCode) {
		this.revenueCode = revenueCode;
	}

	@Column(name = "codelocked", nullable = false, columnDefinition = "tinyint")
	public boolean isCodeLocked() {
		return codeLocked;
	}

	public void setCodeLocked(boolean locked) {
		this.codeLocked = locked;
	}

	@Column(name = "stationlocked", nullable = false, columnDefinition = "tinyint")
	public boolean isStationLocked() {
		return stationLocked;
	}

	public void setStationLocked(boolean locked) {
		this.stationLocked = locked;
	}

	@Column(name = "tracing_status_id")
	public int getTracingStatus() {
		return tracingStatus;
	}

	public void setTracingStatus(int tracingStatus) {
		this.tracingStatus = tracingStatus;
	}

	@OneToOne
	@JoinColumn(name = "deliveryinstructions_id", nullable = true)
	public DeliveryInstructions getDeliveryInstructions() {
		return deliveryInstructions;
	}

	public void setDeliveryInstructions(
			DeliveryInstructions deliveryInstructions) {
		this.deliveryInstructions = deliveryInstructions;
	}

	@Column(name = "tracingstarted")
	@Temporal(value = TemporalType.TIMESTAMP)
	public Timestamp getTracingStarted() {
		return tracingStarted;
	}

	public void setTracingStarted(Timestamp tracingStarted) {
		this.tracingStarted = tracingStarted;
	}

	@Column(name = "tracingcomplete")
	@Temporal(value = TemporalType.TIMESTAMP)
	public Timestamp getTracingComplete() {
		return tracingComplete;
	}

	public void setTracingComplete(Timestamp tracingComplete) {
		this.tracingComplete = tracingComplete;
	}

	@ManyToOne
	@JoinColumn(name = "tracing_agent_id")
	public Agent getTracingAgent() {
		return tracingAgent;
	}

	public void setTracingAgent(Agent tracingAgent) {
		this.tracingAgent = tracingAgent;
	}

	@Column(name = "wtcompanyid")
	public String getWtCompanyCode() {
		return wtCompanyCode;
	}

	public void setWtCompanyCode(String wtCompanyCode) {
		this.wtCompanyCode = wtCompanyCode;
	}

	@Column(name = "wtstationid")
	public String getWtStationCode() {
		return wtStationCode;
	}

	public void setWtStationCode(String wtStationCode) {
		this.wtStationCode = wtStationCode;
	}

	@Column(name = "rxtimestamp")
	@Temporal(value = TemporalType.TIMESTAMP)
	public Timestamp getRxTimestamp() {
		return rxTimestamp;
	}

	public void setRxTimestamp(Timestamp rxTimestamp) {
		this.rxTimestamp = rxTimestamp;
	}

	@Column(name = "courtesyreasonid")
	public int getCourtesyReasonId() {
		return courtesyReasonId;
	}

	public void setCourtesyReasonId(int courtesyReasonId) {
		this.courtesyReasonId = courtesyReasonId;
	}

	@Column(name = "courtesydescription")
	public String getCourtesyDescription() {
		return courtesyDescription;
	}

	public void setCourtesyDescription(String courtesyDescription) {
		this.courtesyDescription = courtesyDescription;
	}

	@Column(name = "custcommid", columnDefinition = "int(11) default 1301")
	public int getCustCommId() {
		return custCommId;
	}

	public void setCustCommId(int custCommId) {
		this.custCommId = custCommId;
	}

	@Column(name = "claimstatus")
	public int getClaimStatusId() {
		return claimStatusId;
	}

	public void setClaimStatusId(int claimStatusId) {
		this.claimStatusId = claimStatusId;
	}

	@Column(name = "cbn")
	public int getCbn() {
		return cbn;
	}

	public void setCbn(int cbn) {
		this.cbn = cbn;
	}

	@Column(name = "pax_comm_enabled", nullable = false, columnDefinition = "bit")
	public boolean isPaxCommEnabled() {
		return this.paxCommEnabled;
	}

	public void setPaxCommEnabled(boolean isEnabled) {
		this.paxCommEnabled = isEnabled;
	}

	@Column(name = "paxview_login_date")
	public Timestamp getPaxview_login_date() {
		return paxview_login_date;
	}

	public void setPaxview_login_date(Timestamp paxview_login_date) {
		this.paxview_login_date = paxview_login_date;
	}

	@Column(name = "assigneddate")
	@Temporal(value = TemporalType.TIMESTAMP)
	public Timestamp getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Timestamp assignedDate) {
		this.assignedDate = assignedDate;
	}

	@Column(name = "prioritized")
	public boolean isPrioritized() {
		return prioritized;
	}

	public void setPrioritized(boolean prioritized) {
		this.prioritized = prioritized;
	}

	@Column(name = "paxpplcenabled")
	@Temporal(value = TemporalType.TIMESTAMP)
	public Timestamp getPaxPplcEnabled() {
		return paxPplcEnabled;
	}

	public void setPaxPplcEnabled(Timestamp paxPplcEnabled) {
		this.paxPplcEnabled = paxPplcEnabled;
	}

	@OneToOne(mappedBy = "incident")
	public CrmFile getCrmFile() {
		return crmFile;
	}

	public void setCrmFile(CrmFile crmFile) {
		this.crmFile = crmFile;
	}

	@OneToOne(mappedBy = "incident")
	public Dispute getDispute() {
		return dispute;
	}

	public void setDispute(Dispute dispute) {
		this.dispute = dispute;
	}

	@OneToOne(mappedBy = "incident")
	public IncidentControl getIncidentControl() {
		return incidentControl;
	}

	public void setIncidentControl(IncidentControl value) {
		this.incidentControl = value;
	}

	@OneToMany(mappedBy = "incident", cascade = CascadeType.ALL)
	@org.hibernate.annotations.OrderBy(clause = "createdate")
	public Set<ExpensePayout> getExpenses() {
		return expenses;
	}

	public void setExpenses(Set<ExpensePayout> expenses) {
		this.expenses = expenses;
	}

	@OneToMany(mappedBy = "incident", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	public Set<Incident_Claimcheck> getClaimchecks() {
		return claimchecks;
	}

	public void setClaimchecks(Set<Incident_Claimcheck> claimchecks) {
		this.claimchecks = claimchecks;
	}

	@OneToMany(mappedBy = "incident", cascade = CascadeType.ALL)
	@OrderColumn(name = "bagnumber")
	public List<Item> getItemlist() {
		return itemlist;
	}

	public void setItemlist(List<Item> itemlist) {
		this.itemlist = itemlist;
	}

	@OneToMany(mappedBy = "incident", cascade = CascadeType.ALL)
	@OrderBy(clause = "articles_id desc")
	public Set<Articles> getArticles() {
		return articles;
	}

	public void setArticles(Set<Articles> articles) {
		this.articles = articles;
	}

	@OneToMany(mappedBy = "incident", cascade = CascadeType.ALL)
	@OrderBy(clause = "passenger_id")
	public Set<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
	}

	@OneToMany(mappedBy = "incident", cascade = CascadeType.ALL)
	@OrderBy(clause = "createtime")
	public Set<Remark> getRemarks() {
		return remarks;
	}

	public void setRemarks(Set<Remark> remarks) {
		this.remarks = remarks;
	}

	@OneToMany(mappedBy = "incident", cascade = CascadeType.ALL)
	@OrderBy(clause = "itinerary_id")
	public Set<Itinerary> getItinerary() {
		return itinerary;
	}

	public void setItinerary(Set<Itinerary> itinerary) {
		this.itinerary = itinerary;
	}

	@OneToMany(mappedBy = "ntIncident", fetch = FetchType.EAGER)
	@org.hibernate.annotations.OrderBy(clause = "claimdate")
	public Set<Claim> getClaims() {
		return claims;
	}

	public void setClaims(Set<Claim> claims) {
		this.claims = claims;
	}

	@OneToMany(mappedBy = "incident", cascade = CascadeType.ALL)
	@OrderBy(clause = "issuedate")
	public List<IssuanceItemIncident> getIssuanceItemIncidents() {
		return issuanceItemIncidents;
	}

	public void setIssuanceItemIncidents(List<IssuanceItemIncident> issuanceItemIncidents) {
		this.issuanceItemIncidents = issuanceItemIncidents;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "incident")
	@OrderBy(clause = "createdate")
	public Set<IncidentActivity> getActivities() {
		return activities;
	}

	public void setActivities(Set<IncidentActivity> activities) {
		this.activities = activities;
	}

	@OneToOne(mappedBy = "incident")
	public TwoDayTask getTwoDayTask() {
		return twoDayTask;
	}

	public void setTwoDayTask(TwoDayTask twoDayTask) {
		this.twoDayTask = twoDayTask;
	}

	@OneToOne(mappedBy = "incident")
	public ThreeDayTask getThreeDayTask() {
		return threeDayTask;
	}

	public void setThreeDayTask(ThreeDayTask threeDayTask) {
		this.threeDayTask = threeDayTask;
	}

	@OneToOne(mappedBy = "incident")
	public FourDayTask getFourDayTask() {
		return fourDayTask;
	}

	public void setFourDayTask(FourDayTask fourDayTask) {
		this.fourDayTask = fourDayTask;
	}

	@Transient
	public List<Itinerary> getItinerary_list() {
		return (itinerary == null ? new ArrayList<Itinerary>() : new ArrayList<Itinerary>(itinerary));
	}

	@Transient
	public String getWt_id() {
		if (wtFile != null) {
			return wtFile.getWt_id();
		}
		return null;
	}

	@Transient
	public List<Incident_Claimcheck> getClaimcheck_list() {
		return claimchecks != null ? new ArrayList<Incident_Claimcheck>(claimchecks) : new ArrayList<Incident_Claimcheck>();
	}

	@Transient
	public List<ExpensePayout> getExpenselist() {
		return expenses != null ? new ArrayList<ExpensePayout>(expenses) : new ArrayList<ExpensePayout>();
	}

	@Transient
	public List<Passenger> getPassenger_list() {
		return passengers != null ? new ArrayList<Passenger>(passengers) : new ArrayList<Passenger>();
	}

	@Transient
	public int getItemtype_ID() {
		return itemtype.getId();
	}

	@Transient
	public String getStationcode() {
		return stationassigned.getStationcode();
	}

	@Transient
	public int getStation_ID() {
		return stationassigned.getStation_ID();
	}

	@Transient
	public String getAgent_username() {
		return agent.getUsername();
	}

	@Transient
	public String getFaultstationcode() {
		return (faultstation == null ? "" : faultstation.getStationcode());
	}

	//End



	@Override
	public int hashCode() {
		int result = 23;
		result = 37 * result + (id == null ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object otherObject) {
		if (this == otherObject)
			return true;
		if (otherObject == null)
			return false;
		if (!(otherObject instanceof Incident))
			return false;

		if (id == null)
			return false;

		Incident o = (Incident) otherObject;
		return id.equals(o.getId());
	}



	private Double roundToTwoDecimals(Double d) {
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		return Double.valueOf(twoDForm.format(d));
	}

	@Transient
	public boolean isSwaLocked() {
		return false;
	}

	@Override
	public String toString() {
		return String.format("Incident [version=%s, Incident_ID=%s, stationcreated=%s, stationassigned=%s, faultstation=%s, agent=%s, agentassigned=%s, "
				+ "createdate=%s, createtime=%s, closedate=%s, recordlocator=%s, manualreportnum=%s, ticketnumber=%s, reportmethod=%s, checkedlocation=%s, "
				+ "numpassengers=%s, numbagchecked=%s, numbagreceived=%s, voluntaryseparation=%s, courtesyreport=%s, tsachecked=%s, customcleared=%s, "
				+ "nonrevenue=%s, itemtype=%s, deliveryInstructions=%s, status=%s, loss_code=%s, printedreceipt=%s, lastupdated=%s, ohd_lasttraced=%s, "
				+ "wtFile=%s, crmFile=%s, passengers=%s, articles=%s, remarks=%s, itinerary=%s, oc_claim_id=%s, claims=%s, claimchecks=%s, "
				+ "language=%s, incidentControl=%s, dispute=%s, locked=%s, codeLocked=%s, stationLocked=%s, revenueCode=%s, tracingStatus=%s, "
				+ "tracingStarted=%s, tracingComplete=%s, tracingAgent=%s, rxTimestamp=%s, courtesyReasonId=%s, courtesyDescription=%s, custCommId=%s, "
				+ "claimStatusId=%s, issuanceItemIncidents=%s, activities=%s, wtStationCode=%s, wtCompanyCode=%s, overall_weight=%s, overall_weight_unit=%s, "
				+ "checklist_version=%s]",
				version, id, stationcreated, stationassigned, faultstation, agent, agentassigned,
				createdate, createtime, closedate, recordlocator, manualreportnum, ticketnumber, reportmethod, checkedlocation,
				numpassengers, numbagchecked, numbagreceived, voluntaryseparation, courtesyreport, tsachecked, customcleared, 
				nonrevenue, itemtype, deliveryInstructions, status, loss_code, printedreceipt, lastupdated, ohd_lasttraced, 
				wtFile, crmFile, passengers, articles, remarks, itinerary, oc_claim_id, claims, claimchecks,
				expenses, language, incidentControl, dispute, locked, codeLocked, stationLocked, revenueCode, tracingStatus,
				tracingStarted, tracingComplete, tracingAgent, rxTimestamp, courtesyReasonId, courtesyDescription, custCommId, 
				claimStatusId, issuanceItemIncidents, activities, wtStationCode, wtCompanyCode, overall_weight, overall_weight_unit, 
				checklist_version);
	}

	@Transient
	public String getTracingStatusServiceDescription() {
		return TracingStatus.getDescriptionByKey(tracingStatus);
	}

	@Transient
	public String getReportMethodDescription() {
		return ReportMethod.getDescriptionByKey(reportmethod);
	}

	public void addPassenger(Passenger pasenger) {
		this.getPassengers().add(pasenger);
	}

	public void addClaimcheck(Incident_Claimcheck claimcheck) {
		this.claimchecks.add(claimcheck);
	}

	public void addItem(Item item) {
		this.getItemlist().add(item);
	}

	@Transient
	public Map<String, Double> getBagFees()
	{
		Map<String,Double> fees= new HashMap<>();
		if(this.expenses!=null) {
			for (ExpensePayout expense : this.expenses)
			{
				if (expense.getPaycode().equals("BAG"))
				{
					if(fees.containsKey(expense.getCurrency_ID()))
					{
						fees.put(expense.getCurrency_ID(),fees.get(expense.getCurrency_ID())+expense.getCheckamt());
					} else {
						fees.put(expense.getCurrency_ID(),expense.getCheckamt());
					}
				}
			}
		}
			return fees;
	}
}

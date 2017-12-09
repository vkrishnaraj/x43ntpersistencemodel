/*
 * Created on Jul 13, 2004
 *
 */
package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import aero.nettracer.commons.constant.GenericConstants;
import aero.nettracer.commons.utils.GenericDateUtils;
import aero.nettracer.persistence.model.communications.IncidentActivity;
import aero.nettracer.persistence.model.dr.Dispute;
import aero.nettracer.persistence.model.issuance.IssuanceItemIncident;
import aero.nettracer.persistence.model.taskmanager.FourDayTask;
import aero.nettracer.persistence.model.taskmanager.ThreeDayTask;
import aero.nettracer.persistence.model.taskmanager.TwoDayTask;
import aero.nettracer.persistence.util.ReportMethod;
import aero.nettracer.persistence.util.TracingStatus;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Incident")
public class Incident implements Serializable {

	private static final long serialVersionUID = -1325304028074169696L;

	@Version
	private int version;

	private String incidentId;
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
	private DeliveryInstructions deliveryInstructions;
	private Status status;
	private int loss_code;

	private Date printedreceipt;

	private Date lastupdated;

	private Date ohd_lasttraced;

	private WorldTracerFile wtFile; // world tracer id
	private CrmFile crmFile;
	private Set<Passenger> passengers;

	private List<Item> itemlist;
	private Set<Articles> articles;
	private Set<Remark> remarks;
	private Set<Itinerary> itinerary;
	private long oc_claim_id;
	private Set<Claim> claims;

	private Set<Incident_Claimcheck> claimchecks;

	private List<Itinerary> itinerary_list; // for displaying to the search incident page
	private List<Incident_Claimcheck> claimcheck_list; // for display to the search incident page
	private List<Passenger> passenger_list; // for displaying to the search incident page

	private String _DATEFORMAT; // current login agent's date format
	private String _TIMEFORMAT; // current login agent's time format
	private TimeZone _TIMEZONE;

	private Set<ExpensePayout> expenses;
	private List<ExpensePayout> expenselist;

	private String language;

	private IncidentControl incidentControl;

	private Dispute dispute;

	private boolean locked = false; // for dispute resolution process
	private boolean codeLocked = false; // for dispute resolution process
	private boolean stationLocked = false; // for dispute resolution process

	private String revenueCode;

	private int tracingStatus;
	private Date tracingStarted;
	private Date tracingComplete;
	private Agent tracingAgent;

	private Date rxTimestamp;
	private int courtesyReasonId;
	private String courtesyDescription;
	private int custCommId;
	private int claimStatusId;

	private List<IssuanceItemIncident> issuanceItemIncidents;

	private Set<IncidentActivity> activities;

	private String wtStationCode;
	private String wtCompanyCode;

	private TwoDayTask twoDayTask;
	private ThreeDayTask threeDayTask;
	private FourDayTask fourDayTask;

	private Double overall_weight;
	private String overall_weight_unit;
	private long checklist_version; // for auto checklist

 	private int cbn;

    private boolean paxCommEnabled = true;
	@Column(name = "paxview_login_date")
	private Date paxview_login_date;
	private Date assignedDate;

	private boolean prioritized;
	private Date paxPplcEnabled;

	@Column(name = "tracing_status_id")
	public int getTracingStatus() {
		return tracingStatus;
	}

	public void setTracingStatus(int tracingStatus) {
		this.tracingStatus = tracingStatus;
	}

	@Temporal(value = TemporalType.TIMESTAMP)
	public Date getTracingStarted() {
		return tracingStarted;
	}

	public void setTracingStarted(Date tracingStarted) {
		this.tracingStarted = tracingStarted;
	}

	@Temporal(value = TemporalType.TIMESTAMP)
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

	@Column(name = "revenue_code", length = 16)
	public String getRevenueCode() {
		return revenueCode;
	}

	public void setRevenueCode(String revenueCode) {
		this.revenueCode = revenueCode;
	}

	@Column(name = "locked", nullable = false)
	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	@Column(name = "codeLocked", nullable = false, columnDefinition = "tinyint")
	public boolean isCodeLocked() {
		return codeLocked;
	}

	public void setCodeLocked(boolean locked) {
		this.codeLocked = locked;
	}

	@Column(name = "stationLocked", nullable = false, columnDefinition = "tinyint")
	public boolean isStationLocked() {
		return stationLocked;
	}

	public void setStationLocked(boolean locked) {
		this.stationLocked = locked;
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

	public Double getOverall_weight() {
		return overall_weight;
	}

	public void setOverall_weight(Double overall_weight) {
		this.overall_weight = roundToTwoDecimals(overall_weight);
	}

	public String getOverall_weight_unit() {
		return overall_weight_unit;
	}

	public void setOverall_weight_unit(String overall_weight_unit) {
		this.overall_weight_unit = overall_weight_unit;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@ManyToOne
	@JoinColumn(name = "status_ID", nullable = false)
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@ManyToOne
	@JoinColumn(name = "itemType_ID", nullable = false)
	public ItemType getItemtype() {
		return itemtype;
	}

	public void setItemtype(ItemType itemtype) {
		this.itemtype = itemtype;
	}

	@ManyToOne
	@JoinColumn(name = "agent_ID", nullable = false)
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@OneToOne
	@JoinColumn(name = "deliveryInstructions_ID", nullable = true)
	public DeliveryInstructions getDeliveryInstructions() {
		return deliveryInstructions;
	}

	public void setDeliveryInstructions(
			DeliveryInstructions deliveryInstructions) {
		this.deliveryInstructions = deliveryInstructions;
	}

	@OneToMany(mappedBy = "incident", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@org.hibernate.annotations.OrderBy(clause = "createdate")
	@Fetch(FetchMode.SELECT)
	public Set<ExpensePayout> getExpenses() {
		return expenses;
	}

	public void setExpenses(Set<ExpensePayout> expenses) {
		this.expenses = expenses;
	}

	@ManyToOne
	@JoinColumn(name = "agentassigned_ID", nullable = true)
	public Agent getAgentassigned() {
		return agentassigned;
	}

	public void setAgentassigned(Agent agentassigned) {
		this.agentassigned = agentassigned;
	}

	@ManyToOne
	@JoinColumn(name = "stationassigned_ID", nullable = false)
	public Station getStationassigned() {
		return stationassigned;
	}

	public void setStationassigned(Station stationassigned) {
		this.stationassigned = stationassigned;
	}

	@ManyToOne
	@JoinColumn(name = "stationcreated_ID", nullable = false)
	public Station getStationcreated() {
		return stationcreated;
	}

	public void setStationcreated(Station stationcreated) {
		this.stationcreated = stationcreated;
	}

	@ManyToOne
	@JoinColumn(name = "faultstation_ID", nullable = true)
	public Station getFaultstation() {
		return faultstation;
	}

	public void setFaultstation(Station faultstation) {
		this.faultstation = faultstation;
	}

	@OneToMany(mappedBy = "incident", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	public Set<Incident_Claimcheck> getClaimchecks() {
		return claimchecks;
	}

	public void setClaimchecks(Set<Incident_Claimcheck> claimchecks) {
		this.claimchecks = claimchecks;

	}

	@OneToMany(mappedBy = "incident", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@org.hibernate.annotations.IndexColumn(name = "bagnumber")
	@Fetch(FetchMode.SELECT)
	public List<Item> getItemlist() {
		return itemlist;
	}

	public void setItemlist(List<Item> itemlist) {
		this.itemlist = itemlist;
	}

	@OneToMany(mappedBy = "incident", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@org.hibernate.annotations.OrderBy(clause = "articles_ID DESC")
	@Fetch(FetchMode.SELECT)
	public Set<Articles> getArticles() {
		return articles;
	}

	public void setArticles(Set<Articles> articles) {
		this.articles = articles;
	}

	@OneToMany(mappedBy = "incident", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@org.hibernate.annotations.OrderBy(clause = "passenger_id")
	@Fetch(FetchMode.SELECT)
	public Set<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
	}

	@OneToMany(mappedBy = "incident", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@org.hibernate.annotations.OrderBy(clause = "createtime")
	@Fetch(FetchMode.SELECT)
	public Set<Remark> getRemarks() {
		return remarks;
	}

	public void setRemarks(Set<Remark> remarks) {
		this.remarks = remarks;
	}

	@OneToMany(mappedBy = "incident", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@org.hibernate.annotations.OrderBy(clause = "itinerary_ID")
	@Fetch(FetchMode.SELECT)
	public Set<Itinerary> getItinerary() {
		return itinerary;
	}

	public void setItinerary(Set<Itinerary> itinerary) {
		this.itinerary = itinerary;
	}

	@Column(columnDefinition = "char")
	public String getCheckedlocation() {
		return checkedlocation;
	}

	public void setCheckedlocation(String checkedlocation) {
		this.checkedlocation = checkedlocation;
	}

	@Basic
	public int getCourtesyreport() {
		return courtesyreport;
	}

	public void setCourtesyreport(int courtesyreport) {
		this.courtesyreport = courtesyreport;
	}

	@Temporal(value = TemporalType.DATE)
	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Temporal(value = TemporalType.TIMESTAMP)
	public Date getLastupdated() {
		return lastupdated;
	}

	public void setLastupdated(Date lastupdated) {
		this.lastupdated = lastupdated;
	}

	@Temporal(value = TemporalType.TIME)
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Transient
	public String getDisplaydate() {
		Date completedate = GenericDateUtils.convertToDate(getCreatedate().toString() + " " + getCreatetime().toString(), GenericConstants.DB_DATETIMEFORMAT,
				null);
		return GenericDateUtils.formatDate(completedate, _DATEFORMAT + " " + _TIMEFORMAT, null, _TIMEZONE);
	}

	@Transient
	public Date getFullCreateDate() {
		if (getCreatedate() == null || getCreatetime() == null) {
			return null;
		} else {
			DateFormat dateFormat = new SimpleDateFormat(GenericConstants.DB_DATEFORMAT);
			String dateString = dateFormat.format(getCreatedate());
			DateFormat timeFormat = new SimpleDateFormat(GenericConstants.DB_TIMEFORMAT);
			String timeString = timeFormat.format(getCreatetime());

			return GenericDateUtils.convertToDate(dateString + " " + timeString, GenericConstants.DB_DATETIMEFORMAT,
					null);
		}
	}

	@Transient
	public Date getFullCloseDate() {
		return getClosedate();
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "close_date")
	public Date getClosedate() {
		return closedate;
	}

	public void setClosedate(Date closedate) {
		this.closedate = closedate;
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

	@Id
	@Column(name = "Incident_ID", length = 13)
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

	@Column(length = 14)
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

	@Column(length = 20)
	public String getManualreportnum() {
		return manualreportnum;
	}

	public void setManualreportnum(String manualreportnum) {
		this.manualreportnum = manualreportnum;
	}

	@Column(length = 10)
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

	@Temporal(TemporalType.TIMESTAMP)
	public Date getOhd_lasttraced() {
		return ohd_lasttraced;
	}

	public void setOhd_lasttraced(Date ohd_lasttraced) {
		this.ohd_lasttraced = ohd_lasttraced;
	}

	@OneToMany(mappedBy = "ntIncident", fetch = FetchType.EAGER)
	@org.hibernate.annotations.OrderBy(clause = "claimdate")
	@Fetch(FetchMode.SELECT)
	public Set<Claim> getClaims() {
		return claims;
	}

	public void setClaims(Set<Claim> claims) {
		this.claims = claims;
	}

	@OneToMany(mappedBy = "incident", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@org.hibernate.annotations.OrderBy(clause = "issuedate")
	@Fetch(FetchMode.SELECT)
	public List<IssuanceItemIncident> getIssuanceItemIncidents() {
		return issuanceItemIncidents;
	}

	public void setIssuanceItemIncidents(
			List<IssuanceItemIncident> issuanceItemIncidents) {
		this.issuanceItemIncidents = issuanceItemIncidents;
	}

	@Basic
	public int getLoss_code() {
		return loss_code;
	}

	public void setLoss_code(int loss_code) {
		this.loss_code = loss_code;
	}

	@Embedded
	public WorldTracerFile getWtFile() {
		return wtFile;
	}

	public void setWtFile(WorldTracerFile wtFile) {
		this.wtFile = wtFile;
	}

	@Transient
	public String getWt_id() {
		if (wtFile != null) {
			return wtFile.getWt_id();
		}
		return null;
	}

	@Transient
	public List<Itinerary> getItinerary_list() {
		return (itinerary == null ? new ArrayList<Itinerary>()
				: new ArrayList<Itinerary>(itinerary));
	}

	public void setItinerary_list(List<Itinerary> itinList) {
		this.itinerary_list = itinList;
	}

	@Transient
	public List<Incident_Claimcheck> getClaimcheck_list() {
		return claimchecks != null ? new ArrayList<Incident_Claimcheck>(
				claimchecks) : new ArrayList<Incident_Claimcheck>();
	}

	public void setClaimcheck_list(List<Incident_Claimcheck> cc_list) {
		this.claimcheck_list = cc_list;
	}

	@Transient
	public List<ExpensePayout> getExpenselist() {
		return expenses != null ? new ArrayList<ExpensePayout>(expenses)
				: new ArrayList<ExpensePayout>();
	}

	public void setExpenselist(List<ExpensePayout> expenselist) {
		this.expenses = new LinkedHashSet<ExpensePayout>(expenselist);
	}

	@Transient
	public List<Passenger> getPassenger_list() {
		return passengers != null ? new ArrayList<Passenger>(passengers)
				: new ArrayList<Passenger>();
	}

	public void setPassenger_list(List<Passenger> paxList) {
		this.passenger_list = paxList;
	}

	@Transient
	public int getItemtype_ID() {
		return itemtype.getItemType_ID();
	}

	//NTFIXME
	/*@Transient
	public String getTypedesc() {
		return itemtype.getDescription();
	}*/

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

	@Temporal(TemporalType.TIMESTAMP)
	public Date getPrintedreceipt() {
		return printedreceipt;
	}

	public void setPrintedreceipt(Date printedreceipt) {
		this.printedreceipt = printedreceipt;
	}

	@Transient
	public String getRcreatedate() {
		Date completedate = GenericDateUtils.convertToDate(getCreatedate().toString(), GenericConstants.DB_DATEFORMAT, null);
		return GenericDateUtils.formatDate(completedate, _DATEFORMAT, null, _TIMEZONE);
	}

	@Transient
	public String getRcreatetime() {
		Date completedate = GenericDateUtils.convertToDate(getCreatetime().toString(), GenericConstants.DB_TIMEFORMAT, null);
		return GenericDateUtils.formatDate(completedate, _TIMEFORMAT, null, _TIMEZONE);
	}

	/*@Transient
	public Station getDispStationAssigned() {
		Station ret = null;

		if (this.getStationassigned() != null)
			ret = StationBMO.getStation("" + this.getStationassigned().getStation_ID());

		return ret;
	}*/

	public long getChecklist_version() {
		return checklist_version;
	}

	public void setChecklist_version(long checklist_version) {
		this.checklist_version = checklist_version;
	}

	@Override
	public int hashCode() {
		int result = 23;
		result = 37 * result + (Incident_ID == null ? 0 : Incident_ID.hashCode());
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

		if (Incident_ID == null)
			return false;

		Incident o = (Incident) otherObject;
		return Incident_ID.equals(o.getIncident_ID());
	}

	@OneToOne(mappedBy = "incident")
	public CrmFile getCrmFile() {
		return crmFile;
	}

	public void setCrmFile(CrmFile crmFile) {
		this.crmFile = crmFile;
	}

	private Double roundToTwoDecimals(Double d) {
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		return Double.valueOf(twoDForm.format(d));
	}

	@Basic
	public long getOc_claim_id() {
		return oc_claim_id;
	}

	public void setOc_claim_id(long oc_claim_id) {
		this.oc_claim_id = oc_claim_id;
	}

	@Column(name = "wtStationId", length = 3)
	public String getWtStationCode() {
		return wtStationCode;
	}

	public void setWtStationCode(String wtStationCode) {
		this.wtStationCode = wtStationCode;
	}

	@Column(name = "wtCompanyId", length = 3)
	public String getWtCompanyCode() {
		return wtCompanyCode;
	}

	public void setWtCompanyCode(String wtCompanyCode) {
		this.wtCompanyCode = wtCompanyCode;
	}

	@Temporal(value = TemporalType.TIMESTAMP)
	public Date getRxTimestamp() {
		return rxTimestamp;
	}

	public void setRxTimestamp(Date rxTimestamp) {
		this.rxTimestamp = rxTimestamp;
	}

	public int getCourtesyReasonId() {
		return courtesyReasonId;
	}

	public void setCourtesyReasonId(int courtesyReasonId) {
		this.courtesyReasonId = courtesyReasonId;
	}

	@Column(length = 100)
	public String getCourtesyDescription() {
		return courtesyDescription;
	}

	public void setCourtesyDescription(String courtesyDescription) {
		this.courtesyDescription = courtesyDescription;
	}

	@Column(columnDefinition = "int(11) default 1301")
	public int getCustCommId() {
		return custCommId;
	}

	public void setCustCommId(int custCommId) {
		this.custCommId = custCommId;
	}

	@Column(name = "claimStatus")
	public int getClaimStatusId() {
		return claimStatusId;
	}

	public void setClaimStatusId(int claimStatusId) {
		this.claimStatusId = claimStatusId;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "incident")
	@org.hibernate.annotations.OrderBy(clause = "createDate")
	@Fetch(FetchMode.SELECT)
	public Set<IncidentActivity> getActivities() {
		return activities;
	}

	public void setActivities(Set<IncidentActivity> activities) {
		this.activities = activities;
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
				+ "wtFile=%s, crmFile=%s, passengers=%s, itemlist=%s, articles=%s, remarks=%s, itinerary=%s, oc_claim_id=%s, claims=%s, claimchecks=%s, "
				+ "itinerary_list=%s, claimcheck_list=%s, passenger_list=%s, _DATEFORMAT=%s, _TIMEFORMAT=%s, _TIMEZONE=%s, expenses=%s, expenselist=%s, "
				+ "language=%s, incidentControl=%s, dispute=%s, locked=%s, codeLocked=%s, stationLocked=%s, revenueCode=%s, tracingStatus=%s, "
				+ "tracingStarted=%s, tracingComplete=%s, tracingAgent=%s, rxTimestamp=%s, courtesyReasonId=%s, courtesyDescription=%s, custCommId=%s, "
				+ "claimStatusId=%s, issuanceItemIncidents=%s, activities=%s, wtStationCode=%s, wtCompanyCode=%s, overall_weight=%s, overall_weight_unit=%s, "
				+ "checklist_version=%s]",
				version, Incident_ID, stationcreated, stationassigned, faultstation, agent, agentassigned, 
				createdate, createtime, closedate, recordlocator, manualreportnum, ticketnumber, reportmethod, checkedlocation,
				numpassengers, numbagchecked, numbagreceived, voluntaryseparation, courtesyreport, tsachecked, customcleared, 
				nonrevenue, itemtype, deliveryInstructions, status, loss_code, printedreceipt, lastupdated, ohd_lasttraced, 
				wtFile, crmFile, passengers, itemlist, articles, remarks, itinerary, oc_claim_id, claims, claimchecks, 
				itinerary_list, claimcheck_list, passenger_list, _DATEFORMAT, _TIMEFORMAT, _TIMEZONE, expenses, expenselist, 
				language, incidentControl, dispute, locked, codeLocked, stationLocked, revenueCode, tracingStatus, 
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

	@OneToOne(mappedBy = "incident", fetch = FetchType.LAZY)
	public TwoDayTask getTwoDayTask() {
		return twoDayTask;
	}

	public void setTwoDayTask(TwoDayTask twoDayTask) {
		this.twoDayTask = twoDayTask;
	}

	@OneToOne(mappedBy = "incident", fetch = FetchType.LAZY)
	public ThreeDayTask getThreeDayTask() {
		return threeDayTask;
	}

	public void setThreeDayTask(ThreeDayTask threeDayTask) {
		this.threeDayTask = threeDayTask;
	}

	@OneToOne(mappedBy = "incident", fetch = FetchType.LAZY)
	public FourDayTask getFourDayTask() {
		return fourDayTask;
	}

	public void setFourDayTask(FourDayTask fourDayTask) {
		this.fourDayTask = fourDayTask;
	}

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

	public void addPassenger(Passenger pasenger) {
		this.getPassengers().add(pasenger);
	}

	public void addClaimcheck(Incident_Claimcheck claimcheck) {
		this.claimchecks.add(claimcheck);
	}

	public void addItem(Item item) {
		this.getItemlist().add(item);
	}

	public Date getPaxview_login_date() {
		return paxview_login_date;
	}

	public void setPaxview_login_date(Date paxview_login_date) {
		this.paxview_login_date = paxview_login_date;
	}

	@Temporal(value = TemporalType.TIMESTAMP)
	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	@Temporal(value = TemporalType.TIMESTAMP)
	public Date getPaxPplcEnabled() {
		return paxPplcEnabled;
	}

	public void setPaxPplcEnabled(Date paxPplcEnabled) {
		this.paxPplcEnabled = paxPplcEnabled;
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

	public boolean isPrioritized() {
		return prioritized;
	}

	public void setPrioritized(boolean prioritized) {
		this.prioritized = prioritized;
	}
}

package aero.nettracer.persistence.model.communications;

import aero.nettracer.persistence.model.Agent;
import aero.nettracer.persistence.model.ExpensePayout;
import aero.nettracer.persistence.model.Incident;
import aero.nettracer.persistence.model.Status;
import aero.nettracer.persistence.model.documents.Document;
import aero.nettracer.persistence.model.onlineclaims.OCFile;
import aero.nettracer.persistence.model.onlineclaims.OCMessage;
import aero.nettracer.persistence.model.taskmanager.IncidentActivityTask;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "incident_activity")
public class IncidentActivity implements Serializable {

	private static final long serialVersionUID = -7194092797476837039L;

	private long id;
	private Incident incident;
	private Timestamp createDate;
	private Timestamp publishedDate;
	private Agent agent;
	private Agent approvalAgent;
	private Document document;
	private Activity activity;
	private String description;
	private int custCommId;
	private ExpensePayout expensePayout;
	private Date lastPrinted;
	private Agent acknowlegeAgent;
	private boolean visibleOnClaimProcessPage = true;
	private List<OCMessage> messages;
	private List<OCFile> files;
	private List<IncidentActivityRemark> remarks;
	private List<IncidentActivityTask> tasks;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "incident", nullable = false)
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	@Column(name = "createdate")
	@Temporal(value = TemporalType.TIMESTAMP)
	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "publisheddate")
	@Temporal(value = TemporalType.TIMESTAMP)
	public Timestamp getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Timestamp publishedDate) {
		this.publishedDate = publishedDate;
	}

	@ManyToOne
	@JoinColumn(name = "agent")
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@ManyToOne
	@JoinColumn(name = "approvalagent")
	public Agent getApprovalAgent() {
		return approvalAgent;
	}

	public void setApprovalAgent(Agent approvalAgent) {
		this.approvalAgent = approvalAgent;
	}

	@OneToOne
	@JoinColumn(name = "document")
	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	@ManyToOne
	@JoinColumn(name = "activity")
	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "custcommid")
	public int getCustCommId() {
		return custCommId;
	}

	public void setCustCommId(int custCommId) {
		this.custCommId = custCommId;
	}

	@ManyToOne
	@JoinColumn(name = "expensepayout_id")
	public ExpensePayout getExpensePayout() {
		return expensePayout;
	}

	public void setExpensePayout(ExpensePayout expensePayout) {
		this.expensePayout = expensePayout;
	}

	@Column(name = "lastprinted")
	@Temporal(value = TemporalType.DATE)
	public Date getLastPrinted() {
		return lastPrinted;
	}

	public void setLastPrinted(Date lastPrinted) {
		this.lastPrinted = lastPrinted;
	}

	@ManyToOne
	@JoinColumn(name = "acknowlegeAgent")
	public Agent getAcknowlegeAgent() {
		return acknowlegeAgent;
	}

	public void setAcknowlegeAgent(Agent acknowlegeAgent) {
		this.acknowlegeAgent = acknowlegeAgent;
	}

	@Column(name = "visible_claim_process_page", nullable = false)
	public boolean isVisibleOnClaimProcessPage() {
		return this.visibleOnClaimProcessPage;
	}

	public void setVisibleOnClaimProcessPage(boolean visibleOnClaimProcessPage) {
		this.visibleOnClaimProcessPage = visibleOnClaimProcessPage;
	}

	@OneToMany(mappedBy = "incAct", cascade = CascadeType.ALL)
	@OrderBy(value = "dateCreated")
	public List<OCMessage> getMessages() {
		if (messages == null) {
			messages = new ArrayList<OCMessage>();
		}
		return messages;
	}

	public void setMessages(List<OCMessage> messages) {
		this.messages = messages;
	}

	@OneToMany(mappedBy = "incAct", cascade = CascadeType.ALL)
	@OrderBy(value="id")
	public List<OCFile> getFiles() {
		if (files == null) {
			files = new ArrayList<OCFile>();
		}
		return files;
	}

	public void setFiles(List<OCFile> files) {
		this.files = files;
	}

	@OneToMany(mappedBy = "incidentActivity", cascade = CascadeType.ALL)
	@OrderBy(value="createDate")
	public List<IncidentActivityRemark> getRemarks() {
		return remarks;
	}

	public void setRemarks(List<IncidentActivityRemark> remarks) {
		this.remarks = remarks;
	}

	@OneToMany(mappedBy = "incidentActivity", cascade = CascadeType.ALL)
	@OrderBy(value="opened_timestamp")
	public List<IncidentActivityTask> getTasks() {
		if (tasks == null) {
			tasks = new ArrayList<IncidentActivityTask>();
		}
		return tasks;
	}

	public void setTasks(List<IncidentActivityTask> tasks) {
		this.tasks = tasks;
	}


	public Status getLastStatus() {
		if (tasks == null || tasks.isEmpty()) return null;
		return tasks.get(tasks.size() - 1).getStatus();
	}

}

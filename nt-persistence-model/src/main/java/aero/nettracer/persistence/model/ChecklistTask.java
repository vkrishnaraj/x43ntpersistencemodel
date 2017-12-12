package aero.nettracer.persistence.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "checklist_task")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class ChecklistTask {

	private long id;
	private String description;
	private long orderId;
	private ChecklistVersion checklistVersion;
	private List<ChecklistTaskOption> checklistTaskOptions;
	private IncidentChecklist snapshotData;

	@Id
	@GeneratedValue
	@Column(name = "task_id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "order_id")
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	@ManyToOne
	@JoinColumn(name = "version_id")
	public ChecklistVersion getChecklistVersion() {
		return checklistVersion;
	}

	public void setChecklistVersion(ChecklistVersion checklistVersion) {
		this.checklistVersion = checklistVersion;
	}

	@OneToMany(mappedBy="checklistTask", cascade=CascadeType.ALL)
	@OrderColumn(name="order_id")
	public List<ChecklistTaskOption> getChecklistTaskOptions() {
		return checklistTaskOptions;
	}

	public void setChecklistTaskOptions(List<ChecklistTaskOption> checklistTaskOptions) {
		this.checklistTaskOptions = checklistTaskOptions;
	}

	@Transient
	public IncidentChecklist getSnapshotData() {
		return snapshotData;
	}

	public void setSnapshotData(IncidentChecklist snapshotData) {
		this.snapshotData = snapshotData;
	}
}

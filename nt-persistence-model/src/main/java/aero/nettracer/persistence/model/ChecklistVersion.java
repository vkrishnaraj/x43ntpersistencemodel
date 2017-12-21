package aero.nettracer.persistence.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "checklist_version")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class ChecklistVersion {

	private long id;
	private boolean active;
	private List<ChecklistTask> checklistTasks;

	@Id
	@GeneratedValue
	@Column(name = "version_id")
	public long getId() {
		return id;
	}


	public void setId(long version_id) {
		this.id = id;
	}

	@Column(name = "active", nullable = false)
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@OneToMany(mappedBy="checklistVersion", cascade=CascadeType.ALL)
    @OrderColumn(name="order_id")
	public List<ChecklistTask> getChecklistTasks() {
		return checklistTasks;
	}

	public void setChecklistTasks(List<ChecklistTask> checklistTasks) {
		this.checklistTasks = checklistTasks;
	}

}

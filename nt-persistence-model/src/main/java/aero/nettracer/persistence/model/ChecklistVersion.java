package aero.nettracer.persistence.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "checklist_version")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class ChecklistVersion {
	private static final long serialVersionUID = 1L;
	
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

	@OneToMany(mappedBy="checklistVersion",
            targetEntity=ChecklistTask.class,
              cascade=CascadeType.ALL)
    @OrderColumn(name="order_id")
	public List<ChecklistTask> getChecklistTasks() {
		return checklistTasks;
	}

	public void setChecklistTasks(List<ChecklistTask> checklistTasks) {
		this.checklistTasks = checklistTasks;
	}
	

}

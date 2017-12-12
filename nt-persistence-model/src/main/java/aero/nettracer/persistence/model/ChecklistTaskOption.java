package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "checklist_task_option")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class ChecklistTaskOption {

	private long id;
	private String description;
	private long order_id;
	private ChecklistTask checklistTask;

	@Id
	@GeneratedValue
	@Column(name = "option_id")
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
	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	@ManyToOne
	@JoinColumn(name = "task_id")
	public ChecklistTask getChecklistTask() {
		return checklistTask;
	}

	public void setChecklistTask(ChecklistTask checklistTask) {
		this.checklistTask = checklistTask;
	}
}

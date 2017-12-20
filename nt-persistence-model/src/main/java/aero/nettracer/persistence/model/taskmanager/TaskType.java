package aero.nettracer.persistence.model.taskmanager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="task_type")
public class TaskType {

	private long id;
	private int code;
	private String description;
	
	public TaskType() { }
	
	public TaskType(long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "code")
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Transient
	public String getKey() {
		return "TASK_TYPE_" + getCode();
	}
	
}

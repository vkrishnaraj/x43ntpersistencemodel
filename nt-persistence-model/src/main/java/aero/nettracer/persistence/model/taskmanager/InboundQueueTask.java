package aero.nettracer.persistence.model.taskmanager;

import aero.nettracer.persistence.model.InboundQueue;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class InboundQueueTask extends GeneralTask {

	private InboundQueue inboundqueue;
	private TaskType taskType;
	private String task_type;

	@Column(name="task_type", insertable = false, updatable =  false)
	public String getTask_type() {
		return task_type;
	}

	public void setTask_type(String task_type) {
		this.task_type = task_type;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "inboundqueue_id")
	public InboundQueue getInboundqueue() {
		return inboundqueue;
	}

	public void setInboundqueue(InboundQueue inboundqueue) {
		this.inboundqueue = inboundqueue;
	}

	@ManyToOne
	@JoinColumn(name="task_type_id")
	public TaskType getTaskType() {
		return taskType;
	}

	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}
	
	@Transient
	public boolean isInbound(){
		return this instanceof InboundTask;
	}
	
	@Transient
	public boolean isAcaa(){
		return this instanceof AcaaTask;
	}
	
	@Transient
	public boolean isDamaged(){
		return this instanceof DamagedTask;
	}
}

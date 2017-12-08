package aero.nettracer.persistence.model;

import java.io.Serializable;

import aero.nettracer.persistence.model.i8n.LocaleBasedObject;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "priority")
public class Priority extends LocaleBasedObject implements Serializable {

	private int priority_ID;
	private String MSG_KEY = "PRIORITY_KEY_";

	@Id
	public int getPriority_ID() {
		return priority_ID;
	}

	public void setPriority_ID(int priority_ID) {
		this.priority_ID = priority_ID;
	}

	@Transient
	public String getKey() {
		return MSG_KEY + priority_ID;
	}
}
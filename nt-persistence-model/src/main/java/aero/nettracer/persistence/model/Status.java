/*
 * Created on Jul 14, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model;

import java.io.Serializable;

import aero.nettracer.persistence.model.i8n.LocaleBasedObject;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Status")
public class Status extends LocaleBasedObject implements Serializable {
	
	private static final long serialVersionUID = -5115842004692528313L;
	
	private static String MSG_KEY = "STATUS_KEY_"; 
	private int Status_ID;
	private int table_ID;
	private String description;

	public Status() { }

	public Status(int statusId) {
		this.Status_ID = statusId;
	}
	
	@Id
	@GeneratedValue
	public int getStatus_ID() {
		return Status_ID;
	}

	public void setStatus_ID(int status_ID) {
		Status_ID = status_ID;
	}

	public int getTable_ID() {
		return table_ID;
	}

	public void setTable_ID(int table_ID) {
		this.table_ID = table_ID;
	}

	@Transient
	public String getKey() {
		return MSG_KEY + Status_ID;
	}
	
	public static String getKey(int id) {
		return MSG_KEY + id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
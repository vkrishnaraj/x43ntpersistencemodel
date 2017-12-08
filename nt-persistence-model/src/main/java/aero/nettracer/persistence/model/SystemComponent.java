/*
 * Created on Jul 20, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "SystemComponents")
public class SystemComponent implements Serializable {
	private int component_ID;
	private String component_Name;
	private String component_Desc;
	private SystemComponent parent;
	private String component_action_link;
	private int sort_order;
	private int display;
	private int sort_group;

	public int getDisplay() {
		return display;
	}

	public void setDisplay(int display) {
		this.display = display;
	}

	public int getSort_order() {
		return sort_order;
	}

	public void setSort_order(int sort_order) {
		this.sort_order = sort_order;
	}

	public String getComponent_action_link() {
		return component_action_link;
	}

	public void setComponent_action_link(String component_action_link) {
		this.component_action_link = component_action_link;
	}

	@ManyToOne
	@JoinColumn(name = "parent_component_id")
	public SystemComponent getParent() {
		return parent;
	}

	public void setParent(SystemComponent parent) {
		this.parent = parent;
	}

	public String getComponent_Desc() {
		return component_Desc;
	}

	public void setComponent_Desc(String component_Desc) {
		this.component_Desc = component_Desc;
	}

	@Id
	@GeneratedValue
	public int getComponent_ID() {
		return component_ID;
	}


	public void setComponent_ID(int component_ID) {
		this.component_ID = component_ID;
	}

	public String getComponent_Name() {
		return component_Name;
	}


	public void setComponent_Name(String component_Name) {
		this.component_Name = component_Name;
	}


	public String toString() {
		StringBuffer sb = new StringBuffer(200);
		sb.append("Component ID=" + this.getComponent_ID() + " Name=" + this.getComponent_Name()
				+ " Desc=" + this.getComponent_Desc() + " Component Link="
				+ this.getComponent_action_link() + " parent=" + this.getParent().getComponent_ID());
		return sb.toString();
	}
	
	public int getSort_group() {
		return sort_group;
	}

	public void setSort_group(int sort_group) {
		this.sort_group = sort_group;
	}

}
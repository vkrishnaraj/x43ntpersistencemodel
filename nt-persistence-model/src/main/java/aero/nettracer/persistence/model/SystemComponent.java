package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "systemcomponents")
public class SystemComponent {

	private int id;
	private String component_Name;
	private String component_Desc;
	private SystemComponent parent;
	private String component_action_link;
	private int display;
	private int sort_order;
	private int sort_group;

	@Id
	@GeneratedValue
	@Column(name = "component_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "component_name")
	public String getComponent_Name() {
		return component_Name;
	}

	public void setComponent_Name(String component_Name) {
		this.component_Name = component_Name;
	}

	@Column(name = "component_desc")
	public String getComponent_Desc() {
		return component_Desc;
	}

	public void setComponent_Desc(String component_Desc) {
		this.component_Desc = component_Desc;
	}

	@ManyToOne
	@JoinColumn(name = "parent_component_id")
	public SystemComponent getParent() {
		return parent;
	}

	public void setParent(SystemComponent parent) {
		this.parent = parent;
	}

	@Column(name = "component_action_link")
	public String getComponent_action_link() {
		return component_action_link;
	}

	public void setComponent_action_link(String component_action_link) {
		this.component_action_link = component_action_link;
	}

	@Column(name = "display")
	public int getDisplay() {
		return display;
	}

	public void setDisplay(int display) {
		this.display = display;
	}

	@Column(name = "sort_order")
	public int getSort_order() {
		return sort_order;
	}

	public void setSort_order(int sort_order) {
		this.sort_order = sort_order;
	}

	@Column(name = "sort_group")
	public int getSort_group() {
		return sort_group;
	}

	public void setSort_group(int sort_group) {
		this.sort_group = sort_group;
	}

}
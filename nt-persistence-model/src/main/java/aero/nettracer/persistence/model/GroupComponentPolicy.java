/*
 * Created on Jul 20, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "group_component_policy")
public class GroupComponentPolicy {

	private int id;
	private SystemComponent component;
	private UserGroup usergroup;
	private Set<SystemPermission> componentPermissions;

	@Id
	@GeneratedValue
	@Column(name = "policy_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "component_id")
	public SystemComponent getComponent() {
		return component;
	}

	public void setComponent(SystemComponent component) {
		this.component = component;
	}

	@ManyToOne
	@JoinColumn(name = "group_id")
	public UserGroup getUsergroup() {
		return usergroup;
	}


	public void setUsergroup(UserGroup usergroup) {
		this.usergroup = usergroup;
	}

	@Transient
	public Set<SystemPermission> getComponentPermissions() {
		return componentPermissions;
	}

	public void setComponentPermissions(Set<SystemPermission> componentPermissions) {
		this.componentPermissions = componentPermissions;
	}

}
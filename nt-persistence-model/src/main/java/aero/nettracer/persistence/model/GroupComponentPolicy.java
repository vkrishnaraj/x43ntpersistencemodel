/*
 * Created on Jul 20, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "group_component_policy")
public class GroupComponentPolicy implements Serializable {
	private int policy_id;
	private SystemComponent component;
	private Set<SystemPermission> componentPermissions;
	private UserGroup usergroup;

	@ManyToOne
	@JoinColumn(name = "component_id")
	public SystemComponent getComponent() {
		return component;
	}

	public void setComponent(SystemComponent component) {
		this.component = component;
	}

	@Transient
	public Set<SystemPermission> getComponentPermissions() {
		return componentPermissions;
	}

	public void setComponentPermissions(Set<SystemPermission> componentPermissions) {
		this.componentPermissions = componentPermissions;
	}

	@ManyToOne
	@JoinColumn(name = "group_id")
	public UserGroup getUsergroup() {
		return usergroup;
	}


	public void setUsergroup(UserGroup usergroup) {
		this.usergroup = usergroup;
	}

	@Id
	@GeneratedValue
	public int getPolicy_id() {
		return policy_id;
	}


	public void setPolicy_id(int policy_id) {
		this.policy_id = policy_id;
	}


}
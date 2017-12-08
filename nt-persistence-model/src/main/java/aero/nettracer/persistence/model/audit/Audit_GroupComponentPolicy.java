package aero.nettracer.persistence.model.audit;

import java.io.Serializable;

import aero.nettracer.persistence.model.SystemComponent;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "audit_group_component_policy")
public class Audit_GroupComponentPolicy implements Serializable {

	private int audit_policy_id;
	private int policy_id;
	private SystemComponent component;
	private Audit_UserGroup audit_usergroup;

	@ManyToOne
	@JoinColumn(name = "component_id")
	public SystemComponent getComponent() {
		return component;
	}

	public void setComponent(SystemComponent component) {
		this.component = component;
	}

	@ManyToOne
	@JoinColumn(name = "audit_group_id")
	public Audit_UserGroup getAudit_usergroup() {
		return audit_usergroup;
	}

	public void setAudit_usergroup(Audit_UserGroup audit_usergroup) {
		this.audit_usergroup = audit_usergroup;
	}

	@Id
	@GeneratedValue
	public int getAudit_policy_id() {
		return audit_policy_id;
	}

	public void setAudit_policy_id(int audit_policy_id) {
		this.audit_policy_id = audit_policy_id;
	}

	public int getPolicy_id() {
		return policy_id;
	}

	public void setPolicy_id(int policy_id) {
		this.policy_id = policy_id;
	}
}
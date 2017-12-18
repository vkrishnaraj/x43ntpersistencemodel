package aero.nettracer.persistence.model;

import org.hibernate.annotations.OrderBy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.HashMap;
import java.util.Set;

@Entity
@Table(name = "usergroup")
public class UserGroup {

	private int id;
	private String companycode_ID;
	private String description2;
	private String description;
	private double bsoLimit;
	private double luvLimit;
	private String autoProvisionGroupName;

	private Set<GroupComponentPolicy> componentPolicies;
	private HashMap<String, GroupComponentPolicy> permissionNameMap = null;
	private HashMap<String, GroupComponentPolicy> permissionLinkMap = null;


	@Id
	@GeneratedValue
	@Column(name = "usergroup_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "companycode_id")
	public String getCompanycode_ID() {
		return companycode_ID;
	}

	public void setCompanycode_ID(String companycode_ID) {
		this.companycode_ID = companycode_ID;
	}

	@Column(name = "description2")
	public String getDescription2() {
		return description2;
	}

	public void setDescription2(String description) {
		this.description2 = description;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "bsolimit")
	public double getBsoLimit() {
		return bsoLimit;
	}

	public void setBsoLimit(double bsoLimit) {
		this.bsoLimit = bsoLimit;
	}

	@Column(name = "luvlimit")
	public double getLuvLimit() {
		return luvLimit;
	}

	public void setLuvLimit(double luvLimit) {
		this.luvLimit = luvLimit;
	}

	@Column(name = "autoprovisiongroupname")
	public String getAutoProvisionGroupName() {
		return autoProvisionGroupName;
	}

	public void setAutoProvisionGroupName(String autoProvisionGroupName) {
		this.autoProvisionGroupName = autoProvisionGroupName;
	}

	@OneToMany(mappedBy = "usergroup", cascade = CascadeType.ALL)
	@OrderBy(clause = "policy_id")
	public Set<GroupComponentPolicy> getComponentPolicies() {
		return componentPolicies;
	}

	public void setComponentPolicies(Set<GroupComponentPolicy> componentPolicies) {
		this.componentPolicies = componentPolicies;
	}

	@Transient
	public HashMap<String, GroupComponentPolicy> getPermissionNameMap() {
		if (permissionNameMap == null) {
			permissionNameMap = new HashMap<String, GroupComponentPolicy>();
			Set<GroupComponentPolicy> l = (Set<GroupComponentPolicy>)this.getComponentPolicies();

			if (l != null) {
				for (GroupComponentPolicy p: l) {
					permissionNameMap.put(p.getComponent().getComponent_Name().toUpperCase(), p);
				}
			}
		}
		return permissionNameMap;	
	}

	@Transient
	public HashMap<String, GroupComponentPolicy> getPermissionLinkMap() {
		if (permissionLinkMap == null) {
			permissionLinkMap = new HashMap<String, GroupComponentPolicy>();
			Set<GroupComponentPolicy> l = (Set<GroupComponentPolicy>)this.getComponentPolicies();

			if (l != null) {
				for (GroupComponentPolicy p: l) {
					String s = p.getComponent().getComponent_action_link();
					if (s != null) {
						int qIdx = s.indexOf("?");
						
						if (qIdx > 0) {
							s = s.substring(0, qIdx);
						}
						
						permissionLinkMap.put(s, p);
					}
				}
			}
		}
		return permissionLinkMap;	
	}

}
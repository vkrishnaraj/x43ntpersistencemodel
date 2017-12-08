package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "usergroup")
public class UserGroup implements Serializable {

	private static final long serialVersionUID = -943540365618533114L;
	private int UserGroup_ID;
	private String description;
	private String description2;
	private Set<GroupComponentPolicy> componentPolicies;
	private HashMap<String, GroupComponentPolicy> permissionNameMap = null;
	private HashMap<String, GroupComponentPolicy> permissionLinkMap = null;
	private String companycode_ID;
	private double bsoLimit;
	private double luvLimit;
	
	private String autoProvisionGroupName;

	@OneToMany(mappedBy = "usergroup", fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "policy_id")
	public Set<GroupComponentPolicy> getComponentPolicies() {
		return componentPolicies;
	}

	public void setComponentPolicies(Set<GroupComponentPolicy> componentPolicies) {
		this.componentPolicies = componentPolicies;
	}

	public String getCompanycode_ID() {
		return companycode_ID;
	}

	public void setCompanycode_ID(String companycode_ID) {
		this.companycode_ID = companycode_ID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription2() {
		return description2;
	}

	public void setDescription2(String description) {
		this.description2 = description;
	}

	@Id
	@GeneratedValue
	public int getUserGroup_ID() {
		return UserGroup_ID;
	}

	public void setUserGroup_ID(int userGroup_ID) {
		UserGroup_ID = userGroup_ID;
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

	public double getBsoLimit() {
		return bsoLimit;
	}

	public void setBsoLimit(double bsoLimit) {
		this.bsoLimit = bsoLimit;
	}

	public double getLuvLimit() {
		return luvLimit;
	}

	public void setLuvLimit(double luvLimit) {
		this.luvLimit = luvLimit;
	}

	public String getAutoProvisionGroupName() {
		return autoProvisionGroupName;
	}

	public void setAutoProvisionGroupName(String autoProvisionGroupName) {
		this.autoProvisionGroupName = autoProvisionGroupName;
	}
	
	
}
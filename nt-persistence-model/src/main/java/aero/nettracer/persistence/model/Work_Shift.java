/*
 * Created on Jul 14, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "work_shift")
public class Work_Shift implements Serializable {

	private int shiftId;
	private String shift_code;
	private String shift_description;
	private Company company;
	private String locale;
	private Set<Agent> agents;

	public String getShift_code() {
		return shift_code;
	}

	public void setShift_code(String shift_code) {
		this.shift_code = shift_code;
	}

	@OneToMany(mappedBy = "shift", fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	public Set<Agent> getAgents() {
		return agents;
	}

	public void setAgents(Set<Agent> agents) {
		this.agents = agents;
	}

	@ManyToOne
	@JoinColumn(name = "companycode_id")
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getShift_description() {
		return shift_description;
	}

	public void setShift_description(String shift_description) {
		this.shift_description = shift_description;
	}

	@Id
	@GeneratedValue
	public int getShift_id() {
		return shift_id;
	}

	public void setShift_id(int shift_id) {
		this.shift_id = shift_id;
	}
}
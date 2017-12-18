/*
 * Created on Jul 14, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "work_shift")
public class Work_Shift {

	private int id;
	private String shift_code;
	private String shift_description;
	private Company company;
	private String locale;
	private Set<Agent> agents;

	@Id
	@GeneratedValue
	@Column(name = "shift_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "shift_code")
	public String getShift_code() {
		return shift_code;
	}

	public void setShift_code(String shift_code) {
		this.shift_code = shift_code;
	}

	@Column(name = "shift_description")
	public String getShift_description() {
		return shift_description;
	}

	public void setShift_description(String shift_description) {
		this.shift_description = shift_description;
	}

	@ManyToOne
	@JoinColumn(name = "companycode_id")
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Column(name = "locale")
	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	@OneToMany(mappedBy = "shift", cascade = CascadeType.ALL)
	public Set<Agent> getAgents() {
		return agents;
	}

	public void setAgents(Set<Agent> agents) {
		this.agents = agents;
	}

}
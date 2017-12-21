package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
public class LFCategory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4630331956112342386L;
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="description",length = 64)
	String description;
	
	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@org.hibernate.annotations.OrderBy(clause = "id")
	List<LFSubCategory> subcategories;
	
	@Column(name="score")
	private int score;
	
	@Column(name="company_code",length = 8)
	private String companycode;
	
	@Column(name="dataplan")
	private boolean dataplan;

	@Column(name="wt_in_lb")
	private int weightInLB;

	@Column(name="HS_CODE")
	private String harmonizedCode;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<LFSubCategory> getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(List<LFSubCategory> subcategories) {
		this.subcategories = subcategories;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public void setCompanycode(String companycode) {
		this.companycode = companycode;
	}
	public String getCompanycode() {
		return companycode;
	}

	public boolean isDataplan() {
		return dataplan;
	}
	public void setDataplan(boolean dataplan) {
		this.dataplan = dataplan;
	}

	public int getWeightInLB() {
		return weightInLB;
	}

	public void setWeightInLB(int weightInLB) {
		this.weightInLB = weightInLB;
	}

	public String getHarmonizedCode() {
		return harmonizedCode;
	}

	public void setHarmonizedCode(String harmonizedCode) {
		this.harmonizedCode = harmonizedCode;
	}
}

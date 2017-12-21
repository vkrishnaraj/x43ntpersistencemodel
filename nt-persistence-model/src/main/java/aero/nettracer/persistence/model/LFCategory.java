package aero.nettracer.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "lfcategory")
public class LFCategory {

	private long id;
	private String description;
	private int score;
	private String companycode;
	private boolean dataplan;
	private int weightInLB;
	private String harmonizedCode;
	private List<LFSubCategory> subcategories;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="score")
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Column(name="company_code",length = 8)
	public String getCompanycode() {
		return companycode;
	}

	public void setCompanycode(String companycode) {
		this.companycode = companycode;
	}

	@Column(name="dataplan")
	public boolean isDataplan() {
		return dataplan;
	}

	public void setDataplan(boolean dataplan) {
		this.dataplan = dataplan;
	}

	@Column(name="wt_in_lb")
	public int getWeightInLB() {
		return weightInLB;
	}

	public void setWeightInLB(int weightInLB) {
		this.weightInLB = weightInLB;
	}

	@Column(name="HS_CODE")
	public String getHarmonizedCode() {
		return harmonizedCode;
	}

	public void setHarmonizedCode(String harmonizedCode) {
		this.harmonizedCode = harmonizedCode;
	}

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	@OrderBy(value = "id")
	public List<LFSubCategory> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<LFSubCategory> subcategories) {
		this.subcategories = subcategories;
	}

}

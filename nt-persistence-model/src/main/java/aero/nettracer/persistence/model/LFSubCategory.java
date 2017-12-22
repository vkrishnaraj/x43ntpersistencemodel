package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lfsubcategory")
public class LFSubCategory {
	
	private long id;
	private String description;
	private LFCategory parent;
	private int score;
	private boolean dataplan;
	private int weightInLB;
	private String harmonizedCode;

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

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	public LFCategory getParent() {
		return parent;
	}

	public void setParent(LFCategory parent) {
		this.parent = parent;
	}

	@Column(name="score")
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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

}

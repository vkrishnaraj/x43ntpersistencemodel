package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;


@Entity
@Proxy(lazy = false)
public class LFSubCategory implements Serializable{
	
	private static final long serialVersionUID = -8770644874113876878L;
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="description",length = 64)
	private String description;
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	@Fetch(FetchMode.SELECT)
	private LFCategory parent;
	
	@Column(name="score")
	private int score;
	
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
	public LFCategory getParent() {
		return parent;
	}
	public void setParent(LFCategory parent) {
		this.parent = parent;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
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

package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "depreciation_category")
public class Depreciation_Category {

	private int id;
	private String name;
	private int calcMethod;
	private boolean notCoveredCoc;
	private double flatRate;
	private double firstYear;
	private double secondYear;
	private double thirdYear;
	private double eachYear;
	private double maxDeprec;
	private String companyCode;
	private int orderNum;
	private int categoryTypeNum;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "calcMethod")
	public int getCalcMethod() {
		return calcMethod;
	}

	public void setCalcMethod(int calcMethod) {
		this.calcMethod = calcMethod;
	}

	@Column(name = "notCoveredCoc")
	public boolean isNotCoveredCoc() {
		return notCoveredCoc;
	}

	public void setNotCoveredCoc(boolean notCoveredCoc) {
		this.notCoveredCoc = notCoveredCoc;
	}

	@Column(name = "flatRate")
	public double getFlatRate() {
		return flatRate;
	}

	public void setFlatRate(double flatRate) {
		this.flatRate = flatRate;
	}

	@Column(name = "firstYear")
	public double getFirstYear() {
		return firstYear;
	}

	public void setFirstYear(double firstYear) {
		this.firstYear = firstYear;
	}

	@Column(name = "secondYear")
	public double getSecondYear() {
		return secondYear;
	}

	public void setSecondYear(double secondYear) {
		this.secondYear = secondYear;
	}

	@Column(name = "thirdYear")
	public double getThirdYear() {
		return thirdYear;
	}

	public void setThirdYear(double thirdYear) {
		this.thirdYear = thirdYear;
	}

	@Column(name = "eachYear")
	public double getEachYear() {
		return eachYear;
	}

	public void setEachYear(double eachYear) {
		this.eachYear = eachYear;
	}

	@Column(name = "maxDeprec")
	public double getMaxDeprec() {
		return maxDeprec;
	}

	public void setMaxDeprec(double maxDeprec) {
		this.maxDeprec = maxDeprec;
	}

	@Column(name = "companyCode")
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	@Column(name = "orderNum")
	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	@Column(name = "categoryTypeNum")
	public int getCategoryTypeNum() {
		return categoryTypeNum;
	}

	public void setCategoryTypeNum(int categoryTypeNum) {
		this.categoryTypeNum = categoryTypeNum;
	}
}

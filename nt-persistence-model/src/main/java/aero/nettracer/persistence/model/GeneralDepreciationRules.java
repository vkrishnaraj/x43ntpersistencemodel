package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "generaldepreciationrules")
public class GeneralDepreciationRules {

	private int id;
	private double lessTwentyDeprec;
	private double twentyOnefiftyDeprec;
	private double onehundredToOnefiftyDeprec;
	private double onefiftyDeprec;
	private int noDates;
	private double generalDeprecRulesMinValue;
	private double generalDeprecRulesMidValue;
	private double generalDeprecRulesMaxValue;

	private String companyCode;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "lessTwentyDeprec")
	public double getLessTwentyDeprec() {
		return lessTwentyDeprec;
	}

	public void setLessTwentyDeprec(double lessTwentyDeprec) {
		this.lessTwentyDeprec = lessTwentyDeprec;
	}

	@Column(name = "twentyOnefiftyDeprec")
	public double getTwentyOnefiftyDeprec() {
		return twentyOnefiftyDeprec;
	}

	public void setTwentyOnefiftyDeprec(double twentyOnefiftyDeprec) {
		this.twentyOnefiftyDeprec = twentyOnefiftyDeprec;
	}

	@Column(name = "onehundredToOnefiftyDeprec")
	public double getOnehundredToOnefiftyDeprec() {
		return onehundredToOnefiftyDeprec;
	}

	public void setOnehundredToOnefiftyDeprec(double onehundredToOnefiftyDeprec) {
		this.onehundredToOnefiftyDeprec = onehundredToOnefiftyDeprec;
	}

	@Column(name = "onefiftyDeprec")
	public double getOnefiftyDeprec() {
		return onefiftyDeprec;
	}

	public void setOnefiftyDeprec(double onefiftyDeprec) {
		this.onefiftyDeprec = onefiftyDeprec;
	}

	@Column(name = "noDates")
	public int getNoDates() {
		return noDates;
	}

	public void setNoDates(int noDates) {
		this.noDates = noDates;
	}

	@Column(name = "companyCode")
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	@Column(name = "generalDeprecRulesMinValue")
	public double getGeneralDeprecRulesMinValue() {
		return generalDeprecRulesMinValue;
	}

	public void setGeneralDeprecRulesMinValue(double generalDeprecRulesMinValue) {
		this.generalDeprecRulesMinValue = generalDeprecRulesMinValue;
	}

	@Column(name = "generalDeprecRulesMidValue")
	public double getGeneralDeprecRulesMidValue() {
		return generalDeprecRulesMidValue;
	}

	public void setGeneralDeprecRulesMidValue(double generalDeprecRulesMidValue) {
		this.generalDeprecRulesMidValue = generalDeprecRulesMidValue;
	}

	@Column(name = "generalDeprecRulesMaxValue")
	public double getGeneralDeprecRulesMaxValue() {
		return generalDeprecRulesMaxValue;
	}

	public void setGeneralDeprecRulesMaxValue(double generalDeprecRulesMaxValue) {
		this.generalDeprecRulesMaxValue = generalDeprecRulesMaxValue;
	}
}

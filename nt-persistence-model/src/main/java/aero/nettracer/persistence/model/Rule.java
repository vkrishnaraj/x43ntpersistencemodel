package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rule")
public class Rule {

	private int id;
	private String ruleName;
	private double gtsv;
	private int minLength;
	private int maxLength;
	private double v10;
	private double v9;
	private double v8;
	private double v7;
	private double v6;
	private double v5;
	private double v4;
	private double v3;
	private double v2;
	private double v1;
	private double v0;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "rn", nullable = false)
	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	@Column(name = "gtsv", nullable = false)
	public double getGtsv() {
		return gtsv;
	}

	public void setGtsv(double gtsv) {
		this.gtsv = gtsv;
	}

	@Column(name = "minlen", nullable = false)
	public int getMinLength() {
		return minLength;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}

	@Column(name = "maxlen", nullable = false)
	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	@Column(name = "v10", nullable = false)
	public double getV10() {
		return v10;
	}

	public void setV10(double v10) {
		this.v10 = v10;
	}

	@Column(name = "v9", nullable = false)
	public double getV9() {
		return v9;
	}

	public void setV9(double v9) {
		this.v9 = v9;
	}

	@Column(name = "v8", nullable = false)
	public double getV8() {
		return v8;
	}

	public void setV8(double v8) {
		this.v8 = v8;
	}

	@Column(name = "v7", nullable = false)
	public double getV7() {
		return v7;
	}

	public void setV7(double v7) {
		this.v7 = v7;
	}

	@Column(name = "v6", nullable = false)
	public double getV6() {
		return v6;
	}

	public void setV6(double v6) {
		this.v6 = v6;
	}

	@Column(name = "v5", nullable = false)
	public double getV5() {
		return v5;
	}

	public void setV5(double v5) {
		this.v5 = v5;
	}

	@Column(name = "v4", nullable = false)
	public double getV4() {
		return v4;
	}

	public void setV4(double v4) {
		this.v4 = v4;
	}

	@Column(name = "v3", nullable = false)
	public double getV3() {
		return v3;
	}

	public void setV3(double v3) {
		this.v3 = v3;
	}

	@Column(name = "v2", nullable = false)
	public double getV2() {
		return v2;
	}

	public void setV2(double v2) {
		this.v2 = v2;
	}

	@Column(name = "v1", nullable = false)
	public double getV1() {
		return v1;
	}

	public void setV1(double v1) {
		this.v1 = v1;
	}

	@Column(name = "v0", nullable = false)
	public double getV0() {
		return v0;
	}

	public void setV0(double v0) {
		this.v0 = v0;
	}
}

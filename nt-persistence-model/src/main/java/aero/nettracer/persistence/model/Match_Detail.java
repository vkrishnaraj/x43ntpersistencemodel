package aero.nettracer.persistence.model;

import aero.nettracer.commons.utils.CommonsUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "match_detail")
public class Match_Detail {

	private int id;
	private Match match;
	private String item;
	private String mbr_info;
	private String ohd_info;
	private double percentage;


	@Id
	@GeneratedValue
	@Column(name = "Matchdetail_ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "match_id")
	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	@Column(name = "item")
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Column(name = "mbr_info")
	public String getMbr_info() {
		return mbr_info;
	}

	public void setMbr_info(String mbr_info) {
		this.mbr_info = mbr_info;
	}

	@Column(name = "ohd_info")
	public String getOhd_info() {
		return ohd_info;
	}

	public void setOhd_info(String ohd_info) {
		this.ohd_info = ohd_info;
	}

	@Column(name = "percentage")
	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	@Transient
	public String getReportPercentage() {
		return "" + percentage;
	}

	@Transient
	public String getDisppercent() {
		return CommonsUtils.format(getPercentage(), "%");
	}

}
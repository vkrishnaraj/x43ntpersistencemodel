package aero.nettracer.persistence.model;

import java.io.Serializable;

import aero.nettracer.commons.utils.CommonsUtils;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Match_Detail")
public class Match_Detail implements Serializable {

	private int Matchdetail_ID;
	private String item;
	private String mbr_info;
	private String ohd_info;
	private double percentage;
	
	private Match match;

	@Transient
	public String getReportPercentage() {
		return "" + percentage;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Id
	@GeneratedValue
	public int getMatchdetail_ID() {
		return Matchdetail_ID;
	}

	public void setMatchdetail_ID(int matchdetail_ID) {
		Matchdetail_ID = matchdetail_ID;
	}

	@ManyToOne
	@JoinColumn(name = "match_id")
	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}
	
	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public String getMbr_info() {
		return mbr_info;
	}

	public void setMbr_info(String mbr_info) {
		this.mbr_info = mbr_info;
	}

	public String getOhd_info() {
		return ohd_info;
	}

	public void setOhd_info(String ohd_info) {
		this.ohd_info = ohd_info;
	}

	@Transient
	public String getDisppercent() {
		return CommonsUtils.format(getPercentage(), "%");
	}

}
package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "wt_roh")
public class WT_ROH {
	
	private int id;
	private String wt_ahl_id;
	private String wt_ohd_id;
	private String fi;
	private String ag;
	private String teletype_address1;
	private String teletype_address2;
	private String teletype_address3;
	private String teletype_address4;
	private int roh_status;
	private int roh_station_id;
	private Agent roh_agent;
	private String lname;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "wt_ahl_id")
	public String getWt_ahl_id() {
		return wt_ahl_id;
	}

	public void setWt_ahl_id(String wt_ahl_id) {
		this.wt_ahl_id = wt_ahl_id;
	}

	@Column(name = "wt_ohd_id")
	public String getWt_ohd_id() {
		return wt_ohd_id;
	}

	public void setWt_ohd_id(String wt_ohd_id) {
		this.wt_ohd_id = wt_ohd_id;
	}

	@Column(name = "fi")
	public String getFi() {
		return fi;
	}

	public void setFi(String fi) {
		this.fi = fi;
	}

	@Column(name = "ag")
	public String getAg() {
		return ag;
	}

	public void setAg(String ag) {
		this.ag = ag;
	}

	@Column(name = "teletype_address1")
	public String getTeletype_address1() {
		return teletype_address1;
	}

	public void setTeletype_address1(String teletype_address1) {
		this.teletype_address1 = teletype_address1;
	}

	@Column(name = "teletype_address2")
	public String getTeletype_address2() {
		return teletype_address2;
	}

	public void setTeletype_address2(String teletype_address2) {
		this.teletype_address2 = teletype_address2;
	}

	@Column(name = "teletype_address3")
	public String getTeletype_address3() {
		return teletype_address3;
	}

	public void setTeletype_address3(String teletype_address3) {
		this.teletype_address3 = teletype_address3;
	}

	@Column(name = "teletype_address4")
	public String getTeletype_address4() {
		return teletype_address4;
	}

	public void setTeletype_address4(String teletype_address4) {
		this.teletype_address4 = teletype_address4;
	}

	@Column(name = "roh_status")
	public int getRoh_status() {
		return roh_status;
	}

	public void setRoh_status(int roh_status) {
		this.roh_status = roh_status;
	}

	@Column(name = "roh_station_id")
	public int getRoh_station_id() {
		return roh_station_id;
	}

	public void setRoh_station_id(int roh_station_id) {
		this.roh_station_id = roh_station_id;
	}

	@ManyToOne
	@JoinColumn(name = "roh_agent_id")
	public Agent getRoh_agent_id() {
		return roh_agent;
	}

	public void setRoh_agent_id(Agent roh_agent) {
		this.roh_agent = roh_agent;
	}

	@Column(name = "roh_agent")
	public Agent getRoh_agent() {
		return roh_agent;
	}

	public void setRoh_agent(Agent roh_agent) {
		this.roh_agent = roh_agent;
	}

	@Column(name = "lname")
	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

}

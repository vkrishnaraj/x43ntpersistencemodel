package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.regex.Pattern;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "worldtracer_actionfiles")
public class Worldtracer_Actionfiles implements Serializable {
	private int id;
	private ActionFileType action_file_type;
	private String seq;
	private String action_file_summary;
	private String action_file_text;
	private int day;
	private String wt_station;
	private String airline;
	private String wt_incident_id;
	private String wt_ohd_id;
	private double percent_match;
	private int item_number;
	private boolean deleted;
	
	private static final String id_pattern = "^\\w{2}-\\w{3}-[A-Z]{2}-[0-9A-Z]{0,3}-\\d+-\\d+$";

	public Worldtracer_Actionfiles() {}
	
	public Worldtracer_Actionfiles(String type_id) throws Exception {
		if (Pattern.matches(id_pattern, type_id)) {
			String [] strList = type_id.split("-");
			this.airline = strList[0];
			this.wt_station = strList[1];
			this.action_file_type = ActionFileType.valueOf(strList[2]);
			this.seq = strList[3];
			this.day = Integer.parseInt(strList[4]);
			this.item_number = Integer.parseInt(strList[5]);
		}
		else {
			throw new Exception("invalid action file id");
		}
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Enumerated(EnumType.STRING)
	public ActionFileType getAction_file_type() {
		return action_file_type;
	}

	public void setAction_file_type(ActionFileType action_file_type) {
		this.action_file_type = action_file_type;
	}
	

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}
	

	public String getAction_file_text() {
		return action_file_text;
	}

	public void setAction_file_text(String action_file_text) {
		this.action_file_text = action_file_text;
	}


	public String getStation() {
		return wt_station;
	}

	public void setStation(String station) {
		this.wt_station = station;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getWt_incident_id() {
		return wt_incident_id;
	}

	public void setWt_incident_id(String wt_incident_id) {
		this.wt_incident_id = wt_incident_id;
	}

	public String getWt_ohd_id() {
		return wt_ohd_id;
	}

	public void setWt_ohd_id(String wt_ohd_id) {
		this.wt_ohd_id = wt_ohd_id;
	}

	public double getPercent_match() {
		return percent_match;
	}
	public void setPercent_match(double percent) {
		this.percent_match = percent;
	}
	

	public int getItem_number() {
		return item_number;
	}
	public void setItem_number(int item_number) {
		this.item_number = item_number;
	}


	public String generateId() {
		return String.format("%s-%s-%s-%s-%d-%d", airline, this.wt_station, this.action_file_type.name(), this.seq, this.day, this.item_number);
	}


	@Column(name = "delete_trigger")
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}


	@Column(name = "summary", length = 512)
	public String getAction_file_summary() {
		return action_file_summary;
	}

	public void setAction_file_summary(String action_file_summary) {
		this.action_file_summary = action_file_summary;
	}
	
	//these have to be down here or they muss up the xdoclet hibernate mapping generator.
	public static enum ActionFileType {
		FW("fm", "FORWARD_AREA"), AA("am", "ACTION_AREA"), WM("sm", "SYSTEM_MATCH_AREA"), EM("em", "EXTENDED_MATCH_AREA"), SP("sp", "SYSTEM_PROMPT_AREA"), AP("ap", "ADDITIONAL_PROMPT_AREA"), CM("cm", "CLAIMS_MATCH_AREA"), LM("lm", "LOCAL_MESSAGE_AREA"), PR("pr", "RETIRED_AREA"), XX("xx","ADMIN_MESSAGES"), HQ("hq", "MANAGEMENT"), IN("in","INSURANCE");
		
		private String htmlId;
		private String areaId;
		
		private ActionFileType(String htmlId, String areaId) {
			this.htmlId = htmlId;
			this.areaId = areaId;
		}
		
		public String htmlId() {
			return htmlId;
		}
		public String areaId() {
			return areaId;
		}
	};
}

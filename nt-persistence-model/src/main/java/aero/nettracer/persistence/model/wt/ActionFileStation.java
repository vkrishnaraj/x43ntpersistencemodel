package aero.nettracer.persistence.model.wt;

import aero.nettracer.persistence.model.Worldtracer_Actionfiles.ActionFileType;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class ActionFileStation {

	private long id;
	private String companyCode;
	private Timestamp lastUpdated;
	private String stationCode;
	private Collection<ActionFileCount> countList;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "company_code", length = 2)
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	@Column(name = "lastupdated")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Column(name = "station_code")
	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	@ElementCollection
	@JoinTable(name = "actionfile_station_counts", joinColumns = @JoinColumn(name = "af_station_id"))
	public Collection<ActionFileCount> getCountList() {
		return countList;
	}

	public void setCountList(Collection<ActionFileCount> countList) {
		this.countList = countList;
	}

	public boolean summaryLoaded(ActionFileType afType, int day, String seq) {
		for(ActionFileCount counts:countList){
			if(counts.getAf_type().equals(afType) 
					&& counts.getAf_seq().equals(seq)){
				switch (day) {
				case 1:
					return counts.isDayOneLoaded();
				case 2:
					return counts.isDayTwoLoaded();
				case 3:
					return counts.isDayThreeLoaded();
				case 4:
					return counts.isDayFourLoaded();
				case 5:
					return counts.isDayFiveLoaded();
				case 6:
					return counts.isDaySixLoaded();
				case 7:
					return counts.isDaySevenLoaded();
				default:
					return false;
				}
			}
		}
		return false;
	}
}

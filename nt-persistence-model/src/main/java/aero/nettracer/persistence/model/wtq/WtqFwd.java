package aero.nettracer.persistence.model.wtq;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OrderBy;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public abstract class WtqFwd extends WorldTracerQueue {

	private String fwdDestinationAirline;
	private String fwdDestinationStation;
	private String fwdExpediteNum;
	private String matchingAhl;
	private String supInfo;
	private String fwdTagNum = null;
	private String handleCopy = null;
	private Set<String> name = new HashSet<String>();
	private Collection<WtqSegment> itinerary = new ArrayList<WtqSegment>();
	private Set<String> teletypes = new HashSet<String>();

	@Column(name = "fwddestinationairline")
	public String getFwdDestinationAirline() {
		return fwdDestinationAirline;
	}

	public void setFwdDestinationAirline(String fwdDestinationAirline) {
		this.fwdDestinationAirline = fwdDestinationAirline;
	}

	@Column(name = "fwddestinationstation")
	public String getFwdDestinationStation() {
		return fwdDestinationStation;
	}

	public void setFwdDestinationStation(String fwdDestinationStation) {
		this.fwdDestinationStation = fwdDestinationStation;
	}

	@Column(name = "fwdexpeditenum")
	public String getFwdExpediteNum() {
		return fwdExpediteNum;
	}

	public void setFwdExpediteNum(String expediteNum) {
		this.fwdExpediteNum = expediteNum;
	}

	@Column(name = "matchingahl")
	public String getMatchingAhl() {
		return matchingAhl;
	}

	public void setMatchingAhl(String matchingAhl) {
		this.matchingAhl = matchingAhl;
	}

	@Column(name = "supinfo")
	public String getSupInfo() {
		return supInfo;
	}

	public void setSupInfo(String supInfo) {
		this.supInfo = supInfo;
	}

	@Column(name = "fwdtagnum")
	public String getFwdTagNum() {
		return fwdTagNum;
	}

	public void setFwdTagNum(String fwdTagNum) {
		this.fwdTagNum = fwdTagNum;
	}

	@Column(name = "handlecopy")
	public String getFwdHandleCopy() {
		return handleCopy;
	}

	public void setFwdHandleCopy(String handleCopy) {
		this.handleCopy = handleCopy;
	}

	@ElementCollection
	@JoinTable(name = "wtq_name", joinColumns = @JoinColumn(name = "wt_queue_id"))
	@Column(name = "pax_name", nullable = false)
	public Set<String> getFwdName() {
		return name;
	}

	public void setFwdName(Set<String> name) {
		this.name = name;
	}

	@ElementCollection
	@JoinTable(name = "wtq_segment", joinColumns = @JoinColumn(name = "segment_id"))
	@OrderBy(value = "departdate asc, departureTime asc")
	public Collection<WtqSegment> getItinerary() {
		return itinerary;
	}

	public void setItinerary(Collection<WtqSegment> itinerary) {
		this.itinerary = itinerary;
	}

	@ElementCollection
	@JoinTable(name = "wtq_teletype", joinColumns = @JoinColumn(name = "wt_queue_id"))
	@Column(name = "ttype_address", nullable = false)
	public Set<String> getTeletypes() {
		return teletypes;
	}

	public void setTeletypes(Set<String> teletypes) {
		this.teletypes = teletypes;
	}

	@Override
	@Transient
	public Object[] getExistsParameters() {
		return new Object[] { this.getFwdExpediteNum(), this.getStatus() };
	}

	@Override
	@Transient
	public String getExistsQuery() {
		return "from WtqFwd fwd where fwd.fwdExpediteNum = ? and fwd.status = ?";
	}

}

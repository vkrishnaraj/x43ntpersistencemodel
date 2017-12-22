package aero.nettracer.persistence.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ohd_log")
public class OHD_Log {

	private int id;
	private String expeditenum;
	private String message;
	private Agent forwarding_agent;
	private int destStationCode;
	private OHD ohd;
	private int ohd_request_id;
	private Timestamp forward_time;
	private int log_status;
	private ProactiveNotification pcn;
	private Set<OHD_Log_Itinerary> itinerary;
	private String destStation;
	private String destCompany;

	@Id
	@GeneratedValue
	@Column(name = "ohdlog_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "expeditenum")
	public String getExpeditenum() {
		return expeditenum;
	}

	public void setExpeditenum(String expeditenum) {
		this.expeditenum = expeditenum;
	}

	@Column(name = "message")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@ManyToOne
	@JoinColumn(name = "send_agent_id")
	public Agent getForwarding_agent() {
		return forwarding_agent;
	}

	public void setForwarding_agent(Agent forwarding_agent) {
		this.forwarding_agent = forwarding_agent;
	}

	@Column(name = "deststationcode")
	public int getDestStationCode() {
		return destStationCode;
	}

	public void setDestStationCode(int destStationCode) {
		this.destStationCode = destStationCode;
	}

	@ManyToOne
	@JoinColumn(name = "ohd_id")
	public OHD getOhd() {
		return ohd;
	}

	public void setOhd(OHD ohd) {
		this.ohd = ohd;
	}

	@Column(name = "ohd_request_id")
	public int getOhd_request_id() {
		return ohd_request_id;
	}

	public void setOhd_request_id(int ohd_request_id) {
		this.ohd_request_id = ohd_request_id;
	}

	@Column(name = "forward_time")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getForward_time() {
		return forward_time;
	}

	public void setForward_time(Timestamp forward_time) {
		this.forward_time = forward_time;
	}

	@Column(name = "log_status")
	public int getLog_status() {
		return log_status;
	}

	public void setLog_status(int log_status) {
		this.log_status = log_status;
	}

	@ManyToOne
	@JoinColumn(name = "pcn")
	public ProactiveNotification getPcn() {
		return pcn;
	}

	public void setPcn(ProactiveNotification pcn) {
		this.pcn = pcn;
	}

	@OneToMany(mappedBy = "log", cascade = CascadeType.ALL)
	@OrderBy(value = "itinerarytype,departdate,schdeparttime")
	public Set<OHD_Log_Itinerary> getItinerary() {
		return itinerary;
	}

	public void setItinerary(Set<OHD_Log_Itinerary> itinerary) {
		this.itinerary = itinerary;
	}

	@Transient
	public String getDestStation() {
		return destStation;
	}

	public void setDestStation(String destStation) {
		this.destStation = destStation;
	}

	@Transient
	public String getDestCompany() {
		return destCompany;
	}

	public void setDestCompany(String destCompany) {
		this.destCompany = destCompany;
	}

	@Transient
	public List<OHD_Log_Itinerary> getItinerarylist() {
		if (itinerary == null || itinerary.size() < 1)
			return null;

		return new ArrayList<OHD_Log_Itinerary>(itinerary);
	}

	@Transient
	public String getDispDestinationAirline() {
		if (itinerary == null || itinerary.isEmpty())
			return "";
		Object[] items = itinerary.toArray();
		OHD_Log_Itinerary itinerary = (OHD_Log_Itinerary) items[items.length - 1];
		return itinerary.getAirline() != null ? itinerary.getAirline() : "";
	}

	@Transient
	public String getDispDestinationFlightnum() {
		if (itinerary == null || itinerary.isEmpty())
			return "";
		Object[] items = itinerary.toArray();
		OHD_Log_Itinerary itinerary = (OHD_Log_Itinerary) items[items.length - 1];
		return itinerary.getFlightnum() != null ? itinerary.getFlightnum() : "";
	}

	// Commenting out this method will break dozer. Leaving it commented out to fix it the right way
	/*@Transient
	public int getLogStatusDescription(){
		return log_status;
	}

	public void setLogStatusDescription(int log_status){
		this.log_status = log_status;
	}*/

}
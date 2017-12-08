/*
 * Created on Jul 20, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "recipient_list")
public class Recipient implements Serializable {

	private int recipient_id;
	private Station station;
	private int station_id = 0;
	private String company_code = "";
	private Message message;

	@ManyToOne
	@JoinColumn(name = "message_id")
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	@Transient
	public String getCompany_code() {
		return company_code;
	}

	public void setCompany_code(String company_code) {
		this.company_code = company_code;
	}

	private List stationList;

	@Transient
	public List getStationList() {
		return stationList;
	}

	public void setStationList(List stationList) {
		this.stationList = stationList;
	}

	@Transient
	public int getStation_id() {
		return station_id;
	}

	public void setStation_id(int station_id) {
		this.station_id = station_id;
	}

	@Id
	@GeneratedValue
	public int getRecipient_id() {
		return recipient_id;
	}

	public void setRecipient_id(int recipient_id) {
		this.recipient_id = recipient_id;
	}

	@ManyToOne
	@JoinColumn(name = "station_ID")
	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}
}
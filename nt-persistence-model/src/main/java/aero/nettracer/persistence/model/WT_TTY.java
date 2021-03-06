package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;

@Entity
@Table(name = "wt_tty")
public class WT_TTY {

	private int id;
	private String teletype_address1;
	private String teletype_address2;
	private String teletype_address3;
	private String teletype_address4;
	private String origin_address;
	private String airline_code;
	private String file_type1;
	private String file_type2;
	private String file_type3;
	private String file_type4;
	private String file_reference1;
	private String file_reference2;
	private String file_reference3;
	private String file_reference4;
	private int tty_status;
	private int tty_station_id;
	private Agent tty_agent;
	private Timestamp send_time;
	private String text;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Column(name = "origin_address")
	public String getOrigin_address() {
		return origin_address;
	}

	public void setOrigin_address(String origin_address) {
		this.origin_address = origin_address;
	}

	@Column(name = "airline_code")
	public String getAirline_code() {
		return airline_code;
	}

	public void setAirline_code(String airline_code) {
		this.airline_code = airline_code;
	}

	@Column(name = "file_type1")
	public String getFile_type1() {
		return file_type1;
	}

	public void setFile_type1(String file_type1) {
		this.file_type1 = file_type1;
	}

	@Column(name = "file_type2")
	public String getFile_type2() {
		return file_type2;
	}

	public void setFile_type2(String file_type2) {
		this.file_type2 = file_type2;
	}

	@Column(name = "file_type3")
	public String getFile_type3() {
		return file_type3;
	}

	public void setFile_type3(String file_type3) {
		this.file_type3 = file_type3;
	}

	@Column(name = "file_type4")
	public String getFile_type4() {
		return file_type4;
	}

	public void setFile_type4(String file_type4) {
		this.file_type4 = file_type4;
	}

	@Column(name = "file_reference1")
	public String getFile_reference1() {
		return file_reference1;
	}

	public void setFile_reference1(String file_reference1) {
		this.file_reference1 = file_reference1;
	}

	@Column(name = "file_reference2")
	public String getFile_reference2() {
		return file_reference2;
	}

	public void setFile_reference2(String file_reference2) {
		this.file_reference2 = file_reference2;
	}

	@Column(name = "file_reference3")
	public String getFile_reference3() {
		return file_reference3;
	}

	public void setFile_reference3(String file_reference3) {
		this.file_reference3 = file_reference3;
	}

	@Column(name = "file_reference4")
	public String getFile_reference4() {
		return file_reference4;
	}

	public void setFile_reference4(String file_reference4) {
		this.file_reference4 = file_reference4;
	}

	@Column(name = "tty_status")
	public int getTty_status() {
		return tty_status;
	}

	public void setTty_status(int tty_status) {
		this.tty_status = tty_status;
	}

	@Column(name = "tty_station_id")
	public int getTty_station_id() {
		return tty_station_id;
	}

	public void setTty_station_id(int tty_station_id) {
		this.tty_station_id = tty_station_id;
	}

	@ManyToOne
	@JoinColumn(name = "tty_agent_id")
	public Agent getTty_agent() {
		return tty_agent;
	}

	public void setTty_agent(Agent tty_agent) {
		this.tty_agent = tty_agent;
	}

	@Column(name = "send_time", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getSend_time() {
		return send_time;
	}

	public void setSend_time(Timestamp send_time) {
		this.send_time = send_time;
	}

	@Column(name = "text", columnDefinition = "text")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
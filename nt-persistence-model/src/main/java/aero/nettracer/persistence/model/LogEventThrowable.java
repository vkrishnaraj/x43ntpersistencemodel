package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "logger_throwable")
public class LogEventThrowable {

	private int id;
	private LogEvent logevent;
	private int t_position;
	private String message;

	@Id
	@GeneratedValue
	@Column(name = "throwable_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "log_id")
	public LogEvent getLogevent() {
		return logevent;
	}

	public void setLogevent(LogEvent logevent) {
		this.logevent = logevent;
	}

	@Column(name = "t_position")
	public int getT_position() {
		return t_position;
	}

	public void setT_position(int t_position) {
		this.t_position = t_position;
	}

	@Column(name = "message")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
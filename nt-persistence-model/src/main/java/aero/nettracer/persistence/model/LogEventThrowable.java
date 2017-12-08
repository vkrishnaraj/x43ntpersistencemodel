package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "LOGGER_THROWABLE")
public class LogEventThrowable implements Serializable {
	private int throwable_ID;
	private int t_position;
	private String message;
	private int log_ID;
	
	private LogEvent logevent;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getT_position() {
		return t_position;
	}

	public void setT_position(int t_position) {
		this.t_position = t_position;
	}

	@Id
	@GeneratedValue
	public int getThrowable_ID() {
		return throwable_ID;
	}

	public void setThrowable_ID(int throwable_ID) {
		this.throwable_ID = throwable_ID;
	}

	@ManyToOne
	@JoinColumn(name = "log_ID")
	public LogEvent getLogevent() {
		return logevent;
	}

	public void setLogevent(LogEvent logevent) {
		this.logevent = logevent;
	}
}
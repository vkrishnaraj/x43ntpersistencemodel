package aero.nettracer.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "logs")
public class LogEvent {

	private int id;
	private String loglevel;
	private String message;
	private String className;
	private String fileName;
	private String lineNumber;
	private String methodName;
	private String loggerName;
	private Date logDate;
	private Time logTime;
	private String threadName;
	private List<LogEventThrowable> loggingEventThrowableWrapper = new ArrayList();

	@Id
	@GeneratedValue
	@Column(name = "log_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "log_level")
	public String getLoglevel() {
		return loglevel;
	}

	public void setLoglevel(String loglevel) {
		this.loglevel = loglevel;
	}

	@Column(name = "message")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "class_name")
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Column(name = "file_name")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "line_number")
	public String getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	@Column(name = "method_name")
	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	@Column(name = "logger_name")
	public String getLoggerName() {
		return loggerName;
	}

	public void setLoggerName(String loggerName) {
		this.loggerName = loggerName;
	}

	@Column(name = "log_date")
	@Temporal(TemporalType.DATE)
	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	@Column(name = "log_time")
	@Temporal(TemporalType.TIME)
	public Time getLogTime() {
		return logTime;
	}

	public void setLogTime(Time logTime) {
		this.logTime = logTime;
	}

	@Column(name = "thread_name")
	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	@OneToMany(mappedBy = "logevent", cascade = CascadeType.ALL)
	public List<LogEventThrowable> getLoggingEventThrowableWrapper() {
		return loggingEventThrowableWrapper;
	}

	public void setLoggingEventThrowableWrapper(List<LogEventThrowable> loggingEventThrowableWrapper) {
		this.loggingEventThrowableWrapper = loggingEventThrowableWrapper;
	}

	public void addThrowableMessage(int position, String throwableMessage) {
		LogEventThrowable letw = new LogEventThrowable();
		letw.setT_position(position);
		letw.setMessage(throwableMessage);
		loggingEventThrowableWrapper.add(letw);
	}

}
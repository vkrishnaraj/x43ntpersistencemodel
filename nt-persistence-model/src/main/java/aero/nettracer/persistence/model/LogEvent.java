package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Logs")
public class LogEvent implements Serializable {
	private int log_ID;
	private String loglevel;
	private String message;
	private String className;
	private String fileName;
	private String lineNumber;
	private String methodName;
	private String loggerName;
	private Date logTime;
	private Date logDate;
	private String threadName;
	private List<LogEventThrowable> loggingEventThrowableWrapper = new ArrayList();

	public void addThrowableMessage(int position, String throwableMessage) {
		LogEventThrowable letw = new LogEventThrowable();
		letw.setT_position(position);
		letw.setMessage(throwableMessage);
		loggingEventThrowableWrapper.add(letw);
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

	@Column(name = "log_level")
	public String getLoglevel() {
		return loglevel;
	}

	public void setLoglevel(String loglevel) {
		this.loglevel = loglevel;
	}

	@Column(name = "line_number")
	public String getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	@Id
	@GeneratedValue
	public int getLog_ID() {
		return log_ID;
	}

	public void setLog_ID(int log_ID) {
		this.log_ID = log_ID;
	}

	@Column(name = "log_date")
	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	@Column(name = "logger_name")
	public String getLoggerName() {
		return loggerName;
	}

	public void setLoggerName(String loggerName) {
		this.loggerName = loggerName;
	}

	@OneToMany(mappedBy = "logevent", fetch = FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	public List<LogEventThrowable> getLoggingEventThrowableWrapper() {
		return loggingEventThrowableWrapper;
	}

	public void setLoggingEventThrowableWrapper(List<LogEventThrowable> loggingEventThrowableWrapper) {
		this.loggingEventThrowableWrapper = loggingEventThrowableWrapper;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "method_name")
	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	@Column(name = "log_time")
	@Temporal(TemporalType.TIME)
	public Date getLogTime() {
		return logTime;
	}

	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}

	@Column(name = "thread_name")
	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}
}
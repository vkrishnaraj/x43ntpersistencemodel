package aero.nettracer.persistence.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pax_message_trigger")
public class PaxMessageTrigger {

	private String triggerKey;
	private String emailContentText;
	private String language = "en";
	private String smsContentText;
	private String subjectLine;

	@Id
	@Column(name="trigger_key")
	public String getTriggerKey() {
		return triggerKey;
	}

	public void setTriggerKey(String triggerKey) {
		this.triggerKey = triggerKey;
	}

	@Column(name="email_content_text")
	public String getEmailContentText() {
		return emailContentText;
	}

	public void setEmailContentText(String emailContentText) {
		this.emailContentText = emailContentText;
	}

	@Column(name="language")
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name="sms_content_text")
	public String getSmsContentText() {
		return smsContentText;
	}

	public void setSmsContentText(String smsContentText) {
		this.smsContentText = smsContentText;
	}
	
	@Column(name="subject_line")
	public String getSubjectLine() {
		return subjectLine;
	}
	public void setSubjectLine(String subjectLine) {
		this.subjectLine = subjectLine;
	}

}

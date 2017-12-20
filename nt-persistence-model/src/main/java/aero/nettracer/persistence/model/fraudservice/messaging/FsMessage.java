package aero.nettracer.persistence.model.fraudservice.messaging;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;

@Entity
@Table(name="central_message")
public class FsMessage {

	public static enum MessageContext {
		FraudScreening
	}

	public static enum MessageStatus {

	}

	private long id;
	private String message;
	private MessageContext messageContext;
	private long senderAgentId;
	private String senderName;
	private Timestamp createdate;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "message")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "messagecontext")
	public MessageContext getMessageContext() {
		return messageContext;
	}

	public void setMessageContext(MessageContext messageContext) {
		this.messageContext = messageContext;
	}

	@Column(name = "senderagentid")
	public long getSenderAgentId() {
		return senderAgentId;
	}

	public void setSenderAgentId(long senderAgentId) {
		this.senderAgentId = senderAgentId;
	}

	@Column(name = "sendername")
	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	@Column(name = "createdate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}
}

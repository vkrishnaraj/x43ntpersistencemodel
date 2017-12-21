package aero.nettracer.persistence.model.wtq;


import aero.nettracer.persistence.model.Agent;
import aero.nettracer.persistence.model.Incident;
import aero.nettracer.persistence.model.OHD;
import aero.nettracer.persistence.util.TxType;
import org.hibernate.annotations.Proxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;

@Entity
@Table(name="wt_transaction")
@Proxy(lazy=false)
public class WorldTracerTransaction {
	
	public static final String UNKNOWN_ERROR = "Unknown Error";
	
	private static int MAX_ERROR_MSG = 99;
	
	public enum Result {FAILURE("wt_txfailure"), SUCCESS("wt_txsuccess");
		private String messageKey;
		
		Result(String messageKey) {
			this.messageKey = messageKey;
		}
		
		public String getMessageKey() {
			return messageKey;
		}
		
		public String getValue() {
			return this.name();
		}
	}

	private long id;
	private Timestamp createDate;
	private long duration = -1;
	private String error;
	private Result result;
	private String txInputData;
	private String txOutputData;
	private TxType txType;
	private Incident incident;
	private OHD ohd;
	private Agent agent;
	private long start = -1;
	private long finish = -1;

	public WorldTracerTransaction() {
		//super();
		//this.createDate = CommonsUtils.getGMTDate();
	}

	public WorldTracerTransaction(TxType txType) {
		this();
		this.txType = txType;
	}

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "createdate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "duration")
	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	@Column(name = "error")
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "result")
	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	@Column(name = "txinputdata", length = 1020)
	public String getTxInputData() {
		return this.txInputData;
	}

	public void setTxInputData(String txData) {
		this.txInputData = txData;
	}

	@Column(name = "txoutputdata", length=1020)
	public String getTxOutputData() {
		return txOutputData;
	}

	public void setTxOutputData(String txResult) {
		this.txOutputData = txResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "txtype", nullable=false)
	public TxType getTxType() {
		return txType;
	}

	public void setTxType(TxType txType) {
		this.txType = txType;
	}

	@ManyToOne
	@JoinColumn(name = "incident_id")
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incidentId) {
		this.incident = incidentId;
	}

	@ManyToOne
	@JoinColumn(name = "ohd_id")
	public OHD getOhd() {
		return ohd;
	}

	public void setOhd(OHD ohd) {
		this.ohd = ohd;
	}
	
	@ManyToOne
	@JoinColumn(name = "agent_id")
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public void startTransaction() {
		this.start = System.currentTimeMillis();
	}
	
	public void endTransaction() {
		this.finish = System.currentTimeMillis();
		this.duration = finish - start;
	}

	public void successTransaction(String data) {
		this.result = Result.SUCCESS;
		if(data != null && data.length() > 1000) {
			data = data.substring(0, 1000);
		}
		this.setTxOutputData(data);
	}
	public void failTransaction(Throwable e) {
		String error = "";
		this.result = Result.FAILURE;
		if(e.getMessage() != null && e.getMessage().trim().length() > 0) {
			error = e.getClass().getName() + ": " + e.getMessage();
		}
		else {
			error = e.getClass().getName() + ": " + WorldTracerTransaction.UNKNOWN_ERROR;
		}
		if(e.getCause() != null) {
			error += "\nCause: " + e.getCause().getClass().getName() + " " + e.getCause().getMessage();
		}
		if(error.length() > MAX_ERROR_MSG ) {
			error = error.substring(0, MAX_ERROR_MSG);
		}
		else {
		this.setError(error);
		}
	}

}

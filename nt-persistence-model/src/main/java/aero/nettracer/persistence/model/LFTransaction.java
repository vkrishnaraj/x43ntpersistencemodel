package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;

@Entity
@Table(name = "lftransaction")
public class LFTransaction {

	private long id;
	private String amt;
	private String swchKey;
	private String authCode;
	private Timestamp transactionDate;
	private String stan;
	private String tranNum;
	private String rspCode;
	private long shippingId;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="amt")
	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	@Column(name="swch_key")
	public String getSwchKey() {
		return swchKey;
	}

	public void setSwchKey(String swchKey) {
		this.swchKey = swchKey;
	}

	@Column(name="auth_code")
	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	@Column(name="transaction_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Column(name="stan")
	public String getStan() {
		return stan;
	}

	public void setStan(String stan) {
		this.stan = stan;
	}

	@Column(name="transaction_num")
	public String getTranNum() {
		return tranNum;
	}

	public void setTranNum(String tranNum) {
		this.tranNum = tranNum;
	}

	@Column(name="rsp_code")
	public String getRspCode() {
		return rspCode;
	}

	public void setRspCode(String rspCode) {
		this.rspCode = rspCode;
	}

	@Column(name="shipping_id")
	public long getShippingId() {
		return shippingId;
	}

	public void setShippingId(long shippingId) {
		this.shippingId = shippingId;
	}

}

package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
public class LFTransaction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3504907139984489526L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="amt",length = 16)
	private String amt;
	
	@Column(name="swch_key",length = 32)
	private String swchKey;
	
	@Column(name="auth_code",length = 16)
	private String authCode;
	
	@Column(name="transaction_datetime")
	private Date transactionDate;
	
	@Column(name="stan",length = 16)
	private String stan;
	
	@Column(name="transaction_num",length = 16)
	private String tranNum;
	
	@Column(name="rsp_code",length = 16)
	private String rspCode;
	
	@Column(name="shipping_id")
	private long shippingId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	public String getSwchKey() {
		return swchKey;
	}
	public void setSwchKey(String swchKey) {
		this.swchKey = swchKey;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getStan() {
		return stan;
	}
	public void setStan(String stan) {
		this.stan = stan;
	}
	public String getTranNum() {
		return tranNum;
	}
	public void setTranNum(String tranNum) {
		this.tranNum = tranNum;
	}
	public String getAmt() {
		return amt;
	}
	public void setAmt(String amt) {
		this.amt = amt;
	}
	public String getRspCode() {
		return rspCode;
	}
	public void setRspCode(String rspCode) {
		this.rspCode = rspCode;
	}
	public long getShippingId() {
		return shippingId;
	}
	public void setShippingId(long shippingId) {
		this.shippingId = shippingId;
	}

	
}

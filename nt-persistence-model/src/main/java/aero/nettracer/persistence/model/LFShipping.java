package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
public class LFShipping implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7635407911286747875L;
	@Id
	@GeneratedValue
	private long id;
	
	@OneToOne
	@JoinColumn(name = "phone_id", nullable = true)
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private LFPhone shippingPhone;

	@OneToOne
	@JoinColumn(name = "shipping_addr_id", nullable = false)
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private LFAddress shippingAddress;

	@OneToOne
	@JoinColumn(name = "billing_addr_id", nullable = true)
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private LFAddress billingAddress;
	
	@Column(name="shipping_option",length = 32)
	private String shippingOption;
	
	@Column(name="shipping_priority")
	private int shippingPriority;
	
	@Column(name="shipping_name",length = 64)
	private String shippingName;
	
	@Column(name="total_payment",length = 16)
	private String totalPayment;
	
	@Column(name="declared_value")
	private double declaredValue;
	
	@Column(name="picked_datetime")
	private Date pickedTimestamp;
	
	@Column(name="instructions",length = 512)
	private String instructions;
	
	@OneToOne(targetEntity = aero.nettracer.persistence.model.LFTransaction.class, cascade = CascadeType.ALL)
	private LFTransaction transaction;
	
	public LFPhone getShippingPhone() {
		return shippingPhone;
	}
	
	public void setShippingPhone(LFPhone shippingPhone) {
		this.shippingPhone = shippingPhone;
	}

	public LFAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(LFAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public LFAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(LFAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getShippingOption() {
		return shippingOption;
	}

	public void setShippingOption(String shippingOption) {
		this.shippingOption = shippingOption;
	}
	
	public int getShippingPriority() {
		return shippingPriority;
	}

	public void setShippingPriority(int shippingPriority) {
		this.shippingPriority = shippingPriority;
	}

	public String getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(String totalPayment) {
		this.totalPayment = totalPayment;
	}

	public LFTransaction getTransaction() {
		return transaction;
	}

	public void setTransaction(LFTransaction transaction) {
		this.transaction = transaction;
	}

	public double getDeclaredValue() {
		return declaredValue;
	}

	public void setDeclaredValue(double declaredValue) {
		this.declaredValue = declaredValue;
	}

	public String getShippingName() {
		return shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	public Date getPickedTimestamp() {
		return pickedTimestamp;
	}

	public void setPickedTimestamp(Date pickedTimestamp) {
		this.pickedTimestamp = pickedTimestamp;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}



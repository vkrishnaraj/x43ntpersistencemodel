package aero.nettracer.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;

@Entity
@Table(name = "lfshipping")
public class LFShipping {

	private long id;
	private LFPhone shippingPhone;
	private LFAddress shippingAddress;
	private LFAddress billingAddress;
	private String shippingOption;
	private int shippingPriority;
	private String shippingName;
	private String totalPayment;
	private double declaredValue;
	private Timestamp pickedTimestamp;
	private String instructions;
	private LFTransaction transaction;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "phone_id")
	public LFPhone getShippingPhone() {
		return shippingPhone;
	}

	public void setShippingPhone(LFPhone shippingPhone) {
		this.shippingPhone = shippingPhone;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shipping_addr_id", nullable = false)
	public LFAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(LFAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "billing_addr_id")
	public LFAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(LFAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	@Column(name="shipping_option")
	public String getShippingOption() {
		return shippingOption;
	}

	public void setShippingOption(String shippingOption) {
		this.shippingOption = shippingOption;
	}

	@Column(name="shipping_priority")
	public int getShippingPriority() {
		return shippingPriority;
	}

	public void setShippingPriority(int shippingPriority) {
		this.shippingPriority = shippingPriority;
	}

	@Column(name="shipping_name")
	public String getShippingName() {
		return shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	@Column(name="total_payment")
	public String getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(String totalPayment) {
		this.totalPayment = totalPayment;
	}

	@Column(name="declared_value")
	public double getDeclaredValue() {
		return declaredValue;
	}

	public void setDeclaredValue(double declaredValue) {
		this.declaredValue = declaredValue;
	}

	@Column(name="picked_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getPickedTimestamp() {
		return pickedTimestamp;
	}

	public void setPickedTimestamp(Timestamp pickedTimestamp) {
		this.pickedTimestamp = pickedTimestamp;
	}

	@Column(name="instructions")
	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	@OneToOne(cascade = CascadeType.ALL)
	public LFTransaction getTransaction() {
		return transaction;
	}

	public void setTransaction(LFTransaction transaction) {
		this.transaction = transaction;
	}
}



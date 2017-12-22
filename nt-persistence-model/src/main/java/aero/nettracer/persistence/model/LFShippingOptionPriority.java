package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lf_shipping_option_priority")
public class LFShippingOptionPriority {

	private long id;
	private String shippingOption;
	private int shippingPriority;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

}

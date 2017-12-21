package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="lf_shipping_option_priority")
@Proxy(lazy = false)
public class LFShippingOptionPriority implements Serializable {

	private static final long serialVersionUID = 9021421764254196698L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="shipping_option",length = 32)
	private String shippingOption;
	
	@Column(name="shipping_priority")
	private int shippingPriority;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
}

package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
public class LFProperty implements Serializable {

	private static final long serialVersionUID = -6078105295569760266L;

	@Id
	@GeneratedValue
	private long id;

	@Column(name="keyStr",length = 50)
	private String keyStr;

	@Column(name="valueStr",length = 255)
	private String valueStr;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getKeyStr() {
		return keyStr;
	}
	
	public void setKeyStr(String keyStr) {
		this.keyStr = keyStr;
	}
	
	public String getValueStr() {
		return valueStr;
	}
	
	public void setValueStr(String valueStr) {
		this.valueStr = valueStr;
	}
}

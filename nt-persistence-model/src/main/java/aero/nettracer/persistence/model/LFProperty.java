package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lfproperty")
public class LFProperty {

	private long id;
	private String keyStr;
	private String valueStr;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="keyStr")
	public String getKeyStr() {
		return keyStr;
	}
	
	public void setKeyStr(String keyStr) {
		this.keyStr = keyStr;
	}

	@Column(name="valueStr")
	public String getValueStr() {
		return valueStr;
	}
	
	public void setValueStr(String valueStr) {
		this.valueStr = valueStr;
	}

}

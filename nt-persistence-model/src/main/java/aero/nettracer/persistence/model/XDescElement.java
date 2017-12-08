package aero.nettracer.persistence.model;

import java.io.Serializable;

import aero.nettracer.persistence.model.i8n.LocaleBasedObject;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "XDescElement")
public class XDescElement extends LocaleBasedObject implements Serializable {
	private int XDesc_ID;
	private String code;

	private String MSG_KEY = "DESCELEMENT_";

	@Id
	@GeneratedValue
	public int getXDesc_ID() {
		return XDesc_ID;
	}

	public void setXDesc_ID(int desc_ID) {
		XDesc_ID = desc_ID;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Transient
	public String getKey() {
		return MSG_KEY + code;
	}
}
package aero.nettracer.persistence.model.audit;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "audit_ohd_photo")
public class Audit_OHD_Photo implements Serializable {

	private int id;
	private int Photo_ID;
	private String thumbpath;
	private String picpath;
	private String OHD_ID;
	private Audit_OHD ohd;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "audit_ohd_id")
	public Audit_OHD getOhd() {
		return ohd;
	}

	public void setOhd(Audit_OHD ohd) {
		this.ohd = ohd;
	}
		
	
	public String getOHD_ID() {
		return OHD_ID;
	}

	public void setOHD_ID(String ohd_id) {
		OHD_ID = ohd_id;
	}

	public int getPhoto_ID() {
		return Photo_ID;
	}

	public void setPhoto_ID(int photo_ID) {
		Photo_ID = photo_ID;
	}

	public String getPicpath() {
		return picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}

	public String getThumbpath() {
		return thumbpath;
	}

	public void setThumbpath(String thumbpath) {
		this.thumbpath = thumbpath;
	}

	//NTFIXME
	/*public boolean equals(Object obj) {
		Audit_OHD_Photo aoi = (Audit_OHD_Photo) obj;
		boolean ret = true;

		if (AuditOHDUtils.notEqualObjects(aoi.getPicpath(), this.getPicpath())
				|| AuditOHDUtils.notEqualObjects(aoi.getThumbpath(), this.getThumbpath())) {
			ret = false;
		}
		return ret;
	}*/
}
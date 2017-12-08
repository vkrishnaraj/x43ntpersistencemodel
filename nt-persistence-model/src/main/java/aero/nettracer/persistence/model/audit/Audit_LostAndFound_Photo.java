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
@Table(name = "audit_lost_found_photo")
public class Audit_LostAndFound_Photo implements Serializable {

	private int id;
	private int Photo_ID;
	private String thumbpath;
	private String picpath;
	private String file_ref_number;
	private Audit_LostAndFoundIncident lostandfoundincident;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "audit_lost_found_id")
	public Audit_LostAndFoundIncident getLostandfoundincident() {
		return lostandfoundincident;
	}

	public void setLostandfoundincident(
			Audit_LostAndFoundIncident lostandfoundincident) {
		this.lostandfoundincident = lostandfoundincident;
	}

	
	public String getFile_ref_number() {
		return file_ref_number;
	}

	public void setFile_ref_number(String file_ref_number) {
		this.file_ref_number = file_ref_number;
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
		Audit_LostAndFound_Photo aoi = (Audit_LostAndFound_Photo) obj;
		boolean ret = true;

		if (AuditOHDUtils.notEqualObjects(aoi.getPicpath(), this.getPicpath())
				|| AuditOHDUtils.notEqualObjects(aoi.getThumbpath(), this.getThumbpath())) {
			ret = false;
		}
		return ret;
	}*/


}
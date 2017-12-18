package aero.nettracer.persistence.model;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ohd_photo")
public class OHD_Photo {

	private int id;
	private String thumbpath;
	private String picpath;
	private OHD ohd;
	private String fileName;

	@Id
	@GeneratedValue
	@Column(name = "photo_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "thumbpath")
	public String getThumbpath() {
		return thumbpath;
	}

	public void setThumbpath(String thumbpath) {
		this.thumbpath = thumbpath;
	}

	@Column(name = "picpath")
	public String getPicpath() {
		return picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}

	@ManyToOne
	@JoinColumn(name = "OHD_ID")
	public OHD getOhd() {
		return ohd;
	}

	public void setOhd(OHD ohd) {
		this.ohd = ohd;
	}

	@Transient
	public String getFileName() {
		String result = "";
		if (StringUtils.isBlank(fileName)) {
			result = picpath.substring(picpath.lastIndexOf('/')+1, picpath.length());
		} else {
			result = fileName;
		}
		return result;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
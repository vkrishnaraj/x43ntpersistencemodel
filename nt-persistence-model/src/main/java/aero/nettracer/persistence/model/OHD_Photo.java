package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "ohd_photo")
public class OHD_Photo implements Serializable {

	private int Photo_ID;
	private String thumbpath;
	private String picpath;

	private OHD ohd;


	private String fileName;

	@Transient
	public String getFileName() {
		String result = "";
		if (fileName == null || fileName.equals("")) {
			result = picpath.substring(picpath.lastIndexOf('/')+1, picpath.length());
		} else {
			result = fileName;
		}

		return result;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@ManyToOne
	@JoinColumn(name = "OHD_ID")
	public OHD getOhd() {
		return ohd;
	}

	public void setOhd(OHD ohd) {
		this.ohd = ohd;
	}

	@Id
	@GeneratedValue
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
}
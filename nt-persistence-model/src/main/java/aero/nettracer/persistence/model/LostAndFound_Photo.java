package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "lost_found_photo")
public class LostAndFound_Photo implements Serializable {
	private int Photo_ID;
	private String thumbpath;
	private String picpath;

	private String fileName;
	
	private String fileReferenceNumber;

	public String getFileReferenceNumber() {
		return fileReferenceNumber;
	}

	public void setFileReferenceNumber(String fileReferenceNumber) {
		this.fileReferenceNumber = fileReferenceNumber;
	}

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
	
	private LostAndFoundIncident lostandfoundincident;

	@ManyToOne
	@JoinColumn(name = "file_ref_number")
	public LostAndFoundIncident getLostandfoundincident() {
		return lostandfoundincident;
	}

	public void setLostandfoundincident(LostAndFoundIncident lostandfoundincident) {
		this.lostandfoundincident = lostandfoundincident;
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
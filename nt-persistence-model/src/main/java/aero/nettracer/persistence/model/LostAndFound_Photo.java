package aero.nettracer.persistence.model;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lost_found_photo")
public class LostAndFound_Photo {

	private int id;
	private String thumbpath;
	private String picpath;
	private String fileReferenceNumber;
	private String fileName;
	private LostAndFoundIncident lostandfoundincident;

	@Id
	@GeneratedValue
	@Column(name = "photo_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "picpath")
	public String getPicpath() {
		return picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}

	@Column(name = "thumbpath")
	public String getThumbpath() {
		return thumbpath;
	}

	public void setThumbpath(String thumbpath) {
		this.thumbpath = thumbpath;
	}

	@Column(name = "filereferencenumber")
	public String getFileReferenceNumber() {
		return fileReferenceNumber;
	}

	public void setFileReferenceNumber(String fileReferenceNumber) {
		this.fileReferenceNumber = fileReferenceNumber;
	}

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

	@ManyToOne
	@JoinColumn(name = "file_ref_number")
	public LostAndFoundIncident getLostandfoundincident() {
		return lostandfoundincident;
	}

	public void setLostandfoundincident(LostAndFoundIncident lostandfoundincident) {
		this.lostandfoundincident = lostandfoundincident;
	}

}
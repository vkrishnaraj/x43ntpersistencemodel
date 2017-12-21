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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Entity
@Table(name="item_photo")
public class Item_Photo {
	
	private int id;
	private String thumbpath;
	private String picpath;
	private Item item;
	private String fileName;

	@Id
	@GeneratedValue
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
	@JoinColumn(name = "item_id", nullable = false)
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Transient
	public String getFileName() {
		String result = null;
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

	@Transient
	public String getUrlEncodedPicpath() throws UnsupportedEncodingException {
		return URLEncoder.encode(picpath, "UTF-8");
	}

	@Transient
	public String getUrlEncodedThumbpath() throws UnsupportedEncodingException {
		return URLEncoder.encode(thumbpath, "UTF-8");
	}

}
/*
 * Created on Jul 13, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ListIterator;

import com.cci.utils.parser.ElementNode;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name="Item_Photo")
public class Item_Photo implements Serializable {
	
	private static final long serialVersionUID = 490403433222640320L;
	
	private int Photo_ID;
	private String thumbpath;
	private String picpath;
	private Item item;
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

	@Transient
	public String toXML() {
		StringBuffer sb = new StringBuffer();

		sb.append("<photo>");
		sb.append("<Photo_ID>" + Photo_ID + "</Photo_ID>");
		sb.append("<thumbpath>" + thumbpath + "</thumbpath>");
		sb.append("<picpath>" + picpath + "</picpath>");
		sb.append("</photo>");

		return sb.toString();
	}

	//NTFIXME
	@Transient
	public static Item_Photo XMLtoObject(ElementNode root) {
		Item_Photo obj = new Item_Photo();

		ElementNode child = null, grandchild = null, ggrandchild = null, gggrandchild = null;

		for (ListIterator i = root.get_children().listIterator(); i.hasNext();) {
			child = (ElementNode) i.next();
			if (child.getType().equals("Photo_ID")) {
				obj.setPhoto_ID(parseInt(child.getTextContents()));
			} else if (child.getType().equals("thumbpath")) {
				obj.setThumbpath(child.getTextContents());
			} else if (child.getType().equals("picpath")) {
				obj.setPicpath(child.getTextContents());
			}

		}

		return obj;
	}

	@Id
	@GeneratedValue
	public int getPhoto_ID() {
		return Photo_ID;
	}

	public void setPhoto_ID(int photo_ID) {
		Photo_ID = photo_ID;
	}

	@Fetch(FetchMode.SELECT)
	@ManyToOne
	@JoinColumn(name = "item_ID", nullable = false)
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getPicpath() {
		return picpath;
	}

	@Transient
	public String getUrlEncodedPicpath() {
		try {
			return URLEncoder.encode(picpath, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "Encoded Filename Error";
		}
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}

	public String getThumbpath() {
		return thumbpath;
	}

	@Transient
	public String getUrlEncodedThumbpath() {
		try {
			return URLEncoder.encode(thumbpath, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "Encoded Filename Error";
		}
	}

	public void setThumbpath(String thumbpath) {
		this.thumbpath = thumbpath;
	}

	public static int parseInt(String s) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return 0;
		}
	}

}
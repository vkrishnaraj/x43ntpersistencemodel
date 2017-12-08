/*
 * Created on Jul 13, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model.audit;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name="audit_Item_Photo")
public class Audit_Item_Photo implements Serializable {

	private static final long serialVersionUID = -6130267206870988696L;
	
	private int audit_photo_id;
	
	private int photo_ID;
	private String thumbpath;
	private String picpath;
	
	private Audit_Item audit_item;

	@Id
	@GeneratedValue
	public int getAudit_photo_id() {
		return audit_photo_id;
	}

	public void setAudit_photo_id(int audit_photo_id) {
		this.audit_photo_id = audit_photo_id;
	}

	@Fetch(FetchMode.SELECT)
	@ManyToOne
	@JoinColumn(name = "audit_item_id")
	public Audit_Item getAudit_item() {
		return audit_item;
	}

	public void setAudit_item(Audit_Item audit_item) {
		this.audit_item = audit_item;
	}
	
	
	public int getPhoto_ID() {
		return photo_ID;
	}

	
	public void setPhoto_ID(int photo_ID) {
		this.photo_ID = photo_ID;
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
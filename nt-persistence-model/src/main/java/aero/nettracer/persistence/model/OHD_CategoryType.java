package aero.nettracer.persistence.model;

import java.io.Serializable;

import aero.nettracer.persistence.model.i8n.LocaleBasedObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "OHD_CategoryType")
public class OHD_CategoryType extends LocaleBasedObject implements Serializable {
	private int OHD_CategoryType_ID;
	private String categoryKey;
	private String wtCategory;
	private String MSG_KEY = "CATEGORY_";	


	@Column(name = "categorytype")
	public String getCategoryKey() {
		return categoryKey;
	}

	public void setCategoryKey(String categoryKey) {
		this.categoryKey = categoryKey;
	}

	@Id
	@GeneratedValue
	public int getOHD_CategoryType_ID() {
		return OHD_CategoryType_ID;
	}

	public void setOHD_CategoryType_ID(int categoryType_ID) {
		OHD_CategoryType_ID = categoryType_ID;
	}

	@Column(name = "wt_category")
	public String getWtCategory() {
		return wtCategory;
	}

	public void setWtCategory(String wtCategory) {
		this.wtCategory = wtCategory;
	}

	@Transient
	public String getKey() {
		return MSG_KEY + getCategoryKey();
	}

	
}
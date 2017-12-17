package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ohd_categorytype")
public class OHD_CategoryType {

	private int id;
	private String categoryKey;
	private String wtCategory;
	private String MSG_KEY = "CATEGORY_";

	@Id
	@GeneratedValue
	@Column(name = "ohd_categorytype_id")
	public int getId() {
		return id;
	}

	public void setId(int categoryType_ID) {
		id = categoryType_ID;
	}

	@Column(name = "categorytype")
	public String getCategoryKey() {
		return categoryKey;
	}

	public void setCategoryKey(String categoryKey) {
		this.categoryKey = categoryKey;
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
package aero.nettracer.persistence.model.salvage;

import aero.nettracer.commons.utils.GenericDateUtils;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "salvage")
public class Salvage {
	
	private int id;
	private String companyCodeId;
	private String pickedUpByFName;
	private String pickedUpByLName;
	private Timestamp salvageDate;
	private int status;
	private Set<SalvageBox> salvageBoxes;
	private Set<SalvageOHDReference> ohdReferences;
	private SalvageRemark remark;


	@Id
	@GeneratedValue
	@Column(name="salvage_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="companycode_id")
	public String getCompanyCodeId() {
		return companyCodeId;
	}

	public void setCompanyCodeId(String companyCodeId) {
		this.companyCodeId = companyCodeId;
	}

	@Column(name="pickedupby_fname")
	public String getPickedUpByFName() {
		return pickedUpByFName;
	}

	public void setPickedUpByFName(String pickedUpByFName) {
		this.pickedUpByFName = pickedUpByFName;
	}

	@Column(name="pickedupby_lname")
	public String getPickedUpByLName() {
		return pickedUpByLName;
	}

	public void setPickedUpByLName(String pickedUpByLName) {
		this.pickedUpByLName = pickedUpByLName;
	}

	@Column(name="salvage_date")
	public Timestamp getSalvageDate() {
		return salvageDate;
	}

	public void setSalvageDate(Timestamp salvageDate) {
		this.salvageDate = salvageDate;
	}

	@Column(name="status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@OneToMany(mappedBy = "salvage", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy(value = "display_id")
	public Set<SalvageBox> getSalvageBoxes() {
		return salvageBoxes;
	}

	public void setSalvageBoxes(Set<SalvageBox> salvageBoxes) {
		this.salvageBoxes = salvageBoxes;
	}

	@OneToMany(mappedBy = "salvage", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy(value = "ohd_id")
	public Set<SalvageOHDReference> getOhdReferences() {
		return ohdReferences;
	}

	public void setOhdReferences(Set<SalvageOHDReference> ohdReferences) {
		this.ohdReferences = ohdReferences;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="remark_id")
	public SalvageRemark getRemark() {
		return remark;
	}

	public void setRemark(SalvageRemark remark) {
		this.remark = remark;
	}
	
	@Transient
	public String getDisSalvageDate(String dateFormat) {
		return GenericDateUtils.formatDate(getSalvageDate(), dateFormat, "", null);
	}
	
}
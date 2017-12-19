package aero.nettracer.persistence.model.documents.templates;

import aero.nettracer.persistence.util.TemplateType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name="template")
public class Template {
	
	private long id;
	private String name;
	private String description;
	private boolean active;
	private Timestamp createDate;
	private Timestamp lastUpdated;
	private String data;
	private int typeAvailableFor;
	private String marginTop;
	private String marginBottom;
	private String marginLeft;
	private String marginRight;
	private Set<TemplateTypeMapping> types;
	private Set<TemplateVar> variables;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "active")
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Column(name = "createDate", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "lastupdated", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Column(name = "data")
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Column(name = "typeavailablefor")
	public int getTypeAvailableFor() {
		return typeAvailableFor;
	}

	public void setTypeAvailableFor(int typeAvailableFor) {
		this.typeAvailableFor = typeAvailableFor;
	}

	@Column(name = "margintop")
	public String getMarginTop() {
		return marginTop;
	}

	public void setMarginTop(String marginTop) {
		this.marginTop = marginTop;
	}

	@Column(name = "marginbottom")
	public String getMarginBottom() {
		return marginBottom;
	}

	public void setMarginBottom(String marginBottom) {
		this.marginBottom = marginBottom;
	}

	@Column(name = "marginleft")
	public String getMarginLeft() {
		return marginLeft;
	}

	public void setMarginLeft(String marginLeft) {
		this.marginLeft = marginLeft;
	}

	@Column(name = "marginright")
	public String getMarginRight() {
		return marginRight;
	}

	public void setMarginRight(String marginRight) {
		this.marginRight = marginRight;
	}

	@ManyToMany
	@JoinTable(name = "template_type_mapping",
			joinColumns = {@JoinColumn(name = "templateId")},
			inverseJoinColumns = {@JoinColumn(name = "templateTypeId")})
	public Set<TemplateTypeMapping> getTypes() {
		return types;
	}

	public void setTypes(Set<TemplateTypeMapping> types) {
		this.types = types;
	}

	@ManyToMany
	@JoinTable(name = "template_var_mapping",
			joinColumns = {@JoinColumn(name = "templateId")},
			inverseJoinColumns = {@JoinColumn(name = "templateVarId")})
	public Set<TemplateVar> getVariables() {
		return variables;
	}

	public void setVariables(Set<TemplateVar> variables) {
		this.variables = variables;
	}

	public boolean isValid() {
		for (TemplateTypeMapping mapping: types) {
			if (TemplateType.INVALID == TemplateType.fromOrdinal(mapping.getOrdinal())) {
				return false;
			}
		}
		return true;
	}

}

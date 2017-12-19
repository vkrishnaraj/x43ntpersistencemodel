package aero.nettracer.persistence.model.documents.templates;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="template_var")
public class TemplateVar {

	private long id;
	private String displayTag;
	private String associatedClass;
	private boolean containsHtml;
	private Set<Template> templates;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "displaytag", nullable = false)
	public String getDisplayTag() {
		return displayTag;
	}

	public void setDisplayTag(String displayTag) {
		this.displayTag = displayTag;
	}

	@Column(name = "associatedclass", nullable = false)
	public String getAssociatedClass() {
		return associatedClass;
	}

	public void setAssociatedClass(String associatedClass) {
		this.associatedClass = associatedClass;
	}

	@Column(name = "containshtml")
	public boolean getContainsHtml() {
		return containsHtml;
	}

	public void setContainsHtml(boolean containsHtml) {
		this.containsHtml = containsHtml;
	}

	@ManyToMany(mappedBy = "variables")
	public Set<Template> getTemplates() {
		return templates;
	}

	public void setTemplates(Set<Template> templates) {
		this.templates = templates;
	}

	@Override
	public boolean equals(Object o) {
		if (o.getClass() != this.getClass()) return false;
		TemplateVar that = (TemplateVar) o;
		return this.associatedClass.equals(that.associatedClass) && this.displayTag.equals(that.displayTag);
	}

}

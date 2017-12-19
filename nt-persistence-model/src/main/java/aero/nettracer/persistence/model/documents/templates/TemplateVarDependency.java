package aero.nettracer.persistence.model.documents.templates;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "template_var_dependency")
public class TemplateVarDependency {

	private long id;
	private String associatedClass;
	private String dependentClass;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "associatedclass", nullable = false)
	public String getAssociatedClass() {
		return associatedClass;
	}

	public void setAssociatedClass(String associatedClass) {
		this.associatedClass = associatedClass;
	}

	@Column(name = "dependentclass", nullable = false)
	public String getDependentClass() {
		return dependentClass;
	}

	public void setDependentClass(String dependentClass) {
		this.dependentClass = dependentClass;
	}
	
	public boolean satisfied(List<String> varClassNames) {
		return varClassNames.contains(dependentClass);
	}

}

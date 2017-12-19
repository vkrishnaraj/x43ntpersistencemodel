package aero.nettracer.persistence.model.bagbuzz;

import aero.nettracer.persistence.model.Category;
import aero.nettracer.persistence.model.Status;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;

@Entity
@Table(name="bagbuzz")
public class BagBuzz {

	private long id;
	private Timestamp created_timestamp;
	private String data;
	private String description;
	private Status status;
	private Category category;

	@Id
	@GeneratedValue
	@Column(name = "bagbuzz_id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		id = id;
	}

	@Temporal(value = TemporalType.TIMESTAMP)
	public Timestamp getCreated_timestamp() {
		return created_timestamp;
	}

	public void setCreated_timestamp(Timestamp createdTimestamp) {
		created_timestamp = createdTimestamp;
	}

	@Column(name = "data")
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	@JoinColumn(name = "status_id", nullable = false)
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}

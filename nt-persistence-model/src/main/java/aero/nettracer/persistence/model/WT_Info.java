package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;

@Entity
@Table(name = "wt_info")
public class WT_Info {

	private int id;
	private String requestContext;
	private String responseContext;
	private Timestamp wt_info_date;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "requestcontext")
	public String getRequestContext() {
		return requestContext;
	}

	public void setRequestContext(String requestContext) {
		this.requestContext = requestContext;
	}

	@Column(name = "responsecontext")
	public String getResponseContext() {
		return responseContext;
	}

	public void setResponseContext(String responseContext) {
		this.responseContext = responseContext;
	}

	@Column(name = "wt_info_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getWt_info_date() {
		return wt_info_date;
	}

	public void setWt_info_date(Timestamp wt_info_date) {
		this.wt_info_date = wt_info_date;
	}

}

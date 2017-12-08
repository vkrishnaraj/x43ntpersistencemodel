package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Proxy;


@Entity
@Table(name = "wt_info")
public class WT_Info implements Serializable {
	private int id;
	private String requestContext;
	private String responseContext;
	private Date wt_info_date;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRequestContext() {
		return requestContext;
	}

	public void setRequestContext(String requestContext) {
		this.requestContext = requestContext;
	}

	public String getResponseContext() {
		return responseContext;
	}

	public void setResponseContext(String responseContext) {
		this.responseContext = responseContext;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getWt_info_date() {
		return wt_info_date;
	}

	public void setWt_info_date(Date wt_info_date) {
		this.wt_info_date = wt_info_date;
	}
}

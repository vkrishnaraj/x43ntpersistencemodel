/*
 * Created on Nov 14, 2012
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model.fraudservice;

import aero.nettracer.persistence.model.Agent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

@Entity
public class Attachment {

	private int id;
	private FsClaim claim;
	private Agent agent;
	private Date createDate;
	private int attachment_id;
	private String path;
	private String description;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	public FsClaim getClaim() {
		return claim;
	}

	public void setClaim(FsClaim claim) {
		this.claim = claim;
	}

	@ManyToOne
	@JoinColumn(name = "agent_id", nullable = false)
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@Column(name = "createdate")
	@Temporal(TemporalType.DATE)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "attachment_id")
	public int getAttachment_id() {
		return attachment_id;
	}

	public void setAttachment_id(int attachment_id) {
		this.attachment_id = attachment_id;
	}

	@Column(name = "path")
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Transient
	public String getUrlEncodedFilepath() {
		try {
			return URLEncoder.encode(path, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "Encoded Filename Error";
		}
	}
}

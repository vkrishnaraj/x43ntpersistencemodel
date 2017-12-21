/*
 * Created on Jul 13, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="lffile")
public class LFFile implements Serializable {
	
	private static final long serialVersionUID = 490403433222640320L;

	private long id;
	private String filepath;
	private String fileName;
	private String uploaderName;
	private String lostId;
	private String foundId;
	private LFFound found;
	private LFLost lost;

	private String companyCode;

	public String getFileName() {
		String result = "";
		if (fileName == null || fileName.equals("")) {
			result = filepath.substring(filepath.lastIndexOf('/')+1, filepath.length());
		} else {
			result = fileName;
		}
		
		return result;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFilepath() {
		return filepath;
	}


	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getUploaderName() {
		return uploaderName;
	}

	public void setUploaderName(String uploaderName) {
		this.uploaderName = uploaderName;
	}

	@ManyToOne
	@JoinColumn(name = "lostId", nullable = true, insertable = false, updatable = false)
	@Fetch(FetchMode.SELECT)
	public LFLost getLost() {
		return lost;
	}

	public void setLost(LFLost lost) {
		this.lost = lost;
	}

	@ManyToOne
	@JoinColumn(name = "foundId", nullable = true, insertable = false, updatable = false)
	@Fetch(FetchMode.SELECT)
	public LFFound getFound() {
		return found;
	}

	public void setFound(LFFound found) {
		this.found = found;
	}

	public String getLostId() {
		return lostId;
	}

	public void setLostId(String lostId) {
		this.lostId = lostId;
	}

	public String getFoundId() {
		return foundId;
	}

	public void setFoundId(String foundId) {
		this.foundId = foundId;
	}

	@Transient
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
}
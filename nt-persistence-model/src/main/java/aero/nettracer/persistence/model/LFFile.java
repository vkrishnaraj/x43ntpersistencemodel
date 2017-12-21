package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="lffile")
public class LFFile {

	private long id;
	private String filepath;
	private String fileName;
	private String uploaderName;
	private LFLost lost;
	private LFFound found;
	private String companyCode;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "filepath")
	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	@Column(name = "filename")
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

	@Column(name = "uploadername")
	public String getUploaderName() {
		return uploaderName;
	}

	public void setUploaderName(String uploaderName) {
		this.uploaderName = uploaderName;
	}

	@ManyToOne
	@JoinColumn(name = "lostId", insertable = false, updatable = false)
	public LFLost getLost() {
		return lost;
	}

	public void setLost(LFLost lost) {
		this.lost = lost;
	}

	@ManyToOne
	@JoinColumn(name = "foundId", insertable = false, updatable = false)
	public LFFound getFound() {
		return found;
	}

	public void setFound(LFFound found) {
		this.found = found;
	}

	@Transient
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

}
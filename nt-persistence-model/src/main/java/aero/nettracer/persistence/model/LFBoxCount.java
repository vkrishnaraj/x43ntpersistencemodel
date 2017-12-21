package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;


@Entity
@Proxy(lazy = false)
public class LFBoxCount implements Serializable {
	
	private static final long serialVersionUID = 5806495189281178779L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="src_stn_code",length = 8)
	private String sourceStationCode;
	
	@JoinColumn(name = "box_count", nullable = false)
	private int boxCount;
	
	@ManyToOne
	@JoinColumn(name = "container_id", nullable = true)
	@Fetch(FetchMode.SELECT)
	private LFBoxContainer container;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public int getBoxCount() {
		return boxCount;
	}
	
	public void setBoxCount(int boxCount) {
		this.boxCount=boxCount;
	}
	
	public LFBoxContainer getContainer() {
		return container;
	}
	
	public void setContainer (LFBoxContainer container) {
		this.container=container;
	}

	public String getSourceStationCode() {
		return sourceStationCode;
	}

	public void setSourceStationCode(String sourceStationCode) {
		this.sourceStationCode = sourceStationCode;
	}

	
}

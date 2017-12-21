package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lfboxcount")
public class LFBoxCount {

	private long id;
	private String sourceStationCode;
	private int boxCount;
	private LFBoxContainer container;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	@Column(name="src_stn_code")
	public String getSourceStationCode() {
		return sourceStationCode;
	}

	public void setSourceStationCode(String sourceStationCode) {
		this.sourceStationCode = sourceStationCode;
	}

	@JoinColumn(name = "box_count", nullable = false)
	public int getBoxCount() {
		return boxCount;
	}
	
	public void setBoxCount(int boxCount) {
		this.boxCount=boxCount;
	}

	@ManyToOne
	@JoinColumn(name = "container_id")
	public LFBoxContainer getContainer() {
		return container;
	}
	
	public void setContainer (LFBoxContainer container) {
		this.container=container;
	}

}

package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "lfboxcontainer")
public class LFBoxContainer {

	private long id;
	private Date dateCount;
	
	@OneToMany(mappedBy = "container")
	@OrderBy(value = "id")
	private List<LFBoxCount> boxCounts=new ArrayList<LFBoxCount>();

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="date_count")
	public Date getDateCount() {
		return dateCount;
	}
	
	public void setDateCount(Date dateCount) {
		this.dateCount = dateCount;
	}

	public List<LFBoxCount> getBoxCounts() {
		 Collections.sort(boxCounts, new Comparator<LFBoxCount>(){
			 
	            public int compare(LFBoxCount o1, LFBoxCount o2) {
	                LFBoxCount p1 = (LFBoxCount) o1;
	                LFBoxCount p2 = (LFBoxCount) o2;
	               return p1.getSourceStationCode().compareToIgnoreCase(p2.getSourceStationCode());
	            }

				 
		 });
		 return boxCounts;
	}
	
	public void setBoxCount(List<LFBoxCount> boxCounts) {
		this.boxCounts=boxCounts;
	}

}

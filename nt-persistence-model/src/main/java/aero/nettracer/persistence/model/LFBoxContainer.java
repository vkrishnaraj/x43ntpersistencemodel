package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
public class LFBoxContainer implements Serializable {
	
	private static final long serialVersionUID = 5806495189281178779L;

	@Id
	@GeneratedValue
	private long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_count")
	private Date dateCount;
	
	@OneToMany(mappedBy = "container", fetch = FetchType.EAGER)
	@OrderBy(clause = "id")
	@Fetch(FetchMode.SELECT)
	private List<LFBoxCount> boxCounts=new ArrayList<LFBoxCount>();
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getDateCount() {
		return dateCount;
	}
	
	public void setDateCount(Date dateCount) {
		this.dateCount = dateCount;
	}

	//TODO this should be refactored NT-6064
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

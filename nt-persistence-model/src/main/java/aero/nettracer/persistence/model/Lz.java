package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "lz")
public class Lz implements Serializable {

	private static final long serialVersionUID = 5515908229381309490L;
	
	@Id @GeneratedValue
	@Column(name = "lz_id")
	private int lz_ID;
	
	private boolean is_default;
	private double percent_load;
	
	@ManyToOne(targetEntity = Station.class)
	@JoinColumn(name="station_id")
	@Fetch(FetchMode.SELECT)
	private Station station;

	@Transient
	private boolean isUsed;

	@Column(nullable = false, length = 20)
	private String companyCode_ID;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private LzType lz_type;

	public int getLz_ID() {
		return lz_ID;
	}

	public void setLz_ID(int lz_ID) {
		this.lz_ID = lz_ID;
	}

	public double getPercent_load() {
		return percent_load;
	}

	public void setPercent_load(double percent) {
		this.percent_load = percent;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public String getCompanyCode_ID() {
		return companyCode_ID;
	}

	public void setCompanyCode_ID(String companyCode_ID) {
		this.companyCode_ID = companyCode_ID;
	}

	public boolean isIs_default() {
		return is_default;
	}

	public void setIs_default(boolean is_default) {
		this.is_default = is_default;
	}
	
	public void setIsUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}
	
	public boolean isUsed() {
		return isUsed;
	}
	
	public LzType getLz_type() {
		return lz_type;
	}

	public void setLz_type(LzType lz_type) {
		this.lz_type = lz_type;
	}

	@Override
	public boolean equals (Object a) {
		
		if (!(a instanceof Lz))
			return false;
				
		Lz b = (Lz) a;
		if (this.lz_ID == b.getLz_ID())
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.lz_ID;
	}
}
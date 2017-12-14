package aero.nettracer.persistence.model;

import aero.nettracer.persistence.util.LzType;
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

@Entity
@Table(name = "lz")
public class Lz {

	private int id;
	private Station station;
	private boolean is_default;
	private LzType lz_type;
	private double percent_load;
	private String companyCode_ID;
	private boolean isUsed;

	@Id
	@GeneratedValue
	@Column(name = "lz_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="station_id")
	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	@Column(name = "is_default")
	public boolean isIs_default() {
		return is_default;
	}

	public void setIs_default(boolean is_default) {
		this.is_default = is_default;
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	public LzType getLz_type() {
		return lz_type;
	}

	public void setLz_type(LzType lz_type) {
		this.lz_type = lz_type;
	}

	@Column(name = "percent_load")
	public double getPercent_load() {
		return percent_load;
	}

	public void setPercent_load(double percent) {
		this.percent_load = percent;
	}

	@Column(name = "companycode_id", nullable = false)
	public String getCompanyCode_ID() {
		return companyCode_ID;
	}

	public void setCompanyCode_ID(String companyCode_ID) {
		this.companyCode_ID = companyCode_ID;
	}

	@Transient
	public boolean isUsed() {
		return isUsed;
	}

	public void setIsUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public boolean equals (Object a) {
		
		if (!(a instanceof Lz))
			return false;
				
		Lz b = (Lz) a;
		if (this.id == b.getId())
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.id;
	}
}
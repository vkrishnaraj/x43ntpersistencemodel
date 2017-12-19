package aero.nettracer.persistence.model.fraudservice;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FsGeodata {

	public enum Type {
		STREET, CITY, ZIP, UNKNOWN;
	}
	
	private long id;
	private FsAddress fsAddress;
	
	private double latitude;
	private double longitude;
	private Type geoType;
	private String geoSource;
	private Timestamp geoDate;
	private String normAddress;
	private String normAddressSource;
	private boolean success;
	private List<String> errors;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@OneToOne
	@JoinColumn(name = "fsaddress_id")
	public FsAddress getFsAddress() {
		return fsAddress;
	}

	public void setFsAddress(FsAddress fsAddress) {
		this.fsAddress = fsAddress;
	}

	@Column(name = "latitude")
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@Column(name = "longitude")
	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Enumerated(EnumType.STRING)
	public Type getGeoType() {
		return geoType;
	}

	public void setGeoType(Type geoType) {
		this.geoType = geoType;
	}

	@Column(name = "geosource")
	public String getGeoSource() {
		return geoSource;
	}

	public void setGeoSource(String geoSource) {
		this.geoSource = geoSource;
	}

	@Column(name = "geodate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getGeoDate() {
		return geoDate;
	}

	public void setGeoDate(Timestamp geoDate) {
		this.geoDate = geoDate;
	}

	@Column(name = "normaddress")
	public String getNormAddress() {
		return normAddress;
	}

	public void setNormAddress(String normAddress) {
		this.normAddress = normAddress;
	}

	@Column(name = "normaddresssource")
	public String getNormAddressSource() {
		return normAddressSource;
	}

	public void setNormAddressSource(String normAddressSource) {
		this.normAddressSource = normAddressSource;
	}

	@Transient
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Column(name = "errors")
	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public String toString(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("### FsGeodata ###");
		list.add("latitude         : " + latitude);
		list.add("longitude        : " + longitude);
		list.add("geoSource        : " + geoSource);
		list.add("geoDate          : " + geoDate);
		list.add("geoType          : " + geoType);
		list.add("normAddress      : " + normAddress);
		list.add("normAddressSource: " + normAddressSource);
		return StringUtils.join(list, '\n');
	}
	
}

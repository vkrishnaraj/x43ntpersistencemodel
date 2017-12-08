package aero.nettracer.persistence.model.fraudservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.Proxy;

@Entity
public class FsGeodata {

	public enum Type {
		STREET, CITY, ZIP, UNKNOWN;
	}
	
	@Id
	@GeneratedValue
	private long id;
	
	@OneToOne(targetEntity = FsAddress.class)
	private FsAddress fsAddress;
	
	private double latitude;
	private double longitude;
	private String geoSource;
	private Date geoDate;
	private String normAddress;
	private String normAddressSource;
	
	@Enumerated(EnumType.STRING) 
	private Type geoType;
	
	
	@Transient
	private boolean success;
	@Transient
	private List<String> errors;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public String getGeoSource() {
		return geoSource;
	}
	public void setGeoSource(String geoSource) {
		this.geoSource = geoSource;
	}
	public Date getGeoDate() {
		return geoDate;
	}
	public void setGeoDate(Date geoDate) {
		this.geoDate = geoDate;
	}
	public String getNormAddress() {
		return normAddress;
	}
	public void setNormAddress(String normAddress) {
		this.normAddress = normAddress;
	}
	public String getNormAddressSource() {
		return normAddressSource;
	}
	public void setNormAddressSource(String normAddressSource) {
		this.normAddressSource = normAddressSource;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	public Type getGeoType() {
		return geoType;
	}
	public void setGeoType(Type geoType) {
		this.geoType = geoType;
	}
	public FsAddress getFsAddress() {
		return fsAddress;
	}
	public void setFsAddress(FsAddress fsAddress) {
		this.fsAddress = fsAddress;
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

package aero.nettracer.persistence.util;

import aero.nettracer.commons.utils.CommonsConstants;

public enum ReportMethod {
	
	DEFAULT(CommonsConstants.INCIDENT_REPORT_METHOD_DEFAULT, "DEFAULT"),
	PHONE(CommonsConstants.INCIDENT_REPORT_METHOD_PHONE, "PHONE"),
	UNKNOWN(CommonsConstants.INCIDENT_REPORT_METHOD_UNKNOWN, "UNKNOWN");
	
	private int key;
	private String description;
	
	ReportMethod(int key, String description){
		this.key = key;
		this.description = description;
	}
	
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static String getDescriptionByKey(int key){
		for(ReportMethod ts: ReportMethod.values()){
			if(ts.getKey() == key){
				return ts.getDescription();
			}
		}
		return null;
	}
	
	public static int getKeyByDescription(String desc){
		for(ReportMethod ts: ReportMethod.values()){
			if(ts.getDescription().equalsIgnoreCase(desc)){
				return ts.getKey();
			}
		}
		return ReportMethod.UNKNOWN.getKey();
	}
	
}

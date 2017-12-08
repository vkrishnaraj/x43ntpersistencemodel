package aero.nettracer.persistence.util;

import aero.nettracer.commons.utils.CommonsConstants;

public enum TracingStatus {			
	DEFAULT(CommonsConstants.INCIDENT_TRACING_STATUS_DEFAULT, "DEFAULT"),
	TRACING(CommonsConstants.INCIDENT_TRACING_STATUS_TRACING, "TRACING"),
	TRACING_FINALIZED(CommonsConstants.INCIDENT_TRACING_STATUS_FINAL, "TRACING FINALIZED");
	
	private int key;
	private String description;
	
	TracingStatus(int key, String description){
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
		for(TracingStatus ts: TracingStatus.values()){
			if(ts.getKey() == key){
				return ts.getDescription();
			}
		}
		return null;
	}
}

package aero.nettracer.persistence.util;

import aero.nettracer.commons.utils.CommonsConstants;

public enum RemarkType {

	REGULAR(CommonsConstants.REMARK_REGULAR, "REGULAR"),
	CLOSING(CommonsConstants.REMARK_CLOSING, "CLOSING"),
	WORLDTRACER_REQUEST(CommonsConstants.REMARK_WORLDTRACER_REQUEST, "WORLDTRACER REQUEST"),
	WORLDTRACER_RESPONSE(CommonsConstants.REMARK_WORLDTRACER_RESPONSE,"WORLDTRACER RESPONSE"),
	CALL(CommonsConstants.REMARK_CALL,"CALL"),
	UNKNOWN(CommonsConstants.REMARK_UNKNOWN, "UNKNOWN"),
	BDO(CommonsConstants.REMARK_BDO_DELIVERY_COMMENT,"BDO"),
	EXPENSE_PAYOUT(CommonsConstants.REMARK_EXPENSE_PAYOUT,"EXPENSE_PAYOUT"),
	CALLBACK(CommonsConstants.REMARK_CALLBACK,"CALLBACK");
	
	
	private int key;
	private String description;
	
	RemarkType(int key, String description){
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
		for(RemarkType ts: RemarkType.values()){
			if(ts.getKey() == key){
				return ts.getDescription();
			}
		}
		return null;
	}
	
	public static int getKeyByDescription(String desc){
		for(RemarkType ts: RemarkType.values()){
			if(ts.getDescription().equalsIgnoreCase(desc)){
				return ts.getKey();
			}
		}
		return RemarkType.UNKNOWN.getKey();
	}
}

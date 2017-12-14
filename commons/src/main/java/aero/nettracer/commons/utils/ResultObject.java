package aero.nettracer.commons.utils;

public class ResultObject<T> {
	private T resultObject;
	private String errorKey;

	public T getResultObject() {
		return resultObject;
	}

	public void setResultObject(T resultObject) {
		this.resultObject = resultObject;
	}

	public String getErrorKey() {
		return errorKey;
	}

	public void setErrorKey(String errorKey) {
		this.errorKey = errorKey;
	}
	
	public boolean isSuccess() {
		return errorKey == null;
	}

	public boolean isPresent() {
		return resultObject != null;
	}

}

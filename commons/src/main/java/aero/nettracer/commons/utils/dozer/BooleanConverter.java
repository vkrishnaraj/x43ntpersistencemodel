package aero.nettracer.commons.utils.dozer;



public class BooleanConverter implements org.dozer.CustomConverter{

	@Override
	public Object convert(Object existingDestinationFieldValue,
			Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {

		if(sourceClass == null){
			return null;
		}
		
		if(Boolean.class.equals(sourceClass)){
			return booleanToInteger((Boolean)sourceFieldValue);
		}
		
		if(Integer.class.equals(sourceClass)){
			return integerToBoolean((Integer)sourceFieldValue);
		}
			
		return null;
	}

	
	private Integer booleanToInteger(Boolean b){
		if(b == null){
			return 0;//if null default 'false'
		} else if (b){
			return 1;
		} else {
			return 0;
		}
		
	}
	
	private Boolean integerToBoolean(Integer i){
		if(i == null){
			return false;//if null default 'false'
		} else if (i > 0){
			return true;
		} else {
			return false;
		}
	}
	
}

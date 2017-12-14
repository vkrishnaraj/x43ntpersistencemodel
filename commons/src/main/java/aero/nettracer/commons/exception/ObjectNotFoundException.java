package aero.nettracer.commons.exception;

public class ObjectNotFoundException extends Exception{
	private static final long serialVersionUID = 3534591936230554080L;

	private static final String ERROR_MESSAGE = "Object %s not found for the following parameter: %s";
	
	public ObjectNotFoundException(){
		super();
	}

	public ObjectNotFoundException(String message){
		super(message);
	}

	public ObjectNotFoundException(String message, Throwable t){
		super(message, t);
	}
	
	public ObjectNotFoundException(Throwable t) {
		super(t);
	}
	
	public ObjectNotFoundException(Class<?> argClass, String id){
		super(String.format(ERROR_MESSAGE, argClass.getCanonicalName(),id));
	}
	
}

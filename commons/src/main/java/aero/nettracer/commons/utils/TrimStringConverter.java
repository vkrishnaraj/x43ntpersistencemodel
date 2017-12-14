package aero.nettracer.commons.utils;

import org.apache.commons.beanutils.Converter;

public class TrimStringConverter implements Converter {

	@Override
	public Object convert(Class type, Object value) {
		if (value == null){
			return null;
		}else
			return value.toString().trim();
	}

}

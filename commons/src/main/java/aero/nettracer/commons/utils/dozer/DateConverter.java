package aero.nettracer.commons.utils.dozer;

import java.util.Date;
import java.util.GregorianCalendar;
import org.dozer.CustomConverter;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * @author Loupas
 *
 * CustomDateConverter to be used by dozer mapping to convert Date objects to XMLGregorianCalendar objects and vice versa.
 * Returns null if source is null or if unable to convert.
 * 
 * Example mapping:
 * 
 *   <configuration>
 *   <custom-converters>
 *     <converter type="aero.nettracer.ws.util.DozerCustomDateConverter" >
 *       <class-a>java.util.Date</class-a>
 *       <class-b>javax.xml.datatype.XMLGregorianCalendar</class-b>
 *     </converter>
 *    
 *   </custom-converters>     
 * </configuration>
 * 
 * Can be expanded upon to handle Calendar if needed.
 */
public class DateConverter implements org.dozer.CustomConverter{

	@Override
	public Object convert(Object existingDestinationFieldValue,
			Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {

		if(sourceFieldValue == null){
			return null;
		}

		try{
			if(sourceFieldValue instanceof Date){
				return convertDateToXMLGregorianCalendar((Date)sourceFieldValue);
			}
			if(sourceFieldValue instanceof XMLGregorianCalendar){
				return ((XMLGregorianCalendar)sourceFieldValue).toGregorianCalendar().getTime();
			}
		} catch (Exception e){
			return null;
		}

		return null;
	}

	
	protected XMLGregorianCalendar convertDateToXMLGregorianCalendar (Date sourceDate){
		if (sourceDate != null) {
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(sourceDate);
			XMLGregorianCalendar xmlDate = null;
			try {
				xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
				return xmlDate;
			} catch (DatatypeConfigurationException e) {
				e.printStackTrace();
				return null;
			}
	
		}else{
			return null;
		}
	}
	
}

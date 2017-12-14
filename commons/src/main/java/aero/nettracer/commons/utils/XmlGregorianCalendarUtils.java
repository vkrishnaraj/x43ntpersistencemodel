package aero.nettracer.commons.utils;

import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

public class XmlGregorianCalendarUtils {
	public static boolean isSameDate(Date src, XMLGregorianCalendar dest) {
		return (src.getDate() == dest.getDay())
				&& (src.getMonth() + 1 == dest.getMonth())
				&& (src.getYear() + 1900 == dest.getYear());
	}
	
	public static boolean isSameTime(Date src, XMLGregorianCalendar dest){
		return (src.getHours() == dest.getHour())
				&& (src.getMinutes() == dest.getMinute())
				&& (src.getSeconds() == dest.getSecond());
	}
	
	public static boolean isSameDateTime(Date src, XMLGregorianCalendar dest){
		return isSameDate(src,dest) && isSameTime(src,dest);
	}
	
	public static boolean isSameMS(Date src, XMLGregorianCalendar dest){
		return (src.getTime() == dest.toGregorianCalendar().getTime().getTime());
	}
}

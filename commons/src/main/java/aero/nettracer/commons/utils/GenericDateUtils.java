package aero.nettracer.commons.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import aero.nettracer.commons.constant.GenericConstants;

public class GenericDateUtils {
	private static Logger logger = Logger.getLogger(GenericDateUtils.class);
	
	public static ArrayList<Integer> ccMonths = null;
	private static ArrayList<Integer> ccYears = null;
	/**
	 * if timezone is not null, date in is in gmt date, need to be converted to
	 * current timezone
	 * 
	 * @param str
	 * @param instyle
	 * @param outstyle
	 * @param inloc
	 * @param tz
	 * @return
	 */
	public static String formatDate(String str, String instyle, String outstyle, String inloc,
			TimeZone tz) {
		try {
			Locale locale = null;
			Locale defaultLocale = Locale.US;
			if (inloc == null) locale = Locale.US;
			else locale = new Locale(inloc);
			if (instyle == null || instyle.equals("")) instyle = "MM/dd/yyyy";

			if (str == null) return null;

			String s = null;
			SimpleDateFormat df = new SimpleDateFormat(instyle, defaultLocale);
			Date mydate = df.parse(str);

			long difference = (tz != null ? tz.getOffset(mydate.getTime()) : 0);

			if (outstyle == null || outstyle.equals("")) {
				DateFormat sdf = new SimpleDateFormat(GenericConstants.DB_DATEFORMAT, locale);
				if (tz != null) {
					// gmt + difference will be the new date
					Date newdate = new Date(mydate.getTime() + difference);
					s = sdf.format(newdate);
				} else {
					s = sdf.format(mydate);
				}
				return s;
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat(outstyle, locale);
				if (tz != null) {
					// gmt + difference will be the new date
					Date newdate = new Date(mydate.getTime() + difference);
					s = sdf.format(newdate);
				} else {
					s = sdf.format(mydate);
				}
				return s;
			}
		} catch (Exception e) {
		}
		return str;
	}

	/**
	 * if timezone is not null, date in is in gmt date, need to be converted to
	 * current timezone
	 * 
	 * @param indate
	 * @param outstyle
	 * @param inloc
	 * @param tz
	 * @return
	 */
	public static String formatDate(Date indate, String outstyle, String inloc, TimeZone tz) {
		try {
			Locale locale = null;
			if (inloc == null) locale = Locale.US;
			else locale = new Locale(inloc);

			if (indate == null) return null;

			long difference = (tz != null ? tz.getOffset(indate.getTime()) : 0);

			String s = null;

			if (outstyle == null || outstyle.trim().equals("")) {
				DateFormat sdf = new SimpleDateFormat(GenericConstants.DISPLAY_DATEFORMAT, locale);

				if (tz != null) {

					// gmt + difference will be the new date
					Date newdate = new Date(indate.getTime() + difference);
					s = sdf.format(newdate);
				} else {
					s = sdf.format(indate);
				}
				return s;
			} else {
				DateFormat sdf = null;
				try {
					sdf = new SimpleDateFormat(outstyle, locale);
				} catch (Exception e) {
					sdf = new SimpleDateFormat(GenericConstants.DISPLAY_DATEFORMAT, locale);
				}
				if (tz != null) {

					// gmt + difference will be the new date
					Date newdate = new Date(indate.getTime() + difference);
					s = sdf.format(newdate);
				} else {
					s = sdf.format(indate);
				}

				return s;
			}
		} catch (Exception e) {
			logger.error("bad format style: " + outstyle);
		}
		return indate.toString();
	}

	public static Date convertToDate(String str, String instyle, String inloc) {
		return convertToDate(str, instyle, inloc, null);
	}
	
	public static Date convertToDate(String str, String instyle, String inloc, TimeZone startTZ) {
		try {
			Locale locale = null;
			if (inloc == null) locale = Locale.US;
			else locale = new Locale(inloc);
			if (instyle == null || instyle.equals("")) instyle = GenericConstants.DB_DATEFORMAT;

			if (str == null || str.length() <= 0) return null;
			SimpleDateFormat df = new SimpleDateFormat(instyle, locale);
			if(startTZ != null) {
				df.setTimeZone(startTZ);
			}
			Date mydate = df.parse(str);
			Calendar c = Calendar.getInstance();
			c.setTime(mydate);
			if (c.get(Calendar.YEAR) < 1900) return null;

			return mydate;
		} catch (Exception e) {
			logger.warn("user entered bad date format: " + instyle);
		}
		return null;
	}
	
	public static Date convertToDatetime(String str, String instyle) {
		Date mydate = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(instyle);
			mydate = sdf.parse(str);
		} catch (ParseException e) {
			logger.warn("user entered bad time format on UI - expected time format: " + instyle + "; entered: " + str);
		}
		return mydate;
	}

	
	public static Date convertToGMTDate(Date now) {
		try {
	
			DateFormat df = new SimpleDateFormat(GenericConstants.DB_DATETIMEFORMAT);
			df.setTimeZone(TimeZone.getTimeZone("GMT"));

			//System.out.println("now: " + df.format(now));
			Date newdate = convertToDate(df.format(now), GenericConstants.DB_DATETIMEFORMAT, null);

			return newdate;
		} catch (Exception e) {
			return new Date();
		}
	}

	public static Date convertToGMTDate(String str, String instyle) {
		return convertToGMTDate(str, instyle, null);
	}
	
	public static Date convertToGMTDate(String str, String instyle, TimeZone startTZ) {
		Date now = convertToDate(str, instyle, null, startTZ);
		return convertToGMTDate(now);
	}
	
	public static Date convertSystemCalendarToGMTDate(Calendar date) {
		return convertSystemDateToGMTDate(date.getTime());
	}
	
	@SuppressWarnings("deprecation")
	public static Date convertSystemDateToGMTDate(Date date) {
		return new Date(date.getTime() + date.getTimezoneOffset()*1000*60);
	}
	
	@SuppressWarnings("deprecation")
	public static Date convertGMTDateToLocalTime(Date date) {
		return new Date(date.getTime() - date.getTimezoneOffset()*1000*60);
	}
	
	public static Date floorDate(Date x) {
		GregorianCalendar a = new GregorianCalendar();
		a.setTime(x);
		a.set(Calendar.SECOND, 0);
		a.set(Calendar.MILLISECOND, 0);
		a.set(Calendar.MINUTE, 0);
		a.set(Calendar.HOUR_OF_DAY, 0);
		return a.getTime();
	}
	
	public static Date addDays(Date x, int y) {
		GregorianCalendar a = new GregorianCalendar();
		a.setTime(x);
		a.add(Calendar.DAY_OF_MONTH, y);
		return a.getTime();
	}
	
	public static Date addOneDay(Date x) {
		return addDays(x, 1);
	}
	
	public static boolean isSameDate(Calendar a, Calendar b) {
		return a.get(Calendar.YEAR) == b.get(Calendar.YEAR) 
			&& a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DATE) == b.get(Calendar.DATE);
	}
	
	public static boolean isDateRangeOutsideLimit(Date startDate, Date endDate, long MAX_NUMBER_OF_DAYS) {
		boolean result = false;
		
		@SuppressWarnings("deprecation")
		long myEndL = endDate.getTime() + endDate.getTimezoneOffset();
		@SuppressWarnings("deprecation")
		long myStartL = startDate.getTime() + startDate.getTimezoneOffset();
		long MILLISECS_PER_DAY = 24 * 60 * 60 * 1000;
		long dateRangeInDays = (myEndL - myStartL) / MILLISECS_PER_DAY; 
		if (dateRangeInDays > MAX_NUMBER_OF_DAYS) {
			result = true;
		}		
		return result;
	}

	public static long getNumberOfDays(Date startDate, Date endDate) {

		@SuppressWarnings("deprecation")
		long startTime = startDate.getTime() + startDate.getTimezoneOffset();

		@SuppressWarnings("deprecation")
		long endTime = endDate.getTime() + endDate.getTimezoneOffset();

		long millisecondsPerDay = 24 * 60 * 60 * 1000;
		long dateRangeInDays = (endTime - startTime) / millisecondsPerDay;

		return dateRangeInDays;
	}

	// use negative for days
	public static void adjustDays(Date d, int days)
	{
	    d.setTime( d.getTime() + days*1000*60*60*24 );
	}
	
	public static ArrayList<Integer> getCcMonths() {
		if (ccMonths == null) {
			ccMonths = new ArrayList<Integer>();
			for (int i = 1; i <= 12; i++) {
				ccMonths.add(i);
			}
		}
		return ccMonths;
	}
	
	/**
	 * 
	 * @return - an ArrayList of years starting with the current year
	 * and including the next 20 years.
	 */
	public static ArrayList<Integer> getCcYears() {
		if (ccYears == null) {
			ccYears = new ArrayList<Integer>();
			int year = Calendar.getInstance().get(Calendar.YEAR) - 2003;
			for (int i = 0; i < 20; i++) {
				ccYears.add(year);
				year++;
			}
		}
		return ccYears;
	}
	
	public static Date combineDateTime(Date date, Date time)
	{
	  	Calendar calendarA = Calendar.getInstance();
	  	calendarA.setTime(date);
	  	Calendar calendarB = Calendar.getInstance();
	  	calendarB.setTime(time);
	  
	  	calendarA.set(Calendar.HOUR_OF_DAY, calendarB.get(Calendar.HOUR_OF_DAY));
	  	calendarA.set(Calendar.MINUTE, calendarB.get(Calendar.MINUTE));
	 	calendarA.set(Calendar.SECOND, calendarB.get(Calendar.SECOND));
	 	calendarA.set(Calendar.MILLISECOND, calendarB.get(Calendar.MILLISECOND));
	 
	 	Date result = calendarA.getTime();
	 	return result;
	}
	
	/**
	 * 
	 * @param inTime Calendar object
	 * @param simpleDateFormat Ex: MM/dd/yyyy hh:mm a z - Invalid date format will throw runtime exception
	 * @param timeZone - should be in the format of US/Mountain - refer Timezone.getAvailableIds() for valid values.
	 * @return Date string in the required format
	 */
	public static String getDisplayDate(Calendar inTime, String simpleDateFormat, String timeZone) {
		if(inTime == null || StringUtils.isBlank(simpleDateFormat) || StringUtils.isBlank(timeZone)) {
			throw new IllegalArgumentException("Invalid date arguments passed");
		}
		String displayDate = "";
		SimpleDateFormat dateFormat = null;
		try {
			dateFormat = new SimpleDateFormat(simpleDateFormat);
			TimeZone toTimeZone = TimeZone.getTimeZone(timeZone);
			dateFormat.setTimeZone(toTimeZone);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException("Invalid time date format ", e);
		}
		displayDate = dateFormat.format(inTime.getTime());
		if(displayDate.contains("GMT") && !(timeZone.contains("GMT"))) {
			logger.info("Invalid timezone passed." + timeZone +". The date is converted to GMT");
		}
		return displayDate;
	}

	public static Date getDateInPast(int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -days);
		return calendar.getTime();
	}

}

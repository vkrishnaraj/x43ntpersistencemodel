package aero.nettracer.commons.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.TimeZone;

import aero.nettracer.commons.constant.GenericConstants;

public class CommonsUtils {

    public static String getNTFileServer() {
        String ntFileServer = System.getProperty(GenericConstants.NETTRACER_FILE_SERVER);
        if (ntFileServer != null) {
            return ntFileServer;
        }
        return "";
    }

    public static double convertToDouble(String s) {
        try {
            return Double.parseDouble(s);
        } catch (Exception e) {
            return 0;
        }
    }

    public static String removeSpaces(String s) {
        StringBuffer sb = new StringBuffer(20);
        StringTokenizer st = new StringTokenizer(s, " ");
        while (st.hasMoreTokens()) {
            sb.append(st.nextToken().trim());
        }
        return sb.toString();
    }

    public static String format(double number, String f) {
        String ret = "";
        DecimalFormat format = (DecimalFormat) NumberFormat.getInstance();
        if (f.equals("%")) {
            format.applyPattern("#0.00");
            format.setMinimumFractionDigits(2);
            ret = "" + format.format(number);
        } else if (f.equals("$")) {
            format.applyPattern("#,##0.00");
            format.setMinimumFractionDigits(2);
            ret = "" + format.format(number);
        }

        return ret;
    }

    public static Date getGMTDate() {
        try {
            Date now = new Date(); // current system date
            DateFormat df = new SimpleDateFormat(GenericConstants.DB_DATETIMEFORMAT);
            df.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date newdate = GenericDateUtils.convertToDate(df.format(now), GenericConstants.DB_DATETIMEFORMAT, null);
            return newdate;
        } catch (Exception e) {
            return new Date();
        }
    }

    public static Timestamp getGMTTimestamp() {
        try {
            Date now = new Date(); // current system date
            DateFormat df = new SimpleDateFormat(GenericConstants.DB_DATETIMEFORMAT);
            df.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date newdate = GenericDateUtils.convertToDate(df.format(now), GenericConstants.DB_DATETIMEFORMAT, null);
            return new Timestamp(newdate.getTime());
        } catch (Exception e) {
            return new Timestamp((new Date()).getTime());
        }
    }

    public static boolean isBitSet(int value, int index) {
        int mask = 1<<index;
        return (mask&value) > 0;
    }
}

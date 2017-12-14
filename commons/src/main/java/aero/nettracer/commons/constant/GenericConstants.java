package aero.nettracer.commons.constant;

public class GenericConstants {
	
	public final static String DB_DATETIMEFORMAT = "yyyy-MM-dd HH:mm:ss";
	public final static String DB_DATEFORMAT = "yyyy-MM-dd";
	public final static String DB_TIMEFORMAT = "HH:mm:ss";
	public final static String DB_DATETIMEFORMAT2 = "yyyy-MM-dd HH:mm";
	
	public final static String DB_DATETIMEFORMAT_MSSQL = "MM/dd/yyyy hh:mm:ss a";
	public final static String DB_DATEFORMAT_MSSQL = "MM/dd/yyyy";
	public final static String DB_TIMEFORMAT_MSSQL = "hh:mm:ss a";
	
	public final static String DISPLAY_DATETIMEFORMAT = "MM/dd/yyyy hh:mm:ss a";
	public final static String DISPLAY_DATEFORMAT = "MM/dd/yyyy";
	public final static String DISPLAY_TIMEFORMAT = "hh:mm:ss a";
	public final static String DISPLAY_TIMEFORMAT_B = "hh:mm a";
	public final static String DISPLAY_TIMEFORMAT_C = "HH:mm";
	
	//TODO we may want to give more though on statuses in commons.
	//The reason is that anytime a project specific status is updated, we are releasing a
	//new version of commons.  The reason we are putting it here is because our current
	//status table is global.  Maybe each project should have it's own status table.
	//Also we may want to consider using enums instead of int.
	public final static String LFC_COLOR_DOESNOTAPPLY = "XX";
	public final static int LF_STATUS_ALL = -1;
	public final static int LF_STATUS_OPEN = 600;
	public final static int LF_STATUS_CLOSED = 601;
	public final static int LF_DISPOSITION_TO_BE_DELIVERED = 602;
	public final static int LF_DISPOSITION_DELIVERED = 603;
	public final static int LF_DISPOSITION_PICKED_UP = 604;
	public final static int LF_DISPOSITION_SALVAGED = 605;
	public final static int LF_DISPOSITION_OTHER = 606;
	public final static int LF_TRACING_OPEN = 607;
	public final static int LF_TRACING_CONFIRMED = 608;
	public final static int LF_TRACING_REJECTED = 609;
	public final static int LF_TRACING_CLOSED = 610;
	public final static int LF_STAGED_FOR_SHIPPING = 613;
	public final static int LF_DISPOSITION_SENT_TO_LZ = 614;
	public final static int LF_DISPOSITION_REMOVED = 615;
	public final static int LF_DISPOSITION_FORWARD_TO_LFC = 616;
	public static final int LF_ITEM_RETURNABLE_NO = 0;
	public static final int LF_ITEM_RETURNABLE_YES = 1;
	public static final int LF_ITEM_RETURNABLE_ALL = -1;

	public final static int LF_TYPE_LOST = 1;
	public final static int LF_TYPE_FOUND = 2;

	public static final String NETTRACER_FILE_SERVER = "nettracer.file.server";

	public static final String IATA_JETBLUE = "B6";
}

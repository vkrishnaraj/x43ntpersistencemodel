package aero.nettracer.commons.utils;

import java.text.DecimalFormat;

public class CommonsConstants {

    public final static String DEFAULT_LOCALE = "en";

    public final static String ENUM_VOUCHER = "VOUCH";
    public final static String ENUM_DRAFT = "DRAFT";
    public final static String ENUM_MILE = "MILE";
    public final static String ENUM_PCARD = "PCARD";
    public final static String ENUM_ACH = "ACH";
    public final static String ENUM_OTHER = "OTHER";
    public final static String ENUM_INC = "INC";
    public final static String ENUM_CCREF = "CCREF";
    public final static String ENUM_INVOICE = "INVOICE";
    public final static String ENUM_PSO = "PSO";
    public final static String ENUM_BDO = "Delivery";
    public final static DecimalFormat DECIMALFORMAT = new DecimalFormat("#0.00");
    public final static String UTB_CHECK = "UTB";

    public static final int DAMAGE_MINOR = 0;
    public static final int DAMAGE_MAJOR = 1;
    public static final int DAMAGE_COMPLETE = 2;

    public final static int MANUFACTURER_OTHER_ID = 71;

    public static final int NO_DEFAULT_STATION = 0;
    public static final int DEFAULT_ORIGIN = 1;
    public static final int DEFAULT_DESTINATION = 2;
    public static final int DEFAULT_CREATED = 3;

    public final static int STATUS_SUSPECTED_FRAUD = 1506;
    public final static int STATUS_KNOWN_FRAUD = 1507;
    public final static int STATUS_FRAUD_UNKNOWN = 0;
    public final static String STATUS_FRAUD_UNKNOWN_DESCRIPTION = "Fraud Status Unknown";

    public final static String DEFAULT_AGENT_TIMEZONE = "14";
    public final static int INCIDENT_LEN = 13;

    public final static int REMARK_UNKNOWN = -11;
    public final static int REMARK_REGULAR = 1;
    public final static int REMARK_CLOSING = 2;
    public final static int REMARK_WORLDTRACER_REQUEST = 3;
    public final static int REMARK_WORLDTRACER_RESPONSE = 4;
    public final static int REMARK_CALL = 5;
    public final static int REMARK_EXPENSE_PAYOUT = 6;
    public final static int REMARK_BDO_DELIVERY_COMMENT = 7;
    public final static int REMARK_CALLBACK = 8;

    public static final int INCIDENT_TRACING_STATUS_DEFAULT = 0;
    public static final int INCIDENT_TRACING_STATUS_TRACING = 1;
    public static final int INCIDENT_TRACING_STATUS_FINAL = 2;

    public static final int INCIDENT_REPORT_METHOD_DEFAULT = 0;
    public static final int INCIDENT_REPORT_METHOD_PHONE = 7;
    public static final int INCIDENT_REPORT_METHOD_UNKNOWN = -1;
}

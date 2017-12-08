package aero.nettracer.persistence.util;

/**
 * Created by vkrishnaraj on 11/28/17.
 */
public enum TxType {

    CREATE_AHL("wt.create_ahl"),
    CLOSE_AHL("wt.close_ahl"),
    SUSPEND_AHL("wt.suspend_ahl"),
    REINSTATE_AHL("wt.reinstate_ahl"),
    CREATE_OHD("wt.create_ohd"),
    CLOSE_OHD("wt.close_ohd"),
    SUSPEND_OHD("wt.suspend_ohd"),
    REINSTATE_OHD("wt.reinstate_ohd"),
    FWD_GENERAL("wt.fwd_gen"),
    FWD_OHD("wt.fwd_ohd"),
    REQUEST_OHD("wt.request_ohd"),
    AMEND_AHL("wt.amend_ahl"),
    AMEND_OHD("wt.amend_ohd"),
    IMPORT_AHL("wt.import_ahl"),
    IMPORT_OHD("wt.import_ohd"),
    CREATE_BDO("wt.create_bdo"),
    ERASE_AF("wt.erase_actionfile"),
    REQUEST_QOH("wt.request.qoh"),
    AF_COUNT("wt.af.count"),
    AF_SUMMARY("wt.af.summary"),
    AF_DETAIL("wt.af.detail"),
    SEND_PXF("wt.send.pxf"),
    CREATE_QOH("wt.qoh");

    private String messageKey;

    private TxType(String messageKey) {
        this.messageKey = messageKey;
    }
    public String getMessageKey() {
        return messageKey;
    }

    public String getValue() {
        return this.name();
    }
}

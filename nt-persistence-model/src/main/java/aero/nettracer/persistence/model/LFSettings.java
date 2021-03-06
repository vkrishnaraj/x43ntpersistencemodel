package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lfsettings")
public class LFSettings {

    private int id;
    private String companyCode;
    private String email_Path;
    private int email_Notice_1;
    private int email_Notice_2;
    private int email_Notice_3;
    private int email_Notice_4;
    private int email_Notice_5;
    private int shippingSurcharge;
    private boolean sendDataplanEmails;
    private int salvage_Low;
    private int salvage_High;
    private int shippingSurchargeType;
    private int auto_close_lr;
    private int auto_close_matched_lr_buffer;
    private int email_payment_remind;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "companycode")
    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    @Column(name = "email_path")
    public String getEmail_Path() {
        return email_Path;
    }

    public void setEmail_Path(String email_Path) {
        this.email_Path = email_Path;
    }

    @Column(name = "email_notice_1")
    public int getEmail_Notice_1() {
        return email_Notice_1;
    }

    public void setEmail_Notice_1(int email_Notice_1) {
        this.email_Notice_1 = email_Notice_1;
    }

    @Column(name = "email_notice_2")
    public int getEmail_Notice_2() {
        return email_Notice_2;
    }

    public void setEmail_Notice_2(int email_Notice_2) {
        this.email_Notice_2 = email_Notice_2;
    }

    @Column(name = "email_notice_3")
    public int getEmail_Notice_3() {
        return email_Notice_3;
    }

    public void setEmail_Notice_3(int email_Notice_3) {
        this.email_Notice_3 = email_Notice_3;
    }

    @Column(name = "email_notice_4")
    public int getEmail_Notice_4() {
        return email_Notice_4;
    }

    public void setEmail_Notice_4(int email_Notice_4) {
        this.email_Notice_4 = email_Notice_4;
    }

    @Column(name = "email_notice_5")
    public int getEmail_Notice_5() {
        return email_Notice_5;
    }

    public void setEmail_Notice_5(int email_Notice_5) {
        this.email_Notice_5 = email_Notice_5;
    }

    @Column(name = "shippingsurcharge")
    public int getShippingSurcharge() {
        return shippingSurcharge;
    }

    public void setShippingSurcharge(int shippingSurcharge) {
        this.shippingSurcharge = shippingSurcharge;
    }

    @Column(name = "senddataplanemails")
    public boolean isSendDataplanEmails() {
        return sendDataplanEmails;
    }

    public void setSendDataplanEmails(boolean sendDataplanEmails) {
        this.sendDataplanEmails = sendDataplanEmails;
    }

    @Column(name = "salvage_low")
    public int getSalvage_Low() {
        return salvage_Low;
    }

    public void setSalvage_Low(int salvage_Low) {
        this.salvage_Low = salvage_Low;
    }

    @Column(name = "salvage_high")
    public int getSalvage_High() {
        return salvage_High;
    }

    public void setSalvage_High(int salvage_High) {
        this.salvage_High = salvage_High;
    }

    @Column(name = "shippingsurchargetype")
    public int getShippingSurchargeType() {
        return shippingSurchargeType;
    }

    public void setShippingSurchargeType(int shippingSurchargeType) {
        this.shippingSurchargeType = shippingSurchargeType;
    }

    @Column(name = "auto_close_lr")
    public int getAuto_close_lr() {
        return auto_close_lr;
    }

    public void setAuto_close_lr(int auto_close_lr) {
        this.auto_close_lr = auto_close_lr;
    }

    @Column(name = "auto_close_matched_lr_buffer")
    public int getAuto_close_matched_lr_buffer() {
        return auto_close_matched_lr_buffer;
    }

    public void setAuto_close_matched_lr_buffer(int auto_close_matched_lr_buffer) {
        this.auto_close_matched_lr_buffer = auto_close_matched_lr_buffer;
    }

    @Column(name = "email_payment_remind")
    public int getEmail_payment_remind() {
        return email_payment_remind;
    }

    public void setEmail_payment_remind(int email_payment_remind) {
        this.email_payment_remind = email_payment_remind;
    }

}

package aero.nettracer.persistence.model.audit;

import java.io.Serializable;
import java.util.Date;

import aero.nettracer.commons.utils.CommonsConstants;
import aero.nettracer.commons.utils.CommonsUtils;
import aero.nettracer.commons.utils.GenericDateUtils;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "audit_articles")
public class Audit_Articles implements Serializable {
	private int audit_articles_id;
	private int Articles_ID;
	private String article;
	private String description;
	private Date enteredDate;
	private Date purchasedate;
	private double cost;
	private String currency_ID;

	private String _DATEFORMAT;
	
	private Audit_Incident audit_incident;

	private int statusId;

	@Id
	@GeneratedValue
	public int getAudit_articles_id() {
		return audit_articles_id;
	}

	public void setAudit_articles_id(int audit_articles_id) {
		this.audit_articles_id = audit_articles_id;
	}

	@ManyToOne
	@JoinColumn(name = "audit_incident_id")
	public Audit_Incident getAudit_incident() {
		return audit_incident;
	}

	public void setAudit_incident(Audit_Incident audit_incident) {
		this.audit_incident = audit_incident;
	}
	
	
	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public int getArticles_ID() {
		return Articles_ID;
	}

	public void setArticles_ID(int articles_ID) {
		Articles_ID = articles_ID;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Transient
	public String getDiscost() {
		return CommonsConstants.DECIMALFORMAT.format(getCost());
	}

	public void setDiscost(String s) {
		setCost(CommonsUtils.convertToDouble(s));
	}

	public String getCurrency_ID() {
		return currency_ID;
	}

	public void setCurrency_ID(String currency_ID) {
		this.currency_ID = currency_ID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.DATE)
	public Date getEnteredDate() {
		return enteredDate;
	}

	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}

	@Temporal(TemporalType.DATE)
	public Date getPurchasedate() {
		return purchasedate;
	}

	@Transient
	public String getDisEnteredDate() {
		return GenericDateUtils.formatDate(getEnteredDate(), get_DATEFORMAT(), null, null);
	}
	
	public void setDisEnteredDate(String disEnteredDate) {
		setPurchasedate(GenericDateUtils.convertToDate(disEnteredDate, get_DATEFORMAT(), null));
	}

	@Transient
	public String getDispurchasedate() {
		return GenericDateUtils.formatDate(purchasedate, get_DATEFORMAT(), null, null);
	}

	public void setDispurchasedate(String s) {
		setPurchasedate(GenericDateUtils.convertToDate(s, get_DATEFORMAT(), null));
	}

	public void setPurchasedate(Date purchasedate) {
		this.purchasedate = purchasedate;
	}

	@Transient
	public String get_DATEFORMAT() {
		return _DATEFORMAT;
	}

	public void set_DATEFORMAT(String _dateformat) {

		_DATEFORMAT = _dateformat;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	//NTFIXME
	/*@Transient
	public String getDisStatusId() {
		return TracerUtils.getText(Status.getKey(getStatusId()), (String) null);
	}*/

}
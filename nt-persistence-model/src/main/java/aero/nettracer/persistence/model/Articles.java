package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.ListIterator;

import aero.nettracer.commons.constant.GenericConstants;
import aero.nettracer.commons.utils.GenericDateUtils;
import com.cci.utils.parser.ElementNode;
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
@Table(name = "Articles")
public class Articles implements Serializable {
	private int articles_ID;
	private String article;
	private String description = "";
	private Date enteredDate;
	private Date purchasedate;
	private double cost;
	private String currency_ID;
	private Incident incident;

	private String _DATEFORMAT;
	private String locale;

	private int statusId;

	@Transient
	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	@ManyToOne
	@JoinColumn(name = "incident_ID")
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	@Id
	@GeneratedValue
	public int getArticles_ID() {
		return articles_ID;
	}

	public void setArticles_ID(int articles_ID) {
		this.articles_ID = articles_ID;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	/*@Transient
	public String getDiscost() {
		return TracingConstants.DECIMALFORMAT.format(getCost());
	}

	public void setDiscost(String s) {
		setCost(TracerUtils.convertToDouble(s));
	}*/

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

	public String toXML() {
		StringBuffer sb = new StringBuffer();

		sb.append("<ma>");
		sb.append("<Articles_ID>" + getArticles_ID() + "</Articles_ID>");
		sb.append("<article>" + getArticle() + "</article>");
		sb.append("<description>" + getDescription() + "</description>");
		sb.append("<purchasedate>" + (getPurchasedate() != null ? getPurchasedate().toString() : "")
				+ "</purchasedate>");
		sb.append("<cost>" + getCost() + "</cost>");
		sb.append("<currency_ID>" + getCurrency_ID() + "</currency_ID>");
		sb.append("<locale>" + getLocale() + "</locale>");
		sb.append("</ma>");

		return sb.toString();
	}

	public static Articles XMLtoObject(ElementNode root) {
		Articles obj = new Articles();

		ElementNode child = null, grandchild = null, ggrandchild = null, gggrandchild = null;


		boolean break_main = false;

		for (ListIterator i = root.get_children().listIterator(); i.hasNext();) {
			child = (ElementNode) i.next();
			if (child.getType().equals("Articles_ID")) {
				obj.setArticles_ID(parseInt(child.getTextContents()));
			} else if (child.getType().equals("article")) {
				obj.setArticle(child.getTextContents());
			} else if (child.getType().equals("description")) {
				obj.setDescription(child.getTextContents());
			} else if (child.getType().equals("purchasedate")) {
				obj.setPurchasedate(GenericDateUtils.convertToDate(child.getTextContents(),
						GenericConstants.DB_DATEFORMAT, null));
			} else if (child.getType().equals("cost")) {
				obj.setCost(parseDouble(child.getTextContents()));
			} else if (child.getType().equals("currency_ID")) {
				obj.setCurrency_ID(child.getTextContents());
			} else if (child.getType().equals("locale")) {
				obj.setLocale(child.getTextContents());
			}

		}

		return obj;
	}

	@Transient
	public String get_DATEFORMAT() {
		if (_DATEFORMAT == null && incident != null) {
			if (incident.get_DATEFORMAT() != null) {
				_DATEFORMAT = incident.get_DATEFORMAT();
			} else {
				_DATEFORMAT = incident.getAgent().getDateformat().getFormat();
			}
		}
	
		return _DATEFORMAT;
	}

	public void set_DATEFORMAT(String _dateformat) {

		_DATEFORMAT = _dateformat;
	}

	/*@Transient
	public String getCurrency() {
		String ret = "";

		if (currency_ID != null && currency_ID.length() > 0 && !currency_ID.equals("0")) {
			ret = CurrencyUtils.getCurrency(currency_ID).getDescription();
		}

		return ret;
	}*/

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	private static int parseInt(String s) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return 0;
		}
	}

	private static double parseDouble(String s) {
		try {
			return Double.parseDouble(s);
		} catch (Exception e) {
			return 0;
		}
	}

}
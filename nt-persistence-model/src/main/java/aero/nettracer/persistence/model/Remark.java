/*
 * Created on Jul 13, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ListIterator;
import java.util.TimeZone;

import aero.nettracer.commons.constant.GenericConstants;
import aero.nettracer.commons.utils.GenericDateUtils;
import aero.nettracer.persistence.util.RemarkType;
import com.cci.utils.parser.ElementNode;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;


/**
 * @author Administrator
 * 
 */ 
@Entity
@Table(name = "remark")
public class Remark implements Serializable {
	private static final long serialVersionUID = 7802884596671654910L;

	@Id
	@GeneratedValue
	private int Remark_ID;
	
	@ManyToOne
	@JoinColumn(name = "agent_ID", nullable = false)
	private Agent agent;
	private String createtime = "";
	private String remarktext = "";
	private int remarktype;
	private boolean secure;

	@OneToOne
	@JoinColumn(name = "forwardLink_ID", nullable = true)
	private ForwardLink forwardLink;

	@ManyToOne
	@JoinColumn(name = "incident_ID", nullable = true)
	@Fetch(FetchMode.SELECT)
	private Incident incident;

	@ManyToOne
	@JoinColumn(name = "OHD_ID", nullable = true)
	@Fetch(FetchMode.SELECT)
	private OHD ohd;

	@OneToOne
	@JoinColumn(name = "BDO_ID", nullable = true)
	@Fetch(FetchMode.SELECT)
	private BDO bdo;

	@ManyToOne
	@JoinColumn(name = "Expensepayout_ID", nullable = true)
	@Fetch(FetchMode.SELECT)
	private ExpensePayout expensePayout;

	@Column(name = "subtype", nullable = true)
	private Integer subtype;

  @Column(name = "callback_status", nullable = true)
  private Integer callBackStatus;

	@Transient
	private String _DATEFORMAT;
	@Transient
	private String _TIMEFORMAT;
	@Transient
	private TimeZone _TIMEZONE;

	@Transient
	private String label;

	public String toXML() {
		StringBuffer sb = new StringBuffer();
		sb.append("<remark>");
		sb.append("<Remark_ID>" + Remark_ID + "</Remark_ID>");
		sb.append("<remarktext>" + remarktext + "</remarktext>");
		sb.append("<createtime>" + createtime + "</createtime>");
		sb.append("<remarktype>" + remarktype + "</remarktype>");
		sb.append("<agent_ID>" + agent.getAgent_ID() + "</agent_ID>");
		sb.append("</remark>");
		return sb.toString();
	}

	public static Remark XMLtoObject(ElementNode root) {
		Remark obj = new Remark();

		ElementNode child = null, grandchild = null, ggrandchild = null, gggrandchild = null;

		for (ListIterator i = root.get_children().listIterator(); i.hasNext();) {
			child = (ElementNode) i.next();
			if (child.getType().equals("Remark_ID")) {
				obj.setRemark_ID(parseInt(child.getTextContents()));
			} else if (child.getType().equals("remarktext")) {
				obj.setRemarktext(child.getTextContents());
			} else if (child.getType().equals("remarktype")) {
				obj.setRemarktype(parseInt(child.getTextContents()));
			} else if (child.getType().equals("createtime")) {
				obj.setCreatetime(child.getTextContents());
			} else if (child.getType().equals("agent_ID")) {
				Agent agent = new Agent();
				agent.setAgent_ID(parseInt(child.getTextContents()));
				obj.setAgent(agent);
			}

		}

		return obj;
	}

	/**
	 * @return Returns the agent.
	 */
	public Agent getAgent() {
		return agent;
	}

	public String getAgentStation() {
		if (agent != null) return agent.getStation().getStationcode();
		else return null;
	}

	public String getAgentUsername() {
		if (agent != null) return agent.getUsername();
		else return null;
	}

	/**
	 * @param agent
	 *          The agent to set.
	 */
	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	/**
	 * @return Returns the createtime.
	 *
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 *
	 * @return the createtime for display only
	 */
	public String getDispcreatetime() {
		return GenericDateUtils.formatDate(createtime, GenericConstants.DB_DATETIMEFORMAT, get_DATEFORMAT()
				+ " " + get_TIMEFORMAT(), null, get_TIMEZONE());
	}

	/**
	 * @param createtime
	 *          The createtime to set.
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	/**
	 * @return Returns the remark_ID.
	 *
	 */
	public int getRemark_ID() {
		return Remark_ID;
	}

	/**
	 * @param remark_ID
	 *          The remark_ID to set.
	 */
	public void setRemark_ID(int remark_ID) {
		Remark_ID = remark_ID;
	}

	/**
	 * @return Returns the incident.
	 *
	 */
	public Incident getIncident() {
		return incident;
	}
	/**
	 * @param incident The incident to set.
	 */
	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	/**
	 * @return Returns the ohd.
	 *
	 */
	public OHD getOhd() {
		return ohd;
	}
	/**
	 * @param ohd The ohd to set.
	 */
	public void setOhd(OHD ohd) {
		this.ohd = ohd;
	}

	/**
	 * @return Returns the remarktext.
	 *
	 */
	public String getRemarktext() {
		return remarktext;
	}

	public String getReadonlyremarktext() {
		if(remarktext != null)
		{
			return remarktext.replaceAll("\r\n", "<br>");
		}
		else
		{
			return "";
		}
	}

	/**
	 * @param remarktext
	 *          The remarktext to set.
	 */
	public void setRemarktext(String remarktext) {
		this.remarktext = remarktext;
	}

	/**
	 * @return Returns the remarktype.
	 *
	 */
	public int getRemarktype() {
		return remarktype;
	}

	/**
	 * @param remarktype
	 *          The remarktype to set.
	 */
	public void setRemarktype(int remarktype) {
		this.remarktype = remarktype;
	}

	/**
	 * @return Returns the _DATEFORMAT.
	 */
	public String get_DATEFORMAT() {
		return _DATEFORMAT;
	}

	/**
	 * @param _dateformat
	 *          The _DATEFORMAT to set.
	 */
	public void set_DATEFORMAT(String _dateformat) {
		_DATEFORMAT = _dateformat;
	}

	/**
	 * @return Returns the _TIMEFORMAT.
	 */
	public String get_TIMEFORMAT() {
		return _TIMEFORMAT;
	}

	/**
	 * @param _timeformat
	 *          The _TIMEFORMAT to set.
	 */
	public void set_TIMEFORMAT(String _timeformat) {
		_TIMEFORMAT = _timeformat;
	}

	/**
	 * @return Returns the _TIMEZONE.
	 */
	public TimeZone get_TIMEZONE() {
		return _TIMEZONE;
	}

	/**
	 * @param _timezone
	 *          The _TIMEZONE to set.
	 */
	public void set_TIMEZONE(TimeZone _timezone) {
		_TIMEZONE = _timezone;
	}

	/**
	 * @return Returns the secure.
	 *
	 */
	public boolean isSecure() {
		return secure;
	}

	/**
	 * @param secure
	 *          secure to set.
	 */
	public void setSecure(boolean secure) {
		this.secure = secure;
	}


	/**
	 * @return Returns the forwardLink.
	 *
	 */
	public ForwardLink getForwardLink() {
		return forwardLink;
	}

	public void setForwardLink(ForwardLink forwardLink) {
		this.forwardLink = forwardLink;
	}

	public boolean getHasForwardLink() {
		return this.forwardLink != null;
	}

	//NTFIXME
	/*@Transient
	public String getDispLink(String locale) {
		if(getHasForwardLink()){
			return ForwardLinkUtils.getHTMLLink(forwardLink, locale);
		} else {
			return null;
		}
	}*/

	@Transient
	public Date getCreateDateObject() {
		return GenericDateUtils.convertToDatetime(createtime, GenericConstants.DB_DATETIMEFORMAT);
	}

	public void setCreateDateObject(Date date) {
		createtime = new SimpleDateFormat(GenericConstants.DB_DATETIMEFORMAT).format(GenericDateUtils.convertToGMTDate(date));
	}

	@Transient
	public String getRemarkTypeDescription() {
		return RemarkType.getDescriptionByKey(remarktype);
	}

	public void setRemarkTypeDescription(String description) {
		remarktype = RemarkType.getKeyByDescription(description);
	}

	public BDO getBdo() {
		return bdo;
	}

	public void setBdo(BDO bdo) {
		this.bdo = bdo;
	}

	public ExpensePayout getExpensePayout() {
		return expensePayout;
	}

	public void setExpensePayout(ExpensePayout expensePayout) {
		this.expensePayout = expensePayout;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getSubtype() {
		return subtype;
	}

	public void setSubtype(Integer subtype) {
		this.subtype = subtype;
	}

  public Integer getCallBackStatus() {
      return this.callBackStatus;
  }

	public void setCallBackStatus(Integer actionStatus) {
		this.callBackStatus = actionStatus;
	}

	private static int parseInt(String s) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return 0;
		}
	}
}
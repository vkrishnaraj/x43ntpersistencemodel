package aero.nettracer.persistence.model.taskmanager;

import aero.nettracer.persistence.model.BagCentral;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import org.apache.commons.lang.StringEscapeUtils;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

@Entity
@DiscriminatorValue("BAGCENTRAL")
@Proxy(lazy = true)
public class BagCentralTask extends GeneralTask {
	

	private BagCentral bagCentral;
	private String actionText;

	@ManyToOne(targetEntity = BagCentral.class, cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "bagcentral_id")
	@Fetch(FetchMode.SELECT)
	public BagCentral getBagCentral() {
		return bagCentral;
	}

	public void setBagCentral(BagCentral bagCentral) {
		this.bagCentral = bagCentral;
	}


	@Transient
	public String getAlert() {
		if(getBagCentral() != null && getBagCentral().getIncident() != null){
			String message = "Bag Central Claim Review Task currently in progress.  Continue working";
			String s = message + "  <a href='bagCentral.do'>" + getBagCentral().getIncident().getIncident_ID() + "</a>";
			return StringEscapeUtils.unescapeHtml(s);
		} else {
			return "";
		}
	}

	@Transient
	public String getActionText() {
		return actionText;
	}

	public void setActionText(String actionText) {
		this.actionText = actionText;
	}
}

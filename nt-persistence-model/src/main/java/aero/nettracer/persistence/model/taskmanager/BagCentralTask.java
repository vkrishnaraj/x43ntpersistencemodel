package aero.nettracer.persistence.model.taskmanager;

import aero.nettracer.persistence.model.BagCentral;
import org.apache.commons.lang3.StringEscapeUtils;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("BAGCENTRAL")
public class BagCentralTask extends GeneralTask {

	private BagCentral bagCentral;
	private String actionText;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bagcentral_id")
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
			String s = message + "  <a href='bagCentral.do'>" + getBagCentral().getIncident().getId() + "</a>";
			return StringEscapeUtils.unescapeHtml4(s);
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

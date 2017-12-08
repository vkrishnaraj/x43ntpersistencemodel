package aero.nettracer.persistence.model.taskmanager;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.apache.commons.lang.StringEscapeUtils;
import org.hibernate.annotations.Proxy;

@Entity
@DiscriminatorValue(FiveDayTask.TASK_TYPE)
@Proxy(lazy = true)
public class FiveDayTask extends MorningDutiesTask {

	@Transient
	public static final String TASK_TYPE = "5DAYTASK";

	@Transient
	public static final String LABEL = "TASK_LABEL_5DAY";

	@Transient
	public static final String KEY = "5";


	@Transient
	public String getDescription() {
		return "TASK_DESCRIPTION_5DAY";
	}
	
	@Transient
	public String getLabel() {
		return LABEL;
	}

	@Transient
	public String getKey() {
		return KEY;
	}

	@Transient
	public String getAlert() {
		String s = "Fifth Day Call currently in progress.  Continue working  <a href='GeneralTask.do?loadIncident=" + this.getIncident().getIncident_ID() + "'>" + this.getIncident().getIncident_ID() + "</a>";
		return StringEscapeUtils.unescapeHtml(s);
	}

}

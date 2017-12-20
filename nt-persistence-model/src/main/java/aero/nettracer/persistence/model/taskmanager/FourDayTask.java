package aero.nettracer.persistence.model.taskmanager;


import org.apache.commons.lang3.StringEscapeUtils;
import org.hibernate.annotations.Proxy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue(FourDayTask.TASK_TYPE)
@Proxy(lazy = true)
public class FourDayTask extends MorningDutiesTask {

	@Transient
	public static final String TASK_TYPE = "4DAYTASK";

	@Transient
	public static final String LABEL = "TASK_LABEL_4DAY";

	@Transient
	public static final String KEY = "4";


	@Transient
	public String getDescription() {
		return "TASK_DESCRIPTION_4DAY";
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
		String s = "Fourth Day Call currently in progress.  Continue working  <a href='GeneralTask.do?loadIncident=" + this.getIncident().getId() + "'>" + this.getIncident().getId() + "</a>";
		return StringEscapeUtils.unescapeHtml4(s);
	}
}

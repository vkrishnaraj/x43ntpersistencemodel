package aero.nettracer.persistence.model.taskmanager;

import org.apache.commons.lang3.StringEscapeUtils;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue(TwoDayTask.TASK_TYPE)
public class TwoDayTask extends MorningDutiesTask {

	@Transient
	public static final String TASK_TYPE = "2DAYTASK";

	@Transient
	public static final String LABEL = "TASK_LABEL_2DAY";

	@Transient
	public static final String KEY = "2";


	@Transient
	public String getDescription() {
		return "TASK_DESCRIPTION_2DAY";
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
		String s = "Second Day Call currently in progress.  Continue working  <a href='GeneralTask.do?loadIncident=" + this.getIncident().getId() + "'>" + this.getIncident().getId() + "</a>";
		return StringEscapeUtils.unescapeHtml4(s);
	}
}

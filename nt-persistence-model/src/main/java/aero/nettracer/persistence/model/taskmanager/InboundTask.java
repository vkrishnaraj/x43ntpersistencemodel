package aero.nettracer.persistence.model.taskmanager;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("INBOUND")
public class InboundTask extends InboundQueueTask {

	@Transient
	public String getDescription() {
		String description = null;
		if(getLocale() != null){
			description = "Inbound";
		}
		if(description != null){
			return description;
		} else {
			return "INBOUND TASK";
		}
	}
}

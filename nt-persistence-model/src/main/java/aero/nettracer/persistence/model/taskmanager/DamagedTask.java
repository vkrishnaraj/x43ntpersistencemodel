package aero.nettracer.persistence.model.taskmanager;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("DAMAGED")
public class DamagedTask extends InboundQueueTask {

	@Transient
	public String getDescription() {
		String description = null;
		if(getLocale() != null){
			description = "Damaged";
		}
		if(description != null){
			return description;
		} else {
			return "DAMAGED TASK";
		}
	}
}

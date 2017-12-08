package aero.nettracer.persistence.model.taskmanager;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.hibernate.annotations.Proxy;

@Entity
@DiscriminatorValue("ACAA")
@Proxy(lazy = true)
public class AcaaTask extends InboundQueueTask {
	@Transient
	public String getDescription() {
		String description = null;
		if(getLocale() != null){
			description = "ACAA";
		}
		if(description != null){
			return description;
		} else {
			return "ACAA TASK";
		}
	}
}

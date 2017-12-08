package aero.nettracer.persistence.model.wtq;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Proxy;

@Entity
@DiscriminatorValue("SUS_AHL")
public class WtqSuspendAhl extends WtqIncidentAction {
	
}

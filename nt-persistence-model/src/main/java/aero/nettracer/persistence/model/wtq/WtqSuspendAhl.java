package aero.nettracer.persistence.model.wtq;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SUS_AHL")
public class WtqSuspendAhl extends WtqIncidentAction {
	
}

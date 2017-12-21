package aero.nettracer.persistence.model.wtq;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RIT_AHL")
public class WtqReinstateAhl extends WtqIncidentAction {

}

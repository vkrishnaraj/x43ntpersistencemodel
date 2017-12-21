package aero.nettracer.persistence.model.wtq;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SUS_OHD")
public class WtqSuspendOhd extends WtqOhdAction {

}

package aero.nettracer.persistence.model.wtq;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RIT_OHD")
public class WtqReinstateOhd extends WtqOhdAction {

}

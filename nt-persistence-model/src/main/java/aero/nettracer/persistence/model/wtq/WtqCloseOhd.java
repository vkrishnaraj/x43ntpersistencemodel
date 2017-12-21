package aero.nettracer.persistence.model.wtq;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CLOSE_OHD")
public class WtqCloseOhd extends WtqOhdAction {

}

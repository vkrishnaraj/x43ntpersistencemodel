package aero.nettracer.persistence.model.logger;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FORWARD")
public class GeneralForwardLog extends GeneralLog {

}

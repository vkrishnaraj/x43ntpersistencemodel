package aero.nettracer.persistence.model.logger;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("LF")
public class GeneralLFLog extends GeneralLog {
}

package aero.nettracer.persistence.model.logger;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PCN")
public class GeneralPcnLog extends GeneralLog {
}

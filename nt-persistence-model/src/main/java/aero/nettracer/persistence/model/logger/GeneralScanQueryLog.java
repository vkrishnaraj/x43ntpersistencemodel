package aero.nettracer.persistence.model.logger;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SCANQRY")
public class GeneralScanQueryLog extends GeneralLog {
}

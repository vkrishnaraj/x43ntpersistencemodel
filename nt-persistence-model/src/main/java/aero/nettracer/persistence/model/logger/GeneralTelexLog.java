package aero.nettracer.persistence.model.logger;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TELEX")
public class GeneralTelexLog extends GeneralLog {
}

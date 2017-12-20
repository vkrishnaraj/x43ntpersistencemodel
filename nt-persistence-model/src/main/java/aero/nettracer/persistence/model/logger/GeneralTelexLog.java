package aero.nettracer.persistence.model.logger;

import org.hibernate.annotations.Proxy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TELEX")
@Proxy(lazy = true)
public class GeneralTelexLog extends GeneralLog {
}

package aero.nettracer.persistence.model.wtq;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Proxy;

@Entity
@DiscriminatorValue(value = "AMEND_OHD")
public class WtqAmendOhd extends WtqOhdAction {
}

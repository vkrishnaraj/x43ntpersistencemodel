package aero.nettracer.persistence.model.wtq;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CREATE_OHD")
public class WtqCreateOhd extends WtqOhdAction {
	
}

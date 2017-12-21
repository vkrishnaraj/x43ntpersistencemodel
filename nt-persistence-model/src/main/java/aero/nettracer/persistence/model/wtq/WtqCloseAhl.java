package aero.nettracer.persistence.model.wtq;

import aero.nettracer.persistence.model.Incident;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Proxy;


@Entity
@DiscriminatorValue("CLOSE_AHL")
public class WtqCloseAhl extends WtqIncidentAction {

	public WtqCloseAhl() {

	}

	public WtqCloseAhl(Incident incident) {
		super(incident);
	}

}

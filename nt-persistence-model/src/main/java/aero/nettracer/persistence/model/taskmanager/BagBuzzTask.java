package aero.nettracer.persistence.model.taskmanager;

import aero.nettracer.persistence.model.bagbuzz.BagBuzz;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("BAGBUZZ")
public class BagBuzzTask extends GeneralTask {

	private BagBuzz bagBuzz;

	@ManyToOne
	@JoinColumn(name = "bagbuzz_id")
	public BagBuzz getBagBuzz() {
		return bagBuzz;
	}

	public void setBagBuzz(BagBuzz bagBuzz) {
		this.bagBuzz = bagBuzz;
	}

}

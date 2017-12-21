package aero.nettracer.persistence.model.taskmanager;


import aero.nettracer.persistence.model.dr.Dispute;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("DISPUTE")
public class DisputeResolutionTask extends GeneralTask {
	
	private Dispute dispute;
	
	@OneToOne
	@JoinColumn(name = "dispute_res_id")
	public Dispute getDispute() {
		return dispute;
	}

	public void setDispute(Dispute dispute) {
		this.dispute = dispute;
	}
}

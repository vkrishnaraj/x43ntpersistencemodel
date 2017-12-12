package aero.nettracer.persistence.util;

public enum DeliveryStatusType {
	DELIVERED, PICKED_UP, ON_TRUCK, UNABLE_DELIVER;
	
	public String getDescriptionKey() {
		return "status.delivery." + this.name();
	}
}

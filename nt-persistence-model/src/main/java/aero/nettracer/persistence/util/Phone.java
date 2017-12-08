package aero.nettracer.persistence.util;


	/*
	 * The following Phone inner class and getPhoneList method is to map our application phones which are associated with the address
	 * to the web service/message queue model where a passenger has a collection of phone objects
	 * 
	 * This implementation ties our Passenger model to the web service phone type, Consider refactoring.
	 */
	
	public class Phone{
		public enum PhoneType{
			HOME,
			ALT,
			HOTEL,
			MOBILE,
			WORK,
			PAGER
		}
		
		private String phoneNumber;
		private PhoneType phoneType;
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public PhoneType getPhoneType() {
			return phoneType;
		}
		public void setPhoneType(PhoneType phoneType) {
			this.phoneType = phoneType;
		}

	}

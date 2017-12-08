package aero.nettracer.persistence.model.i8n;

import aero.nettracer.persistence.model.Agent;

public abstract class LocaleBasedObject {
	private String locale = null;
	
	public abstract String getKey();

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	public void setLocale(Agent agent) {
		this.locale = agent.getCurrentlocale();
	}
	
	//NTFIXME
	/*public String getDescription() {
		return TracerUtils.getText(getKey(), locale);
	}*/

	//NTFIXME
	/*public String getDescription(String loc) {
		return TracerUtils.getText(getKey(), loc);
	}*/

	//NTFIXME
	/*public String getTextDescription(Agent user) {
		return TracerUtils.getText(getKey(), user);
	}*/
}

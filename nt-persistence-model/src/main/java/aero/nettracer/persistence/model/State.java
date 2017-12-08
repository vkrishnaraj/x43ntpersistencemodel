package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "State")
public class State implements Serializable {
	private String State_ID;
	private String state;
	private String countrycode_ID;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Id
	public String getState_ID() {
		return State_ID;
	}

	public void setState_ID(String state_ID) {
		State_ID = state_ID;
	}

	public String getCountrycode_ID() {
		return countrycode_ID;
	}

	public void setCountrycode_ID(String countrycode_ID) {
		this.countrycode_ID = countrycode_ID;
	}
}
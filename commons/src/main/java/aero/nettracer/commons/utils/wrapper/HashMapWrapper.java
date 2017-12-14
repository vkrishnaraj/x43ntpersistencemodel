package aero.nettracer.commons.utils.wrapper;

import static aero.nettracer.commons.utils.Validations.validateNotNull;


import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class HashMapWrapper<K, V> {	
	private Map<K, V> basket;
	
	public HashMapWrapper() {
		this.basket = new LinkedHashMap<K, V>();
	}
	
	public HashMapWrapper(Map<K, V> basket) {
		validateNotNull(basket, "HashMap");
		this.basket = basket;
	}

	public Map<K, V> getBasket() {
		return basket;
	}
	
	public void setBasket(Map<K, V> basket) {
		this.basket = basket;
	}
}

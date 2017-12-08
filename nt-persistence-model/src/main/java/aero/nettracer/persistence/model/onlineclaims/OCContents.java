package aero.nettracer.persistence.model.onlineclaims;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "oc_content")
public class OCContents {
	@Id
	@GeneratedValue
	long id;
	
	@ManyToOne(targetEntity = OCBag.class)
	@JoinColumn(name = "bagId", nullable = false)
	private OCBag bag;
	
	@Basic
	private int male;
	
	@Column(length = 50)
	private String article;
	
	@Column(length = 50)
	private String color;
	
	@Column(length = 50)
	private String size;
	
	@Column(length = 50)
	private String brand;
	
	@Column(length = 50)
	private String purchasedAt;
	
	@Column(length = 50)
	private String purchasedDate;
	
	@Basic
	private double price;
	
	@Column(length = 3)
	private String currency;

	@Column(length = 50)
	private String contentOwner;
	
	@Basic
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getMale() {
		return male;
	}

	public void setMale(int male) {
		this.male = male;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPurchasedAt() {
		return purchasedAt;
	}

	public void setPurchasedAt(String purchasedAt) {
		this.purchasedAt = purchasedAt;
	}

	public String getPurchasedDate() {
		return purchasedDate;
	}

	public void setPurchasedDate(String purchasedDate) {
		this.purchasedDate = purchasedDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public long getId() {
  	return id;
  }

	public void setId(long id) {
  	this.id = id;
  }

	public OCBag getBag() {
		return bag;
	}

	public void setBag(OCBag bag) {
		this.bag = bag;
	}

	public String getContentOwner() {
		return contentOwner;
	}

	public void setContentOwner(String contentOwner) {
		this.contentOwner = contentOwner;
	}

}

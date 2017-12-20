package aero.nettracer.persistence.model.onlineclaims;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "oc_content")
public class OCContents {

	long id;
	private String article;
	private String brand;
	private String color;
	private String currency;
	private int male;
	private double price;
	private String purchasedAt;
	private String purchasedDate;
	private String size;
	private OCBag bag;
	private String contentOwner;
	private int quantity;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "article")
	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	@Column(name = "brand")
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Column(name = "color")
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "currency")
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Column(name = "male")
	public int getMale() {
		return male;
	}

	public void setMale(int male) {
		this.male = male;
	}

	@Column(name = "price")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name = "purchasedat")
	public String getPurchasedAt() {
		return purchasedAt;
	}

	public void setPurchasedAt(String purchasedAt) {
		this.purchasedAt = purchasedAt;
	}

	@Column(name = "purchaseddate")
	public String getPurchasedDate() {
		return purchasedDate;
	}

	public void setPurchasedDate(String purchasedDate) {
		this.purchasedDate = purchasedDate;
	}

	@Column(name = "size")
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@ManyToOne
	@JoinColumn(name = "bagid", nullable = false)
	public OCBag getBag() {
		return bag;
	}

	public void setBag(OCBag bag) {
		this.bag = bag;
	}

	@Column(name = "contentowner")
	public String getContentOwner() {
		return contentOwner;
	}

	public void setContentOwner(String contentOwner) {
		this.contentOwner = contentOwner;
	}

	@Column(name = "quantity")
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

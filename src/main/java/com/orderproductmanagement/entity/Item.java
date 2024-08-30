package com.orderproductmanagement.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "item", uniqueConstraints = @UniqueConstraint(columnNames = { "title" }))
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemId;
	private String title;
	private String summary;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	@NotNull
	@Column(nullable = false)
	private BigDecimal mrp;
	private BigDecimal discount;
	@NotNull
	@Column(nullable = false)
	private BigDecimal price;
	@NotNull
	@Column(nullable = false)
	private int quantity;
	@NotNull
	@Column(nullable = false)
	private int sold;
	@NotNull
	@Column(nullable = false)
	private int available;
	@NotNull
	@Column(nullable = false)
	private int defective;
	
	@OneToMany(mappedBy = "item")
	private Set<OrderItemDetails> orderItemDetails = new HashSet<>();
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(Long itemId, String title, String summary, @NotNull Product product, @NotNull Brand brand,
			@NotNull BigDecimal mrp, BigDecimal discount, @NotNull BigDecimal price, @NotNull int quantity,
			@NotNull int sold, @NotNull int available, @NotNull int defective, LocalDateTime createdAt,
			Set<OrderItemDetails> orderItemDetails,
			LocalDateTime updatedAt) {
		super();
		this.itemId = itemId;
		this.title = title;
		this.summary = summary;
		this.product = product;
		this.brand = brand;
		this.mrp = mrp;
		this.discount = discount;
		this.price = price;
		this.quantity = quantity;
		this.sold = sold;
		this.available = available;
		this.defective = defective;
		this.orderItemDetails = orderItemDetails;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
    void onCreate() {
	   this.setCreatedAt(LocalDateTime.now());
    }

	public Long getItemId() {
		return itemId;
	}

	public String getTitle() {
		return title;
	}

	public String getSummary() {
		return summary;
	}

	public Product getProduct() {
		return product;
	}

	public Brand getBrand() {
		return brand;
	}

	public BigDecimal getMrp() {
		return mrp;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getSold() {
		return sold;
	}

	public int getAvailable() {
		return available;
	}

	public int getDefective() {
		return defective;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public void setMrp(BigDecimal mrp) {
		this.mrp = mrp;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public void setDefective(int defective) {
		this.defective = defective;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Set<OrderItemDetails> getOrderItemDetails() {
		return orderItemDetails;
	}

	public void setOrderItemDetails(Set<OrderItemDetails> orderItemDetails) {
		this.orderItemDetails = orderItemDetails;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", title=" + title + ", summary=" + summary + ", product=" + product
				+ ", brand=" + brand + ", mrp=" + mrp + ", discount=" + discount + ", price=" + price + ", quantity="
				+ quantity + ", sold=" + sold + ", available=" + available + ", defective=" + defective
				+ ", orderItemDetails=" + orderItemDetails + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}

	
}

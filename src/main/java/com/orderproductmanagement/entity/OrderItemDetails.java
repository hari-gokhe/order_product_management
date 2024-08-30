package com.orderproductmanagement.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "order_item_details")
public class OrderItemDetails {
	@Id
	@Column(name = "order_item_details_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	@ManyToOne
	@JoinColumn(name = "orders_id")
	private Orders orders;
	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item item;

	private BigDecimal discount;
	@NotNull
	@Column(nullable = false)
	private BigDecimal price;
	@NotNull
	@Column(nullable = false)
	private int quantity;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public OrderItemDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItemDetails(Long id, Product product, Orders orders, 
			Item item, 
			BigDecimal discount,
			@NotNull BigDecimal price, @NotNull int quantity, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.product = product;
		this.orders = orders;
		this.item = item;
		this.discount = discount;
		this.price = price;
		this.quantity = quantity;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@PrePersist
    void onCreate() {
	   this.setCreatedAt(LocalDateTime.now());
    }
	
	public Long getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public Orders getOrders() {
		return orders;
	}

	public Item getItem() {
		return item;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public void setItem(Item item) {
		this.item = item;
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

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "OrderItemDetails [id=" + id + ", product=" + product + ", orders=" + orders + ", item=" + item
				+ ", discount=" + discount + ", price=" + price + ", quantity=" + quantity + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

	
}

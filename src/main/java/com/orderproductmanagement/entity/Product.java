package com.orderproductmanagement.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "product", uniqueConstraints = @UniqueConstraint(columnNames = { "title" }))
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private Long productId;
	
	private String title;
	private String summary;
	private String type;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	@ManyToOne
	@JsonIgnoreProperties(ignoreUnknown = true)
	private Category category;
	
	@OneToMany(mappedBy = "product")
	private Set<OrderItemDetails> orderItemDetails = new HashSet<>();

	public Product(Long productId, String title, String summary, String type, LocalDateTime createdAt, LocalDateTime updatedAt,
			Category category,Set<OrderItemDetails> orderItemDetails) {
		super();
		this.productId = productId;
		this.title = title;
		this.summary = summary;
		this.type = type;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.category = category;
		this.orderItemDetails =orderItemDetails;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PrePersist
    void onCreate() {
	   this.setCreatedAt(LocalDateTime.now());
    }
	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	public Set<OrderItemDetails> getOrderItemDetails() {
		return orderItemDetails;
	}

	public void setOrderItemDetails(Set<OrderItemDetails> orderItemDetails) {
		this.orderItemDetails = orderItemDetails;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", title=" + title + ", summary=" + summary + ", type=" + type
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", category=" + category
				+ ", orderItemDetails=" + orderItemDetails + "]";
	}



	

	

}

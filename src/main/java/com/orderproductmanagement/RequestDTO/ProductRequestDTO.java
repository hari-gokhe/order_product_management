package com.orderproductmanagement.RequestDTO;

import java.time.LocalDate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ProductRequestDTO {

	private Long productId;
	@NotEmpty(message = "title is required")
	private String title;
	@NotEmpty(message = "summary is required")
	private String summary;
	@NotEmpty(message = "type is required")
	private String type;
//	@NotEmpty(message = "category is required")
	@Valid
	@NotNull(message = "category is required.")
	private CategoryRequestDTO category;
	private LocalDate createdAt;
	private LocalDate updatedAt;

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

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	public CategoryRequestDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryRequestDTO category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ProductRequestDTO [productId=" + productId + ", title=" + title + ", summary=" + summary + ", type="
				+ type + ", category=" + category + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}

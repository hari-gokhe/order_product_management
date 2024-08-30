package com.orderproductmanagement.RequestDTO;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Null;

public class BrandRequestDTO {

	private Long brandId;
	@NotEmpty(message = "title is required")
	private String title;
	@NotEmpty(message = "summary is required")
	private String summary;
	private LocalDate createdAt;
	private LocalDate updatedAt;

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
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

	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", title=" + title + ", summary=" + summary + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

}

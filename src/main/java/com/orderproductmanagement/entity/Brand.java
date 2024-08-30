package com.orderproductmanagement.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "brand", uniqueConstraints = @UniqueConstraint(columnNames = { "title" }))
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long brandId;
	@NotNull
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String summary;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public Brand(Long brandId, String title, String summary, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.brandId = brandId;
		this.title = title;
		this.summary = summary;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PrePersist
    void onCreate() {
	   this.setCreatedAt(LocalDateTime.now());
    }
	
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

	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", title=" + title + ", summary=" + summary + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

}

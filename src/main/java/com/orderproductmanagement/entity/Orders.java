package com.orderproductmanagement.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	private byte status;
	private BigDecimal subTotal;
	private BigDecimal itemDiscount;
	private BigDecimal tax;
	private BigDecimal total;
	private String promoCode;
	private BigDecimal discount;
	private BigDecimal grandTotal;
	
	@OneToMany(mappedBy = "orders")
	private Set<OrderItemDetails> orderItemDetails = new HashSet<>();
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(Long orderId, User user, byte status, BigDecimal subTotal, BigDecimal itemDiscount, BigDecimal tax,
			BigDecimal total, String promoCode,  BigDecimal discount, BigDecimal grandTotal,
			Set<OrderItemDetails> orderItemDetails,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.status = status;
		this.subTotal = subTotal;
		this.itemDiscount = itemDiscount;
		this.tax = tax;
		this.total = total;
		this.promoCode = promoCode;
		this.discount = discount;
		this.grandTotal = grandTotal;
		this.orderItemDetails = orderItemDetails;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
	void onCreate() {
		this.setCreatedAt(LocalDateTime.now());
	}
	public Long getOrderId() {
		return orderId;
	}
	public User getUser() {
		return user;
	}
	public byte getStatus() {
		return status;
	}
	public BigDecimal getSubTotal() {
		return subTotal;
	}
	public BigDecimal getItemDiscount() {
		return itemDiscount;
	}
	public BigDecimal getTax() {
		return tax;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public String getPromoCode() {
		return promoCode;
	}
	
	public BigDecimal getDiscount() {
		return discount;
	}
	public BigDecimal getGrandTotal() {
		return grandTotal;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}
	public void setItemDiscount(BigDecimal itemDiscount) {
		this.itemDiscount = itemDiscount;
	}
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
	
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
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
	public void addOrderItemDetails(OrderItemDetails orderItemDetails) {
		this.orderItemDetails.add(orderItemDetails);
	}
	

}

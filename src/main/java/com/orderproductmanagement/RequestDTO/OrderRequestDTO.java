package com.orderproductmanagement.RequestDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.orderproductmanagement.entity.OrderItemDetails;
import com.orderproductmanagement.entity.User;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class OrderRequestDTO {

	private Long orderId;
	@NotNull(message = "user Details can not be null")
	private User user;
	private byte status;
	@DecimalMax(value = "1000000", inclusive = false)
	@DecimalMin(value = "0.1")
//	@NotNull(message = "subTotal can not be null")
	private BigDecimal subTotal;
	@DecimalMax(value = "1000000", inclusive = false)
	@DecimalMin(value = "0.1")
//	@NotNull(message = "itemDiscount can not be null")
	private BigDecimal itemDiscount;
	@DecimalMax(value = "1000000", inclusive = false)
	@DecimalMin(value = "0.1")
//	@NotNull(message = "tax can not be null")
	private BigDecimal tax;
	@DecimalMax(value = "1000000", inclusive = false)
	@DecimalMin(value = "0.1")
//	@NotNull(message = "total can not be null")
	private BigDecimal total;
	
	private String promoCode;
	@DecimalMax(value = "1000000", inclusive = false)
	@DecimalMin(value = "0.1")
//	@NotNull(message = "discount can not be null")
	private BigDecimal discount;
	@DecimalMax(value = "1000000", inclusive = false)
	@DecimalMin(value = "0.1")
//	@NotNull(message = "grandTotal can not be null")
	private BigDecimal grandTotal;
	@NotEmpty(message = "orderItemDetails can not be empty")
	private Set<OrderItemDetails> orderItemDetails = new HashSet<>();
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
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
	public Set<OrderItemDetails> getOrderItemDetails() {
		return orderItemDetails;
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
	public void setOrderItemDetails(Set<OrderItemDetails> orderItemDetails) {
		this.orderItemDetails = orderItemDetails;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "OrderRequestDTO [orderId=" + orderId + ", user=" + user + ", status=" + status + ", subTotal="
				+ subTotal + ", itemDiscount=" + itemDiscount + ", tax=" + tax + ", total=" + total + ", promoCode="
				+ promoCode + ", discount=" + discount + ", grandTotal=" + grandTotal + ", orderItemDetails="
				+ orderItemDetails + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	

}

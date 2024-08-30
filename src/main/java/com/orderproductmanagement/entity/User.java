package com.orderproductmanagement.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = { "userName","mobile" }))

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private String userName;
	@NotNull
	private String mobile;
	@NotNull
	private String email;

//	@JsonIgnore
	private LocalDateTime registeredAt;
	@Nullable
	@JsonIgnore
	private LocalDate lastLogin;

	public User(Long userId, String firstName, String lastName, String userName, String mobile, String email,
			LocalDateTime registeredAt, LocalDate lastLogin) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.mobile = mobile;
		this.email = email;
		this.registeredAt = registeredAt;
		this.lastLogin = lastLogin;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PrePersist
	void onCreate() {
		this.setRegisteredAt(LocalDateTime.now());
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(LocalDateTime registeredAt) {
		this.registeredAt = registeredAt;
	}

	public LocalDate getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDate lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", mobile=" + mobile + ", email=" + email + ", registeredAt=" + registeredAt
				+ ", lastLogin=" + lastLogin + "]";
	}

}

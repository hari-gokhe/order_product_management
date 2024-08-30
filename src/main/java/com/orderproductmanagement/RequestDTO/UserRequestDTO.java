package com.orderproductmanagement.RequestDTO;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;


public class UserRequestDTO {

	private Long userId;
	@NotEmpty(message = "firstName is required")
	@NotBlank
	private String firstName;
	
	@NotEmpty(message = "lastName is required")
	@NotBlank
	private String lastName;
	
	private String userName;
	
	@NotEmpty(message = "mobile is required")
	@NotBlank
	@Size(min=10,max=10,message = "mobile number length can not be less than 10 digit")
	private String mobile;
	
	@NotEmpty(message = "email is required")
	@Email(message = "please enter valid email")
	@NotBlank
	private String email;
	
	private LocalDate registeredAt;
	@Null
	private LocalDate lastLogin;

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

	public LocalDate getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(LocalDate registeredAt) {
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

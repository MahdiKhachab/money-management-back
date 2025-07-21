package com.alzahraa.money.manegment.dto;

import lombok.Data;

@Data
public class DonorRequestDTO {
	
	private String fullName;
	
	private String organization;
	
	private String phone;
	
	private String email;

	public DonorRequestDTO() {
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
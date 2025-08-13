package com.alzahraa.money.manegment.dto;

import java.time.LocalDate;

import com.alzahraa.money.manegment.enums.IncomeSourceTypeEnum;


public class IncomeRequestDTO {
	private Double amount;
	private IncomeSourceTypeEnum sourceType;
	private String description;
	private LocalDate dateReceived;
	private Long donorId; // ID المتبرع إذا موجود

	public IncomeRequestDTO() {
		// TODO Auto-generated constructor stub
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public IncomeSourceTypeEnum getSourceType() {
		return sourceType;
	}

	public void setSourceType(IncomeSourceTypeEnum sourceType) {
		this.sourceType = sourceType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(LocalDate dateReceived) {
		this.dateReceived = dateReceived;
	}

	public Long getDonorId() {
		return donorId;
	}

	public void setDonorId(Long donorId) {
		this.donorId = donorId;
	}

}

package com.alzahraa.money.manegment.dto;

import java.time.LocalDate;

import com.alzahraa.money.manegment.enums.IncomeSourceTypeEnum;

 
public class IncomeResponseDTO {

	private Long id;

	private Double amount;

	private IncomeSourceTypeEnum sourceType;

	private String description;

	private LocalDate dateReceived;

	private Long donorId; // نرسل معرف المتبرع للرجوع له

	private String donorName; // اسم المتبرع للعرض في الرد

	public IncomeResponseDTO(Long id, Double amount, IncomeSourceTypeEnum sourceType, String description,
			LocalDate dateReceived, Long donorId, String donorName) {
		super();
		this.id = id;
		this.amount = amount;
		this.sourceType = sourceType;
		this.description = description;
		this.dateReceived = dateReceived;
		this.donorId = donorId;
		this.donorName = donorName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

}

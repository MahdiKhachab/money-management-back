package com.alzahraa.money.manegment.entity;

import java.time.LocalDate;


import com.alzahraa.money.manegment.enums.IncomeSourceTypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_incomes")
public class IncomeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Double amount;

	@Enumerated(EnumType.STRING)
	@Column(name = "source_type", length = 20, nullable = false)
	private IncomeSourceTypeEnum sourceType;

	@Column(length = 255)
	private String description;

	@Column(name = "date_received", nullable = false)
	private LocalDate dateReceived;

	@ManyToOne
	@JoinColumn(name = "donor_id")
	private DonorEntity donor;

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

	public DonorEntity getDonor() {
		return donor;
	}

	public void setDonor(DonorEntity donor) {
		this.donor = donor;
	}

}

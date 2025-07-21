package com.alzahraa.money.manegment.dto;

import java.time.LocalDate;

import com.alzahraa.money.manegment.enums.ExpenseCategoryEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseResponseDTO {
	private Long id;
	private Double amount;
	private ExpenseCategoryEnum category;
	private String details;
	private LocalDate dateSpent;

	public ExpenseResponseDTO(Long id, Double amount, ExpenseCategoryEnum category, String details,
			LocalDate dateSpent) {
		super();
		this.id = id;
		this.amount = amount;
		this.category = category;
		this.details = details;
		this.dateSpent = dateSpent;
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

	public ExpenseCategoryEnum getCategory() {
		return category;
	}

	public void setCategory(ExpenseCategoryEnum category) {
		this.category = category;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public LocalDate getDateSpent() {
		return dateSpent;
	}

	public void setDateSpent(LocalDate dateSpent) {
		this.dateSpent = dateSpent;
	}

}

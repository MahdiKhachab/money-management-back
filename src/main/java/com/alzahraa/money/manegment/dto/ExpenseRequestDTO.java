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
public class ExpenseRequestDTO {
	private Double amount;
	private ExpenseCategoryEnum category;
	private String details;
	private LocalDate dateSpent;

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

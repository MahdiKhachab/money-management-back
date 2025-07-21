package com.alzahraa.money.manegment.dto;

import com.alzahraa.money.manegment.enums.ExpenseCategoryEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategorySummaryDTO {

	private ExpenseCategoryEnum category;

	private double totalAmount;

	public CategorySummaryDTO(ExpenseCategoryEnum category, double totalAmount) {
		super();
		this.category = category;
		this.totalAmount = totalAmount;
	}

	public ExpenseCategoryEnum getCategory() {
		return category;
	}

	public void setCategory(ExpenseCategoryEnum category) {
		this.category = category;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}

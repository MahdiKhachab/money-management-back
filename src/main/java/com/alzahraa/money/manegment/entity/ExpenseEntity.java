package com.alzahraa.money.manegment.entity;

import java.time.LocalDate;


import com.alzahraa.money.manegment.enums.ExpenseCategoryEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_Expenses")
public class ExpenseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private ExpenseCategoryEnum category;

    @Column(length = 255)
    private String details;

    @Column(name = "date_spent", nullable = false)
    private LocalDate dateSpent;

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

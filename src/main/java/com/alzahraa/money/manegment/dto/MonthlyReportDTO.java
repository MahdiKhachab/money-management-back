package com.alzahraa.money.manegment.dto;

public class MonthlyReportDTO {
	private int year;
	private int month;
	private Double totalIncome;
	private Double totalExpenses;
	private Double netBalance;

	public MonthlyReportDTO(int year, int month, Double totalIncome, Double totalExpenses, Double netBalance) {
		super();
		this.year = year;
		this.month = month;
		this.totalIncome = totalIncome;
		this.totalExpenses = totalExpenses;
		this.netBalance = netBalance;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public Double getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(Double totalIncome) {
		this.totalIncome = totalIncome;
	}

	public Double getTotalExpenses() {
		return totalExpenses;
	}

	public void setTotalExpenses(Double totalExpenses) {
		this.totalExpenses = totalExpenses;
	}

	public Double getNetBalance() {
		return netBalance;
	}

	public void setNetBalance(Double netBalance) {
		this.netBalance = netBalance;
	}

}

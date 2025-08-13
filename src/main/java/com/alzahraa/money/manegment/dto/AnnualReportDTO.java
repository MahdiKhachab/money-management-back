package com.alzahraa.money.manegment.dto;

public class AnnualReportDTO {
	private int year;
	private double totalIncome;
	private double totalExpense;
	private double totalMaintenance;
	private double netBalance;

	public AnnualReportDTO(int year, double totalIncome, double totalExpense, double totalMaintenance,
			double netBalance) {
		super();
		this.year = year;
		this.totalIncome = totalIncome;
		this.totalExpense = totalExpense;
		this.totalMaintenance = totalMaintenance;
		this.netBalance = netBalance;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(double totalIncome) {
		this.totalIncome = totalIncome;
	}

	public double getTotalExpense() {
		return totalExpense;
	}

	public void setTotalExpense(double totalExpense) {
		this.totalExpense = totalExpense;
	}

	public double getTotalMaintenance() {
		return totalMaintenance;
	}

	public void setTotalMaintenance(double totalMaintenance) {
		this.totalMaintenance = totalMaintenance;
	}

	public double getNetBalance() {
		return netBalance;
	}

	public void setNetBalance(double netBalance) {
		this.netBalance = netBalance;
	}

}

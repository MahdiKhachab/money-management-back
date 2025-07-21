package com.alzahraa.money.manegment.service.impl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alzahraa.money.manegment.dto.AnnualReportDTO;
import com.alzahraa.money.manegment.dto.CategorySummaryDTO;
import com.alzahraa.money.manegment.dto.MonthlyReportDTO;
import com.alzahraa.money.manegment.dto.SourceSummaryDTO;
import com.alzahraa.money.manegment.entity.ExpenseEntity;
import com.alzahraa.money.manegment.entity.IncomeEntity;
import com.alzahraa.money.manegment.entity.MaintenanceEntity;
import com.alzahraa.money.manegment.enums.ExpenseCategoryEnum;
import com.alzahraa.money.manegment.enums.IncomeSourceTypeEnum;
import com.alzahraa.money.manegment.repository.ExpenseRepository;
import com.alzahraa.money.manegment.repository.IncomeRepository;
import com.alzahraa.money.manegment.repository.MaintenanceRepository;
import com.alzahraa.money.manegment.service.ReportService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

	@Autowired
	private IncomeRepository incomeRepository;
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Autowired
	private MaintenanceRepository maintenanceRepository;

	@Override
	public AnnualReportDTO getAnnualReport(int year) {
		LocalDate start = LocalDate.of(year, 1, 1);
		LocalDate end = LocalDate.of(year, 12, 31);

		double totalIncome = incomeRepository.findByDateReceivedBetween(start, end).stream()
				.mapToDouble(IncomeEntity::getAmount).sum();

		double totalExpenses = expenseRepository.findByDateSpentBetween(start, end).stream()
				.mapToDouble(ExpenseEntity::getAmount).sum();

		double totalMaintenance = maintenanceRepository.findByDateBetween(start, end).stream()
				.mapToDouble(MaintenanceEntity::getCost).sum();

		double netBalance = totalIncome - (totalExpenses + totalMaintenance);

		return new AnnualReportDTO(year, totalIncome, totalExpenses, totalMaintenance, netBalance);
	}

	@Override
	public List<SourceSummaryDTO> getIncomeBySourceType(int year) {
		LocalDate start = LocalDate.of(year, 1, 1);
		LocalDate end = LocalDate.of(year, 12, 31);

		List<IncomeEntity> incomes = incomeRepository.findByDateReceivedBetween(start, end);

		return Arrays
				.stream(IncomeSourceTypeEnum
						.values())
				.map(type -> new SourceSummaryDTO(type, incomes.stream().filter(i -> i.getSourceType() == type)
						.mapToDouble(IncomeEntity::getAmount).sum()))
				.collect(Collectors.toList());
	}

	@Override
	public List<CategorySummaryDTO> getExpensesByCategory(int year) {
		LocalDate start = LocalDate.of(year, 1, 1);
		LocalDate end = LocalDate.of(year, 12, 31);

		List<ExpenseEntity> expenses = expenseRepository.findByDateSpentBetween(start, end);

		return Arrays.stream(ExpenseCategoryEnum.values())
				.map(category -> new CategorySummaryDTO(category, expenses.stream()
						.filter(e -> e.getCategory() == category).mapToDouble(ExpenseEntity::getAmount).sum()))
				.collect(Collectors.toList());
	}

	@Override
	public MonthlyReportDTO getMonthlyReport(int year, int month) {
		LocalDate start = LocalDate.of(year, month, 1);
		LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

		double totalIncome = incomeRepository.findByDateReceivedBetween(start, end).stream()
				.mapToDouble(IncomeEntity::getAmount).sum();

		double totalExpenses = expenseRepository.findByDateSpentBetween(start, end).stream()
				.mapToDouble(ExpenseEntity::getAmount).sum();

		double totalMaintenance = maintenanceRepository.findByDateBetween(start, end).stream()
				.mapToDouble(MaintenanceEntity::getCost).sum();

		double netBalance = totalIncome - (totalExpenses + totalMaintenance);

		return new MonthlyReportDTO(year, month, totalIncome, totalExpenses + totalMaintenance, netBalance);
	}
}

package com.alzahraa.money.manegment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alzahraa.money.manegment.dto.AnnualReportDTO;
import com.alzahraa.money.manegment.dto.CategorySummaryDTO;
import com.alzahraa.money.manegment.dto.MonthlyReportDTO;
import com.alzahraa.money.manegment.dto.SourceSummaryDTO;
import com.alzahraa.money.manegment.service.ReportService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

	@Autowired
	private ReportService reportService;

	@GetMapping("/monthly")
	public MonthlyReportDTO getMonthlyReport(@RequestParam int year, @RequestParam int month) {
		return reportService.getMonthlyReport(year, month);
	}

	@GetMapping("/annual")
	public AnnualReportDTO getAnnualReport(@RequestParam int year) {
		return reportService.getAnnualReport(year);
	}

	@GetMapping("/income-by-source")
	public List<SourceSummaryDTO> getIncomeBySource(@RequestParam int year) {
		return reportService.getIncomeBySourceType(year);
	}

	@GetMapping("/expense-by-category")
	public List<CategorySummaryDTO> getExpensesByCategory(@RequestParam int year) {
		return reportService.getExpensesByCategory(year);
	}
}

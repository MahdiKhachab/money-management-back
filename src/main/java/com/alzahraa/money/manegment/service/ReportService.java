package com.alzahraa.money.manegment.service;

import java.util.List;

import com.alzahraa.money.manegment.dto.AnnualReportDTO;
import com.alzahraa.money.manegment.dto.CategorySummaryDTO;
import com.alzahraa.money.manegment.dto.MonthlyReportDTO;
import com.alzahraa.money.manegment.dto.SourceSummaryDTO;

public interface ReportService {

	AnnualReportDTO getAnnualReport(int year);

	List<SourceSummaryDTO> getIncomeBySourceType(int year);

	List<CategorySummaryDTO> getExpensesByCategory(int year);

	MonthlyReportDTO getMonthlyReport(int year, int month);
}

package com.alzahraa.money.manegment.service;

import java.util.List;

import com.alzahraa.money.manegment.dto.IncomeRequestDTO;
import com.alzahraa.money.manegment.dto.IncomeResponseDTO;

public interface IncomeService {

	IncomeResponseDTO createIncome(IncomeRequestDTO incomeRequestDTO);

	List<IncomeResponseDTO> getAllIncomes();

	IncomeResponseDTO getIncomeById(Long id);

	IncomeResponseDTO updateIncome(Long id, IncomeRequestDTO incomeRequestDTO);

	void deleteIncome(Long id);
}

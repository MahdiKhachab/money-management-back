package com.alzahraa.money.manegment.service;

import java.util.List;

import com.alzahraa.money.manegment.dto.ExpenseRequestDTO;
import com.alzahraa.money.manegment.dto.ExpenseResponseDTO;

public interface ExpenseService {
	ExpenseResponseDTO createExpense(ExpenseRequestDTO dto);

	List<ExpenseResponseDTO> getAllExpenses();

	ExpenseResponseDTO getExpenseById(Long id);

	ExpenseResponseDTO updateExpense(Long id, ExpenseRequestDTO dto);

	void deleteExpense(Long id);
}

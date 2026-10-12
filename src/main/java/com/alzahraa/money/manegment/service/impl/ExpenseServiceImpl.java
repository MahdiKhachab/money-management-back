package com.alzahraa.money.manegment.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alzahraa.money.manegment.dto.ExpenseRequestDTO;
import com.alzahraa.money.manegment.dto.ExpenseResponseDTO;
import com.alzahraa.money.manegment.entity.ExpenseEntity;
import com.alzahraa.money.manegment.repository.ExpenseRepository;
import com.alzahraa.money.manegment.service.ExpenseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;

	@Override
	public ExpenseResponseDTO createExpense(ExpenseRequestDTO dto) {
		ExpenseEntity entity = new ExpenseEntity();
		entity.setAmount(dto.getAmount());
		entity.setCategory(dto.getCategory());
		entity.setDetails(dto.getDetails());
		entity.setDateSpent(dto.getDateSpent());

		ExpenseEntity saved = expenseRepository.save(entity);
		return mapToResponse(saved);
	}

	@Override
	public List<ExpenseResponseDTO> getAllExpenses() {
		return expenseRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
	}

	@Override
	public ExpenseResponseDTO getExpenseById(Long id) {
		ExpenseEntity entity = expenseRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));
		return mapToResponse(entity);
	}

	@Override
	public ExpenseResponseDTO updateExpense(Long id, ExpenseRequestDTO dto) {
		ExpenseEntity entity = expenseRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));
		entity.setAmount(dto.getAmount());
		entity.setCategory(dto.getCategory());
		entity.setDetails(dto.getDetails());
		entity.setDateSpent(dto.getDateSpent());
		return mapToResponse(expenseRepository.save(entity));
	}

	@Override
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}

	private ExpenseResponseDTO mapToResponse(ExpenseEntity entity) {
		return new ExpenseResponseDTO(entity.getId(), entity.getAmount(), entity.getCategory(), entity.getDetails(),
				entity.getDateSpent());
	}
}

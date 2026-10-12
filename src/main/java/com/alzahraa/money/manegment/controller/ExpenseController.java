package com.alzahraa.money.manegment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alzahraa.money.manegment.dto.ExpenseRequestDTO;
import com.alzahraa.money.manegment.dto.ExpenseResponseDTO;
import com.alzahraa.money.manegment.service.ExpenseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ExpenseResponseDTO createExpense(@RequestBody ExpenseRequestDTO dto) {
		return expenseService.createExpense(dto);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ExpenseResponseDTO> getAllExpenses() {
		return expenseService.getAllExpenses();
	}

	@GetMapping(value = { "/{id}", "/v1/expenses/{id}" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ExpenseResponseDTO getExpenseById(@PathVariable Long id) {
		return expenseService.getExpenseById(id);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ExpenseResponseDTO updateExpense(@PathVariable Long id, @RequestBody ExpenseRequestDTO dto) {
		return expenseService.updateExpense(id, dto);
	}

	@DeleteMapping({ "/{id}", "/v1/delete/{id}" })
	public ResponseEntity<Boolean> deleteExpense(@PathVariable Long id) {
		expenseService.deleteExpense(id);
		return ResponseEntity.ok(true);
	}
}

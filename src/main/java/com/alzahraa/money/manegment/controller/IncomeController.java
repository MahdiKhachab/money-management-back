package com.alzahraa.money.manegment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alzahraa.money.manegment.dto.IncomeRequestDTO;
import com.alzahraa.money.manegment.dto.IncomeResponseDTO;
import com.alzahraa.money.manegment.service.IncomeService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/incomes")
@RequiredArgsConstructor
public class IncomeController {

	@Autowired
	private IncomeService incomeService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public IncomeResponseDTO createIncome(@RequestBody IncomeRequestDTO incomeRequestDTO) {
		return incomeService.createIncome(incomeRequestDTO);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<IncomeResponseDTO> getAllIncomes() {
		return incomeService.getAllIncomes();
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public IncomeResponseDTO getIncomeById(@PathVariable Long id) {
		return incomeService.getIncomeById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteIncome(@PathVariable Long id) {
		incomeService.deleteIncome(id);
	}
}

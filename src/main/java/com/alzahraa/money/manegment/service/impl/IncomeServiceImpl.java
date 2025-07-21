package com.alzahraa.money.manegment.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alzahraa.money.manegment.dto.IncomeRequestDTO;
import com.alzahraa.money.manegment.dto.IncomeResponseDTO;
import com.alzahraa.money.manegment.entity.DonorEntity;
import com.alzahraa.money.manegment.entity.IncomeEntity;
import com.alzahraa.money.manegment.repository.DonorRepository;
import com.alzahraa.money.manegment.repository.IncomeRepository;
import com.alzahraa.money.manegment.service.IncomeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {

	@Autowired
	IncomeRepository incomeRepository;
	
	@Autowired
	DonorRepository donorRepository;

	@Override
	public IncomeResponseDTO createIncome(IncomeRequestDTO dto) {
		IncomeEntity income = new IncomeEntity();
		income.setAmount(dto.getAmount());
		income.setSourceType(dto.getSourceType());
		income.setDescription(dto.getDescription());
		income.setDateReceived(dto.getDateReceived());

		if (dto.getDonorId() != null) {
			DonorEntity donor = donorRepository.findById(dto.getDonorId())
					.orElseThrow(() -> new RuntimeException("Donor not found"));
			income.setDonor(donor);
		}

		IncomeEntity saved = incomeRepository.save(income);
		return mapToResponse(saved);
	}

	@Override
	public List<IncomeResponseDTO> getAllIncomes() {
		return incomeRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
	}

	@Override
	public IncomeResponseDTO getIncomeById(Long id) {
		IncomeEntity income = incomeRepository.findById(id).orElseThrow(() -> new RuntimeException("Income not found"));
		return mapToResponse(income);
	}

	@Override
	public void deleteIncome(Long id) {
		incomeRepository.deleteById(id);
	}

	private IncomeResponseDTO mapToResponse(IncomeEntity income) {
		  Long donorId = income.getDonor() != null ? income.getDonor().getId() : null;
		  String donorName = income.getDonor() != null ? income.getDonor().getFullName() : null;

		 return new IncomeResponseDTO(
			        income.getId(),
			        income.getAmount(),
			        income.getSourceType(),
			        income.getDescription(),
			        income.getDateReceived(),
			        donorId,
			        donorName
			    );
	}
}

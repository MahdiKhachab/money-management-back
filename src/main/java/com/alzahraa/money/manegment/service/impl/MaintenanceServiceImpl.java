package com.alzahraa.money.manegment.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alzahraa.money.manegment.dto.MaintenanceRequestDTO;
import com.alzahraa.money.manegment.dto.MaintenanceResponseDTO;
import com.alzahraa.money.manegment.entity.MaintenanceEntity;
import com.alzahraa.money.manegment.repository.MaintenanceRepository;
import com.alzahraa.money.manegment.service.MaintenanceService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements MaintenanceService {

	@Autowired
	private MaintenanceRepository maintenanceRepository;

	@Override
	public MaintenanceResponseDTO createMaintenance(MaintenanceRequestDTO dto) {
		MaintenanceEntity entity = new MaintenanceEntity();
		entity.setItemName(dto.getItemName());
		entity.setMaintenanceType(dto.getMaintenanceType());
		entity.setDate(dto.getDate());
		entity.setCost(dto.getCost());
		entity.setRemarks(dto.getRemarks());

		MaintenanceEntity saved = maintenanceRepository.save(entity);
		return mapToResponse(saved);
	}

	@Override
	public List<MaintenanceResponseDTO> getAllMaintenances() {
		return maintenanceRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
	}

	@Override
	public MaintenanceResponseDTO getMaintenanceById(Long id) {
		MaintenanceEntity entity = maintenanceRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Maintenance not found with id: " + id));
		return mapToResponse(entity);
	}

	@Override
	public void deleteMaintenance(Long id) {
		maintenanceRepository.deleteById(id);
	}

	private MaintenanceResponseDTO mapToResponse(MaintenanceEntity entity) {
		return new MaintenanceResponseDTO(entity.getId(), entity.getItemName(), entity.getMaintenanceType(),
				entity.getDate(), entity.getCost(), entity.getRemarks());
	}
}

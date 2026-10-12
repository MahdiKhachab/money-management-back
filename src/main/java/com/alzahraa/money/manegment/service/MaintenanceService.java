package com.alzahraa.money.manegment.service;

import java.util.List;

import com.alzahraa.money.manegment.dto.MaintenanceRequestDTO;
import com.alzahraa.money.manegment.dto.MaintenanceResponseDTO;

public interface MaintenanceService {
	MaintenanceResponseDTO createMaintenance(MaintenanceRequestDTO dto);

	List<MaintenanceResponseDTO> getAllMaintenances();

	MaintenanceResponseDTO getMaintenanceById(Long id);

	MaintenanceResponseDTO updateMaintenance(Long id, MaintenanceRequestDTO dto);

	void deleteMaintenance(Long id);
}

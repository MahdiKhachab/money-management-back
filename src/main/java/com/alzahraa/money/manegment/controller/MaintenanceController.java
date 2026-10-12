package com.alzahraa.money.manegment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alzahraa.money.manegment.dto.MaintenanceRequestDTO;
import com.alzahraa.money.manegment.dto.MaintenanceResponseDTO;
import com.alzahraa.money.manegment.service.MaintenanceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/maintenances")
@RequiredArgsConstructor
public class MaintenanceController {

	@Autowired
	private MaintenanceService maintenanceService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public MaintenanceResponseDTO createMaintenance(@RequestBody MaintenanceRequestDTO dto) {
		return maintenanceService.createMaintenance(dto);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MaintenanceResponseDTO> getAllMaintenances() {
		return maintenanceService.getAllMaintenances();
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public MaintenanceResponseDTO getMaintenanceById(@PathVariable Long id) {
		return maintenanceService.getMaintenanceById(id);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public MaintenanceResponseDTO updateMaintenance(@PathVariable Long id, @RequestBody MaintenanceRequestDTO dto) {
		return maintenanceService.updateMaintenance(id, dto);
	}

	@DeleteMapping("/{id}")
	public void deleteMaintenance(@PathVariable Long id) {
		maintenanceService.deleteMaintenance(id);
	}
}

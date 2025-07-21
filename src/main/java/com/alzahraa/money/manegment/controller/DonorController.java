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

import com.alzahraa.money.manegment.dto.DonorRequestDTO;
import com.alzahraa.money.manegment.dto.DonorResponseDTO;
import com.alzahraa.money.manegment.service.DonorService;


@RestController
@RequestMapping("/api/donors")
public class DonorController {

	@Autowired
	private DonorService donorService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DonorResponseDTO> createDonor(@RequestBody DonorRequestDTO donorDto) {
		return ResponseEntity.ok(donorService.createDonor(donorDto));
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DonorResponseDTO> getDonor(@PathVariable Long id) {
		return ResponseEntity.ok(donorService.getDonorById(id));
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DonorResponseDTO>> getAllDonors() {
		return ResponseEntity.ok(donorService.getAllDonors());
	}

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DonorResponseDTO> updateDonor(@PathVariable Long id, @RequestBody DonorRequestDTO donorDto) {
		return ResponseEntity.ok(donorService.updateDonor(id, donorDto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteDonor(@PathVariable Long id) {
		return ResponseEntity.ok(donorService.deleteDonor(id));
	}
}

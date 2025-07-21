package com.alzahraa.money.manegment.service;

import com.alzahraa.money.manegment.dto.DonorRequestDTO;
import com.alzahraa.money.manegment.dto.DonorResponseDTO;

import java.util.List;

public interface DonorService {
	
	DonorResponseDTO createDonor(DonorRequestDTO donorDto);

	DonorResponseDTO updateDonor(Long id, DonorRequestDTO donorDto);

	boolean deleteDonor(Long id);

	DonorResponseDTO getDonorById(Long id);

	List<DonorResponseDTO> getAllDonors();
}

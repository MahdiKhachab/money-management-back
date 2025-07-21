package com.alzahraa.money.manegment.service.impl;

import com.alzahraa.money.manegment.dto.DonorRequestDTO;
import com.alzahraa.money.manegment.dto.DonorResponseDTO;
import com.alzahraa.money.manegment.entity.DonorEntity;
import com.alzahraa.money.manegment.repository.DonorRepository;
import com.alzahraa.money.manegment.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonorServiceImpl implements DonorService {

    @Autowired
    private DonorRepository donorRepository;

    private DonorResponseDTO mapToDto(DonorEntity donor) {
        DonorResponseDTO dto = new DonorResponseDTO();
        dto.setId(donor.getId());
        dto.setFullName(donor.getFullName());
        dto.setOrganization(donor.getOrganization());
        dto.setPhone(donor.getPhone());
        dto.setEmail(donor.getEmail());
        return dto;
    }

    @Override
    public DonorResponseDTO createDonor(DonorRequestDTO dto) {
        DonorEntity donor = new DonorEntity();
        donor.setFullName(dto.getFullName());
        donor.setOrganization(dto.getOrganization());
        donor.setPhone(dto.getPhone());
        donor.setEmail(dto.getEmail());
        return mapToDto(donorRepository.save(donor));
    }

    @Override
    public DonorResponseDTO updateDonor(Long id, DonorRequestDTO dto) {
        DonorEntity donor = donorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DonorEntity not found"));
        donor.setFullName(dto.getFullName());
        donor.setOrganization(dto.getOrganization());
        donor.setPhone(dto.getPhone());
        donor.setEmail(dto.getEmail());
        return mapToDto(donorRepository.save(donor));
    }

    @Override
    public boolean deleteDonor(Long id) {
        if (!donorRepository.existsById(id)) {
            throw new RuntimeException("DonorEntity not found");
        }
        donorRepository.deleteById(id);
        return true;
    }

    @Override
    public DonorResponseDTO getDonorById(Long id) {
        DonorEntity donor = donorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DonorEntity not found"));
        return mapToDto(donor);
    }

    @Override
    public List<DonorResponseDTO> getAllDonors() {
        return donorRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
}

package com.alzahraa.money.manegment.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alzahraa.money.manegment.entity.IncomeEntity;

public interface IncomeRepository extends JpaRepository<IncomeEntity, Long> {
	
	List<IncomeEntity> findByDateReceivedBetween(LocalDate start, LocalDate end);

}

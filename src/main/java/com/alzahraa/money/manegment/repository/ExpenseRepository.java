package com.alzahraa.money.manegment.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alzahraa.money.manegment.entity.ExpenseEntity;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {
	
	List<ExpenseEntity> findByDateSpentBetween(LocalDate start, LocalDate end);

	
}

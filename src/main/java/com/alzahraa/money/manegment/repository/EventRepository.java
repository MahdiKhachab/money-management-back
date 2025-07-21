package com.alzahraa.money.manegment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alzahraa.money.manegment.entity.IncomeEntity;

public interface EventRepository extends JpaRepository<IncomeEntity, Long> {
}

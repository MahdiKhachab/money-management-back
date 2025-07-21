package com.alzahraa.money.manegment.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alzahraa.money.manegment.entity.MaintenanceEntity;

public interface MaintenanceRepository extends JpaRepository<MaintenanceEntity, Long> {

	List<MaintenanceEntity> findByDateBetween(LocalDate start, LocalDate end);

}

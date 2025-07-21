package com.alzahraa.money.manegment.entity;

import java.time.LocalDate;


import com.alzahraa.money.manegment.enums.MaintenanceTypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_Maintenances")
public class MaintenanceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "item_name", length = 100, nullable = false)
	private String itemName;

	@Enumerated(EnumType.STRING)
	@Column(name = "maintenance_type", length = 30, nullable = false)
	private MaintenanceTypeEnum maintenanceType;

	@Column(nullable = false)
	private LocalDate date;

	@Column(nullable = false)
	private Double cost;

	@Column(length = 255)
	private String remarks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public MaintenanceTypeEnum getMaintenanceType() {
		return maintenanceType;
	}

	public void setMaintenanceType(MaintenanceTypeEnum maintenanceType) {
		this.maintenanceType = maintenanceType;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}

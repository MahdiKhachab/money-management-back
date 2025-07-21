package com.alzahraa.money.manegment.dto;

import java.time.LocalDate;

import com.alzahraa.money.manegment.enums.MaintenanceTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceResponseDTO {
	private Long id;
	private String itemName;
	private MaintenanceTypeEnum maintenanceType;
	private LocalDate date;
	private Double cost;
	private String remarks;

	public MaintenanceResponseDTO(Long id, String itemName, MaintenanceTypeEnum maintenanceType, LocalDate date,
			Double cost, String remarks) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.maintenanceType = maintenanceType;
		this.date = date;
		this.cost = cost;
		this.remarks = remarks;
	}

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

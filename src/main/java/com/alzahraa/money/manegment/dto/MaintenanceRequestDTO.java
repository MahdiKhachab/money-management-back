package com.alzahraa.money.manegment.dto;

import java.time.LocalDate;

import com.alzahraa.money.manegment.enums.MaintenanceTypeEnum;

 
public class MaintenanceRequestDTO {
	private String itemName;
	private MaintenanceTypeEnum maintenanceType;
	private LocalDate date;
	private Double cost;
	private String remarks;

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

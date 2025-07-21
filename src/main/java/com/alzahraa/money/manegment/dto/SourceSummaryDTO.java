package com.alzahraa.money.manegment.dto;

import com.alzahraa.money.manegment.enums.IncomeSourceTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SourceSummaryDTO {
	
	private IncomeSourceTypeEnum sourceType;
	
	private double totalAmount;

	public SourceSummaryDTO(IncomeSourceTypeEnum sourceType, double totalAmount) {
		super();
		this.sourceType = sourceType;
		this.totalAmount = totalAmount;
	}

	public IncomeSourceTypeEnum getSourceType() {
		return sourceType;
	}

	public void setSourceType(IncomeSourceTypeEnum sourceType) {
		this.sourceType = sourceType;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}

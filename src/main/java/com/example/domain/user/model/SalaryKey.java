package com.example.domain.user.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class SalaryKey implements Serializable {
	private String userId;
	private String yearMonth;
	
	public SalaryKey (String userId, String yearMonth) {
		this.setUserId(userId);
		this.setYearMonth(yearMonth);
	}
}

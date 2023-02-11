package com.example.form;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SalaryForm {

	@NotBlank(groups = ValidGroup1.class)
	private String userId;

	@NotBlank(groups = ValidGroup1.class)
	private Integer salary;
	
	@NotBlank(groups = ValidGroup1.class)
	private String year;
	
	@NotBlank(groups = ValidGroup1.class)
	private String month;
}

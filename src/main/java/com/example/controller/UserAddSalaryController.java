package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.SalaryForm;

@Controller
@RequestMapping("/addSalary")
public class UserAddSalaryController {
	
	@GetMapping()
	public String getAddSalary(@ModelAttribute SalaryForm form) {
		
		return "user/addSalary";
	}
}

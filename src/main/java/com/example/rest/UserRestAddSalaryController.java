package com.example.rest;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.user.model.Salary;
import com.example.domain.user.model.SalaryKey;
import com.example.domain.user.service.UserService;
import com.example.form.SalaryForm;

@RestController
@RequestMapping("/addSalary")
public class UserRestAddSalaryController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageSource messageSource;

	@PostMapping("/insert")
	public RestResult isnertSalary(SalaryForm form, BindingResult bindingResult, Locale locale) {

		if(bindingResult.hasErrors()) {
			Map<String, String> errors = new HashMap<>();

			for(FieldError error: bindingResult.getFieldErrors()) {
				String message = messageSource.getMessage(error, locale);
				errors.put(error.getField(), message);
			}

			return new RestResult(90, errors);
		}
		
		String yearMonth = form.getYear() + "/" + form.getMonth();
		String userId = form.getUserId();
		SalaryKey salaryKey = new SalaryKey(userId,yearMonth);
		Integer salaryValue = (Integer)form.getSalary();
		Salary salary = new Salary(salaryKey,salaryValue);
		
		
		userService.insertSalaryOne(salary);
		int i = 1;
		return new RestResult(90, null);
		
	}

}

package com.spring.bean.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spring.bean.Employee;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeFormValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Employee.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeName",
				"name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeEmail",
				"email.required");

	}

}

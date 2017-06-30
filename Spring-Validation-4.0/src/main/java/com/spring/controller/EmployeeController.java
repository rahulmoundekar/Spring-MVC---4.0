package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.spring.bean.Employee;
import com.spring.bean.validator.EmployeeFormValidator;

import javax.validation.Valid;

@Controller
public class EmployeeController {

	@RequestMapping(method = RequestMethod.GET, value = "/addEmployee")
	public ModelAndView helloWorld(ModelMap model) {
		Employee employeeForm = new Employee();
		model.addAttribute("employeeForm", employeeForm);
		System.out.println("sdkjhajhd");
		return new ModelAndView("addEmployeeForm");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/saveEmployee")
	public ModelAndView saveFrom(
			ModelMap model,
			@ModelAttribute(value = "employeeForm") @Valid Employee employeeForm,
			BindingResult result) {

		if (result.hasErrors()) {

			return new ModelAndView("addEmployeeForm");
		}
		model.addAttribute("employeeForm", employeeForm);
		return new ModelAndView("addEmployeeForm");
	}

	@InitBinder("employeeForm")
	public void formInitBinder(WebDataBinder webDataBinder) {
		final EmployeeFormValidator employeeFormValidator = new EmployeeFormValidator();
		webDataBinder.setValidator(employeeFormValidator);
	}

}

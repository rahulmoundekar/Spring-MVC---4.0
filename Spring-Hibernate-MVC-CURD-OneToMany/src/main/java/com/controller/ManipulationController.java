package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Address;
import com.model.Student;
import com.service.ManipulationService;

@Controller
public class ManipulationController {
	@Autowired
	ManipulationService manipulationService;

	@RequestMapping(value = "/index")
	public String redirect(Model model) {
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(new Address());
		addresses.add(new Address());
		Student student = new Student();
		student.setAddresses(addresses);
		model.addAttribute("studentForm", student);
		return "welcome";
	}

	@RequestMapping(value = "/insert")
	public String insertform(Model model,
			@ModelAttribute("studentForm") @Valid Student student,
			BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("studentForm", student);
			return "welcome";
		} else {
			Student student2 = new Student();
			if (student.getId() == 0) {
				student2.setName(student.getName());
				student2.setMobile(student.getMobile());
				List<Address> list = new ArrayList<Address>();
				List<Address> alist = student.getAddresses();
				for (Address address : alist) {
					Address address2 = new Address();
					address2.setAddress(address.getAddress());
					address2.setStudent(student2);
					list.add(address2);
				}
				student2.setAddresses(list);
			} else {
				student2.setId(student.getId());
				student2.setName(student.getName());
				student2.setMobile(student.getMobile());
				List<Address> list = new ArrayList<Address>();
				List<Address> alist = student.getAddresses();
				for (Address address : alist) {
					Address address2 = new Address();
					address2.setAid(address.getAid());
					address2.setAddress(address.getAddress());
					address2.setStudent(student2);
					list.add(address2);
				}
				student2.setAddresses(list);
			}
			manipulationService.addStudent(student2);
			List<Address> addresses = new ArrayList<Address>();
			addresses.add(new Address());
			addresses.add(new Address());
			Student student3 = new Student();
			student3.setAddresses(addresses);
			model.addAttribute("studentForm", student3);
			model.addAttribute("studentFormList", getStudentList());
			return "welcome";
		}
	}

	@ModelAttribute("studentFormList")
	public List<Student> getStudentList() {
		return manipulationService.getStudentList();

	}

	@RequestMapping(value = "/edit")
	public String Edit(Model model, @RequestParam Integer id) {
		Student student2 = manipulationService.editStudent(id);
		model.addAttribute("studentForm", student2);
		return "welcome";
	}

	@RequestMapping(value = "/delete")
	public String delete(Model model, @RequestParam Integer id) {
		manipulationService.deleteStudent(id);
		model.addAttribute("studentForm", new Student());
		model.addAttribute("studentFormList",
				manipulationService.getStudentList());
		return "redirect:index.htm";
	}
}
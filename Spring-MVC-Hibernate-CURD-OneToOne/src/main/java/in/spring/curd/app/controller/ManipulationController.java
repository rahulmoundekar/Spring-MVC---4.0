package in.spring.curd.app.controller;

import in.spring.curd.app.bean.PanCard;
import in.spring.curd.app.bean.Student;
import in.spring.curd.app.service.ManipulationService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ManipulationController {
	
	@Autowired
	ManipulationService manipulationService;

	@RequestMapping(value = "/index")
	public String redirect(Model model) {
		Student student = new Student();
		student.setPanCard(new PanCard());
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

				PanCard panCard = new PanCard();
				panCard.setPanNumber(student.getPanCard().getPanNumber());
				panCard.setStudent(student2);
				student2.setPanCard(panCard);
			} else {
				student2.setId(student.getId());
				student2.setName(student.getName());
				student2.setMobile(student.getMobile());

				PanCard panCard = new PanCard();
				panCard.setId(student.getPanCard().getId());
				panCard.setStudent(student2);
				panCard.setPanNumber(student.getPanCard().getPanNumber());

				student2.setPanCard(panCard);
			}
			manipulationService.addStudent(student2);
			model.addAttribute("studentFormList", getStudentList());
			return "redirect:index.htm";
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
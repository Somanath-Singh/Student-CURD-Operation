package com.mgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mgmt.entity.Student;
import com.mgmt.repo.IStudentMgmtRepo;
import com.mgmt.service.IStudentMgmtService;

@Controller
public class HomeController {
	
	@Autowired
	private IStudentMgmtService stuService;
	
	@Autowired
	private IStudentMgmtRepo stuRepo;
	
	@GetMapping("/")
	public String getHome(Model m) {	
		
		m.addAttribute("student",stuService.getAllStudent());
		
		return "Home";
		
	}
	
	@GetMapping("/registerForm")
	public String addStudent() {	
		
		return "AddStudent";
		
	}
	
	 
	@PostMapping("/register")
	public String processData(@ModelAttribute("student") Student student) {
		
		//store the data into database
		
		stuService.addStudent(student);
		
		return "details";
		
	}
	
	@GetMapping("/{redgno}/edit")
	public String editStudent(Model m,@PathVariable("redgno")String rno) {
		
		m.addAttribute("student",stuRepo.findByRedgno(rno));
		
		return "EditStudent";
		
	}
	
	@PostMapping("/edit")
	public String processEdit(@ModelAttribute("student")Student student) {
		
		
		Student stu=stuRepo.findById(student.getId()).get();
		
		System.out.println(student.getId());
		
		System.out.println(student.getRedgno());
		
		stu.setName(student.getName());
		
		stu.setRedgno(student.getRedgno());
		
		stu.setAddress(student.getAddress());
		
		stu.setRelation(student.getRelation());
		
		stu.setGuardianName(student.getGuardianName());
		
		//store the edited data into database
		
				stuRepo.save(stu);
				
				return "details";
				
	}
	
	
	@GetMapping("/{id}/delete")
	public String deleteStudent(@PathVariable("id")int sId) {
		
		stuRepo.deleteById(sId);
		
		return "Delete";
		
	}

}

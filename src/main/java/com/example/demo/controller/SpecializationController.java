package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Specialization;
import com.example.demo.repository.SpecializationRepository;

@Controller
public class SpecializationController {
	@Autowired
	private SpecializationRepository repo;

	@GetMapping("/specializationForm")
	public String getSpecialization() {
		return "specialization";
	}
	
	@PostMapping("/SpecializationData")
	public String postSpecialization(@ModelAttribute Specialization specialization, Model model) {
		if(specialization != null) {
			repo.save(specialization);
			model.addAttribute("message","Success !!");
			return "specialization";
		}else {
			model.addAttribute("message","Failed !!");
			return "specialization";
			
		}
	}

}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;


@Controller
public class PatientController {
	
	@Autowired
	private PatientRepository repo;
	
	@GetMapping("/patientForm")
	public String getPatient() {
		return "patient";
	}
	
	@PostMapping("/PatientData")
	public String postPatient(@ModelAttribute Patient patient, Model model) {
		if(patient !=null) {
			repo.save(patient);
			model.addAttribute("message","AddSuccess !!");
			return "patient";
		}else {
			model.addAttribute("message","Failed !!");
			return "patient";
		}
	}
	
	

}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;

@Controller
public class DoctorController {
	@Autowired
	private DoctorRepository repo;

	@GetMapping("/doctorForm")
	public String getDoctor() {
		return "doctor";
	}

	@PostMapping("/DoctorData")
	public String postDoctor(@ModelAttribute Doctor doctor, Model model) {
		if (doctor != null) {
			repo.save(doctor);
			model.addAttribute("message", "Succes !!");
			return "redirect:/doctorForm";
		} else {
			model.addAttribute("message", "Failed !!");
			return "redirect:/doctorForm";

		}

	}
	
	public List<Doctor> getAllDoctor(){
		return repo.findAll();
	}

}

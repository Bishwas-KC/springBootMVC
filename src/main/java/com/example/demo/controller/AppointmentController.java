package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Appointment;
import com.example.demo.repository.AppointmentRepository;

@Controller
public class AppointmentController {

	@Autowired
	private AppointmentRepository repo;

	@Autowired
	private DoctorController doctorService;

	@GetMapping("/appointmentForm")
	public String getAppointment(Model model) {
		model.addAttribute("dlist", doctorService.getAllDoctor());
		return "appointment";
	}

	@PostMapping("/appointmentData")
	public String postAppointment(@ModelAttribute Appointment appointment, Model model) {
		repo.save(appointment);
		model.addAttribute("message","AddSuccess !!");
		return "appointment";
	}

}

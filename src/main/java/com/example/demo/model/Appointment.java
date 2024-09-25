package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Doctor doctor;
	private LocalDate date;
	private String noOfSlots;
	private String details;
	private int consultationFee;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getNoOfSlots() {
		return noOfSlots;
	}
	public void setNoOfSlots(String noOfSlots) {
		this.noOfSlots = noOfSlots;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getConsultationFee() {
		return consultationFee;
	}
	public void setConsultationFee(int consultationFee) {
		this.consultationFee = consultationFee;
	}


}

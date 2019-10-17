package com.hospital.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.app.services.IAdmissionsService;

@RestController
@RequestMapping("/api/admissions")
public class AdmissionsController {
	
	
	@Autowired
	private IAdmissionsService admissionsService;
	
	
	@GetMapping(value = "/getAllAdmissions")
	public void getAllAdmissions() {
		
		System.out.println(admissionsService.getAllAdmissions().toString());
		
		
	}
	
	@PostMapping(path = "/createAdmission")
	public void createAdmission() {
		
		
		
	}
	
	@PostMapping(path = "/createExternalAdmission")
	public void createExternalAdmission() {
		
		
		
	}
	
	@PutMapping(path = "/updateAdmission")
	public void updateAdmission() {
		
		
		
	}
	
	@GetMapping(path = "/getAdmissionItem")
	public void getAdmissionItem() {
		
		
		
	}
	
	@DeleteMapping(path = "/deleteAdmission")
	public void deleteAdmission() {
		
		
		
	}
	

}

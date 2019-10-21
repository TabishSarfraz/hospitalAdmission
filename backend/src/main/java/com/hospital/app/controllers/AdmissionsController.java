package com.hospital.app.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.aspectj.weaver.patterns.ParserException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.app.domain.Admissions;
import com.hospital.app.domain.Category;
import com.hospital.app.domain.Patient;
import com.hospital.app.dto.AdmissionsDTO;
import com.hospital.app.dto.CategoryDTO;
import com.hospital.app.services.IAdmissionsService;

@RestController 
@CrossOrigin
@RequestMapping("/api/admissions")
public class AdmissionsController {
	
	
	@Autowired
	private IAdmissionsService admissionsService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping(value = "/getAllAdmissions")
	public List<AdmissionsDTO> getAllAdmissions() {
		

		List<Admissions> admissions = admissionsService.getAllAdmissions();
			
		if(admissions != null) {
		
			List<AdmissionsDTO> admissionsDto  = admissions.stream()
													.map( admissionItem -> convertToDto(admissionItem))
													.collect(Collectors.toList());
			
			return admissionsDto;
			
		}
		 
		 return null;
		
	}
	
	@GetMapping(path = "/getAdmissionItem")
	public ResponseEntity<?> getAdmissionItem(@RequestParam(value = "id") Integer id) {
		
		Admissions admissionItem = admissionsService.getAdmissionsItem(id);
		
		AdmissionsDTO admissionsDto = new AdmissionsDTO();
		
		if(admissionItem != null) {
			
			admissionsDto = convertToDto(admissionItem);
			
			return  new ResponseEntity<AdmissionsDTO>(admissionsDto, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Admission item not found", HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping(path = "/createAdmission", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createAdmission( @RequestBody AdmissionsDTO admissionsDto) {
		
		System.out.println(admissionsDto.getCategory().toString());
		System.out.println(admissionsDto.getPatient().toString());
		
		Admissions admissions = convertToEntity(admissionsDto);
		
		boolean result = admissionsService.createAdmission(admissions);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/createExternalAdmission", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createExternalAdmission(@Valid @RequestBody AdmissionsDTO admissionsDto) {
		
		Admissions admissions = convertToEntity(admissionsDto);
		
		boolean result = admissionsService.createAdmission(admissions);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@PutMapping(path = "/updateAdmission")
	public ResponseEntity<?> updateAdmission(@RequestBody AdmissionsDTO admissionsDto) {
		
		Admissions admissions = convertToEntity(admissionsDto);
		
		boolean result = admissionsService.updateAdmission(admissions);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	@DeleteMapping(path = "/deleteAdmission")
	public ResponseEntity<?>  deleteAdmission(@RequestParam(value = "id") Integer id) {
		
		boolean result = admissionsService.deleteAdmission(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/getCategories")
	public List<CategoryDTO> getCategories() {
		

		List<Category> categories = admissionsService.getAdmissionsCategories();
			
		if(categories != null) {
		
			List<CategoryDTO> categoriesDto  = categories.stream()
													.map( categoriesItem -> 
														modelMapper.map(categoriesItem, CategoryDTO.class))
													.collect(Collectors.toList());
			
			return categoriesDto;
			
		}
		 
		 return null;
		
	}
	
	
	private AdmissionsDTO convertToDto(Admissions admissions) {
		
		AdmissionsDTO admissionsDto = modelMapper.map(admissions, AdmissionsDTO.class);
		
		return admissionsDto;
		
	}
	
	private Admissions convertToEntity(AdmissionsDTO admissionsDto) throws ParserException{
		
		modelMapper.typeMap(AdmissionsDTO.class, Admissions.class )
		.addMappings(mapper -> {

			mapper.map(src -> src.getPatient(), Admissions::setPatientID);
			mapper.map(src -> src.getCategory(), Admissions::setCategoryID);
			
		});
		
		Admissions admissions = modelMapper.map(admissionsDto, Admissions.class);
		
		return admissions;
		
	}
	
	

}

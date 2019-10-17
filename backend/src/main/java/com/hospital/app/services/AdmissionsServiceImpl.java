package com.hospital.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.app.domain.Admissions;
import com.hospital.app.repositories.IAdmissionRepository;
import com.hospital.app.repositories.ICateogoryRepository;
import com.hospital.app.repositories.IPatientRepository;

@Service
public class AdmissionsServiceImpl implements IAdmissionsService {
	
	
	@Autowired
	private IAdmissionRepository admissionsRepo;
	
	@Autowired
	private ICateogoryRepository categoryRepo;
	
	@Autowired
	private IPatientRepository patientRepo;
	

	@Override
	public List<Admissions> getAllAdmissions() {
		
		List<Admissions> admissionsList = admissionsRepo.findAll();
		
		return admissionsList;

	}

	@Override
	public void createAdmission() {
		

	}

	@Override
	public void createExternalAdmission() {
		

	}

	@Override
	public void updateAdmission() {
		

	}

	@Override
	public void getAdmissionsItem() {
		

	}

	@Override
	public void deleteAdmission() {
		

	}

}

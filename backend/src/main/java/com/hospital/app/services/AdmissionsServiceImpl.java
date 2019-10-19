package com.hospital.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.app.domain.Admissions;
import com.hospital.app.domain.Patient;
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
	public Admissions getAdmissionsItem(Integer id) {
		
		Admissions admission = admissionsRepo.findById(id);
		
		return admission;

	}

	@Override
	public boolean createAdmission(Admissions admission) {
		
		Patient patient = admission.getPatientID();
		
		Patient patientOld = findSinglePatient(patient);
		
		if(patientOld!= null && patientOld.getFirstName() != null && patientOld.getId() != null  ) {
			
			admission.setPatientID(patientOld);
			
			admissionsRepo.save(admission);
			
		}else {
			
			patient = patientRepo.save(patient);
			
			patient = findSinglePatient(patient);
			
			admission.setPatientID(patient);
			
			admissionsRepo.save(admission);
			
		}
		
		return true;
		
	}


	@Override
	public boolean updateAdmission(Admissions admission) {
		
		Patient patient = admission.getPatientID();
		
		Patient patientOld = findSinglePatient(patient);
		
		patientOld.setGender(patient.getGender());
		
		patient = patientRepo.save(patientOld);
		
		admission.setPatientID(patient);
		
		admissionsRepo.save(admission);
			
		return true;

	}



	@Override
	@Transactional
	public boolean deleteAdmission(Integer id) {
		
		admissionsRepo.deleteById(id);
		
		return true;
		
	}
	
	private Patient findSinglePatient(Patient patient) {
		
		return patientRepo.findByFirstNameAndLastNameAndDateBirth(
				patient.getFirstName(), 
				patient.getLastName(),
				patient.getDateBirth()
				);
		
	}
	
}

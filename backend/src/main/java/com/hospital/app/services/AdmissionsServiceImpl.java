package com.hospital.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.app.domain.Admissions;
import com.hospital.app.domain.Category;
import com.hospital.app.domain.Patient;
import com.hospital.app.repositories.IAdmissionRepository;
import com.hospital.app.repositories.ICategoryRepository;
import com.hospital.app.repositories.IPatientRepository;
import java.util.Date;

@Service
public class AdmissionsServiceImpl implements IAdmissionsService {
	
	
	@Autowired
	private IAdmissionRepository admissionsRepo;
	
	@Autowired
	private ICategoryRepository categoryRepo;
	
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
		
		Category category = categoryRepo.findByName(admission.getCategoryID().getName());
		
		if(patientOld!= null && patientOld.getFirstName() != null && patientOld.getId() != null 
			&& category != null & category.getName() != null & category.getId()!= null) {
			
			patientOld.setGender(patient.getGender());
			admission.setPatientID(patientOld);
			admission.setCategoryID(category);
			admission.setDateAdmission(new Date());
                        
			admissionsRepo.save(admission);
			
		}else {
			
			if(category == null) {
			
				return false;
				
			}else {
			
			patient = patientRepo.save(patient);
			
			patient = findSinglePatient(patient);
			
			admission.setPatientID(patient);
            admission.setCategoryID(category);
            admission.setDateAdmission(new Date());

			admissionsRepo.save(admission);
			
			}
			
		}
		
		return true;
		
	}


	@Override
	public boolean updateAdmission(Admissions admission) {
		
		Patient patient = admission.getPatientID();
		
		Patient patientOld = findSinglePatient(patient);
		
		Category category = categoryRepo.findByName(admission.getCategoryID().getName());

		patientOld.setGender(patient.getGender());
		
		patient = patientRepo.save(patientOld);
		
		admission.setPatientID(patient);
        admission.setCategoryID(category);
		
		admissionsRepo.save(admission);
			
		return true;

	}

	@Override
	@Transactional
	public boolean deleteAdmission(Integer id) {
		
		admissionsRepo.deleteById(id);
		
		return true;
		
	}
	
	@Override
	public List<Category> getAdmissionsCategories() {
		
		List<Category> categoryList = categoryRepo.findAll();
		
		return categoryList;

	}
	
	
	private Patient findSinglePatient(Patient patient) {
		
		return patientRepo.findByFirstNameAndLastNameAndDateBirth(
				patient.getFirstName(), 
				patient.getLastName(),
				patient.getDateBirth()
				);
		
	}
	
}

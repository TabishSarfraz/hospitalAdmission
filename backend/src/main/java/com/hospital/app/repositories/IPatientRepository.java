package com.hospital.app.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hospital.app.domain.Patient;


@Repository
public interface IPatientRepository extends CrudRepository<Patient, Long> {
	
	List<Patient> findAll();
	
	List<Patient> findById(Integer id);
	
	List<Patient> findByFirstNameAndLastNameAndDateBirth(String firstName, String lastName, Date dateBirth);
	

}

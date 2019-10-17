/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.app.repositories;

import com.hospital.app.domain.Admissions;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tabish Sarfraz
 */

@Repository
public interface IAdmissionRepository extends CrudRepository<Admissions, Long>{
    
	
	List<Admissions> findAll();
	
	Admissions findById(Integer id);
	
    
}

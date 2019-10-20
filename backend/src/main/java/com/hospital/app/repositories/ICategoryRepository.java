package com.hospital.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hospital.app.domain.Category;

@Repository
public interface ICategoryRepository extends CrudRepository<Category, Long> {

	List<Category> findAll();
	
	Category findById(Integer id);
	
	Category findByName(String name);
	
}

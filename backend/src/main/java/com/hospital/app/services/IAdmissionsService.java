package com.hospital.app.services;

import java.util.List;

import com.hospital.app.domain.Admissions;

public interface IAdmissionsService {
	
	public abstract List<Admissions> getAllAdmissions();
	
	public abstract Admissions getAdmissionsItem(Integer id);
	
	public abstract boolean createAdmission(Admissions admissions);
	
	public abstract boolean updateAdmission(Admissions admissions);

	public abstract boolean deleteAdmission(Integer id);

}

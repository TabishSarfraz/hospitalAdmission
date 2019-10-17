package com.hospital.app.services;

import java.util.List;

import com.hospital.app.domain.Admissions;

public interface IAdmissionsService {
	
	public abstract List<Admissions> getAllAdmissions();
	public abstract void createAdmission();
	public abstract void createExternalAdmission();
	public abstract void updateAdmission();
	public abstract void getAdmissionsItem();
	public abstract void deleteAdmission();

}

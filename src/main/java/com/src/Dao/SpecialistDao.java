package com.src.Dao;

import java.util.List;

import com.src.model.Specialist;

public interface SpecialistDao {
	public boolean addSpecialist(String sp);
	public List<Specialist> getAllSpecialist();

}

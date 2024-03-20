package com.src.service;

import java.util.List;

import com.src.Dao.SpecialistDao;
import com.src.Dao.SpecialistDaoImple;
import com.src.model.Specialist;

public class SpecialistServiceImple implements SpecialistService {
	SpecialistDao sdao = new SpecialistDaoImple();

	@Override
	public boolean addSpecialist(String sp) {
		// TODO Auto-generated method stub
		return sdao.addSpecialist(sp);
	}

	@Override
	public List<Specialist> getAllSpecialist() {
		// TODO Auto-generated method stub
		return sdao.getAllSpecialist();
	}

}

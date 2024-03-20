package com.src.service;

import java.util.List;

import com.src.Dao.DoctorDao;
import com.src.Dao.DoctorDaoImple;
import com.src.model.Doctor;

public class DoctorServiceImple implements DoctorService {
	DoctorDao ddao = new DoctorDaoImple();
	@Override
	public boolean registerDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return ddao.registerDoctor(doctor);
	}

	@Override
	public List<Doctor> getAllDoctor() {
		// TODO Auto-generated method stub
		return ddao.getAllDoctor();
	}

	@Override
	public Doctor getDoctorById(int id) {
		// TODO Auto-generated method stub
		return ddao.getDoctorById(id);
	}

	@Override
	public boolean updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return ddao.updateDoctor(doctor);
	}

	@Override
	public boolean deleteDoctorById(int id) {
		// TODO Auto-generated method stub
		return ddao.deleteDoctorById(id);
	}

	@Override
	public Doctor loginDoctor(String email, String password) {
		// TODO Auto-generated method stub
		return ddao.loginDoctor(email, password);
	}

	@Override
	public int countTotalDoctor() {
		// TODO Auto-generated method stub
		return ddao.countTotalDoctor();
	}

	@Override
	public int countTotalAppointment() {
		// TODO Auto-generated method stub
		return ddao.countTotalAppointment();
	}

	@Override
	public int countTotalAppointmentByDoctorId(int doctorId) {
		// TODO Auto-generated method stub
		return ddao.countTotalAppointmentByDoctorId(doctorId);
	}

	@Override
	public int countTotalUser() {
		// TODO Auto-generated method stub
		return ddao.countTotalUser();
	}

	@Override
	public int countTotalSpecialist() {
		// TODO Auto-generated method stub
		return ddao.countTotalSpecialist();
	}

	@Override
	public boolean checkOldPassword(int doctorId, String oldPassword) {
		// TODO Auto-generated method stub
		return ddao.checkOldPassword(doctorId, oldPassword);
	}

	@Override
	public boolean changePassword(int doctorId, String newPassword) {
		// TODO Auto-generated method stub
		return ddao.changePassword(doctorId, newPassword);
	}

	@Override
	public boolean editDoctorProfile(Doctor doctor) {
		// TODO Auto-generated method stub
		return ddao.editDoctorProfile(doctor);
	}

}

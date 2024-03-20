package com.src.service;

import java.util.List;

import com.src.Dao.AppointmentDao;
import com.src.Dao.AppointmentDaoImple;
import com.src.model.Appointment;

public class AppointmentServiceImple implements AppointmentService {
	AppointmentDao adao = new AppointmentDaoImple();

	@Override
	public boolean addAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return adao.addAppointment(appointment);
	}

	@Override
	public List<Appointment> getAllAppointmentByLoginUser(int userId) {
		// TODO Auto-generated method stub
		return adao.getAllAppointmentByLoginUser(userId);
	}

	@Override
	public List<Appointment> getAllAppointmentByLoginDoctor(int doctorId) {
		// TODO Auto-generated method stub
		return adao.getAllAppointmentByLoginDoctor(doctorId);
	}

	@Override
	public Appointment getAppointmentById(int id) {
		// TODO Auto-generated method stub
		return adao.getAppointmentById(id);
	}

	@Override
	public boolean updateDrAppointmentCommentStatus(int apptId, int docId, String comment) {
		// TODO Auto-generated method stub
		return adao.updateDrAppointmentCommentStatus(apptId, docId, comment);
	}

	@Override
	public List<Appointment> getAllAppointment() {
		// TODO Auto-generated method stub
		return adao.getAllAppointment();
	}

}

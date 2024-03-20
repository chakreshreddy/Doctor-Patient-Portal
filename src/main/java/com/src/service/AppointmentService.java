package com.src.service;

import java.util.List;

import com.src.model.Appointment;

public interface AppointmentService {
	public boolean addAppointment(Appointment appointment);
	public List<Appointment> getAllAppointmentByLoginUser(int userId);
	public List<Appointment> getAllAppointmentByLoginDoctor(int doctorId);
	public Appointment getAppointmentById(int id);
	public boolean updateDrAppointmentCommentStatus(int apptId, int docId, String comment);
	public List<Appointment> getAllAppointment();

}

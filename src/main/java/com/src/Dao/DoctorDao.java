package com.src.Dao;

import java.util.List;

import com.src.model.Doctor;

public interface DoctorDao {
	public boolean registerDoctor(Doctor doctor);
	public List<Doctor> getAllDoctor();
	public Doctor getDoctorById(int id);
	public boolean updateDoctor(Doctor doctor);
	public boolean deleteDoctorById(int id);
	public Doctor loginDoctor(String email, String password);
	public int countTotalDoctor();
	public int countTotalAppointment();
	public int countTotalAppointmentByDoctorId(int doctorId);
	public int countTotalUser();
	public int countTotalSpecialist();
	public boolean checkOldPassword(int doctorId, String oldPassword);
	public boolean changePassword(int doctorId, String newPassword);
	public boolean editDoctorProfile(Doctor doctor);

}

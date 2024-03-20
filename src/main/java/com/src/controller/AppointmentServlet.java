package com.src.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.src.Dao.AppointmentDao;
import com.src.Dao.AppointmentDaoImple;
import com.src.model.Appointment;

/**
 * Servlet implementation class AppointmentServlet
 */
public class AppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId	= Integer.parseInt(req.getParameter("userId"));
		String fullName = req.getParameter("fullName");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String appointmentDate = req.getParameter("appointmentDate");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String diseases = req.getParameter("diseases");
		int doctorId = Integer.parseInt(req.getParameter("doctorNameSelect"));
		String address = req.getParameter("address");
		
		
		Appointment appointment = new Appointment(userId, doctorId, fullName, gender, age, appointmentDate, email, phone, diseases, doctorId, address, "Pending");
		
		AppointmentDao appointmentDAO = new AppointmentDaoImple();
		boolean f = appointmentDAO.addAppointment(appointment);
		
		//get session
		HttpSession session = req.getSession();
		
		if(f==true) {
			
			session.setAttribute("successMsg", "Appointment is recorded Successfully.");
			resp.sendRedirect("user_appointment.jsp");
			
			
		}
		else {
			
			session.setAttribute("errorMsg", "Something went wrong on server!");
			resp.sendRedirect("user_appointment.jsp");
			
		}
	}

}

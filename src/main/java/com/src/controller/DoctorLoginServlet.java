package com.src.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.src.Dao.DoctorDao;
import com.src.Dao.DoctorDaoImple;
import com.src.model.Doctor;

/**
 * Servlet implementation class DoctorLoginServlet
 */
public class DoctorLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorLoginServlet() {
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

			//get email and password which is coming from doctor_login.jsp page
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			//create session
			HttpSession session = req.getSession();

			//create DB connection
			DoctorDao docDAO = new DoctorDaoImple();
			
			//call loginDoctor() method for doctor login which method declared in DoctorDAO 
			Doctor doctor = docDAO.loginDoctor(email, password);

			if (doctor != null) {
				//means doctor is valid or exist
				//then store particular logged in doctor object in session
				session.setAttribute("doctorObj", doctor);
				//and redirect the particular doctor index page which is reside doctor folder
				resp.sendRedirect("doctor/index.jsp");//doctor index means dashboard of doctors
			} else {
				session.setAttribute("errorMsg", "Invalid email or password");
				resp.sendRedirect("doctor_login.jsp");
			}
	}

}

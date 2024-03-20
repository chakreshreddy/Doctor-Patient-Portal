package com.src.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.src.Dao.AppointmentDao;
import com.src.Dao.AppointmentDaoImple;

/**
 * Servlet implementation class UpdateStatusServlet
 */
public class UpdateStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStatusServlet() {
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
		try {
			
			 int 	id = Integer.parseInt(req.getParameter("id"));
			 int 	doctorId = Integer.parseInt(req.getParameter("doctorId"));
			 String comment = req.getParameter("comment");
			 
			 AppointmentDao appDAO = new AppointmentDaoImple();
			 boolean f = appDAO.updateDrAppointmentCommentStatus(id, doctorId, comment);
			 
			 HttpSession session = req.getSession();
			 
			 
			 if(f == true) {
				 session.setAttribute("successMsg", "Comment updated");
				 resp.sendRedirect("doctor/patient.jsp");
				 
			 }else {
				 
				 session.setAttribute("errorMsg", "Something went wrong on server!");
				 resp.sendRedirect("doctor/patient.jsp");
				 
			 }
			 
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}

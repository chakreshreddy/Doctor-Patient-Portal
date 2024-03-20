<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.src.Dao.DoctorDaoImple"%>
<%@page import="com.src.Dao.DoctorDao"%>
<%@page import="com.src.model.Doctor"%>

<!-- for jstl tag -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- end of jstl tag -->

<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<title>Index Page | Doctor</title>
<!-- Include the CSS file -->
<%@include file="../component/allcss.jsp" %>

<!-- customs css for this page -->
<style type="text/css">
.my-card {
	box-shadow: 0px 0px 10px 1px maroon;
	/*box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.3);*/
}
</style>
<!-- end of customs css for this page -->
</head>
<body>
<%@include file="navbar.jsp"%>

	<!-- check if the doctor is logged in or not; if not, redirect to doctor_login.jsp -->
	<c:if test="${empty doctorObj }">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>

	<div class="container p-5">
		<p class="text-center text-success fs-3">Doctor Dashboard</p>
		<%
		DoctorDao docDAO = new DoctorDaoImple();
		int totalNumberOfDoctor = docDAO.countTotalDoctor();
		Doctor currentLoginDoctor = (Doctor)session.getAttribute("doctorObj");
		%>
		<div class="row">
			<div class="col-md-4 offset-md-2">
				<div class="card my-card">
					<div class="card-body text-center text-success">
						<i class="fa-solid fa-user-doctor fa-3x"></i><br>
						<p class="fs-4 text-center">
							Doctor <br><%= totalNumberOfDoctor %>
						</p>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card my-card">
					<div class="card-body text-center text-success">
						<i class="fa-solid fa-calendar-check fa-3x"></i><br>
						<p class="fs-4 text-center">
							Total Appointment <br> <%= docDAO.countTotalAppointmentByDoctorId(currentLoginDoctor.getId()) %>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

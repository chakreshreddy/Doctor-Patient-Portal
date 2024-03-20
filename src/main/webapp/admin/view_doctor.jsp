<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.src.model.Doctor"%>
<%@page import="com.src.Dao.DoctorDaoImple"%>
<%@page import="com.src.Dao.DoctorDao"%>
<%@page import="java.util.List"%>

<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Doctor page</title>
    <%@include file="../component/allcss.jsp"%>

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

<div class="container-fluid p-3">
    <div class="row">
        <div class="col-md-12">
            <div class="card my-card">
                <div class="card-body">
                    <p class="fs-3 text-center text-danger">List of Doctors</p>

                    <!-- message print -->
                    <!-- for success msg -->
                    <%
                    String successMsg = (String) session.getAttribute("successMsg");
                    if (successMsg != null && !successMsg.isEmpty()) {
                    %>
                    <p class="text-center text-success fs-3"><%= successMsg %></p>
                    <%
                        session.removeAttribute("successMsg");
                    }
                    %>

                    <!-- for error msg -->
                    <%
                    String errorMsg = (String) session.getAttribute("errorMsg");
                    if (errorMsg != null && !errorMsg.isEmpty()) {
                    %>
                    <p class="text-center text-danger fs-3"><%= errorMsg %></p>
                    <%
                        session.removeAttribute("errorMsg");
                    }
                    %>
                    <!-- End of message print -->

                    <!-- table for doctor list -->
                    <table class="table table-striped">
                        <thead>
                        <tr class="table-info">
                            <!-- <th scope="col">ID</th> -->
                            <th scope="col">Full Name</th>
                            <th scope="col">DOB</th>
                            <th scope="col">Qualification</th>
                            <th scope="col">Specialist</th>
                            <th scope="col">Email</th>
                            <th scope="col">Phone</th>
                            <th colspan="2" class="text-center" scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody>

                        <%
                        DoctorDao docDAO2 = new DoctorDaoImple();
                        List<Doctor> listOfDoc = docDAO2.getAllDoctor();
                        for (Doctor doctorLst : listOfDoc) {
                        %>
                        <tr>
                            <%-- <th scope="row"><%= doctorLst.getId()%></th> --%>
                            <th><%= doctorLst.getFullName()%></th>
                            <td><%= doctorLst.getDateOfBirth()%></td>
                            <td><%= doctorLst.getQualification()%></td>
                            <td><%= doctorLst.getSpecialist()%></td>
                            <td><%= doctorLst.getEmail()%></td>
                            <td><%= doctorLst.getPhone()%></td>

                            <td><a class="btn btn-sm btn-primary"
                                   href="edit_doctor.jsp?id=<%= doctorLst.getId()%>">Edit</a></td>
                            <td><a class="btn btn-sm btn-danger"
                                   href="../deleteDoctor?id=<%= doctorLst.getId()%>">Delete</a></td>
                        </tr>
                        <%
                        }
                        %>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

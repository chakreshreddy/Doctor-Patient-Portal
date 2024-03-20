<%@page import="com.src.Dao.SpecialistDao"%>
<%@page import="com.src.model.Specialist"%>
<%@page import="com.src.Dao.SpecialistDaoImple"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../component/allcss.jsp"%>

<style type="text/css">
.my-card {
    box-shadow: 0px 0px 10px 1px maroon;
    /*box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.3);*/
}
</style>

<%
    String successMsg = (String) session.getAttribute("successMsg");
    String errorMsg = (String) session.getAttribute("errorMsg");
    session.removeAttribute("successMsg");
    session.removeAttribute("errorMsg");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Doctor page</title>
</head>
<body>
    <%@include file="navbar.jsp"%>

    <div class="container-fluid p-3">
        <div class="row">
            <div class="col-md-5 offset-4">
                <div class="card my-card">
                    <div class="card-body">
                        <p class="fs-3 text-center text-danger">Add Doctor</p>

                        <!-- message print -->
                        <!-- for success msg -->
                        <%
                            if (successMsg != null && !successMsg.isEmpty()) {
                        %>
                            <p class="text-center text-success fs-3"><%= successMsg %></p>
                        <%
                            }
                        %>

                        <!-- for error msg -->
                        <%
                            if (errorMsg != null && !errorMsg.isEmpty()) {
                        %>
                            <p class="text-center text-danger fs-3"><%= errorMsg %></p>
                        <%
                            }
                        %>
                        <!-- End of message print -->

                        <!-- boostrap form -->
                        <form action="../addDoctor" method="post">
                            <div class="mb-3">
                                <label class="form-label">Full Name</label> <input
                                    name="fullName" id="test" type="text" placeholder="Enter full name"
                                    class="form-control">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Date of Birth</label> 
                                <input name="dateOfBirth" type="date" placeholder="Enter DOB" class="form-control">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Qualification</label> <input
                                    name="qualification" type="text"
                                    placeholder="Enter qualification" class="form-control">
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Specialist</label> <select
                                    class="form-control" name="specialist">
                                    <option selected="selected" disabled="disabled">---Select---</option>
                            <%
                            SpecialistDao spDAO = new SpecialistDaoImple();
                            List<Specialist> spList = spDAO.getAllSpecialist();
                            for (Specialist sp : spList) {
                            %>
                                <option>
                                    <%= sp.getSpecialistName() %>
                                </option>
                            <%
                            }
                            %>
                            </select>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Email address</label> <input
                                name="email" type="email" placeholder="Enter Email"
                                class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Phone</label> <input name="phone"
                                type="text" placeholder="Enter mobile number"
                                class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Password</label> <input name="password"
                                type="password" placeholder="Enter password" class="form-control">
                        </div>

                        <button type="submit" class="btn btn-danger text-white col-md-12">Register</button>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

<%@page import="com.src.model.Appointment"%>
<%@page import="com.src.Dao.AppointmentDaoImple"%>
<%@page import="com.src.model.Doctor"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patient Page</title>

    <!-- Include CSS and other dependencies here -->

    <%@include file="../component/allcss.jsp"%>

    <!-- Custom CSS for this page -->
    <style type="text/css">
        .my-card {
            box-shadow: 0px 0px 10px 1px maroon;
        }
    </style>
</head>
<body>
    <%@include file="navbar.jsp"%>

    <!-- Check if "doctorObj" is empty (not logged in) -->
    <c:if test="${empty doctorObj}">
        <c:redirect url="../doctor_login.jsp"></c:redirect>
    </c:if>

    <div class="container p-3">
        <div class="row">
            <div class="col-md-12">
                <div class="card my-card">
                    <div class="card-body">
                        <p class="text-center text-success fs-3">Patient Details</p>

                        <!-- Display success message if present -->
                        <c:if test="${not empty successMsg}">
                            <p class="text-center text-success fs-5">${successMsg}</p>
                            <c:remove var="successMsg" scope="session" />
                        </c:if>

                        <!-- Display error message if present -->
                        <c:if test="${not empty errorMsg}">
                            <p class="text-center text-danger fs-5">${errorMsg}</p>
                            <c:remove var="errorMsg" scope="session" />
                        </c:if>

                        <!-- Table for patient list -->
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col" style="padding-right: 100px">Full Name</th>
                                    <th scope="col">Gender</th>
                                    <th scope="col">Age</th>
                                    <th scope="col">Appointment Date</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Phone</th>
                                    <th scope="col">Diseases</th>
                                    <th scope="col">Status</th>
                                    <th scope="col">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <!-- Access the "doctorObj" attribute directly using JSTL/EL -->
                                <c:set var="doctor" value="${sessionScope.doctorObj}" />

                                <!-- Access the "list" variable directly using JSTL/EL -->
                                <c:out value="test is name ${appDAO.getAllAppointmentByLoginDoctor(doctor.id)} test"/>
                                <c:forEach var="applist" items="${appDAO.getAllAppointmentByLoginDoctor(doctor.id)}">
                                <c:out value="${applist.fullName} is name"/>
                                    <tr>
                                        <th>${applist.fullName}</th>
                                        <td>${applist.gender}</td>
                                        <td>${applist.age}</td>
                                        <td>${applist.appointmentDate}</td>
                                        <td>${applist.email}</td>
                                        <td>${applist.phone}</td>
                                        <td>${applist.diseases}</td>
                                        <td>${applist.status}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${'Pending' eq applist.status}">
                                                    <a href="comment.jsp?id=${applist.id}" class="btn btn-success btn-sm">Comment / Prescription</a>
                                                </c:when>
                                                <c:otherwise>
                                                    <a href="#!" class="btn btn-success btn-sm disabled"><i class="fa fa-comment"></i> Comment / Prescription</a>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                      
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

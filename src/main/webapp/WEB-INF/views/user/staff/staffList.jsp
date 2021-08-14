<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div
        class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
    <h2>Staff Manager</h2>
    <div class="btn-toolbar mb-2 mb-md-0">
        <div class="btn-group me-2">
            <button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
            <button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
        </div>

    </div>
</div>
<h4 id="message_title">${mega}</h4>
<div class="table-responsive">
    <%@include file="_createStaff.jsp" %>
    <table class="table table-striped ta    ble-sm">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Gender</th>
            <th scope="col">Birthday</th>
            <th scope="col">Email</th>
            <th scope="col">Phone</th>
            <th scope="col">Salary</th>
            <th scope="col">Note</th>
            <th scope="col">Depart</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="staff" items="${staffs}">
            <tr>
                <th scope="col">${staff.staffid}</th>
                <td>${staff.staffname}</td>
                <td>${staff.gender== true?'Male':'Female'}</td>
                <td><fmt:formatDate value="${staff.birthday}"/></td>
                <td>${staff.email}</td>
                <td>${staff.phone}</td>
                <td><fmt:formatNumber
                        value="${staff.salary}" type="currency"/></td>
                <td>${staff.notes}</td>
                <td>${staff.departsByDepartid.departname}</td>

                <td>
                    <button type="button" class="btn btn btn-danger" onclick="getProfileEditStaffUById('${staff.staffid}')">Update</button>
                    <a href="/staff/delete/${staff.staffid}" class="btn btn-success">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%@include file="_updateStaff.jsp"%>
</div>

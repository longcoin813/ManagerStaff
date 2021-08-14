<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div
        class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
    <h2>Records Manager</h2>
    <div class="btn-toolbar mb-2 mb-md-0">
        <div class="btn-group me-2">
            <button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
            <button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
        </div>

    </div>
</div>
<h4 id="message_title">${mega}</h4>
<div class="table-responsive">
    <%@include file="_createRecord.jsp" %>
    <table class="table table-striped table-sm">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Type </th>
            <th scope="col">Reason</th>
            <th scope="col">Date</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="records" items="${records}">
            <tr>
                <td>${records.recordid}</td>
                <td>${records.staffsByStaffid.staffname}</td>
                <td>${records.type== true?'Thành tích':'Kỹ luật'}</td>
                <td>${records.reason}</td>
                <td>${records.date}</td>
                <td>
                    <a href="/records/delete/${records.recordid}" class="btn btn-success">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
<%--    <%@include file="_updateRecord.jsp" %>--%>

</div>
<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h1 class="h2">User</h1>
	<div class="btn-toolbar mb-2 mb-md-0">
		<div class="btn-group me-2">
			<button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
			<button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
		</div>

	</div>
</div>
<h2>User Manager</h2>
<div class="table-responsive">
	<%@include file="_createUser.jsp"%>
	<table class="table table-striped table-sm">
		<thead>
			<tr>
				<th scope="col">STT</th>
				<th scope="col">Full Name</th>
				<th scope="col">User Name</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}" varStatus="status">
				<tr>
					<th scope="col">${status.index + 1}</th>
					<td>${user.fullName}</td>
					<td>${user.username}</td>
					<td>
						<%@include file="_updateUser.jsp"%>
						<button type="button" class="btn btn btn-success" onclick="getProfileEditUserByUserName('${user.username}')">Update</button>
						<a href="/user/delete/${user.username}" class="btn btn-success">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
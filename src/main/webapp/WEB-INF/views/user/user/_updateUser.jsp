

<!-- Modal -->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Create User</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form:form action="/user/update" modelAttribute="editUser" method="post">
					<div class="form-group row">
						<label for="editFullName" class="col-sm-2 col-form-label">Fullname
						</label>
						<div class="col-sm-10">
							<form:input id="editFullName" path="fullName" class="form-control" />
						</div>
					</div>
					<div class="form-group row">
						<label for="editUsername" class="col-sm-2 col-form-label">Username
						</label>
						<div class="col-sm-10">
							<form:input path="username" id="editUsername" class="form-control" readonly="true" />
						</div>
					</div>
					<div class="form-group row">
						<label for="editPassword" class="col-sm-2 col-form-label">Password
						</label>
						<div class="col-sm-10">
							<form:input type="password" id="editPassword" path="password" class="form-control" />
						</div>
					</div>
					<hr>

					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button class="btn btn-success" formaction="/user/update">Update
						</button>
					</div>
				</form:form>

			</div>

		</div>
	</div>
</div>
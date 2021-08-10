

<!-- Modal -->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Update Depart</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form:form action="/departs/update" modelAttribute="editID" method="post">
					<div class="form-group row">
						<label for="editID" class="col-sm-2 col-form-label">Fullname
						</label>
						<div class="col-sm-10">
							<form:input id="editID" path="departid" class="form-control" />
						</div>
					</div>
					<div class="form-group row">
						<label for="editName" class="col-sm-2 col-form-label">Username
						</label>
						<div class="col-sm-10">
							<form:input path="departname" id="editName" class="form-control" readonly="true" />
						</div>
					</div>

					<hr>

					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button class="btn btn-success" formaction="/departs/update">Update
						</button>
					</div>
				</form:form>

			</div>

		</div>
	</div>
</div>
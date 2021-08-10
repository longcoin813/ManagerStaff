<button type="button" class="btn btn-primary" data-toggle="modal"
        data-target="#exampleModal">INSERT
</button>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
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
                <form:form action="/user/staff" modelAttribute="form">
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">
                            ID
                        </label>
                        <div class="col-sm-10">
                            <form:input path="staffid" class="form-control" value="NV"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">
                            Name
                        </label>
                        <div class="col-sm-10">
                            <form:input path="staffname" class="form-control"/>

                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">
                            Gender
                        </label>
                        <div class="col-sm-10">
                            <div class="form-check-inline">
                                <label class="form-check-label" for="radio2">
                                    <form:radiobutton path="gender" class="form-check-input" id="radio1" value="true"/>
                                    Nam
                                </label>
                            </div>
                            <div class="form-check-inline">
                                <label class="form-check-label" for="radio2">
                                    <form:radiobutton path="gender" class="form-check-input" id="radio2" value="false"/>
                                        Nữ
                            </div>

                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">
                            Birthday
                        </label>
                        <div class="col-sm-10">
                            <form:input path="birthday" class="form-control" placeholder="YYYY/MM/DD"/>

                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">
                            Email
                        </label>
                        <div class="col-sm-10">
                            <form:input path="email" class="form-control"/>

                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">
                            Phone
                        </label>
                        <div class="col-sm-10">
                            <form:input path="phone" class="form-control"/>

                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">
                            Salary
                        </label>
                        <div class="col-sm-10">
                            <form:input path="salary" class="form-control"/>

                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">
                            Note
                        </label>
                        <div class="col-sm-10">
                            <form:input path="notes" class="form-control"/>

                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">
                            Depart
                        </label>
                        <div class="col-sm-10">
                            <form:input path="departsByDepartid" class="form-control"/>

                        </div>
                    </div>
                    <hr>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary"
                                data-dismiss="modal">Close
                        </button>
                        <button class="btn btn-success" formaction="/staff/create">Save
                            changes
                        </button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
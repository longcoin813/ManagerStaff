<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<button type="button" class="btn btn-primary" data-toggle="modal"
        data-target="#exampleModal">INSERT
</button>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Create Record</h5>
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form:form action="/user/records" modelAttribute="form">
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">
                            Staff Name
                        </label>
                        <div class="col-sm-10">
                            <form:select path="staffsByStaffid" class="form-control">
                                <form:options items="${records}"
                                              itemValue="recordid"
                                              itemLabel="staffsByStaffid.staffname" />
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">
                            Type
                        </label>
                        <div class="col-sm-10">
                            <form:input path="type" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">
                            Reason
                        </label>
                        <div class="col-sm-10">
                            <form:input path="reason" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">
                            Date
                        </label>
                        <div class="col-sm-10">
                            <form:input path="date" class="form-control"/>
                        </div>
                    </div>

                    <hr>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary"
                                data-dismiss="modal">Close
                        </button>
                        <button class="btn btn-success" formaction="/records/create">Save
                            changes
                        </button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
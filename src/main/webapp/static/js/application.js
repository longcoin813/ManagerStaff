// user
function getProfileEditUserByUserName(username) {
    $.get(`/user/edit/${username}`, (response) => {
        if (response) {
            setResponseToModalEdit(response)
        }
    })
}

function setResponseToModalEdit(data) {
    const {username, fullName, password} = data;

    $('#editFullName').val(fullName);
    $('#editUsername').val(username);
    $('#editPassword').val(password);

    $('#updateModal').modal('show');
}

// staff
function getProfileEditStaffUById(staffid) {
    $.get(`/user//staff/edit/${staffid}`, (staff) => {
        if (staff) {
            setResponseModalStaffEdit(staff)
        }
    })
}

function setResponseModalStaffEdit(payload) {

    $('#editstaffid').val(payload['staffid']);
    $('#editstaffname').val(payload['staffname']);
    if (payload['gender']) {
        $('#genderMale').prop('checked', 'checked')
    } else {
        $('#genderFemale').prop('checked', 'checked')
    }

    document.getElementById('editbirthday').valueAsDate = new Date(payload['birthday']);

    $('#editemail').val(payload['email']);
    $('#editphone').val(payload['phone']);
    $('#editsalary').val(payload['salary']);
    $('#editnotes').val(payload['notes']);
    $('#editdepartid').val(payload['departid']);

    $('#updateModalStaff').modal('show');

}

// Depart
function getdepartid(departid) {
    $.get(`/user/departs/edit/${departid}`, (depart) => {
        if (depart) {
            setResponseModalDepartEdit(depart)
        }
    })
}

function setResponseModalDepartEdit(data1) {
    const {departid, departname} = data1;

    $('#editID').val(departid);
    $('#editName').val(departname);

    $('#updateModalDepart').modal('show');

}

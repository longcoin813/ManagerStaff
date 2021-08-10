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
    $.get(`/staff/edit/${staffid}`, (response) => {
        if (response) {
            setResponseModalStaffEdit(response)
        }
    })
}

function setResponseModalStaffEdit(data1) {
    const {staffid, staffname} = data1;

    $('#editstaffid').val(staffid);
    $('#editstaffname').val(staffname);

// Depart
    function getdepartid(departid) {
        $.get(`/depart/edit/${departid}`, (response) => {
            if (response) {
                setResponseModalStaffEdit(response)
            }
        })
    }

    function setResponseModalDepartEdit(data) {
        const {departid, departname} = data;

        $('#editID').val(departid);
        $('#editName').val(departname);
    }
}
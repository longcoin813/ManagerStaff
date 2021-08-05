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
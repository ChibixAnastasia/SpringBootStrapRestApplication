$(document).ready(function () {
    createTable()
    editUser()

})

async function createTable() {

    let response = await fetch("/api")
    let users = await response.json()
    console.log(users)

    for (let i = 0; i < users.length; i++) {

        let listRoles = '';
        for (let element of users[i].roles) {
            listRoles += " " + element.role.replaceAll("ROLE_", "");
        }
        let userid = users[i].id;
        let firstName = users[i].firstName;
        let lastName = users[i].lastName;
        let email = users[i].email;
        //let password = users[i].password;
        let userRoles = listRoles;

        let tr = $("<tr align=\"center\">").attr("id", i);
        tr.append("" +
            "<td>" + userid + "</td>" +
            "<td>" + firstName + "</td>" +
            "<td>" + lastName + "</td>" +
            "<td>" + email + "</td>" +
            //"<td>" + password + "</td>" +
            "<td>" + userRoles + "</td>" +

            "<td><button onclick='getUser("+ users[i].id + ")' class='btn btn-md btn-info eBtn' data-toggle='modal'  data-target='#editModal'>Edit</button></td>"
        );
        $("#allUser").append(tr)
    }
}

async function getUser(id) {
    let user = await fetch('/api/' + id).then(response => response.json());

    $(".editForm #id1").val(user.id);
    $(".editForm #firstName1").val(user.firstName);
    $(".editForm #lastname1").val(user.lastName);
    $(".editForm #email1").val(user.email);
   $(".editForm #password1").val(user.password);

}

function editUser() {
    $("#editForm").submit(function (event) {
        event.preventDefault()

        let role = [];
        let arr = Array.from(document.getElementById("role1").options).filter(option => option.selected).map(option => option.value)
        for(let i = 0; i < arr.length; i++) {
            role.push({id:arr[i]})
        }

        let user = {
            id: $("#id1").val(),
            firstName: $("#firstName1").val(),
            lastName: $("#lastname1").val(),
            email: $("#email1").val(),
            password: $("#password1").val(),
            role: role
        }

        console.log(user)

        fetch('/api/',
            {
                method: 'PUT',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify(user)
            });
        window.location.href = "/admin"
    })
}
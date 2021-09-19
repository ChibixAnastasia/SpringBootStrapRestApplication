
$(document).ready(function () {
    createTable();
    editUser();
    addUser();

})




async function createTable() {

    let response = await fetch("/api");
    let users = await response.json()
    console.log(users);

    for (let i = 0; i < users.length; i++) {

        let listRoles = '';
        for (let element of users[i].roles) {
            listRoles += " " + element.name.replaceAll("ROLE_", "");
        }
        let userid = users[i].id;
        let firstName = users[i].firstName;
        let lastName = users[i].lastName;
        let age = users[i].age;
        let email = users[i].email;
        let userRoles = listRoles;

        let tr = $("<tr align=\"center\">").attr("id", i);
        tr.append("" +
            "<td>" + userid + "</td>" +
            "<td>" + firstName + "</td>" +
            "<td>" + lastName + "</td>" +
            "<td>" + age + "</td>" +
            "<td>" + email + "</td>" +
            "<td>" + userRoles + "</td>" +

            "<td><button onclick='getUser("+ users[i].id + ")' class='btn btn-md btn-info eBtn' data-toggle='modal' data-target='#editModal'>Edit</button></td>" +
            "<td><button onclick='UserForDelete("+ users[i].id + ")' class='btn btn-md btn-danger eBtn' data-toggle='modal' data-target='#deleteModal'>Delete</button></td>"
        );
        $("#usersTable").append(tr)
    }
}

function addUser() {
    $("#addNewUser").submit(async function(event) {
        event.preventDefault()

        let arr = Array.from(document.getElementById("role0").options).filter(option => option.selected).map(option => option.value)

        let rolesForUser = [];

        for(let i = 0; i < arr.length; i++) {
            let response = await fetch('/api/roles/' + arr[i])
            let roles = await response.json()
            rolesForUser.push(roles)
        }

        let user = {
            firstName: $("#firstName0").val(),
            lastName: $("#lastname0").val(),
            age: $("#age0").val(),
            email: $("#email0").val(),
            password: $("#password0").val(),
            roles: rolesForUser
        }

        await fetch('/api/',
            {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify(user)
            }).then(result => console.log(result))
        window.location.href = "/admin"

    })
}

async function getUser(id) {
    let user = await fetch('/api/' + id).then(response => response.json());

    $(".editForm #id1").val(user.id);
    $(".editForm #firstName1").val(user.firstName);
    $(".editForm #lastname1").val(user.lastName);
    $(".editForm #age1").val(user.age);
    $(".editForm #email1").val(user.email);
   $(".editForm #password1").val(user.password);

}

function editUser() {
    $("#editForm").submit(async function (event) {
        event.preventDefault()


        let arr1 = Array.from(document.getElementById("role1").options).filter(option => option.selected).map(option => option.value)

        let rolesForUser = [];

        for (let i = 0; i < arr1.length; i++) {
            let response = await fetch('/api/roles/' + arr1[i])
            let roles = await response.json()
            rolesForUser.push(roles)
        }

        let user = {
            id: $("#id1").val(),
            firstName: $("#firstName1").val(),
            lastName: $("#lastname1").val(),
            age: $("#age1").val(),
            email: $("#email1").val(),
            password: $("#password1").val(),
            roles: rolesForUser
        }

        console.log(user)

        await fetch('/api/',
            {
                method: 'PUT',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify(user)
            });
        window.location.href = "/admin"
    })
}

async function UserForDelete(id) {
    let user = await fetch('/api/' + id).then(response => response.json());

    $("#deleteForm #id2").val(user.id);
    $("#deleteForm #firstName2").val(user.firstName);
    $("#deleteForm #lastname2").val(user.lastName);
    $("#deleteForm #age2").val(user.age);
    $("#deleteForm #email2").val(user.email);
    $("#deleteForm #password2").val(user.password);

    $("#deleteForm").submit(async function(event) {
        event.preventDefault()

        await fetch('/api/' + id,
            {method: 'DELETE'});
        window.location.href = "/admin"
    })
}

//Эта фанкция, котороя создает массив ролей для юзера, принимающая два массива(масив ролей из базы, и массив значений из тега select)
/*function generatedRoles(selectedValue, rolesInDataBase) {
    let value = [];
    for(let i = 0; i < selectedValue.length; i++) {
        value.push(parseInt(selectedValue[i]));
    }

    let roleArray = [];
    for(let i = 0; i < value.length; i++) {
        if (value[i] === 1) {
            roleArray.push(rolesInDataBase[0])
        } else if (value[i] === 2) {
            roleArray.push(rolesInDataBase[1])
        }
    }
    return roleArray;
}*/


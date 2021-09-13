createTable()

async function createTable() {
    let response = await fetch('/api/current')
    let user = await response.json()
    console.log(user)

    let listRoles = '';
    for(let element of user.authorities) {
        listRoles +=" " + element.name.replaceAll("ROLE_", "");
    }
    console.log(listRoles);

    let userid = user.id;
    let firstName = user.firstName;
    let lastName = user.lastName;
    let age = user.age;
    let email = user.email;

    let tr = $("<tr align=\"center\">");
    tr.append("" +
        "<td>" + userid + "</td>" +
        "<td>" + firstName + "</td>" +
        "<td>" + lastName + "</td>" +
        "<td>" + age + "</td>" +
        "<td>" + email + "</td>" +
        "<td>" + listRoles + "</td>");
    $("#userInfo").append(tr);
}
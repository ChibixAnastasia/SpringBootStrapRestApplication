createTable()

async function createTable() {
    let response = await fetch('/api/current')
    let user = await response.json()
    console.log(user)

    let listRoles = '';
}
interface User {
    name: string,
    id: number
}

interface User {
    address: string
}

interface Admin extends User {
    role: 'admin' | 'ta'
}

let ajeet: User = {
    name: 'ajeet',
    id: 123,
    address: 'Amsterdam' // if we comment line 6, it's an error
}

console.log('Full data ' + JSON.stringify(ajeet));

let kumar: Admin = {
    name: 'ajeet',
    id: 123,
    address: 'Amsterdam', // if we comment line 6, it's an error
    role: 'ta'
}

console.log('Full data ' + JSON.stringify(kumar));


export {}
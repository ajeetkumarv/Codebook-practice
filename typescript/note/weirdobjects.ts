function createUser({name: string, isPaid: boolean}) {} // accept an object that must have name and isPaid

function createUser2(): {} { // return type is {} means object
    return {} 
}

type User = {
    readonly _id: string,
    name: String,
    isPaid: boolean
}

type cardDate = {
    cardDate: string
}

type cardNumber = {
    cardNumber: string
}

type cardDetail = cardDate & cardNumber & {
    cvv: number
}

let cardDetailObj = {
    cardDate: "123",
    cardNumber: "132",
    cvv: 585
}

console.log(cardDetailObj.cardNumber);



"use strict";
function createUser({ name: string, isPaid: boolean }) { } // accept an object that must have name and isPaid
function createUser2() {
    return {};
}
let cardDetailObj = {
    cardDate: "123",
    cardNumber: "132",
    cvv: 585
};
console.log(cardDetailObj.cardNumber);

"use strict";
function addTwo(num) {
    return num + 2;
    //return "hello"; // this is an error bcz we said : number in function definition
}
// same function with arrow
const addTwoArrow = (n) => n + 2;
console.log(addTwoArrow(5));
function handleError(errmsg) {
    throw new Error(errmsg);
}

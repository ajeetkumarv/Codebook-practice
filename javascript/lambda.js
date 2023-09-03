const person = (firstName, age) => ({firstName, age}); 

//above is shorcut for below
// const person = (firstName, age) => {
//     return {
//         firstName: firstNameame,
//         age: age
//     }
// }

let me = person('Ajeet', 30);

console.log(me.firstName);
console.log(me.age);

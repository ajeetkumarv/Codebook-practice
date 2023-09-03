let dog = {
    name: 'camper'
};

console.log('Dog: ' + JSON.stringify(dog));
dog.bark='bow bow';
console.log('Dog: ' + JSON.stringify(dog));
delete dog.bark
console.log('Dog: ' + JSON.stringify(dog));
console.log(dog.hasOwnProperty('tail'));

let aCopy = JSON.parse(JSON.stringify(dog)); // creatinga copy of dog
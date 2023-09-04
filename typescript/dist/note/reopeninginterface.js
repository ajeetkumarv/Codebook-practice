"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
let ajeet = {
    name: 'ajeet',
    id: 123,
    address: 'Amsterdam' // if we comment line 6, it's an error
};
console.log('Full data ' + JSON.stringify(ajeet));
let kumar = {
    name: 'ajeet',
    id: 123,
    address: 'Amsterdam',
    role: 'ta'
};
console.log('Full data ' + JSON.stringify(kumar));

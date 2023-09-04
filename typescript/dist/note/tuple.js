"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
let tuser;
tuser = ['av', 1223, true];
tuser[1] = 5000;
console.log('Tuple ' + tuser);
//so even though we made tuser a tuple to restrict it's behaviour according to it's type
// we can still
tuser.push(false);
console.log('Tuple ' + tuser);

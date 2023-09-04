let msg;
msg = 'abc';

let endsWithC = msg.endsWith('c'); // works but you don't get intellisense
let endsWithC2 = (<string>msg).endsWith('c');
let endsWithC3 = (msg as string).endsWith('c');


console.log('Ends with C? ' + endsWithC);
console.log('Ends with C? ' + endsWithC2);

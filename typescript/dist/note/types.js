"use strict";
let a;
let b;
let c;
let d;
let e = [1, 2, 3];
let f = [1, true, 'a'];
// we have Null, Undefined, Void, Any, Tuples
let aAnyType;
const ColorRed = 0;
const ColorBlue = 1;
var Color;
(function (Color) {
    Color[Color["Red"] = 0] = "Red";
    Color[Color["blue"] = 1] = "blue";
})(Color || (Color = {}));
; // internally {Red = 0, blue = 1}
console.log('Color is: ' + Color.Red); // output: Color i: 0

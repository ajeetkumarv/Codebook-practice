"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const point_1 = require("./point");
let emptyPoint = new point_1.Point(); // works bcz we have x? and y?
let point = new point_1.Point(5, 6);
point.draw();
point.X = 10; // setter is called here
console.log('Point: ' + JSON.stringify(point));
